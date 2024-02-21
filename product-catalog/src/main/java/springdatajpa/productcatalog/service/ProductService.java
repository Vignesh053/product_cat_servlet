package springdatajpa.productcatalog.service;

import java.util.List;

import springdatajpa.productcatalog.entity.Product;

public interface ProductService {
    
    public List<Product> getProductLists();

    

    public Product createProduct(Product product);

    

    
}
