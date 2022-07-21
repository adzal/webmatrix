package webmatrix;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import dataaccess.ConsultantDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Consultant;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Optional<String> rememberMe = Optional.ofNullable(request.getParameter("rememberme"));
	
		try {
			ConsultantDAO loginDao = new ConsultantDAO();
			String page = "/login.jsp";
			String message = "";
			if (loginDao.validate(email, password)) {
				Consultant consultant = loginDao.getConsultant(email);
				session.setAttribute("consultant", consultant);

				if (rememberMe.isPresent()) {
					// We checked the box to remember me and a
					// successful login, lets set a cookie.
					Cookie webMatrixCookie = new Cookie("webmatrixlogin", email);
					// setting cookie to expiry in 10 mins
					webMatrixCookie.setMaxAge(10 * 60);
					response.addCookie(webMatrixCookie);
				}
				
				message = "Welcome back " +
						consultant.getPrenom() + " " +
						consultant.getNom();

				page = "/welcome.jsp";
			} else {
				request.setAttribute("email", email);
				message = "Login error.";
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher(page).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
