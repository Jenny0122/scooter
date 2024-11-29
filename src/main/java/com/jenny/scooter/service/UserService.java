package com.jenny.scooter.service;


import com.jenny.scooter.model.UserCreateRequestDto;
import com.jenny.scooter.entity.User;
import com.jenny.scooter.exception.DuplicatedValueException;
import com.jenny.scooter.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User saveUser(UserCreateRequestDto userCreateRequestDto) {

        String username = userCreateRequestDto.getUsername();
        if(userRepository.existsByUsername(username)) {
            throw new DuplicatedValueException("중복된 ID가 존재합니다.");
        }
        return userRepository.save(userCreateRequestDto.toEntity());
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();

    }
    public User getUserByUsername(String userUsername) {
        return userRepository.findByUsername(userUsername);

    }
}
