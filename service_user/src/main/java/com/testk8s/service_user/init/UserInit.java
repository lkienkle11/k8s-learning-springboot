package com.testk8s.service_user.init;

import com.testk8s.service_user.entity.User;
import com.testk8s.service_user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserInit implements CommandLineRunner {

    private final IUserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        long count = userRepository.count();
        if (count >= 20) {
            log.info("Users already initialized (count: {}), skipping initialization.", count);
            return;
        }

        Random random = new Random();
        // Create users from user1 to user10
        for (int i = 1; i <= 10; i++) {
            String username = "user" + i;

            if (userRepository.findUserByUsername(username) == null) {
                User user = User.builder()
                        .username(username)
                        .name("User Name " + i)
                        .age(random.nextInt(60) + 18) // Age can still vary slightly or be fixed if preferred
                        .build();
                userRepository.save(user);
                log.info("Initialized user: {}", username);
            }
        }
    }
}
