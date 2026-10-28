package com.ecommerce.catalog.application;

import com.ecommerce.catalog.domain.Product;
import com.ecommerce.catalog.domain.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(String name, String description, BigDecimal price, Integer stock) {
        logger.info("Creando nuevo producto: name={}, price={}, stock={}", name, price, stock);
        
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (stock == null || stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        Product product = new Product(
            UUID.randomUUID(),
            name,
            description,
            price,
            stock
        );

        Product savedProduct = productRepository.save(product);
        logger.info("Producto creado exitosamente con ID: {}", savedProduct.id());
        return savedProduct;
    }

    @Transactional(readOnly = true)
    public Optional<Product> getProductById(UUID id) {
        logger.debug("Buscando producto por ID: {}", id);
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            logger.debug("Producto encontrado: {}", product.get().name());
        } else {
            logger.warn("Producto no encontrado con ID: {}", id);
        }
        return product;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        logger.info("Obteniendo todos los productos");
        List<Product> products = productRepository.findAll();
        logger.info("Se encontraron {} productos", products.size());
        return products;
    }

    @Transactional(readOnly = true)
    public List<Product> searchProductsByName(String name) {
        logger.info("Buscando productos por nombre: {}", name);
        List<Product> products = productRepository.findByNameContaining(name);
        logger.info("Se encontraron {} productos con nombre contendo '{}'", products.size(), name);
        return products;
    }

    @Transactional
    public Optional<Product> updateProduct(UUID id, String name, String description, BigDecimal price, Integer stock) {
        logger.info("Actualizando producto con ID: {}", id);
        
        if (!productRepository.existsById(id)) {
            logger.warn("No se puede actualizar: producto no encontrado con ID: {}", id);
            return Optional.empty();
        }

        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isEmpty()) {
            return Optional.empty();
        }

        Product product = existingProduct.get();
        Product updatedProduct = product;

        if (name != null && !name.isBlank()) {
            updatedProduct = updatedProduct.withName(name);
        }
        if (description != null) {
            updatedProduct = updatedProduct.withDescription(description);
        }
        if (price != null && price.compareTo(BigDecimal.ZERO) > 0) {
            updatedProduct = updatedProduct.withPrice(price);
        }
        if (stock != null && stock >= 0) {
            updatedProduct = updatedProduct.withStock(stock);
        }

        Product savedProduct = productRepository.save(updatedProduct);
        logger.info("Producto actualizado exitosamente: {}", savedProduct.id());
        return Optional.of(savedProduct);
    }

    @Transactional
    public boolean deleteProduct(UUID id) {
        logger.info("Eliminando producto con ID: {}", id);
        
        if (!productRepository.existsById(id)) {
            logger.warn("No se puede eliminar: producto no encontrado con ID: {}", id);
            return false;
        }

        productRepository.deleteById(id);
        logger.info("Producto eliminado exitosamente con ID: {}", id);
        return true;
    }

    @Transactional(readOnly = true)
    public boolean existsProduct(UUID id) {
        return productRepository.existsById(id);
    }
}