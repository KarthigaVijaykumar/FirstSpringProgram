package com.mindtree.SpringCodingChallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.SpringCodingChallenge.entity.Player;
import com.mindtree.SpringCodingChallenge.entity.Team;
import com.mindtree.SpringCodingChallenge.exception.TeamServiceException;
import com.mindtree.SpringCodingChallenge.service.TeamService;


@RestController
public class TeamController {
	
	
	@Autowired 
	private TeamService service;

	
	@PostMapping("/addTeam")
	public ResponseEntity<?> addTeam(@RequestBody Team team) {
		String message;
		try {
			service.addTeam(team);
			message = "Team added successfully";
			return new ResponseEntity(message,HttpStatus.CREATED);
		} catch (TeamServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	 

	@PostMapping("/addPlayer/{teamId}")
	public ResponseEntity<?> addPlayer(@RequestBody Player player,@PathVariable int teamId) {
		String message;
		try {
			service.addPlayer(player,teamId);
			message = "Player added successfully";
			return new ResponseEntity(message,HttpStatus.CREATED);
		} catch (TeamServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	 
	@GetMapping("/getPlayersInTeam/{teamName}")
	public ResponseEntity<?> getPlayers(@PathVariable String teamName) {
		String message;
		try {
			Team playersInTeam = service.getPlayers(teamName);
			return new ResponseEntity(playersInTeam,HttpStatus.OK);
		} catch (TeamServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/getPlayerByName/{playerName}")
	public ResponseEntity<?> getPlayer(@PathVariable String playerName) {
		String message;
		try {
			Player playersDetails = service.getPlayer(playerName);
			return new ResponseEntity(playersDetails,HttpStatus.OK);
		} catch (TeamServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/updateLocation/{teamId}")
	public ResponseEntity<?> updateLocationById(@PathVariable int teamId,@RequestBody String location) {
		String message;
		try {
			Team updatedTeam = service.updateLocation(teamId,location);
			return new ResponseEntity(updatedTeam,HttpStatus.OK);
		} catch (TeamServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deletePlayer/{playerId}")
	public ResponseEntity<?> deletePlayerById(@PathVariable int playerId) {
		String message;
		try {
			String deletedMessage = service.deletePlayerById(playerId);
			return new ResponseEntity(deletedMessage,HttpStatus.NO_CONTENT);
		} catch (TeamServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	
}
