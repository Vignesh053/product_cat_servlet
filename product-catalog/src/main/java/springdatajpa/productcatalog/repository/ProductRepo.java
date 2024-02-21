package springdatajpa.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springdatajpa.productcatalog.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    
}
