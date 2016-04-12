package CONTROLLER.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MODEL.entities.Note;
import MODEL.entities.NoteHandler;


/**
 * 
 * We get the <code>session</code>-object of loginSave which holds the data of who is currently logged-in. <p>
 * 
 * The parameter from writtenData, which the user has typed in as a note that will get saved, gets stored to the session also. <p>
 * 
 * The data from <code>writtenData</code> gets sent to a method in
 *  the <code>Model</code> to add a new row in the table <code>Note</code>,
 *  which saves the <code>loginSave</code>, <code>writtenData</code>, and auto-generates an unique key for that column, that we later
 *  can receive.
 * 
 */
@WebServlet("/StoreData")
public class StoreData extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// GET CURRENT SESSION
		HttpSession session = request.getSession(true);

		// GET USERNAME FROM SESSION
		String usernameStr = (String) session.getAttribute("loginSave");

		// SAVE DATA TO SESSION
		String noteStr = request.getParameter("writtenData");
		session.setAttribute("dataSave", noteStr);

		NoteHandler.addNote(new Note(noteStr, usernameStr));
		request.getRequestDispatcher("/success.jsp").forward(request, response);

	}

}
