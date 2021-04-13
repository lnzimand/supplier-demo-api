# Supplier-Demo-API

## Table Of Contents
* [General Info](#general-info)
* [Technologies](#technologies)
* [API Layer Classes Info](#api-layer-classes-info)
* [Service Layer Classes Info](#service-layer-classes-info)
* [Data Layer Classes Info](#data-layer-classes-info)

## General Info
A demo application programming interface for registering, modifying, and viewing suppliers.

## Technologies
* ##### Java<br/>
  How to install Java on various OS:
  https://java.com/en/download/help/download_options.html
* #### Spring Boot<br/>
  How to initialize Spring Boot:
  https://start.spring.io/
* #### Intellij<br/>
  How to install Intellij: https://www.jetbrains.com/help/idea/installation-guide.html#snap
* #### Git<br/>
  How to install Git: https://git-scm.com/downloads

## API Layer Classes Info
#### Package Name
* com.example.SupplierDemoAPI.controller
###### Class Name
* SupplierController<br/>
  @GetMapping getSuppliers: gets a list of all suppliers from Service Layer's getSuppliers (JSON file)<br/>
  @GetMapping(path = "companyId") getSupplier: gets a JSON file for a supplier from Service Layer's getSupplier with a provided ID<br/>
  @PostMapping(path = "register") registerNewSupplier: takes supplier info and pass it to Service Layer's addNewSupplier to store supplier's info into the database<br/>
  @DeleteMapping(path = "delete/{companyId}") deleteSupplier: takes a supplier ID and pass it to Service Layer's deleteSupplier for deletion of a supplier from a database<br/>
  @PutMapping(path = "update/{companyId}") updateSupplier: updates a supplier information

## Service Layer Classes Info
#### Package Name
* com.example.SupplierDemoAPI.service
###### Class Name
* SupplierService<br/>
  getSuppliers: gets all suppliers info from a Data Layer Service and pass it back to the API Layer Service<br/>
  addNewSupplier: gets a JSON file for a supplier from a Data Layer Service, with a provided ID, and pass it back to the API Layer Service<br/>
  deleteSupplier: takes a new supplier info from API LAyer Service and pass to the Data Layer Service to create a new user<br/>
  updateSupplier: updates a supplier information<br/>
## Data Layer Classes Info
#### Package Name
* com.example.SupplierDemoAPI.domain.repository
###### Class Name
* SupplierRepository<br/>
  Handles all database requests
