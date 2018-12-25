package com.scoutingalpha.microservice.player.app.domain;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Player {
    @Id
    private String id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

//    LocalDate birthDay = LocalDate.of(1990, Month.DECEMBER, 15);
    private LocalDate birthday;

    private Address address;

    private ArrayList<String> associations;

    private ArrayList<String> sports;

    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<String> getAssociations() {
        return associations;
    }

    public void setAssociations(ArrayList<String> associations) {
        this.associations = associations;
    }

    public ArrayList<String> getSports() {
        return sports;
    }

    public void setSports(ArrayList<String> sports) {
        this.sports = sports;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(firstName, player.firstName) &&
                Objects.equals(lastName, player.lastName) &&
                Objects.equals(birthday, player.birthday) &&
                Objects.equals(address, player.address) &&
                Objects.equals(associations, player.associations) &&
                Objects.equals(sports, player.sports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, address, associations, sports);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", address=" + address +
                ", associations=" + associations +
                ", sports=" + sports +
                '}';
    }
}