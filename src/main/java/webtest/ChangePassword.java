package webtest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String email = request.getParameter("email");
		
		getServletContext().getRequestDispatcher("/changepassword.jsp").forward(request, response);
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

		String message = "";
		String page = "/welcome.jsp";

		ConsultantDAO dao = new ConsultantDAO();
		try {
			if (dao.changePassword(email, oldPassword, newPassword)) {
				Consultant consultant = dao.getConsultant(email);
				request.setAttribute("consultant", consultant);
				message = "Password reset for " +
						consultant.getPrenom() + " " +
						consultant.getNom();

			} else {
				page = "/changepassword.jsp";
				request.setAttribute("email", email);
				message = "password reset error.";
			}
		}catch(SQLSyntaxErrorException e) {
			message = "Something went wrong";
			page = "/changepassword.jsp";		
		}
		catch (SQLException e) {
			message = "Something went wrong";
			page = "/changepassword.jsp";
		}

		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}
}
