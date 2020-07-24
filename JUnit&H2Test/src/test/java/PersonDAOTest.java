import ch.ti8m.azubi.jdbc.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonDAOTest {

    @Before
    public void setup() throws SQLException {
        try (Connection conn = ConnectionFactory.testConnection()) {
            try (Statement statement = conn.createStatement()) {
                statement.execute("drop table if exists person");
            }

            try (Statement statement = conn.createStatement()) {
                statement.execute("create table person (\n" +
                        " id int not null auto_increment,(\n" +
                        " firstname VARCHAR(64) not null, (\n" +
                        " lastname VARCHAR(64) not null, (\n" +
                        " birthdate date, (\n"+
                        " primary key (id))");
            }
        }
    }


    @Test
    public void hasContent() {
        try (Connection conn = ConnectionFactory.testConnection()) {
            Statement statement = conn.createStatement();

            List<Person> people = new LinkedList<>();

            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                Date birthDate = resultSet.getDate("birthDate");

                Person person = new Person();


            }
            Assert.assertTrue(!people.isEmpty());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
