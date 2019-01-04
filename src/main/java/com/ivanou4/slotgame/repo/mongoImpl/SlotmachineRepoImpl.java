package com.ivanou4.slotgame.repo.mongoImpl;

import com.ivanou4.slotgame.model.Slotmachine;
import com.ivanou4.slotgame.repo.SlotmachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SlotmachineRepoImpl implements SlotmachineRepo {
    @Autowired
    SlotmachineRepoMongo repository;

    @Override
    public Slotmachine save(Slotmachine slotmachine) {
        return repository.save(slotmachine);
    }

    @Override
    public Slotmachine get(String id) {
        return repository.getById(id);
    }

    @Override
    public List<Slotmachine> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Slotmachine> getBySlotroomId(String slotroomId) {
        return repository.getBySlotroomId(slotroomId);
    }
}
