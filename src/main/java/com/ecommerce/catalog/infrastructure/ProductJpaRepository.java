package com.ecommerce.catalog.infrastructure;

import com.ecommerce.catalog.domain.Product;
import com.ecommerce.catalog.domain.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, UUID>, ProductRepository {
    @Override
    default Product save(Product product) {
        return save(product);
    }
    
    @Override
    default Optional<Product> findById(UUID id) {
        return findById(id);
    }
    
    @Override
    default List<Product> findAll() {
        return findAll();
    }
    
    @Override
    default void deleteById(UUID id) {
        deleteById(id);
    }
    
    @Override
    List<Product> findByNameContaining(String name);
    
    @Override
    default boolean existsById(UUID id) {
        return existsById(id);
    }
}