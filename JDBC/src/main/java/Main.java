import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception{
        try (Connection connection = ConnectionConfiguration.createDBConnection()) {

            // select all
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("select * from person");
                while (resultSet.next()) {

                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    Date birthDate = resultSet.getDate("birthDate");

                    System.out.println("#" + id + ": " + firstName + " "
                            + lastName + ", born on " + birthDate);
                }
            }
        }
    }
}

