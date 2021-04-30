/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.service;

import com.ianducloux.shuttlebe.entity.Concessionaire;
import com.ianducloux.shuttlebe.repository.ConcessionaireRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iandu
 */
@Service
public class ConcessionaireServiceImpl implements ConcessionaireService{
    
    @Autowired
    private ConcessionaireRepository concessionaireRepository;
    

    @Override
    @Transactional(readOnly = true)
    public Iterable<Concessionaire> findAll() {
        
        return concessionaireRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Concessionaire> findAll(Pageable Pageable) {
        
        return concessionaireRepository.findAll(Pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Concessionaire> findById(Long id) {
        
        return concessionaireRepository.findById(id);
    }

    @Override
    @Transactional
    public Concessionaire save(Concessionaire concessionaire) {
        
        return concessionaireRepository.save(concessionaire);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        concessionaireRepository.deleteById(id);
    }
    
}
