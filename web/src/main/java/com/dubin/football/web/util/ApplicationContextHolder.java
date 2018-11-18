package com.dubin.football.web.util;

import com.dubin.football.service.configuration.ServiceApplicationConfiguration;
import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@UtilityClass
public class ApplicationContextHolder {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceApplicationConfiguration.class);

    public AnnotationConfigApplicationContext getContext() {
        return context;
    }
}
