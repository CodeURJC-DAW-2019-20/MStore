-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mstore
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
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` bigint NOT NULL,
  `component` varchar(255) DEFAULT NULL,
  `component_tag` int NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `features` varchar(255) DEFAULT NULL,
  `n_img` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `post_address` varchar(255) DEFAULT NULL,
  `price` int NOT NULL,
  `brand_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKboufdgt05m6eptbyer6c9dlso` (`brand_id`),
  KEY `FK72mt33dhhs48hf9gcqrq4fxte` (`user_id`),
  CONSTRAINT `FK72mt33dhhs48hf9gcqrq4fxte` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKboufdgt05m6eptbyer6c9dlso` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (3,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology, new.','High Quality Graphics Card from company AMD, air cooling, new, not used.',4,'AMD RX 580','Plaza de la limonada 3',230,2,1),(4,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, semi used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, semi used.',1,'AMD RX 480','Plaza de la limonada 3',210,2,1),(5,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for high tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used',1,'AMD XT5000','Plaza de la limonada 3',450,2,1),(6,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology. Overclocked already.','High Quality Graphics Card from company AMD, air cooling, new, not used, already overclocked. may overheat  bit.',1,'AMD XT 5000 OC','Plaza de la limonada 3',500,2,1),(7,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for low tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used',1,'AMD 3700','Plaza de la limonada 3',130,2,1),(8,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, used, made for budget low tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, used.',1,'AMD 2500','Plaza de la limonada 3',110,2,1),(9,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming, pulse architecture, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming.',1,'AMD Pulse GPU','Plaza de la limonada 3',240,2,1),(10,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, radeon architecture, made for low tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, radeon architecture',2,'AMD Radeon 4000','Plaza de la limonada 3',140,2,1),(11,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, radeon architecture, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, radeon architecture',1,'AMD Radeon HD 5000','Plaza de la limonada 3',170,2,1),(13,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, radeon architecture made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used, blue color',1,'AMD Radeon Blue','Calle del brujo 23',156,2,12),(14,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology, Overclocked.','High Quality Graphics Card from company AMD, air cooling, new, not used overclocked.',1,'AMD RX 580 OC','Calle del brujo 23',220,2,12),(15,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology. Pulse architecture.','High Quality Graphics Card from company AMD, air cooling, new, not used,  Pulse architecture.',1,'Pulse AMD Graphics card','Calle del brujo 23',220,2,12),(16,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for high tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used, made for high end gaming',1,'AMD X5700','Calle del brujo 23',670,2,12),(18,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, semi used, made for the highest tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, semi used, made for the highest tier gaming.',1,'AMD XT 6000','Avenida sin fin',770,2,17),(19,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, semi used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology. MSI modified','High Quality Graphics Card from company AMD, air cooling, semi used, MSI modified',1,'AMD RX 580 OC MSI','Avenida sin fin',340,2,17),(21,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology, used.','High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming, used, may nee cleaning',1,'AMD 2000','Plaza de la embajda 6',230,2,20),(22,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology, new.','High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming.',1,'AMD hd 5500','Plaza de la embajda 6',220,2,20),(23,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for low tier gaming, Afterburner support, can also be implemented ith SLI tchnology, new.','High Quality Graphics Card from company AMD, air cooling, made for low tier gaming',1,'AMD 5600 GPU','Plaza de la embajda 6',130,2,20),(24,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for high end gaming, Afterburner support, can also be implemented ith SLI tchnology, used.','High Quality Graphics Card from company AMD, air cooling, used',1,'AMD XT 3000','Plaza de la embajda 6',565,2,20),(25,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology, new, Pulse architecture.','High Quality Graphics Card from company AMD, air cooling, made for mid tier gamin, new pukse arcitecture',1,'AMD 3900 Pulse','Plaza de la embajda 6',322,2,20),(27,'Video Cards & Video Devices',3,'High Quality Graphics Card from company ASUS, air cooling, made for mid tier gaming, Afterburner support, new.','High Quality Graphics Card from company ASUS, air cooling, made for mid tier gaming',1,'ASUS GTX 1060 6GB','Plaza de la embajda 6',210,26,20),(29,'Video Cards & Video Devices',3,'High Quality Graphics Card from company NVIDIA, air cooling, made for high tier gaming, Afterburner support, can also be implemented ith SLI tchnology, new.','High Quality Graphics Card from company NVIDIA, air cooling, made for high tier gaming.',2,'NVIDIA RTX 2080Ti','Plaza de la embajda 6',680,28,20),(30,'CPU / Processors',2,'Ryzen model from brand AMD Processor with 8 cores and integrated GPU','Ryzen AMD Processor 8 cores',1,'AMD Ryzen 5','Plaza de la embajda 6',130,2,20),(31,'CPU / Processors',2,'Ryzen model from brand AMD Processor with 8 cores and integrated GPU','Ryzen model from brand AMD Processor with 8 cores',1,'AMD Ryzen 3','Plaza de la embajda 6',110,2,20),(34,'Monitors',7,'HP monitor HD with 1080p suport, VSync, FreeSync. LED powere and 2 HDMI ports.','HP monitor with HDMI and VSync support',1,'HP monitor 1080p','Calle de la justicia 9',145,33,32),(35,'Motherboards',0,'AMD compatible motherboard with 6xUSB ports 4xHDMI ports 3xSATA 3.0 port support and SLI compatible.','AMD model motherboard',1,'AMD Motherboard','Calle de la justicia 8',110,2,32),(37,'Computer Mice',6,'Computer gaming mouse with several DPI options','computer gaming mouse',1,'Corsair Mouse','Calle de la justicia 8',60,36,32),(39,'CPU / Processors',2,'seventh gen 7700k model CPU from brand intel, 8 cores.','8 cores seventh gen processor',1,'Intel','Calle de la justicia 8',450,38,32),(41,'Video Cards & Video Devices',3,'High end gpu sold by nvidia but modified by gigabyte, 3 fans air cooling rtx technology','High end gpu sold by nvidia but modified by gigabyte',3,'Gigabyte RT 2080ti','Calle de la justicia 8',780,40,32),(44,'Headphones',5,'Blue logitech headphones with good sound quality, wireless but with cable option.','Blue logitech headphones with good sound quality',1,'Blue headphones','Calle de los angeles 7',25,43,42),(46,'Speakers',4,'Good quality Pionees speakers with Stereo sound','Good quality Pionees speakers',1,'Pioneer Seakers','Calle de los Angeles 7',40,45,42),(49,'Storage Devices',1,'1TB seagate barracuda disk drive internal HDD','1TB internal HDD',1,'Seagat barracuda 1TB','Calle del manzano 2',40,48,47),(51,'Storage Devices',1,'1TB internal disk drive HDD from company WD','1TB inernal disk drive',2,'WD 1TB HDD','calle de los manzanos 2',45,50,47),(52,'Laser Printer',0,'Not used HP laser printer, comes in the original box','HP laser printer new',1,'HP laser printer','Calle del manzano 2',130,33,47),(53,'3D Printer',10,'3D printer from brand logitech with blue filament included, drivers not needed','3D logitech branded printer',1,'3D printer','Calle del manzano 2',320,43,47),(54,'Printer Supplies',11,'golden filament for any kind and brand of 3d printer','filamnt for 3d printer color: gold',1,'3D printer golden filament','Calle del manzano 2',29,33,47);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-22 20:21:16
