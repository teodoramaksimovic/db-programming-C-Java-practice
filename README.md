# Database Programming Practice

Solutions to database programming exercises covering embedded SQL in C, transaction management, dynamic SQL, and object-relational mapping with Hibernate.

## Repository structure

### `practice-sqc`

Exercises implemented in C using embedded SQL with IBM Db2.

Topics include:
- embedded SQL statements
- host variables
- cursors
- transaction management
- commit and rollback
- dynamic SQL
- error handling using SQLCA

The directory also contains two shell scripts used to simplify working with embedded SQL/C programs:

- one script handles the compilation process required to build an executable from an `.sqc` source file
- the other removes intermediate and generated files created during the compilation process

### `practice-java-hibernate`
Exercises implemented in Java using Hibernate ORM.

Topics include:
- entity mapping with JPA annotations
- CRUD operations
- Hibernate sessions and transactions
- HQL queries
- entity relationships
- composite primary keys

## Database

The exercises use an IBM Db2 database based on the `STUD2020` schema used in the Database Programming course.

Database credentials and local Hibernate configuration are not included in the repository.

For Hibernate exercises, copy:

```text
hibernate.cfg.example.xml
