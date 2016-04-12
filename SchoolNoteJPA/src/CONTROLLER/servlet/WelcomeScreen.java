package CONTROLLER.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MODEL.entities.User;
import MODEL.entities.UserHandler;


/**
 * 
 * 
 * @author Martin Özgun
 */
public class WelcomeScreen extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String saveLogin = request.getParameter("username");
		HttpSession session = request.getSession(true);
		session.setAttribute("loginSave", saveLogin);

		String getName = UserHandler.getNamefromUsername(saveLogin);

		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("message", messages);
		messages.put("success",
				String.format("Hello %s and welcome to School Note!", getName));

		
		request.getRequestDispatcher("/success.jsp").forward(request, response);

	}


}