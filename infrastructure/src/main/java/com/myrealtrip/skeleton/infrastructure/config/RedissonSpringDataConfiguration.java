package com.myrealtrip.skeleton.infrastructure.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.codec.FstCodec;
import org.redisson.codec.KryoCodec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * ResissonSpringDataConfiguration
 *
 * @author sarasu
 * @since 2021.10.21
 */
//@Configuration
//@EnableRedisRepositories("com.myrealtrip.*")
//public class RedissonSpringDataConfiguration {
//    @Value("${myrealtrip.redis.threads}")
//    private int threads;
//
//    @Value("${myrealtrip.redis.nettyThreads}")
//    private int nettyThreads;
//
//    @Value("${myrealtrip.redis.codec}")
//    private String codecName;
//
//    @Value("${myrealtrip.redis.transportMode}")
//    private String transportMode;
//
//    @Value("${myrealtrip.redis.singleServerConfig.address}")
//    private String address;
//
//    @Value("${myrealtrip.redis.singleServerConfig.idleConnectionTimeout}")
//    private int idleConnectionTimeout;
//
//    @Value("${myrealtrip.redis.singleServerConfig.connectTimeout}")
//    private int connectTimeout;
//
//    @Value("${myrealtrip.redis.singleServerConfig.timeout}")
//    private int timeout;
//
//    @Value("${myrealtrip.redis.singleServerConfig.retryAttempts}")
//    private int retryAttempts;
//
//    @Value("${myrealtrip.redis.singleServerConfig.retryInterval}")
//    private int retryInterval;
//
//    @Value("${myrealtrip.redis.singleServerConfig.subscriptionsPerConnection}")
//    private int subscriptionsPerConnection;
//
//    @Value("${myrealtrip.redis.singleServerConfig.subscriptionConnectionMinimumIdleSize}")
//    private int subscriptionConnectionMinimumIdleSize;
//
//    @Value("${myrealtrip.redis.singleServerConfig.subscriptionConnectionPoolSize}")
//    private int subscriptionConnectionPoolSize;
//
//    @Value("${myrealtrip.redis.singleServerConfig.connectionMinimumIdleSize}")
//    private int connectionMinimumIdleSize;
//
//    @Value("${myrealtrip.redis.singleServerConfig.connectionPoolSize}")
//    private int connectionPoolSize;
//
//    @Value("${myrealtrip.redis.singleServerConfig.database}")
//    private int database;
//
//    @Value("${myrealtrip.redis.singleServerConfig.dnsMonitoringInterval}")
//    private int dnsMonitoringInterval;
//
//
//    @Bean(destroyMethod = "shutdown")
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//
//        config.setThreads(threads);
//        config.setNettyThreads(nettyThreads);
//        config.setCodec(getCodec(codecName));
//        config.setTransportMode(getTransportMode(transportMode));
//
//        config.useSingleServer()
//                .setAddress(address)
//                .setIdleConnectionTimeout(idleConnectionTimeout)
//                .setConnectTimeout(connectTimeout)
//                .setTimeout(timeout)
//                .setRetryAttempts(retryAttempts)
//                .setRetryInterval(retryInterval)
//                .setSubscriptionsPerConnection(subscriptionsPerConnection)
//                .setSubscriptionConnectionMinimumIdleSize(subscriptionConnectionMinimumIdleSize)
//                .setSubscriptionConnectionPoolSize(subscriptionConnectionPoolSize)
//                .setConnectionMinimumIdleSize(connectionMinimumIdleSize)
//                .setConnectionPoolSize(connectionPoolSize)
//                .setDatabase(database)
//                .setDnsMonitoringInterval(dnsMonitoringInterval);
//
//        return Redisson.create(config);
//    }
//
//    @Bean
//    public RedissonConnectionFactory redissonConnectionFactory(RedissonClient client) {
//        return new RedissonConnectionFactory(client);
//    }
//
//    @Primary
//    @Bean
//    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        return redisTemplate;
//    }
//
//    private Codec getCodec(String codecName) {
//        if ("FST".equalsIgnoreCase(codecName)) {
//            return new FstCodec();
//        }
//        if ("KRYO".equalsIgnoreCase(codecName)) {
//            return new KryoCodec();
//        }
//
//        return new FstCodec();
//    }
//
//    private TransportMode getTransportMode(String transportMode) {
//        if ("NIO".equalsIgnoreCase(transportMode)) {
//            return TransportMode.NIO;
//        }
//        if ("EPOLL".equalsIgnoreCase(transportMode)) {
//            return TransportMode.EPOLL;
//        }
//        if ("KQUEUE".equalsIgnoreCase(transportMode)) {
//            return TransportMode.KQUEUE;
//        }
//
//        return TransportMode.NIO;
//    }
//}
