/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
/**
 *
 * @author magnoir
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SELLING_PRICE")
    private Double price;
    
    public Product(Integer id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public Product(){
        this.id = 0;
        this.name = "default";
        this.price = 0.0;
    }
    
    //Getters
    public Integer getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Double getPrice(){
        return this.price;
    }
    
    //Setters
    public void setId(Integer id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
}
