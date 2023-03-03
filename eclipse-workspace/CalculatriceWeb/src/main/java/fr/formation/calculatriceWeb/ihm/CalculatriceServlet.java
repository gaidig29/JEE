package fr.formation.calculatriceWeb.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.calculatriceWeb.bll.CalculatriceImpl;
import fr.formation.calculatriceWeb.bo.Calculatrice;

/**
 * Servlet implementation class CalculatriceServlet
 */
@WebServlet("/CalculatriceServlet")
public class CalculatriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculatriceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CalculatriceImpl manager = new CalculatriceImpl();
		int res= 0;
		if(request.getParameter("BT_VALID") != null) {

			Integer a = Integer.parseInt(request.getParameter("a"));
			Integer b = Integer.parseInt(request.getParameter("b"));
			String op = request.getParameter("op");
			
		 	Calculatrice calcul = new Calculatrice(a,b,op);
			res = manager.calcul(calcul);

		}
		request.setAttribute("resultat", res);
		request.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
