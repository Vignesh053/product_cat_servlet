package springdatajpa.productcatalog.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springdatajpa.productcatalog.entity.Product;
import springdatajpa.productcatalog.service.ProductService;


@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    // get mapping endpoint to fetch all the products in a list
    @GetMapping("product/list")
    public List<Product> getProductList(){
        return productService.getProductLists();
    }

    //post mapping endpoint to add a new product in database
    @PostMapping("product/add")
    public Product addProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
