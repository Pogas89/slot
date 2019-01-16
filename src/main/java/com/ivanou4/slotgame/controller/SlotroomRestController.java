package com.ivanou4.slotgame.controller;

import com.ivanou4.slotgame.service.SlotroomService;
import com.ivanou4.slotgame.to.SlotroomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.ivanou4.slotgame.controller.SlotroomRestController.REST_URL;

@RestController
@RequestMapping(REST_URL)
@CrossOrigin(origins = "http://localhost:4200")
public class SlotroomRestController {
    static final String REST_URL = "/rest/slotroom";

    @Autowired
    private SlotroomService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<SlotroomDTO> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public SlotroomDTO get(@PathVariable("id") String id) {
        return service.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<SlotroomDTO> createWithLocation(@RequestBody String slotroomJson) {
        SlotroomDTO createdSlotroom = service.create(slotroomJson);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(createdSlotroom.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(createdSlotroom);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void update(@RequestBody String slotroomJson) {
        service.update(slotroomJson);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
