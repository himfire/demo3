package com.example.demo3.repositories.user;

import com.example.demo3.persistances.model.language.Language;
import com.example.demo3.persistances.model.role.Role;
import com.example.demo3.persistances.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    public UserRepository getUnderTest() {
        return underTest;
    }

    Random random = new Random();
    @Test
    void itShouldFindByEmail() {
        Set<Language> languages = Set.of(new Language(
                random.nextLong(),"English","en"),
                new Language(random.nextLong(),"Arabic","ar"));
        Set<Role> roles = Set.of(new Role(
                random.nextLong(),"Admin","ad"
        ),new Role(
                random.nextLong(),"Teacher","ta"
        ));
        //Given
        Long id = random.nextLong();

        User user = new User(100L,"Hisham", "Khartoum",
                "hdalang@gmail.com", "hdalang", "1234qwer",
                "test", LocalDate.now(), "00966503752342", "address1",
                "address2", "address3", LocalDate.now(),
                LocalDate.now(), 0L,
                LocalDate.now(), "172.20.20.72", 0L,
                languages, roles);
        System.out.println("User: "+user.toString());

        //When
        underTest.save(user);
        log.info("User: "+user.toString());

        //Then
        Optional<User> optionalUser =underTest.findById(id);
        assertThat(optionalUser).
                isPresent();
    }

    @Test
    void itShouldFindByUsername() {
        //Given
        //When
        //Then
    }
}