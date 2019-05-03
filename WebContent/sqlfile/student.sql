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

 Date: 03/05/2019 14:20:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(3) NULL DEFAULT NULL,
  `score` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (18, '009', '999', '吴三', 21, 88);
INSERT INTO `student` VALUES (19, '003', '333', '肥猪', 13, 23);
INSERT INTO `student` VALUES (21, '001', '111', '陈同学', 24, 70);
INSERT INTO `student` VALUES (22, '008', '888', '八姑', 55, 61);
INSERT INTO `student` VALUES (24, '002', '002', '李四', 21, 55);
INSERT INTO `student` VALUES (25, '004', '004', '陈小四', 24, 46);
INSERT INTO `student` VALUES (26, 'A011', '123', '小明', 20, 80);

SET FOREIGN_KEY_CHECKS = 1;
