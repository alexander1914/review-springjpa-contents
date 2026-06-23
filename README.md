# Review Spring JPA contents
Describing the best practices with JPA:

# Getting Started
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.6/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.6/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.6/reference/data/sql.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### JPA Persistence API Annotations

*@Table*: is annotation in JPA is used to define the database table mapping for an entity.

*@Entity*: is annotation of the Java class can indicate that it is the entity, 
and it can represent the tables in the relational database.

*@Id*: is annotation used to define the primary key of a JPA entity, uniquely identifying each record in the database.

*@GeneratedValue*: is annotation to work automatically generate IDs

*@GeneratedValue*: is annotation provides us with different strategies for the generation of primary keys

*@UniqueConstraint*: is annotation that enforces unique constraints on one or more columns.

*@Column*: is annotation that specified, JPA automatically maps the field name to a column with the same name.

*@CreationTimestamp*: is annotation a convenient annotation that sets the field value to the current timestamp 
when the entity is first saved.

*@UpdateTimestamp*: is annotation another annotation provided by Hibernate. 
It automatically sets the field value to the current timestamp on each entity update.

*@Repository*: is annotation used to indicate that the class is a Data Access Object(DAO) or repository
The main purpose of the **@Repository** annotation is to interact with a database. 
It encapsulates the logic required to access and manipulate data.

### Query Lookup Strategies
The JPA module supports defining a query manually as a String or having it being derived from the method name.
Derived queries with the predicates **IsStartingWith**, **StartingWith**, **StartsWith**, **IsEndingWith**, 
**EndingWith**, **EndsWith**, **IsNotContaining**, **NotContaining**, **NotContains**, **IsContaining**, **Containing**, 
Contains the respective arguments for these queries will get sanitized. 
This means if the arguments actually contain characters recognized by LIKE as wildcards these will get escaped so 
they match only as literals. 
The escape character used can be configured by setting the escapeCharacter of the **@EnableJpaRepositories** annotation. 

    public interface UserRepository extends Repository<User, Long> {

    List<User> findByEmailAddressAndLastname(String emailAddress, String lastname);

    }


