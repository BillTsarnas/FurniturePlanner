drop database if exists furnitureplanner;
create database furnitureplanner;

use furnitureplanner;

SET SQL_SAFE_UPDATES = 0;

SET GLOBAL innodb_buffer_pool_size=268435456;
/*We create our main table where we are performing our data analysis*/

CREATE TABLE CLIENTS 
(
    clientid                int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    surname                 varchar(255),
    mphone 				    varchar(20),
    hphone 				    varchar(20),
    email 					varchar(100),
    address 				varchar(255),
    PRIMARY KEY(clientid)
);


insert into CLIENTS (name,surname,mphone,hphone, email, address) VALUES
('Ruben Enrique','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 1','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 2','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 3','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 4','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 5','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 6','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 7','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 8','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 9','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 10','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   ),
('Ruben 11','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'   );



CREATE TABLE ORDERS 
(
    orderid                  int NOT NULL AUTO_INCREMENT,
    name                     varchar(255),  
    clientid	 			 int,
    installmentid            int,
    totalcost                float,
	status                   int,
    PRIMARY KEY(orderId)
);



CREATE TABLE ORDER_INSTALLMENTS 
(
    orderid                  int,
    installmentid 		     int,
    paytype                  varchar(255),
    PRIMARY KEY(orderid, installmentid)
);


CREATE TABLE INSTALLMENTS 
(
    installmentid                  int NOT NULL AUTO_INCREMENT,
    amount                         float,
    PRIMARY KEY(installmentid)
);


CREATE TABLE ORDER_FURNITURE 
(
    orderid                  int,
    furnitureid 		     int,
    type                     varchar(255),
    PRIMARY KEY(orderid, furnitureid)
);


CREATE TABLE FURNITURE 
(
    furnitureid              int NOT NULL AUTO_INCREMENT,
    name                     varchar(255),  
    numOfExtraParts          int,
    numOfCuts 				 int,
    PRIMARY KEY(furnitureId)
);


CREATE TABLE FURNITURE_MATERIAL 
(
    furnitureid              int,
    materialid               int,  
  
    PRIMARY KEY(furnitureId,materialid)
);


CREATE TABLE MATERIAL_CATALOGUE 
(
    materialid              int NOT NULL AUTO_INCREMENT,
    name  					varchar(255),
    cost                 	varchar(255),
    colour 				    varchar(255),
    PRIMARY KEY(materialid)
);

INSERT INTO MATERIAL_CATALOGUE(name,cost,colour) VALUES
('melamine','50','black'),
('oak','200','brown'),
('maple', '250','dark');


CREATE TABLE FURNITURE_EXTRAPARTS 
(
    extrapartid                  int NOT NULL,
    furnitureid             int,
    PRIMARY KEY(extrapartid,furnitureid)
);

INSERT INTO FURNITURE_EXTRAPARTS(extrapartid,furnitureid) VALUES
('1','0'),
('1','1'),
('2','1'),
('3','0'),
('4','0'),
('5','0'),
('6','0'),
('7','1');


CREATE TABLE EXTRAPARTS_CATALOGUE 
(
    extraPartsid            int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    cost                 	varchar(255),
    PRIMARY KEY(extraPartsid)
);


INSERT INTO EXTRAPARTS_CATALOGUE(name,cost) VALUES
('Rail', '5'),
('Handle', '1'),
('Wheel_small','2'),
('Dish Case','3'),
('Cutlery Case','2'),
('Trash Can','4'),
('Wardrobe bar','2');


CREATE TABLE BOXES_FURNITURE 
(
    furnitureid             int NOT NULL AUTO_INCREMENT,
    boxid 				    int NOT NULL,
    sizeinsqmts             int,
    PRIMARY KEY(furnitureid,boxid)
);


CREATE TABLE BOX
(
    boxId             		int NOT NULL AUTO_INCREMENT,
    height 				    int NOT NULL,
    width                   int NOT NULL,
    depth                   int,
    thickness               int,
    back_thickness          double,
    colour                  varchar(255),
    num_shelves             int,
    PRIMARY KEY(boxId)
);

