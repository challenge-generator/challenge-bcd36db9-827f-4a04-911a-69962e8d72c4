package com.ecommerce.catalog.domain;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

public record Product(
    @NotNull
    UUID id,

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(max = 100, message = "El nombre del producto no puede exceder 100 caracteres")
    String name,

    @NotBlank(message = "La descripción del producto no puede estar vacía")
    @Size(max = 500, message = "La descripción del producto no puede exceder 500 caracteres")
    String description,

    @NotNull(message = "El precio del producto es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que cero")
    BigDecimal price,

    @NotNull(message = "El stock del producto es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    Integer stock) {
    
    public Product {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
    
    public Product withName(String newName) {
        return new Product(this.id, newName, this.description, this.price, this.stock);
    }
    
    public Product withDescription(String newDescription) {
        return new Product(this.id, this.name, newDescription, this.price, this.stock);
    }
    
    public Product withPrice(BigDecimal newPrice) {
        return new Product(this.id, this.name, this.description, newPrice, this.stock);
    }
    
    public Product withStock(Integer newStock) {
        return new Product(this.id, this.name, this.description, this.price, newStock);
    }
}