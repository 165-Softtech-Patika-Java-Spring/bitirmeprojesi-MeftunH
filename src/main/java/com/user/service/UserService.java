package com.user.service;

import com.user.converter.UserMapper;
import com.user.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserEntityService userEntityService;
    private final UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
}