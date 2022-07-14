package webtest;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Consultant consultant = new Consultant();
		consultant.setEmail(request.getParameter("email"));
		consultant.setPassword(request.getParameter("password"));
		consultant.setNom(request.getParameter("nom"));
		consultant.setPrenom(request.getParameter("prenom"));
		consultant.setCommentaire(request.getParameter("commentaire"));

		ConsultantDAO dao = new ConsultantDAO();
		String page = "/registration.jsp";
		String message="";
		try {
			dao.insertConsultant(consultant);
			page = "/welcome.jsp";
			message="Thanks for joining us " + consultant.getPrenom() + 
					" " + consultant.getNom() + ".";
			
		} catch (SQLIntegrityConstraintViolationException ie) {
			message="Error account already exists";
		} catch (SQLException e) {
			message="Something went wrong";
		}
		request.setAttribute("message", message);
		request.setAttribute("consultant", consultant);
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}
}
