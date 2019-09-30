-- MySQL dump 10.13  Distrib 5.5.24, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: juegosolimpicos
-- ------------------------------------------------------
-- Server version	5.5.24-0ubuntu0.12.04.1

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
-- Table structure for table `Ciudad`
--
DROP DATABASE IF EXISTS `juegosolimpicos`;
CREATE DATABASE `juegosolimpicos`;

USE `juegosolimpicos`;

DROP TABLE IF EXISTS `Ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ciudad` (
  `id_ciudad` int(11) NOT NULL,
  `nombre_ciudad` varchar(64) NOT NULL,
  `id_pais` int(11) NOT NULL,
  `valor_ciudad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ciudad`),
  KEY `FK_Ciudad_Pais` (`id_pais`),
  CONSTRAINT `FK_Ciudad_Pais` FOREIGN KEY (`id_pais`) REFERENCES `Pais` (`id_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ciudad`
--

-- LOCK TABLES `Ciudad` WRITE;
/*!40000 ALTER TABLE `Ciudad` DISABLE KEYS */;
INSERT INTO `Ciudad` VALUES (1,'LA CORUÑA',1,93),(2,'MADRID',1,NULL),(3,'BARCELONA',1,124),(4,'LISBOA',2,134),(5,'OPORTO',2,NULL),(6,'COIMBRA',2,NULL),
(7,'CHAMONIX',3,123),(8,'PARÍS',3,5),(9,'NIZA',3,NULL),(10,'MILÁN',4,135),(11,'ROMA',4,125),(12,'TURÍN',4,190),(13,'PEKIN',5,80);
/*!40000 ALTER TABLE `Ciudad` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `Pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pais` (
  `id_pais` int(11) NOT NULL,
  `nombre_pais` varchar(64) NOT NULL,
  `codigo_pais` varchar(2) NOT NULL,
  `valor_pais` int(11) NOT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

-- LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `Pais` DISABLE KEYS */;
INSERT INTO `Pais` VALUES (1,'ESPAÑA','ES',100),(2,'PORTUGAL','PT',200),(3,'FRANCIA','FR',50),(4,'ITALIA','IT',150),(5,'CHINA','CN',250);
/*!40000 ALTER TABLE `Pais` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `Sede_jjoo`
--

DROP TABLE IF EXISTS `Sede_jjoo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sede_jjoo` (
  `año` int(11) NOT NULL,
  `id_tipo_jjoo` int(11) NOT NULL,
  `sede` int(11) NOT NULL,
  PRIMARY KEY (`año`,`id_tipo_jjoo`),
  KEY `FK_Sede_jjoo_Ciudad` (`sede`),
  KEY `FK_Sede_jjoo_Tipo_jjoo` (`id_tipo_jjoo`),
  CONSTRAINT `FK_Sede_jjoo_Ciudad` FOREIGN KEY (`sede`) REFERENCES `Ciudad` (`id_ciudad`),
  CONSTRAINT `FK_Sede_jjoo_Tipo_jjoo` FOREIGN KEY (`id_tipo_jjoo`) REFERENCES `Tipo_jjoo` (`id_tipo_jjoo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sede_jjoo`
--

-- LOCK TABLES `Sede_jjoo` WRITE;
/*!40000 ALTER TABLE `Sede_jjoo` DISABLE KEYS */;
INSERT INTO `Sede_jjoo` VALUES (1900,2,8),(1924,1,7),(1924,2,8),(1960,2,11),(1992,2,3),(2006,1,12),(2008,2,13),(2022,1,13),(2024,2,8);
/*!40000 ALTER TABLE `Sede_jjoo` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `Tipo_jjoo`
--

DROP TABLE IF EXISTS `Tipo_jjoo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tipo_jjoo` (
  `id_tipo_jjoo` int(11) NOT NULL,
  `descripcion_tipo` varchar(32) NOT NULL,
  PRIMARY KEY (`id_tipo_jjoo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tipo_jjoo`
--

-- LOCK TABLES `Tipo_jjoo` WRITE;
/*!40000 ALTER TABLE `Tipo_jjoo` DISABLE KEYS */;
INSERT INTO `Tipo_jjoo` VALUES (1,'INVIERNO'),(2,'VERANO');
/*!40000 ALTER TABLE `Tipo_jjoo` ENABLE KEYS */;
-- UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
SET global sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

-- Dump completed on 2012-10-18 12:27:37


