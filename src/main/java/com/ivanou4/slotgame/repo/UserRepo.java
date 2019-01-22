package com.ivanou4.slotgame.repo;

import com.ivanou4.slotgame.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    Optional<User> findByUserName(String userName);

    Boolean existsByUsername(String username);

    void save(User user);

    User get(String id);

    List<User> getAll();

    void delete(String id);
}
