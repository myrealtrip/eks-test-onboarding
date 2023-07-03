package com.myrealtrip.skeleton.domain.sample.es.repository;

import com.myrealtrip.skeleton.domain.sample.es.entity.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * PostRepository
 *
 * @author sarasu
 * @since 2021.10.26
 */
public interface PostRepository extends ElasticsearchRepository<Post, String> {
    List<Post> findByTitle(String title);
}
