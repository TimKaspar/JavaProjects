import ch.ti8m.azubi.jdbc.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonDAOTest {


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
