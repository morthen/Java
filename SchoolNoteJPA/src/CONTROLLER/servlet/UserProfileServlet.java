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

import MODEL.entities.Note;
import MODEL.entities.NoteHandler;
import MODEL.entities.UserHandler;


/**
 * 
 * We get the session-object of the current session, which holds the data of the current logged-in user. 
 * We send the data to the Model, which returns the notes from the user.
 * Then we can send the data to the View of what notes the current logged-in user has written.
 * 
 * 
 * @author Martin Özgun
 */

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// --------------- MAPS ------------------
		Map<String, List<Note>> storedListMessages = new HashMap<String, List<Note>>();
		Map<String, String> messages = new HashMap<String, String>();

		request.setAttribute("list", storedListMessages);
		request.setAttribute("userProfileMsg", messages);
		
		HttpSession session = request.getSession(true);

		String userProfile = (String) session.getAttribute("loginSave");
		String getUser = UserHandler.getNamefromUsername(userProfile);

		List<Note> noteData = NoteHandler.getNotefromUsername(userProfile);

		session.setAttribute("listNoteObject", noteData);
		messages.put("success", getUser);

		request.getRequestDispatcher("/userProfile.jsp").forward(request,
				response);
	}



}
