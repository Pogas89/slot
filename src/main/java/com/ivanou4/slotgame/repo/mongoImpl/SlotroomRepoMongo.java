package com.ivanou4.slotgame.repo.mongoImpl;

import com.ivanou4.slotgame.model.Slotroom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SlotroomRepoMongo extends MongoRepository<Slotroom, String> {
    Slotroom getById(String id);
}
