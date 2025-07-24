# Bootcamp - Proyecto Java Multimódulo

Este proyecto es una plantilla base para aplicaciones Java con arquitectura multimódulo, usando Gradle y Spring Boot.

## Estructura del proyecto

- `technology-api/` - Módulo de ejemplo con API y lógica de negocio
- `proyecto2/`, `proyecto3/`, `proyecto4/`, `proyecto5/` - Módulos adicionales (estructura similar a technology-api)

## Requisitos

- Java 17 (LTS)
- Gradle 8+

## Compilación y ejecución

```bash
./gradlew build
```

Para ejecutar un módulo Spring Boot (por ejemplo, technology-api):

```bash
cd technology-api
../gradlew bootRun
```

## Notas
- Todas las dependencias y configuraciones comunes están centralizadas en el `build.gradle` raíz.
- El archivo `.gitignore` en la raíz cubre todos los subproyectos y herramientas comunes.

## Personalización
Agrega tus propios módulos siguiendo la estructura de `technology-api` y hereda la configuración automáticamente.

--- 