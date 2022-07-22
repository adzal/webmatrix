package webmatrix;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Consultant;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

import dataaccess.ConsultantDAO;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String WELCOME_PAGE = "/WEB-INF/welcome.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Welcome() {
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
		Consultant consultant = (Consultant) session.getAttribute("consultant");
		String page = WELCOME_PAGE;
		if (consultant == null) {
			// We have no consultant lets see if we have a cookie instead.
			Optional<String> email = Arrays.stream(request.getCookies())
					.filter(c -> "webmatrixlogin".equals(c.getName()))
					.findAny()
					.map(c -> c.getValue());

			if (email.isPresent()) {
				try {
					// We have no consultant but we have a cookie with the email so
					// lets call the ConsultantDAO to recover the consultant.
					ConsultantDAO dao = new ConsultantDAO();
					consultant = dao.getConsultant(email.get());
					consultant.setIsCookieLogin(true);
					session.setAttribute("consultant", consultant);
				} catch (SQLException e) {
					page = "/";
					request.setAttribute("message", "Something went wrong.");
				}
			} else {
				page = "/";
				request.setAttribute("message", "Must login to access Welcome page");
			}
		}
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
