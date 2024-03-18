package com.example.pesto.commons.dao;

import com.example.pesto.commons.enums.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name="user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseDAO {

    @Id
    @NotBlank(message = "username can't be blank")
    private String username;

    @NotBlank(message = "name can't be blank")
    private String name;
    private String email;
    @NotBlank(message = "User password can't be blank")
    private String password;

    public void setPassword(String password){
        this.password=password;
    }
    @Enumerated(EnumType.STRING)
    private Role role;

    public String getUsername(){
        return username;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}
