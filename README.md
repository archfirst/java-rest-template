# Java REST Template
This template provides a starter project that implements best practices in Java, REST and Domain-Driven Design. Features include:
- Use of the [Hexagonal Architecture](http://alistair.cockburn.us/Hexagonal+architecture) to arrange the application into logical layers, with well-defined responsibilities.
- RESTful APIs are implemented using the [Spring MVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) framework.
- Persistence is implemented using an in-memory repository layer. This can be substituted with any persistence technology of your choice.

You may also want to review the companion project [Java Cucumber Template](https://github.com/archfirst/java-cucumber-template). It contains a template for acceptance testing of RESTful applications.

## Quick Start
To run the application locally:
```bash
$ mvn install
$ mvn spring-boot:run
```
To verify that the application is working correctly, point your browser to [http://localhost:8080/accounts](http://localhost:8080/accounts) - you should see a response with a list of accounts in JSON format. Since the persistence layer is in memory, the list will be empty.

## Package Structure

```
org.archfirst.template
    adapter
        persistence
        rest
    application
    domain
```

The package structure is arranged into logical layers as suggested by the [Hexagonal Architecture](http://alistair.cockburn.us/Hexagonal+architecture) (a.k.a. the [Onion Architecture](http://jeffreypalermo.com/blog/the-onion-architecture-part-1/)):

- The `adapter` layer *adapts* interactions from the external world to the application layer. It contains two adapters:
    - The REST adapter converts incoming HTTP messages to a format acceptable by the application layer.
    - The persistence adapter that reads and writes domain objects to persistence storage (in this case, simply to memory).

- The `application` layer coordinates high-level activities such as creation of the domain objects and asking them to perform tasks requested by the external world.

- The `domain` layer encapsulate the state and behavior of the business domain. It consists of entities and value objects. See [this article](https://archfirst.org/domain-driven-design/) for a detailed description of the domain layer.
