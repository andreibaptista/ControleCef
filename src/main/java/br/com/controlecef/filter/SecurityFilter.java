package br.com.controlecef.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlecef.model.Usuario;

@WebFilter("/seg/*")
public class SecurityFilter implements Filter {

	public static final String LOGIN_PAGE = "/login.html";
	public static final String HOME_PAGE = "/seg/index.html";


	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Usuario user = (Usuario) req.getSession().getAttribute("currentUser");
		String page = req.getRequestURI().substring(req.getContextPath().length());

		System.out.println(page);
		// autenticacao
		if (user == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(req.getContextPath() + LOGIN_PAGE);
		}/* // autorizacao
		else if (!HOME_PAGE.equals(page)
				&& !permissaoDao.hasPermition(user.getPerfil()
						.getCodigoPerfil(), page)) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}else if (user.getDataExpiracaoSenha() != null && !page.contains(ALTERA_SENHA_PAGE)) {
			if(user.getDataExpiracaoSenha().before(new Date())) {
				HttpServletResponse res = (HttpServletResponse) response;
				res.sendRedirect(req.getContextPath() + ALTERA_SENHA_PAGE);
			} else {
				chain.doFilter(request, response);
			}*/
	
			chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {

	}

}
