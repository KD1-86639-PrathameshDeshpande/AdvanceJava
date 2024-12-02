package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Profile</title>");
		out.println("</head>");
		out.println("<body bgcolor='pink'>");
		out.println("<h1>Student Information</h1>");
		out.println("<h1>FirstName: Prathamesh</h1>");
		out.println("<h1>LastName: Deshpande</h1>");
		out.println("<h1>Qualification: B.Tech CSE</h1>");
		out.println("<h1>College Name: SIT Engineering,Yadrav</h1>");
		out.println("<h1>Date Of Birth: 31/05/2002</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
