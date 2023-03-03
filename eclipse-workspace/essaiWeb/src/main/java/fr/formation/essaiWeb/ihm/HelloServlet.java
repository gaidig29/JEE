package fr.formation.essaiWeb.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("BT_CALC") != null) {
			String nomFamille ="nomFamille";
			Integer age = Integer.parseInt(request.getParameter("age"));
			String nationalite =request.getParameter("nationalite ");
			String sexe =request.getParameter("sexe");
			Integer res = age-18;
			String resTxt;

			if((res>=0)&&(nationalite.equals("France"))&&(sexe.equals("Feminin"))) {
				resTxt = "Vous pouvez voter";
			}else {	
				resTxt = "Vous ne pouvez pas voter";
			}

			request.setAttribute("resultat", resTxt);
		}
		request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
