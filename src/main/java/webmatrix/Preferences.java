package webmatrix;

import java.io.IOException;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Consultant;

/**
 * Servlet implementation class Preferences
 */
public class Preferences extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PREFERENCES_PAGE = "/WEB-INF/Preferences.jsp";
	private final String LOGIN_PAGE = "/WEB-INF/login.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Preferences() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Optional<Consultant> consultant = Optional.ofNullable((Consultant) session.getAttribute("consultant"));
		String page = PREFERENCES_PAGE;
		String message = "Welcome to preferences page.";

		// If no consultant or if we logged in via a cookie go to login page
		if (consultant.map(Consultant::getIsCookieLogin).orElse(true)) {
			message = "You must re-login to update preferences.";
			page = LOGIN_PAGE;
		}
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
