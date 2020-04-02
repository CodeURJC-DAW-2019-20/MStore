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
INSERT INTO `post_tags` VALUES (5,'gaming'),(5,'AMD'),(5,'high end'),(5,'new'),(5,'graphics'),(7,'gaming'),(7,'AMD'),(7,';budget'),(9,'gaming'),(9,'AMD'),(9,'graphics'),(14,'gaming'),(14,'AMD'),(14,'RX'),(16,'gaming'),(16,'AMD'),(16,'graphics'),(18,'gaming'),(18,'AMD'),(18,'graphics'),(19,'MSI'),(19,'RX'),(19,'gaming'),(19,'AMD'),(19,'graphics'),(21,'gaming'),(21,'AMD'),(21,'graphics'),(23,'gaming'),(23,'AMD'),(23,'HD'),(24,'gaming'),(24,'AMD'),(24,'graphics'),(27,'gaming'),(27,'ASUS'),(27,'HD'),(29,'gaming'),(30,'Ryzen'),(31,'Ryzen'),(35,'motherboard'),(35,'AMD'),(35,'gaming'),(39,'gaming'),(44,'sound'),(46,'sound'),(53,'printer'),(60,'sound'),(4,'gaming'),(4,'graphics'),(4,'AMD'),(54,'printer'),(54,'3D'),(11,'radeon'),(11,'gaming'),(11,'AMD'),(22,'gaming'),(22,'HD'),(22,'AMD'),(51,'1TB'),(51,'HDD'),(10,'gaming'),(10,'Radeon'),(13,'gaming'),(13,'Radeon'),(6,'gaming'),(6,'AMD'),(6,'graphics'),(8,'gaming'),(8,'AMD'),(49,'1TB'),(49,'Seagate'),(37,'mouse'),(15,'AMD'),(15,'gaming'),(25,'graphics'),(25,'AMD'),(41,'gaming'),(41,'RTX'),(41,'graphics'),(63,'sound'),(63,'headphones'),(64,'sound'),(64,'headphones'),(65,'speakers'),(65,'sound'),(66,'sound'),(66,'speakers'),(67,'monitor'),(52,'laser'),(52,'printer'),(52,'HP'),(70,'monitor'),(70,'HP'),(72,'printer'),(72,'HP'),(75,'WD'),(75,'HDD'),(76,'Seagate'),(76,'HDD'),(77,'monitor'),(77,'HP'),(78,'mouse'),(78,'gaming'),(79,'mouse'),(80,'mouse'),(80,'HP'),(81,'mouse'),(81,'HP'),(83,'monitor'),(84,'monitor'),(85,'monitor'),(71,'printer'),(71,'HP'),(86,'printer'),(87,'speakers'),(88,'speakers'),(89,'speakers'),(34,'HP'),(34,'monitor');
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

-- Dump completed on 2020-04-02  1:32:43
