package com.dubin.football.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.dubin.football.web.servlet")
@EnableWebMvc
@Import(value = {ThymeleafConfiguration.class, InternationalizationConfiguration.class})
public class WebConfiguration {
}
