/*
 Navicat Premium Data Transfer

 Source Server         : LH
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : hotel

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 15/06/2019 15:37:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'admin', '115712', '18792579011', '115712@qq.com', '男');
INSERT INTO `admin_user` VALUES (2, '李恒', '115712', '18792579011', '115712@qq.com', '男');
INSERT INTO `admin_user` VALUES (3, '李哲', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (4, '刘天阳', '123456789', '18691489614', '5988651@qq.com', '男');
INSERT INTO `admin_user` VALUES (5, '刘星', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (6, '郑玉楠', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (7, '马甲', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (8, '你好', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (10, '张毕成', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (11, '刘晨', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (12, '11111', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (13, '111111111', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (14, '石头', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (15, '疯狂的id', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (16, '勒戒', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (17, '凤姐', '115712', NULL, NULL, NULL);
INSERT INTO `admin_user` VALUES (18, '小明', '115712', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for food_info
-- ----------------------------
DROP TABLE IF EXISTS `food_info`;
CREATE TABLE `food_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food_info
-- ----------------------------
INSERT INTO `food_info` VALUES (1, '牛筋面', '无', 10);
INSERT INTO `food_info` VALUES (2, '深海尤物套餐', '无', 150);
INSERT INTO `food_info` VALUES (5, '凉皮', '无', 10);
INSERT INTO `food_info` VALUES (6, '牛排', '无', 100);

-- ----------------------------
-- Table structure for food_order
-- ----------------------------
DROP TABLE IF EXISTS `food_order`;
CREATE TABLE `food_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `food_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  INDEX `food_name`(`food_name`) USING BTREE,
  CONSTRAINT `food_order_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `food_order_ibfk_2` FOREIGN KEY (`food_name`) REFERENCES `food_info` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `id` int(11) NOT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` int(11) NOT NULL,
  `isnull` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `isnull`(`isnull`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES (1000, '双人间', 500, 1);
INSERT INTO `room_info` VALUES (1001, '单人间', 200, 1);
INSERT INTO `room_info` VALUES (1002, '豪华间', 1000, 1);
INSERT INTO `room_info` VALUES (1003, '单人间', 200, 1);
INSERT INTO `room_info` VALUES (1004, '单人间', 200, 1);
INSERT INTO `room_info` VALUES (1005, '单人间', 200, 1);
INSERT INTO `room_info` VALUES (1006, '双人间', 500, 1);
INSERT INTO `room_info` VALUES (1007, '双人间', 500, 0);
INSERT INTO `room_info` VALUES (1008, '双人间', 500, 1);
INSERT INTO `room_info` VALUES (1009, '双人间', 500, 1);
INSERT INTO `room_info` VALUES (1010, '豪华间', 1000, 0);
INSERT INTO `room_info` VALUES (1011, '豪华间', 1000, 0);
INSERT INTO `room_info` VALUES (1012, '豪华间', 1000, 0);
INSERT INTO `room_info` VALUES (1013, '豪华间', 1000, 0);
INSERT INTO `room_info` VALUES (2010, '双人间', 481, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_2`(`username`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'roo2', 'root', '凤姐', '女', '18792579011', '115712@163.com', '2019-06-07');
INSERT INTO `user` VALUES (5, '用户1', '115712', '小红', '女', '18792579011', '115712@163.com', '2019-06-07');
INSERT INTO `user` VALUES (6, '用户甲', '123456', '阿亮', '男', '18792579011', '115712@qq.com', '2019-06-07');
INSERT INTO `user` VALUES (7, '用户4', '123456', '小明', '男', '18792579012', '115712@qq.com', '2019-06-09');
INSERT INTO `user` VALUES (9, '111111111', '123456', '1111111', '男', '18792579011', '115712@qq.com', '2019-06-09');
INSERT INTO `user` VALUES (10, '1111111', '123456', '1111111', '男', '18792579011', '115712@qq.com', '2019-06-09');
INSERT INTO `user` VALUES (11, '11111', '123456', '111', '男', '18792579011', '115712@qq.com', '2019-06-09');
INSERT INTO `user` VALUES (12, '11111111111111', '123456', '111111', '男', '18792579011', '115712@qq.com', '2019-06-09');
INSERT INTO `user` VALUES (13, '11111111', '123456', '111111', '男', '18792579011', '115712@qq.com', '2019-06-09');
INSERT INTO `user` VALUES (14, '111111111111', '123456', '11111111', '男', '18792579011', '115712@qq.com', '2019-06-09');
INSERT INTO `user` VALUES (15, 'iheng', '115712', '1111111', '女', '18792579011', '115712@qq.com', '2019-06-09');
INSERT INTO `user` VALUES (16, 'admin', '115712', 'liheng', '男', '187925790', '115712@qq.com', '2019-06-09 21:38:04.629');
INSERT INTO `user` VALUES (17, 'lliuxiang', '115712', 'liuxing', '男', '187925790', '115712@qq.com', '2019-06-09 22:31:28.765');

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `roomid` int(11) NOT NULL,
  `status` int(1) NOT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `usename`(`username`) USING BTREE,
  INDEX `room_id`(`roomid`) USING BTREE,
  INDEX `room_status`(`status`) USING BTREE,
  CONSTRAINT `user_order_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_order_ibfk_2` FOREIGN KEY (`roomid`) REFERENCES `room_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_order
-- ----------------------------
INSERT INTO `user_order` VALUES (1, '用户甲', 1001, 1, '2019-06-07');
INSERT INTO `user_order` VALUES (4, '用户1', 1000, 1, '2019-06-07');
INSERT INTO `user_order` VALUES (5, '用户4', 1002, 1, '2019-06-07');
INSERT INTO `user_order` VALUES (14, 'admin', 1006, 1, '2019-06-11');
INSERT INTO `user_order` VALUES (19, 'admin', 1003, 1, '2019-06-11');
INSERT INTO `user_order` VALUES (20, 'admin', 1004, 0, '2019-06-11');
INSERT INTO `user_order` VALUES (21, 'admin', 1005, 0, '2019-06-11');

SET FOREIGN_KEY_CHECKS = 1;
