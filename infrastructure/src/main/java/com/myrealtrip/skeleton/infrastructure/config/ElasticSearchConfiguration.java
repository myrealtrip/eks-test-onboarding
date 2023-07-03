package com.myrealtrip.skeleton.infrastructure.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * ElasticSearchConfiguration
 *
 * @author sarasu
 * @since 2021.10.26
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.myrealtrip")
public class ElasticSearchConfiguration extends AbstractElasticsearchConfiguration {
    @Value("${spring.elasticsearch.rest.uris}")
    private String esUri;

    @Override
    @Bean
    public @NotNull RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration
                .builder()
                .connectedTo(esUri)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
