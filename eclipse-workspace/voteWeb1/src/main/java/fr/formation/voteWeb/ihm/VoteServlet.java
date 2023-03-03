package fr.formation.voteWeb.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.voteWeb.bll.VoteManager;
import fr.formation.voteWeb.bll.VoteManagerSing;
import fr.formation.voteWeb.bo.Votant;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private VoteManager manager = VoteManagerSing.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Votant votant = new Votant( "", "", LocalDate.now(), "FRANCAIS");
		String message = "";
		
		// TRAITEMENT
		if(request.getParameter("BT_VALID")!=null) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			LocalDate ddn = LocalDate.parse(request.getParameter("ddn"));
			String nationalite = request.getParameter("nationalite");
			votant = new Votant(nom,prenom,ddn,nationalite);
			boolean res = manager.peutVoter(votant);
		
			if(res) {
				message="tu peux voter !!";
			}
			else {
				message="tu ne peux pas voter !!";
			}
		}
		
		
		request.setAttribute("votant", votant);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/vote.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
