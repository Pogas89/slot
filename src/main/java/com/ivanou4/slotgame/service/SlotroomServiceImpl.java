package com.ivanou4.slotgame.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivanou4.slotgame.exception.SlotmachineException;
import com.ivanou4.slotgame.model.Slotroom;
import com.ivanou4.slotgame.repo.SlotroomRepo;
import com.ivanou4.slotgame.to.SlotroomDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SlotroomServiceImpl implements SlotroomService {
    @Autowired
    private SlotroomRepo repo;

    private Mapper dozzerMapper = new DozerBeanMapper();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SlotroomDTO create(String slotroomJson) {
        Slotroom slotroom = repo.save(dozzerMapper.map(convertFrom(slotroomJson), Slotroom.class));
        return dozzerMapper.map(slotroom, SlotroomDTO.class);
    }

    @Override
    public void update(String slotroomJson) {
        repo.save(dozzerMapper.map(convertFrom(slotroomJson), Slotroom.class));
    }

    @Override
    public void delete(String id) {
        repo.delete(id);
    }

    @Override
    public SlotroomDTO get(String id) {
        Slotroom slotroom = repo.get(id);
        if (slotroom != null) {
            return dozzerMapper.map(slotroom, SlotroomDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<SlotroomDTO> getAll() {
        List<Slotroom> companies = repo.getAll();
        if (companies.isEmpty()){
            return null;
        }
        List<SlotroomDTO> companiesDTO = new ArrayList<>();
        for (Slotroom company : companies) {
            companiesDTO.add(dozzerMapper.map(company, SlotroomDTO.class));
        }
        return companiesDTO;
    }

    private SlotroomDTO convertFrom(String json) {
        SlotroomDTO slotroomDTO;
        try{
            slotroomDTO = objectMapper.readValue(json, SlotroomDTO.class);
            return slotroomDTO;
        } catch (IOException e) {
            throw new SlotmachineException("Bad or incomplete data");
        }
    }
}
