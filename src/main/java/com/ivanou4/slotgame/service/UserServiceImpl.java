package com.ivanou4.slotgame.service;

import com.ivanou4.slotgame.model.User;
import com.ivanou4.slotgame.repo.UserRepo;
import com.ivanou4.slotgame.to.UserDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;

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
    public void updatePassword(String pass, String id) {
        User user = repo.get(id);
        user.setPassword(pass);
        repo.save(user);
    }

    @Override
    public void resetPassword(String username) {
        User user = repo.findByUserName(username).get();
        user.setPassword("password");
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
