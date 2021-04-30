/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.service;

import com.ianducloux.shuttlebe.entity.Reservation;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author iandu
 */
public interface ReservationService {
    
    public Iterable<Reservation> findAll();
    
    public Page<Reservation> findAll(Pageable Pageable);
    
    public Optional<Reservation> findById(Long id);
    
    public Reservation save(Reservation reservation);
    
    public void deleteById(Long id);
    
}
