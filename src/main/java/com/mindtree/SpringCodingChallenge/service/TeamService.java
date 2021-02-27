package com.mindtree.SpringCodingChallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.SpringCodingChallenge.entity.Player;
import com.mindtree.SpringCodingChallenge.entity.Team;
import com.mindtree.SpringCodingChallenge.exception.TeamServiceException;
import com.mindtree.SpringCodingChallenge.repository.PlayerRepository;
import com.mindtree.SpringCodingChallenge.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired 
	private TeamRepository teamrepo;
	@Autowired
	private PlayerRepository playerrepo;
	

	public Team addTeam(Team team) throws TeamServiceException{
		int Id = team.getTeamId();
		Team teamPresent = null;
		teamPresent = teamrepo.findById(Id).orElse(null);
		if(teamPresent == null) {
			return teamrepo.save(team);
		}
		else {
			throw new TeamServiceException("TeamId is already added in the database");
		}
	}
	
	
	public Player addPlayer(Player player, int teamId) throws TeamServiceException {
		Team teamPresent = teamrepo.findById(teamId).orElse(null);
		int Id = player.getPlayerId();
		Player playerPresent = playerrepo.findById(Id).orElse(null);
		if(playerPresent == null) {
			player.setTeam(teamPresent);
			return playerrepo.save(player);
		}
		else {
			throw new TeamServiceException("Player Id is already added in the database");
		}
	}


	public Team getPlayers(String teamName) throws TeamServiceException {
		Team team = teamrepo.findByTeamName(teamName);
		if(team != null) {
			return team;
		}
		else {
			throw new TeamServiceException("No such team is present in the database");
		}
	}
	

	public Team updateLocation(int teamId, String location) throws TeamServiceException {
		Team teamPresent = teamrepo.findById(teamId).orElse(null);
		if(teamPresent != null) {
			teamPresent.setLocation(location);
			return teamrepo.save(teamPresent);
		}
		else {
			throw new TeamServiceException("No such team is present in the database to make changes");
		}
	}


	public String deletePlayerById(int playerId) throws TeamServiceException {
		Player playerPresent = playerrepo.findById(playerId).orElse(null);
		if(playerPresent != null) {
			playerrepo.deleteById(playerId);
			return "Player details deleted successfully";
		}
		else {
			throw new TeamServiceException("No such player is available in the database");
		}
	}


	public Player getPlayer(String playerName) throws TeamServiceException {
		Player player = playerrepo.findByPlayerName(playerName);
		if(player != null) {
			return player;
		}
		else {
			throw new TeamServiceException("No such player is present in the database");
		}
		
	}

	
}