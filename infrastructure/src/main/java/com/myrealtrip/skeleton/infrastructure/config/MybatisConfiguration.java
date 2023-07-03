package com.myrealtrip.skeleton.infrastructure.config;

import com.myrealtrip.cipher.CipherDecryptor;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * MybatisConfiguration
 *
 * @author sarasu
 * @since 2021.10.28
 */
@RequiredArgsConstructor
@Configuration
@MapperScan("com.myrealtrip.skeleton.domain.sample.mybatis")
public class MybatisConfiguration {
    @Value("${spring.config.activate.on-profile}")
    private String profile;

    @Value("${spring.datasource.readWrite.jdbc-url}")
    private String readWriteJdbcUrl;

    @Value("${spring.datasource.readWrite.username}")
    private String readWriteDbUser;

    @Value("${spring.datasource.readWrite.password}")
    private String readWriteDbPassword;

    @Bean(destroyMethod = "close", name = "mybatisMasterDataSource")
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .url(CipherDecryptor.decrypt(profile, readWriteJdbcUrl))
                .username(CipherDecryptor.decrypt(profile, readWriteDbUser))
                .password(CipherDecryptor.decrypt(profile, readWriteDbPassword))
                .build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("mybatisMasterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
