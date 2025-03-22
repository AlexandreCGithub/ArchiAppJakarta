/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.ArrayList;
import java.io.Serializable;
import model.Product;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.annotation.PostConstruct;
/**
 *
 * @author magnoir
 */
@Named
@ApplicationScoped
public class CatalogManager implements Serializable {

    private ArrayList<Product> productList;
    private Integer formProductId;
    private String formProductName;
    private Double formProductPrice;

    public CatalogManager() {
        this.productList = new ArrayList<>();
    }

    public CatalogManager(ArrayList<Product> productList) {
        this.productList = productList;
    }

    //Getter
    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    public Integer getFormProductId() {
        return formProductId;
    }

    public String getFormProductName() {
        return formProductName;
    }
    
    public Double getFormProductPrice() {
        return formProductPrice;
    }

    //Setter
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    public void setFormProductId(Integer formProductId) {
        this.formProductId = formProductId;
    }
    
    public void setFormProductName(String formProductName) {
        this.formProductName = formProductName;
    }

    public void setFormProductPrice(Double formProductPrice) {
        this.formProductPrice = formProductPrice;
    }
    
    
    public String createProduct(){
        productList.add(new Product(getFormProductId(), getFormProductName(), getFormProductPrice()));
        setFormProductId(null);
        setFormProductName(null);
        setFormProductPrice(null);
        return "createProductSuccess";
    }
    
    @PostConstruct
    public void initCatalog() {
        productList.add(new Product(1, "Ordinateur Portable", 1200.99));
        productList.add(new Product(2, "Smartphone", 799.49));
        productList.add(new Product(3, "Casque Bluetooth", 149.99));
        productList.add(new Product(4, "Souris Gaming", 59.99));
        productList.add(new Product(5, "Clavier Mécanique", 89.99));
    }
}
