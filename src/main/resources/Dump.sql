CREATE DATABASE  IF NOT EXISTS schooldb /*!40100 DEFAULT CHARACTER SET utf8 */;
USE schooldb;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: schooldb
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table student
--



DROP TABLE IF EXISTS clients;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE clients (
                         id int(11) NOT NULL AUTO_INCREMENT,
                         name varchar(45) DEFAULT NULL,
                         email varchar(45) DEFAULT NULL,
                         address varchar(45) DEFAULT NULL,
                         PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1244 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS products;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE products (
                          id int(11) NOT NULL AUTO_INCREMENT,
                          name varchar(45) DEFAULT NULL,
                          price int(11) DEFAULT '0',
                          stock int(11) DEFAULT '0',
                          PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1244 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS orders;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE orders (
                        id int(11) NOT NULL AUTO_INCREMENT,
                        idC int(11) DEFAULT '0',
                        idP int(11) DEFAULT '0',
                        quantity int(11) DEFAULT '0',
                        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1244 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table student
--


LOCK TABLES client WRITE;
/*!40000 ALTER TABLE client DISABLE KEYS */;
/*!40000 ALTER TABLE client ENABLE KEYS */;
LOCK TABLES product WRITE;
/*!40000 ALTER TABLE product DISABLE KEYS */;
/*!40000 ALTER TABLE product ENABLE KEYS */;
LOCK TABLES orders WRITE;
/*!40000 ALTER TABLE orders DISABLE KEYS */;
/*!40000 ALTER TABLE orders ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-03 15:51:37