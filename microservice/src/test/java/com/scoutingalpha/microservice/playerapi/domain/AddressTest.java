package com.scoutingalpha.microservice.playerapi.domain;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Address Test")
class AddressTest {
    private Address address;

    private final String city = "Beaconsfield";
    private final String country = "Canada";
    private final String postalCode = "H9W 5M9";
    private final String provinceCode = "Qc";
    private final String street = "Charleswood";

    @BeforeAll
    static void setup() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @BeforeEach
    void before() {
        address = new Address();
        address.setCity(city);
        address.setCountry(country);
        address.setPostalCode(postalCode);
        address.setProvinceCode(provinceCode);
        address.setStreet(street);
    }

    @Test
    @DisplayName("City")
    void city() {
        assertEquals(address.getCity(), city);
    }

    @Test
    @DisplayName("Country")
    void country() {
        assertEquals(address.getCountry(), country);
    }

    @Test
    @DisplayName("Postal Code")
    void postalCode() {
        assertEquals(address.getPostalCode(), postalCode);
    }

    @Test
    @DisplayName("Province")
    void province() {
        assertEquals(address.getProvinceCode(), provinceCode);
    }

    @Test
    @DisplayName("Street")
    void street() {
        assertEquals(address.getStreet(), street);
    }

    @Test
    @DisplayName("Should implement toString")
    void implementToString() {
        assertThat(address.toString(), containsString(city));
        assertThat(address.toString(), containsString(country));
    }


    @Test
    @DisplayName("Should implement equals and hash code based on account")
    void equalsHashCode() {
        Address address1 = new Address();
        address1.setCity("1");

        Address address2 = new Address();
        address2.setCity("2");

        Address address3 = new Address();
        address3.setCity("1");

        assertThat(address1, is(not(address2)));
        assertThat(address1.hashCode(), is(not(address2.hashCode())));

        assertThat(address1, is(address3));
        assertThat(address1.hashCode(), is(address3.hashCode()));
    }
}
