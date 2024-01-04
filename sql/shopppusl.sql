/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50647
 Source Host           : localhost:3306
 Source Schema         : shopppusl

 Target Server Type    : MySQL
 Target Server Version : 50647
 File Encoding         : 65001

 Date: 04/01/2024 11:36:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advertiser_info
-- ----------------------------
DROP TABLE IF EXISTS `advertiser_info`;
CREATE TABLE `advertiser_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '公告内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for cart_info
-- ----------------------------
DROP TABLE IF EXISTS `cart_info`;
CREATE TABLE `cart_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goodsId` bigint(20) NULL DEFAULT NULL COMMENT '所属商品',
  `count` int(10) NULL DEFAULT NULL COMMENT '数量',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '所属用户',
  `level` int(10) NULL DEFAULT NULL COMMENT '用户等级',
  `createTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for coupon_info
-- ----------------------------
DROP TABLE IF EXISTS `coupon_info`;
CREATE TABLE `coupon_info`  (
  ` couponId` bigint(20) NOT NULL,
  `couponName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '优惠劵名称',
  `couponDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '优惠卷介绍',
  `couponTotal` int(11) NOT NULL COMMENT '优惠卷数量',
  `discount` int(11) NULL DEFAULT NULL COMMENT '优惠金额',
  `min` int(11) NULL DEFAULT NULL COMMENT '最小使用金额',
  `couponStauts` tinyint(4) NULL DEFAULT NULL COMMENT '优惠卷状态',
  `couponStartTime` datetime(0) NULL DEFAULT NULL COMMENT '优惠卷开始时间',
  `couponStopTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (` couponId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '商品描述',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `discount` double(10, 2) NULL DEFAULT NULL COMMENT '商品折扣价格',
  `sales` int(10) NULL DEFAULT 0 COMMENT '商品销量',
  `hot` int(10) NULL DEFAULT 10 COMMENT '商品点赞数',
  `recommend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是不是推荐',
  `count` int(10) NULL DEFAULT 0 COMMENT '库存',
  `typeId` bigint(20) NULL DEFAULT NULL COMMENT '所属类别',
  `fields` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片ID，用英文, 隔开',
  `goodbCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品条码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品详情表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for order_goods_rel
-- ----------------------------
DROP TABLE IF EXISTS `order_goods_rel`;
CREATE TABLE `order_goods_rel`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderId` bigint(20) NULL DEFAULT NULL COMMENT '所属订单ID',
  `goodsId` bigint(20) NULL DEFAULT NULL COMMENT '所属商品ID',
  `count` int(10) NULL DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单商品关系映射表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单ID',
  `totalPrice` double(10, 0) NULL DEFAULT NULL COMMENT '总价格',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '所属用户',
  `level` int(10) NULL DEFAULT NULL COMMENT '用户等级',
  `linkAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `linkPhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `linkMan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `createTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品订单信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for type_info
-- ----------------------------
DROP TABLE IF EXISTS `type_info`;
CREATE TABLE `type_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parentId` bigint(20) NULL DEFAULT NULL COMMENT '父分类id',
  `categoryLevel` tinyint(4) NOT NULL COMMENT '分类级别(1-一级分类 2-二级分类 3-三级分类)',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品类别表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(10) NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `level` int(10) NULL DEFAULT NULL COMMENT '权限等级(root  c  用户)',
  `account` double(10, 2) NULL DEFAULT NULL COMMENT '余额',
  `vipid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'vip卡（用户）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vip_info
-- ----------------------------
DROP TABLE IF EXISTS `vip_info`;
CREATE TABLE `vip_info`  (
  `id` int(11) NOT NULL COMMENT 'vip卡主键',
  `vipStartTime` datetime(0) NULL DEFAULT NULL COMMENT 'vip卡生效时间',
  `vipStopTime` datetime(0) NULL DEFAULT NULL COMMENT 'vip卡过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Procedure structure for demo
-- ----------------------------
DROP PROCEDURE IF EXISTS `demo`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `demo`()
BEGIN
	IF NOT EXISTS(SELECT * FROM user_info WHERE `name` = '111') THEN
		INSERT INTO user_info(`name`, `password`) VALUES('111', '123456');
	ELSE
		DELETE FROM user_info WHERE `name` = '111';
	END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for lbwnb
-- ----------------------------
DROP PROCEDURE IF EXISTS `lbwnb`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lbwnb`(`name` VARCHAR(20), pwd VARCHAR(255))
BEGIN
  INSERT INTO user_info(`name`, `password`) VALUES(`name`, pwd);
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
