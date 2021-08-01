package com.example.spring.mongo;

import com.example.spring.mongo.entity.User;
import com.example.spring.mongo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class MongoRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void test() {
        repository.deleteAll();

        User user = new User();
        user.setId(0);
        user.setUsername("mongo");
        user.setPassword("password");

        User save = repository.save(user);
        Assertions.assertEquals(user, save);
        log.info("save {}", save);

        List<User> all = repository.findAll();
        Assertions.assertEquals(1, all.size());
        log.info("find all {}", all);

        User first = all.get(0);
        Assertions.assertEquals(user, first);

        List<User> byUsername = repository.findByUsername("mongo");
        Assertions.assertEquals(1, byUsername.size());
        log.info("find by username {}", byUsername);

        repository.deleteAll();
    }
}
