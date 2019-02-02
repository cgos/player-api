package com.scoutingalpha.microservice.player.info.repository;

import com.scoutingalpha.microservice.player.info.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Optional<Player> findOneByFirstName(String name);
}
