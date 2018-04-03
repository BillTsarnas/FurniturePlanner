
use furnitureplanner;

SET SQL_SAFE_UPDATES = 0;

SET GLOBAL innodb_buffer_pool_size=268435456;
/*We create our main table where we are performing our data analysis*/

CREATE TABLE Users 
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


insert into users (name,surname,mphone,hphone, email, address) VALUES
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
    orderId                  int NOT NULL AUTO_INCREMENT,
    userId	 				 int,
    installmentId            int,
	status                   int,
    PRIMARY KEY(orderId)
);



CREATE TABLE INSTALLMENTS 
(
    installmentId                  int NOT NULL AUTO_INCREMENT,
    paytype 				       varchar(255),
    amount                         float,
    PRIMARY KEY(installmentId)
);

CREATE TABLE ORDER_FURNITURE 
(
    orderId                  int,
    furnitureId 		     int,
    type                     varchar(255),
    PRIMARY KEY(orderId, furnitureId)
);


CREATE TABLE FURNITURE 
(
    furnitureId              int NOT NULL AUTO_INCREMENT,
    materialsId 			 int,
    numOfExtraParts          int,
    numOfCuts 				 int,
    PRIMARY KEY(furnitureId)
);


CREATE TABLE MATERIAL_CATALOGUE 
(
    materialId              int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    cost                 	varchar(255),
    color 				    float,
    PRIMARY KEY(materialId)
);

CREATE TABLE FURNITURE_EXTRAPARTS 
(
    userId                  int NOT NULL AUTO_INCREMENT,
    furnitureId             int,
    PRIMARY KEY(userId,furnitureId)
);

CREATE TABLE EXTRAPARTS_CATALOGUE 
(
    extraPartsId            int NOT NULL AUTO_INCREMENT,
    name 				    varchar(255),
    cost                 	varchar(255),
    PRIMARY KEY(extraPartsId)
);

CREATE TABLE BOXES_FURNITURE 
(
    furnitureId             int NOT NULL AUTO_INCREMENT,
    boxId 				    int NOT NULL,
    size                    int,
    PRIMARY KEY(furnitureId,boxId)
);

CREATE TABLE BOX
(
    boxId             		int NOT NULL AUTO_INCREMENT,
    height 				    int NOT NULL,
    width                   int NOT NULL,
    depth                   int,
    PRIMARY KEY(boxId)
);
