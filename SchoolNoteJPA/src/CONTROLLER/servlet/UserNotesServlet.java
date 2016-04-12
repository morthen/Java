package CONTROLLER.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MODEL.entities.NoteHandler;


/**
 *  To see the specified note that we have selected from the <code>View</code>,
 *  that we return from the <code>Model</code> with help of the unique id of that note.
 */

@WebServlet("/UserNotesServlet")
public class UserNotesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("userNoteMsg", messages);
		
		String getCurrentNoteId = request.getParameter("userNotes");
		long noteID = Long.valueOf(getCurrentNoteId).longValue();
		String currentNote = NoteHandler.getNoteFromId(noteID);

		messages.put("success", currentNote);
		request.getRequestDispatcher("/showNote.jsp")
				.forward(request, response);
	}


}
