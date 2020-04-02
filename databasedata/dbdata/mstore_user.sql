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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-02  1:32:43
