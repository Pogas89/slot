package com.ivanou4.slotgame.repo;

import com.ivanou4.slotgame.model.Slotroom;

import java.util.List;

public interface SlotroomRepo {
    Slotroom save(Slotroom slotroom);

    Slotroom get(String id);

    List<Slotroom> getAll();

    void delete(String id);
}
