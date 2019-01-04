package com.ivanou4.slotgame.service;

import com.ivanou4.slotgame.to.SlotmachineDTO;

import java.util.List;

public interface SlotmachineService {
    SlotmachineDTO create(String slotmachineJson);

    void update(String slotmachineJson);

    void delete(String id);

    SlotmachineDTO get(String id);

    List<SlotmachineDTO> getAll();

    List<SlotmachineDTO> getBySlotroomId(String slotroomId);
}
