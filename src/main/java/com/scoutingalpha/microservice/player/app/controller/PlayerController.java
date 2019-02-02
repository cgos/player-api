package com.scoutingalpha.microservice.player.app.controller;

import com.scoutingalpha.microservice.player.app.domain.Player;
import com.scoutingalpha.microservice.player.app.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/player")
class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private final PlayerRepository playerRepository = null;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Player player) {
        playerRepository.save(player);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Player player) {
        playerRepository.save(player);
    }

//    @RequestMapping(value = "/{id}")
//    public Optional<Player> read(@PathVariable String id){
//        return playerRepository.findById(id);
//    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        playerRepository.deleteById(id);
    }

    @RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
    public Optional<Player> getByfirstName(@PathVariable String firstName) {
        return playerRepository.findOneByFirstName(firstName);
    }


//    @GetMapping("/one")
//    public ResponseEntity<Player> player(@RequestParam(value = "name", defaultValue = "Wayne") String name) {
//        // TODO introduce slf4j
//
//        //TODO Understand the lambda and complete playerRepository before doing testing
//
//        logger.debug("request to get a player: {}", name);
//        Optional<Player> player = playerRepository.findOneByFullName(name);
//
//        if (player.isPresent()) {
//            return ResponseEntity.ok().body(player.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }


//        return Optional.ofNullable(new ResponseEntity<>(player, HttpStatus.OK));

//        return Optional.ofNullable((ResponseEntity) player).map(response -> {
//            return ((ResponseEntity.BodyBuilder) ResponseEntity.ok().body(response));
//        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));

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
//    }
}
