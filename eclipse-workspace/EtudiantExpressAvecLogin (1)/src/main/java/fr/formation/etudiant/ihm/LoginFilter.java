package fr.formation.etudiant.ihm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/EtudiantServlet")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String login = (String) ((HttpServletRequest) request).getSession().getAttribute("login");
		if(login == null) {
			String servletName = ((HttpServletRequest) request).getServletPath();
			System.out.println(servletName);
			((HttpServletRequest) request).getSession().setAttribute("called", servletName);
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
		else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}



}
