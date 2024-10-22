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
-- Table structure for table `medicineinfo`
--

DROP TABLE IF EXISTS `medicineinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicineinfo` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mname` varchar(255) DEFAULT NULL COMMENT '名称',
  `mshortname` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `producttime` date DEFAULT NULL COMMENT '生产时间',
  `warrenty` varchar(255) DEFAULT NULL COMMENT '保质期（月）',
  `number` char(10) DEFAULT NULL COMMENT '药品编码',
  `price` float(20,2) DEFAULT NULL COMMENT '价格',
  `stock` int DEFAULT NULL COMMENT '库存',
  `mnameeng` varchar(45) DEFAULT NULL COMMENT '药品英文名',
  `isprescription` tinyint DEFAULT NULL,
  `mcontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='药品信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicineinfo`
--

LOCK TABLES `medicineinfo` WRITE;
/*!40000 ALTER TABLE `medicineinfo` DISABLE KEYS */;
INSERT INTO `medicineinfo` VALUES (2,'999感冒灵','感冒灵','白云山','2019-05-31','24','00001',16.80,500,'Ganmaoling',0,'“感冒灵颗粒是中药和西药的复方制剂，它的主要成分是三叉苦、金盏银盘、野菊花、岗梅、咖啡因、对乙酰氨基酚、马来酸氯苯那敏、薄荷油。它主要的功效就是解热镇痛，可以用于感冒引起的头痛、发热、鼻塞、流涕、咽痛。'),(3,'百宝丹','云南白药','云南白药','2019-06-30','60','00002',25.69,900,'Yunnan Baiyao ',0,'云南白药是云南著名的中成药，由名贵药材制成，具有化瘀止血、活血止痛、解毒消肿之功效。'),(5,'复方醋酸地塞米松凝胶','皮炎平','三九医药','2020-06-01','24','00003',9.82,1000,' Compound Dexamethasone Acetate',NULL,'用于局限性搔痒症、神经性皮炎、接触性皮炎、脂溢性皮炎以及慢性湿疹。'),(6,'异丁苯丙酸','布洛芬','金甲王药物研究','2021-09-22','60','00004',25.64,1000,'Ibuprofen',0,'用于治疗偏头痛'),(14,'感冒灵','测试','西南制药','2022-10-01','36','测试',12.53,200,'test',0,'测试'),(15,'test','test','云南白药','2022-10-18','20','test',22.25,200,'test',0,'test');
/*!40000 ALTER TABLE `medicineinfo` ENABLE KEYS */;
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
