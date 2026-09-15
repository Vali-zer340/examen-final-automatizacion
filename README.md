# Examen Final - Automatización de Pruebas

Proyecto desarrollado para el Examen Final de la asignatura Automatización de Pruebas.

El objetivo del proyecto es implementar un proceso completo de automatización utilizando Java, Maven, JUnit 5, Git, GitHub y GitHub Actions, incorporando pruebas unitarias, pruebas de integración, pruebas de aceptación, integración continua y un pipeline de despliegue con rollback.

---

## Tecnologías utilizadas

- Java 17
- Maven
- JUnit 5
- Maven Surefire Plugin
- Maven Failsafe Plugin
- Git
- GitHub
- GitHub Actions

---

## Estrategia de versionado

Para el desarrollo del proyecto se utilizó un flujo de ramas basado en GitFlow.

Las principales ramas son:

- `main`: versión estable del proyecto.
- `develop`: rama de integración.
- `feature/pruebas`: desarrollo de pruebas automatizadas.
- `feature/ci-pipeline`: configuración del pipeline de integración continua.
- `feature/deployment-pipeline`: configuración del pipeline de despliegue.
- `feature/documentacion`: elaboración de la documentación.

Cada nueva funcionalidad fue desarrollada en una rama `feature` y posteriormente integrada a `develop`.

---

## Estructura del proyecto

```text
examen-automatizacion
│
├── .github
│   └── workflows
│       ├── ci.yml
│       └── deployment.yml
│
├── src
│   ├── main
│   │   └── java
│   │       └── cl/iplacex/automatizacion
│   │           ├── App.java
│   │           └── ProductoService.java
│   │
│   └── test
│       └── java
│           └── cl/iplacex/automatizacion
│               ├── ProductoServiceTest.java
│               ├── ProductoIntegrationIT.java
│               └── ProductoAcceptanceAT.java
│
├── .gitignore
├── pom.xml
└── README.md
```

---

## Estrategia de pruebas

El proyecto utiliza tres niveles de pruebas automatizadas.

### Pruebas unitarias

Las pruebas unitarias se encuentran en:

```text
ProductoServiceTest.java
```

Estas pruebas verifican individualmente el comportamiento de `ProductoService`.

Entre los casos evaluados se encuentran:

- cálculo correcto del total de una compra;
- rechazo de precios negativos.

Para ejecutarlas:

```bash
mvn clean test
```

---

### Pruebas de integración

Las pruebas de integración se encuentran en:

```text
ProductoIntegrationIT.java
```

Estas pruebas verifican la integración entre los datos utilizados y la lógica implementada en `ProductoService`.

Son ejecutadas mediante Maven Failsafe.

Para ejecutar las pruebas unitarias y de integración:

```bash
mvn clean verify
```

---

### Acceptance Tests

Los criterios de aceptación se encuentran implementados en:

```text
ProductoAcceptanceAT.java
```

Estos tests representan situaciones que debe cumplir el sistema desde el punto de vista funcional.

Ejemplos:

- un cliente debe obtener correctamente el total de una compra;
- el sistema debe rechazar cantidades negativas.

Se ejecutan mediante el perfil Maven `acceptance`:

```bash
mvn test -Pacceptance
```

---

## Pipeline de Integración Continua

El archivo:

```text
.github/workflows/ci.yml
```

define el pipeline de integración continua mediante GitHub Actions.

El pipeline incluye las siguientes etapas:

1. Descarga del repositorio.
2. Configuración de Java 17.
3. Compilación del proyecto.
4. Ejecución de pruebas unitarias.
5. Ejecución de pruebas de integración.
6. Generación y almacenamiento de reportes.

El flujo principal corresponde a:

```text
Build
  ↓
Pruebas automatizadas
  ↓
Reportes
```

Los reportes de Maven Surefire y Failsafe se almacenan como artifacts del workflow.

---

## Deployment Pipeline

El archivo:

```text
.github/workflows/deployment.yml
```

implementa el pipeline de despliegue utilizado en el proyecto.

El flujo está compuesto por:

```text
Build
  ↓
Pruebas unitarias e integración
  ↓
Acceptance Tests
  ↓
Deploy a ambiente de prueba
  ↓
Rollback
```

Antes del despliegue se genera un respaldo de la versión existente.

Posteriormente se realiza el despliegue de la nueva versión y se valida su funcionamiento.

Finalmente se ejecuta un rollback controlado para demostrar la recuperación de la versión anterior.

---

## Estrategia de Rollback

El mecanismo implementado mantiene dos estados:

```text
deploy/current
deploy/backup
```

Antes de realizar un nuevo despliegue, la versión actual se copia hacia `backup`.

La nueva versión es instalada en `current`.

Durante el proceso de rollback se elimina la versión desplegada y se restaura el contenido almacenado en `backup`.

Finalmente el pipeline valida que la versión restaurada corresponda a:

```text
version-anterior
```

confirmando que el rollback se realizó correctamente.

---

## Ejecución local

Para compilar el proyecto:

```bash
mvn clean compile
```

Para ejecutar pruebas unitarias:

```bash
mvn clean test
```

Para ejecutar pruebas unitarias e integración:

```bash
mvn clean verify
```

Para ejecutar Acceptance Tests:

```bash
mvn test -Pacceptance
```

---

## Evidencias

Durante el desarrollo se obtuvieron evidencias de:

- configuración del proyecto Maven;
- ejecución de pruebas unitarias;
- configuración del flujo Git;
- ejecución de pruebas unitarias e integración;
- ejecución exitosa del pipeline CI;
- generación de artifacts de pruebas;
- ejecución de Acceptance Tests;
- deployment pipeline exitoso;
- despliegue en ambiente de pruebas;
- ejecución y validación del rollback.

Las capturas correspondientes se incluyen en la documentación final del examen.

---

## Resultado

El proyecto implementa un flujo completo de automatización que incluye:

- versionamiento con Git y GitHub;
- proyecto Maven;
- pruebas unitarias;
- pruebas de integración;
- pruebas de aceptación;
- pipeline de integración continua;
- pipeline de despliegue;
- ambiente de prueba;
- mecanismo de rollback;
- generación de evidencias y artifacts.
