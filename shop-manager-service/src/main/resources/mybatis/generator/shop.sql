/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2016-09-18 18:00:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_ddl`
-- ----------------------------
DROP TABLE IF EXISTS `sys_ddl`;
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='系统数据字典表';

-- ----------------------------
-- Records of sys_ddl
-- ----------------------------
INSERT INTO `sys_ddl` VALUES ('1', null, null, '2016-09-11 16:03:58', null, null, 'man', 'sex', '性别', '男', '1', '100');
INSERT INTO `sys_ddl` VALUES ('2', '1', 'admin', '2016-09-11 16:12:14', null, null, 'man', 'sex', '性别', '男', '1', '100');
INSERT INTO `sys_ddl` VALUES ('3', '1', 'admin', '2016-09-11 16:17:33', 'admin', '2016-09-11 19:05:16', 'femal', 'sex', '性别', '女', '2', '100');
INSERT INTO `sys_ddl` VALUES ('6', '1', 'admin', '2016-09-11 19:15:40', 'admin', '2016-09-11 19:16:00', '未知性别', 'sex', '性别', '未知', '0', '100');
INSERT INTO `sys_ddl` VALUES ('8', '1', 'admin', '2016-09-11 19:18:26', null, null, '正常', 'public', '公共', 'normal', '1', '90');
INSERT INTO `sys_ddl` VALUES ('9', '1', 'admin', '2016-09-11 19:18:47', null, null, '删除', 'public', '公共', 'delete', '2', '90');
INSERT INTO `sys_ddl` VALUES ('10', '1', 'admin', '2016-09-11 19:20:56', null, null, '黄色图片', 'color', '颜色', '黄色', 'yellow', '80');
INSERT INTO `sys_ddl` VALUES ('11', '1', 'admin', '2016-09-11 19:21:18', 'admin', '2016-09-12 13:04:12', '红色颜色', 'color', '颜色', '红色', 'red', '80');
INSERT INTO `sys_ddl` VALUES ('12', '1', 'admin', '2016-09-11 19:21:46', 'admin', '2016-09-11 19:22:51', '绿色', 'color', '颜色', '绿色', 'green', '80');
INSERT INTO `sys_ddl` VALUES ('14', '1', 'admin', '2016-09-11 19:22:39', null, null, '黑色', 'color', '颜色', '黑色', 'black', '80');
INSERT INTO `sys_ddl` VALUES ('18', '1', 'admin', '2016-09-12 13:17:09', 'admin', '2016-09-12 13:24:57', '白色之恋', 'color', '颜色', '白色', 'black', '70');
INSERT INTO `sys_ddl` VALUES ('19', '1', 'admin', '2016-09-12 13:38:39', null, null, '绝黄色', 'color', '颜色', '橘色', 'orange', '70');
INSERT INTO `sys_ddl` VALUES ('20', '1', 'admin', '2016-09-12 13:43:31', null, null, '银色山庄', 'color', '颜色', '银色', 'silver', '70');
INSERT INTO `sys_ddl` VALUES ('21', '1', 'admin', '2016-09-12 13:50:58', null, null, '蓝色的天空', 'color', '颜色', '蓝色', 'blue', '70');

-- ----------------------------
-- Table structure for `sys_export_field`
-- ----------------------------
DROP TABLE IF EXISTS `sys_export_field`;
CREATE TABLE `sys_export_field` (
  `exp_id` int(11) NOT NULL AUTO_INCREMENT,
  `exp_status` varchar(45) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `editor` varchar(45) DEFAULT NULL COMMENT '修改人.',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间.',
  `remark` varchar(45) DEFAULT NULL COMMENT '描述',
  `module_name` varchar(45) DEFAULT NULL COMMENT '所属模块，如用户管理为：system-user',
  `exp_cnames` varchar(500) DEFAULT NULL COMMENT '导出字段的中文名',
  `no_exp_cnames` varchar(500) DEFAULT NULL COMMENT '未导出字段的中文名',
  `exp_enames` varchar(500) DEFAULT NULL COMMENT '导出字段的英文名',
  `no_exp_enames` varchar(500) DEFAULT NULL COMMENT '未导出字段的英文名',
  PRIMARY KEY (`exp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统导出字段表';

