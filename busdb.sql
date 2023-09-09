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
  `adminId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `firstName` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `lastName` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `email` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  PRIMARY KEY (`adminId`),
  KEY `fk_admin_userId_idx` (`userId`),
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
  `busName` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `totalSeat` int NOT NULL,
  `busType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `image` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`licensePlateId`),
  UNIQUE KEY `id_bienso_UNIQUE` (`licensePlateId`),
  KEY `companyId_idx` (`companyId`),
  CONSTRAINT `companyId` FOREIGN KEY (`companyId`) REFERENCES `buscompanies` (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES (501,1,'Xe Kumho ',30,'ghế ngồi VIP','https://res.cloudinary.com/dc9dlukr6/image/upload/v1692612156/assets/xe_phuong_trang_to30yn.jpg'),(502,2,'Xe Kumho ',34,'giường nằm','https://res.cloudinary.com/dc9dlukr6/image/upload/v1692612156/assets/xe_kumho_txflpf.jpg'),(504,2,'Can\'t forget',10,'Funny type','https://res.cloudinary.com/dc9dlukr6/image/upload/v1693672865/dz4eiyq9hdqzdgicsclw.jpg'),(510,1,'Xe Kumho ',60,'Ghế ngồi VIP','https://res.cloudinary.com/dc9dlukr6/image/upload/v1692612156/assets/xe_phuong_trang_to30yn.jpg'),(807,6,'Can\'t forget',34,'Funny type','https://res.cloudinary.com/dc9dlukr6/image/upload/v1693857797/tkbtnzuygrvik0xc88hi.jpg'),(900,1,'Xe Phương Trang ',30,'ghế ngồi VIP','https://res.cloudinary.com/dc9dlukr6/image/upload/v1692612156/assets/xe_phuong_trang_to30yn.jpg');
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buscompanies`
--

DROP TABLE IF EXISTS `buscompanies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buscompanies` (
  `companyId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `nameCompany` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `totalBus` int DEFAULT NULL,
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `allowedDelivery` tinyint DEFAULT NULL,
  PRIMARY KEY (`companyId`),
  KEY `fk_buscompanies_user_idx` (`userId`),
  CONSTRAINT `fk_buscompanies_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buscompanies`
--

LOCK TABLES `buscompanies` WRITE;
/*!40000 ALTER TABLE `buscompanies` DISABLE KEYS */;
INSERT INTO `buscompanies` VALUES (1,8,'Futa Buslines',30,'https://res.cloudinary.com/dc9dlukr6/image/upload/v1692612156/assets/xe_phuong_trang_to30yn.jpg','enabled','Số 01 Tô Hiến Thành, Phường 3, Thành phố Đà Lạt, Tỉnh Lâm Đồng, Việt Nam.','02838386853','hotro@futa.vn',1),(2,9,'Kumho Samco Buslines',15,'https://res.cloudinary.com/dc9dlukr6/image/upload/v1692612156/assets/xe_kumho_txflpf.jpg','enabled','292 – Đinh Bộ Lĩnh, Phường 26, quận Bình Thạnh, TPHCM.','0903580000','lienhe@kumhosamco.com.vn',1),(3,15,'Nhà xe Hadilao',75,'https://res.cloudinary.com/dc9dlukr6/image/upload/v1693735556/ler4jnnvynfq4kodqprs.jpg','Enabled','23/89 Lê Văn Duyệt, phường 3, quận Bình Thạnh','0386221906','datluongtan1410@gmail.com',0),(4,15,'Nhà xe Hadilao',75,'https://res.cloudinary.com/dc9dlukr6/image/upload/v1693735576/zpq7eteltnwam30fdmy9.png','Enabled','23/89 Lê Văn Duyệt, phường 3, quận Bình Thạnh','0386221906','datluongtan1410@gmail.com',0),(5,15,'Hanh Cafe',75,'https://res.cloudinary.com/dc9dlukr6/image/upload/v1693742572/obgnb0cqhkdqqt8n8ndd.jpg','Enabled','23/89 Lê Văn Duyệt, phường 3, quận Bình Thạnh','0386221906','datluongtan1410@gmail.com',0),(6,17,'Tâm Hạnh',75,'https://res.cloudinary.com/dc9dlukr6/image/upload/v1693857756/u4uhpp16uobkhng7przq.png','Enabled','23/89 Lê Văn Duyệt, phường 3, quận Bình Thạnh','0386221906','datluongtan1410@gmail.com',0);
/*!40000 ALTER TABLE `buscompanies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busroutes`
--

DROP TABLE IF EXISTS `busroutes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `busroutes` (
  `routeId` int NOT NULL AUTO_INCREMENT,
  `routeName` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `placeStart` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `placeStop` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`routeId`),
  UNIQUE KEY `id_tuyen_UNIQUE` (`routeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busroutes`
--

LOCK TABLES `busroutes` WRITE;
/*!40000 ALTER TABLE `busroutes` DISABLE KEYS */;
INSERT INTO `busroutes` VALUES (1,'Cần Thơ - Hồ Chí Minh','Cần Thơ','Nha Trang'),(2,'Hà Tiên - Hồ Chí Minh','Hà Tiên ','Hồ Chí Minh'),(4,'Phan Thiết - Hồ Chí Minh','Phan Thiết','Hồ Chí Minh'),(5,'Cần Thơ - Phan Thiết','Cần Thơ','Hồ Chí Minh');
/*!40000 ALTER TABLE `busroutes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busseat`
--

DROP TABLE IF EXISTS `busseat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `busseat` (
  `seatId` int NOT NULL AUTO_INCREMENT,
  `licensePlateId` int NOT NULL,
  `numSeat` varchar(3) COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  PRIMARY KEY (`seatId`),
  KEY `fk_busseat_bus_idx` (`licensePlateId`),
  CONSTRAINT `fk_busseat_bus` FOREIGN KEY (`licensePlateId`) REFERENCES `bus` (`licensePlateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busseat`
--

LOCK TABLES `busseat` WRITE;
/*!40000 ALTER TABLE `busseat` DISABLE KEYS */;
/*!40000 ALTER TABLE `busseat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bustrips`
--

DROP TABLE IF EXISTS `bustrips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bustrips` (
  `tripId` int NOT NULL AUTO_INCREMENT,
  `routeId` int NOT NULL,
  `licensePlateId` int NOT NULL,
  `tripName` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `timeStart` datetime NOT NULL,
  `timeStop` datetime NOT NULL,
  PRIMARY KEY (`tripId`),
  KEY `licensePlateId_idx` (`licensePlateId`),
  KEY `routeId_idx` (`routeId`),
  CONSTRAINT `licensePlateId` FOREIGN KEY (`licensePlateId`) REFERENCES `bus` (`licensePlateId`),
  CONSTRAINT `routeId` FOREIGN KEY (`routeId`) REFERENCES `busroutes` (`routeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bustrips`
--

LOCK TABLES `bustrips` WRITE;
/*!40000 ALTER TABLE `bustrips` DISABLE KEYS */;
INSERT INTO `bustrips` VALUES (2,2,502,'Hà Tiên - Hồ Chí Minh',290,'2023-09-05 23:00:00','2023-09-05 05:00:00');
/*!40000 ALTER TABLE `bustrips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `firstName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `lastName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  KEY `user_idx` (`userId`),
  CONSTRAINT `user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,5,'Anh','Nguyễn','0988566221','Nguyễn Kiệm, Gò Vấp, TPHCM','https://res.cloudinary.com/dc9dlukr6/image/upload/v1692612377/assets/user_avatar_bwwrhq.png','workanhnguyen@gmail.com'),(2,6,'Minh','Trần','0387456239','Nghĩa Hưng, Tân Bình, TPHCM','nullhttps://res.cloudinary.com/dc9dlukr6/image/upload/v1692612377/assets/user_avatar_bwwrhq.png','minhanh208@gmail.com');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliveries`
--

DROP TABLE IF EXISTS `deliveries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliveries` (
  `deliveryId` int NOT NULL AUTO_INCREMENT,
  `orderId` int NOT NULL,
  `tripId` int NOT NULL,
  `description` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `receiverName` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `receiverPhone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `receiverEmail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `sendTime` datetime NOT NULL,
  `receiveTime` datetime DEFAULT NULL,
  `createDate` datetime NOT NULL,
  `paymentMethod` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`deliveryId`),
  KEY `fk_delivery_tripId_idx` (`tripId`),
  KEY `fk_delivery_orderId_idx` (`orderId`),
  CONSTRAINT `fk_delivery_orderId` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`),
  CONSTRAINT `fk_delivery_tripId` FOREIGN KEY (`tripId`) REFERENCES `bustrips` (`tripId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveries`
--

LOCK TABLES `deliveries` WRITE;
/*!40000 ALTER TABLE `deliveries` DISABLE KEYS */;
INSERT INTO `deliveries` VALUES (2,1,2,'dddd','a','0','w@gmail.com','2023-05-01 08:00:00','2023-05-01 09:00:00','2023-05-01 08:00:00','offline','waitting',250000);
/*!40000 ALTER TABLE `deliveries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `createDate` datetime NOT NULL,
  `amount` decimal(16,0) DEFAULT NULL,
  `customerId` int DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `fk_orders_customer_idx` (`customerId`),
  CONSTRAINT `fk_orders_customer` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2023-12-23 08:00:00',150,1),(2,'2023-12-23 08:00:00',200,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revenuestatistics`
--

DROP TABLE IF EXISTS `revenuestatistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revenuestatistics` (
  `revenueStatisticId` int NOT NULL AUTO_INCREMENT,
  `companyId` int NOT NULL,
  `month` date DEFAULT NULL,
  `quarter` int DEFAULT NULL,
  `year` year DEFAULT NULL,
  `revenue` decimal(16,0) DEFAULT NULL,
  PRIMARY KEY (`revenueStatisticId`),
  KEY `companyIds_idx` (`companyId`),
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
  `reviewId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `tripId` int NOT NULL,
  `rating` int NOT NULL,
  `comment` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `createdDate` date DEFAULT NULL,
  PRIMARY KEY (`reviewId`),
  KEY `fk_reviews_tripId_idx` (`tripId`),
  KEY `fk_reviews_userId_idx` (`userId`),
  CONSTRAINT `fk_reviews_tripId` FOREIGN KEY (`tripId`) REFERENCES `bustrips` (`tripId`),
  CONSTRAINT `fk_reviews_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
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
  `routeStatisticsId` int NOT NULL AUTO_INCREMENT,
  `routeId` int NOT NULL,
  `month` date DEFAULT NULL,
  `quarter` int DEFAULT NULL,
  `year` year DEFAULT NULL,
  `frequency` int DEFAULT NULL,
  PRIMARY KEY (`routeStatisticsId`),
  KEY `routeIds_idx` (`routeId`),
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
  `ticketId` int NOT NULL AUTO_INCREMENT,
  `orderId` int NOT NULL,
  `tripId` int NOT NULL,
  `numSeat` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `paymentMethod` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`ticketId`),
  KEY `fk_tickets_tripId_idx` (`tripId`),
  KEY `fk_tickets_order_idx` (`orderId`),
  CONSTRAINT `fk_tickets_order` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`),
  CONSTRAINT `fk_tickets_tripId` FOREIGN KEY (`tripId`) REFERENCES `bustrips` (`tripId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
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
  `userId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `user_role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `accountStatus` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs NOT NULL,
  `avatar` varchar(200) COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `Username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'nhaxePhuongTrang','PT9876','Nhà xe','enabled',NULL),(2,'nhaxeKumho','Kumho1234','Nhà xe','disabled',NULL),(3,'quynhdao632','quynhdao632002','Admin','enabled',NULL),(4,'luongdat001','luongdat1234','Admin','enabled',NULL),(5,'vananh002','vananh002','Khách hàng','enabled',NULL),(6,'minhanh003','minhanh003','Khách hàng','enabled',NULL),(8,'luongdat','$2a$10$.B.2.eTpDFbnLClyGjnaNufCMaIDbwzE87EgVBZ6IcX48Ztl5UNEC','ROLE_ADMIN','enable',NULL),(9,'hello','$2a$10$IyhwYJziP4iXD.r1Sj8t4OM1DsTU0VMcBJwzQt.IcK93BjPOMradS','ROLE_BUSCOMPANY','enable',NULL),(11,'luongtandat','$2a$10$WemmUemeqOo9DcyWvTULNeBlougstzdfCkpP0.EDt.O5IMUcFQ7aS','ROLE_ADMIN','enable',NULL),(12,'datluong','$2a$10$ODREIsU/IrKTL2WyFhoCQuHAz5SMiQ/c81dtzo6nqWs09gGDM.Md.','ROLE_USER','enable',NULL),(14,'1234','$2a$10$HAOQeNLWcxnVVK9YD03xK.wJMa3LsRj4wsDSiOsHbAHWlGebpsO1K','ROLE_USER','enable',NULL),(15,'ngocanh','$2a$10$xClHphz.VA2ZSzKVNIlrtOtE0UxJjVcOcKg9T8ANRrvWERv2n3XvG','ROLE_USER','enable',NULL),(17,'ngocanh1','$2a$10$pM.iZSdXp/yeU5UVmBeZAu6L.8R0Zzxth1F1ceYq/uLS57ucK0xFK','ROLE_USER','enable',NULL);
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

-- Dump completed on 2023-09-08 17:45:33
