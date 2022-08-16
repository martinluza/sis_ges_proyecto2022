CREATE DATABASE  IF NOT EXISTS `sis_ges_proyecto2022` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sis_ges_proyecto2022`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: sis_ges_proyecto2022
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `afiliaciones`
--

DROP TABLE IF EXISTS `afiliaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `afiliaciones` (
  `id` varchar(45) NOT NULL,
  `deuda` int DEFAULT NULL,
  `cuota` int DEFAULT NULL,
  `ultimo` date DEFAULT NULL,
  `alta` date DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afiliaciones`
--

LOCK TABLES `afiliaciones` WRITE;
/*!40000 ALTER TABLE `afiliaciones` DISABLE KEYS */;
INSERT INTO `afiliaciones` VALUES ('18',0,100,'2020-09-09','2000-01-01','activo'),('19',100,50,'2020-07-09','2001-12-01','activo'),('20',450,150,'2020-06-09','1999-07-08','activo'),('38',200,50,'2020-05-09','2012-03-03','activo'),('564',0,300,'2020-08-01','2000-03-01','activo'),('89',0,500,'2022-08-04','1990-09-04','activo');
/*!40000 ALTER TABLE `afiliaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afiliados`
--

DROP TABLE IF EXISTS `afiliados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `afiliados` (
  `documento` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `nacimiento` date DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `rubro` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afiliados`
--

LOCK TABLES `afiliados` WRITE;
/*!40000 ALTER TABLE `afiliados` DISABLE KEYS */;
INSERT INTO `afiliados` VALUES ('18','juancito','morales','turca','centro',4536,'juancitopro','0001-01-01','inactivo','estufas'),('19','luana','gonzalez','armenia','prado',34,'luanagol','0003-02-01','inactivo','calienta camas'),('20','alex','rogers','alemana','ciudad vieja',98,'alextennis','2000-02-29','activo','autos'),('38','lucas','redin','español','centro',1348,'lucasredin','2398-01-09','activo','comercio'),('564','haskdf','asdfja','asdfasdf','adsfas',56382,'jdsfasdf','2002-12-12','activo','adsfasdf'),('89','nicolas','alvares','uruguaya','prado',3456,'fghj','2001-08-09','activo','camas');
/*!40000 ALTER TABLE `afiliados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locales`
--

DROP TABLE IF EXISTS `locales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locales` (
  `id` varchar(45) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `negocio` varchar(45) DEFAULT NULL,
  `encargado` varchar(45) DEFAULT NULL,
  `afiliado` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `afiliado_id_idx` (`afiliado`),
  CONSTRAINT `afiliado_id` FOREIGN KEY (`afiliado`) REFERENCES `afiliados` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locales`
--

LOCK TABLES `locales` WRITE;
/*!40000 ALTER TABLE `locales` DISABLE KEYS */;
INSERT INTO `locales` VALUES ('200001','prado','1234','automotora','lucas','20','activo'),('200002','prado','2348','luces','lucas','20','inactivo'),('200003','asdf','123','ads','asdf','20','activo'),('200004','ljglig','123','asdjfjg','dgjeiofg','20','activo'),('200005','asdf','1234','asdfgh','asdfg','20','activo'),('200006','asd','2345','sdfg','ghj','20','activo'),('380001','hfhasd','123','asdf','asdfdf','38','activo'),('380002','dsh','1235','sjh','fghj','38','activo'),('380003','asdfg','1234','asdfgh','asdfg','38','activo'),('456789','dfgh','3456','sdfgh','dcvbnm','89','activo');
/*!40000 ALTER TABLE `locales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `nombre` varchar(45) NOT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (' mari','1234','activo'),(' marti','1234','activo'),(' martina','1234','activo'),(' mauri','1234','activo'),('camila','1234','activo'),('martin','1234','activo'),('mauri','1234','inactivo'),('viky1','1234','activo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-16 19:07:15
