package com.ivanou4.slotgame.util;

import com.ivanou4.slotgame.model.Slotmachine;
import com.ivanou4.slotgame.model.Slotroom;
import com.ivanou4.slotgame.to.SlotmachineDTO;

public class SlotmachineMapper {
    public Slotmachine from(SlotmachineDTO slotmachineDTO) {
        Slotmachine slotmachine = new Slotmachine();
        slotmachine.setId(slotmachineDTO.getId());
        slotmachine.setModel(slotmachineDTO.getModel());
        slotmachine.setVersion(slotmachineDTO.getVersion());
        slotmachine.setFactoryNumber(slotmachineDTO.getFactoryNumber());
        slotmachine.setSkksNumber(slotmachineDTO.getSkksNumber());
        slotmachine.setSlotroomId(slotmachineDTO.getSlotroomId());
        slotmachine.setTechService(slotmachineDTO.getTechService());
        return slotmachine;
    }

    public SlotmachineDTO to(Slotmachine slotmachine, Slotroom slotroom) {
        SlotmachineDTO slotmachineDTO = new SlotmachineDTO();
        slotmachineDTO.setId(slotmachine.getId());
        slotmachineDTO.setModel(slotmachine.getModel());
        slotmachineDTO.setVersion(slotmachine.getVersion());
        slotmachineDTO.setFactoryNumber(slotmachine.getFactoryNumber());
        slotmachineDTO.setTechService(slotmachine.getTechService());
        slotmachineDTO.setSkksNumber(slotmachine.getSkksNumber());
        if (slotroom != null) {
            slotmachineDTO.setSlotroomId(slotroom.getId());
            slotmachineDTO.setSlotroomAddres(slotroom.getAddres());
        }
        return slotmachineDTO;
    }
}
