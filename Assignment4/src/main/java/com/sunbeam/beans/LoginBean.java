package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {
	String email;
	String password;
	User u;
	
	public LoginBean() {
		
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public boolean login() {
		try(UserDao udao=new UserDaoImpl()){
			User dbUser=udao.findByEmail(email);
			if(dbUser!=null && dbUser.getPassword().equals(password)) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
	}
	

}
