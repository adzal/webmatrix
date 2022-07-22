package webmatrix;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import dataaccess.ConsultantDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Consultant;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String CHANGE_PASSWORD = "/WEB-INF/changepassword.jsp";
	private final String WELCOME_PAGE = "/WEB-INF/welcome.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher(CHANGE_PASSWORD).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String oldPassword = request.getParameter("oldpassword");
		String newPassword = request.getParameter("password");
		String password2 = request.getParameter("password2");

		String message = "";
		String page = WELCOME_PAGE;

		ConsultantDAO dao = new ConsultantDAO();
		try {

			if (email.isBlank() ||
					oldPassword.isBlank() ||
					newPassword.isBlank()) {
				page = CHANGE_PASSWORD;
				message = "You must fill in all fields.";
			} else if (!password2.equals(newPassword)) {
				page = CHANGE_PASSWORD;
				message = "The passwords must match";
			} else if (dao.changePassword(email, oldPassword, newPassword)) {
				Consultant consultant = dao.getConsultant(email);
				HttpSession session = request.getSession();
				session.setAttribute("consultant", consultant);
				page = WELCOME_PAGE;
				message = "Password for " +
						consultant.getPrenom() + " " +
						consultant.getNom() + " changed successfully";
			} else {
				page = CHANGE_PASSWORD;
				request.setAttribute("email", email);
				message = "password reset error.";
			}
		} catch (SQLSyntaxErrorException e) {
			message = "Something went wrong";
			page = CHANGE_PASSWORD;
		} catch (SQLException e) {
			message = "Something went wrong";
			page = CHANGE_PASSWORD;
		}

		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}
}
