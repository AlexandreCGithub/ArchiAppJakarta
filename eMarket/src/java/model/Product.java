/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
/**
 *
 * @author magnoir
 */
public class Product implements Serializable {
    
    private Integer id;
    private String name;
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
