package com.ivanou4.slotgame.repo.mongoImpl;

import com.ivanou4.slotgame.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepoMongo  extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    User save(User user);

    User getById(String id);
}
