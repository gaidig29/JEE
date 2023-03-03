package fr.formation.lesContextes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContexteServlet
 */
@WebServlet("/ContexteServlet")
public class ContexteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContexteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("BTREQ") != null) {
			request.setAttribute("messageReq", request.getParameter("message"));
		}
		if (request.getParameter("BTSES") != null) {
			request.getSession().setAttribute("messageSes", request.getParameter("message"));
		}
		if (request.getParameter("BTAPP") != null) {
			request.getServletContext().setAttribute("messageApp", request.getParameter("message"));
		}
		request.getRequestDispatcher("WEB-INF/contexte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
