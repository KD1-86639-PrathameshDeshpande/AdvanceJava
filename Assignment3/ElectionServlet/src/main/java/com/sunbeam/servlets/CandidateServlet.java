package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;
@WebServlet("/candlist")
public class CandidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list=new ArrayList<>();
		
		try(CandidateDao cdao=new CandidateDaoImpl()){
			list=cdao.findAll();
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new  ServletException(e);
	}
		resp.setContentType("text.html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		ServletContext co=this.getServletContext();
		String color=co.getInitParameter("color");
		out.println("<body bgcolor='"+color+"'>");
		
		
		ServletContext app=this.getServletContext();
		String appTitle=app.getInitParameter("app.title");
		out.println("<h1> "+appTitle+" </h1>");
		
		
		Cookie[] arr=req.getCookies();
		String userName="",role="";
		if(arr!=null) {
			for(Cookie c:arr) {
				if(c.getName().equals("uname")) {
					userName=c.getValue();
				}
				if(c.getName().equals("role")) {
					role=c.getValue();
				}
			}
		}
		out.printf("Hello %s please vote a candidate..",userName);
		
		ServletContext ctx=this.getServletContext();
		String ann=(String) ctx.getAttribute("announcement");
		if(ann!=null) {
			out.println("<p style='color=red'>NOTE: "+ann+" </p>");
		}
		
		
		
		out.println("<h1>Candidate List</h1>");
		out.println("<form method='post' action='vote'>");
		for(Candidate c:list) {
			out.printf("<input type='radio' name='candidate' value='%d'/> %s <br/> \n",c.getId(),c.getName());
		}
		out.println("<br/> <input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	
	}
}
