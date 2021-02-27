package com.mindtree.SpringCodingChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.SpringCodingChallenge.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

	Team findByTeamName(String teamName);

}
