package com.scoutingalpha.microservice.playerapi.domain;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

public class Player {
    @NotBlank(message = "Fullname is required")
    private String fullName;

//    private Date birthday;

    private int year;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return year == player.year &&
                Objects.equals(fullName, player.fullName) &&
                Objects.equals(address, player.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, year, address);
    }

    @Override
    public String toString() {
        return "Player{" +
                "fullName='" + fullName + '\'' +
                ", year=" + year +
                ", address=" + address +
                '}';
    }
}
