/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.repository;

import com.ianducloux.shuttlebe.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iandu
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
}