-- ----------------------------
-- Records of sys_export_field
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '1', 'admin', '2016-09-12 16:42:32', null, null, '系统设置', 'system', '系统设置', '', '100', '0', 'glyphicon glyphicon-search', 'show', '1', '0');
INSERT INTO `sys_menu` VALUES ('13', '1', 'admin', '2016-09-13 09:07:34', null, null, '相册管理', 'ablum', '相册管理', '', '100', '0', '', 'show', '1', '0');
INSERT INTO `sys_menu` VALUES ('15', '1', 'admin', '2016-09-13 09:08:48', null, null, '动态日志管理', 'log', '日志管理', '', '100', '0', '', 'show', '1', '0');
INSERT INTO `sys_menu` VALUES ('16', '1', 'admin', '2016-09-13 09:10:12', 'admin', '2016-09-13 10:13:16', '系统设置-菜单管理', 'menu', '菜单管理', '', '100', '0', '', 'show', '2', '1');
INSERT INTO `sys_menu` VALUES ('18', '1', 'admin', '2016-09-13 09:11:01', null, null, '菜单管理', 'menu', '菜单管理', '', '100', '1', '', 'show', '2', '1');
INSERT INTO `sys_menu` VALUES ('19', '1', 'admin', '2016-09-13 09:11:16', null, null, '权限管理', 'permission', '权限管理', '', '100', '1', '', 'show', '2', '1');
INSERT INTO `sys_menu` VALUES ('20', '1', 'admin', '2016-09-13 09:11:31', null, null, '数据字典', 'ddl', '数据字典', '', '100', '1', '', 'show', '2', '1');
INSERT INTO `sys_menu` VALUES ('21', '1', 'admin', '2016-09-13 09:11:47', null, null, '日志管理', 'log', '日志管理', '', '100', '1', '', 'show', '2', '1');
INSERT INTO `sys_menu` VALUES ('22', '1', 'admin', '2016-09-13 09:12:06', null, null, '导出设置', 'export', '导出设置', '', '100', '1', '', 'show', '2', '1');
INSERT INTO `sys_menu` VALUES ('23', '1', 'admin', '2016-09-13 09:14:40', null, null, '系统设置-菜单管理', 'user', '用户管理', '', '100', '1', '', 'show', '2', '1');
INSERT INTO `sys_menu` VALUES ('24', '1', 'admin', '2016-09-13 10:09:31', null, null, '系统设置-菜单管理', 'menu', '菜单管理', '', '100', '1', '', 'show', '2', '1');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '1', 'admin', '2016-09-13 09:14:14', null, null, '', 'view', '查看', 'system:menu:view', '16', 'system/menu/view');
INSERT INTO `sys_permission` VALUES ('2', '1', 'admin', '2016-09-13 09:16:18', null, null, '菜单编辑', 'edit', '编辑', 'system:menu:edit', '16', 'system/menu/edit');
INSERT INTO `sys_permission` VALUES ('3', '1', 'admin', '2016-09-13 09:16:54', null, null, '菜单删除', 'delete', '删除', 'system:menu:delete', '16', 'system/menu/delete');
INSERT INTO `sys_permission` VALUES ('4', '1', 'admin', '2016-09-13 09:17:35', 'admin', '2016-09-14 12:44:53', '菜单添加', 'add', '添加', 'system:menu:add', '16', 'system/menu/add');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_status` varchar(10) DEFAULT NULL COMMENT ' 状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT ' 创建时间',
  `editor` varchar(45) DEFAULT NULL COMMENT '修改人.',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间.',
  `remark` varchar(45) DEFAULT NULL COMMENT '描述',
  `role_code` varchar(45) DEFAULT NULL COMMENT ' 角色编码：例如：admin',
  `role_name` varchar(45) DEFAULT NULL COMMENT ' 角色名称',
  `role_type` varchar(45) DEFAULT NULL COMMENT '角色类型任务分配：assignment、管理角色：security-role、普通角色：user',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('11', '1', 'admin', '2016-09-18 15:48:04', 'admin', '2016-09-18 15:48:04', '管理、分配系统权限角色', 'system', '系统管理员', 'ADMIN');
INSERT INTO `sys_role` VALUES ('13', '1', 'admin', '2016-09-18 15:48:12', 'admin', '2016-09-18 15:48:12', '相册管理员', 'album', '相册管理管理员', 'ADMIN');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_menu_status` varchar(45) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='系统角色菜单表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('16', '1', 'admin', '2016-09-14 09:48:56', '11', '1');
INSERT INTO `sys_role_menu` VALUES ('18', '1', 'admin', '2016-09-14 09:48:56', '11', '15');
INSERT INTO `sys_role_menu` VALUES ('19', '1', 'admin', '2016-09-14 10:48:15', '6', '1');
INSERT INTO `sys_role_menu` VALUES ('20', '1', 'admin', '2016-09-14 10:48:15', '6', '16');
INSERT INTO `sys_role_menu` VALUES ('22', '1', 'admin', '2016-09-14 10:48:15', '6', '18');
INSERT INTO `sys_role_menu` VALUES ('23', '1', 'admin', '2016-09-14 10:48:15', '6', '19');
INSERT INTO `sys_role_menu` VALUES ('24', '1', 'admin', '2016-09-14 10:48:15', '6', '20');
INSERT INTO `sys_role_menu` VALUES ('25', '1', 'admin', '2016-09-14 10:48:15', '6', '21');
INSERT INTO `sys_role_menu` VALUES ('26', '1', 'admin', '2016-09-14 10:48:15', '6', '22');
INSERT INTO `sys_role_menu` VALUES ('27', '1', 'admin', '2016-09-14 10:48:15', '6', '23');
INSERT INTO `sys_role_menu` VALUES ('28', '1', 'admin', '2016-09-14 10:48:15', '6', '24');
INSERT INTO `sys_role_menu` VALUES ('31', '1', 'admin', '2016-09-14 10:48:15', '6', '13');
INSERT INTO `sys_role_menu` VALUES ('32', '1', 'admin', '2016-09-14 10:48:15', '6', '15');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_permission_status` varchar(45) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='系统角色权限表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', 'admin', '2016-09-14 10:49:41', '6', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1', 'admin', '2016-09-14 10:49:41', '6', '16');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', 'admin', '2016-09-18 10:50:10', null, null, 'lovecws', 'lgan', 'c11868852c15f3d74d1ce8c247139096', 'd71b61ea0bcaa1bee9d640aca7370ff6', null, '甘大亮', 'admin', '915827225@qq.com', null, '17730831521', null, 'group1/M00/00/01/wKgQgVfeAM2AXK1AAAP_SZsMbmc710.jpg', null, '2016-09-07 00:00:00', null, '河南省', '信阳市', '罗山县');

-- ----------------------------
-- Table structure for `sys_user_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_log`;
CREATE TABLE `sys_user_log` (
  `user_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_log_status` varchar(45) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `editor` varchar(45) DEFAULT NULL COMMENT '修改人.',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间.',
  `remark` varchar(45) DEFAULT NULL COMMENT '描述',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `operate_type` varchar(10) DEFAULT NULL COMMENT '操作类型（参与枚举:OperatorLogTypeEnum,1:增加,2:修改,3:删除,4:查询,5:登录）',
  `ip` varchar(20) DEFAULT NULL COMMENT 'IP地址',
  `content` varchar(500) DEFAULT NULL COMMENT '操作内容',
  `method` varchar(100) DEFAULT NULL,
  `parameter` varchar(100) DEFAULT NULL,
  `result` varchar(2000) DEFAULT NULL,
  `usetime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of sys_user_log
