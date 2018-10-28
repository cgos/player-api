package com.scoutingalpha.microservice.playerapi.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

@DisplayName("Player Tests")
public class PlayerTest {
    private static Validator validator;
    private Player player;

    @BeforeAll
    static void setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @BeforeEach
    void before() {
        player = new Player();
        player.setFullName("Wayne Gretzky");
        player.setYear(2008);
    }

    @Test
    @DisplayName("name is required")
    void name() {
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
//            player.setYear(2008);
    }

    @Test
    @DisplayName("Address")
    void address() {
        //        player.setAddress();
    }
}
