package fr.formation.majeurMineur.ihm;

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
@WebFilter({"/MajeurServlet","/MineurServlet"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		SessionModel model = (SessionModel) ((HttpServletRequest)request).getSession().getAttribute("sessionModel");
		String servletName = ((HttpServletRequest) request).getServletPath();
		((HttpServletRequest)request).getSession().setAttribute("called", servletName);
		if(model==null) {
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
		else {
			if(model.getAge()>=18 && servletName.equals("/MajeurServlet"))
				chain.doFilter(request, response);
			else if(model.getAge()<18 && servletName.equals("/MineurServlet"))
				chain.doFilter(request, response);
			else {
				response.getWriter().print("PAGE NON AUTORISEE");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
