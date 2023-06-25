package com.nt.service;

import com.nt.model.IPLPlayer;

public interface IIPLPLayerMgmtService {
	
	public String registerPlayer(IPLPlayer player);
	public Iterable<IPLPlayer> showAllPalyer();
	public String updatePlayer(IPLPlayer player);
	public String deletePlayer(int id);

}
