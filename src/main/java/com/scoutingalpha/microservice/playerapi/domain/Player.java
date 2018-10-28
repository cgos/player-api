package com.scoutingalpha.microservice.playerapi.domain;

import javax.validation.constraints.NotBlank;
import java.util.Date;

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
}
