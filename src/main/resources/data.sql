--delete from  verification_token;
--delete from  items;
--delete from  item;
--delete from  booking_request;
--delete from vehicle;
--delete from  users_roles;
--delete from  role;
--delete from  user_details;
--delete from  mechanics;
--delete from  persistent_logins;

create table if not exists persistent_logins (
     username varchar(100) not null,
     series varchar(64) primary key,
     token varchar(64) not null,
     last_used timestamp not null
);

--deafault roles
INSERT INTO role (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

--default users
INSERT INTO user_details (id, email, password, username, first_name, last_name, gender, date_of_birth, enabled) VALUES
(1, 'admin@gmail.com', '$2a$10$rXnjuySCmW6jqP77IrYXHusdMoJzUEnSeh6XOJ4ErbzBGPeSQrbXa', 'Admin', 'Ger', 'Harrison', 'MALE', '1990-01-09', true),
(2, 'user@gmail.com', '$2a$10$nSpZ0ZPr/XM7KVDyDOw.4OB.kXWMELjQ9rc7pICqrtChBnVPHPog2', 'User','Ger', 'Harrison', 'MALE', '1990-01-09', true);

insert into users_roles(user_id, role_id) values
(1,1),
(2,2);

--test vehicles
INSERT INTO vehicle (vehicle_id, type, engine, licence, make, mileage, age, model, USER_ID, other_details) VALUES
(1, 'SEDAN', 'DIESEL','123123', 'FORD', '100', '2', 'Focus','1', 'test'),
(2, 'SEDAN', 'ELECTRIC','134431f', 'SUBARU', '200', '2', 'XV','2','test');

--default mechanics
INSERT INTO mechanics (id, first_name, last_name)VALUES
(1, 'Kile ', 'Jason'),
(2, 'Bob ', 'Marley'),
(3, 'Dart ', 'Vaider'),
(4, 'Frodo ', 'Beggins');


--default items
INSERT INTO item (id, name, price)VALUES
(1, 'Wheel ', 200.0),
(2, 'Oil', 30.0),
(3, 'Battery', 150.0),
(4, 'Exterior Lights', 50.0),
(5, 'Brake Rotor', 100.0),
(6, 'Windshield', 500.0),
(7, 'Headlight Components', 100.0),
(8, 'Oil', 30.0),
(9, 'Spark Plugs', 90.0),
(10, 'Door Handles/Locks', 50.0),
(11, 'Fuses', 60.0),
(12, 'Remote Keyless Entry', 40.0),
(13, 'Tire Pressure Monitoring System', 200.0),
(14, 'Oil Filter', 200.0),
(15, 'Air filter', 200.0),
(16, 'Brake Pad', 50.0),
(17, 'Belt', 70.0),
(18, 'Brake Caliper', 60.0),
(19, 'Wheel Cylinder', 100.0),
(20, 'Master Cylinder', 150.0),
(21, 'Fuel Pump', 100.0),
(22, 'Water pump', 100.0),
(23, 'Engine Sensor', 55.0),
(24, 'Muffler', 90.0),
(25, 'Shock', 80.0),
(26, 'Strut', 70.0),
(27, 'Clutch', 200.0),
(28, 'Automatic Transmission', 1000.0),
(29, 'Wiper Blade', 30.0),
(30, 'Starter Motor', 200.0),
(31, 'Seat', 200.0),
(32, 'Trunk', 300.0),
(33, 'Control Arm', 400.0),
(34, 'Oil Drain Plug', 5.0),
(35, 'Leaf Spring', 100.0),
(36, 'Air Suspention', 200.0),
(37, 'Coil Spring', 50.0),
(38, 'Bumper', 100.0),
(39, 'Radiator Grille', 150.0),
(40, 'Towbar', 300.0);
--DECLARE @dIncr DATE = '2020-06-01'
--DECLARE @dEnd DATE = '2021-06-01'
--
--WHILE ( @dIncr < @dEnd )
--BEGIN
--  INSERT INTO CALENDAR(date) VALUES( @dIncr )
--  SELECT @dIncr = DATEADD(DAY, 1, @dIncr )
--END
