package com.phaeljf.workshopmongo.resources;

import com.phaeljf.workshopmongo.domain.User;
import com.phaeljf.workshopmongo.dto.UserDTO;
import com.phaeljf.workshopmongo.repository.UserRepository;
import com.phaeljf.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> users = service.findAll();
        List<UserDTO> usersDTO = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTO);
    }

}
