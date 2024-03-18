package com.example.pesto.auth.controller;

import com.example.pesto.auth.dto.request.JwtRequest;
import com.example.pesto.auth.dto.response.JwtResponse;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserService userDetailsService;

    @PostMapping(value = Endpoints.Auth.AUTHENTICATE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new UserDisabledException(e);
        } catch (BadCredentialsException e) {
            throw new WrongLoginCredentials(e);
        }catch (UsernameNotFoundException e) {
            throw new WrongLoginCredentials(e);
        }
    }
}