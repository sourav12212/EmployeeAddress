
<h1 align="center"> Employee-Address Mapping Project </h1>
<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
    <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4-brightgreen.svg" />
</a>
</p>

---

<p align="left">

## Overview
This project "Emplyee Address mapping project" is a Springboot application project that demonstrate One-to-One mapping between Employee and Address table.It provides a lot of API endpoints for creating , retrieving , updating and deleting to Employee and Address table.This project serves as a foundation of Employee corresponding their address.

## Technologies used
- **Framework:** Springboot
- **Language:** Java
- **Build Tool:** Maven

## Dependencies 
The EmployeeAddress application uses some dependencies

- **Springboot starter web**
    - **Description:** provides support for building web applications , including API endpoints
     - **Maven Dependencies**
         ```xml
           <dependency>
		        	<groupId>org.springframework.boot</groupId>
		        	<artifactId>spring-boot-starter-web</artifactId>
	          	</dependency>
     ```

- **Springboot starter data JPA**
    - **Description:** provides a set of pre-cnfigured components that helps to set-up and use JPA
     - **Maven Dependencies**
         ```xml
           <dependency>
		       	<groupId>org.springframework.boot</groupId>
			      <artifactId>spring-boot-starter-data-jpa</artifactId>
		      </dependency>
     ```

- **Springboot starter validation**
    - **Description:** provides a set of validation rules to input data from API
     - **Maven Dependencies**
         ```xml
           <dependency>
			      <groupId>org.springframework.boot</groupId>
			      <artifactId>spring-boot-starter-validation</artifactId>
	      	</dependency>
     ```

- **Lombok**
    - **Description:** provides a set of annotations that automatically creates getters,setters,constructors etc.
     - **Maven Dependencies**
         ```xml
           <dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
     ```

- **MySQL**
    - **Description:** MySQL JDBC helps to connect MySQL database.
     - **Maven Dependencies**
         ```xml
           <dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
     ```

- **Swagger**
    - **Description:**  Adds Swagger UI for documenting and testing your API endpoints.
     - **Maven Dependencies**
         ```xml
           <dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.1.0</version>
		</dependency>
     ```

## Data Flow
In the Employee-Address Mapping Project, data flows through various components to handle employee and address operations. Here's an overview of the data flow:

1. **Employee Entity**

   - **Controller Layer**

     The `EmployeeController` handles HTTP requests related to employees and routes them to the `EmployeeService`.
    ```
	@RestController
           public class EmployeeController {

            //some code
          }
    ```
    - **Service Layer**
  
      The `EmployeeService` interact with the Repository to perform CRUD operations.
      ```
      	@Service
        public class EmployeeService {
        @Autowired
        IEmployeeRepo employeeRepo;
	   // Implemented some service layer code to interact with the Repository 
      }

      ```

   - **Model Class**
  
      The `Employee` model class helps to declare how many entities are there in the Emplyee class.
      ```
      	@Data
         @NoArgsConstructor
        @AllArgsConstructor
        @Entity
          public class Employee {
      		// to declare employee tables entity
      }

      ```
      - **Repository Class**
  
      The `IEmployeeRepo` manages data access to the employee entity using Spring Data JPA.
      ```
      	@Repository
           public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
         }

      ```

1. **Address Entity**

   - **Controller Layer**

     The `AddressController` handles HTTP requests related to employees and routes them to the `AddressService`.
    ```
	@RestController
          public class AddressController {
    		// Implement some code
    ```
    - **Service Layer**
  
      The `AddressService` interact with the Repository to perform CRUD operations.
      ```
      	@Service
          public class AddressService {
      		

      ```

   - **Model Class**
  
      The `Address` model class helps to declare how many entities are there in the Address class.
      ```
      	@Data
      	@NoArgsConstructor
	 @AllArgsConstructor
	 @Entity
	 public class Address {

      ```
      - **Repository Class**
  
      The `IAddressRepo` manages data access to the address entity using Spring Data JPA.
      ```
      	@Repository
	 public interface IAddressRepo extends JpaRepository<Address,Long> {
	 }

      ```

## Data Structures

The project utilizes the following data structures to represent employees and address data:

#### Employee Class

The `Employee` class defines the structure for employee data and includes fields such as `employeeId`, `firstName`, and `lastName` and a foreign key to the Address table.

```
	@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    
    @Id
    private Integer employeeId;
    @NotBlank(message = "you must enter first name")
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "fk_addressId")
    private Address address;
}
```

#### Address Class

The `Address` class defines the structure for employee data and includes fields such as `addressId`, `street`, `city`,`state` and `zip code` 

```
	@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String zipcode;
}
```

## Database Configuration

The project is configured to connect to a MySQL database with the following properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/EmployeeAddress
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update


spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```

## Usage

1. Start your Spring Boot application.
2. Access the API endpoints to create, retrieve, update, and delete employee and addresses.

## Contact

For questions or feedback, please contact [Sourav Das](mailto:sourav12212@gmail.com).
