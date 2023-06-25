package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLTeam;
import com.nt.service.IIPLTeamMgmtService;

@RestController
@RequestMapping("/team")
public class IPLTeamOpreationController {
	@Autowired
	private IIPLTeamMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam team){
		String msg=service.saveTeam(team);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLTeam> searchIPLTeamById(@PathVariable("id") int id){
		IPLTeam team = service.findTeamById(id);
		return new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<Iterable<IPLTeam>> showAllTeam(){
		Iterable<IPLTeam> it = service.findAllTeam();
		return new ResponseEntity<Iterable<IPLTeam>>(it,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateTeam(@RequestBody IPLTeam team){
		
		String msg=service.udateTeam(team);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTeam(@PathVariable("id") int id){
		
		String msg=service.deleteTeam(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}

}
