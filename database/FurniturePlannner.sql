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
    totalcost                float,
	status                   int,
    PRIMARY KEY(orderId)
);

insert into ORDERS (name, clientid,totalcost, status) VALUES
('Order 1',1,1.00,1),
('Order 2',2,2.00,1),
('Order 3',3,3.00,1),
('Order 4',4,4.00,1),
('Order 5',5,5.00,1);




CREATE TABLE ORDER_INSTALLMENTS 
(
    orderid                  int,
    installmentid 		     int,
    PRIMARY KEY(orderid, installmentid)
);

insert into ORDER_INSTALLMENTS (orderid, installmentid) VALUES 
(1,1),
(1,2),
(1,3),
(1,4);

CREATE TABLE INSTALLMENTS 
(
    installmentid                  int NOT NULL AUTO_INCREMENT,
    amount                         float,
    paytype                       varchar(255),
    PRIMARY KEY(installmentid)
);

insert into INSTALLMENTS (amount,paytype) VALUES
(1.00 ,'Card'),
(2.00 , 'Cash'),
(3.00 ,'Card'),
(4.00 ,'Cash'),
(5.00 ,'Card' );


CREATE TABLE ORDER_FURNITURE 
(
    orderid                  int NOT NULL,
    furnitureid 		     int NOT NULL,
    PRIMARY KEY(orderid, furnitureid)
);

insert into ORDER_FURNITURE (orderid, furnitureid) VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5);

CREATE TABLE FURNITURE 
(
    furnitureid              int NOT NULL AUTO_INCREMENT,
    name                     varchar(255),  
    numofcuts                int, 
    PRIMARY KEY(furnitureId)
);

insert into FURNITURE (name,numofcuts) VALUES
('Kitchen 1',3),
('Kitchen 2',4),
('Wardrobe 1',5),
('Wardrobe 2',2),
('Wardrobe 3',3);



CREATE TABLE PIECE_MATERIAL 
(
    pieceid              int,
    materialid               int,  
  
    PRIMARY KEY(pieceid,materialid)
);

insert into PIECE_MATERIAL (pieceid, materialid) VALUES
(1,3),
(2,1),
(3,2),
(4,3),
(5,3),
(6,3),
(7,3),
(8,3),
(9,3),
(10,1),
(11,1),
(12,1),
(13,1);

CREATE TABLE MATERIAL_CATALOGUE 
(
    materialid              int NOT NULL AUTO_INCREMENT,
    name  					varchar(255),
    cost                 	float,
    colour 				    varchar(255),
    PRIMARY KEY(materialid)
);

INSERT INTO MATERIAL_CATALOGUE(name,cost,colour) VALUES
('melamine',50.0,'black'),
('oak',2000.0,'brown'),
('maple', 250.0,'dark');


CREATE TABLE BOX_EXTRAPARTS 
(
    boxid             int NOT NULL,
    extrapartid             int NOT NULL,
    PRIMARY KEY(extrapartid,boxid)
);

insert into BOX_EXTRAPARTS (boxid, extrapartid) VALUES
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(2,1),
(2,2),
(2,3),
(2,4),
(2,5),
(2,6),
(2,7),
(3,2),
(3,3),
(3,4),
(3,5),
(3,6),
(4,5),
(4,6),
(4,7),
(5,1),
(5,2),
(5,3),
(5,4),
(5,5),
(6,2),
(6,3),
(7,4),
(7,5),
(7,2),
(7,1),
(8,4),
(8,5),
(8,3),
(9,5),
(9,4),
(9,1),
(10,5),
(10,4),
(11,3),
(11,5),
(12,1),
(12,4),
(13,1),
(13,2),
(13,3),
(13,4);

CREATE TABLE EXTRAPARTS_CATALOGUE 
(
    extrapartid            int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    cost                 	varchar(255),
    type                    char(1),
    PRIMARY KEY(extrapartid)
);


INSERT INTO EXTRAPARTS_CATALOGUE(name,cost,type) VALUES
('Rail','5','K'),
('Handle', '1','K'),
('Wheel_small','2','W'),
('Dish Case','3','W'),
('Cutlery Case','2','W'),
('Trash Can','4','W'),
('Wardrobe bar','2','W');


CREATE TABLE BOX_PIECES
(
    boxid             int NOT NULL,
    pieceid 		  int NOT NULL,
    PRIMARY KEY(pieceid,boxid)
);


INSERT INTO BOX_PIECES(boxid,pieceid) VALUES
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(2,3),
(3,1),
(3,2),
(4,1),
(4,2),
(5,1),
(5,2),
(5,5);


CREATE TABLE PIECES_PROPERTIES
(
    pieceid                 int NOT NULL AUTO_INCREMENT ,
    height 				    int NOT NULL,
    width                   int NOT NULL,
    thickness               int,
    colour                  varchar(255),
    isDoor                  boolean,
    PRIMARY KEY(pieceid)
);


INSERT INTO PIECES_PROPERTIES(height,width,thickness,colour,isDoor) VALUES
(3, 5,  1,'Red',true),
(2, 4,  1,'Blue',false),
(3, 5,  1,'Purple',false),
(1, 5, 1,'Green',false),
(2, 1,  1,'Red',false),
(3, 6,  1,'Black',false),
(1, 16,  1,'Red',false),
(2, 18,  1,'Green',false),
(1, 24,  1,'Purple',false),
(2, 12,  1,'Red',false),
(1, 16,  1,'Orange',false),
(2, 17,  1,'Green',false),
(5, 19,  1,'Black',false);


CREATE TABLE FURNITURE_BOXES 
(
    furnitureid             int NOT NULL,
    boxid 				int NOT NULL,
    PRIMARY KEY(furnitureid,boxid)
);

insert into FURNITURE_BOXES (furnitureid, boxid) VALUES
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(2,3),
(3,4),
(3,5),
(4,4),
(4,5),
(5,4),
(5,5);

CREATE TABLE BOXES_CATALOGUE 
(
    boxid                   int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    height 				    double,
    width                   double,
    depth                   double,
    thickness               double,
    colour                  varchar(255),
    door_colour             varchar(255),
    PRIMARY KEY(boxid)
);

INSERT INTO BOXES_CATALOGUE(name,height,width,depth,thickness,colour,door_colour) VALUES
('SELF',1,1,1,1,'Green','Black'),
('4 DRAWERS',1,1,1,1,'Green','Black'),
('3 DRAWERS',1,1,1,1,'Green','Black'),
('LONG BOX',1,1,1,1,'Green','Black'),
('HOOKING BAR',1,1,1,1,'Green','Black');

