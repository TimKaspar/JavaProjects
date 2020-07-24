package ch.ti8m.azubi.jdbc.dao;

import ch.ti8m.azubi.jdbc.model.Person;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
public class PersonDAO implements DAO<Person> {
=======
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PersonDAO {
>>>>>>> cff5ea189c5f419376637abcfd81afb0bf3b4ba0

    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

<<<<<<< HEAD
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
=======
    /**
     * Return a list of all people.
     */
    public List<Person> list() throws Exception {
        try (Statement statement = connection.createStatement()) {
            List<Person> people = new LinkedList<>();

            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                Date birthDate = resultSet.getDate("birthDate");

                Person person = new Person();

                person.setId(id);
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setBirthDate(birthDate);

                people.add(person);
                System.out.println(person.toString());

            }
            System.out.println("created list with all people from ch.ti8m.azubi.jdbc.model.Person");
            return people;
        }
    }

    /**
     * Get the person with the given id. If no such person is found, null is returned.
     */
    public Person get(int id) throws Exception {

        try (Statement statement = connection.createStatement()) {

            Person person = new Person();

            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()) {

                int personId = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                Date birthDate = resultSet.getDate("birthDate");


                if (personId == id) {
                    person.setFirstName(firstName);
                    person.setLastName(lastName);
                    person.setBirthDate(birthDate);
                }
            }

            if (person.getLastName() == null) {
                System.out.println("Could not find ch.ti8m.azubi.jdbc.model.Person with id:"+id);
                return null;
            } else {
                System.out.println("Found person with id:"+id);
                return person;
            }

        }
    }

    /**
     * Create a new person, and sets the generated id in the person.
     */
    public int create(Person person) throws Exception {
        try (Statement statement = connection.createStatement()) {

            String sql = String.format("insert into person (firstname, lastname, birthdate) values ('%s', '%s', '%s')", person.getFirstName(), person.getLastName(), person.getBirthDate());
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            int generatedId = generatedKeys.getInt(1);
            System.out.println("Created new person with id=" + generatedId);
            return generatedId;
>>>>>>> cff5ea189c5f419376637abcfd81afb0bf3b4ba0
        }

    }

<<<<<<< HEAD
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
=======
    /**
     * Update a person
     */
    public void update(Person person) throws Exception {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()) {

                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                Date birthDate = resultSet.getDate("birthDate");

                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setBirthDate(birthDate);

            }
            System.out.println("updated"+person+"successfully");
        }

    }

    /**
     * Delete a person by id.
     * @return
     */
    public boolean delete(int id) throws Exception {
        try (Statement statement = connection.createStatement()) {

            String sql = String.format("delete from person where id=" + id);
            if (statement.executeUpdate(sql) == 1){
                System.out.println("deleted person with id:"+id);
                return true;
            } else {
                System.out.println("Error whilst deleting");
                System.out.println(statement.executeUpdate(sql));
                return false;
            }


        }

>>>>>>> cff5ea189c5f419376637abcfd81afb0bf3b4ba0
    }
}
