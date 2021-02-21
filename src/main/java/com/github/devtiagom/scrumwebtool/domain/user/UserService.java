package com.github.devtiagom.scrumwebtool.domain.user;

import com.github.devtiagom.scrumwebtool.domain.user.api.v1.controller.dtos.request.UserRequestSaveDTO;
import com.github.devtiagom.scrumwebtool.domain.user.entities.User;
import com.github.devtiagom.scrumwebtool.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User saveNewUser(UserRequestSaveDTO userDto) {
        return this.userRepository.save(new User(userDto));
    }
}
