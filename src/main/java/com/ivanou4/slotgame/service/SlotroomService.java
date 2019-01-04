package com.ivanou4.slotgame.service;

import com.ivanou4.slotgame.to.SlotroomDTO;

import java.util.List;

public interface SlotroomService {
    SlotroomDTO create(String slotroomJson);

    void update(String slotroomJson);

    void delete(String id);

    SlotroomDTO get(String id);

    List<SlotroomDTO> getAll();
}
