/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.controller;

import com.ianducloux.shuttlebe.entity.Reservation;
import com.ianducloux.shuttlebe.service.ReservationService;
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
@RequestMapping("/api/reservations")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    //Create a new Reservation
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Reservation reservation){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.save(reservation));
    }
    
    //Read a reservation
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        if(!reservationService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(reservationService.findById(id));
    }
    
    //Update an User
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Reservation uReservation, 
            @PathVariable Long id){
        if(!reservationService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        Reservation reservation = new Reservation();
        reservation.setUser(uReservation.getUser());
        reservation.setVehicle(uReservation.getVehicle());
        reservation.setReservationStartDate(uReservation.getReservationStartDate());
        reservation.setReservationEndDate(uReservation.getReservationEndDate());
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.save(reservation));
            
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!reservationService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        reservationService.deleteById(id);
        return ResponseEntity.ok().build();
    } 
    
    @GetMapping
    public List<Reservation> readAll(){
        List<Reservation> reservations = StreamSupport
                .stream(reservationService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return reservations;
    }
    
}
