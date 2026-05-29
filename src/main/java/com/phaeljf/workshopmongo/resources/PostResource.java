package com.phaeljf.workshopmongo.resources;


import com.phaeljf.workshopmongo.domain.Post;
import com.phaeljf.workshopmongo.domain.User;
import com.phaeljf.workshopmongo.dto.UserDTO;
import com.phaeljf.workshopmongo.repository.PostRepository;
import com.phaeljf.workshopmongo.resources.util.URL;
import com.phaeljf.workshopmongo.services.PostService;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParm(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
