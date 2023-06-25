package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.IPLTeam;
import com.nt.repository.IIPLTeamRepoitory;

@Service
public class IPLTeamMgmtServiceImpl implements IIPLTeamMgmtService {

	@Autowired
	private IIPLTeamRepoitory teamRepo;
	@Override
	public String saveTeam(IPLTeam team) {
		
		return "team saved with :"+teamRepo.save(team).getTeamId();
	}

	@Override
	public IPLTeam findTeamById(int id) {
		Optional<IPLTeam> opt = teamRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw new  IllegalArgumentException("invailid team id ");
	}

	@Override
	public Iterable<IPLTeam> findAllTeam() {
		return teamRepo.findAll();
	}

	@Override
	public String udateTeam(IPLTeam team) {
		Optional<IPLTeam> opt = teamRepo.findById(team.getTeamId());
		if(opt.isPresent())
		
			teamRepo.save(team);
		return team.getTeamId()+"team is update ";
	}

	@Override
	public String deleteTeam(int id) {
		Optional<IPLTeam> opt = teamRepo.findById(id);
		
		if(opt.isPresent())
		teamRepo.deleteById(id);
		return id +"Tourist is deleted";
	}

}
