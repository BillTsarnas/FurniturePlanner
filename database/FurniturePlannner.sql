drop database if exists furnitureplanner;
create database furnitureplanner;

use furnitureplanner;

SET SQL_SAFE_UPDATES = 0;

SET GLOBAL innodb_buffer_pool_size=268435456;
/*We create our main table where we are performing our data analysis*/

CREATE TABLE USERS 
(
    userId                  int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    surname                 varchar(255),
    mphone 				    varchar(20),
    hphone 				    varchar(20),
    email 					varchar(100),
    address 				varchar(255),
    PRIMARY KEY(userId)
);


insert into USERS (name,surname,mphone,hphone, email, address) VALUES
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


DROP TABLE ORDERS;

CREATE TABLE ORDERS 
(
    orderId                  int NOT NULL AUTO_INCREMENT,
    name                     varchar(255),  
    userId	 				 int,
    installmentId            int,
    totalcost                float,
	status                   int,
    PRIMARY KEY(orderId)
);

DROP TABLE INSTALLMENTS;

CREATE TABLE INSTALLMENTS 
(
    installmentId                  int NOT NULL AUTO_INCREMENT,
    paytype 				       varchar(255),
    amount                         float,
    PRIMARY KEY(installmentId)
);

DROP TABLE ORDER_FURNITURE;

CREATE TABLE ORDER_FURNITURE 
(
    orderId                  int,
    furnitureId 		     int,
    type                     varchar(255),
    PRIMARY KEY(orderId, furnitureId)
);

DROP TABLE FURNITURE;

CREATE TABLE FURNITURE 
(
    furnitureId              int NOT NULL AUTO_INCREMENT,
    name                     varchar(255),  
    materialsId 			 int,
    numOfExtraParts          int,
    numOfCuts 				 int,
    PRIMARY KEY(furnitureId)
);

DROP TABLE MATERIAL_CATALOGUE;

CREATE TABLE MATERIAL_CATALOGUE 
(
    materialId              int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    cost                 	varchar(255),
    color 				    float,
    PRIMARY KEY(materialId)
);

DROP TABLE FURNITURE_EXTRAPARTS;

CREATE TABLE FURNITURE_EXTRAPARTS 
(
    userId                  int NOT NULL AUTO_INCREMENT,
    furnitureId             int,
    PRIMARY KEY(userId,furnitureId)
);

DROP TABLE EXTRAPARTS_CATALOGUE;

CREATE TABLE EXTRAPARTS_CATALOGUE 
(
    extraPartsId            int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    cost                 	varchar(255),
    PRIMARY KEY(extraPartsId)
);

DROP TABLE BOXES_FURNITURE;

CREATE TABLE BOXES_FURNITURE 
(
    furnitureId             int NOT NULL AUTO_INCREMENT,
    boxId 				    int NOT NULL,
    size                    int,
    PRIMARY KEY(furnitureId,boxId)
);

DROP TABLE BOX;

CREATE TABLE BOX
(
    boxId             		int NOT NULL AUTO_INCREMENT,
    height 				    int NOT NULL,
    width                   int NOT NULL,
    depth                   int,
    PRIMARY KEY(boxId)
);
