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
 * Servlet implementation class ReadData.
 */

public class ReadData extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Get do request from jsp.
	 *
	 */
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// GET CURRENT SESSION, AND GET ATTRIBUTES FROM LOGINSAVE/DATASAVE
		HttpSession session = request.getSession(true);
		String loginStr = (String) session.getAttribute("loginSave");
//		String dataStr = (String) session.getAttribute("dataSave");

		List<Note> noteData = NoteHandler.getNotefromUsername(loginStr);

		session.setAttribute("listNoteObject", noteData);

		request.getRequestDispatcher("/readData.jsp")
				.forward(request, response);

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
