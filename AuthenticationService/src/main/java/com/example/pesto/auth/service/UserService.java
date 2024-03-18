package com.example.pesto.auth.service;
import com.example.pesto.auth.dto.request.PageableRequestDTO;
import com.example.pesto.commons.dao.User;
import com.example.pesto.auth.dto.response.PageableResponseDTO;
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
    public void addUser(User user){
        log.info("Saving employee to db");
        user.setPassword(bcryptEncoder.encode(user.getPassword()));

        try{
            User us = userRepository.findById(user.getUsername()).get();
            throw new ProjectUserAlreadyExist();
        }catch (EntityNotFoundException ex){
            userRepository.save(user);
        }
        catch ( NoSuchElementException ex){
            userRepository.save(user);
        }

    }
}