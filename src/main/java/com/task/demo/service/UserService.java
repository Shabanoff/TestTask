package com.task.demo.service;

import com.task.demo.model.entity.User;
import com.task.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public List<User> findTop20ByUserId (Long userId) {
        return userRepository.findTop20ByUserIdOrderByResultDescLevelIdDesc(userId);
    }

    public List<User> findTop20ByLevelId (Long levelId){
        return userRepository.findTop20ByLevelIdOrderByResultDescUserIdDesc(levelId);
    }

    public User create(User user) {
           return userRepository.save(user);
    }

}

