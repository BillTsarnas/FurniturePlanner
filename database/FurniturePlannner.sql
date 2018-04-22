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

insert into ORDERS (name, clientid,installmentid,totalcost, status) VALUES
('Order 1',1,1,1.00,1),
('Order 2',2,1,2.00,1),
('Order 3',3,1,3.00,1),
('Order 4',4,1,4.00,1),
('Order 5',5,1,5.00,1);




CREATE TABLE ORDER_INSTALLMENTS 
(
    orderid                  int,
    installmentid 		     int,
    paytype                  varchar(255),
    PRIMARY KEY(orderid, installmentid)
);

insert into ORDER_INSTALLMENTS (orderid, installmentid,paytype) VALUES 
(1,1,'Card'),
(1,2,'Cash'),
(1,3,'Card'),
(1,4,'Card');

CREATE TABLE INSTALLMENTS 
(
    installmentid                  int NOT NULL AUTO_INCREMENT,
    amount                         float,
    PRIMARY KEY(installmentid)
);

insert into INSTALLMENTS (amount) VALUES
(1.00),
(2.00),
(3.00),
(4.00),
(5.00);


CREATE TABLE ORDER_FURNITURE 
(
    orderid                  int NOT NULL,
    furnitureid 		     int NOT NULL,
    type                     varchar(255),
    PRIMARY KEY(orderid, furnitureid)
);

insert into ORDER_FURNITURE (orderid, furnitureid,type) VALUES
(1,1,'K'),
(1,2,'K'),
(1,3,'K'),
(1,4,'K'),
(1,5,'K');

CREATE TABLE FURNITURE 
(
    furnitureid              int NOT NULL AUTO_INCREMENT,
    name                     varchar(255),  
    numOfExtraParts          int,
    numOfCuts 				 int,
    PRIMARY KEY(furnitureId)
);

insert into FURNITURE (name, numOfExtraParts,numOfCuts) VALUES
('Kitchen 1',1,3),
('Kitchen 2',2,4),
('Wardrobe 1',3,5),
('Wardrobe 2',4,2),
('Wardrobe 3',5,1);



CREATE TABLE FURNITURE_MATERIAL 
(
    furnitureid              int,
    materialid               int,  
  
    PRIMARY KEY(furnitureId,materialid)
);

insert into FURNITURE_MATERIAL (furnitureid, materialid) VALUES
(1,3),
(2,1),
(3,2),
(4,3),
(5,1);


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
    furnitureid             int NOT NULL,
    extrapartid             int NOT NULL,
    type                    char(1),
    PRIMARY KEY(extrapartid,furnitureid)
);

insert into FURNITURE_EXTRAPARTS (furnitureid, extrapartid, type ) VALUES
(1,3, 'K'),
(1,4, 'K'),
(1,5, 'K'),
(1,6, 'K'),
(1,7, 'K'),
(2,1, 'K'),
(2,2, 'K'),
(2,3, 'K'),
(2,4, 'K'),
(2,5, 'K'),
(2,6, 'K'),
(2,7, 'K'),
(3,2, 'W'),
(3,3, 'W'),
(3,4, 'W'),
(3,5, 'W'),
(3,6, 'W'),
(4,5, 'W'),
(4,6, 'W'),
(4,7, 'W'),
(5,1, 'W'),
(5,2, 'W'),
(5,3, 'W'),
(5,4, 'W'),
(5,5, 'W');


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
    furnitureid             int NOT NULL,
    boxid 				    int NOT NULL,
    sizeinsqmts             int,
    PRIMARY KEY(furnitureid,boxid)
);


INSERT INTO BOXES_FURNITURE(furnitureid,boxid,sizeinsqmts) VALUES
(1,1, 5),
(1,2, 4),
(1,3, 5),
(2,1, 5),
(2,2, 1),
(2,3, 6),
(3,1, 16),
(3,2, 18),
(4,1, 24),
(4,2, 12),
(5,1, 16),
(5,2, 17),
(5,5, 19);


CREATE TABLE BOX_PROPERTIES
(
    boxId             		int NOT NULL,
    height 				    int NOT NULL,
    width                   int NOT NULL,
    depth                   int,
    thickness               int,
    back_thickness          double,
    colour                  varchar(255),
    num_shelves             int
);


INSERT INTO BOX_PROPERTIES(boxId,height,width,depth,thickness,back_thickness,colour,num_shelves) VALUES
(1,3, 5, 4, 1,3,'Red',2),
(1,2, 4, 4, 1,3,'Blue',2),
(1,3, 5, 4, 1,3,'Purple',2),
(2,1, 5, 4, 1,3,'Green',2),
(2,2, 1, 4, 1,3,'Red',2),
(2,3, 6, 4, 1,3,'Black',2),
(3,1, 16, 4, 1,3,'Red',2),
(3,2, 18, 4, 1,3,'Green',2),
(4,1, 24, 4, 1,3,'Purple',2),
(4,2, 12, 4, 1,3,'Red',2),
(5,1, 16, 4, 1,3,'Orange',2),
(5,2, 17, 4, 1,3,'Green',2),
(5,5, 19, 4, 1,3,'Black',2);



CREATE TABLE BOXES_CATALOGUE 
(
    boxid                   int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    type                 	char(1),
    PRIMARY KEY(boxid)
);

INSERT INTO BOXES_CATALOGUE(name,type) VALUES
('SELF', 'K'),
('4 DRAWERS','K'),
('3 DRAWERS','K'),
('LONG BOX','W'),
('HOOKING BAR', 'W');

