# CRM Application
A simple CRM application built with Java & Spring Boot that allows for CRUD operations, deployable as a desktop app using Electron.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Usage](#usage)
- [Deployment](#deployment)
- [Built With](#built-with)
- [License](#license)
- [Project Structure](#project-structure)


## Prerequisites

- Java 17
- Maven
- Node.js

## Usage

In this application a user can:

- View a table of customers
- Create new customer entries
- Edit existing customer information
- Delete customer entries

### Preview

***Table is prepopulated with placeholder data for demonstration purposes***

![crm](https://github.com/jenschrad/final-project/assets/109177708/4b77e682-9320-46da-8692-38ee7a6c7367)


## Deployment 

In Windows, to deploy as a desktop application using Electron, run the following from the command line:
```powershell
java -jar crm.war
npm run crm
```

## Built With
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [H2 Database Engine](https://www.h2database.com)
- [Electron](https://www.electronjs.org/)

## License
This project is licensed under the MIT License - see the LICENSE.md file for details.


## Project Structure
This project is a fullstack application created to manage customer information.
### Data Layer
**Path:** _src/main/java/com/app/crm/data_

The data layer includes data access logic and entities within the application.

_/entities_
``Customer.java``

_/repos_
``CustomerRepo.java``


### Controller Layer
**Path:** _src/main/java/com/app/crm/controllers_

The controller layer is responsible for defining endpoints, mapping HTTP requests, and returning appropriate responses to the client.

``CustomerController.java``



### Service Layer
**Path:** _src/main/java/com/app/crm/services_

The service layer contains the business logic for the application, coordinates the interactions between entities & repositories, and processes data from controllers.

``CustomerService.java``
``ICustomerService.java``

### Resource Layer
**Path:** _src/main/resources_

The resource layer holds the HTML, CSS, and SQL files for the project.

**CSS:**
_resources/static/css_

**HTML:**
_resources/templates/customer_

**SQL:**
_data.sql_ & _schema.sql_