-- ----------------------------
INSERT INTO `sys_user_log` VALUES ('1', '1', 'lgan', '2016-09-18 17:24:26', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '13ms');
INSERT INTO `sys_user_log` VALUES ('2', '1', 'lgan', '2016-09-18 17:24:26', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('3', '1', 'lgan', '2016-09-18 17:24:26', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('4', '1', 'lgan', '2016-09-18 17:24:26', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('5', '1', 'lgan', '2016-09-18 17:25:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@15259a8d', 'null', '12ms');
INSERT INTO `sys_user_log` VALUES ('6', '1', 'lgan', '2016-09-18 17:25:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@48b25681', 'null', '0ms');
INSERT INTO `sys_user_log` VALUES ('7', '1', 'lgan', '2016-09-18 17:25:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@59064460', 'null', '0ms');
INSERT INTO `sys_user_log` VALUES ('8', '1', 'lgan', '2016-09-18 17:25:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@27de4bb6', 'null', '1ms');
INSERT INTO `sys_user_log` VALUES ('9', '1', 'lgan', '2016-09-18 17:25:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@4405c869', 'null', '1ms');
INSERT INTO `sys_user_log` VALUES ('10', '1', 'lgan', '2016-09-18 17:25:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@6e32a3f3', '\"system/user/list\"', '18ms');
INSERT INTO `sys_user_log` VALUES ('11', '1', 'lgan', '2016-09-18 17:25:32', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.role.RoleController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@7dd5f653', '\"system/role/list\"', '27ms');
INSERT INTO `sys_user_log` VALUES ('12', '1', 'lgan', '2016-09-18 17:25:33', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.menu.MenuController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@664af301', '\"system/menu/list\"', '61ms');
INSERT INTO `sys_user_log` VALUES ('13', '1', 'lgan', '2016-09-18 17:25:33', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.permission.PermissionController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@75c36c1e', '\"system/permission/list\"', '24ms');
INSERT INTO `sys_user_log` VALUES ('14', '1', 'lgan', '2016-09-18 17:25:34', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.ddl.DDLController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@5c593e16', '\"system/ddl/list\"', '38ms');
INSERT INTO `sys_user_log` VALUES ('15', '1', 'lgan', '2016-09-18 17:25:34', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '', '\"system/log/list\"', '4ms');
INSERT INTO `sys_user_log` VALUES ('16', '1', 'lgan', '2016-09-18 17:25:35', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.export.ExportSettingController list', '', '\"system/export/list\"', '10ms');
INSERT INTO `sys_user_log` VALUES ('17', '1', 'lgan', '2016-09-18 17:25:35', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.ddl.DDLController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@36165f2c', '\"system/ddl/list\"', '16ms');
INSERT INTO `sys_user_log` VALUES ('18', '1', 'lgan', '2016-09-18 17:25:36', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.menu.MenuController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@278c90d7', '\"system/menu/list\"', '12ms');
INSERT INTO `sys_user_log` VALUES ('19', '1', 'lgan', '2016-09-18 17:25:37', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.menu.MenuController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@44d7b53', '\"system/menu/list\"', '9ms');
INSERT INTO `sys_user_log` VALUES ('20', '1', 'lgan', '2016-09-18 17:25:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.menu.MenuController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@571eb296', '\"system/menu/list\"', '11ms');
INSERT INTO `sys_user_log` VALUES ('21', '1', 'lgan', '2016-09-18 17:25:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.menu.MenuController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@374991dc', '\"system/menu/list\"', '10ms');
INSERT INTO `sys_user_log` VALUES ('22', '1', 'lgan', '2016-09-18 17:26:02', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '', '\"system/log/list\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('23', '1', 'lgan', '2016-09-18 17:26:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '', '\"system/log/list\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('24', '1', 'lgan', '2016-09-18 17:26:58', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('25', '1', 'lgan', '2016-09-18 17:26:58', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('26', '1', 'lgan', '2016-09-18 17:26:58', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('27', '1', 'lgan', '2016-09-18 17:26:58', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('28', '1', 'lgan', '2016-09-18 17:26:59', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '', '\"system/log/list\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('29', '1', 'lgan', '2016-09-18 17:27:13', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '', '\"system/log/list\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('30', '1', 'lgan', '2016-09-18 17:27:13', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '', '\"system/log/list\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('31', '1', 'lgan', '2016-09-18 17:27:14', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '', '\"system/log/list\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('32', '1', 'lgan', '2016-09-18 17:27:15', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '', '\"system/log/list\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('33', '1', 'lgan', '2016-09-18 17:45:18', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '11ms');
INSERT INTO `sys_user_log` VALUES ('34', '1', 'lgan', '2016-09-18 17:45:18', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('35', '1', 'lgan', '2016-09-18 17:45:18', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('36', '1', 'lgan', '2016-09-18 17:45:18', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('37', '1', 'lgan', '2016-09-18 17:45:21', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@7de93d36', '\"system/log/list\"', '157ms');
INSERT INTO `sys_user_log` VALUES ('38', '1', 'lgan', '2016-09-18 17:45:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('39', '1', 'lgan', '2016-09-18 17:45:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('40', '1', 'lgan', '2016-09-18 17:45:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('41', '1', 'lgan', '2016-09-18 17:45:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('42', '1', 'lgan', '2016-09-18 17:45:39', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@41fbead5', '\"system/log/list\"', '12ms');
INSERT INTO `sys_user_log` VALUES ('43', '1', 'lgan', '2016-09-18 17:45:50', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('44', '1', 'lgan', '2016-09-18 17:45:50', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('45', '1', 'lgan', '2016-09-18 17:45:50', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('46', '1', 'lgan', '2016-09-18 17:45:50', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('47', '1', 'lgan', '2016-09-18 17:45:51', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@50b18f30', '\"system/log/list\"', '7ms');
INSERT INTO `sys_user_log` VALUES ('48', '1', 'lgan', '2016-09-18 17:46:19', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('49', '1', 'lgan', '2016-09-18 17:46:19', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('50', '1', 'lgan', '2016-09-18 17:46:19', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('51', '1', 'lgan', '2016-09-18 17:46:19', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('52', '1', 'lgan', '2016-09-18 17:46:20', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@4f4ed8b7', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('53', '1', 'lgan', '2016-09-18 17:46:30', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@4037996e', '\"system/log/list\"', '39ms');
INSERT INTO `sys_user_log` VALUES ('54', '1', 'lgan', '2016-09-18 17:46:32', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@626854e1', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('55', '1', 'lgan', '2016-09-18 17:46:39', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.permission.PermissionController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@650ea5a7', '\"system/permission/list\"', '34ms');
INSERT INTO `sys_user_log` VALUES ('56', '1', 'lgan', '2016-09-18 17:46:43', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@4c92b91f', 'null', '15ms');
INSERT INTO `sys_user_log` VALUES ('57', '1', 'lgan', '2016-09-18 17:46:43', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@67f0b10a', 'null', '0ms');
INSERT INTO `sys_user_log` VALUES ('58', '1', 'lgan', '2016-09-18 17:46:43', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@6a934691', 'null', '1ms');
INSERT INTO `sys_user_log` VALUES ('59', '1', 'lgan', '2016-09-18 17:46:43', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@5c2941cb', 'null', '6ms');
INSERT INTO `sys_user_log` VALUES ('60', '1', 'lgan', '2016-09-18 17:46:43', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@8262559', 'null', '1ms');
INSERT INTO `sys_user_log` VALUES ('61', '1', 'lgan', '2016-09-18 17:46:43', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@2a357f0f', '\"system/user/list\"', '11ms');
INSERT INTO `sys_user_log` VALUES ('62', '1', 'lgan', '2016-09-18 17:46:44', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@1c1516c8', 'null', '0ms');
INSERT INTO `sys_user_log` VALUES ('63', '1', 'lgan', '2016-09-18 17:46:44', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@222cfd59', 'null', '0ms');
INSERT INTO `sys_user_log` VALUES ('64', '1', 'lgan', '2016-09-18 17:46:44', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@56dbbb90', 'null', '0ms');
INSERT INTO `sys_user_log` VALUES ('65', '1', 'lgan', '2016-09-18 17:46:45', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@13af4c7a', 'null', '0ms');
INSERT INTO `sys_user_log` VALUES ('66', '1', 'lgan', '2016-09-18 17:46:45', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController initBinder', 'org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder@2ac13d5a', 'null', '0ms');
INSERT INTO `sys_user_log` VALUES ('67', '1', 'lgan', '2016-09-18 17:46:45', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.user.UserController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@106c0532', '\"system/user/list\"', '4ms');
INSERT INTO `sys_user_log` VALUES ('68', '1', 'lgan', '2016-09-18 17:47:03', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('69', '1', 'lgan', '2016-09-18 17:47:03', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('70', '1', 'lgan', '2016-09-18 17:47:03', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('71', '1', 'lgan', '2016-09-18 17:47:03', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('72', '1', 'lgan', '2016-09-18 17:47:05', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@1d2b941e', '\"system/log/list\"', '12ms');
INSERT INTO `sys_user_log` VALUES ('73', '1', 'lgan', '2016-09-18 17:47:10', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@474424cf', '\"system/log/list\"', '11ms');
INSERT INTO `sys_user_log` VALUES ('74', '1', 'lgan', '2016-09-18 17:47:12', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@48167e8d', '\"system/log/list\"', '12ms');
INSERT INTO `sys_user_log` VALUES ('75', '1', 'lgan', '2016-09-18 17:47:58', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@36557fee', '\"system/log/list\"', '24714ms');
INSERT INTO `sys_user_log` VALUES ('76', '1', 'lgan', '2016-09-18 17:49:44', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('77', '1', 'lgan', '2016-09-18 17:49:44', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('78', '1', 'lgan', '2016-09-18 17:49:44', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('79', '1', 'lgan', '2016-09-18 17:49:44', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('80', '1', 'lgan', '2016-09-18 17:49:46', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@721163f2', '\"system/log/list\"', '21ms');
INSERT INTO `sys_user_log` VALUES ('81', '1', 'lgan', '2016-09-18 17:49:48', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@15f4fb87', '\"system/log/list\"', '42ms');
INSERT INTO `sys_user_log` VALUES ('82', '1', 'lgan', '2016-09-18 17:49:55', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.ddl.DDLController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@67f09860', '\"system/ddl/list\"', '30ms');
INSERT INTO `sys_user_log` VALUES ('83', '1', 'lgan', '2016-09-18 17:49:57', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.ddl.DDLController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@2d39f2f8', '\"system/ddl/list\"', '6ms');
INSERT INTO `sys_user_log` VALUES ('84', '1', 'lgan', '2016-09-18 17:49:59', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@4f0cb5a6', '\"system/log/list\"', '15ms');
INSERT INTO `sys_user_log` VALUES ('85', '1', 'lgan', '2016-09-18 17:50:00', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@35302713', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('86', '1', 'lgan', '2016-09-18 17:50:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@6a38774b', '\"system/log/list\"', '9ms');
INSERT INTO `sys_user_log` VALUES ('87', '1', 'lgan', '2016-09-18 17:50:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@369f427d', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('88', '1', 'lgan', '2016-09-18 17:50:24', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('89', '1', 'lgan', '2016-09-18 17:50:24', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('90', '1', 'lgan', '2016-09-18 17:50:24', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('91', '1', 'lgan', '2016-09-18 17:50:24', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('92', '1', 'lgan', '2016-09-18 17:50:25', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@5e4e2be3', '\"system/log/list\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('93', '1', 'lgan', '2016-09-18 17:50:27', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@29065c17', '\"system/log/list\"', '9ms');
INSERT INTO `sys_user_log` VALUES ('94', '1', 'lgan', '2016-09-18 17:50:42', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('95', '1', 'lgan', '2016-09-18 17:50:42', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('96', '1', 'lgan', '2016-09-18 17:50:42', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('97', '1', 'lgan', '2016-09-18 17:50:42', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('98', '1', 'lgan', '2016-09-18 17:50:43', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@7d21672f', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('99', '1', 'lgan', '2016-09-18 17:50:46', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.ddl.DDLController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@489a632f', '\"system/ddl/list\"', '13ms');
INSERT INTO `sys_user_log` VALUES ('100', '1', 'lgan', '2016-09-18 17:50:47', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@126fa2', '\"system/log/list\"', '11ms');
INSERT INTO `sys_user_log` VALUES ('101', '1', 'lgan', '2016-09-18 17:50:50', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@7c17342e', '\"system/log/list\"', '12ms');
INSERT INTO `sys_user_log` VALUES ('102', '1', 'lgan', '2016-09-18 17:51:10', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('103', '1', 'lgan', '2016-09-18 17:51:10', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('104', '1', 'lgan', '2016-09-18 17:51:10', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('105', '1', 'lgan', '2016-09-18 17:51:10', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('106', '1', 'lgan', '2016-09-18 17:51:11', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@7a7e1f7e', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('107', '1', 'lgan', '2016-09-18 17:51:12', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@1eafb38b', '\"system/log/list\"', '10ms');
INSERT INTO `sys_user_log` VALUES ('108', '1', 'lgan', '2016-09-18 17:51:12', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@35b8e82b', '\"system/log/list\"', '16ms');
INSERT INTO `sys_user_log` VALUES ('109', '1', 'lgan', '2016-09-18 17:51:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('110', '1', 'lgan', '2016-09-18 17:51:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('111', '1', 'lgan', '2016-09-18 17:51:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('112', '1', 'lgan', '2016-09-18 17:51:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('113', '1', 'lgan', '2016-09-18 17:51:39', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@6d90d3ac', '\"system/log/list\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('114', '1', 'lgan', '2016-09-18 17:51:40', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('115', '1', 'lgan', '2016-09-18 17:51:40', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('116', '1', 'lgan', '2016-09-18 17:51:40', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('117', '1', 'lgan', '2016-09-18 17:51:40', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('118', '1', 'lgan', '2016-09-18 17:51:41', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@14d4d634', '\"system/log/list\"', '7ms');
INSERT INTO `sys_user_log` VALUES ('119', '1', 'lgan', '2016-09-18 17:51:52', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('120', '1', 'lgan', '2016-09-18 17:51:52', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('121', '1', 'lgan', '2016-09-18 17:51:52', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('122', '1', 'lgan', '2016-09-18 17:51:52', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('123', '1', 'lgan', '2016-09-18 17:51:52', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@5c90dda0', '\"system/log/list\"', '6ms');
INSERT INTO `sys_user_log` VALUES ('124', '1', 'lgan', '2016-09-18 17:51:56', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '7org.apache.shiro.web.servlet.ShiroHttpServletRequest@7c4d8f7d', '\"system/log/list\"', '14ms');
INSERT INTO `sys_user_log` VALUES ('125', '1', 'lgan', '2016-09-18 17:53:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('126', '1', 'lgan', '2016-09-18 17:53:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('127', '1', 'lgan', '2016-09-18 17:53:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('128', '1', 'lgan', '2016-09-18 17:53:38', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('129', '1', 'lgan', '2016-09-18 17:53:39', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@7493c2fb', '\"system/log/list\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('130', '1', 'lgan', '2016-09-18 17:53:43', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '3org.apache.shiro.web.servlet.ShiroHttpServletRequest@40594f53', '\"system/log/list\"', '9ms');
INSERT INTO `sys_user_log` VALUES ('131', '1', 'lgan', '2016-09-18 17:54:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('132', '1', 'lgan', '2016-09-18 17:54:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('133', '1', 'lgan', '2016-09-18 17:54:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('134', '1', 'lgan', '2016-09-18 17:54:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('135', '1', 'lgan', '2016-09-18 17:54:23', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@539309c6', '\"system/log/list\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('136', '1', 'lgan', '2016-09-18 17:54:25', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@2d7eaeaf', '\"system/log/list\"', '6ms');
INSERT INTO `sys_user_log` VALUES ('137', '1', 'lgan', '2016-09-18 17:54:47', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('138', '1', 'lgan', '2016-09-18 17:54:48', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('139', '1', 'lgan', '2016-09-18 17:54:48', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('140', '1', 'lgan', '2016-09-18 17:54:48', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('141', '1', 'lgan', '2016-09-18 17:54:49', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@57d59c7c', '\"system/log/list\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('142', '1', 'lgan', '2016-09-18 17:54:50', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@5413d65c', '\"system/log/list\"', '6ms');
INSERT INTO `sys_user_log` VALUES ('143', '1', 'lgan', '2016-09-18 17:54:57', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('144', '1', 'lgan', '2016-09-18 17:54:57', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('145', '1', 'lgan', '2016-09-18 17:54:57', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('146', '1', 'lgan', '2016-09-18 17:54:57', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('147', '1', 'lgan', '2016-09-18 17:54:58', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@510f0f3c', '\"system/log/list\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('148', '1', 'lgan', '2016-09-18 17:54:59', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '3org.apache.shiro.web.servlet.ShiroHttpServletRequest@262e5e21', '\"system/log/list\"', '6ms');
INSERT INTO `sys_user_log` VALUES ('149', '1', 'lgan', '2016-09-18 17:55:21', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('150', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('151', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('152', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('153', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('154', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('155', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('156', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('157', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('158', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('159', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('160', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('161', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('162', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('163', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('164', '1', 'lgan', '2016-09-18 17:55:22', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('165', '1', 'lgan', '2016-09-18 17:55:23', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@20e32e92', '\"system/log/list\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('166', '1', 'lgan', '2016-09-18 17:55:25', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@73cd1988', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('167', '1', 'lgan', '2016-09-18 17:56:51', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('168', '1', 'lgan', '2016-09-18 17:56:51', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('169', '1', 'lgan', '2016-09-18 17:56:51', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('170', '1', 'lgan', '2016-09-18 17:56:51', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('171', '1', 'lgan', '2016-09-18 17:56:52', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@5db88734', '\"system/log/list\"', '4ms');
INSERT INTO `sys_user_log` VALUES ('172', '1', 'lgan', '2016-09-18 17:56:54', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@1c24591f', '\"system/log/list\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('173', '1', 'lgan', '2016-09-18 17:57:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('174', '1', 'lgan', '2016-09-18 17:57:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('175', '1', 'lgan', '2016-09-18 17:57:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('176', '1', 'lgan', '2016-09-18 17:57:31', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('177', '1', 'lgan', '2016-09-18 17:57:32', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@6237fdca', '\"system/log/list\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('178', '1', 'lgan', '2016-09-18 17:57:45', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@28f9067c', '\"system/log/list\"', '6ms');
INSERT INTO `sys_user_log` VALUES ('179', '1', 'lgan', '2016-09-18 17:58:53', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController main', '', '\"system/layout/main\"', '5ms');
INSERT INTO `sys_user_log` VALUES ('180', '1', 'lgan', '2016-09-18 17:58:53', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController header', '', '\"system/layout/header\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('181', '1', 'lgan', '2016-09-18 17:58:53', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController menu', '', '\"system/layout/menu\"', '1ms');
INSERT INTO `sys_user_log` VALUES ('182', '1', 'lgan', '2016-09-18 17:58:53', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.layout.LayoutController footer', '', '\"system/layout/footer\"', '0ms');
INSERT INTO `sys_user_log` VALUES ('183', '1', 'lgan', '2016-09-18 17:58:55', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@362dc0e1', '\"system/log/list\"', '32ms');
INSERT INTO `sys_user_log` VALUES ('184', '1', 'lgan', '2016-09-18 17:59:06', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@a314f3f', '\"system/log/list\"', '9ms');
INSERT INTO `sys_user_log` VALUES ('185', '1', 'lgan', '2016-09-18 17:59:06', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@153f6dec', '\"system/log/list\"', '7ms');
INSERT INTO `sys_user_log` VALUES ('186', '1', 'lgan', '2016-09-18 17:59:08', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '2org.apache.shiro.web.servlet.ShiroHttpServletRequest@78c88a9', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('187', '1', 'lgan', '2016-09-18 17:59:11', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '3org.apache.shiro.web.servlet.ShiroHttpServletRequest@9111396', '\"system/log/list\"', '7ms');
INSERT INTO `sys_user_log` VALUES ('188', '1', 'lgan', '2016-09-18 17:59:13', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '4org.apache.shiro.web.servlet.ShiroHttpServletRequest@e4fa30', '\"system/log/list\"', '9ms');
INSERT INTO `sys_user_log` VALUES ('189', '1', 'lgan', '2016-09-18 17:59:15', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '5org.apache.shiro.web.servlet.ShiroHttpServletRequest@201c99a8', '\"system/log/list\"', '9ms');
INSERT INTO `sys_user_log` VALUES ('190', '1', 'lgan', '2016-09-18 17:59:33', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '6org.apache.shiro.web.servlet.ShiroHttpServletRequest@1792cf53', '\"system/log/list\"', '10ms');
INSERT INTO `sys_user_log` VALUES ('191', '1', 'lgan', '2016-09-18 17:59:35', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '10org.apache.shiro.web.servlet.ShiroHttpServletRequest@6da99cd9', '\"system/log/list\"', '16ms');
INSERT INTO `sys_user_log` VALUES ('192', '1', 'lgan', '2016-09-18 17:59:41', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '11org.apache.shiro.web.servlet.ShiroHttpServletRequest@5fb3baa1', '\"system/log/list\"', '13ms');
INSERT INTO `sys_user_log` VALUES ('193', '1', 'lgan', '2016-09-18 17:59:43', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '16org.apache.shiro.web.servlet.ShiroHttpServletRequest@31f5b58e', '\"system/log/list\"', '26ms');
INSERT INTO `sys_user_log` VALUES ('194', '1', 'lgan', '2016-09-18 17:59:53', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '20org.apache.shiro.web.servlet.ShiroHttpServletRequest@228a4d64', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('195', '1', 'lgan', '2016-09-18 18:00:04', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@5dbc9d1e', '\"system/log/list\"', '7ms');
INSERT INTO `sys_user_log` VALUES ('196', '1', 'lgan', '2016-09-18 18:00:08', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '10org.apache.shiro.web.servlet.ShiroHttpServletRequest@6599187b', '\"system/log/list\"', '6ms');
INSERT INTO `sys_user_log` VALUES ('197', '1', 'lgan', '2016-09-18 18:00:10', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '15org.apache.shiro.web.servlet.ShiroHttpServletRequest@4255cd05', '\"system/log/list\"', '8ms');
INSERT INTO `sys_user_log` VALUES ('198', '1', 'lgan', '2016-09-18 18:00:12', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '16org.apache.shiro.web.servlet.ShiroHttpServletRequest@1102c8b9', '\"system/log/list\"', '9ms');
INSERT INTO `sys_user_log` VALUES ('199', '1', 'lgan', '2016-09-18 18:00:13', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '17org.apache.shiro.web.servlet.ShiroHttpServletRequest@623c8dc', '\"system/log/list\"', '7ms');
INSERT INTO `sys_user_log` VALUES ('200', '1', 'lgan', '2016-09-18 18:00:14', null, null, null, '1', 'lgan', null, '0:0:0:0:0:0:0:1', null, 'com.lovecws.shop.controller.system.log.LogController list', '20org.apache.shiro.web.servlet.ShiroHttpServletRequest@4b6d1037', '\"system/log/list\"', '9ms');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role_status` varchar(45) DEFAULT NULL COMMENT '状态 PublicStatusEnum',
  `creator` varchar(45) DEFAULT NULL COMMENT '创建人.',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间.',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='系统用户角色中间表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('9', '1', 'admin', '2016-09-18 15:48:27', '11', '1');
