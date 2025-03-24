package logic;

import facade.ProductFacade;
import java.util.ArrayList;
import java.io.Serializable;
import model.Product;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;

@Named
@ApplicationScoped
public class CatalogManager implements Serializable {

    private ArrayList<Product> productList;
    private String formProductName;
    private Double formProductPrice;
    @EJB
    private ProductFacade productFacade;  

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

    public String getFormProductName() {
        return formProductName;
    }
    
    public Double getFormProductPrice() {
        return formProductPrice;
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    //Setter
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
    public void setFormProductName(String formProductName) {
        this.formProductName = formProductName;
    }

    public void setFormProductPrice(Double formProductPrice) {
        this.formProductPrice = formProductPrice;
    }
    
    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }
    
    public String createProduct(){
        Product entity = new Product(productList.size()+1, getFormProductName(), getFormProductPrice());
        setFormProductName(null);
        setFormProductPrice(null);
        productList.add(entity) ; 
        productFacade.create(entity);
        return "createProductSuccess" ;
    }
    
    @PostConstruct
    public void initCatalog(){
        productList.addAll(productFacade.findAll());
    }
}
