package com.myrealtrip.skeleton.domain.sample.es;

import com.myrealtrip.skeleton.domain.sample.es.entity.Post;
import com.myrealtrip.skeleton.domain.sample.es.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ElasticsearchSampleService
 *
 * @author sarasu
 * @since 2021.10.26
 */
@AllArgsConstructor
@Service
public class ElasticsearchSampleService {
    private PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> findById(String id) {
        return postRepository.findById(id);
    }

    public List<Post> findByTitle(String title){
        return postRepository.findByTitle(title);
    }

    public void delete(Post post){
        postRepository.delete(post);
    }
}
