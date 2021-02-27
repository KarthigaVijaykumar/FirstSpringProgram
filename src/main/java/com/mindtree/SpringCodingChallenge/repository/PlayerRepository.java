package com.mindtree.SpringCodingChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.SpringCodingChallenge.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer>{

	Player findByPlayerName(String playerName);

}
