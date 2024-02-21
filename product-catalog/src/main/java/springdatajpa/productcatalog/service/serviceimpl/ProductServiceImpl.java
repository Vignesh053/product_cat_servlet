package springdatajpa.productcatalog.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springdatajpa.productcatalog.entity.Product;
import springdatajpa.productcatalog.repository.ProductRepo;
import springdatajpa.productcatalog.service.ProductService;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    //implementation of fetching the products into a list from database
    @Override
    public List<Product> getProductLists() {
        return productRepo.findAll();
    }

    

    //implementation of adding new product in database
    @Override
    public Product createProduct( Product product) {
        return productRepo.save(product);
    }

    

    
    
}
