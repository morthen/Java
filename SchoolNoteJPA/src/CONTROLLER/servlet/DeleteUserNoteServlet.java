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
 * Connects to the <code>Note</code>-table via <code>JPA</code> in the database to delete the row with the specific <code>note-id</code>. 
 * 
 * @author Ludwig Slotte
 */
@WebServlet("/DeleteUserNoteServlet")
public class DeleteUserNoteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String getCurrentNoteId = request.getParameter("userNote");
		long noteId = Long.valueOf(getCurrentNoteId).longValue();

		NoteHandler.deleteNote(noteId);

		request.getRequestDispatcher("/ReadNotes").forward(request, response);
	}


}
