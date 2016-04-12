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
 * To show other profiles other than the user that is currently logged-in. 
 * The profile shows the selected user's <code>notes</code>. <p>
 * 
 * Gets list of <code>Notes</code> from current <code>username</code>
 *  after calling method from <code>NoteHandler</code>. 
 * Stores list of <code>Note</code>-objects in a <code>HashMap</code>
 *  to show in <code>userProfile.jsp</code>.
 * 
 * @author Ludwig Slotte
 */

@WebServlet("/OtherUserProfileServlet")
public class OtherUserProfileServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// --------------- MAPS
		Map<String, List<Note>> storedListMessages = new HashMap<String, List<Note>>();
		Map<String, String> messages = new HashMap<String, String>();
		
		request.setAttribute("list", storedListMessages);		
		request.setAttribute("userProfileMsg", messages);

		HttpSession session = request.getSession(true);

		String userProfile = request.getParameter("userProfile");
		String getUser = UserHandler.getNamefromUsername(userProfile);

		List<Note> noteData = NoteHandler.getNotefromUsername(userProfile);

		messages.put("success", getUser);
		session.setAttribute("listNoteObject", noteData);

		request.getRequestDispatcher("/userProfile.jsp").forward(request,
				response);
	}



}
