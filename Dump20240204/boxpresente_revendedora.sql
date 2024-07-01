-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: boxpresente
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `revendedora`
--

DROP TABLE IF EXISTS `revendedora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revendedora` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_grupo` int NOT NULL,
  `nome` varchar(150) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `celular` varchar(15) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `data_cadastro` datetime NOT NULL,
  `excluido` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_revendedora_grupo_idx` (`id_grupo`),
  CONSTRAINT `fk_revendedora_grupo` FOREIGN KEY (`id_grupo`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revendedora`
--

LOCK TABLES `revendedora` WRITE;
/*!40000 ALTER TABLE `revendedora` DISABLE KEYS */;
INSERT INTO `revendedora` VALUES (1,3,'Icaro Oliveira','rua porto alegre do norte 23','Colombo','pr','(41) 98883-8697','075.669.854-50','2023-10-05 22:15:55',NULL),(2,3,'Icaro Oliveira TESTE','Rua porto alegre do norte 23','Colombo','pr','(41) 98883-8697','075.669.854-50','2023-10-05 22:38:30','2023-10-05 22:38:38'),(3,3,'Icaro Oliveira TESTE','Rua porto alegre do norte 23','Colombo','pr','(41) 98883-8697','075.669.854-50','2023-10-05 22:39:02','2023-10-05 22:39:13'),(4,3,'jose','Rua Porto Alegre do Norte, 23','Colombo','PR','(41)98887-75544','075.663.046-50','2024-01-04 20:48:18',NULL),(5,3,'Ícaro Rodrigo de Oliveira','Rua Porto Alegre do Norte, 23','Colombo','PR','(12)42342-34','076.332.819-79','2024-01-28 18:15:25',NULL),(6,3,'Ícaro Rodrigo de Oliveira','Rua Porto Alegre do Norte, 23','Colombo','PR','(12)42342-34','076.332.819-79','2024-01-28 18:17:17',NULL);
/*!40000 ALTER TABLE `revendedora` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-04 14:38:55
