package com.phaeljf.workshopmongo.services;

import com.phaeljf.workshopmongo.domain.User;
import com.phaeljf.workshopmongo.dto.UserDTO;
import com.phaeljf.workshopmongo.repository.UserRepository;
import com.phaeljf.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado! Id: " + id));
       // poderia retornar tb
       // repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
        repository.deleteById(id);
    }

    public User update(User user) {
        User updatedUser = findById(user.getId());
        updateData(updatedUser, user);
        return repository.save(updatedUser);
    }

    private void updateData(User updatedUser, User user) {
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
    }


    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }


}
