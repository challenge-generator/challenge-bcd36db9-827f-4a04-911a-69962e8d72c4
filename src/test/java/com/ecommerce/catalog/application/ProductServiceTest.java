package com.ecommerce.catalog.application;

import com.ecommerce.catalog.domain.Product;
import com.ecommerce.catalog.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ProductService - Pruebas Unitarias")
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product productoBase;
    private UUID productoId;

    @BeforeEach
    void setUp() {
        productoId = UUID.randomUUID();
        productoBase = new Product(
            productoId,
            "Laptop Gaming",
            "Laptop de alta gama para gaming",
            new BigDecimal("1499.99"),
            10
        );
    }

    @Nested
    @DisplayName("Crear Producto")
    class CrearProducto {

        @Test
        @DisplayName("Debe crear un producto exitosamente")
        void debeCrearProductoExitosamente() {
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

            when(productRepository.save(any(Product.class))).thenReturn(productoGuardado);

            Product resultado = productService.createProduct(nuevoProducto);

            assertThat(resultado).isNotNull();
            assertThat(resultado.id()).isNotNull();
            assertThat(resultado.name()).isEqualTo("Mouse Inalámbrico");
            verify(productRepository, times(1)).save(any(Product.class));
        }

        @Test
        @DisplayName("Debe lanzar excepción cuando el nombre está vacío")
        void debeLanzarExcepcionCuandoNombreEstaVacio() {
            Product productoInvalido = new Product(
                null,
                "",
                "Descripción válida",
                new BigDecimal("10.00"),
                5
            );

            assertThatThrownBy(() -> productService.createProduct(productoInvalido))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("nombre");

            verify(productRepository, never()).save(any(Product.class));
        }

        @Test
        @DisplayName("Debe lanzar excepción cuando el precio es negativo")
        void debeLanzarExcepcionCuandoPrecioEsNegativo() {
            Product productoInvalido = new Product(
                null,
                "Producto",
                "Descripción",
                new BigDecimal("-10.00"),
                5
            );

            assertThatThrownBy(() -> productService.createProduct(productoInvalido))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("precio");

            verify(productRepository, never()).save(any(Product.class));
        }
    }

    @Nested
    @DisplayName("Obtener Producto")
    class ObtenerProducto {

        @Test
        @DisplayName("Debe obtener un producto por su ID")
        void debeObtenerProductoPorId() {
            when(productRepository.findById(productoId)).thenReturn(Optional.of(productoBase));

            Optional<Product> resultado = productService.getProductById(productoId);

            assertThat(resultado).isPresent();
            assertThat(resultado.get().name()).isEqualTo("Laptop Gaming");
            verify(productRepository, times(1)).findById(productoId);
        }

        @Test
        @DisplayName("Debe retornar vacío cuando el producto no existe")
        void debeRetornarVacioCuandoProductoNoExiste() {
            UUID idInexistente = UUID.randomUUID();
            when(productRepository.findById(idInexistente)).thenReturn(Optional.empty());

            Optional<Product> resultado = productService.getProductById(idInexistente);

            assertThat(resultado).isEmpty();
            verify(productRepository, times(1)).findById(idInexistente);
        }

        @Test
        @DisplayName("Debe obtener todos los productos")
        void debeObtenerTodosLosProductos() {
            Product producto2 = new Product(
                UUID.randomUUID(),
                "Teclado Mecánico",
                "Teclado RGB",
                new BigDecimal("89.99"),
                25
            );

            when(productRepository.findAll()).thenReturn(List.of(productoBase, producto2));

            List<Product> resultado = productService.getAllProducts();

            assertThat(resultado).hasSize(2);
            assertThat(resultado).extracting(Product::name)
                .containsExactlyInAnyOrder("Laptop Gaming", "Teclado Mecánico");
            verify(productRepository, times(1)).findAll();
        }
    }

    @Nested
    @DisplayName("Actualizar Producto")
    class ActualizarProducto {

        @Test
        @DisplayName("Debe actualizar un producto existente")
        void debeActualizarProductoExistente() {
            Product productoActualizado = productoBase.withPrice(new BigDecimal("1799.99"));

            when(productRepository.existsById(productoId)).thenReturn(true);
            when(productRepository.save(any(Product.class))).thenReturn(productoActualizado);

            Product resultado = productService.updateProduct(productoId, productoActualizado);

            assertThat(resultado.price()).isEqualByComparingTo(new BigDecimal("1799.99"));
            verify(productRepository, times(1)).existsById(productoId);
            verify(productRepository, times(1)).save(any(Product.class));
        }

        @Test
        @DisplayName("Debe lanzar excepción al actualizar producto inexistente")
        void debeLanzarExcepcionAlActualizarProductoInexistente() {
            UUID idInexistente = UUID.randomUUID();
            when(productRepository.existsById(idInexistente)).thenReturn(false);

            assertThatThrownBy(() -> productService.updateProduct(idInexistente, productoBase))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("no encontrado");

            verify(productRepository, never()).save(any(Product.class));
        }
    }

    @Nested
    @DisplayName("Eliminar Producto")
    class EliminarProducto {

        @Test
        @DisplayName("Debe eliminar un producto existente")
        void debeEliminarProductoExistente() {
            when(productRepository.existsById(productoId)).thenReturn(true);
            doNothing().when(productRepository).deleteById(productoId);

            productService.deleteProduct(productoId);

            verify(productRepository, times(1)).existsById(productoId);
            verify(productRepository, times(1)).deleteById(productoId);
        }

        @Test
        @DisplayName("Debe lanzar excepción al eliminar producto inexistente")
        void debeLanzarExcepcionAlEliminarProductoInexistente() {
            UUID idInexistente = UUID.randomUUID();
            when(productRepository.existsById(idInexistente)).thenReturn(false);

            assertThatThrownBy(() -> productService.deleteProduct(idInexistente))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("no encontrado");

            verify(productRepository, never()).deleteById(any(UUID.class));
        }
    }

    @Nested
    @DisplayName("Buscar Productos")
    class BuscarProductos {

        @Test
        @DisplayName("Debe buscar productos por nombre")
        void debeBuscarProductosPorNombre() {
            when(productRepository.findByNameContaining("Laptop"))
                .thenReturn(List.of(productoBase));

            List<Product> resultado = productService.searchProductsByName("Laptop");

            assertThat(resultado).hasSize(1);
            assertThat(resultado.get(0).name()).contains("Laptop");
            verify(productRepository, times(1)).findByNameContaining("Laptop");
        }

        @Test
        @DisplayName("Debe retornar lista vacía cuando no hay resultados")
        void debeRetornarListaVaciaCuandoNoHayResultados() {
            when(productRepository.findByNameContaining("Inexistente")).thenReturn(List.of());

            List<Product> resultado = productService.searchProductsByName("Inexistente");

            assertThat(resultado).isEmpty();
            verify(productRepository, times(1)).findByNameContaining("Inexistente");
        }
    }
}