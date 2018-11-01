/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : green

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 01/11/2018 11:18:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alembic_version
-- ----------------------------
DROP TABLE IF EXISTS `alembic_version`;
CREATE TABLE `alembic_version`  (
  `version_num` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`version_num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rose` int(11) NULL DEFAULT NULL,
  `project` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `project`(`project`) USING BTREE,
  INDEX `rose`(`rose`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `author_ibfk_2` FOREIGN KEY (`project`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `author_ibfk_3` FOREIGN KEY (`rose`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `author_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for depend
-- ----------------------------
DROP TABLE IF EXISTS `depend`;
CREATE TABLE `depend`  (
  `case_id` int(11) NOT NULL AUTO_INCREMENT,
  `suite_id` int(11) NULL DEFAULT NULL,
  `attred` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `case_id`(`case_id`) USING BTREE,
  CONSTRAINT `depend_ibfk_1` FOREIGN KEY (`case_id`) REFERENCES `test_case` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for email_reports
-- ----------------------------
DROP TABLE IF EXISTS `email_reports`;
CREATE TABLE `email_reports`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email_re_user_id` int(11) NULL DEFAULT NULL COMMENT '设置发件人',
  `send_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发件箱地址',
  `send_email_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发件箱密码',
  `to_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人',
  `default_set` tinyint(1) NULL DEFAULT 0 COMMENT '默认',
  `port` int(11) NULL DEFAULT NULL COMMENT '端口号',
  `stmp_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'smtp服务器',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `email_re_user_id`(`email_re_user_id`) USING BTREE,
  CONSTRAINT `email_reports_ibfk_1` FOREIGN KEY (`email_re_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for interfaces
-- ----------------------------
DROP TABLE IF EXISTS `interfaces`;
CREATE TABLE `interfaces`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_id` int(11) NULL DEFAULT NULL,
  `projects_id` int(11) NULL DEFAULT NULL,
  `Interface_name` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Interface_url` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Interface_meth` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'GET',
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `Interface_headers` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `interface_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'http',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `projects_id`(`projects_id`) USING BTREE,
  INDEX `model_id`(`model_id`) USING BTREE,
  CONSTRAINT `interfaces_ibfk_4` FOREIGN KEY (`projects_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `interfaces_ibfk_5` FOREIGN KEY (`model_id`) REFERENCES `models` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interfaces
-- ----------------------------
INSERT INTO `interfaces` VALUES (1, 1, 1, '获取外网列表', '/restapi/network/external/', 'GET', 0, NULL, 'https');

-- ----------------------------
-- Table structure for mock_server
-- ----------------------------
DROP TABLE IF EXISTS `mock_server`;
CREATE TABLE `mock_server`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `make_uers` int(11) NULL DEFAULT NULL COMMENT '创建用户',
  `name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `path` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `methods` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法',
  `headers` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求头',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `return_para` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返回数据',
  `params` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `rebacktype` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态是否开启',
  `delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  `is_check` tinyint(1) NULL DEFAULT 0 COMMENT '是否校验参数',
  `is_headers` tinyint(1) NULL DEFAULT 0 COMMENT '是否检验header',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `make_uers`(`make_uers`) USING BTREE,
  CONSTRAINT `mock_server_ibfk_1` FOREIGN KEY (`make_uers`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for models
-- ----------------------------
DROP TABLE IF EXISTS `models`;
CREATE TABLE `models`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `model_project_id` int(11) NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `model_project_id`(`model_project_id`) USING BTREE,
  CONSTRAINT `models_ibfk_1` FOREIGN KEY (`model_project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of models
-- ----------------------------
INSERT INTO `models` VALUES (1, '网络', 1, 1);

-- ----------------------------
-- Table structure for parames
-- ----------------------------
DROP TABLE IF EXISTS `parames`;
CREATE TABLE `parames`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_case_id` int(11) NULL DEFAULT NULL COMMENT '接口id',
  `parameter_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数类型',
  `parameter_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称',
  `necessary` tinyint(1) NULL DEFAULT 0 COMMENT '是否必传',
  `parameter` int(11) NULL DEFAULT 0 COMMENT '参数',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态',
  `desc` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `test_case_id`(`test_case_id`) USING BTREE,
  CONSTRAINT `parames_ibfk_2` FOREIGN KEY (`test_case_id`) REFERENCES `test_case` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_user_id` int(11) NULL DEFAULT NULL,
  `project_name` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `project_name`(`project_name`) USING BTREE,
  INDEX `project_user_id`(`project_user_id`) USING BTREE,
  CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`project_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of projects
-- ----------------------------
INSERT INTO `projects` VALUES (1, 2, 'NeoCU', 0);

-- ----------------------------
-- Table structure for registrations
-- ----------------------------
DROP TABLE IF EXISTS `registrations`;
CREATE TABLE `registrations`  (
  `task_id` int(11) NULL DEFAULT NULL,
  `test_interface_id` int(11) NULL DEFAULT NULL,
  INDEX `test_interface_id`(`test_interface_id`) USING BTREE,
  INDEX `task_id`(`task_id`) USING BTREE,
  CONSTRAINT `registrations_ibfk_2` FOREIGN KEY (`test_interface_id`) REFERENCES `test_case` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `registrations_ibfk_3` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `demo` tinyint(1) NULL DEFAULT 0,
  `permissions` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, 'owner', 1, NULL);
INSERT INTO `roles` VALUES (2, 'master', 1, NULL);
INSERT INTO `roles` VALUES (3, 'developer', 1, NULL);
INSERT INTO `roles` VALUES (4, 'reporter', 1, NULL);
INSERT INTO `roles` VALUES (5, 'guest', 1, NULL);

-- ----------------------------
-- Table structure for tasks
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `make_user` int(11) NULL DEFAULT NULL COMMENT '创建用户',
  `task_name` varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `task_desc` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `task_start` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务执行时间',
  `task_make_date` datetime(0) NULL DEFAULT NULL COMMENT '任务创建时间',
  `task_repor_to` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人邮箱',
  `task_repor_operate` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抄送人邮箱',
  `task_make_email` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护任务人的邮箱',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '任务状态，默认正常状态',
  `run_status` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '创建' COMMENT '任务运行状态，默认创建',
  `prject` int(11) NULL DEFAULT NULL COMMENT '任务所属项目',
  `test_event` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `make_user`(`make_user`) USING BTREE,
  INDEX `prject`(`prject`) USING BTREE,
  INDEX `test_event`(`test_event`) USING BTREE,
  CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`make_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_case
-- ----------------------------
DROP TABLE IF EXISTS `test_case`;
CREATE TABLE `test_case`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interface_id` int(11) NOT NULL COMMENT '接口id',
  `request_type` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求类型',
  `request_header` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求header',
  `request_para` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数parameter',
  `request_data` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求数据data',
  `status_code` int(10) NULL DEFAULT NULL COMMENT 'response code',
  `response_data` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返回数据',
  `expect_data` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '期望结果',
  `save_result` tinyint(1) NULL DEFAULT NULL COMMENT '是否保存结果',
  `assert` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '检查点',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `interface_id`(`interface_id`) USING BTREE,
  CONSTRAINT `test_case_ibfk_1` FOREIGN KEY (`interface_id`) REFERENCES `interfaces` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_case_results
-- ----------------------------
DROP TABLE IF EXISTS `test_case_results`;
CREATE TABLE `test_case_results`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `case_id` int(11) NULL DEFAULT NULL,
  `result` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `test_evm` int(11) NULL DEFAULT NULL COMMENT '测试环境',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `case_id`(`case_id`) USING BTREE,
  INDEX `test_evm`(`test_evm`) USING BTREE,
  CONSTRAINT `test_case_results_ibfk_3` FOREIGN KEY (`case_id`) REFERENCES `test_case` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_case_results_ibfk_4` FOREIGN KEY (`test_evm`) REFERENCES `test_environment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_environment
-- ----------------------------
DROP TABLE IF EXISTS `test_environment`;
CREATE TABLE `test_environment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `make_user` int(11) NULL DEFAULT NULL COMMENT '创建用户',
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '环境名称',
  `database` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库',
  `database_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库用户密码',
  `database_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库用户',
  `db_host` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库主机',
  `db_port` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库服务端口',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `make_user`(`make_user`) USING BTREE,
  CONSTRAINT `test_environment_ibfk_1` FOREIGN KEY (`make_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_environment
-- ----------------------------
INSERT INTO `test_environment` VALUES (1, 2, 'https://10.130.232.10', 1, '232测试环境', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for test_results
-- ----------------------------
DROP TABLE IF EXISTS `test_results`;
CREATE TABLE `test_results`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_user_id` int(11) NULL DEFAULT NULL,
  `test_num` int(11) NULL DEFAULT NULL,
  `pass_num` int(11) NULL DEFAULT NULL,
  `fail_num` int(11) NULL DEFAULT NULL,
  `test_time` datetime(0) NULL DEFAULT NULL,
  `hour_time` int(11) NULL DEFAULT NULL,
  `test_log` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `test_rep` varchar(252) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `projects_id` int(11) NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT 0,
  `exception_num` int(11) NULL DEFAULT NULL,
  `para_num` int(11) NULL DEFAULT NULL,
  `unknow_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `test_user_id`(`test_user_id`) USING BTREE,
  INDEX `projects_id`(`projects_id`) USING BTREE,
  CONSTRAINT `test_results_ibfk_1` FOREIGN KEY (`test_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_results_ibfk_2` FOREIGN KEY (`projects_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码，MD5加密',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '最后一次更新时间',
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `is_spre` tinyint(1) NOT NULL DEFAULT 0,
  `work_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name_unique`(`username`) USING BTREE,
  UNIQUE INDEX `user_email`(`user_email`) USING BTREE,
  INDEX `work_id`(`work_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`work_id`) REFERENCES `works` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '202CB962AC59075B964B07152D234B70', '2016-11-06 16:56:45', '2018-05-15 00:01:59', 'admin@test.com', 0, 0, 1);
INSERT INTO `user` VALUES (2, 'demo', 'ABE45D28281CFA2A4201C9B90A143095', '2018-07-18 13:21:32', '2018-07-18 13:21:36', 'test@test.com', 1, 0, 4);

-- ----------------------------
-- Table structure for works
-- ----------------------------
DROP TABLE IF EXISTS `works`;
CREATE TABLE `works`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of works
-- ----------------------------
INSERT INTO `works` VALUES (5, '产品经理');
INSERT INTO `works` VALUES (2, '开发');
INSERT INTO `works` VALUES (1, '测试');
INSERT INTO `works` VALUES (3, '测试组长');
INSERT INTO `works` VALUES (4, '测试经理');
INSERT INTO `works` VALUES (6, '项目经理');

SET FOREIGN_KEY_CHECKS = 1;
