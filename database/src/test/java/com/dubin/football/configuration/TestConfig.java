package com.dubin.football.configuration;

import com.dubin.football.database.configuration.DatabaseApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DatabaseApplicationConfiguration.class)
public class TestConfig {
}
