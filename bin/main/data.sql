delete from  booking_request;
delete from vehicle;
delete from  users_roles;
delete from  role;
delete from  user_details;


INSERT INTO role (id, name) VALUES 
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO user_details (id, email, password, username, first_name, last_name, gender, date_of_birth) VALUES 
(1, 'admin@gmail.com', '1111', 'Admin', 'Ger', 'Harrison', 'MALE', '1990-01-09'),
(2, 'user@gmail.com', '2222', 'User','Ger', 'Harrison', 'MALE', '1990-01-09');

insert into users_roles(user_id, role_id) values
(1,1),
(2,2);

INSERT INTO vehicle (vehicle_id, type, engine, licence, make, mileage, age, model, USER_ID, other_details) VALUES 
(1, 'SEDAN', 'DIESEL','123123', 'MERCEDES', '100', '2', 'xxy','1', 'test'),
(2, 'SEDAN', 'ELECTRIC','134431f', 'MERCEDES', '200', '2', 'tt1','2','test');