package com.myrealtrip.skeleton.domain.sample.redis.repository;

import com.myrealtrip.skeleton.domain.sample.redis.entity.RedisSampleCache;
import org.springframework.data.repository.CrudRepository;

/**
 * RedisSampleRepository
 *
 * @author sarasu
 * @since 2021.10.21
 */
public interface RedisSampleRepository extends CrudRepository<RedisSampleCache, Long> {
}
