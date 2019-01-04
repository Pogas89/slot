package com.ivanou4.slotgame.repo.mongoImpl;

import com.ivanou4.slotgame.model.Slotmachine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SlotmachineRepoMongo extends MongoRepository<Slotmachine, String> {
    Slotmachine getById(String id);

    List<Slotmachine> getBySlotroomId(String slotroomId);
}
