package com.ivanou4.slotgame.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ivanou4.slotgame.model.Role;
import com.ivanou4.slotgame.model.User;
import com.ivanou4.slotgame.repo.UserRepo;
import com.ivanou4.slotgame.to.UserDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String USER1_ID = "User1TestId";
    private static final String USER2_ID = "User2TestId";
    private static final String PASSWORD = "11111111";
    private static final String CHANGE_PASSWORD = "22222222";
    private Mapper dozzerMapper = new DozerBeanMapper();

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepo repo;

    @Mock
    private PasswordEncoder encoder;

    @Before
    public void setUp() throws Exception {
        when(encoder.encode(PASSWORD)).thenReturn(PASSWORD);
    }

    @Test
    public void existsByUsername() {
        User user = createUser(USER1_ID);
        when(repo.existsByUsername(anyString())).thenReturn(true);
        Boolean isExist = service.existsByUsername(user.getUsername());
        assertThat(isExist).isEqualTo(true);
        verify(repo).existsByUsername(user.getUsername());
    }

    @Test
    public void save() throws JsonProcessingException {
        User user = createUser(USER1_ID);
        doNothing().when(repo).save(any(User.class));
        repo.save(user);
        verify(repo).save(user);
    }

    @Test
    public void updatePassword() {
        User user = createUser(USER1_ID);
        when(repo.get(anyString())).thenReturn(user);
        doNothing().when(repo).save(any(User.class));
        service.updatePassword(CHANGE_PASSWORD, USER1_ID);
        verify(repo).get(USER1_ID);
        verify(repo).save(user);
    }

    @Test
    public void resetPassword() {
        User user = createUser(USER1_ID);
        Optional<User> optionalUser = Optional.of(user);
        when(repo.findByUserName(any())).thenReturn(optionalUser);
        doNothing().when(repo).save(any(User.class));
        service.resetPassword(user.getUsername());
        verify(repo).findByUserName(user.getUsername());
        verify(repo).save(user);
    }

    @Test
    public void get() {
        User user = createUser(USER1_ID);
        when(repo.get(anyString())).thenReturn(user);
        UserDTO userDTO = service.get(USER1_ID);
        assertThat(dozzerMapper.map(user, UserDTO.class)).isEqualTo(userDTO);
        verify(repo).get(USER1_ID);
    }

    @Test
    public void getAll() {
        User firstCreatedUser = createUser(USER1_ID);
        User secondCreatedUser = createUser(USER2_ID);
        when(repo.getAll()).thenReturn(Arrays.asList(firstCreatedUser, secondCreatedUser));
        List<UserDTO> userDTOS = service.getAll();
        assertThat(userDTOS).isEqualTo(Arrays.asList(
                dozzerMapper.map(firstCreatedUser, UserDTO.class),
                dozzerMapper.map(secondCreatedUser, UserDTO.class)
        ));
        verify(repo).getAll();
    }

    @Test
    public void delete() {
        doNothing().when(repo).delete(anyString());
        service.delete(USER2_ID);
        verify(repo).delete(USER2_ID);
    }

    private User createUser(String user1Id) {
        User user = new User();
        user.setId(user1Id);
        user.setUsername("testUser" + user1Id);
        user.setPassword(encoder.encode(PASSWORD));
        HashSet<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_ADMIN);
        roles.add(Role.ROLE_USER);
        user.setRoles(roles);
        return user;
    }
}
