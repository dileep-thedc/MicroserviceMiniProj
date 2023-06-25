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

import com.nt.model.IPLPlayer;
import com.nt.service.IIPLPLayerMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/player")
public class IPLPLayerOprationController {
	
	@Autowired
	private IIPLPLayerMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
		
		String msg=service.registerPlayer(player);
		log.info("Rest Controller :request came from player service");
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	@GetMapping("/all")
	public ResponseEntity<Iterable<IPLPlayer>> showAllPlayer(){
		Iterable<IPLPlayer> it = service.showAllPalyer();
		log.info("Rest Controller :request came from show all player");
		return new ResponseEntity<Iterable<IPLPlayer>>(it,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatePlayer(@RequestBody IPLPlayer player){
		String msg=service.updatePlayer(player);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePlayer(@PathVariable("id") int id){
		String msg=service.deletePlayer(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
