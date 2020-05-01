package com.cental.apirest;

import com.cental.apirest.model.User;
import com.cental.apirest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ApirestApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApirestApplication.class, args);
    }


    @Bean
    public CommandLineRunner run(UserRepository userRepository) throws Exception {
        return (String[] args) -> {
            User user1 = new User();
            User user2 = new User();

            user1.setName("Roberto");
            user1.setPassword("123456");
            user1.setEmail("roberto@roberto.com");

            user2.setName("Jaime");
            user2.setEmail("jaimee@jaime.com");
            user2.setPassword("7890");

            if (!userRepository.findByEmail(user1.getEmail()).isPresent()) {
                userRepository.save(user1);
            }

            if (!userRepository.findByEmail(user2.getEmail()).isPresent()) {
                userRepository.save(user2);
            }
        };
    }
}



