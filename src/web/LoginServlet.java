package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
//@WebServlet("/LoginServlet") 
public class LoginServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = null;
		RequestDispatcher dispatcher = null;
		if (("admin".equalsIgnoreCase(username) && "1234".equals(password))) {
			session = request.getSession();
			session.setAttribute("username", username);
			dispatcher = request.getRequestDispatcher("welcome.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("failure.jsp");
		}
		dispatcher.forward(request, response);
 
	}
 
}