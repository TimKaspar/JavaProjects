package ch.ti8m.azubi.jdbc.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Person() {

    }

    public Person(String firstName, String lastName, LocalDate birthDate) {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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