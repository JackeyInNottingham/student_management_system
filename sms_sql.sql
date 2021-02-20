/*
 Navicat Premium Data Transfer

 Source Server         : 虚拟机
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 192.168.56.10:3306
 Source Schema         : sms

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 20/02/2021 20:17:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `gender` char(1) DEFAULT NULL,
  `password` varchar(20) NOT NULL DEFAULT '12345',
  `email` varchar(50) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `address` varchar(100) NOT NULL,
  `portrait_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
BEGIN;
INSERT INTO `tb_admin` VALUES (1, 'xiaohong', '女', '12345', 'xiaohong@123.com', '123456789', 'XXYYZZ', '/upload/portrait/default_admin_portrait.png');
INSERT INTO `tb_admin` VALUES (3, 'xiaohuang', '男', '12345', 'xiaohuang@123.com', '12313112', 'test', '/upload/portrait/352a7891c5d74fe6bc186e53f4c7458f_lihua.jpeg');
COMMIT;

-- ----------------------------
-- Table structure for tb_clazz
-- ----------------------------
DROP TABLE IF EXISTS `tb_clazz`;
CREATE TABLE `tb_clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `number` int(3) NOT NULL,
  `introduction` varchar(200) NOT NULL,
  `coordinator` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `grade_name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_clazz_tb_grade__fk_idx` (`grade_name`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_clazz
-- ----------------------------
BEGIN;
INSERT INTO `tb_clazz` VALUES (68, '一年级一班', 45, '~', '管大人', 'guandaren@123.com', '13123123123', '一年级');
INSERT INTO `tb_clazz` VALUES (69, '一年级二班', 60, '~~', '老刘', 'laoliu@123.com', '12321312', '一年级');
INSERT INTO `tb_clazz` VALUES (73, '二年级一班', 52, '~~~', '老李', 'laoli@123.com', '11232131', '二年级');
INSERT INTO `tb_clazz` VALUES (74, '三年级一班', 58, '~~~~', '老吴', 'laowu@123.com', '1231231', '三年级');
COMMIT;

-- ----------------------------
-- Table structure for tb_grade
-- ----------------------------
DROP TABLE IF EXISTS `tb_grade`;
CREATE TABLE `tb_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `manager` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `introduction` varchar(200) NOT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_grade
-- ----------------------------
BEGIN;
INSERT INTO `tb_grade` VALUES (93, '一年级', '管大人', 'guandaren@123.com', '13123123123', '飘飘的天下');
INSERT INTO `tb_grade` VALUES (94, '二年级', '老李', 'laoli@123.com', '12313123', '老李天下第一');
INSERT INTO `tb_grade` VALUES (96, '三年级', '老吴', 'laowu@123.com', '123123', '无敌的老吴');
COMMIT;

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` varchar(20) NOT NULL,
  `name` varchar(15) NOT NULL,
  `gender` char(1) DEFAULT NULL,
  `password` varchar(20) NOT NULL DEFAULT '12345',
  `email` varchar(50) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `address` varchar(100) NOT NULL,
  `introduction` varchar(200) DEFAULT NULL,
  `portrait_path` varchar(200) DEFAULT NULL,
  `clazz_name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_student_sno_uindex` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
BEGIN;
INSERT INTO `tb_student` VALUES (8, '1002', 'xiaoming', '男', '12345', 'xiaoming@123.com', '123123123123', 'aavbv', '~', '/upload/portrait/c370f9cfc0df487ab0405e282459239c_智子.jpg', '一年级一班');
INSERT INTO `tb_student` VALUES (17, '1008', 'test6', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', '一年级二班');
INSERT INTO `tb_student` VALUES (18, '1009', 'test7', '男', '12345', 'test', 'test', 'test', 'test12132131', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (20, '1011', 'test9', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (24, '1015', 'test13', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (28, '1019', 'test17', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (30, '1021', 'test19', '男', '12345', 'test1', 'test', 'test111', 'test111111', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (31, '1022', 'test20', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (32, '1023', 'test21', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (33, '1024', 'test22', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (34, '1025', 'test23', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (35, '1026', 'test24', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (36, '1027', 'test25', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (37, '1028', 'test26', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (38, '1029', 'test27', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (39, '1030', 'test28', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (40, '1031', 'test29', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (41, '1032', 'test30', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (42, '1033', 'test31', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (43, '1034', 'test32', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (45, '1036', 'test34', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (46, '1037', 'test35', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (47, '1038', 'test36', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (48, '1039', 'test37', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (49, '1040', 'test38', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (50, '1041', 'test39', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (51, '1042', 'test40', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (52, '1043', 'test41', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (53, '1044', 'test42', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (54, '1045', 'test43', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (55, '1046', 'test44', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (56, '1047', 'test45', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (57, '1048', 'test46', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (58, '1049', 'test47', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (59, '1050', 'test48', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (60, '1051', 'test49', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (61, '1052', 'test50', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (62, '1053', 'test51', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (64, '1055', 'test53', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (65, '1056', 'test54', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (66, '1057', 'test55', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (67, '1058', 'test56', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (68, '1059', 'test57', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (69, '1060', 'test58', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (70, '1061', 'test59', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (71, '1062', 'test60', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (72, '1063', 'test61', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (73, '1064', 'test62', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (74, '1065', 'test63', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (75, '1066', 'test64', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (76, '1067', 'test65', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (77, '1068', 'test66', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (78, '1069', 'test67', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (79, '1070', 'test68', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (80, '1071', 'test69', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (81, '1072', 'test70', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (82, '1073', 'test71', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (83, '1074', 'test72', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (84, '1075', 'test73', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (85, '1076', 'test74', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (86, '1077', 'test75', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (87, '1078', 'test76', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (88, '1079', 'test77', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (89, '1080', 'test78', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (90, '1081', 'test79', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (91, '1082', 'test80', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (92, '1083', 'test81', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (93, '1084', 'test82', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (94, '1085', 'test83', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (95, '1086', 'test84', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (96, '1087', 'test85', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (97, '1088', 'test86', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (98, '1089', 'test87', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (99, '1090', 'test88', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (100, '1091', 'test89', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (101, '1092', 'test90', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (102, '1093', 'test91', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (103, '1094', 'test92', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (104, '1095', 'test93', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (105, '1096', 'test94', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (106, '1097', 'test95', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (107, '1098', 'test96', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (108, '1099', 'test97', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (109, '1100', 'test98', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (110, '1101', 'test99', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (111, '1102', 'test100', '男', '12345', 'test', 'test', 'test', 'test', '/upload/portrait/default_student_portrait.png', 'test');
INSERT INTO `tb_student` VALUES (112, 'fdafas', 'fdsaf', '男', '12345', 'fdaf', '', 'dafd', 'fdafas', '', '一班');
INSERT INTO `tb_student` VALUES (113, '123123', 'test12312', '男', '12345', '123123', '', '21', '22', '/upload/portrait/96a74fd20d344c40926dba1f8db6b379_智子.jpg', '一班');
COMMIT;

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tno` varchar(20) NOT NULL,
  `name` varchar(15) NOT NULL,
  `gender` char(1) DEFAULT NULL,
  `password` varchar(20) NOT NULL DEFAULT '12345',
  `email` varchar(50) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `address` varchar(100) NOT NULL,
  `portrait_path` varchar(200) DEFAULT NULL,
  `clazz_name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_teacher_tno_uindex` (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
BEGIN;
INSERT INTO `tb_teacher` VALUES (13, '0102', '管大人', '男', '12345', 'guandaren2@123.com', '13123123123', 'rd', '/upload/portrait/0a306b60a35d402bb87ea31fd16fb6e0_智子.jpg', '一年级一班');
INSERT INTO `tb_teacher` VALUES (15, '0103', '老李', '男', '12345', 'laoli@123.com', '', 'nn', '/upload/portrait/7b4e41065dd44feda9c1aa65612ded23_default_teacher_portrait.png', '一年级二班');
INSERT INTO `tb_teacher` VALUES (16, '0104', '老刘', '男', '12345', 'laoliu@123.com', '123123213', 'tt', '/upload/portrait/55e8cdcaa5aa4d41b0007d6e486ff2bb_default_teacher_portrait.png', '二年级一班');
INSERT INTO `tb_teacher` VALUES (17, '0105', '老吴', '男', '12345', 'laowu@123.com', '12312313213', 'rr', '/upload/portrait/8a7eb3948da045e38e3486709474117f_default_teacher_portrait.png', '三年级一班');
INSERT INTO `tb_teacher` VALUES (18, 'test', 'test', '男', '12345', 'test', 'test', 'test', '/upload/portrait/c2688d93353c4cda9add2fa7d2bc6121_default_admin_portrait.png', '一班');
INSERT INTO `tb_teacher` VALUES (20, 'test10000', 'test1', '男', '12345', 'test1', 'test', 'test1', '/upload/portrait/e1636cc9e56143359f0f784634a019bb_智子.jpg', '一班');
INSERT INTO `tb_teacher` VALUES (21, 'test2', 'test2', '男', '12345', 'test2', 'test', 'test2', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test2');
INSERT INTO `tb_teacher` VALUES (22, 'test3', 'test3', '男', '12345', 'test3', 'test', 'test3', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test3');
INSERT INTO `tb_teacher` VALUES (23, 'test4fdsafdda', 'test4fdsf', '男', '12345', 'test4', 'test', 'fdafdtest4', '/upload/portrait/ce9a907ad1af425ea4e215015281ce86_智子.jpg', '一班');
INSERT INTO `tb_teacher` VALUES (24, 'test5', 'test5', '男', '12345', 'test5', 'test', 'test5', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test5');
INSERT INTO `tb_teacher` VALUES (25, 'test6', 'test6', '男', '12345', 'test6', 'test', 'test6', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test6');
INSERT INTO `tb_teacher` VALUES (26, 'test7', 'test7', '男', '12345', 'test7', 'test', 'test7', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test7');
INSERT INTO `tb_teacher` VALUES (27, 'test8', 'test8', '男', '12345', 'test8', 'test', 'test8', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test8');
INSERT INTO `tb_teacher` VALUES (28, 'test9', 'test9', '男', '12345', 'test9', 'test', 'test9', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test9');
INSERT INTO `tb_teacher` VALUES (29, 'test10', 'test10', '男', '12345', 'test10', 'test', 'test10', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test10');
INSERT INTO `tb_teacher` VALUES (30, 'test11', 'test11', '男', '12345', 'test11', 'test', 'test11', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test11');
INSERT INTO `tb_teacher` VALUES (33, 'test14', 'test14', '男', '12345', 'test14', 'test', 'test14', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test14');
INSERT INTO `tb_teacher` VALUES (34, 'test15', 'test15', '男', '12345', 'test15', 'test', 'test15', '/src/resources/upload/portrait/default_teacher_portrait.png', 'test15');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
