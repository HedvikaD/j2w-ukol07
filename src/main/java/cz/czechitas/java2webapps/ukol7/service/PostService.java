package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> list() {
        return postRepository.findByPublishedBeforeOrderByPublishedDesc(LocalDate.now(), PageRequest.of(0, 20));
    }

    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug).orElse(null);
    }
    public void updatePost(String slug, Post updatedPost) {
        Post post = postRepository.findBySlug(slug).orElse(null);
        if (post != null) {
            post.setTitle(updatedPost.getTitle());
            post.setPerex(updatedPost.getPerex());
            post.setBody(updatedPost.getBody());
            postRepository.save(post);
        }
    }

}
