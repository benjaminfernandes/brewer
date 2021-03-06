package br.com.fernantech.brewer.config.init;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.fernantech.brewer.config.JPAConfig;
import br.com.fernantech.brewer.config.MailConfig;
import br.com.fernantech.brewer.config.S3Config;
import br.com.fernantech.brewer.config.SecurityConfig;
import br.com.fernantech.brewer.config.ServiceConfig;
import br.com.fernantech.brewer.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {JPAConfig.class, ServiceConfig.class, SecurityConfig.class, S3Config.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[] {WebConfig.class, MailConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		HttpPutFormContentFilter httpPutFormContentFilter = new HttpPutFormContentFilter();
		return new Filter[] {httpPutFormContentFilter};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) { //USADO PARA O UPLOAD AULA 14.3
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.setInitParameter("spring.profiles.default", "local");
	}

}
