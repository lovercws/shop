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
-- Table structure for table `sys_ddl`
--

DROP TABLE IF EXISTS `sys_ddl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_ddl` (
  `ddl_id` int(11) NOT NULL AUTO_INCREMENT,
  `ddl_status` varchar(10) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `editor` varchar(45) DEFAULT NULL COMMENT '修改人.',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间.',
  `remark` varchar(45) DEFAULT NULL COMMENT '描述',
  `ddl_code` varchar(45) DEFAULT NULL COMMENT '数据字典内码',
  `ddl_name` varchar(45) DEFAULT NULL COMMENT '数据字典名称',
  `ddl_key` varchar(45) DEFAULT NULL COMMENT '数据字典key',
  `ddl_value` varchar(45) DEFAULT NULL COMMENT '数据字典值',
  `ddl_number` int(11) DEFAULT NULL COMMENT '数据字典排序',
  PRIMARY KEY (`ddl_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='系统数据字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_ddl`
--

LOCK TABLES `sys_ddl` WRITE;
/*!40000 ALTER TABLE `sys_ddl` DISABLE KEYS */;
INSERT INTO `sys_ddl` VALUES (1,NULL,NULL,'2016-09-11 16:03:58',NULL,NULL,'man','sex','性别','男','1',100),(2,'1','admin','2016-09-11 16:12:14',NULL,NULL,'man','sex','性别','男','1',100),(3,'1','admin','2016-09-11 16:17:33','admin','2016-09-11 19:05:16','femal','sex','性别','女','2',100),(6,'1','admin','2016-09-11 19:15:40','admin','2016-09-11 19:16:00','未知性别','sex','性别','未知','0',100),(7,'1','admin','2016-09-11 19:18:03',NULL,NULL,'禁用','public','公共','forbit','0',90),(8,'1','admin','2016-09-11 19:18:26',NULL,NULL,'正常','public','公共','normal','1',90),(9,'1','admin','2016-09-11 19:18:47',NULL,NULL,'删除','public','公共','delete','2',90),(10,'1','admin','2016-09-11 19:20:56',NULL,NULL,'黄色图片','color','颜色','黄色','yellow',80),(11,'1','admin','2016-09-11 19:21:18',NULL,NULL,'红色颜色','color','颜色','红色','red',80),(12,'1','admin','2016-09-11 19:21:46','admin','2016-09-11 19:22:51','绿色','color','颜色','绿色','green',80),(14,'1','admin','2016-09-11 19:22:39',NULL,NULL,'黑色','color','颜色','黑色','black',80),(16,'1','admin','2016-09-11 23:18:35',NULL,NULL,'白色是混合光','color','颜色','白色','white',80),(17,'1','admin','2016-09-11 23:19:00',NULL,NULL,'黑色大地','color','颜色','黑色','black',80);
/*!40000 ALTER TABLE `sys_ddl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-11 23:49:29
