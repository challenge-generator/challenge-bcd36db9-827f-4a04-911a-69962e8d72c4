# Desarrollo de una API REST con Spring Framework

La empresa necesita una API REST que gestione productos en un catálogo de e-commerce. La API debe permitir la creación, lectura, actualización y eliminación de productos, así como la conexión a una base de datos utilizando un ORM. Los productos tienen atributos como nombre, descripción, precio y stock. La API debe manejar variables de entorno para configuración y generar registros de rastros para monitoreo.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Experiencia en Frameworks |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 10 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del proyecto y enrutamiento de solicitudes

**Objetivo:** Configurar un proyecto Spring Boot y definir los endpoints para la gestión de productos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Crear un nuevo proyecto Spring Boot.
- Definir los endpoints para crear, leer, actualizar y eliminar productos.
- Verificar que los endpoints respondan correctamente a las solicitudes.

**Entregable:** Proyecto Spring Boot con endpoints definidos y funcionales.

<details>
<summary>Pistas de conocimiento</summary>

- Uso de anotaciones en Spring para definir endpoints.
- Configuración básica de un proyecto Spring Boot.

</details>

### Fase 2: Control de variables de entorno y generación de logs

**Objetivo:** Implementar el control de variables de entorno y la generación de registros de rastros en la API.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Configurar variables de entorno para la configuración de la API.
- Implementar la generación de logs para monitorear las solicitudes y respuestas de la API.

**Entregable:** API con control de variables de entorno y generación de logs funcional.

<details>
<summary>Pistas de conocimiento</summary>

- Uso de propiedades de aplicación en Spring para variables de entorno.
- Implementación de logging en Spring utilizando SLF4J y Logback.

</details>

### Fase 3: Conexión a base de datos utilizando ORM

**Objetivo:** Conectar la API a una base de datos utilizando un ORM y definir las entidades y repositorios para gestionar productos.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Configurar la conexión a una base de datos utilizando un ORM.
- Definir las entidades y repositorios para gestionar productos en la base de datos.

**Entregable:** API conectada a una base de datos con entidades y repositorios definidos.

<details>
<summary>Pistas de conocimiento</summary>

- Configuración de la conexión a la base de datos en Spring.
- Definición de entidades y repositorios utilizando JPA.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es Spring Framework y para qué se utiliza en el desarrollo de aplicaciones?
- **paraQueSirve**: ¿Para qué sirve el control de variables de entorno en una aplicación Spring?
- **comoSeUsa**: ¿Cómo se utiliza un ORM en Spring para conectarse a una base de datos?
- **erroresComunes**: ¿Cuáles son los errores comunes al configurar logging en Spring?
- **queDecisionesImplica**: ¿Qué decisiones implica la elección de un ORM en un proyecto Spring?

## Criterios de Evaluacion

- Configuración correcta del proyecto Spring Boot.
- Definición de endpoints funcionales para la gestión de productos.
- Control de variables de entorno en la API.
- Generación de logs para monitoreo de solicitudes y respuestas.
- Conexión a base de datos utilizando un ORM.
- Definición de entidades y repositorios para gestionar productos.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
