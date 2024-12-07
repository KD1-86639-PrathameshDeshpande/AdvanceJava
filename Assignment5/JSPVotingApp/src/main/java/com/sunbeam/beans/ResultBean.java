package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class ResultBean {
	private List<Candidate> list;
	public ResultBean() {
		this.list=new ArrayList<Candidate>();
	}
	public List<Candidate> getList() {
		return list;
	}
	public void setList(List<Candidate> list) {
		this.list = list;
	}
	public void fetchCandidate() {
		try(CandidateDao cdao=new CandidateDaoImpl()){
			this.list=cdao.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	

}
