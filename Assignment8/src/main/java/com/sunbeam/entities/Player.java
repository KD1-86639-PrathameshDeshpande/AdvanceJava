package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="players")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
public class Player extends BaseEntity{
	@Column(name="fist_name",length=20)
	private String firstName;
	
	@Column(name="last_name",length=20)
	private String lastName;
	
	private LocalDate dob;
	@Column(name="batting_avg")
	private double battingAvg;
	@Column(name="wickets_taken")
	private int wicketsTaken;
	@ManyToOne
	@JoinColumn(name="team_id")
	private IPLTeam playerTeam;
	
	
	public Player(String firstName,String lastName,LocalDate dob,double battingAvg,int wicketsTaken) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		this.battingAvg=battingAvg;
		this.wicketsTaken=wicketsTaken;
	}
	
	
}
