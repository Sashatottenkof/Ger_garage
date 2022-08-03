## Deployment

The App is deployed on free hosting provided by Heroku.

https://gergarage.herokuapp.com/

Default users:

email: admin@gmail.com; pass: 1111;
email: user@gmail.com; pass: 2222;

## To Start


The application is set up for PostgreSQL Database, so you need to change application.properties file to connect to your 
own database. It also can be changed to mySQL with minor changes.


Change email settings to use your email for notification purposes;

http://localhost:8080/



# General description

The Web application is designed for small car-repair shop “Ger’s Garage”. 
The shop carries out maintenance checks for all kinds of small to medium vehicles (i.e. motorbikes, cars, small vans and small buses).
It also sells require parts or other supplies to its customers if required. 
The shop has small number of staff who work there.
Web service allows customers to book their vehicles for a check-up or service.


The back-end is implemented with Spring Boot framework with 
Thymeleaf template engine for managing front-end.
Authentication and authorization is handled by Spring Security Service.
Hibernate is used as JPA to establish an interaction with database(PostgreSQL). The Service
follows three-layer architecture (Controller-Service-Repository).
Gradle is used as a  build automation tool to manage project architecture for classes, resources and dependencies. 


## Project Requirements:

1) Customer has to be able to register on the website;
2) Customers details and information about his bookings should be saved in the service system;
3) Customer can book a vehicle for a service or repair;
4) At least 4 types of booking available:
5) Only 4 bookings on one day can be done.
6) Sunday is not available for booking;
7) Customer should provide information about vehicle;
8) Owner of the shop have to have admin access to all bookings for any day or week;
9) Owner can allocate each mechanic to each vehicle;
10) Owner has only 1 mechanic available on one day;
11) Owner can print the schedule for any particular day;
12) One mechanic can carry our no more than 4 services in one day. A Major Repair is count for double.
13) Owner should be able to allocate costs to each booking;
14) Owner can add additional item to the cost of service;
15) Owner needs to be able to print an “invoice” or bill for each customer when the service/repair is complete. This should provide an itemised bill for the customer.

e_schema.png)
![DataBase design](https://github.com/Sashatottenkof/Ger_garage/blob/master/src/main/resources/static/images/GitHub_Images/DataBas
Physical Data Base Design


![Functionality](https://github.com/Sashatottenkof/Ger_garage/blob/master/src/main/resources/static/images/GitHub_Images/Functionality.png)
General look at New Visitor Functionality


## Web Service has additional features:

• Users email verification and email notification after successful registration;

• Expiration token for logged in user (24 hours);

• User can alter its details after registration;

![DataBase design](https://github.com/Sashatottenkof/Ger_garage/blob/master/src/main/resources/static/images/GitHub_Images/Booking-Form.png)
Booking Form


![DataBase design](https://github.com/Sashatottenkof/Ger_garage/blob/master/src/main/resources/static/images/GitHub_Images/Admin-Dashboard.png)
Admin dashboard


## During the development following tools and technologies are being used:

• SpringBoot - a core of backend; 

• PostgreSQL - data base;

• Hibernate -  to set up connection between java source code and MySQL database and manipulate data with little coding;

• Gradle - As a build automation tool;

• Thymeleaf - for setting up a connection between frontend and backend parts together;

• HTML and CSS;

• Javascript;

• jQuery;

• Bootstrap;

• Docker - was used to run a database during its development process and deploy whole web application on the Google Cloud Platform.

• Google Engine - was used as a live-server to deploy the app for testing;


