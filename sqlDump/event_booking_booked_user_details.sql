-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: event_booking
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `booked_user_details`
--

DROP TABLE IF EXISTS `booked_user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booked_user_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` double NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `gender` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `e_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7frk9skkbuftoqaky1tneat2s` (`e_id`),
  CONSTRAINT `FK7frk9skkbuftoqaky1tneat2s` FOREIGN KEY (`e_id`) REFERENCES `booked_events` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booked_user_details`
--

LOCK TABLES `booked_user_details` WRITE;
/*!40000 ALTER TABLE `booked_user_details` DISABLE KEYS */;
INSERT INTO `booked_user_details` VALUES (1,21,'2023-11-29 15:06:02.724640','Male','Sree',1),(2,0,'2023-11-29 16:34:53.317419','','',2),(3,21,'2023-11-30 17:34:43.016307','Female','Kaviyanjali',3),(4,22,'2023-11-30 17:49:43.122988','Male','Ranjith',4),(5,22,'2023-11-30 17:49:43.135954','Female','Kaviyanjali',4),(6,22,'2023-11-30 17:55:42.006081','Male','MohanaSundaram',5);
/*!40000 ALTER TABLE `booked_user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-01 12:52:29
