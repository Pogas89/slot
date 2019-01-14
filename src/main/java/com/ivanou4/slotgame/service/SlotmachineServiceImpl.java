package com.ivanou4.slotgame.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivanou4.slotgame.exception.SlotmachineException;
import com.ivanou4.slotgame.model.Slotmachine;
import com.ivanou4.slotgame.model.Slotroom;
import com.ivanou4.slotgame.repo.SlotmachineRepo;
import com.ivanou4.slotgame.repo.SlotroomRepo;
import com.ivanou4.slotgame.to.SlotmachineDTO;
import com.ivanou4.slotgame.util.SlotmachineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SlotmachineServiceImpl implements SlotmachineService {
    @Autowired
    private SlotroomRepo slotroomRepo;

    @Autowired
    private SlotmachineRepo slotmachineRepo;

    private SlotmachineMapper slotmachineMapper = new SlotmachineMapper();

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public SlotmachineDTO create(String slotmachineJson) {
        Slotmachine slotmachine = slotmachineMapper.from(convertFrom(slotmachineJson));
        Slotmachine createdSlotmachine = slotmachineRepo.save(slotmachine);
        return slotmachineMapper.to(createdSlotmachine, slotroomRepo.get(createdSlotmachine.getSlotroomId()));
    }

    @Override
    public void update(String slotmachineJson) {
        Slotmachine slotmachine = slotmachineMapper.from(convertFrom(slotmachineJson));
        slotmachineRepo.save(slotmachine);
    }

    @Override
    public void delete(String id) {
        slotmachineRepo.delete(id);
    }

    @Override
    public SlotmachineDTO get(String id) {
        Slotmachine slotmachine = slotmachineRepo.get(id);
        if (slotmachine==null){
            return null;
        }
        Slotroom slotroom = slotroomRepo.get(slotmachine.getSlotroomId());
        return slotmachineMapper.to(slotmachine, slotroom);
    }

    @Override
    public List<SlotmachineDTO> getAll() {
        List<SlotmachineDTO> slotmachineDTOS = new ArrayList<>();
        List<Slotmachine> slotmachines = slotmachineRepo.getAll();
        if (slotmachines.isEmpty()) {
            return null;
        }
        for (Slotmachine slotmachine : slotmachines) {
            Slotroom slotroom = slotroomRepo.get(slotmachine.getSlotroomId());
            slotmachineDTOS.add(slotmachineMapper.to(slotmachine, slotroom));
        }
        return slotmachineDTOS;
    }

    @Override
    public List<SlotmachineDTO> getBySlotroomId(String slotroomId) {
        List<SlotmachineDTO> slotmachineDTOS = new ArrayList<>();
        List<Slotmachine> slotmachines = slotmachineRepo.getBySlotroomId(slotroomId);
        if (slotmachines.isEmpty()) {
            return null;
        }
        for (Slotmachine slotmachine : slotmachines) {
            Slotroom slotroom = slotroomRepo.get(slotmachine.getSlotroomId());
            slotmachineDTOS.add(slotmachineMapper.to(slotmachine, slotroom));
        }
        return slotmachineDTOS;
    }

    private SlotmachineDTO convertFrom(String json) {
        SlotmachineDTO slotmachineDTO;
        try {
            slotmachineDTO = objectMapper.readValue(json, SlotmachineDTO.class);
            return slotmachineDTO;
        } catch (IOException e) {
            throw new SlotmachineException("Bad or incomplete data");
        }
    }
}
