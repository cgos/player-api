package com.scoutingalpha.microservice.playerapi.com.scoutingalpha.microservice.playerapi.domain;

import java.util.Date;

public class Player {
    private String name;
    private Date birthday;
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
