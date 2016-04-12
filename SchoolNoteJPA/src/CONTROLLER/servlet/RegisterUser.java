package CONTROLLER.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.persistence.RollbackException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.exceptions.DatabaseException;

import MODEL.entities.User;
import MODEL.entities.UserHandler;


/**
 * Servlet implementation class RegisterUser.
 * 
 * @author Ludwig Slotte / Martin Özgun
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try{
		
		boolean errorDuplicate = false;
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String username = request.getParameter("login");
		String password = request.getParameter("password");
		
	

		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messageError", messages);

		try {
			UserHandler.addUsers(new User(username, name, password));
		} catch (RollbackException e) {
			System.err.println("Duplicate key of username causes - " + e.getClass());
			out.print("<p style=\"color:red\">Sorry, the username " + username +" is already taken</p>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
			errorDuplicate = true;
		}

		if (!errorDuplicate) {
		
			request.setAttribute("user", username);
			response.sendRedirect("http://localhost:8080/SchoolNoteJPA/WelcomeScreen?username="
					+ username);
		}
		} catch(Exception e){
			System.err.println("Exception in " + e.getClass() + " Message: " + e.getMessage());
		}

	}


}
