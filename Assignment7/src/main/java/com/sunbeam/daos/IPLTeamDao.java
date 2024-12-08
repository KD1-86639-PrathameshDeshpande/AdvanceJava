package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.IPLTeam;

public interface IPLTeamDao {
	String registerTeam(IPLTeam team);
	List<IPLTeam> displayTeams();
	List<IPLTeam> diaplayTeamswithAgenBatting(int maxPlayerAge,double battingAvg);
	List<IPLTeam> displayOwnerandAbbreviation(int maxPlayerAge,double battingAvg);
	String updateMaxAgeRequirement(String name,int newAge);
	String deleteTeam(Long teamId);
}
