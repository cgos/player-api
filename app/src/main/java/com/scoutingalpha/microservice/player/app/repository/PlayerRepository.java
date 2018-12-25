package com.scoutingalpha.microservice.player.app.repository;

import com.scoutingalpha.microservice.player.app.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Optional<Player> findOneByFirstName(String name);
}
