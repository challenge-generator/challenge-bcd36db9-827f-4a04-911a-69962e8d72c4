package com.ecommerce.catalog.infrastructure;

import com.ecommerce.catalog.application.ProductService;
import com.ecommerce.catalog.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductCreateRequest request) {
        logger.info("Petición POST recibida para crear producto: {}", request.name());
        
        try {
            Product product = productService.createProduct(
                request.name(),
                request.description(),
                request.price(),
                request.stock()
            );
            logger.info("Producto creado exitosamente: id={}, name={}", product.id(), product.name());
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch (IllegalArgumentException e) {
            logger.error("Error al crear producto: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        logger.info("Petición GET recibida para obtener producto: id={}", id);
        
        return productService.getProductById(id)
            .map(product -> {
                logger.info("Producto encontrado: id={}, name={}", product.id(), product.name());
                return ResponseEntity.ok(product);
            })
            .orElseGet(() -> {
                logger.warn("Producto no encontrado: id={}", id);
                return ResponseEntity.notFound().build();
            });
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(required = false) String search) {
        
        logger.info("Petición GET recibida para listar productos. Búsqueda: {}", search);
        
        List<Product> products;
        if (search != null && !search.isBlank()) {
            products = productService.searchProductsByName(search);
            logger.info("Búsqueda '{}' retornó {} productos", search, products.size());
        } else {
            products = productService.getAllProducts();
            logger.info("Listado completo retornó {} productos", products.size());
        }
        
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable UUID id,
            @RequestBody ProductUpdateRequest request) {
        
        logger.info("Petición PUT recibida para actualizar producto: id={}", id);
        
        try {
            return productService.updateProduct(
                id,
                request.name(),
                request.description(),
                request.price(),
                request.stock()
            ).map(product -> {
                logger.info("Producto actualizado exitosamente: id={}", product.id());
                return ResponseEntity.ok(product);
            }).orElseGet(() -> {
                logger.warn("Producto no encontrado para actualizar: id={}", id);
                return ResponseEntity.notFound().build();
            });
        } catch (IllegalArgumentException e) {
            logger.error("Error al actualizar producto: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable UUID id) {
        logger.info("Petición DELETE recibida para eliminar producto: id={}", id);
        
        boolean deleted = productService.deleteProduct(id);
        
        if (deleted) {
            logger.info("Producto eliminado exitosamente: id={}", id);
            return ResponseEntity.ok(Map.of("deleted", true));
        } else {
            logger.warn("Producto no encontrado para eliminar: id={}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Map<String, Boolean>> checkProductExists(@PathVariable UUID id) {
        logger.info("Petición GET para verificar existencia de producto: id={}", id);
        boolean exists = productService.existsProduct(id);
        logger.info("Existencia del producto {}: {}", id, exists);
        return ResponseEntity.ok(Map.of("exists", exists));
    }

    public record ProductCreateRequest(
        String name,
        String description,
        BigDecimal price,
        Integer stock
    ) {}

    public record ProductUpdateRequest(
        String name,
        String description,
        BigDecimal price,
        Integer stock
    ) {}
}