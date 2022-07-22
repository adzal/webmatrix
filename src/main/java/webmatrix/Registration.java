package webmatrix;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import dataaccess.ConsultantDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Consultant;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String REGISTRATION_PAGE = "/WEB-INF/registration.jsp";
	private final String WELCOME_PAGE = "/WEB-INF/welcome.jsp";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create a NEW users so invalidate current consultant
		HttpSession session = request.getSession();
		session.invalidate();
		getServletContext().getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		Consultant consultant = new Consultant();
		consultant.setEmail(request.getParameter("email"));
		consultant.setPassword(request.getParameter("password"));
		String password2 = request.getParameter("password2");
		consultant.setNom(request.getParameter("nom"));
		consultant.setPrenom(request.getParameter("prenom"));
		consultant.setCommentaire(request.getParameter("commentaire"));

		ConsultantDAO dao = new ConsultantDAO();
		String page = REGISTRATION_PAGE;
		String message = "";
		try {
			if (consultant.getEmail().isBlank() ||
					consultant.getNom().isBlank() ||
					consultant.getPrenom().isBlank() ||
					consultant.getPassword().isBlank()) {
				message = "You must fill in all fields.";
			} else if (!password2.equals(consultant.getPassword())) {
				message = "The passwords must match";
			} else {
				// Check we
				dao.insertConsultant(consultant);
				page = WELCOME_PAGE;
				request.setAttribute("consultant", consultant);
				message = "Thanks for joining us " + consultant.getPrenom() +
						" " + consultant.getNom() + ".";
			}
		} catch (SQLIntegrityConstraintViolationException ie) {
			message = "Error account already exists";
		} catch (SQLException e) {
			message = "Something went wrong";
		}
		request.setAttribute("message", message);
		session.setAttribute("consultant", consultant);
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}
}
