package com.ivanou4.slotgame;

import com.ivanou4.slotgame.model.Role;
import com.ivanou4.slotgame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@SpringBootApplication
public class SlotgameApplication {
    @Value("${app.admin.username}")
    private String username;

    @Value("${app.admin.password}")
    private String password;

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    public void setUp() {
        if (mongoTemplate.collectionExists(User.class) && !mongoTemplate.findAll(User.class).isEmpty()) {
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        HashSet<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_ADMIN);
        roles.add(Role.ROLE_USER);
        user.setRoles(roles);
        mongoTemplate.save(user);
    }

    public static void main(String[] args) {
        SpringApplication.run(SlotgameApplication.class, args);
    }

}

