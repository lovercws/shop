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
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_status` varchar(10) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `editor` varchar(45) DEFAULT NULL COMMENT ' 修改人.',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间.',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  `menu_code` varchar(45) DEFAULT NULL COMMENT '菜单内码',
  `menu_name` varchar(45) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(45) DEFAULT NULL COMMENT '菜单地址',
  `menu_num` int(11) DEFAULT NULL COMMENT '菜单编号（用于显示时排序）',
  `is_leaf` tinyint(4) DEFAULT NULL COMMENT '是否为叶子节点',
  `menu_icon` varchar(45) DEFAULT NULL COMMENT '菜单图标',
  `menu_visible` varchar(10) DEFAULT NULL COMMENT '菜单可见 show,hidden',
  `level` int(11) DEFAULT NULL COMMENT '菜单层级',
  `parent_menu_id` int(11) DEFAULT NULL COMMENT '父节点:一级菜单为0',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (25,'1','lgan','2016-09-29 22:00:04','admin','2016-09-29 23:35:57','系统管理；功能设置','system','系统设置','',1000,0,'glyphicon glyphicon-th','show',1,0),(26,'1','lgan','2016-09-29 22:00:33','admin','2016-09-29 23:36:05','相册管理;','album','相册管理','',900,0,'','show',1,0),(27,'1','lgan','2016-09-29 22:01:03','admin','2016-09-29 23:36:11','书籍管理','book','书籍管理','',800,0,'','show',1,0),(28,'1','lgan','2016-09-29 22:02:42','admin','2016-09-29 23:36:22','系统管理：用户管理','system:user','用户管理','/system/user/list',990,0,'glyphicon glyphicon-user','show',2,25),(29,'1','lgan','2016-09-29 22:03:29','admin','2016-09-29 23:40:50','系统设置:角色管理','system:role','角色管理','/system/role/list',980,0,'glyphicon glyphicon-user','show',2,25),(30,'1','lgan','2016-09-29 22:07:28','admin','2016-09-29 23:37:22','系统设置 菜单管理','system:menu','菜单管理','/system/menu/list',970,0,'/glyphicon glyphicon-user','show',2,25),(31,'1','lgan','2016-09-29 22:08:33','admin','2016-09-29 23:37:53','系统设置；\r\n权限管理','system:permission','权限管理','/system/permission/list',960,0,'glyphicon glyphicon-user','show',2,25),(32,'1','lgan','2016-09-29 22:09:28','admin','2016-09-29 23:38:06','系统设置；数据字典','system:ddl','数据字典','/system/ddl/list',950,0,'glyphicon glyphicon-list','show',2,25),(33,'1','lgan','2016-09-29 22:10:25','admin','2016-09-29 23:38:13','系统设置；日志管理','system:log','日志管理','/system/log/list',940,0,'glyphicon glyphicon-list','show',2,25),(34,'1','lgan','2016-09-29 22:11:19','admin','2016-09-29 23:38:39','系统设置；导出设置','system:export','导出设置','/system/export/list',930,0,'glyphicon glyphicon-user','show',2,25);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
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
