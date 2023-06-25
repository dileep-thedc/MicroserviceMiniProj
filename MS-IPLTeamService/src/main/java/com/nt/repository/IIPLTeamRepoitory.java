package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.IPLTeam;

public interface IIPLTeamRepoitory extends JpaRepository<IPLTeam, Integer> {

}
