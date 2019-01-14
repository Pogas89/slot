package com.ivanou4.slotgame.controller;

import com.ivanou4.slotgame.model.Slotroom;
import com.ivanou4.slotgame.to.SlotroomDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


public class SlotroomRestControllerTest extends AbstractRestControllerTest {

    @Before
    public void setUp() {
        mongoTemplate.save(createSlotroom("testId", "testName"));
        mongoTemplate.save(createSlotroom("testId2", "testName2"));
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(Slotroom.class);
    }

    @Test
    public void getAll() {
        ResponseEntity<List<SlotroomDTO>> responseEntity =
                restTemplate.exchange(createURL("/rest/slotroom"), HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<SlotroomDTO>>() {
                        });
        List<SlotroomDTO> slotroomDTOS = responseEntity.getBody();
        assertThat(slotroomDTOS.size(), is(2));
    }

    @Test
    public void get() {
        SlotroomDTO slotroomDTO =
                restTemplate.getForObject(createURL("/rest/slotroom/{id}"), SlotroomDTO.class, "testId");
        assertThat(slotroomDTO.getId(), is("testId"));
        assertThat(slotroomDTO.getAddres(), is("testAddres"));
        assertThat(slotroomDTO.getName(), is("testName"));
    }

    @Test
    public void createWithLocation() {
        HttpEntity<SlotroomDTO> request = new HttpEntity<>(dozerBeanMapper.
                map(createSlotroom(null, "testName"),SlotroomDTO.class));
        SlotroomDTO createdSlotroomDTO = restTemplate.postForObject(createURL("/rest/slotroom"),
                request, SlotroomDTO.class);
        assertThat(createdSlotroomDTO.getId(), notNullValue());
        assertThat(createdSlotroomDTO.getAddres(), is("testAddres"));
        assertThat(createdSlotroomDTO.getName(), is("testName"));
    }

    @Test
    public void update() {
        SlotroomDTO slotroomDTO = dozerBeanMapper.map(createSlotroom("testId", "newTestName"),SlotroomDTO.class);
        HttpEntity<SlotroomDTO> request = new HttpEntity<>(slotroomDTO);
        restTemplate.put(createURL("/rest/slotroom"), request, SlotroomDTO.class);
        SlotroomDTO updatedSlotroom = restTemplate.getForObject(createURL("/rest/slotroom/{id}"),
                SlotroomDTO.class, "testId");
        assertThat(updatedSlotroom.getId(), is(slotroomDTO.getId()));
        assertThat(updatedSlotroom.getName(), is(slotroomDTO.getName()));
        assertThat(updatedSlotroom.getAddres(), is(slotroomDTO.getAddres()));
    }

    @Test
    public void delete() {
        restTemplate.delete(createURL("/rest/slotroom/{id}"), "testId");
        SlotroomDTO slotroomDTO = restTemplate.getForObject(createURL("/rest/slotroom/{id}"),
                SlotroomDTO.class, "testId");
        assertNull(slotroomDTO);
    }
}