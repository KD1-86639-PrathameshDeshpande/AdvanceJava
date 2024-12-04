package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processRequest(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
	String email=req.getParameter("email");
	String password=req.getParameter("pass");
	String dob=req.getParameter("dob");
	Date bdate=Date.valueOf(dob);
	int status=0;
	String role="voter";
	User u=new User(0,fname,lname,email,password,bdate,status,role);
	
	try(UserDao udao=new UserDaoImpl()) {
		udao.save(u);
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("User Added Successfully");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
