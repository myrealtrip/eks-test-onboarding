package com.myrealtrip.skeleton.infrastructure.redis;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * RedisAgent
 *
 * @author sarasu
 * @since 2021.10.21
 */
@Component
@RequiredArgsConstructor
public class RedisAgent {
    private RedisTemplate redisTemplate;

    public <K, V> void setValue(K key, V value) {
        getValueOperations().set(key, value);
    }

    public <T extends Object> T getValue(T key) {
        return (T) getValueOperations().get(key);
    }

    @NotNull
    private ValueOperations getValueOperations() {
        return redisTemplate.opsForValue();
    }
}
