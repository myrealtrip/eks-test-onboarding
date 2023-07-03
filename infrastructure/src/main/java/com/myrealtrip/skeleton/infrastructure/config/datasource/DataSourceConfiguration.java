package com.myrealtrip.skeleton.infrastructure.config.datasource;

import com.myrealtrip.cipher.CipherDecryptor;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * DatasourceConfiguration
 *
 * @author sarasu
 * @since 2021.11.09
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {
    @Value("${spring.config.activate.on-profile}")
    private String profile;

    @Value("${spring.datasource.readWrite.jdbc-url}")
    private String readWriteJdbcUrl;

    @Value("${spring.datasource.readWrite.username}")
    private String readWriteDbUser;

    @Value("${spring.datasource.readWrite.password}")
    private String readWriteDbPassword;

    @Value("${spring.datasource.readOnly.jdbc-url}")
    private String readOnlyJdbcUrl;

    @Value("${spring.datasource.readOnly.username}")
    private String readOnlyDbUser;

    @Value("${spring.datasource.readOnly.password}")
    private String readOnlyDbPassword;

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private String showSql;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private String formatSql;

    @Value("${myrealtrip.base-package}")
    private String basePackage;

    @Bean(destroyMethod = "close")
    public HikariDataSource readWriteDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .url(CipherDecryptor.decrypt(profile, readWriteJdbcUrl))
                .username(CipherDecryptor.decrypt(profile, readWriteDbUser))
                .password(CipherDecryptor.decrypt(profile, readWriteDbPassword))
                .build();
    }

    @Bean(destroyMethod = "close")
    public HikariDataSource readOnlyDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .url(CipherDecryptor.decrypt(profile, readOnlyJdbcUrl))
                .username(CipherDecryptor.decrypt(profile, readOnlyDbUser))
                .password(CipherDecryptor.decrypt(profile, readOnlyDbPassword))
                .build();
    }

    @Bean
    public TransactionRoutingDataSource routingDataSource(@Qualifier("readWriteDataSource") DataSource readWriteDataSource, @Qualifier("readOnlyDataSource") DataSource readOnlyDataSource) {
        TransactionRoutingDataSource transactionRoutingDataSource = new TransactionRoutingDataSource();

        Map<Object, Object> dataSourceMap = new HashMap<>();

        dataSourceMap.put(TransactionType.READ_ONLY, readOnlyDataSource);
        dataSourceMap.put(TransactionType.READ_WRITE, readWriteDataSource);

        transactionRoutingDataSource.setTargetDataSources(dataSourceMap);

        return transactionRoutingDataSource;
    }

    @Bean
    public DataSource dataSource(TransactionRoutingDataSource dataSource) {
        return  new LazyConnectionDataSourceProxy(dataSource);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(basePackage);

        Properties jpaProperties = new Properties();

        jpaProperties.put("hibernate.show_sql", showSql);
        jpaProperties.put("hibernate.format_sql", formatSql);

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
