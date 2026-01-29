package com.testk8s.service_user.service;


import com.testk8s.service_user.mapper.IUserMapper;
import com.testk8s.service_user.repository.IUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl {
    IUserRepository userRepo;

    IUserMapper userMapper;

    public model.User findByUsername(String username) {
        return userMapper.toModel(userRepo.findUserByUsername(username));
    }

    public List<model.User> findAll() {
        return userRepo.findAll().stream().map(userMapper::toModel).toList();
    }
}
