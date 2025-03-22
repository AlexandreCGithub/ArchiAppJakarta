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
public class ShoppingCartItem implements Serializable {
    
    private Integer id;
    private Integer quantity;
    private Product product;
    
    public ShoppingCartItem() {
        this.id = 0;
        this.quantity = 0;
        this.product = null;
    }
    
    public ShoppingCartItem(Integer id, Integer quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }
    
    //Getter
    public Integer getId() {
        return id;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public Product getProduct() {
        return product;
    }
    
    //Setter
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
}
