package com.dubin.football.web;

import com.dubin.football.service.configuration.ServiceApplicationConfiguration;
import com.dubin.football.web.configuration.SecurityConfiguration;
import com.dubin.football.web.configuration.WebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String SERVLET_MAPPING = "/";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ServiceApplicationConfiguration.class, SecurityConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {SERVLET_MAPPING};
    }
}
