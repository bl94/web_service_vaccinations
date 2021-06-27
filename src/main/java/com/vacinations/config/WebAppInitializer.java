package com.vacinations.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	public WebAppInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{DemoSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
