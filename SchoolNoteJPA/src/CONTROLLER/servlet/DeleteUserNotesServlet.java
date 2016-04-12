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
 * This class only executes when the user clicks on '<code>Delete Note</code>'. <p>
 * Gets a request from the user to delete a certain <code>note</code> from an unique ID-number,
 * that we receive from a parameter.
 * Connects to the <code>Note</code>-table in the database to delete the row with the specific <code>note</code>. 
 * 
 * @author Ludwig Slotte
 */
@WebServlet("/DeleteUserNotesServlet")
public class DeleteUserNotesServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new delete user notes servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserNotesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get do request from jsp.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// --------------- MAPS
//		Map<String, String> messages = new HashMap<String, String>();
//		request.setAttribute("userDeleteNoteMsg", messages);

		String getCurrentNoteId = request.getParameter("userNotes");
		long noteId = Long.valueOf(getCurrentNoteId).longValue();

		NoteHandler.deleteNote(noteId);

//		messages.put("success", getCurrentNoteId);
		request.getRequestDispatcher("/ReadData").forward(request, response);
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
