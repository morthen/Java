package CONTROLLER.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MODEL.entities.Note;
import MODEL.entities.NoteHandler;


/**
 * We get the <code>session</code>-object of loginSave which holds the data of who is currently logged-in. <p>
 * The data gets sent to a method in <code>NoteHandler</code>, which returns the notes from the logged-in user. 
 * The data gets saved in a <code>list</code> of <code>Note</code>-objects's that we return to the View.
 * 
 * @author Martin Özgun
 */

public class ReadNotes extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// GET CURRENT SESSION, AND GET ATTRIBUTES FROM LOGINSAVE/DATASAVE
		HttpSession session = request.getSession(true);
		String loginStr = (String) session.getAttribute("loginSave");

		List<Note> noteData = NoteHandler.getNotefromUsername(loginStr);

		session.setAttribute("listNoteObject", noteData);

		request.getRequestDispatcher("/handleNotes.jsp")
				.forward(request, response);

	}



}
