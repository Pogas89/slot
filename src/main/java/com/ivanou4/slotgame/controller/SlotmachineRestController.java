package com.ivanou4.slotgame.controller;

import com.ivanou4.slotgame.service.SlotmachineService;
import com.ivanou4.slotgame.to.SlotmachineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.ivanou4.slotgame.controller.SlotmachineRestController.REST_URL;


@RestController
@RequestMapping(REST_URL)
@CrossOrigin(origins = "http://localhost:4200")
public class SlotmachineRestController {
    static final String REST_URL = "/rest/slotmachine";

    @Autowired
    private SlotmachineService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SlotmachineDTO> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SlotmachineDTO get(@PathVariable("id") String id) {
        return service.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SlotmachineDTO> createWithLocation(@RequestBody String slotmachineJson) {
        SlotmachineDTO createdSlotmachine = service.create(slotmachineJson);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(createdSlotmachine.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(createdSlotmachine);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody String slotmachineJson) {
        service.update(slotmachineJson);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = "slotroomId")
    public List<SlotmachineDTO> getByCompanyId(@RequestParam("slotroomId") String companyId) {
        return service.getBySlotroomId(companyId);
    }
}
