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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (2,'AMD'),(26,'ASUS'),(28,'NVIDIA'),(33,'HP'),(36,'Corsair'),(38,'Intel'),(40,'Gigabyte'),(43,'Logitech'),(45,'Pioneer'),(48,'Seagate'),(50,'WD'),(82,'Other');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (90),(90),(90),(90);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `post` VALUES (4,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, semi used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, semi used.',1,'AMD RX 480','Plaza de la limonada 3',210,2,1),(5,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for high tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used',1,'AMD XT5000','Plaza de la limonada 3',450,2,1),(6,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology. Overclocked already.','High Quality Graphics Card from company AMD, air cooling, new, not used, already overclocked. may overheat  bit.',1,'AMD XT 5000 OC','Plaza de la limonada 3',500,2,1),(7,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for low tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used',1,'AMD 3700','Plaza de la limonada 3',130,2,1),(8,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, used, made for budget low tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, used.',1,'AMD 2500','Plaza de la limonada 3',110,2,1),(9,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming, pulse architecture, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming.',1,'AMD Pulse GPU','Plaza de la limonada 3',240,2,1),(10,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, radeon architecture, made for low tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, radeon architecture',2,'AMD Radeon 4000','Plaza de la limonada 3',140,2,1),(11,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, radeon architecture, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, radeon architecture',1,'AMD Radeon HD 5000','Plaza de la limonada 3',100,2,1),(13,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, radeon architecture made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used, blue color',1,'AMD Radeon Blue','Calle del brujo 23',156,2,12),(14,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology, Overclocked.','High Quality Graphics Card from company AMD, air cooling, new, not used overclocked.',1,'AMD RX 580 OC','Calle del brujo 23',220,2,12),(15,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology. Pulse architecture.','High Quality Graphics Card from company AMD, air cooling, new, not used,  Pulse architecture.',1,'Pulse AMD Graphics card','Calle del brujo 23',220,2,12),(16,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, new, not used, made for high tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, new, not used, made for high end gaming',1,'AMD X5700','Calle del brujo 23',670,2,12),(18,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, semi used, made for the highest tier gaming, Afterburner support, can also be implemented ith SLI tchnology.','High Quality Graphics Card from company AMD, air cooling, semi used, made for the highest tier gaming.',1,'AMD XT 6000','Avenida sin fin',770,2,17),(19,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, semi used, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology. MSI modified','High Quality Graphics Card from company AMD, air cooling, semi used, MSI modified',1,'AMD RX 580 OC MSI','Avenida sin fin',340,2,17),(21,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology, used.','High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming, used, may nee cleaning',1,'AMD 2000','Plaza de la embajda 6',230,2,20),(22,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology, new.','High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming.',1,'AMD hd 5500','Plaza de la embajda 6',220,2,20),(23,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for low tier gaming, Afterburner support, can also be implemented ith SLI tchnology, new.','High Quality Graphics Card from company AMD, air cooling, made for low tier gaming',1,'AMD 5600 GPU','Plaza de la embajda 6',130,2,20),(24,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for high end gaming, Afterburner support, can also be implemented ith SLI tchnology, used.','High Quality Graphics Card from company AMD, air cooling, used',1,'AMD XT 3000','Plaza de la embajda 6',565,2,20),(25,'Video Cards & Video Devices',3,'High Quality Graphics Card from company AMD, air cooling, made for mid tier gaming, Afterburner support, can also be implemented ith SLI tchnology, new, Pulse architecture.','High Quality Graphics Card from company AMD, air cooling, made for mid tier gamin, new pukse arcitecture',1,'AMD 3900 Pulse','Plaza de la embajda 6',322,2,20),(27,'Video Cards & Video Devices',3,'High Quality Graphics Card from company ASUS, air cooling, made for mid tier gaming, Afterburner support, new.','High Quality Graphics Card from company ASUS, air cooling, made for mid tier gaming',1,'ASUS GTX 1060 6GB','Plaza de la embajda 6',210,26,20),(29,'Video Cards & Video Devices',3,'High Quality Graphics Card from company NVIDIA, air cooling, made for high tier gaming, Afterburner support, can also be implemented ith SLI tchnology, new.','High Quality Graphics Card from company NVIDIA, air cooling, made for high tier gaming.',2,'NVIDIA RTX 2080Ti','Plaza de la embajda 6',680,28,20),(30,'CPU / Processors',2,'Ryzen model from brand AMD Processor with 8 cores and integrated GPU','Ryzen AMD Processor 8 cores',1,'AMD Ryzen 5','Plaza de la embajda 6',130,2,20),(31,'CPU / Processors',2,'Ryzen model from brand AMD Processor with 8 cores and integrated GPU','Ryzen model from brand AMD Processor with 8 cores',1,'AMD Ryzen 3','Plaza de la embajda 6',110,2,20),(34,'Monitors',7,'HP monitor HD with 1080p suport, VSync, FreeSync. LED powere and 2 HDMI ports.','HP monitor with HDMI and VSync support',3,'HP monitor 1080p','Calle de la justicia 9',145,2,32),(35,'Motherboards',0,'AMD compatible motherboard with 6xUSB ports 4xHDMI ports 3xSATA 3.0 port support and SLI compatible.','AMD model motherboard',1,'AMD Motherboard','Calle de la justicia 8',110,2,32),(37,'Computer Mice',6,'Computer gaming mouse with several DPI options','computer gaming mouse',1,'Corsair Mouse','Calle de la justicia 8',60,36,32),(39,'CPU / Processors',2,'seventh gen 7700k model CPU from brand intel, 8 cores.','8 cores seventh gen processor',1,'Intel','Calle de la justicia 8',450,38,32),(41,'Video Cards & Video Devices',3,'High end gpu sold by nvidia but modified by gigabyte, 3 fans air cooling rtx technology','High end gpu sold by nvidia but modified by gigabyte',3,'Gigabyte RT 2080ti','Calle de la justicia 8',780,40,32),(44,'Headphones',5,'Blue logitech headphones with good sound quality, wireless but with cable option.','Blue logitech headphones with good sound quality',1,'Blue headphones','Calle de los angeles 7',25,43,42),(46,'Speakers',4,'Good quality Pionees speakers with Stereo sound','Good quality Pionees speakers',1,'Pioneer Seakers','Calle de los Angeles 7',40,45,42),(49,'Storage Devices',1,'1TB seagate barracuda disk drive internal HDD','1TB internal HDD',1,'Seagate barracuda 1TB','Calle del manzano 2',40,48,47),(51,'Storage Devices',1,'1TB internal disk drive HDD from company WD','1TB inernal disk drive',2,'WD 1TB HDD','calle de los manzanos 2',42,50,47),(52,'Laser Printer',9,'Not used HP laser printer, comes in the original box','HP laser printer new',1,'HP laser printer','Calle del manzano 2',130,33,47),(53,'3D Printer',10,'3D printer from brand logitech with blue filament included, drivers not needed','3D logitech branded printer',1,'3D printer','Calle del manzano 2',320,43,47),(54,'3D Printer',10,'golden filament for any kind and brand of 3d printer','filamnt for 3d printer color: gold',1,'3D printer golden filament','Calle del manzano 2',29,33,47),(60,'Headphones',5,'Pro gaming headset with stereo sound and built in volume controller and mic.','Pro gaming headset with stereo sound',3,'Pro gaming Headset XP','Silicon valley 56',20,45,59),(63,'Headphones',5,'EXCELLENT SOUND: Stereo bass headphone with excellent sound effect, 3.5mm plug compatible with all 3.5mm jack devices.','8.3 x 7.1 x 3.5 inches\r\n6.6 ounces\r\n9.6 ounces\r\nELECDER\r\nB07KQS84WH\r\ni39',3,'Elecder I39 Headphones With Microphone','1512 Monroe Avenue Cape Haze, FL 33946',19,50,62),(64,'Headphones',5,'PREMIUM SOUND QUALITY - Set of 3 pieces excellent stereo headphones with microphone, surround sound effect with good bass, clear and vivid, allowing you to have a better listening experience.','5 x 2.1 x 0.4 inches ST-EN30 Earphone_3colors',2,'3 Packs Earbud Headphones With Remote & Microphone','1512 Monroe Avenue Cape Haze, FL 33946',13,45,62),(65,'Speakers',4,'Great sounds','70 W\r\n1x 5,25\"',2,'Eris E5','1512 Monroe Avenue Cape Haze, FL 33946',211,2,62),(66,'Speakers',4,'Wireless connectivity via Bluetooth. Compatible with Bluetooth enabled devices such as iPhone, iPod, iPad, Smartphones, Tablets, Computers and More','Perfect wireless speaker for travelling. Ultra lightweight and portable. Bring your music anywhere you go',1,'Betron A3 Bluetooth Wireless Speaker for Iphone','Limons Street',59,45,62),(67,'Monitors',7,'Built from lightweight, high-strength metal with a matte finish and high-polished resin, this ultra-slim display brings home a modern look and feel without the premium price tag','With its vivid IPS panel, this micro-edge display delivers ultra-wide viewing angles and crisp, clear picture quality; it\'s an expansive viewing experience, suitable for dual display setups',2,'HP 27f Ultraslim Full HD','Limons Street',180,33,62),(70,'Monitors',7,'Enjoy a great screen experience with this elegant HP monitor. Advanced IPS technology provides very wide viewing angles of up to 178 ° with consistent details and vibrant colors.','IPS display with 68.58 cm (27 \") LED backlight\r\nMicro-edge display, Ultrathin, Very wide viewing angles up to 178 °',1,'HP Monitor 27m 68,58 cm (27\" ), IPS, Full HD','Madrid Street',270,33,62),(71,'Ink Printer',8,'Save time and money with HP\'s most affordable wireless all-in-one printer to date. With a hassle-free setup and easy printing from your mobile devices, the HP DeskJet 2600 All-in-One removes the complications of your everyday printing needs.','Colour Multifunction Printer - Perfect for home use\r\nPrint, Scan & Copy\r\nPaper Size - A4',1,'HP DeskJet 2630 Wireless All-in-One Printer','Madrid Street',39,33,62),(72,'Ink Printer',8,'Printing Type: Colour Printing Technology: HP Thermal Inkjet','Easy from the start, Reduce your impact, Tackle more tasks for less cash',1,'HP Ink Advantage 2135','Madrid Street',195,33,62),(75,'Storage Devices',1,'We present the WD NAS Red with 4TB capacity. WD Red is the only hard drive for NAS systems with 1 to 5 compartments.','NAS WD support eliminates confusion. WD Red is the only hard drive for NAS systems with 1 to 5 disk compartments.',1,'WD NAS Red 4TB SATA3','Berlin Street',128,50,62),(76,'Storage Devices',1,'Multi-tier Caching technology for increased performance\r\nUp to 220 MB/s maximum sustained data transfer rate','Rock-solid reliability built on over 20 years of BarraCuda innovation\r\nVersatile mix of capacity and price point options to fit any budget',1,'Seagate Barracuda 6TB 6000GB','Berlin Street',169,48,58),(77,'Monitors',7,'Get the crisp image quality you crave thanks to this ultra-thin screen with micro-edges, immersive wide viewing angles and integrated audio. ','',1,'HP Monitor 22er 21,5\"','Madrid Street',185,33,62),(78,'Computer Mice',6,'High Tracking Accurancy 4 Settings of DPI(800 / 1200 / 1600 /2400 ) Resolution Optical Tracking Technology provides sensitivity and precise tracking on a wide range of surfaces','The ergonomic shape design plus scroll wheel with high quality rubber and skin-friendly surface provide you the most comfortable feeling in hand for long time using',1,'Computer Wired USB Mouse,Games','Madrid Street ',24,45,62),(79,'Computer Mice',6,'Would you like to do your job without missing a sound or disturbing your environment? Choose LeadsaiL quiet mice; you will enjoy the same click feeling with over 90% less click noise.','Would like to take full control of your every aim with perfect tracking? Choose LeadsaiL optical LED wireless mouse. Featuring 3 adjustable DPI (1600/1200/800).',1,'Wireless Mouse for Laptop','Madrid Street ',15,45,62),(80,'Computer Mice',6,'Designed with Your Comfort in Mind: The elongated arch and contoured shape provides relaxed control for either right or left-hand users','Inserting the USB cord, you power your mouse and avoid ever replacing batteries\r\nNavigate with the convenient 3 control buttons and central scroll whee',1,'HP X500 Black Wired USB Mouse','Madrid Street',7,33,62),(81,'Computer Mice',6,'Blue LED technology lets your mouse function on a wide range of surfaces, so you can work from almost anywhere','1200 optical sensors give you exceptional accuracy and incredible speed\r\nJust pop in the battery, plug in the USB receiver, and you’re good to go; no need to install anything',1,'HP Z3700 Blue 2.4 GHz USB','Limons Street',17,33,62),(83,'Monitors',7,'With an impressive resolution of 3,840 by 2,160 pixels, LG\'s 23.7-inch UltraFine 4K monitor shows you your photos and videos in all their splendor. ','',1,'Monitor UltraFine 4K','Madrid Street ',750,82,62),(84,'Monitors',7,'Display Diagonal Display: 60.5 cm (23.8 \") Display brightness (typical): 250 cd','',1,'Monitor 24b1xh 23.8\" Led Fullhd','Berlin Street',120,82,62),(85,'Monitors',7,'Sleek look, immersive view, give your desk a slim, sleek new addition; nearly borderless on three sides, the micro-edge designdelivers more screen in less space, idealfect for multiple display setups','High quality from any angle, watch and enjoy your content in an elegant full HD, from any angle; panel active area 47.6 x 26.77 cm',1,'HP 22w Full HD Monitor','Madrid',450,33,62),(86,'Ink Printer',8,'Print, scan and copy with fast speeds and keep tasks moving\r\nSave up to 70 Percent on ink (HP 304 inks) with HP Instant ink','',1,'HP Ink Printer','Madrid Street',25,33,62),(87,'Speakers',4,'Rich Acoustics : These multimedia speakers deliver rich, clear stereo sound with its 10 Watts peak power or 5 Watts RMS power from two 2.5-Inch drivers per speaker','Dual Connectivity : This portable PC speaker set up provides two 3.5 mm audio inputs, including auxiliary line, that works with most smartphones.',1,'Logitech Z200 PC Speakers','Madrid Street',75,43,62),(88,'Speakers',4,'Experience Sound : Loud, deep, clear sound for your music, movies and games, the Z333 wired multimedia speakers deliver 80W peak power and 40W RMS sustained power','Intense Bass : Experience deep, detailed sound with the subwoofer and large 5-Inch front-firing driver that comes in this multimedia speaker set up.',1,'Logitech Z333 2.1 Multimedia Speaker','Berlin Street ',35,43,62),(89,'Speakers',4,'Compact And Powerful: Super-portable Bluetooth speaker delivers powerful sound and robust bass through an advanced 5W driver and passive subwoofer.','Unstoppable Music: Micro SD support and AUX capability provide endless audio options.',1,'SoundCore mini, Bluetooth Speaker','Madrid Street ',49,82,62);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `post_tags` VALUES (5,'gaming'),(5,'AMD'),(5,'high end'),(5,'new'),(5,'graphics'),(7,'gaming'),(7,'AMD'),(7,'budget'),(9,'gaming'),(9,'AMD'),(9,'graphics'),(14,'gaming'),(14,'AMD'),(14,'RX'),(16,'gaming'),(16,'AMD'),(16,'graphics'),(18,'gaming'),(18,'AMD'),(18,'graphics'),(19,'MSI'),(19,'RX'),(19,'gaming'),(19,'AMD'),(19,'graphics'),(21,'gaming'),(21,'AMD'),(21,'graphics'),(23,'gaming'),(23,'AMD'),(23,'HD'),(24,'gaming'),(24,'AMD'),(24,'graphics'),(27,'gaming'),(27,'ASUS'),(27,'HD'),(29,'gaming'),(30,'Ryzen'),(31,'Ryzen'),(35,'motherboard'),(35,'AMD'),(35,'gaming'),(39,'gaming'),(44,'sound'),(46,'sound'),(53,'printer'),(60,'sound'),(4,'gaming'),(4,'graphics'),(4,'AMD'),(54,'printer'),(54,'3D'),(11,'radeon'),(11,'gaming'),(11,'AMD'),(22,'gaming'),(22,'HD'),(22,'AMD'),(51,'1TB'),(51,'HDD'),(10,'gaming'),(10,'Radeon'),(13,'gaming'),(13,'Radeon'),(6,'gaming'),(6,'AMD'),(6,'graphics'),(8,'gaming'),(8,'AMD'),(49,'1TB'),(49,'Seagate'),(37,'mouse'),(15,'AMD'),(15,'gaming'),(25,'graphics'),(25,'AMD'),(41,'gaming'),(41,'RTX'),(41,'graphics'),(63,'sound'),(63,'headphones'),(64,'sound'),(64,'headphones'),(65,'speakers'),(65,'sound'),(66,'sound'),(66,'speakers'),(67,'monitor'),(52,'laser'),(52,'printer'),(52,'HP'),(70,'monitor'),(70,'HP'),(72,'printer'),(72,'HP'),(75,'WD'),(75,'HDD'),(76,'Seagate'),(76,'HDD'),(77,'monitor'),(77,'HP'),(78,'mouse'),(78,'gaming'),(79,'mouse'),(80,'mouse'),(80,'HP'),(81,'mouse'),(81,'HP'),(83,'monitor'),(84,'monitor'),(85,'monitor'),(71,'printer'),(71,'HP'),(86,'printer'),(87,'speakers'),(88,'speakers'),(89,'speakers'),(34,'HP'),(34,'monitor');
/*!40000 ALTER TABLE `post_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `id` bigint NOT NULL,
  `stars` int NOT NULL,
  `buyer_id` bigint DEFAULT NULL,
  `seller_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1pnrukdwgtooeyk99du5e8d2f` (`buyer_id`),
  KEY `FKgsc19kkf4pcq5d5ee8gnnpss2` (`seller_id`),
  CONSTRAINT `FK1pnrukdwgtooeyk99du5e8d2f` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKgsc19kkf4pcq5d5ee8gnnpss2` FOREIGN KEY (`seller_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (56,4,55,1),(61,3,42,47),(62,2,32,20),(63,1,12,1),(64,5,42,55),(65,3,42,32),(66,2,32,42),(67,1,20,32),(68,3,59,57),(69,4,59,1),(70,5,32,47),(71,2,55,12),(72,3,32,17),(73,5,47,17),(74,1,47,42),(75,2,20,32),(76,3,47,59);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `credit_card` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'','dm@gmail.com','Diego','Montoto','$2a$10$WZ6RGYyDXm/pq9JLTrkFpuJoYqMzPRVoLxBa8B9UhSC1oE10WixBG','565465456',NULL),(12,'','gerardor@gmail.com','Gerardo ','Rivera','$2a$10$5lfqgxmnuzDCnJFLtIdACeDanMthKvqbxmqiQQiD8oKeKQWSGlP2i','456654342',NULL),(17,'','joselyn@gmail.com','Joselyn','Deyval','$2a$10$uUpn2TH1RWYucWRxk7KQgOzpTAi0/Fax37DQ.2rgg8ebDh2POOUY.','776887564',NULL),(20,'','gamer@gmail.com','xXUltimateGamerXx','Pro360NoScopeHD','$2a$10$5WbJTImUH8vmdyFTkfSG2ORPJm4aE/j/isF0mXqbO.Gzcz32oi2K.','997865342',NULL),(32,NULL,'joselus@gmail.com','Jose Luis','Bierra Senito','$2a$10$dK5YV2z37DMdjM8gGfzv9etvwXZWXZbapYkWiNBpHJI.mSvWBzEoa','785456866',NULL),(42,'','laurii@gmail.com','Laura','Flores','$2a$10$D6DaCGGzRN9hE7OKZRXNA.3CTH.WHO1VZbiKYrqptCEJnm2dwn.nu','645788342',NULL),(47,'','mary@gmail.com','Maria','Sanchez','$2a$10$vXuN5ZR/Sz7r0zeR0D2ANONrAD68PBH6aMv92UZHpBtqVCsPxgY8S','766578948',NULL),(55,NULL,'dimonra13@gmail.com','DIEGO','RAMOS','$2a$10$b/isCLZGoxMe4OaXjgp5juB7P6YXb.pRKKXgpxMnXz47ffnwnTEtO','669087298',NULL),(57,NULL,'pepita@gmail.com','pepe','pepon','$2a$10$.PADwNO/Pmqz62XlBK9e9uKltREaKvMur8IBVqWgi3kS2CshwRgh2','555555555',NULL),(58,NULL,'admin@gmail.com','Admin','ElAdmin','$2a$10$vz56wKtvG9g1bzvpvo42GOjuy.4eLdV5sqaJP6yBui384c0nF1Q6m','67434344','Calle del admin 1'),(59,NULL,'musk@gmail.com','Elon','Musk','$2a$10$Gb1g4UaT.cnuXsue5JViPOWWoAGn4WrVmpmmGDiVquVIDI6u6K8Ue','786547786',NULL),(62,'','margarita@gmail.com','Margarita','Motos','$2a$10$zl1jqXSOJuTqe3k8.IJKHO2F1u7m0fdSda704QVVzSsPcUmgmfzPC','667878547',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`),
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'ROLE_USER'),(12,'ROLE_USER'),(17,'ROLE_USER'),(20,'ROLE_USER'),(32,'ROLE_USER'),(42,'ROLE_USER'),(47,'ROLE_USER'),(55,'ROLE_USER'),(57,'ROLE_USER'),(58,'ROLE_USER'),(58,'ROLE_ADMIN'),(59,'ROLE_USER'),(62,'ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_sellers`
--

DROP TABLE IF EXISTS `user_sellers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_sellers` (
  `user_id` bigint NOT NULL,
  `sellers_id` bigint NOT NULL,
  UNIQUE KEY `UK_9ybaag8e3nreedoj419y0enhc` (`sellers_id`),
  KEY `FKfktdkhbxy4l2b517bgf2ywl50` (`user_id`),
  CONSTRAINT `FKfktdkhbxy4l2b517bgf2ywl50` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKonx7mjmfgwia7pa06pvo19q1l` FOREIGN KEY (`sellers_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_sellers`
--

LOCK TABLES `user_sellers` WRITE;
/*!40000 ALTER TABLE `user_sellers` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_sellers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tags`
--

DROP TABLE IF EXISTS `user_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tags` (
  `user_id` bigint NOT NULL,
  `tags` varchar(255) DEFAULT NULL,
  KEY `FKfcm4hc8oko2uqvf1bfypmp6st` (`user_id`),
  CONSTRAINT `FKfcm4hc8oko2uqvf1bfypmp6st` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tags`
--

LOCK TABLES `user_tags` WRITE;
/*!40000 ALTER TABLE `user_tags` DISABLE KEYS */;
INSERT INTO `user_tags` VALUES (1,'gaming'),(1,'overclocked'),(1,'overclocked'),(12,'Radeon'),(12,'gaming'),(12,'AMD'),(17,'gaming'),(17,'AMD'),(17,'MSI'),(17,'graphics'),(55,'gaming'),(55,'graphics'),(55,'gaming'),(59,'sound'),(59,'sound'),(59,'sound'),(57,'sound'),(57,'sound'),(57,'sound'),(62,'speakers'),(62,'speakers'),(62,'speakers'),(58,'HP'),(58,'monitor'),(58,'HP');
/*!40000 ALTER TABLE `user_tags` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-06 16:36:15
