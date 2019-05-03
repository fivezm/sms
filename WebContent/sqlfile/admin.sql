/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50512
 Source Host           : localhost:3306
 Source Schema         : sms

 Target Server Type    : MySQL
 Target Server Version : 50512
 File Encoding         : 65001

 Date: 03/05/2019 14:20:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `admin_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'A001', '001', '小迪');
INSERT INTO `admin` VALUES (11, 'A002', '003', '小铭');
INSERT INTO `admin` VALUES (17, 'A005', '005', '小欣');

SET FOREIGN_KEY_CHECKS = 1;
