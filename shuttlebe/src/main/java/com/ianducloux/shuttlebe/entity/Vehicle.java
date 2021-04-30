/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ianducloux.shuttlebe.entity;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author iandu
 */
@Entity
@Table(name = "vehicles")
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mark;
    private String subMark;
    private String year;
    private String color;
    
    @ManyToOne(optional = false)
    @JoinColumn(name= "concessionaire_id", referencedColumnName = "id")
    private Concessionaire concessionaire;
    
    @Column(unique = true)
    private String serialNumber;
    
    private boolean available;

    public Vehicle() {
    }

    public Vehicle(long id, String mark, String subMark, String year, String color, Concessionaire concessionaire, String serialNumber, boolean available) {
        this.id = id;
        this.mark = mark;
        this.subMark = subMark;
        this.year = year;
        this.color = color;
        this.concessionaire = concessionaire;
        this.serialNumber = serialNumber;
        this.available = available;
    }

   

   

  

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSubMark() {
        return subMark;
    }

    public void setSubMark(String subMark) {
        this.subMark = subMark;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Concessionaire getConcessionaire() {
        return concessionaire;
    }

    public void setConcessionaire(Concessionaire concessionaire) {
        this.concessionaire = concessionaire;
    }

  

    

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    

    

 

    
    
}
