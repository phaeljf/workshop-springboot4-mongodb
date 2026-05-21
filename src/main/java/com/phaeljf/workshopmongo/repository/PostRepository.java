package com.phaeljf.workshopmongo.repository;

import com.phaeljf.workshopmongo.domain.Post;
import com.phaeljf.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
