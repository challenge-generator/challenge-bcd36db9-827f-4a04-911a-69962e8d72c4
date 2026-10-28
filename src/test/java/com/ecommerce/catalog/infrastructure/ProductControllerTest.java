package com.ecommerce.catalog.infrastructure;

import com.ecommerce.catalog.application.ProductService;
import com.ecommerce.catalog.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
@DisplayName("ProductController - Pruebas de Integración")
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    private Product productoBase;
    private UUID productoId;
    private String productoJson;

    @BeforeEach
    void setUp() throws Exception {
        productoId = UUID.randomUUID();
        productoBase = new Product(
            productoId,
            "Laptop Gaming",
            "Laptop de alta gama para gaming",
            new BigDecimal("1499.99"),
            10
        );
        productoJson = objectMapper.writeValueAsString(productoBase);
    }

    @Nested
    @DisplayName("GET - Obtener Productos")
    class ObtenerProductos {

        @Test
        @DisplayName("Debe retornar todos los productos")
        void debeRetornarTodosLosProductos() throws Exception {
            Product producto2 = new Product(
                UUID.randomUUID(),
                "Teclado Mecánico",
                "Teclado RGB",
                new BigDecimal("89.99"),
                25
            );

            when(productService.getAllProducts())
                .thenReturn(List.of(productoBase, producto2));

            mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Laptop Gaming"))
                .andExpect(jsonPath("$[1].name").value("Teclado Mecánico"));

            verify(productService, times(1)).getAllProducts();
        }

        @Test
        @DisplayName("Debe retornar producto por ID")
        void debeRetornarProductoPorId() throws Exception {
            when(productService.getProductById(productoId))
                .thenReturn(Optional.of(productoBase));

            mockMvc.perform(get("/api/products/{id}", productoId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(productoId.toString()))
                .andExpect(jsonPath("$.name").value("Laptop Gaming"))
                .andExpect(jsonPath("$.price").value(1499.99));

            verify(productService, times(1)).getProductById(productoId);
        }

        @Test
        @DisplayName("Debe retornar 404 cuando el producto no existe")
        void debeRetornar404CuandoProductoNoExiste() throws Exception {
            UUID idInexistente = UUID.randomUUID();
            when(productService.getProductById(idInexistente))
                .thenReturn(Optional.empty());

            mockMvc.perform(get("/api/products/{id}", idInexistente))
                .andExpect(status().isNotFound());

            verify(productService, times(1)).getProductById(idInexistente);
        }
    }

    @Nested
    @DisplayName("POST - Crear Producto")
    class CrearProducto {

        @Test
        @DisplayName("Debe crear un producto exitosamente")
        void debeCrearProductoExitosamente() throws Exception {
            Product nuevoProducto = new Product(
                null,
                "Mouse Inalámbrico",
                "Mouse ergonómico",
                new BigDecimal("29.99"),
                50
            );

            Product productoGuardado = new Product(
                UUID.randomUUID(),
                "Mouse Inalámbrico",
                "Mouse ergonómico",
                new BigDecimal("29.99"),
                50
            );

            when(productService.createProduct(any(Product.class)))
                .thenReturn(productoGuardado);

            mockMvc.perform(post("/api/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(nuevoProducto)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.name").value("Mouse Inalámbrico"))
                .andExpect(jsonPath("$.price").value(29.99));

            verify(productService, times(1)).createProduct(any(Product.class));
        }

        @Test
        @DisplayName("Debe retornar 400 cuando los datos son inválidos")
        void debeRetornar400CuandoDatosSonInvalidos() throws Exception {
            Product productoInvalido = new Product(
                null,
                "",
                "Descripción",
                new BigDecimal("-10.00"),
                -5
            );

            mockMvc.perform(post("/api/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(productoInvalido)))
                .andExpect(status().isBadRequest());

            verify(productService, never()).createProduct(any(Product.class));
        }
    }

    @Nested
    @DisplayName("PUT - Actualizar Producto")
    class ActualizarProducto {

        @Test
        @DisplayName("Debe actualizar un producto existente")
        void debeActualizarProductoExistente() throws Exception {
            Product productoActualizado = productoBase.withPrice(new BigDecimal("1799.99"));

            when(productService.updateProduct(eq(productoId), any(Product.class)))
                .thenReturn(productoActualizado);

            mockMvc.perform(put("/api/products/{id}", productoId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(productoActualizado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(1799.99));

            verify(productService, times(1)).updateProduct(eq(productoId), any(Product.class));
        }

        @Test
        @DisplayName("Debe retornar 404 al actualizar producto inexistente")
        void debeRetornar404AlActualizarProductoInexistente() throws Exception {
            UUID idInexistente = UUID.randomUUID();
            when(productService.updateProduct(eq(idInexistente), any(Product.class)))
                .thenThrow(new RuntimeException("Producto no encontrado"));

            mockMvc.perform(put("/api/products/{id}", idInexistente)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(productoJson))
                .andExpect(status().isNotFound());

            verify(productService, times(1)).updateProduct(eq(idInexistente), any(Product.class));
        }
    }

    @Nested
    @DisplayName("DELETE - Eliminar Producto")
    class EliminarProducto {

        @Test
        @DisplayName("Debe eliminar un producto existente")
        void debeEliminarProductoExistente() throws Exception {
            doNothing().when(productService).deleteProduct(productoId);

            mockMvc.perform(delete("/api/products/{id}", productoId))
                .andExpect(status().isNoContent());

            verify(productService, times(1)).deleteProduct(productoId);
        }

        @Test
        @DisplayName("Debe retornar 404 al eliminar producto inexistente")
        void debeRetornar404AlEliminarProductoInexistente() throws Exception {
            UUID idInexistente = UUID.randomUUID();
            doThrow(new RuntimeException("Producto no encontrado"))
                .when(productService).deleteProduct(idInexistente);

            mockMvc.perform(delete("/api/products/{id}", idInexistente))
                .andExpect(status().isNotFound());

            verify(productService, times(1)).deleteProduct(idInexistente);
        }
    }

    @Nested
    @DisplayName("GET - Buscar Productos")
    class BuscarProductos {

        @Test
        @DisplayName("Debe buscar productos por nombre")
        void debeBuscarProductosPorNombre() throws Exception {
            when(productService.searchProductsByName("Laptop"))
                .thenReturn(List.of(productoBase));

            mockMvc.perform(get("/api/products/search")
                    .param("name", "Laptop"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Laptop Gaming"));

            verify(productService, times(1)).searchProductsByName("Laptop");
        }

        @Test
        @DisplayName("Debe retornar lista vacía cuando no hay resultados")
        void debeRetornarListaVaciaCuandoNoHayResultados() throws Exception {
            when(productService.searchProductsByName("Inexistente"))
                .thenReturn(List.of());

            mockMvc.perform(get("/api/products/search")
                    .param("name", "Inexistente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

            verify(productService, times(1)).searchProductsByName("Inexistente");
        }
    }
}