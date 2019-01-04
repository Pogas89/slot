package com.ivanou4.slotgame.repo;

import com.ivanou4.slotgame.model.Slotmachine;

import java.util.List;

public interface SlotmachineRepo {
    Slotmachine save(Slotmachine slotmachine);

    Slotmachine get(String id);

    List<Slotmachine> getAll();

    void delete(String id);

    List<Slotmachine> getBySlotroomId(String slotroomId);
}
