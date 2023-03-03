package fr.formation.calculatrice.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.calculatrice.bll.Calculatrice;
import fr.formation.calculatrice.bll.CalculatriceException;
import fr.formation.calculatrice.bll.CalculatriceSing;

/**
 * Servlet implementation class CalculatriceServlet
 */
@WebServlet("/CalculatriceServlet")
public class CalculatriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Calculatrice calculatrice = CalculatriceSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculatriceServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CalculatriceModel model = new CalculatriceModel();
		
		
		Integer a =0;
		Integer b =0;
		if (request.getParameter("a") != null) {
			a = Integer.parseInt(request.getParameter("a"));
			b = Integer.parseInt(request.getParameter("b"));
		}

		if (request.getParameter("BT_PLUS") != null) {
			model.setResultat(calculatrice.plus(a, b));
		}
		if (request.getParameter("BT_MOINS") != null) {
			model.setResultat(calculatrice.moins(a, b));
		}
		if (request.getParameter("BT_FOIS") != null) {
			model.setResultat(calculatrice.fois(a, b));
		}
		if (request.getParameter("BT_DIV") != null) {
			try {
				model.setResultat(calculatrice.div(a, b));
			} catch (CalculatriceException e) {
				model.setMessage(e.getMessage());
			}
		}
		model.setHistorique(calculatrice.getHistory());

		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
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
