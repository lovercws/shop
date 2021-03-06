-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_permission` (
  `role_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_permission_status` varchar(45) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='系统角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES (3,'1','lgan','2016-09-29 22:50:17',11,5),(4,'1','lgan','2016-09-29 22:50:17',11,6),(5,'1','lgan','2016-09-29 22:50:17',11,7),(6,'1','lgan','2016-09-29 22:50:17',11,8),(7,'1','lgan','2016-09-29 22:50:17',11,9),(8,'1','lgan','2016-09-29 22:50:17',11,10),(9,'1','lgan','2016-09-29 22:50:17',11,11),(10,'1','lgan','2016-09-29 22:50:17',11,12),(11,'1','lgan','2016-09-29 22:50:17',11,13),(12,'1','lgan','2016-09-29 22:50:17',11,14),(13,'1','lgan','2016-09-29 22:50:17',11,15),(14,'1','lgan','2016-09-29 22:50:17',11,16),(15,'1','lgan','2016-09-29 22:50:17',11,17),(16,'1','lgan','2016-09-29 22:50:17',11,22),(17,'1','lgan','2016-09-29 22:50:17',11,23),(18,'1','lgan','2016-09-29 22:50:17',11,24),(19,'1','lgan','2016-09-29 22:50:17',11,25),(20,'1','lgan','2016-09-29 22:50:17',11,18),(21,'1','lgan','2016-09-29 22:50:17',11,19),(22,'1','lgan','2016-09-29 22:50:17',11,20),(23,'1','lgan','2016-09-29 22:50:17',11,21),(24,'1','lgan','2016-09-29 22:50:17',11,26),(25,'1','lgan','2016-09-29 22:50:17',11,27),(26,'1','lgan','2016-09-29 22:50:17',11,28),(27,'1','lgan','2016-09-29 22:50:17',11,29),(28,'1','lgan','2016-09-29 22:50:17',11,30),(29,'1','lgan','2016-09-29 22:50:17',11,31),(30,'1','lgan','2016-09-29 22:50:17',11,32),(31,'1','lgan','2016-09-29 22:50:17',11,33),(32,'1','lgan','2016-09-29 22:50:17',11,34),(33,'1','lgan','2016-09-29 22:50:17',11,35),(34,'1','lgan','2016-09-29 22:50:17',11,36);
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-29 23:42:16
