package com.ivanou4.slotgame.controller;

import com.ivanou4.slotgame.model.Slotmachine;
import com.ivanou4.slotgame.model.Slotroom;
import com.ivanou4.slotgame.to.SlotmachineDTO;
import com.ivanou4.slotgame.util.SlotmachineMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class SlotmachineRestControllerTest extends AbstractRestControllerTest {
    private SlotmachineMapper slotmachineMapper = new SlotmachineMapper();

    @Before
    public void setUp() {
        mongoTemplate.save(createSlotmachine("testId", "testModel"));
        mongoTemplate.save(createSlotmachine("testId2", "testModel2"));
        mongoTemplate.save(createSlotroom("testSlotroomId", "testName"));
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(Slotmachine.class);
        mongoTemplate.dropCollection(Slotroom.class);
    }

    @Test
    public void getAll() {
        ResponseEntity<List<SlotmachineDTO>> responseEntity =
                restTemplate.exchange(createURL("/rest/slotmachine"), HttpMethod.GET, entity,
                        new ParameterizedTypeReference<List<SlotmachineDTO>>() {
                        });
        List<SlotmachineDTO> slotmachineDTOS = responseEntity.getBody();
        assertThat(slotmachineDTOS.size(), is(2));
    }

    @Test
    public void get() {
        ResponseEntity<SlotmachineDTO> responseEntity = restTemplate.exchange(createURL("/rest/slotmachine/{id}"), HttpMethod.GET, entity,
                SlotmachineDTO.class, "testId");
        SlotmachineDTO slotmachineDTO = responseEntity.getBody();
        assertThat(slotmachineDTO.getId(), is("testId"));
        assertThat(slotmachineDTO.getModel(), is("testModel"));
        assertThat(slotmachineDTO.getVersion(), is("testVersion"));
        assertThat(slotmachineDTO.getFactoryNumber(), is("testFactoryNumber"));
        assertThat(slotmachineDTO.getTechService(), is(true));
        assertThat(slotmachineDTO.getSkksNumber(), is(111111));
        assertThat(slotmachineDTO.getSlotroomId(), is("testSlotroomId"));
        assertThat(slotmachineDTO.getSlotroomAddres(), is("testAddres"));
    }

    @Test
    public void createWithLocation() {
        HttpEntity<SlotmachineDTO> request = new HttpEntity<>(slotmachineMapper.to(
                createSlotmachine(null, "testModel"),
                createSlotroom("testSlotroomId", "testName")
                ),headers);
        SlotmachineDTO slotmachineDTO = restTemplate.postForObject(createURL("/rest/slotmachine"),
                request, SlotmachineDTO.class);
        assertThat(slotmachineDTO.getId(), notNullValue());
        assertThat(slotmachineDTO.getModel(), is("testModel"));
        assertThat(slotmachineDTO.getVersion(), is("testVersion"));
        assertThat(slotmachineDTO.getFactoryNumber(), is("testFactoryNumber"));
        assertThat(slotmachineDTO.getTechService(), is(true));
        assertThat(slotmachineDTO.getSkksNumber(), is(111111));
        assertThat(slotmachineDTO.getSlotroomId(), is("testSlotroomId"));
        assertThat(slotmachineDTO.getSlotroomAddres(), is("testAddres"));
    }

    @Test
    public void update() {
        HttpEntity<SlotmachineDTO> request = new HttpEntity<>(slotmachineMapper.to(
                createSlotmachine(null, "testModel"),
                createSlotroom("testSlotroomId", "testName")),headers);
        SlotmachineDTO slotmachineDTO = restTemplate.postForObject(createURL("/rest/slotmachine"),
                request, SlotmachineDTO.class);
        assertThat(slotmachineDTO.getId(), notNullValue());
        assertThat(slotmachineDTO.getModel(), is("testModel"));
        assertThat(slotmachineDTO.getVersion(), is("testVersion"));
        assertThat(slotmachineDTO.getFactoryNumber(), is("testFactoryNumber"));
        assertThat(slotmachineDTO.getTechService(), is(true));
        assertThat(slotmachineDTO.getSkksNumber(), is(111111));
        assertThat(slotmachineDTO.getSlotroomId(), is("testSlotroomId"));
        assertThat(slotmachineDTO.getSlotroomAddres(), is("testAddres"));
    }

    @Test
    public void delete() {
        restTemplate.exchange(createURL("/rest/slotmachine/{id}"), HttpMethod.DELETE, entity,
                SlotmachineDTO.class, "testId");
        ResponseEntity<SlotmachineDTO> responseEntity = restTemplate.exchange(createURL("/rest/slotmachine/{id}"), HttpMethod.GET, entity,
                SlotmachineDTO.class, "testId");
        SlotmachineDTO slotmachineDTO = responseEntity.getBody();
        assertNull(slotmachineDTO);
    }

    @Test
    public void getByCompanyId() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURL("/rest/slotmachine"))
                .queryParam("slotroomId", "testSlotroomId");
        ResponseEntity<List<SlotmachineDTO>> responseEntity =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                        new ParameterizedTypeReference<List<SlotmachineDTO>>() {
                        });
        List<SlotmachineDTO> slotmachineDTOS = responseEntity.getBody();
        assertThat(slotmachineDTOS.size(), is(2));
    }

    private Slotmachine createSlotmachine(String testId, String testModel) {
        Slotmachine slotmachine = new Slotmachine();
        slotmachine.setId(testId);
        slotmachine.setModel(testModel);
        slotmachine.setVersion("testVersion");
        slotmachine.setFactoryNumber("testFactoryNumber");
        slotmachine.setTechService(true);
        slotmachine.setSkksNumber(111111);
        slotmachine.setSlotroomId("testSlotroomId");
        return slotmachine;
    }
}