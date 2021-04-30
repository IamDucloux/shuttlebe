/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.service;

import com.ianducloux.shuttlebe.entity.Concessionaire;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author iandu
 */

public interface ConcessionaireService {
    
    public Iterable<Concessionaire> findAll();
    
    public Page<Concessionaire> findAll(Pageable Pageable);
    
    public Optional<Concessionaire> findById(Long id);
    
    public Concessionaire save(Concessionaire concessionaire);
    
    public void deleteById(Long id);
}
