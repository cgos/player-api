package com.scoutingalpha.microservice.playerapi.controller;

import com.scoutingalpha.microservice.playerapi.domain.Address;
import com.scoutingalpha.microservice.playerapi.domain.Player;
import com.scoutingalpha.microservice.playerapi.repository.PlayerRepository;
import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/player")
class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    private final PlayerRepository playerRepository;

    @GetMapping("/one")
    public ResponseEntity<Player> player(@RequestParam(value = "name", defaultValue = "Wayne") String name) {
        // TODO introduce slf4j

        //TODO Understand the lambda and complete playerRepository before doing testing

        logger.debug("request to get a player: {}", name);
        Optional<Player> player = playerRepository.findOneByFullName(name);
        return Optional.ofNullable((ResponseEntity) player).map(response -> {
            return ((ResponseEntity.BodyBuilder) ResponseEntity.ok().body(response));
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));

//        String city = "Beaconsfield";
//        String country = "Canada";
//        String postalCode = "H9W 5M9";
//        String provinceCode = "Qc";
//        String street = "Charleswood";
//
//        Address address = new Address();
//        address.setCity(city);
//        address.setCountry(country);
//        address.setPostalCode(postalCode);
//        address.setProvinceCode(provinceCode);
//        address.setStreet(street);
//        Player p = new Player();
//        p.setFullName("Wayne Gretzky");
//        p.setYear(2008);
//        p.setAddress(address);
//        return ResponseEntity.ok().body(p);
    }
}
