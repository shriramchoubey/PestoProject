package com.example.pesto.auth.controller;

import com.example.pesto.auth.dto.request.JwtRequest;
import com.example.pesto.auth.dto.response.JwtResponse;
import com.example.pesto.auth.service.AuthenticationTokenService;
import com.example.pesto.auth.service.JwtUserService;
import com.example.pesto.auth.util.JwtTokenUtil;
import com.example.pesto.commons.exceptions.UserDisabledException;
import com.example.pesto.commons.exceptions.WrongLoginCredentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(Endpoints.Auth.BASE_URL)
public class JwtAuthenticationController {
    @Autowired
    AuthenticationTokenService tokenService;

    @PostMapping(value = Endpoints.Auth.AUTHENTICATE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid JwtRequest reequest) throws Exception {
        return ResponseEntity.ok(tokenService.createToken(reequest.getUsername(), reequest.getPassword()));
    }

}