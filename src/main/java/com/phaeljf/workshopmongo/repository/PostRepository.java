package com.phaeljf.workshopmongo.repository;

import com.phaeljf.workshopmongo.domain.Post;
import com.phaeljf.workshopmongo.domain.User;
import com.phaeljf.workshopmongo.dto.AuthorDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


    List<Post> findByTitleContainingIgnoreCase(String title);

}
