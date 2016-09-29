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
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_status` varchar(45) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `editor` varchar(45) DEFAULT NULL COMMENT '修改人.',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间.',
  `remark` varchar(45) DEFAULT NULL COMMENT '描述',
  `permission_code` varchar(45) DEFAULT NULL COMMENT '权限内码',
  `permission_name` varchar(45) DEFAULT NULL COMMENT '权限名称',
  `permission` varchar(45) DEFAULT NULL COMMENT '权限标识',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id（权限是从菜单项中派发出来的）',
  `permission_path` varchar(45) DEFAULT NULL COMMENT '权限路径',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='系统权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (5,'1','lgan','2016-09-29 22:15:24','lgan','2016-09-29 22:19:21','查看用户信息','system:user:view','查看用户','system:user:view',28,'system/user/view'),(6,'1','lgan','2016-09-29 22:16:00',NULL,NULL,'编辑用户','system:user:edit','编辑用户','system:user:edit',28,'system/user/edit'),(7,'1','lgan','2016-09-29 22:16:29',NULL,NULL,'删除用户','system:user:delete','删除用户','system:user:delete',28,'system/user/delete'),(8,'1','lgan','2016-09-29 22:18:18',NULL,NULL,'添加用户','system:user:add','添加用户','system:user:add',28,'system/user/add'),(9,'1','lgan','2016-09-29 22:20:14',NULL,NULL,'用户分配角色','system:user:allowrole','用户分配角色','system:user:allowrole',28,'system/user/allowrole'),(10,'1','lgan','2016-09-29 22:20:46',NULL,NULL,'用户导出到excel','system:user:export','用户导出','system:user:export',28,'system/user/export'),(11,'1','lgan','2016-09-29 22:21:33',NULL,NULL,'用户从excel中导入用户','system:user:import','用户导入','system:user:import',28,'system/user/import'),(12,'1','lgan','2016-09-29 22:35:25',NULL,NULL,'增加角色','system:role:add','增加角色','system:role:add',29,'system/role/add'),(13,'1','lgan','2016-09-29 22:35:57',NULL,NULL,'删除角色','system:role:delete','删除角色','system:role:delete',29,'system/role/delete'),(14,'1','lgan','2016-09-29 22:36:30',NULL,NULL,'编辑角色','system:role:edit','编辑角色','system:role:edit',29,'system/role/edit'),(15,'1','lgan','2016-09-29 22:37:14',NULL,NULL,'查看角色','system:role:view','查看角色','system:role:view',29,'system/role/view'),(16,'1','lgan','2016-09-29 22:38:05','lgan','2016-09-29 22:38:52','分配菜单','system:role:allowmenu','分配菜单','system:role:allowmenu',29,'system/role/allowmenu'),(17,'1','lgan','2016-09-29 22:38:28','lgan','2016-09-29 22:39:00','分配权限','system:role:allowpermission','分配权限','system:role:allowpermission',29,'system/role/allowpermission'),(18,'1','lgan','2016-09-29 22:40:06',NULL,NULL,'添加权限','system:permission:add','添加权限','system:permission:add',31,'system:permission:add'),(19,'1','lgan','2016-09-29 22:40:25',NULL,NULL,'查看权限','system:permission:view','查看权限','system:permission:view',31,'system:permission:view'),(20,'1','lgan','2016-09-29 22:40:51',NULL,NULL,'删除权限','system:permission:delete','删除权限','system:permission:delete',31,'system:permission:delete'),(21,'1','lgan','2016-09-29 22:41:22',NULL,NULL,'编辑权限','system:permission:edit','编辑权限','system:permission:edit',31,'system:permission:edit'),(22,'1','lgan','2016-09-29 22:42:06',NULL,NULL,'添加菜单','system:menu:add','添加菜单','system:menu:add',30,'system:menu:add'),(23,'1','lgan','2016-09-29 22:42:25',NULL,NULL,'查看菜单','system:menu:view','查看菜单','system:menu:view',30,'system:menu:view'),(24,'1','lgan','2016-09-29 22:42:44',NULL,NULL,'编辑菜单','system:menu:edit','编辑菜单','system:menu:edit',30,'system:menu:edit'),(25,'1','lgan','2016-09-29 22:43:07',NULL,NULL,'删除菜单','system:menu:delete','删除菜单','system:menu:delete',30,'system:menu:delete'),(26,'1','lgan','2016-09-29 22:44:04',NULL,NULL,'添加数据字典','system:ddl:add','添加数据字典','system:ddl:add',32,'system:ddl:add'),(27,'1','lgan','2016-09-29 22:44:22',NULL,NULL,'查看数据字典','system:ddl:view','查看数据字典','system:ddl:view',32,'system:ddl:view'),(28,'1','lgan','2016-09-29 22:44:42',NULL,NULL,'编辑数据字典','system:ddl:edit','编辑数据字典','system:ddl:edit',32,'system:ddl:edit'),(29,'1','lgan','2016-09-29 22:45:08',NULL,NULL,'删除数据字典','system:ddl:delete','删除数据字典','system:ddl:delete',32,'system:ddl:delete'),(30,'1','lgan','2016-09-29 22:45:43',NULL,NULL,'查看日志','system:log:view','查看日志','system:log:view',33,'system:log:view'),(31,'1','lgan','2016-09-29 22:46:13',NULL,NULL,'删除日志','system:log:delete','删除日志','system:log:delete',33,'system:log:delete'),(32,'1','lgan','2016-09-29 22:47:07',NULL,NULL,'添加导出模型','system:export:add','添加导出模型','system:export:add',34,'system:export:add'),(33,'1','lgan','2016-09-29 22:47:31',NULL,NULL,'查看导出模型','system:export:view','查看导出模型','system:export:view',34,'system:export:view'),(34,'1','lgan','2016-09-29 22:47:55',NULL,NULL,'编辑导出模型','system:export:edit','编辑导出模型','system:export:edit',34,'system:export:edit'),(35,'1','lgan','2016-09-29 22:48:13',NULL,NULL,'删除导出模型','system:export:delete','删除导出模型','system:export:delete',34,'system:export:delete'),(36,'1','lgan','2016-09-29 22:48:57',NULL,NULL,'导出EXCEL','system:export:export','导出EXCEL','system:export:export',34,'system:export:export');
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
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
