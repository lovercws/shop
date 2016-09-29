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
-- Table structure for table `sys_export_model`
--

DROP TABLE IF EXISTS `sys_export_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_export_model` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `model_status` varchar(10) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `editor` varchar(45) DEFAULT NULL COMMENT '修改人.',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间.',
  `remark` varchar(45) DEFAULT NULL COMMENT '描述',
  `model_name` varchar(45) DEFAULT NULL COMMENT '所属模块，如用户管理为：system-user',
  `c_names` varchar(500) DEFAULT NULL COMMENT '导出字段的中文名',
  `e_names` varchar(500) DEFAULT NULL COMMENT '未导出字段的中文名',
  PRIMARY KEY (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统导出字段表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_export_model`
--

LOCK TABLES `sys_export_model` WRITE;
/*!40000 ALTER TABLE `sys_export_model` DISABLE KEYS */;
INSERT INTO `sys_export_model` VALUES (2,'1','lgan','2016-09-26 22:57:26','lgan','2016-09-27 20:55:33',NULL,'sys_export_model','模块名称,中文字段,英文字段','model_name,c_names,e_names'),(3,'1','lgan','2016-09-26 23:02:43',NULL,NULL,NULL,'sys_permission',' ,状态 PublicStatusEnum,创建人.,创建时间.,修改人.,修改时间.,描述,权限内码,权限名称,权限标识,菜单id（权限是从菜单项中派发出来的）,权限路径','permission_id,permission_status,creator,create_time,editor,edit_time,remark,permission_code,permission_name,permission,menu_id,permission_path');
/*!40000 ALTER TABLE `sys_export_model` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-29 23:42:15
