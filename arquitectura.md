.
```
├── paltzi-market.iml
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── platzi
│   │   │           └── platzi market
│   │   │               ├── domain
│   │   │               │   ├── dto
│   │   │               │   ├── repository
│   │   │               │   └── service
│   │   │               ├── PaltziMarketApplication.java
│   │   │               ├── persistance
│   │   │               │   ├── crud
│   │   │               │   └── entity
│   │   │               └── web
│   │   │                   └── controller
│   │   └── resources
│   │       ├── application.properties
│   │       ├── application.yaml
│   │       ├── keystore
│   │       │   └── rtc4j.p12
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── platzi
│                   └── market
│                       └── PaltziMarketApplicationTests.java
```

### JPA

JPA (Java Persistence API) es una especificación de Java que proporciona un estándar para gestionar la persistencia de datos en aplicaciones Java. La persistencia permite almacenar información en una base de datos para su posterior recuperación y uso.

### Características principales:
- **Mapeo Objeto-Relacional (ORM)**: Permite mapear clases Java a tablas en bases de datos y viceversa.
- **Consultas con JPQL**: Proporciona un lenguaje de consulta similar a SQL, pero orientado a objetos.
- **Gestión de Entidades**: Facilita la creación, lectura, actualización y eliminación de objetos persistentes.
- **Transacciones**: Manejo automático de transacciones de base de datos de manera declarativa.

### Ejemplo de Entidad JPA
```java
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;

    // Getters y setters
}
```

En este ejemplo, la clase `Producto` es una entidad JPA que se mapeará directamente a una tabla en la base de datos.

- La anotación `@Entity` indica que esta clase es una entidad gestionada por JPA.
- `@Id` define la clave primaria de la tabla.
- `@GeneratedValue(strategy = GenerationType.IDENTITY)` especifica que el valor del identificador será generado automáticamente por la base de datos.

JPA facilita la persistencia de datos en aplicaciones Java al abstraer la lógica de acceso a la base de datos.  
Es ampliamente utilizado en el desarrollo empresarial y es compatible con distintos proveedores de persistencia, como **Hibernate, EclipseLink y OpenJPA**, que implementan esta especificación y ofrecen funcionalidades adicionales.

#### Dominio vs Persistencia

Cuando trabajas con arquitectura limpia o capas bien definidas, hay una separación clara entre la capa de dominio (la lógica del negocio) y la capa de persistencia (cómo se almacenan los datos en la base de datos).

**Ejemplo en tu código:**

Tienes dos clases clave:

- **Product (Dominio):** Representa un producto en el negocio.
- **Producto (Persistencia):** Representa cómo se almacena un producto en la base de datos.

Si tu código estuviera mal alineado al dominio, podrías haber hecho que la aplicación trabajara directamente con `Producto` en todas partes. Eso significaría que toda la lógica del negocio dependería directamente de cómo están las tablas en la base de datos, lo cual no es bueno porque limita la flexibilidad.

#### Beneficios de esta separación

✔ Independencia de la base de datos: Si en el futuro decides cambiar de MySQL a MongoDB, solo necesitas cambiar la implementación de `ProductoRepository`, pero el resto de la aplicación seguirá funcionando igual.

✔ Código más mantenible y flexible: La lógica del negocio se mantiene en `Product`, mientras que `Producto` solo es relevante para la base de datos.

✔ Facilita pruebas unitarias: Puedes probar la lógica del negocio sin depender de la base de datos.

#### Inyección de Dependencias (DI)

La Inyección de Dependencias (Dependency Injection, DI) es un patrón de diseño que permite a un objeto recibir sus dependencias de un objeto externo en lugar de crearlas por sí mismo. Esto promueve la separación de responsabilidades y facilita la prueba y el mantenimiento del código.

### Conceptos Clave

- **Dependencia**: Es cualquier objeto que una clase necesita para funcionar.
- **Inyección**: Es el proceso de proporcionar las dependencias a una clase en lugar de que la clase las cree.

### Tipos de Inyección de Dependencias

1. **Constructor Injection**: Las dependencias se pasan a través del constructor de la clase.
2. **Setter Injection**: Las dependencias se pasan a través de métodos setter.
3. **Field Injection**: Las dependencias se inyectan directamente en los campos de la clase (menos recomendado por problemas de testabilidad).

### Optional en Java

**¿Qué es Optional?**

Optional es una clase introducida en Java 8 como parte del paquete `java.util`. Su propósito principal es proporcionar una forma segura y elegante de manejar valores que pueden ser `null`, evitando así los temidos `NullPointerException`.

**¿Por qué usar Optional?**

Antes de Optional, cuando un método podía devolver un valor o `null`, el programador tenía que verificar manualmente si el valor era `null` antes de usarlo. Esto llevaba a código propenso a errores y menos legible. Con Optional, se encapsula el valor potencialmente nulo dentro de un contenedor, lo que permite manejar explícitamente el caso en que no haya valor disponible.