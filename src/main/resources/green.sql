/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : green

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-23 13:13:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `alembic_version`
-- ----------------------------
DROP TABLE IF EXISTS `alembic_version`;
CREATE TABLE `alembic_version` (
  `version_num` varchar(32) NOT NULL,
  PRIMARY KEY (`version_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alembic_version
-- ----------------------------

-- ----------------------------
-- Table structure for `author`
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rose` int(11) DEFAULT NULL,
  `project` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `project` (`project`),
  KEY `rose` (`rose`),
  CONSTRAINT `author_ibfk_2` FOREIGN KEY (`project`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `author_ibfk_3` FOREIGN KEY (`rose`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `user_id` int(11) DEFAULT NULL,
  `auth_id` int(11) DEFAULT NULL,
  KEY `auth_user_ibfk_1` (`user_id`),
  KEY `auth_id` (`auth_id`),
  CONSTRAINT `auth_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `auth_user_ibfk_2` FOREIGN KEY (`auth_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user
-- ----------------------------

-- ----------------------------
-- Table structure for `depend`
-- ----------------------------
DROP TABLE IF EXISTS `depend`;
CREATE TABLE `depend` (
  `case_id` int(11) NOT NULL AUTO_INCREMENT,
  `suite_id` int(11) DEFAULT NULL,
  `attred` varchar(64) DEFAULT NULL,
  KEY `case_id` (`case_id`),
  CONSTRAINT `depend_ibfk_1` FOREIGN KEY (`case_id`) REFERENCES `test_interface` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depend
-- ----------------------------

-- ----------------------------
-- Table structure for `email_reports`
-- ----------------------------
DROP TABLE IF EXISTS `email_reports`;
CREATE TABLE `email_reports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email_re_user_id` int(11) DEFAULT NULL COMMENT '设置发件人',
  `send_email` varchar(64) DEFAULT NULL COMMENT '发件箱地址',
  `send_email_password` varchar(64) DEFAULT NULL COMMENT '发件箱密码',
  `to_email` varchar(64) DEFAULT NULL COMMENT '收件人',
  `default_set` tinyint(1) DEFAULT '0' COMMENT '默认',
  `port` int(11) DEFAULT NULL COMMENT '端口号',
  `stmp_email` varchar(64) DEFAULT NULL COMMENT 'smtp服务器',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `email_re_user_id` (`email_re_user_id`),
  CONSTRAINT `email_reports_ibfk_1` FOREIGN KEY (`email_re_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email_reports
-- ----------------------------

-- ----------------------------
-- Table structure for `interfaces`
-- ----------------------------
DROP TABLE IF EXISTS `interfaces`;
CREATE TABLE `interfaces` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_id` int(11) DEFAULT NULL,
  `projects_id` int(11) DEFAULT NULL,
  `Interface_name` varchar(252) DEFAULT NULL,
  `Interface_url` varchar(252) DEFAULT NULL,
  `Interface_meth` varchar(252) NOT NULL DEFAULT 'GET',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `Interface_headers` varchar(252) DEFAULT NULL,
  `interface_type` varchar(32) NOT NULL DEFAULT 'http',
  PRIMARY KEY (`id`),
  KEY `projects_id` (`projects_id`),
  KEY `model_id` (`model_id`),
  CONSTRAINT `interfaces_ibfk_4` FOREIGN KEY (`projects_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `interfaces_ibfk_5` FOREIGN KEY (`model_id`) REFERENCES `models` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of interfaces
-- ----------------------------
INSERT INTO `interfaces` VALUES ('1', '1', '1', '获取外网列表', '/restapi/network/external/', 'GET', '0', null, 'https');

-- ----------------------------
-- Table structure for `mock_server`
-- ----------------------------
DROP TABLE IF EXISTS `mock_server`;
CREATE TABLE `mock_server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `make_uers` int(11) DEFAULT NULL COMMENT '创建用户',
  `name` varchar(55) DEFAULT NULL COMMENT '名称',
  `path` varchar(252) DEFAULT NULL COMMENT '路径',
  `methods` varchar(50) DEFAULT NULL COMMENT '方法',
  `headers` varchar(500) DEFAULT NULL COMMENT '请求头',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `return_para` varchar(500) DEFAULT NULL COMMENT '返回数据',
  `params` varchar(500) DEFAULT NULL COMMENT '参数',
  `rebacktype` varchar(32) DEFAULT NULL COMMENT '类型',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态是否开启',
  `delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `is_check` tinyint(1) DEFAULT '0' COMMENT '是否校验参数',
  `is_headers` tinyint(1) DEFAULT '0' COMMENT '是否检验header',
  PRIMARY KEY (`id`),
  KEY `make_uers` (`make_uers`) USING BTREE,
  CONSTRAINT `mock_server_ibfk_1` FOREIGN KEY (`make_uers`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mock_server
-- ----------------------------

-- ----------------------------
-- Table structure for `models`
-- ----------------------------
DROP TABLE IF EXISTS `models`;
CREATE TABLE `models` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_name` varchar(256) DEFAULT NULL,
  `model_project_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `model_project_id` (`model_project_id`),
  CONSTRAINT `models_ibfk_1` FOREIGN KEY (`model_project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of models
-- ----------------------------
INSERT INTO `models` VALUES ('1', '网络', '1', '1');

-- ----------------------------
-- Table structure for `parames`
-- ----------------------------
DROP TABLE IF EXISTS `parames`;
CREATE TABLE `parames` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interface_id` int(11) DEFAULT NULL COMMENT '接口id',
  `parameter_type` varchar(64) DEFAULT NULL COMMENT '参数类型',
  `parameter_name` varchar(64) DEFAULT NULL COMMENT '参数名称',
  `necessary` tinyint(1) DEFAULT '0' COMMENT '是否必传',
  `type` int(11) DEFAULT '0' COMMENT '类型，返回还是传参，入参为0，出参为1',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  `demo` varchar(63) DEFAULT NULL COMMENT '示例',
  `desc` varchar(252) DEFAULT NULL COMMENT '参数描述',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `interface_id` (`interface_id`),
  CONSTRAINT `parames_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `parames_ibfk_2` FOREIGN KEY (`interface_id`) REFERENCES `interfaces` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parames
-- ----------------------------

-- ----------------------------
-- Table structure for `projects`
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_user_id` int(11) DEFAULT NULL,
  `project_name` varchar(252) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_name` (`project_name`) USING BTREE,
  KEY `project_user_id` (`project_user_id`),
  CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`project_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projects
-- ----------------------------
INSERT INTO `projects` VALUES ('1', '2', 'NeoCU', '0');

-- ----------------------------
-- Table structure for `registrations`
-- ----------------------------
DROP TABLE IF EXISTS `registrations`;
CREATE TABLE `registrations` (
  `task_id` int(11) DEFAULT NULL,
  `test_interface_id` int(11) DEFAULT NULL,
  KEY `test_interface_id` (`test_interface_id`),
  KEY `task_id` (`task_id`),
  CONSTRAINT `registrations_ibfk_2` FOREIGN KEY (`test_interface_id`) REFERENCES `test_interface` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `registrations_ibfk_3` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of registrations
-- ----------------------------

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `demo` tinyint(1) DEFAULT '0',
  `permissions` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------

-- ----------------------------
-- Table structure for `tasks`
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `make_user` int(11) DEFAULT NULL COMMENT '创建用户',
  `task_name` varchar(52) DEFAULT NULL COMMENT '任务名称',
  `task_desc` varchar(252) DEFAULT NULL,
  `task_start` varchar(252) DEFAULT NULL COMMENT '任务执行时间',
  `task_make_date` datetime DEFAULT NULL COMMENT '任务创建时间',
  `task_repor_to` varchar(252) DEFAULT NULL COMMENT '收件人邮箱',
  `task_repor_operate` varchar(252) DEFAULT NULL COMMENT '抄送人邮箱',
  `task_make_email` varchar(252) DEFAULT NULL COMMENT '维护任务人的邮箱',
  `status` tinyint(1) DEFAULT '0' COMMENT '任务状态，默认正常状态',
  `run_status` varchar(64) DEFAULT '创建' COMMENT '任务运行状态，默认创建',
  `prject` int(11) DEFAULT NULL COMMENT '任务所属项目',
  `test_event` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `make_user` (`make_user`),
  KEY `prject` (`prject`),
  KEY `test_event` (`test_event`),
  CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`make_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tasks
-- ----------------------------

-- ----------------------------
-- Table structure for `test_case_results`
-- ----------------------------
DROP TABLE IF EXISTS `test_case_results`;
CREATE TABLE `test_case_results` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `case_id` int(11) DEFAULT NULL,
  `result` varchar(252) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `test_evm` int(11) DEFAULT NULL COMMENT '测试环境',
  PRIMARY KEY (`id`),
  KEY `case_id` (`case_id`),
  KEY `test_evm` (`test_evm`),
  CONSTRAINT `test_case_results_ibfk_3` FOREIGN KEY (`case_id`) REFERENCES `test_interface` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_case_results_ibfk_4` FOREIGN KEY (`test_evm`) REFERENCES `test_environment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_case_results
-- ----------------------------

-- ----------------------------
-- Table structure for `test_environment`
-- ----------------------------
DROP TABLE IF EXISTS `test_environment`;
CREATE TABLE `test_environment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `make_user` int(11) DEFAULT NULL COMMENT '创建用户',
  `url` varchar(64) DEFAULT NULL COMMENT '地址',
  `project` int(11) DEFAULT NULL COMMENT '环境对应的项目',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `database` varchar(255) DEFAULT NULL COMMENT '数据库',
  `database_password` varchar(32) DEFAULT NULL COMMENT '数据库用户密码',
  `database_user` varchar(32) DEFAULT NULL COMMENT '数据库用户',
  `db_host` varchar(255) DEFAULT NULL COMMENT '数据库主机',
  `db_port` varchar(255) DEFAULT NULL COMMENT '数据库服务端口',
  PRIMARY KEY (`id`),
  KEY `make_user` (`make_user`),
  KEY `project` (`project`),
  CONSTRAINT `test_environment_ibfk_1` FOREIGN KEY (`make_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_environment_ibfk_2` FOREIGN KEY (`project`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_environment
-- ----------------------------

-- ----------------------------
-- Table structure for `test_interface`
-- ----------------------------
DROP TABLE IF EXISTS `test_interface`;
CREATE TABLE `test_interface` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_id` int(11) DEFAULT NULL,
  `projects_id` int(11) DEFAULT NULL,
  `Interface_name` varchar(252) DEFAULT NULL,
  `Interface_url` varchar(252) DEFAULT NULL,
  `Interface_meth` varchar(252) DEFAULT NULL,
  `Interface_pase` varchar(252) DEFAULT NULL,
  `Interface_assert` varchar(252) DEFAULT NULL,
  `Interface_user_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `Interface_headers` varchar(252) DEFAULT NULL,
  `Interface_is_debug` tinyint(1) DEFAULT '0',
  `Interface_debug_whether` tinyint(1) DEFAULT '1',
  `getattr_p` varchar(252) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `save_result` tinyint(1) DEFAULT '0',
  `select_database` varchar(252) DEFAULT NULL,
  `database_field` varchar(252) DEFAULT NULL,
  `is_database` tinyint(1) DEFAULT '0',
  `interface_type` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Interface_user_id` (`Interface_user_id`),
  KEY `projects_id` (`projects_id`),
  KEY `model_id` (`model_id`),
  CONSTRAINT `test_interface_ibfk_4` FOREIGN KEY (`Interface_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_interface_ibfk_5` FOREIGN KEY (`projects_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_interface_ibfk_6` FOREIGN KEY (`model_id`) REFERENCES `models` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_interface
-- ----------------------------

-- ----------------------------
-- Table structure for `test_results`
-- ----------------------------
DROP TABLE IF EXISTS `test_results`;
CREATE TABLE `test_results` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_user_id` int(11) DEFAULT NULL,
  `test_num` int(11) DEFAULT NULL,
  `pass_num` int(11) DEFAULT NULL,
  `fail_num` int(11) DEFAULT NULL,
  `test_time` datetime DEFAULT NULL,
  `hour_time` int(11) DEFAULT NULL,
  `test_log` varchar(252) DEFAULT NULL,
  `test_rep` varchar(252) DEFAULT NULL,
  `projects_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `exception_num` int(11) DEFAULT NULL,
  `para_num` int(11) DEFAULT NULL,
  `unknow_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `test_user_id` (`test_user_id`),
  KEY `projects_id` (`projects_id`),
  CONSTRAINT `test_results_ibfk_1` FOREIGN KEY (`test_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_results_ibfk_2` FOREIGN KEY (`projects_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_results
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `is_spre` tinyint(1) NOT NULL DEFAULT '0',
  `work_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE,
  UNIQUE KEY `user_email` (`user_email`) USING BTREE,
  KEY `work_id` (`work_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`work_id`) REFERENCES `works` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '202CB962AC59075B964B07152D234B70', '2016-11-06 16:56:45', '2018-05-15 00:01:59', 'admin@test.com', '0', '0', null);
INSERT INTO `user` VALUES ('2', 'demo', 'ABE45D28281CFA2A4201C9B90A143095', '2018-07-18 13:21:32', '2018-07-18 13:21:36', 'test@test.com', '0', '0', null);

-- ----------------------------
-- Table structure for `works`
-- ----------------------------
DROP TABLE IF EXISTS `works`;
CREATE TABLE `works` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of works
-- ----------------------------
