/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.service;

import com.ianducloux.shuttlebe.entity.User;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author iandu
 */
public interface UserService {
    
    public Iterable<User> findAll();
    
    public Page<User> findAll(Pageable Pageable);
    
    public Optional<User> findById(Long id);
    
    public User save(User user);
    
    public void deleteById(Long id);
    
}
