package com.ivanou4.slotgame.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivanou4.slotgame.model.Slotroom;
import com.ivanou4.slotgame.repo.SlotroomRepo;
import com.ivanou4.slotgame.to.SlotroomDTO;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SlotroomServiceImplTest {
    private static final String SLOTROOM1_ID = "Slotroom1TestId";
    private static final String SLOTROOM2_ID = "Slotroom2TestId";
    private Mapper dozzerMapper = new DozerBeanMapper();
    private ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private SlotroomServiceImpl service;

    @Mock
    private SlotroomRepo repo;

    @Test
    public void create() throws JsonProcessingException {
        Slotroom slotroom = createSlotroom(SLOTROOM1_ID);
        when(repo.save(any(Slotroom.class))).thenReturn(slotroom);
        SlotroomDTO slotroomDTO = service.create(objectMapper.writeValueAsString(slotroom));
        assertThat(dozzerMapper.map(slotroom, SlotroomDTO.class)).isEqualTo(slotroomDTO);
        verify(repo).save(slotroom);
    }

    @Test
    public void update() throws JsonProcessingException {
        Slotroom slotroom = createSlotroom(SLOTROOM1_ID);
        when(repo.save(any(Slotroom.class))).thenReturn(slotroom);
        service.update(objectMapper.writeValueAsString(slotroom));
        verify(repo).save(slotroom);
    }

    @Test
    public void delete() {
        doNothing().when(repo).delete(anyString());
        service.delete(SLOTROOM2_ID);
        verify(repo).delete(SLOTROOM2_ID);
    }

    @Test
    public void get() {
        Slotroom slotroom = createSlotroom(SLOTROOM1_ID);
        when(repo.get(anyString())).thenReturn(slotroom);
        SlotroomDTO slotroomDTO = service.get(SLOTROOM1_ID);
        assertThat(dozzerMapper.map(slotroom, SlotroomDTO.class)).isEqualTo(slotroomDTO);
        verify(repo).get(SLOTROOM1_ID);
    }

    @Test
    public void getAll() {
        Slotroom firstCreatedSlotroom = createSlotroom(SLOTROOM1_ID);
        Slotroom secondCreatedSlotroom = createSlotroom(SLOTROOM2_ID);
        when(repo.getAll()).thenReturn(Arrays.asList(firstCreatedSlotroom, secondCreatedSlotroom));
        List<SlotroomDTO> slotroomDTOS = service.getAll();
        assertThat(slotroomDTOS).isEqualTo(Arrays.asList(
                dozzerMapper.map(firstCreatedSlotroom, SlotroomDTO.class),
                dozzerMapper.map(secondCreatedSlotroom, SlotroomDTO.class)
        ));
        verify(repo).getAll();
    }

    private Slotroom createSlotroom(String id) {
        Slotroom slotroom = new Slotroom();
        slotroom.setId(id);
        slotroom.setName("TestName");
        slotroom.setAddres("TestAddres");
        return slotroom;
    }
}