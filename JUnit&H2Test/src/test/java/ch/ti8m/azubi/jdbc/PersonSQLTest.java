package ch.ti8m.azubi.jdbc;

import ch.ti8m.azubi.jdbc.model.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

//creates Person table
public class PersonSQLTest {

    @Before
    public void setup() throws SQLException {
        try (Connection connection = ConnectionFactory.testConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("drop table if exists person");
                statement.execute("create table person (" +
                        " id int not null auto_increment," +
                        " firstname VARCHAR(64) not null," +
                        " lastname VARCHAR(64) not null," +
                        " birthdate date," +
                        " primary key (id))");
                statement.execute("insert into person (firstname, lastname, birthdate) values ('Bruce', 'Willis', '1955-03-19')");
                statement.execute("insert into person (firstname, lastname, birthdate) values ('Kate', 'Beckinsale', '1973-07-26')");
                statement.execute("insert into person (firstname, lastname, birthdate) values ('Emilia', 'Clarke', '1986-10-23')");
            }
        }
    }

    @After
    public void cleanup() throws SQLException {
        try (Connection connection = ConnectionFactory.testConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("drop table if exists person");
            }
        }
    }

    //List()

    @Test
    public void testListPersons() throws SQLException {
        try (Connection connection = ConnectionFactory.testConnection()) {

            List<Person> persons = new LinkedList<>();

            // select all
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("select * from person");
                while (resultSet.next()) {

                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    LocalDate birthDate = resultSet.getDate("birthDate").toLocalDate();

                    Person person = new Person(firstName, lastName, birthDate);
                    System.out.println(person);
                    persons.add(person);
                }
            }

            Assert.assertEquals(3, persons.size());
        }
    }

    @Test
    public void tableNotNull() throws SQLException {
        try (Connection connection = ConnectionFactory.testConnection()) {
            // select all
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("select * from person");
                while (resultSet.next()) {

                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    LocalDate birthDate = resultSet.getDate("birthDate").toLocalDate();

                    Person person = new Person(firstName, lastName, birthDate);
                    System.out.println(person);
                    Assert.assertNotNull(person);
                }
            }
        }
    }

    @Test
    public void listNotNull() throws SQLException {
        try (Connection connection = ConnectionFactory.testConnection()) {

            List<Person> persons = new LinkedList<>();

            // select all
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("select * from person");
                while (resultSet.next()) {

                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    LocalDate birthDate = resultSet.getDate("birthDate").toLocalDate();

                    Person person = new Person(firstName, lastName, birthDate);
                    System.out.println(person);
                    persons.add(person);
                }
            }

            Assert.assertNotNull(persons);
        }
    }

    //get()

    @Test
    public void personWithIdExists(int id) throws SQLException {
        try (Connection connection = ConnectionFactory.testConnection()) {

            List<Person> persons = new LinkedList<>();

            // select all
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("select * from person where id=" + id);
                Assert.assertNotNull(resultSet.next());
            }
        }
    }

    @Test
    public void idNotOutOfBounds(int id) throws SQLException {
        try (Connection connection = ConnectionFactory.testConnection()) {

            List<Person> persons = new LinkedList<>();
            boolean x = false;
            int biggestId = 0;

            // find biggest id/find number of values in table
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("select * from person");
                while (resultSet.next()) {

                    int personId = resultSet.getInt("id");

                    if (biggestId < personId) {
                        biggestId = personId;
                    }
                }
            }
            if (id > 0 && id < biggestId) {
                x = true;
            }
            Assert.assertTrue(x);
        }
    }
}

