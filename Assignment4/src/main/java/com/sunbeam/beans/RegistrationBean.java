package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegistrationBean {
String fname;
String lname;
String email;
String pass;
String dob;
boolean result;

public RegistrationBean() {
	
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public boolean isResult() {
	return result;
}

public void setResult(boolean result) {
	this.result = result;
}
public boolean register() {
	try(UserDao udao=new UserDaoImpl()){
		String fname=this.fname;
		String lname=this.lname;
		String email=this.email;
		String pass=this.pass;
		Date dob=Date.valueOf(this.dob);
		String role="voter";
		int status=0;
		
		User dbUser=new User(0,fname,lname,email,pass,dob,status,role);
		udao.save(dbUser);
		result=true;
		
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}
	return result;
}


}
