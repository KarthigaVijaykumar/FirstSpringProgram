package com.mindtree.SpringCodingChallenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "players")
public class Player {
	
	
	@Id
	private int playerId;
	private String playerName;
	private int playerAge;
	private String playerRole;
	
	@ManyToOne
	private Team team;
	
	
	public Player() {
		super();
	}


	public Player(int playerId, String playerName, int playerAge, String playerRole, Team team) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerAge = playerAge;
		this.playerRole = playerRole;
		this.team = team;
	}


	public int getPlayerId() {
		return playerId;
	}


	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public int getPlayerAge() {
		return playerAge;
	}


	public void setPlayerAge(int playerAge) {
		this.playerAge = playerAge;
	}


	public String getPlayerRole() {
		return playerRole;
	}


	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}

	
	@JsonBackReference
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
