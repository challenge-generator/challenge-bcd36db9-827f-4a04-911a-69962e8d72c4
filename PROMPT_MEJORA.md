# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/ecommerce/catalog/application/ProductService.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/catalog/infrastructure/ProductController.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/ecommerce/catalog/infrastructure/ProductControllerTest.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/ecommerce/catalog/application/ProductService.java` — `Product.id`: Se invoca `id` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/catalog/application/ProductService.java` — `Product.isPresent`: Se invoca `isPresent` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/catalog/application/ProductService.java` — `Product.get`: Se invoca `get` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/catalog/infrastructure/ProductController.java` — `ProductUpdateRequest.name`: Se invoca `name` sobre `ProductUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/catalog/infrastructure/ProductController.java` — `ProductUpdateRequest.description`: Se invoca `description` sobre `ProductUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/catalog/infrastructure/ProductController.java` — `ProductUpdateRequest.price`: Se invoca `price` sobre `ProductUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/catalog/infrastructure/ProductController.java` — `ProductUpdateRequest.stock`: Se invoca `stock` sobre `ProductUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/catalog/infrastructure/ProductController.java` — `Product.id`: Se invoca `id` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/catalog/infrastructure/ProductController.java` — `Product.name`: Se invoca `name` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/catalog/application/ProductServiceTest.java` — `Product.id`: Se invoca `id` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/catalog/application/ProductServiceTest.java` — `Product.name`: Se invoca `name` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/catalog/application/ProductServiceTest.java` — `Product.get`: Se invoca `get` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/ecommerce/catalog/application/ProductServiceTest.java` — `Product.price`: Se invoca `price` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Spring, Tecnología Java, Advanced L2

### Brecha de conocimiento
Experiencia comprobable en al menos un marco de trabajo (Framework) en su lenguaje de programación principal (por ejemplo, Spring Framework en Java o ASP .net core en C#) y puede realizar el enrutamiento de solicitudes, controlar las variables de entorno, generar registros de rastros (Logs) y conectarse con bases de datos utilizando un Mapeador Relacional de Objetos (ORM).

### Reto
- Tema: Experiencia en Frameworks
- Seniority: advanced-l2
- Tipo: practical
- Título: Desarrollo de una API REST con Spring Framework
- Tiempo estimado: 10 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del proyecto y enrutamiento de solicitudes — objetivo: Configurar un proyecto Spring Boot y definir los endpoints para la gestión de productos. — entregable (NO resolver): Proyecto Spring Boot con endpoints definidos y funcionales.
- Fase 2: Control de variables de entorno y generación de logs — objetivo: Implementar el control de variables de entorno y la generación de registros de rastros en la API. — entregable (NO resolver): API con control de variables de entorno y generación de logs funcional.
- Fase 3: Conexión a base de datos utilizando ORM — objetivo: Conectar la API a una base de datos utilizando un ORM y definir las entidades y repositorios para gestionar productos. — entregable (NO resolver): API conectada a una base de datos con entidades y repositorios definidos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.ecommerce</groupId>
    <artifactId>catalog</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>catalog</name>
    <description>API REST para gestión de catálogo de productos</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/ecommerce/catalog/CatalogApplication.java ===
package com.ecommerce.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CatalogApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatalogApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: catalog-service
  datasource:
    url: jdbc:postgresql://localhost:5432/ecommerce_catalog
    username: catalog_user
    password: catalog_password
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher

server:
  port: 8080
  servlet:
    context-path: /api

logging:
  level:
    root: INFO
    org.springframework.web: DEBUG
    org.hibernate: ERROR
    com.ecommerce.catalog: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
  file:
    name: logs/catalog-service.log

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    operationsSorter: method
    tagsSorter: alpha

// === ARCHIVO: src/main/java/com/ecommerce/catalog/domain/Product.java ===
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

// === ARCHIVO: src/main/java/com/ecommerce/catalog/domain/ProductRepository.java ===
package com.ecommerce.catalog.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(UUID id);
    List<Product> findAll();
    void deleteById(UUID id);
    List<Product> findByNameContaining(String name);
    boolean existsById(UUID id);
}

// === ARCHIVO: src/main/java/com/ecommerce/catalog/infrastructure/ProductJpaRepository.java ===
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

// === ARCHIVO: src/main/java/com/ecommerce/catalog/application/ProductService.java ===
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

// === ARCHIVO: src/main/java/com/ecommerce/catalog/infrastructure/ProductController.java ===
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

// === ARCHIVO: src/main/resources/logback-spring.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
    
    <property name="LOG_FILE" value="${LOG_FILE:-${LOG_PATH:-${LOG_TEMP:-${java.io.tmpdir:-/tmp}}}/spring.log}"/>
    <property name="CONSOLE_LOG_PATTERN" value="%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}"/>
    <property name="FILE_LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss.SSS} ${LOG_LEVEL_PATTERN:-%5p} ${PID:- } --- [%t] %-40.40logger{39} : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}"/>

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${CONSOLE_LOG_PATTERN}</pattern>
            <charset>utf8</charset>
        </encoder>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_FILE}</file>
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz</fileNamePattern>
            <maxFileSize>10MB</maxFileSize>
            <maxHistory>30</maxHistory>
            <totalSizeCap>1GB</totalSizeCap>
        </rollingPolicy>
    </appender>

    <logger name="com.ecommerce.catalog" level="DEBUG"/>
    <logger name="org.springframework.web" level="INFO"/>
    <logger name="org.springframework.boot" level="INFO"/>
    <logger name="org.hibernate.SQL" level="DEBUG"/>
    <logger name="org.hibernate.type.descriptor.sql.BasicBinder" level="TRACE"/>
    <logger name="org.springdoc" level="INFO"/>

    <root level="INFO">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </root>

    <springProfile name="dev">
        <logger name="com.ecommerce.catalog" level="DEBUG"/>
        <root level="DEBUG">
            <appender-ref ref="CONSOLE"/>
        </root>
    </springProfile>

    <springProfile name="prod">
        <logger name="com.ecommerce.catalog" level="INFO"/>
        <root level="WARN">
            <appender-ref ref="CONSOLE"/>
            <appender-ref ref="FILE"/>
        </root>
    </springProfile>
</configuration>

// === ARCHIVO: src/test/java/com/ecommerce/catalog/application/ProductServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/ecommerce/catalog/infrastructure/ProductControllerTest.java ===
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
```
