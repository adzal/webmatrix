package webmatrix;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOut
 */
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		session.invalidate();

		Arrays.stream(request.getCookies())
				.filter(c -> "webmatrixlogin".equals(c.getName()))
				.findAny()
				.ifPresent(c -> {
					// If a matching cookie set max Age to 0 then add to response
					c.setMaxAge(0);
					response.addCookie(c);
				});

//		Cookie loginCookie = null;
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("webmatrixlogin")) {
//					loginCookie = cookie;
//					break;
//				}
//			}
//		}
//		if (loginCookie != null) {
//			loginCookie.setMaxAge(0);
//			response.addCookie(loginCookie);
//		}
		
		getServletContext().getRequestDispatcher("/").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
