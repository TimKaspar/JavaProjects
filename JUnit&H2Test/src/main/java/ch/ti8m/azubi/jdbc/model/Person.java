package ch.ti8m.azubi.jdbc.model;

import java.sql.Date;
<<<<<<< HEAD
import java.time.LocalDate;
=======
>>>>>>> cff5ea189c5f419376637abcfd81afb0bf3b4ba0
import java.util.Objects;

public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
<<<<<<< HEAD
    private LocalDate birthDate;
=======
    private Date birthDate;
>>>>>>> cff5ea189c5f419376637abcfd81afb0bf3b4ba0

    public Person() {

    }

<<<<<<< HEAD
    public Person(String firstName, String lastName, LocalDate birthDate) {
=======
    public Person(String firstName, String lastName, Date birthDate) {
>>>>>>> cff5ea189c5f419376637abcfd81afb0bf3b4ba0
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

<<<<<<< HEAD
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
=======
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
>>>>>>> cff5ea189c5f419376637abcfd81afb0bf3b4ba0
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "#" + id + ": " + firstName + " " + lastName + ", born on " + birthDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (id == null) {
            return false;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), id);
    }


}