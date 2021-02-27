package com.mindtree.SpringCodingChallenge.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "teams")
public class Team {
	
	@Id
	private int teamId;
	private String teamName;
	private String location;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Player> players;
	
	public Team() {
		super();
	}
	
	public Team(int teamId, String teamName, String location) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.location = location;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@JsonManagedReference
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
