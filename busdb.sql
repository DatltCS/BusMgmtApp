-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: busdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminId` int NOT NULL,
  `userId` int NOT NULL,
  `firstName` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `lastName` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `phone` varchar(10) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `address` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `avata` varchar(256) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `email` varchar(256) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`adminId`),
  KEY `UserId_idx` (`userId`),
  CONSTRAINT `fk_admin_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bus` (
  `licensePlateId` int NOT NULL,
  `companyId` int NOT NULL,
  `busName` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `totalSeat` int NOT NULL,
  PRIMARY KEY (`licensePlateId`),
  UNIQUE KEY `id_bienso_UNIQUE` (`licensePlateId`),
  KEY `id_nha_xe_idx` (`companyId`),
  CONSTRAINT `companyId` FOREIGN KEY (`companyId`) REFERENCES `buscompanies` (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buscompanies`
--

DROP TABLE IF EXISTS `buscompanies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buscompanies` (
  `companyId` int NOT NULL,
  `userId` int NOT NULL,
  `nameCompany` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `totalBus` int NOT NULL,
  `avata` varchar(256) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `status` tinyint NOT NULL,
  `address` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `phone` varchar(10) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `allowedDelivery` tinyint NOT NULL,
  PRIMARY KEY (`companyId`),
  KEY `UserId_idx` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buscompanies`
--

LOCK TABLES `buscompanies` WRITE;
/*!40000 ALTER TABLE `buscompanies` DISABLE KEYS */;
/*!40000 ALTER TABLE `buscompanies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busroutes`
--

DROP TABLE IF EXISTS `busroutes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `busroutes` (
  `routeId` int NOT NULL,
  `routeName` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `palaceStart` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `palaceStop` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`routeId`),
  UNIQUE KEY `id_tuyen_UNIQUE` (`routeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busroutes`
--

LOCK TABLES `busroutes` WRITE;
/*!40000 ALTER TABLE `busroutes` DISABLE KEYS */;
/*!40000 ALTER TABLE `busroutes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bustrips`
--

DROP TABLE IF EXISTS `bustrips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bustrips` (
  `tripId` int NOT NULL,
  `routeId` int NOT NULL,
  `licensePlateId` int NOT NULL,
  `tripName` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `timeStart` time NOT NULL,
  `timeStop` time NOT NULL,
  PRIMARY KEY (`tripId`),
  KEY `RouteId_idx` (`routeId`),
  KEY `LicensePlateId_idx` (`licensePlateId`),
  CONSTRAINT `licensePlateId` FOREIGN KEY (`licensePlateId`) REFERENCES `bus` (`licensePlateId`),
  CONSTRAINT `routeId` FOREIGN KEY (`routeId`) REFERENCES `busroutes` (`routeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bustrips`
--

LOCK TABLES `bustrips` WRITE;
/*!40000 ALTER TABLE `bustrips` DISABLE KEYS */;
/*!40000 ALTER TABLE `bustrips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerId` int NOT NULL,
  `userId` int NOT NULL,
  `firstName` varchar(30) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `lastName` varchar(10) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `phone` varchar(10) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `address` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `avata` varchar(256) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`customerId`),
  KEY `user_idx` (`userId`),
  CONSTRAINT `user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliveries`
--

DROP TABLE IF EXISTS `deliveries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliveries` (
  `deliveryId` int NOT NULL,
  `customerId` int NOT NULL,
  `description` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `senderName` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `senderPhone` varchar(10) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `senderEmail` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `receiverName` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `receiverPhone` varchar(10) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `receiverEmail` varchar(100) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `sendTime` datetime NOT NULL,
  `receiveTime` datetime DEFAULT NULL,
  `createDate` datetime NOT NULL,
  `paymentMethod` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `status` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`deliveryId`),
  KEY `customerId_idx` (`customerId`),
  CONSTRAINT `customerId` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveries`
--

LOCK TABLES `deliveries` WRITE;
/*!40000 ALTER TABLE `deliveries` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliveries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revenuestatistics`
--

DROP TABLE IF EXISTS `revenuestatistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revenuestatistics` (
  `revenueStatisticId` int NOT NULL,
  `companyId` int NOT NULL,
  `month` date DEFAULT NULL,
  `quarter` int DEFAULT NULL,
  `year` year DEFAULT NULL,
  `revenue` decimal(16,0) DEFAULT NULL,
  PRIMARY KEY (`revenueStatisticId`),
  KEY `companyId_idx` (`companyId`),
  CONSTRAINT `companyIds` FOREIGN KEY (`companyId`) REFERENCES `buscompanies` (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revenuestatistics`
--

LOCK TABLES `revenuestatistics` WRITE;
/*!40000 ALTER TABLE `revenuestatistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `revenuestatistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `reviewId` int NOT NULL,
  `customerId` int NOT NULL,
  `rating` int NOT NULL,
  `comment` varchar(300) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`reviewId`),
  KEY `CustomerId_idx` (`customerId`),
  CONSTRAINT `fk_reviews_customerId` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routestatistics`
--

DROP TABLE IF EXISTS `routestatistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routestatistics` (
  `routeStatisticsId` int NOT NULL,
  `routeId` int NOT NULL,
  `month` date DEFAULT NULL,
  `quarter` int DEFAULT NULL,
  `year` year DEFAULT NULL,
  `frequency` int DEFAULT NULL,
  PRIMARY KEY (`routeStatisticsId`),
  KEY `routeId_idx` (`routeId`),
  CONSTRAINT `routeIds` FOREIGN KEY (`routeId`) REFERENCES `busroutes` (`routeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routestatistics`
--

LOCK TABLES `routestatistics` WRITE;
/*!40000 ALTER TABLE `routestatistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `routestatistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `ticketId` int NOT NULL,
  `customerId` int NOT NULL,
  `numSeat` varchar(3) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `status` tinyint NOT NULL,
  `paymentMethod` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`ticketId`),
  KEY `customerId_idx` (`customerId`),
  CONSTRAINT `fk_tickets_customerId` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userId` int NOT NULL,
  `username` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `role` varchar(45) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `accountStatus` varchar(20) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `Username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-12 13:28:07
