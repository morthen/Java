package CONTROLLER.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MODEL.authenticate.LoginAuthenticate;


/**
 * Handles the login request, to get the parameters 
 * <code>username</code> and <code>password</code> for validation. <p>
 * 
 * The class sends redirect to <code>WelcomeScreen</code> if user is validated, 
 * else prints out error message to <code>login.jsp</code>.
 * 
 * @author Ludwig Slotte / Martin Özgun
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String login = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession(false);
		if (session != null)
			session.setAttribute("username", login);

		
		// Take the login-username and password parameters and authenticate them to log-in to site.
		if (LoginAuthenticate.validate(login, password)) {
			response.sendRedirect("http://localhost:8080/SchoolNoteJPA/WelcomeScreen?username="
					+ login);
		} 
		// If validation fails, print out error to screen
		else {

			out.print("<p style=\"color:red\">Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);

		}

		out.close();
	}
}
