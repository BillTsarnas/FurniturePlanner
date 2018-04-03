CREATE DATABASE  IF NOT EXISTS `furnitureplanner` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `furnitureplanner`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: furnitureplanner
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `mphone` varchar(20) DEFAULT NULL,
  `hphone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Ruben Enrique','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(2,'Ruben 1','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(3,'Ruben 2','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(4,'Ruben 3','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(5,'Ruben 4','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(6,'Ruben 5','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(7,'Ruben 6','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(8,'Ruben 7','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(9,'Ruben 8','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(10,'Ruben 9','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(11,'Ruben 10','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301'),(12,'Ruben 11','Padilla Robles','55185211806','555435685411','rubpad@gmail.com','mar marmara 377 int 301');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-23 16:44:38
