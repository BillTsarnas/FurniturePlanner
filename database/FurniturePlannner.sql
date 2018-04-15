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


DROP TABLE IF EXISTS ORDERS;

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


DROP TABLE IF EXISTS ORDER_INSTALLMENTS;

CREATE TABLE ORDER_INSTALLMENTS 
(
    orderid                  int,
    installmentid 		     int,
    paytype                  varchar(255),
    PRIMARY KEY(orderid, installmentid)
);

DROP TABLE IF EXISTS INSTALLMENTS;

CREATE TABLE INSTALLMENTS 
(
    installmentid                  int NOT NULL AUTO_INCREMENT,
    amount                         float,
    PRIMARY KEY(installmentid)
);

DROP TABLE IF EXISTS ORDER_FURNITURE;

CREATE TABLE ORDER_FURNITURE 
(
    orderid                  int,
    furnitureid 		     int,
    type                     varchar(255),
    PRIMARY KEY(orderid, furnitureid)
);

DROP TABLE IF EXISTS FURNITURE;

CREATE TABLE FURNITURE 
(
    furnitureid              int NOT NULL AUTO_INCREMENT,
    name                     varchar(255),  
    numOfExtraParts          int,
    numOfCuts 				 int,
    PRIMARY KEY(furnitureId)
);

DROP TABLE IF EXISTS FURNITURE_MATERIAL;

CREATE TABLE FURNITURE_MATERIAL 
(
    furnitureid              int,
    materialid               int,  
  
    PRIMARY KEY(furnitureId,materialid)
);

DROP TABLE IF EXISTS MATERIAL_CATALOGUE;

CREATE TABLE MATERIAL_CATALOGUE 
(
    materialid              int NOT NULL AUTO_INCREMENT,
    name  					varchar(255),
    cost                 	varchar(255),
    colour 				    float,
    PRIMARY KEY(materialid)
);

DROP TABLE IF EXISTS FURNITURE_EXTRAPARTS;

CREATE TABLE FURNITURE_EXTRAPARTS 
(
    extrapartid                  int NOT NULL AUTO_INCREMENT,
    furnitureid             int,
    PRIMARY KEY(userid,furnitureid)
);

DROP TABLE IF EXISTS EXTRAPARTS_CATALOGUE;

CREATE TABLE EXTRAPARTS_CATALOGUE 
(
    extraPartsid            int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    cost                 	varchar(255),
    PRIMARY KEY(extraPartsid)
);

DROP TABLE IF EXISTS BOXES_FURNITURE;

CREATE TABLE BOXES_FURNITURE 
(
    furnitureid             int NOT NULL AUTO_INCREMENT,
    boxid 				    int NOT NULL,
    sizeinsqmts             int,
    PRIMARY KEY(furnitureid,boxid)
);

DROP TABLE IF EXISTS BOX;

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

