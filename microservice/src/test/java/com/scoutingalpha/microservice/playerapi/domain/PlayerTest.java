package com.scoutingalpha.microservice.playerapi.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Player Tests")
class PlayerTest {
    private static Validator validator;
    private Player player;
    private Address address;

    @BeforeAll
    static void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @BeforeEach
    void before() {
        player = new Player();
        player.setFullName("Wayne Gretzky");
        player.setYear(2008);

        address = new Address();
        address.setCity("Beaconsfield");
        address.setCountry("Canada");
        address.setPostalCode("H9W 5M9");
        address.setProvinceCode("Qc");
        address.setStreet("Charleswood");

        player.setAddress(address);
    }

    @Test
    @DisplayName("name is required")
    void name() {
        assertEquals(player.getFullName(), "Wayne Gretzky");
        player.setFullName(null);
        Set<ConstraintViolation<Player>> violations = validator.validate(player);
        assertThat(violations, hasSize(1));

        ConstraintViolation<Player> violation = violations.iterator().next();

        assertThat(violation.getPropertyPath().toString(), is("fullName"));
        assertThat(violation.getMessage(), is("Fullname is required"));
        assertThat(violation.getInvalidValue(), nullValue());

        player.setFullName("");
        violations = validator.validate(player);
        assertThat(violations, hasSize(1));
        violation = violations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("fullName"));
        assertThat(violation.getMessage(), is("Fullname is required"));
        assertThat(violation.getInvalidValue(), is(""));
    }

    @Test
    @DisplayName("Year")
    void year() {
        assertEquals(player.getYear(), 2008);
    }

    @Test
    @DisplayName("Address")
    void address() {
        assertEquals(player.getAddress(), address);
    }

    @Test
    @DisplayName("Should implement toString")
    void implementToString() {
        assertThat(player.toString(), containsString(player.getFullName()));
        assertThat(player.toString(), containsString(String.valueOf(player.getYear())));
    }

    @Test
    @DisplayName("Should implement equals and hash code based on account")
    void equalsHashCode() {
        Player player1 = new Player();
        player1.setFullName("1");

        Player player2 = new Player();
        player2.setFullName("2");

        Player player3 = new Player();
        player3.setFullName("1");


        assertThat(player1, is(not(player2)));
        assertThat(player1.hashCode(), is(not(player2.hashCode())));

        assertThat(player1, is(player3));
        assertThat(player1.hashCode(), is(player3.hashCode()));
    }
}
