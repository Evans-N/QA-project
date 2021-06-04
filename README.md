Coverage: 40%
# QA-IMS-Project
-----------------------------------
An application that an end user can interact with via a Command-Line Interface (CLI). The application required is an inventory management system, that needs to be able to:
- **Add** a **customer** to the system
- **View** all **customers** in the system
- **Update** a **customer** in the system
- **Delete** a **customer** in the system
- **Add** an **item** to the system
- **View** all **items** in the system
- **Update** an **item** in the system
- **Delete** an **item** in the system
- **Create** an **order** in the system
- **View** all **orders** in the system
- **Delete** an **order** in the system
- **Add** an **item** to an **order**
- **Calculate** a **cost** for an **order**
- **Delete** an **item** in an **order**

## Getting Started
-----------------------------------
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

The application runs off of this MySQL Schema.  
_(If you do not have MySQL click [here](https://dev.mysql.com/downloads/installer/) to download.)_

```drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `last_name` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(40) DEFAULT NULL,
  `value` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE `orders`;

CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customers_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ;

CREATE TABLE `orders_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `item_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  FOREIGN KEY (`item_id`) REFERENCES `items` (`id`),
  FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
);
``` 
This application also runs on Java.  
_(If you do not have Java downloaded, you can do so [here](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html).)_

### Installing

A step by step series of examples that tell you how to get a development env running

You will need to setup db.properties credentials. ***This is private info: DO NOT SHARE***.  
_(I have added my file in with false credential as an example.)_

```
db.url=jdbc:mysql://localhost:3306/ims?serverTimezone=UTC
db.user=root
db.password=XXXXXXX
```

Now lets download our dependencies in the program.  
- locate pom.xml file
- right click file
- Maven -> Update Project

Next we will run our program in Command Line.

```
mvn clean package
cd target
java -jar ims-0.0.1-jar-with-dependencies.jar
```

Now we can follow the prompts of the program.
```
Welcome to the Inventory Management System!
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
STOP: To close the application

```

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
