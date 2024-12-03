package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;
@WebServlet("/newcandidate")
public class AddCandidateServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	processRequest(req, resp);
	
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	processRequest(req, resp);
		
	}


protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String name=req.getParameter("name");
String party=req.getParameter("party");
int votes=0;
Candidate c=new Candidate(0,name,party,votes);

try(CandidateDao cdao=new CandidateDaoImpl()) {
cdao.save(c);
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	resp.sendRedirect("result");
	
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw new ServletException(e);
}


}

}
