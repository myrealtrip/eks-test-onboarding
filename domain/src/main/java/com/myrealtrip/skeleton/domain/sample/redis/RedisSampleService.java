package com.myrealtrip.skeleton.domain.sample.redis;

import com.myrealtrip.skeleton.domain.sample.redis.entity.RedisSampleCache;
import com.myrealtrip.skeleton.domain.sample.redis.repository.RedisSampleRepository;
import com.myrealtrip.skeleton.infrastructure.redis.RedisAgent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * RedisSampleService
 *
 * @author sarasu
 * @since 2021.10.21
 */
//@Slf4j
//@AllArgsConstructor
//@Service
//public class RedisSampleService {
//    private RedisAgent redisAgent;
//    private RedisSampleRepository redisSampleRepository;
//
//    public void set(String key, String value) {
//        redisAgent.setValue(key, value);
//    }
//
//    public String get(String key) {
//        return redisAgent.getValue(key);
//    }
//
//    public void setRedisObject(RedisSampleCache cache) {
//        redisSampleRepository.save(cache);
//    }
//
//    public Optional<RedisSampleCache> getRedisObject(Long id) {
//        return redisSampleRepository.findById(id);
//    }
//}
