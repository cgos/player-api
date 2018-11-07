package com.scoutingalpha.microservice.playerapi.controller;

import com.scoutingalpha.microservice.playerapi.domain.Address;
import com.scoutingalpha.microservice.playerapi.domain.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
class PlayerController {

    @GetMapping("/one")
    public ResponseEntity<Player> player(@RequestParam(value="name", defaultValue="Wayne") String name){
        //TODO introduce slf4j
        String city = "Beaconsfield";
        String country = "Canada";
        String postalCode = "H9W 5M9";
        String provinceCode = "Qc";
        String street = "Charleswood";

        Address address = new Address();
        address.setCity(city);
        address.setCountry(country);
        address.setPostalCode(postalCode);
        address.setProvinceCode(provinceCode);
        address.setStreet(street);
        Player p = new Player();
        p.setFullName("Wayne Gretzky");
        p.setYear(2008);
        p.setAddress(address);
        return ResponseEntity.ok().body(p);
    }
}
