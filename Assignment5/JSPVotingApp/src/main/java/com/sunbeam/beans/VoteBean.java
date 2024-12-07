package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {
	
	private int candId;
	private boolean success;
	private int userId;
	
	public VoteBean() {
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void vote() {
		this.success=false;
		try(CandidateDao cdao=new CandidateDaoImpl()){
			int count=cdao.incrVote(candId);
			if(count==1) {
				try(UserDao udao=new UserDaoImpl()){
					User user=udao.findById(this.userId);
					if(user!=null) {
						user.setStatus(1);
						count=udao.update(user);
						if(count==1) {
							this.success=true;
						}
					}
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
