package ch.ti8m.azubi.jdbc;

import ch.ti8m.azubi.jdbc.dao.PersonDAO;
import ch.ti8m.azubi.jdbc.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class PersonDAOTest {


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
            }
        }
    }

    @Test
    public void testCreate() throws Exception {
        PersonDAO personDAO = new PersonDAO(ConnectionFactory.testConnection());

        Person person = new Person("Tim", "Kaspar", LocalDate.of(2020, 4, 3));

        personDAO.create(person);

        Person loaded = personDAO.get(person.getId());

        Integer id = loaded.getId();

        Assert.assertNotNull(person.getId());
        Assert.assertEquals(id, person.getId());
    }

    @Test
    public void testGet() throws Exception {
        PersonDAO personDAO = new PersonDAO(ConnectionFactory.testConnection());

        Person person = new Person("Tim", "Kaspar", LocalDate.of(2020, 4, 3));

        personDAO.create(person);

        Person loaded = personDAO.get(person.getId());

        Assert.assertNotNull(loaded);
        Assert.assertEquals(person.getId(), loaded.getId());
        Assert.assertEquals(person.getFirstName(), loaded.getFirstName());
        Assert.assertEquals(person.getLastName(), loaded.getLastName());
        Assert.assertEquals(person.getBirthDate(), loaded.getBirthDate());

    }

    @Test
    public void testGetNotFound() throws Exception {
        PersonDAO personDAO = new PersonDAO(ConnectionFactory.testConnection());

        Person loaded = personDAO.get(999999999);

        Assert.assertNull(loaded);

    }

    @Test
    public void testUpdate() throws Exception {
        PersonDAO personDAO = new PersonDAO(ConnectionFactory.testConnection());

        Person person = new Person("Tim", "Kaspar", LocalDate.of(2020, 4, 3));
        personDAO.create(person);

        person.setFirstName("Franzis");
        person.setLastName("Kerald");

        personDAO.update(person);

        Person loaded = personDAO.get(person.getId());

        Assert.assertNotNull(person);
        //person ist auf Datenbank
        Assert.assertEquals(person, loaded);

        Assert.assertEquals(person.getFirstName(),loaded.getFirstName());
        Assert.assertEquals(person.getLastName(),loaded.getLastName());
        Assert.assertEquals(person.getBirthDate(),loaded.getBirthDate());
    }

    @Test
    public void testDelete() throws Exception {
        PersonDAO personDAO = new PersonDAO(ConnectionFactory.testConnection());

        Person person = new Person("Tim", "Kaspar", LocalDate.of(2020, 4, 3));


        personDAO.create(person);
        personDAO.delete(person.getId());

        Assert.assertNull(personDAO.get(person.getId()));

    }
    @Test
    public void testList() throws Exception {
        PersonDAO personDAO = new PersonDAO(ConnectionFactory.testConnection());

        Person person = new Person("Tim", "Kaspar", LocalDate.of(2020, 4, 3));
        Person person2 = new Person("Andreas", "Denzler", LocalDate.of(2020, 4, 20));

        List<Person> people = new LinkedList<>();

        personDAO.create(person);
        personDAO.create(person2);

        people.add(person);
        people.add(person2);

        Assert.assertNotNull(people);
        Assert.assertEquals(person.getFirstName(),people.get(0).getFirstName());
        Assert.assertEquals(person.getLastName(),people.get(0).getLastName());
        Assert.assertEquals(person.getBirthDate(),people.get(0).getBirthDate());

    }
    @Test
    public void testSave() throws Exception {
        PersonDAO personDAO = new PersonDAO(ConnectionFactory.testConnection());

        Person person = new Person("Tim", "Kaspar", LocalDate.of(2020, 4, 3));
        Person person2 = new Person("Andreas", "Denzler", LocalDate.of(2020, 4, 20));
        Person person3 = new Person("Franz", "Andreas", LocalDate.of(2020, 4, 20));

        personDAO.create(person);
        personDAO.create(person3);

        personDAO.save(person);
        personDAO.save(person2);
        personDAO.save(person3);

    }
    @Test
    public void testFind() throws Exception {
        PersonDAO personDAO = new PersonDAO(ConnectionFactory.testConnection());

        Person person = new Person("Tim", "Kaspar", LocalDate.of(2020, 4, 3));
        Person person2 = new Person("Andreas", "Denzler", LocalDate.of(2020, 4, 20));
        Person person3 = new Person("Franz", "Andreas", LocalDate.of(2020, 4, 20));

        personDAO.save(person);
        personDAO.save(person2);
        personDAO.save(person3);

        Assert.assertEquals(person.getFirstName(),personDAO.find("tim").get(0).getFirstName());
        Assert.assertEquals(person2.getFirstName(),personDAO.find("Andreas").get(0).getFirstName());
        Assert.assertEquals(person3.getLastName(),personDAO.find("andreas").get(1).getLastName());
    }


}
