package fr.formation.brasserie.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.brasserie.bll.BrasserieManager;
import fr.formation.brasserie.bll.BrasserieManagerException;
import fr.formation.brasserie.bll.BrasserieManagerSing;
import fr.formation.brasserie.bo.Brasserie;

/**
 * Servlet implementation class BrasserieServlet
 */
@WebServlet("/BrasserieServlet")
public class BrasserieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BrasserieManager manager = BrasserieManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BrasserieServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BrasserieModel model = new BrasserieModel(new Brasserie(),"");

		// traitement
		if (request.getParameter("BT_DELETE") != null) {
			Long id = Long.parseLong(request.getParameter("BT_DELETE"));
			manager.deleteBy(id);
		}
		
		
		if (request.getParameter("BT_VALID") != null) {
			model.getCurrent().setNom(request.getParameter("nom"));
			model.getCurrent().setAdresse(request.getParameter("adresse"));
			model.getCurrent().setVille(request.getParameter("ville"));

			if (model.check() != null) {
				model.setErreur("ERREUR"+model.check());
			} else {
				try {
					manager.add(model.getCurrent());
				} catch (BrasserieManagerException e) {
					model.setErreur("ERREUR"+e.getMessage());
				}
			}
		}
		
		model.setLstBrasseries(manager.getAll());

		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/brasserie.jsp").forward(request, response);

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
