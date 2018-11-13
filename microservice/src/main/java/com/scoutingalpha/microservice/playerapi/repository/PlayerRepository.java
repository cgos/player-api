package com.scoutingalpha.microservice.playerapi.repository;

import com.scoutingalpha.microservice.playerapi.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Optional<Player> findOneByFullName(String name);
}
