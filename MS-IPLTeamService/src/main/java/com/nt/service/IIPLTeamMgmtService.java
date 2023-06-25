package com.nt.service;



import com.nt.model.IPLTeam;

public interface IIPLTeamMgmtService {
	
	public String saveTeam(IPLTeam team);
	
	public IPLTeam findTeamById(int id);
	
	public Iterable<IPLTeam> findAllTeam();
	public String udateTeam(IPLTeam team);
	public String deleteTeam(int id);

}
