package com.ivanou4.slotgame.controller;

import com.ivanou4.slotgame.SlotgameApplication;
import com.ivanou4.slotgame.model.Slotroom;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SlotgameApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AbstractRestControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    protected MongoTemplate mongoTemplate;

    protected TestRestTemplate restTemplate = new TestRestTemplate();

    protected Mapper dozerBeanMapper = new DozerBeanMapper();

    public String createURL(String uri) {
        return "http://localhost:" + port + uri;
    }

    Slotroom createSlotroom(String id, String name) {
        Slotroom slotroom = new Slotroom();
        slotroom.setId(id);
        slotroom.setName(name);
        slotroom.setAddres("testAddres");
        return slotroom;
    }
}
