package fr.formation.exo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class exo1
 */
@WebServlet("/exo1")
public class exo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer a = Integer.parseInt(request.getParameter("a"));
		Integer b = Integer.parseInt(request.getParameter("b"));
		Integer res = null;
		switch(request.getParameter("operation")) {
		case "plus":
			res = a+b ;	
			break;
		case "moins":
			res = a-b ;
			break;
		case "div":
			res = a/b ;	
			break;
		case "fois":
			res = a*b ;		
			break;
		}
		
		request.setAttribute("resultat", res);
		request.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
		
		//reponse.getWriter().print("<h1>"+res+"</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
