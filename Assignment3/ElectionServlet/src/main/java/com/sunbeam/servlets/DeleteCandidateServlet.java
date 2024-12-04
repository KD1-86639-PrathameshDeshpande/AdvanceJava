package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;


@WebServlet("/delcand")
public class DeleteCandidateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pocessRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pocessRequest(request, response);
	}
protected void pocessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String candId=req.getParameter("id");
	int id=Integer.parseInt(candId);
	try(CandidateDao cdao=new CandidateDaoImpl()){
		
		int count=cdao.deleteById(id);
		String message="Candidate deleted "+count;
		req.setAttribute("msg",message);
		
	}catch(Exception e) {
		e.printStackTrace();
		throw new ServletException();
	}
	RequestDispatcher rd=req.getRequestDispatcher("result");
	rd.forward(req, resp);
	
	
	}

}
