package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class NewCandidate {
	String name;
	String party;
	int count;
	public NewCandidate() {
		this.name=name;
		this.party=party;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void addCandidate() {
		try(CandidateDao cdao=new CandidateDaoImpl()){
			int vote=0;
			Candidate cand=new Candidate(0,name,party,vote);
			count=cdao.save(cand);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
