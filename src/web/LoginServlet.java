package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import database.HibernateUtil;
import database.User;

@WebServlet("/LoginServlet")
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
		
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction tx = session1.beginTransaction();
		
		org.hibernate.Query q = session1.createQuery("FROM User as u WHERE u.userName="+username + " AND u.password="+password);
		List<User> user = new ArrayList<User>();
		user = q.list();
		tx.commit();
		if(user.size() > 0){
			System.out.println("\n\n\nIn the DATABASE method !!!!!!!!!!!!!!!!!1111\n\n\n ");
		} else {
			System.out.println("Login Failed");
			
			request.setAttribute("errorMsg", "Wrong username or password");
			
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		dispatcher.forward(request, response);
 
	}
 
}