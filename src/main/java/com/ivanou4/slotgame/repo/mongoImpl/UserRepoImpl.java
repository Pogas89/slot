package com.ivanou4.slotgame.repo.mongoImpl;

import com.ivanou4.slotgame.model.User;
import com.ivanou4.slotgame.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepoImpl implements UserRepo {
    @Autowired
    private UserRepoMongo repository;

    @Override
    public Optional<User> findByUserName(String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User get(String id) {
        return repository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
