/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.controller;

import com.ianducloux.shuttlebe.entity.Vehicle;
import com.ianducloux.shuttlebe.service.VehicleService;
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
@RequestMapping("/api/vehicles")
public class VehicleController {
    
    @Autowired
    private VehicleService vehicleService;
    
    //Create a new Vehicle
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Vehicle vehicle){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleService.save(vehicle));
    }
    
    //Read a Vehicle
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        
        if(!vehicleService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(vehicleService.findById(id));
    }
    
    //Update a Vehicle
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Vehicle uVehicle,
            @PathVariable Long id){
        
        if(!vehicleService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        Vehicle vehicle = new Vehicle();
        vehicle.setMark(uVehicle.getMark());
        vehicle.setSubMark(uVehicle.getSubMark());
        vehicle.setYear(uVehicle.getYear());
        vehicle.setColor(uVehicle.getColor());
        vehicle.setConcessionaire(uVehicle.getConcessionaire());
        vehicle.setSerialNumber(uVehicle.getSerialNumber());
        vehicle.setAvailable(uVehicle.isAvailable());
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleService.save(vehicle));
        
    }
    
    //Delete a Vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!vehicleService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        vehicleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    //Read All the Vehicles
    @GetMapping
    public List<Vehicle> readAll(){
        List<Vehicle> vehicles = StreamSupport
                .stream(vehicleService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return vehicles;
    }
}
