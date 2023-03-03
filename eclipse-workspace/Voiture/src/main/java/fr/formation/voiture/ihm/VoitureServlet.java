package fr.formation.voiture.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.voiture.bll.VoitureManager;
import fr.formation.voiture.bll.VoitureManagerException;
import fr.formation.voiture.bll.VoitureSing;
import fr.formation.voiture.bo.Voiture;

/**
 * Servlet implementation class VoitureServlet
 */
@WebServlet("/VoitureServlet")
public class VoitureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoitureManager voiture = VoitureSing.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoitureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VoitureModel model = new VoitureModel(new Voiture());

		if (request.getParameter("BT_DELETE") != null) {
			Long id = Long.parseLong(request.getParameter("BT_DELETE"));
			voiture.deleteBy(id);
		}
		
		if (request.getParameter("BT_VALID") != null) {
		
			model.getCurrent().setNom( request.getParameter("nom"));
			model.getCurrent().setModele( request.getParameter("modele"));
			model.getCurrent().setMarque( request.getParameter("marque"));
			model.getCurrent().setPrix(Integer.parseInt(request.getParameter("prix")));

			
			if (model.check() != null) {
				// TODO : gérer l'erreur
				System.out.println("ERREUR"+model.check());
			} else {
				try {
					voiture.add(model.getCurrent());
				} catch (VoitureManagerException e) {
					// TODO : gérer l'exception
					System.out.println("ERREUR"+e.getMessage());
				}
			}
			

		}
		
		model.setHistorique(voiture.getAll());


		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/voiture.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
