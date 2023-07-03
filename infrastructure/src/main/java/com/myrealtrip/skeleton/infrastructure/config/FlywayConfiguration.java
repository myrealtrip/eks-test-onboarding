package com.myrealtrip.skeleton.infrastructure.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * FlywayConfiguration
 *
 * @author sarasu
 * @since 2021.11.05
 */
@Configuration
public class FlywayConfiguration {
    @Bean
    public Flyway flyway(DataSource dataSource){
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();

        return flyway;
    }
}