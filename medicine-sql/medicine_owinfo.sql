-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: medicine
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `owinfo`
--

DROP TABLE IF EXISTS `owinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owinfo` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mname` varchar(255) DEFAULT NULL COMMENT '药品名称',
  `count` int DEFAULT NULL COMMENT '数量',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `createtime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COMMENT='出入库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owinfo`
--

LOCK TABLES `owinfo` WRITE;
/*!40000 ALTER TABLE `owinfo` DISABLE KEYS */;
INSERT INTO `owinfo` VALUES (1,'云南白药',300,'小江','2022-09-14 08:03:05'),(2,'皮炎平',160,'小李','2022-09-14 08:03:34'),(4,'布洛芬',200,'小钟','2022-09-14 08:14:26'),(5,'云南白药',50,'小李','2022-09-17 16:11:43'),(7,'皮炎平',200,'小李','2022-09-22 08:34:36'),(8,'感冒灵',300,'小江','2022-10-09 15:25:29'),(9,'undefined',22,'22','2022-10-21 01:12:04');
/*!40000 ALTER TABLE `owinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-30 21:50:38
