package CONTROLLER.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MODEL.entities.NoteHandler;
import MODEL.entities.UserHandler;


/**
 * To list all <code>users</code> after the user has clicked to show all <code>users</code>. <p>
 * Calling on method from <code>UserHandler</code> to list all users.
 * Stores the <code>list</code> of users in a <code>HashMap</code> to print it to the <code>users.jsp</code>.
 * 
 * @author Ludwig Slotte
 * 
 * */
@WebServlet("/GetUsersServlet")
public class GetUsersServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, List<String>> storedMessages = new HashMap<String, List<String>>();
		request.setAttribute("users", storedMessages);

		Map<String, Integer> storedAmountOfNotesMessages = new HashMap<String, Integer>();
		request.setAttribute("amountOfNotes", storedAmountOfNotesMessages);

		List<String> users = UserHandler.listUsers();

		storedMessages.put("users", users);

		request.getRequestDispatcher("/users.jsp").forward(request, response);

	}



}
