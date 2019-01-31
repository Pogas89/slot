package com.ivanou4.slotgame.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ivanou4.slotgame.model.User;
import com.ivanou4.slotgame.repo.UserRepo;
import com.ivanou4.slotgame.to.UserDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    private Mapper dozzerMapper = new DozerBeanMapper();

    @Override
    public Boolean existsByUsername(String username) {
        return repo.existsByUsername(username);
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public void updatePassword(JsonNode form) {
        String pass = form.get(0).asText();
        String username = form.get(1).asText();
        User user = repo.findByUserName(username).get();
        user.setPassword(encoder.encode(pass));
        repo.save(user);
    }

    @Override
    public void resetPassword(String id) {
        User user = repo.get(id);
        user.setPassword(encoder.encode("password"));
        repo.save(user);
    }

    @Override
    public UserDTO get(String id) {
        User user = repo.get(id);
        if (user != null) {
            return dozzerMapper.map(user, UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = repo.getAll();
        if (users.isEmpty()) {
            return null;
        }
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(dozzerMapper.map(user, UserDTO.class));
        }
        return userDTOS;
    }

    @Override
    public void delete(String id) {
        repo.delete(id);
    }
}
