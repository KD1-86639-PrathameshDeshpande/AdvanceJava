package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="Teams")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
public class IPLTeam extends BaseEntity {
	
	
	@Column(length=100,unique=true)
	private String name;
	
	@Column(length=10,unique=true)
	private String abbreviation;
	
	@Column(length=40, nullable=false)
	private String owner;
	
	@Column(name="max_player_age")
	private int maxPlayerAge;
	
	@Column(name="batting_avg")
	private double battingAvg;
	
	@Column(name="wicket_taken")
	private int wicketTaken;
	@OneToMany (mappedBy = "playerTeam")
	@ToString.Exclude
	private List<Player> players=new ArrayList<>();
	
	public IPLTeam(String owner,String abbreviation) {
		this.abbreviation=abbreviation;
		this.owner=owner;
	}
	
	
public IPLTeam(String name,String abbrevation,String owner,int maxPlayerAge,double battingAvg,int wicketTaken)
	 {
	super();
	this.name=name;
	this.abbreviation=abbrevation;
	this.owner=owner;
	this.maxPlayerAge=maxPlayerAge;
	this.battingAvg=battingAvg;
	this.wicketTaken=wicketTaken;
}

public void addPlayer(Player p) {
	this.players.add(p);
	p.setPlayerTeam(this);
}


public void removePlayer(Player players2) {
this.players.remove(players2);
players2.setPlayerTeam(null);
	
}








}
