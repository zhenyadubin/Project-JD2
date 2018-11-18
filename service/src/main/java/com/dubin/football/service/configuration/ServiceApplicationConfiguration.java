package com.dubin.football.service.configuration;

import com.dubin.football.database.configuration.DatabaseApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.dubin.football.service")
@Import(DatabaseApplicationConfiguration.class)
public class ServiceApplicationConfiguration {
}
