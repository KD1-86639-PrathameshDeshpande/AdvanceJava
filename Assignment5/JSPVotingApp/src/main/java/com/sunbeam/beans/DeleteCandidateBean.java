package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class DeleteCandidateBean {
	private int candId;
	private int count;
	
	public DeleteCandidateBean() {
		
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void deleteCandidate() {
		try(CandidateDao cdao=new CandidateDaoImpl()){
			count=cdao.deleteById(candId);
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
}
