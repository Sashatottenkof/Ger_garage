# Ger_garage
Web Service for car-repair shop
The Web application is designed for small car-repair shop “Ger’s Garage”, That shop carries out maintenance checks for all kinds of small to medium vehicles (i.e. motorbikes, cars, small vans and small buses). It also sells require parts or other supplies to its customers if required. Ger has a small number of staff who work with him.
Web service allows customers to book their vehicles for a check-up or service.


## Web Service Requirements:
1) Customer has to be able to register on the website;
2) Customers details and information about his bookings should be saved in the service system;
3) Customer can book a vehicle for a service or repair;
4) At least 4 types of bookings available:
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

## During the development following tools and technologies have been used:

• SpringBoot - a core of backend; 

• MySQL - data base;

• Worckbench;

• Hibernate -  to set up connection between java source code and MySQL database and manipulate data with little coding;

• Gradle - As a build automation tool;

• Thymeleaf - for setting up a connection between frontend and backend parts together;

• HTML and CSS;

• Javascript;

• jQuery;

• Bootstrap;

• Docker - was used to run database during development and deploy whole web application on a Google Cloud Platform.

• Google Engine - was used as a live-server to deploy the app;

## To Start

Set up a database in a Docker container 

**$ docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql**

**192.168.99.100:3306/Ger_garage**

http://localhost:8080/


