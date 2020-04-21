package ch.ti8m.azubi.jdbc.dao;

import ch.ti8m.azubi.jdbc.model.Person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PersonDAO {

    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

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
        }

    }

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

    }
}
