/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.controller;

import com.ianducloux.shuttlebe.entity.Concessionaire;
import com.ianducloux.shuttlebe.service.ConcessionaireService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/concessionaires")
public class ConcessionaireController {
    
    @Autowired
    private ConcessionaireService concessionaireService;
    
    //Create a new Concessionaire
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Concessionaire concessionaire){
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(concessionaireService.save(concessionaire));
    }
    
    //Read a Concessionaire
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        
        Optional<Concessionaire> oConcessionaire = concessionaireService.findById(id);
        
        if(!oConcessionaire.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oConcessionaire);
        
    }
    
    //Update a Concessionaire
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Concessionaire uConcessionaire, 
            @PathVariable Long id){
        
        Optional<Concessionaire> oConcessionaire = concessionaireService.findById(id);
        
        if(!oConcessionaire.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        oConcessionaire.get().setName(uConcessionaire.getName());
        oConcessionaire.get().setAddress(uConcessionaire.getAddress());
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(concessionaireService.save(oConcessionaire.get()));
    }
    
    
    //Delete a Concessionaire
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        
        if(!concessionaireService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        concessionaireService.deleteById(id);
        return ResponseEntity.ok().build();
                
    }
    
    //Read All Concessionaires
    @GetMapping
    public List<Concessionaire> readAll(){
        List<Concessionaire> concessionaires = StreamSupport
                .stream(concessionaireService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        
        return concessionaires;
    }
    
}
    