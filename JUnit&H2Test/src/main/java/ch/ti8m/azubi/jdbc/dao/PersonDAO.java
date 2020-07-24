package ch.ti8m.azubi.jdbc.dao;

import ch.ti8m.azubi.jdbc.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
public class PersonDAO implements DAO<Person> {

    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Person> list() throws Exception {
        //try (Statement statement = connection.createStatement()) {
//
        //    List<Person> list = new LinkedList<>();
//
        //    String sql = String.format("select id, firstname, lastname, birthdate "+
        //            "from person");
        //    ResultSet resultSet = statement.executeQuery(sql);
        //    while (resultSet.next()) {
        //        Person person = new Person();
        //        person.setId(resultSet.getInt("id"));
        //        person.setFirstName(resultSet.getString("firstname"));
        //        person.setLastName(resultSet.getString("lastname"));
        //        person.setBirthDate(resultSet.getDate("birthdate").toLocalDate());
        //        list.add(person);
        //    }
        //    return list;
        //}
        try (PreparedStatement statement = connection.prepareStatement("select * from person")) {

            ResultSet resultSet = statement.executeQuery();
            List<Person> list = new LinkedList<>();
            while (resultSet.next()) {

                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("firstname"));
                person.setLastName(resultSet.getString("lastname"));
                person.setBirthDate(resultSet.getDate("birthdate").toLocalDate());
                list.add(person);

            }
            return list;
        }

    }

    @Override
    public Person get(int id) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement("select id, firstname, lastname, birthdate "+
                "from person where id = ?")) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                // no person found
                return null;
            }
            // person found
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setFirstName(resultSet.getString("firstname"));
            person.setLastName(resultSet.getString("lastname"));
            person.setBirthDate(resultSet.getDate("birthdate").toLocalDate());
            return person;
        }
    }

    @Override
    public void create(Person person) throws Exception {
        if (person == null) {
            throw new IllegalArgumentException("person is required");
        }

        //try (Statement statement = connection.createStatement()) {
        //    String sql = String.format("insert into person (firstname, lastname, birthdate)"+
        //                    " values ('%s', '%s', '%s')",
        //            person.getFirstName(), person.getLastName(), person.getBirthDate());
        //    statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
        //    ResultSet generatedKeys = statement.getGeneratedKeys();
        //    generatedKeys.next();
        //    int id = generatedKeys.getInt(1);
        //    person.setId(id);
        //}
        try (PreparedStatement statement = connection.prepareStatement("insert into person (firstname, lastname, birthdate) values (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setObject(3, person.getBirthDate());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            int generatedId = generatedKeys.getInt(1);
            person.setId(generatedId);
            System.out.println("Created new person with id=" + generatedId);
        }

    }

    @Override
    public void update(Person person) throws Exception {
        if (person == null) {
            throw new IllegalArgumentException("person is required");
        }
        if (person.getId() == null) {
            throw new IllegalArgumentException("id is required");
        }

        //try (Statement statement = connection.createStatement()) {
        //    String sql = String.format("update person set firstname='%s', lastname='%s', "+
        //                    "birthdate='%s' where id = %d", person.getFirstName(), person.getLastName(),
        //            person.getBirthDate(), person.getId());
        //    int rowsUpdated = statement.executeUpdate(sql);
        //    if (rowsUpdated == 0) {
        //        throw new Exception("Updated failed, no entity with that id exists");
        //    }
        //}
        try (PreparedStatement statement = connection.prepareStatement("update person set firstname=?, lastname=?, birthdate=? where id =?")){
            statement.setString(1,person.getFirstName());
            statement.setString(2,person.getLastName());
            statement.setObject(3,person.getBirthDate());
            statement.setInt(4,person.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new Exception("Updated failed, no entity with that id exists");
            }
        }
    }

    @Override
    public boolean delete(int id) throws Exception {

        //try (Statement statement = connection.createStatement()) {
        //    String sql = String.format("delete from person where id = %d", id);
        //    int rowsDeleted = statement.executeUpdate(sql);
        //    return rowsDeleted > 0;
        //}
        try (PreparedStatement statement = connection.prepareStatement("delete from person where id=?")) {

            statement.setInt(1, id);
            int numberOfDeletedRecords = statement.executeUpdate();
            return numberOfDeletedRecords > 0;
        }


    }

    @Override
    public void save(Person person) throws Exception {
        if (person.getId() == null) {
            create(person);
        } else {
            update(person);
        }
    }

    @Override
    public List<Person> find(String searchText) throws Exception {
        if (searchText == null) {
            throw new IllegalArgumentException("search text is required");
        }
        // case-insensitive search, and we add a wildcard (%) to allow
        // searching for names that start with the search text.
        searchText = searchText.toLowerCase()+"%";

        try (PreparedStatement statement = connection.prepareStatement("select id, firstname, lastname, birthdate from person"
                + " where lower(firstname) like '" + searchText + "'"
                + "or lower(lastname) like '" + searchText + "'")) {

            List<Person> searchResult = new LinkedList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("firstname"));
                person.setLastName(resultSet.getString("lastname"));
                person.setBirthDate(resultSet.getDate("birthdate").toLocalDate());
                searchResult.add(person);
            }

            return searchResult;
        }
    }
}
