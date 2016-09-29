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
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_status` varchar(10) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `editor` varchar(45) DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间.',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  `user_name` varchar(45) DEFAULT NULL COMMENT '登录名',
  `password` varchar(45) DEFAULT NULL COMMENT '登录密码',
  `salt` varchar(45) DEFAULT NULL COMMENT '盐',
  `real_name` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `nick_name` varchar(45) DEFAULT NULL COMMENT '昵称',
  `type` varchar(10) DEFAULT NULL COMMENT '用户类型（admin:超级管理员，common:普通操作员），超级管理员由系统初始化时添加，不能删除)',
  `email` varchar(45) DEFAULT NULL COMMENT '邮件号码',
  `email_active` varchar(10) DEFAULT NULL COMMENT '激活yes；未激活no',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `phone_active` varchar(10) DEFAULT NULL COMMENT '激活yes；未激活no',
  `avator` varchar(100) DEFAULT NULL COMMENT '头像地址（缩略图',
  `sex` varchar(10) DEFAULT NULL COMMENT 'unknow未知；male 男；female 女',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `detail_area` varchar(200) DEFAULT NULL COMMENT '用户详细地址',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `area` varchar(20) DEFAULT NULL COMMENT '区',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `userName_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'1','admin','2016-09-18 10:50:10',NULL,NULL,'lovecws','lgan','c11868852c15f3d74d1ce8c247139096','d71b61ea0bcaa1bee9d640aca7370ff6',NULL,'甘大亮','admin','915827225@qq.com',NULL,'17730831521',NULL,'group1/M00/00/01/wKgQgVfeAM2AXK1AAAP_SZsMbmc710.jpg',NULL,'2016-09-07 00:00:00',NULL,'河南省','信阳市','罗山县'),(2,'1','lgan','2016-09-29 21:56:42',NULL,NULL,'我爱你，卫生','admin','c1f02e8d37e9f34711aaf11e3d6c01ef','395ab38e75af10fa5ebef7a339e29fb6',NULL,'管理员','admin','lovercws@gmail.com',NULL,'17730831521',NULL,'',NULL,'2016-09-08 00:00:00',NULL,'河南省','信阳市','罗山县');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
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
