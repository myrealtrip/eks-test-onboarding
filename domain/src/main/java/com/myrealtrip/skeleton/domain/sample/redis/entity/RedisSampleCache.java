package com.myrealtrip.skeleton.domain.sample.redis.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * RedisSampleCache
 *
 * @author sarasu
 * @since 2021.10.21
 */
@RedisHash(value = "redisSample")
@Getter
@ToString
public class RedisSampleCache implements Serializable {
    @Id
    private Long id;
    private String data;

    public RedisSampleCache(Long id, String data){
        this.id = id;
        this.data = data;
    }

    public RedisSampleCache() {

    }
}
