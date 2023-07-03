package com.myrealtrip.skeleton.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JpaConfiguration
 *
 * @author sarasu
 * @since 2021.11.16
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = "com.myrealtrip.*")
@EnableJpaAuditing
public class JpaConfiguration {
}
