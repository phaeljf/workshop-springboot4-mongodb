package com.phaeljf.workshopmongo.services;

import com.phaeljf.workshopmongo.domain.Post;
import com.phaeljf.workshopmongo.repository.PostRepository;
import com.phaeljf.workshopmongo.repository.UserRepository;
import com.phaeljf.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado! Id: " + id));
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);
    }

}
