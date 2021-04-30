/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.controller;

import com.ianducloux.shuttlebe.entity.User;
import com.ianducloux.shuttlebe.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author iandu
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    //Create a new User
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(user));
    }
    
    //Read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        if(!userService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(userService.findById(id));
    }
    
    //Update an User
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User uUser, 
            @PathVariable Long id){
        if(!userService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        User user = new User();
        user.setName(uUser.getName());
        user.setSurname(uUser.getSurname());
        user.setEmail(uUser.getEmail());
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(user));
            
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!userService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    } 
    
    @GetMapping
    public List<User> readAll(){
        List<User> users = StreamSupport
                .stream(userService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return users;
    }
            
            
}
