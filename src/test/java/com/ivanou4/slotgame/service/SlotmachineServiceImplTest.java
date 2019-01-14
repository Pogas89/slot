package com.ivanou4.slotgame.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivanou4.slotgame.model.Slotmachine;
import com.ivanou4.slotgame.model.Slotroom;
import com.ivanou4.slotgame.repo.SlotmachineRepo;
import com.ivanou4.slotgame.repo.SlotroomRepo;
import com.ivanou4.slotgame.to.SlotmachineDTO;
import com.ivanou4.slotgame.util.SlotmachineMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SlotmachineServiceImplTest {
    private static final String SLOTMACHINE1_ID = "Slotmachine1TestId";
    private static final String SLOTMACHINE2_ID = "Slotmachine2TestId";
    private static final String SLOTROOM1_ID = "Slotroom1TestId";
    private ObjectMapper objectMapper = new ObjectMapper();
    private SlotmachineMapper slotmachineMapper = new SlotmachineMapper();

    @InjectMocks
    private SlotmachineServiceImpl service;

    @Mock
    private SlotroomRepo slotroomRepo;

    @Mock
    private SlotmachineRepo slotmachineRepo;

    @Test
    public void create() throws JsonProcessingException {
        Slotmachine createdSlotmachine = createSlotmachine(SLOTMACHINE1_ID);
        Slotroom slotroom = createSlotroom(SLOTROOM1_ID);
        SlotmachineDTO createdSlotmachineDTO = slotmachineMapper.to(createdSlotmachine,slotroom);
        when(slotmachineRepo.save(any(Slotmachine.class))).thenReturn(createdSlotmachine);
        when(slotroomRepo.get(SLOTROOM1_ID)).thenReturn(slotroom);
        SlotmachineDTO slotmachineDTO = service.create(objectMapper.writeValueAsString(createdSlotmachine));
        assertThat(slotmachineDTO).isEqualTo(createdSlotmachineDTO);
        verify(slotmachineRepo).save(createdSlotmachine);
        verify(slotroomRepo).get(SLOTROOM1_ID);
    }

    @Test
    public void update() throws JsonProcessingException {
        Slotmachine createdSlotmachine = createSlotmachine(SLOTMACHINE1_ID);
        Slotroom slotroom = createSlotroom(SLOTROOM1_ID);
        SlotmachineDTO createdSlotmachineDTO = slotmachineMapper.to(createdSlotmachine,slotroom);
        when(slotmachineRepo.save(any(Slotmachine.class))).thenReturn(createdSlotmachine);
        when(slotroomRepo.get(SLOTROOM1_ID)).thenReturn(slotroom);
        service.create(objectMapper.writeValueAsString(createdSlotmachine));
        verify(slotmachineRepo).save(createdSlotmachine);
        verify(slotroomRepo).get(SLOTROOM1_ID);
    }

    @Test
    public void delete() {
        doNothing().when(slotmachineRepo).delete(anyString());
        service.delete(SLOTMACHINE2_ID);
        verify(slotmachineRepo).delete(SLOTMACHINE2_ID);
    }

    @Test
    public void get() {
        Slotmachine createdSlotmachine = createSlotmachine(SLOTMACHINE1_ID);
        Slotroom slotroom = createSlotroom(SLOTROOM1_ID);
        SlotmachineDTO createdSlotmachineDTO = slotmachineMapper.to(createdSlotmachine,slotroom);
        when(slotmachineRepo.get(SLOTMACHINE1_ID)).thenReturn(createdSlotmachine);
        when(slotroomRepo.get(SLOTROOM1_ID)).thenReturn(slotroom);
        SlotmachineDTO slotmachineDTO = service.get(SLOTMACHINE1_ID);
        assertThat(slotmachineDTO).isEqualTo(createdSlotmachineDTO);
        verify(slotmachineRepo).get(SLOTMACHINE1_ID);
        verify(slotroomRepo).get(SLOTROOM1_ID);
    }

    @Test
    public void getAll() {
        Slotmachine firstCreatedSlotmachine = createSlotmachine(SLOTMACHINE1_ID);
        Slotmachine secondCreatedSlotmachine = createSlotmachine(SLOTMACHINE1_ID);
        Slotroom slotroom = createSlotroom(SLOTROOM1_ID);
        SlotmachineDTO createdSlotmachineDTO1 = slotmachineMapper.to(firstCreatedSlotmachine,slotroom);
        SlotmachineDTO createdSlotmachineDTO2 = slotmachineMapper.to(secondCreatedSlotmachine,slotroom);
        when(slotmachineRepo.getAll()).thenReturn(Arrays.asList(firstCreatedSlotmachine,secondCreatedSlotmachine));
        when(slotroomRepo.get(SLOTROOM1_ID)).thenReturn(slotroom);
        List<SlotmachineDTO> slotmachineDTOS = service.getAll();
        assertThat(slotmachineDTOS).isEqualTo(Arrays.asList(createdSlotmachineDTO1,createdSlotmachineDTO2));
        verify(slotmachineRepo).getAll();
        verify(slotroomRepo, times(2)).get(SLOTROOM1_ID);
    }

    @Test
    public void getBySlotroomId() {
        Slotmachine firstCreatedSlotmachine = createSlotmachine(SLOTMACHINE1_ID);
        Slotmachine secondCreatedSlotmachine = createSlotmachine(SLOTMACHINE1_ID);
        Slotroom slotroom = createSlotroom(SLOTROOM1_ID);
        SlotmachineDTO createdSlotmachineDTO1 = slotmachineMapper.to(firstCreatedSlotmachine,slotroom);
        SlotmachineDTO createdSlotmachineDTO2 = slotmachineMapper.to(secondCreatedSlotmachine,slotroom);
        when(slotmachineRepo.getBySlotroomId(SLOTROOM1_ID)).thenReturn(Arrays.asList(firstCreatedSlotmachine,secondCreatedSlotmachine));
        when(slotroomRepo.get(SLOTROOM1_ID)).thenReturn(slotroom);
        List<SlotmachineDTO> slotmachineDTOS = service.getBySlotroomId(SLOTROOM1_ID);
        assertThat(slotmachineDTOS).isEqualTo(Arrays.asList(createdSlotmachineDTO1,createdSlotmachineDTO2));
        verify(slotmachineRepo).getBySlotroomId(SLOTROOM1_ID);
        verify(slotroomRepo, times(2)).get(SLOTROOM1_ID);
    }

    private Slotmachine createSlotmachine(String slotmachine1Id) {
        Slotmachine slotmachine = new Slotmachine();
        slotmachine.setId(slotmachine1Id);
        slotmachine.setModel("testModel");
        slotmachine.setVersion("testVersion");
        slotmachine.setFactoryNumber("testFactoryNumber");
        slotmachine.setTechService(true);
        slotmachine.setSkksNumber(111111);
        slotmachine.setSlotroomId(SLOTROOM1_ID);
        return slotmachine;
    }

    private Slotroom createSlotroom(String slotroom1Id) {
        Slotroom slotroom = new Slotroom();
        slotroom.setId(slotroom1Id);
        slotroom.setName("testName");
        slotroom.setAddres("testAdress");

        return slotroom;
    }
}