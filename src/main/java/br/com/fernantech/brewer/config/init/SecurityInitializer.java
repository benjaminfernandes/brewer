package br.com.fernantech.brewer.config.init;

import java.util.EnumSet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.SessionTrackingMode;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer{

	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		
		//servletContext.getSessionCookieConfig().setMaxAge(20); // para colocar tempo de sessão por usuário
		servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));//usar os Cookies para armazenar o JSessiona ID  e evida de aparecer na URL
		
		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter",
				new CharacterEncodingFilter());
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");
		characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
		
	}
}
