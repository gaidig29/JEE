package fr.formation.etudiant.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.etudiant.bll.EtudiantManager;
import fr.formation.etudiant.bll.EtudiantManagerSing;
import fr.formation.etudiant.bo.Etudiant;

/**
 * Servlet implementation class EtudiantServlet
 */
@WebServlet("/EtudiantServlet")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtudiantManager manager = EtudiantManagerSing.getInstance();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EtudiantServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EtudiantModel model = new EtudiantModel(0.0, null, null);
		
		//  Initialisation de la  session
		if(request.getSession().getAttribute("lstSession")==null) {
			request.getSession().setAttribute("lstSession", new ArrayList<>());
		}
		List<Etudiant> lstSession = (List<Etudiant>) request.getSession().getAttribute("lstSession");
		

		if (request.getParameter("BT_VALID") != null) {
			Etudiant e = new Etudiant(
					request.getParameter("nom"),
					request.getParameter("prenom"),
					Double.parseDouble(request.getParameter("note"))
					);
			manager.add(e);
			
			// ajout de l'étudiant dans la liste des étudiants de la session
			lstSession.add(e);
		}
		model.setLstEtudiants(manager.getAll());
		model.setLstRattrapage(manager.getRattrapage());
		model.setMeilleur(manager.getMeilleur());
		model.setMoinsBon(manager.getMoinsBon());
		model.setMoyenne(manager.getMoyenne());
		
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/etudiant.jsp").forward(request, response);

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
