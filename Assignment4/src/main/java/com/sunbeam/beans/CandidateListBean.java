package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class CandidateListBean {
	String name;
	String party;
	
	public CandidateListBean() {
		
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
	
	public List<Candidate> candidatedisplay() {
		List<Candidate> list=new ArrayList<>();
		try(CandidateDao cdao=new CandidateDaoImpl()){
			list=cdao.findAll();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return list;
			
		}
	}


