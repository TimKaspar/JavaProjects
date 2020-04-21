import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception{
        try (Connection connection = ConnectionConfiguration.createDBConnection()) {

            Person person = new Person("Tim","Kaspar",Date.valueOf("2020-04-20"));
            PersonDAO personDAO = new PersonDAO(connection);
            personDAO.create(person);
            personDAO.list();
            personDAO.delete(14);
            personDAO.list();


        }
    }
}

