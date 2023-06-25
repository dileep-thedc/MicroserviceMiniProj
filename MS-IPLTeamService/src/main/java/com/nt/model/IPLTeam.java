package com.nt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MS_IPLTeam")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class IPLTeam implements Serializable{
	@Id
	@GeneratedValue
	private Integer teamId;
	
	@Column(length=20)
	private String teamName;
	@Column(length=20)
	private String owner;
	@Column(length=20)
	private String captain;
	
	

}
