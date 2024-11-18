package br.edu.utfpr.pb.pw44s.server;

import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void cleanup() {
        userRepository.deleteAll();
        testRestTemplate.getRestTemplate().getInterceptors().clear();
    }

    @Test
    public void createUser_whenUserIsValid_receiveCreated() {
        User user = createValidUser();
        ResponseEntity<Object> response = testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void createUser_whenUserIsValid_userSavedToDatabase() {
        User user = createValidUser();
        testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(userRepository.count()).isEqualTo(1);
    }

    @Test
    public void createUser_whenEmailIsMissing_receiveBadRequest() {
        User user = createValidUser();
        user.setEmail(null);

        ResponseEntity<Object> response = testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void deleteUser_whenUserExists_userRemovedFromDatabase() {
        User user = createValidUser();
        User savedUser = userRepository.save(user);

        testRestTemplate.delete("/users/" + savedUser.getId());

        assertThat(userRepository.existsById(savedUser.getId())).isFalse();
    }

    @Test
    public void getUserById_whenUserExists_receiveUser() {
        User user = createValidUser();
        User savedUser = userRepository.save(user);

        ResponseEntity<User> response = testRestTemplate.getForEntity("/users/" + savedUser.getId(), User.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getEmail()).isEqualTo(savedUser.getEmail());
    }

    private User createValidUser() {
        User user = new User();
        user.setEmail("joao.silva@example.com");
        user.setName("João da Silva");
        user.setPassword("SenhaSegura123");
        user.setCpf("12345678901");
        user.setBirthDate(LocalDate.parse("1990-01-15"));
        user.setGender("masculino");
        user.setPhone("+5511999998888");
        return user;
    }
}
