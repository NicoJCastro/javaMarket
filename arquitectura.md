.
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

### JPA

JPA (Java Persistence API) es una especificación de Java que proporciona un estándar para gestionar la persistencia de datos en aplicaciones Java. La persistencia permite almacenar información en una base de datos para su posterior recuperación y uso.

### Características principales:
- **Mapeo Objeto-Relacional (ORM)**: Permite mapear clases Java a tablas en bases de datos y viceversa.
- **Consultas con JPQL**: Proporciona un lenguaje de consulta similar a SQL, pero orientado a objetos.
- **Gestión de Entidades**: Facilita la creación, lectura, actualización y eliminación de objetos persistentes.
- **Transacciones**: Manejo automático de transacciones de base de datos de manera declarativa.

### Ejemplo de Entidad JPA
```Java
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
