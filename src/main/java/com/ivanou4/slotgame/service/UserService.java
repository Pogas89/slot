package com.ivanou4.slotgame.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ivanou4.slotgame.model.User;
import com.ivanou4.slotgame.to.UserDTO;

import java.util.List;

public interface UserService {
    Boolean existsByUsername(String username);

    void save(User user);

    void updatePassword(JsonNode form);

    void resetPassword(String id);

    UserDTO get(String id);

    List<UserDTO> getAll();

    void delete(String id);
}
