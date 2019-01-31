package com.ivanou4.slotgame.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.ivanou4.slotgame.service.UserService;
import com.ivanou4.slotgame.to.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ivanou4.slotgame.controller.UserRestController.REST_URL;

@RestController
@RequestMapping(REST_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserRestController {
    static final String REST_URL = "/rest/user";

    @Autowired
    private UserService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserDTO get(@PathVariable("id") String id) {
        return service.get(id);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void updatePassword(@RequestBody JsonNode form) {
        service.updatePassword(form);
    }

    @GetMapping(path = "/reset/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void resetPassword(@PathVariable("id") String id) {
        service.resetPassword(id);
    }
}
