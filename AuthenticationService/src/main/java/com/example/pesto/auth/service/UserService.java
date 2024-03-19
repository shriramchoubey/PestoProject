package com.example.pesto.auth.service;
import com.example.pesto.auth.dto.request.CreateUserRequestDTO;
import com.example.pesto.auth.dto.request.PageableRequestDTO;
import com.example.pesto.commons.dao.User;
import com.example.pesto.auth.dto.response.PageableResponseDTO;
import com.example.pesto.commons.enums.Role;
import com.example.pesto.commons.exceptions.ProjectUserAlreadyExist;
import com.example.pesto.commons.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class UserService{

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UserRepository userRepository;

    public PageableResponseDTO getUserList(String user, PageableRequestDTO userListRequestDTO){
        return PageableResponseDTO.builder().build();
    }
    public void addUser(CreateUserRequestDTO requestDTO){

        User user = new User();
        user.setUsername(requestDTO.getUsername());
        user.setName(requestDTO.getName());
        user.setRole(Role.valueOf(requestDTO.getRole()));
        user.setEmail(requestDTO.getEmail());


        user.setPassword(bcryptEncoder.encode(requestDTO.getPassword()));

        User existingUser = userRepository.findById(requestDTO.getUsername()).orElse(null);
        if(existingUser != null){
            log.info("user already exist in DB");
            throw new ProjectUserAlreadyExist();
        }
        userRepository.save(user);
        log.info("saved new user to db");
    }
}