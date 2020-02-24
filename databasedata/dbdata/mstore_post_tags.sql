-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mstore
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `post_tags`
--

DROP TABLE IF EXISTS `post_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_tags` (
  `post_id` bigint NOT NULL,
  `tags` varchar(255) DEFAULT NULL,
  KEY `FKmmtgl185ka210lj8kenewllt1` (`post_id`),
  CONSTRAINT `FKmmtgl185ka210lj8kenewllt1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_tags`
--

LOCK TABLES `post_tags` WRITE;
/*!40000 ALTER TABLE `post_tags` DISABLE KEYS */;
INSERT INTO `post_tags` VALUES (5,'gaming'),(5,''),(5,';high end'),(5,''),(5,';graphics'),(7,'gaming'),(7,''),(7,';budget'),(9,'gaming'),(9,''),(9,';graphics'),(14,'gaming'),(14,''),(14,';RX'),(15,'AMD'),(15,''),(15,';gaming'),(16,'gaming'),(16,''),(16,';graphics'),(18,'gaming'),(18,''),(18,';graphics'),(19,'MSI'),(19,''),(19,';gaming'),(19,''),(19,';graphics'),(21,'gaming'),(21,''),(21,';graphics'),(23,'gaming'),(23,''),(23,';HD'),(24,'gaming'),(24,''),(24,';graphics'),(25,'graphics'),(25,''),(25,';gaming'),(27,'gaming'),(27,''),(27,';HD'),(29,'gaming'),(30,'Ryzen'),(31,'Ryzen'),(34,'1080p'),(35,'mothrboard'),(35,''),(35,';gaming'),(37,'mice'),(37,''),(37,';gaming'),(39,'gaming'),(41,'gaming'),(41,''),(41,';RTX'),(41,''),(41,';HD'),(44,'sound'),(46,'sound'),(49,'1TB'),(53,'printer'),(60,'sound'),(4,'gaming'),(4,'graphics'),(4,'AMD'),(6,'gaming'),(6,'overclocked'),(6,'AMD'),(6,'graphics'),(52,'laser'),(52,'printer'),(52,'HP'),(54,'printer'),(54,'3D'),(11,'radeon'),(11,'gaming'),(11,'AMD'),(22,'gaming'),(22,'HD'),(22,'AMD'),(51,'1TB'),(51,'HDD'),(8,'gaming'),(8,'budget'),(10,'gaming'),(10,'Radeon'),(13,'gaming'),(13,'Radeon');
/*!40000 ALTER TABLE `post_tags` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-24 12:42:50
