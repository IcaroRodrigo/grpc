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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_grupo` int NOT NULL,
  `data_cadastro` datetime NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf_cnpj` varchar(45) DEFAULT NULL,
  `tipo_pessoa` tinyint(1) DEFAULT NULL,
  `excluido` datetime DEFAULT NULL,
  `telefone` varchar(15) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `endereco` text,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente_grupo_idx` (`id_grupo`),
  CONSTRAINT `fk_cliente_grupo` FOREIGN KEY (`id_grupo`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,3,'2023-10-02 22:26:44','Joares de souza',NULL,NULL,'2023-10-04 21:01:01','(41) 98883-8697',NULL,NULL,NULL,NULL),(3,3,'2023-10-02 22:29:44','Icaro Oliveira ee','07566304950',1,NULL,'(41) 98883-8697','1989-10-10','Rua Porto Alegre do Norte, 23','Colombo','PR'),(4,3,'2023-10-04 20:20:22','Icaro Oliveira TESTE',NULL,NULL,'2023-10-04 20:28:47','(41) 98883-8697',NULL,NULL,NULL,NULL),(5,3,'2023-11-01 06:40:15','Ícaro Rodrigo de Oliveira','075.663.049-50',1,NULL,'(41) 98883-8697','1989-10-10','Rua Porto Alegre do Norte, 23','Colombo','PR'),(6,3,'2024-01-04 19:03:20','teste 4','465.65',1,NULL,'(41)98999-9','1989-10-10','Rua Porto Alegre do Norte, 23','Colombo','PR'),(7,3,'2024-01-04 19:03:49','tese2','465.65',1,NULL,'(41)98999-9','1989-10-10','','',''),(10,3,'2024-01-04 19:38:37','teste 5 ','075.663.049-50',1,NULL,'(41)98886-89744','1989-10-10','Rua Porto Alegre do Norte, 23','Colombo','PR');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-04 14:38:56
