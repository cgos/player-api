package com.scoutingalpha.microservice.playerapi.controller;

import com.scoutingalpha.microservice.playerapi.com.scoutingalpha.microservice.playerapi.domain.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @GetMapping("/one")
    public Player player(@RequestParam(value="name", defaultValue="Wayne") String name){
        Player p = new Player();
        p.setName("Wayne");
        return p;
    }
}
