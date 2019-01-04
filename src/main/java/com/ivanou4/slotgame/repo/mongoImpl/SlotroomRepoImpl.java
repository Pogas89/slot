package com.ivanou4.slotgame.repo.mongoImpl;

import com.ivanou4.slotgame.model.Slotroom;
import com.ivanou4.slotgame.repo.SlotroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SlotroomRepoImpl implements SlotroomRepo {
    @Autowired
    private SlotroomRepoMongo repository;

    @Override
    public Slotroom save(Slotroom slotroom) {
        return repository.save(slotroom);
    }

    @Override
    public Slotroom get(String id) {
        return repository.getById(id);
    }

    @Override
    public List<Slotroom> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
