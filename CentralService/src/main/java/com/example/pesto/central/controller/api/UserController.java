package com.example.pesto.central.controller.api;

import com.example.pesto.auth.dto.request.PageableRequestDTO;
import com.example.pesto.auth.dto.response.PageableResponseDTO;
import com.example.pesto.auth.service.UserService;
import com.example.pesto.auth.util.CustomUser;
import com.example.pesto.commons.dao.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(Endpoints.UserAPI.BASE_URL)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(Endpoints.UserAPI.USER)
    public ResponseEntity<String> createUser( @Valid @RequestBody User UserRequestDTO){
      userService.addUser(UserRequestDTO);
      return new ResponseEntity<>("User created successfully", HttpStatus.OK);
    }
    @PostMapping(Endpoints.UserAPI.USERLIST)
    public  ResponseEntity<PageableResponseDTO> getUserList(@Valid @RequestBody PageableRequestDTO userListRequestDTO){
        CustomUser user = authenticate();
        log.info("user list requested by " + user.getId());
        PageableResponseDTO userList = userService.getUserList(user.getId(),userListRequestDTO);
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }
    private CustomUser authenticate(){
        CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("User unauthorised");
        }
        return user;
    }
}
