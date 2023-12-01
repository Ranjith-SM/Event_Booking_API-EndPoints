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
-- Table structure for table `event_ticket`
--

DROP TABLE IF EXISTS `event_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `desc` varchar(100) NOT NULL,
  `event_date` datetime(6) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `title` varchar(100) NOT NULL,
  `total_availability` double NOT NULL,
  `a_id` int DEFAULT NULL,
  `c_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKakxd29t8qkipbf3o60uiujmx2` (`a_id`),
  KEY `FKaf8mot9ow0ebd5qmn562c4esf` (`c_id`),
  CONSTRAINT `FKaf8mot9ow0ebd5qmn562c4esf` FOREIGN KEY (`c_id`) REFERENCES `event_category` (`id`),
  CONSTRAINT `FKakxd29t8qkipbf3o60uiujmx2` FOREIGN KEY (`a_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_ticket`
--

LOCK TABLES `event_ticket` WRITE;
/*!40000 ALTER TABLE `event_ticket` DISABLE KEYS */;
INSERT INTO `event_ticket` VALUES (1,50,'2023-11-29 10:58:05.368684','Workshop about the stock market','2023-12-05 00:00:00.000000','1701235685312-file.png',899,'Basics of Stock Market',50,1,1),(2,20,'2023-11-29 11:02:02.293388','Workshop about how to build portfolio using ETF\'s','2024-01-06 00:00:00.000000','1701235922284-file.png',99,'Build Portfolio using ETFs',20,2,1),(3,100,'2023-11-29 11:05:37.319041','learn to rap from home','2024-01-02 00:00:00.000000','1701236137310-file.jpg',99,'Learn Rap Online from Home',100,3,2),(4,100,'2023-11-29 11:07:25.747821','learn to utilise the time effectively','2024-01-04 00:00:00.000000','1701236245739-file.png',99,'Time Management for Stress Free Results',100,4,2),(5,100,'2023-11-29 11:10:15.884647','learn to trade in intraday trading successfully','2024-01-03 00:00:00.000000','1701236415860-file.png',499,'Professional & Successful Commodity Intraday Trading',100,5,2),(6,100,'2023-11-29 11:47:19.343980','Sangeetha Payithiyam is a musical comedy considered the father of modern Tamil drama. ','2024-01-08 00:00:00.000000','1701238639334-file.jpg',300,'Sangeetha Payithiyam ',100,8,3),(7,500,'2023-11-29 11:50:55.221145','Splash 2023 - is a national art festival which celebrates the freedom of expression via art.','2023-12-01 00:00:00.000000','1701238855211-file.jpg',100,'SPLASH 2023',500,9,3),(8,100,'2023-11-29 11:55:17.348637','et\'s Join and discover the magic of Our resin art Workshop where every drop tells a unique story!','2023-12-03 00:00:00.000000','1701239117340-file.png',2999,'Resin Art Workshop',100,13,3),(9,1000,'2023-11-29 11:58:46.414927','This show happens to be the most anticipated show of the decade.','2023-12-31 00:00:00.000000','1701239326405-file.jpg',749,'Vijay Antovy',1000,15,4),(10,1000,'2023-11-29 12:01:50.222109','All set to take you to a world of pure musical bliss as Shreya Ghoshal graces the stage','2023-12-23 00:00:00.000000','1701239510215-file.png',999,'Shreya Ghoshal RedFM Live Concert',1000,17,4),(11,1000,'2023-11-29 12:57:37.840615','An Exhibit of fine Indian Classical and contemporary music.','2024-01-05 00:00:00.000000','1701242857827-file.png',299,'Amritha Thankachy Live',1000,18,4);
/*!40000 ALTER TABLE `event_ticket` ENABLE KEYS */;
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
