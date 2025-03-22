/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import java.util.ArrayList;
import java.io.Serializable;
import model.ShoppingCartItem;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.annotation.PostConstruct;
import model.Product;
/**
/**
 *
 * @author magnoir
 */
@Named
@ApplicationScoped
public class ShoppingCartManager implements Serializable {
    
    private ArrayList<ShoppingCartItem> shoppingCart;
    private Product prodToAdd;
    private ShoppingCartItem shoppingCartItemToRemove;
    private Integer formRemoveQuantity;

    public ShoppingCartManager(ArrayList<ShoppingCartItem> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
    public ShoppingCartManager() {
        this.shoppingCart = new ArrayList<>();
    }
    
    //Getter
    public ArrayList<ShoppingCartItem> getShoppingCart() {
        return shoppingCart;
    }
    
    public Product getProdToAdd() {
        return prodToAdd;
    }
    
    public ShoppingCartItem getShoppingCartItemToRemove() {
        return shoppingCartItemToRemove;
    }


    public Integer getFormRemoveQuantity() {
        return formRemoveQuantity;
    }
    
    //Setter
    public void setShoppingCart(ArrayList<ShoppingCartItem> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
    public void setProdToAdd(Product prodToAdd) {
        this.prodToAdd = prodToAdd;
    }
    
    public void setShoppingCartItemToRemove(ShoppingCartItem shoppingCartItemToRemove) {
        this.shoppingCartItemToRemove = shoppingCartItemToRemove;
    }
    
    public void setFormRemoveQuantity(Integer formRemoveQuantity) {
        this.formRemoveQuantity = formRemoveQuantity;
    }
    
    public String addToCart(){
        for (ShoppingCartItem item : shoppingCart) {
            if (item.getProduct().getId().equals(prodToAdd.getId())) {
                item.setQuantity(item.getQuantity() + 1);
                return "addToCartProductSuccess";
            }
        }
        ShoppingCartItem addToCartItem = new ShoppingCartItem(shoppingCart.size() + 1, 1, prodToAdd);
        shoppingCart.add(addToCartItem);
        return "addToCartProductSuccess";
    }
    
    public String removeFromCart(){
        for (ShoppingCartItem item : shoppingCart) {
            if (item.getId().equals(shoppingCartItemToRemove.getId())) {
                Integer quantityDelta = item.getQuantity() - getFormRemoveQuantity();
                if (quantityDelta >= 0){
                     item.setQuantity(item.getQuantity() - getFormRemoveQuantity());
                }
            }
        }
        setFormRemoveQuantity(null);
        return null;
    }
    
    @PostConstruct
    public void initCart() {
        Product ordi = new Product(1, "Ordinateur Portable", 1200.99);
        Product smartphone = new Product(2, "Smartphone", 799.49);
        Product casque = new Product(3, "Casque Bluetooth", 149.99);
        
        ShoppingCartItem ordiItem = new ShoppingCartItem(1, 1, ordi);
        ShoppingCartItem smartphoneItem = new ShoppingCartItem(2, 3, smartphone);
        ShoppingCartItem casqueItem = new ShoppingCartItem(3, 5, casque);
        
        shoppingCart.add(ordiItem);
        shoppingCart.add(smartphoneItem);
        shoppingCart.add(casqueItem);
    }
}
