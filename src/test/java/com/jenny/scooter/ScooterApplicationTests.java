package com.jenny.scooter;

import com.jenny.scooter.entity.User;
import com.jenny.scooter.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class ScooterApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void abc() {
        userRepository.findAll().forEach(System.out::println);
    }
    @Test
//    @Transactional
    void contextLoads() throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get("D:\\virtual_data.csv"));

        String line = "";

        int i = 0;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] array = line.split(",");
            System.out.println(++i);
            String fullname = array[0];
            String username = array[1];
            String password = array[2];
            String address = array[3];
            Long age = Long.parseLong(array[4]);
            String jumin = array[5];

            User user = User.builder()
                    .fullname(fullname).username(username).password(password).address(address).age(age).jumin(jumin).build();

            user = userRepository.save(user);

//            System.out.println(user);
//            if(i == 10) return;
        }
    }

}
