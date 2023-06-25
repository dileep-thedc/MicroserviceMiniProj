package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.client.IIPLTeamServiceConsumer;
import com.nt.model.IPLPlayer;
import com.nt.model.IPLTeam;
import com.nt.repository.IIPLPlayerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IPLPlayerMgmtServiceImpl implements IIPLPLayerMgmtService  {

	@Autowired
	private IIPLPlayerRepository playerRepo;
	@Autowired
	private IIPLTeamServiceConsumer consumer;
	@Override
	public String registerPlayer(IPLPlayer player) {

		//use feign client ms communication to get IPLTeam info  being palyer service
		IPLTeam team=consumer.searchTeamById(player.getTeamInfo().getTeamId());
		//assign palyer object to team object
		log.info("consumer player service got info from team service using feign client");
		player.setTeamInfo(team);
		
		log.info("player object is saved");
		// save player object 
		return "player with team details:"+playerRepo.save(player).getPlayerId();
	}

	@Override
	public Iterable<IPLPlayer> showAllPalyer() {
		
		log.info("all player details retrived");
		return playerRepo.findAll();
	}

	@Override
	public String updatePlayer(IPLPlayer player) {
		Optional<IPLPlayer> opt = playerRepo.findById(player.getPlayerId());
		if(opt.isPresent());
			playerRepo.save(player);
		return "player updated:"+player;
	}

	@Override
	public String deletePlayer(int id) {
		Optional<IPLPlayer> opt = playerRepo.findById(id);
		if(opt.isPresent())
			playerRepo.deleteById(id);
		return id+"Deleted";
	}


}
