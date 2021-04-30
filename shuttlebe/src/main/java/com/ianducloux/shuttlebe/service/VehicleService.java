/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.service;


import com.ianducloux.shuttlebe.entity.Vehicle;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author iandu
 */
public interface VehicleService {
    
    public Iterable<Vehicle> findAll();
    
    public Page<Vehicle> findAll(Pageable Pageable);
    
    public Optional<Vehicle> findById(Long id);
    
    public Vehicle save(Vehicle vehicle);
    
    public void deleteById(Long id);
    
}
