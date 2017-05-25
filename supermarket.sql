/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : supermarket

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-05-25 23:31:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `sex` varchar(2) NOT NULL DEFAULT '��',
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `isdelete` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '王强', '小王', '男', '', null, 'N');
INSERT INTO `customer` VALUES ('2', '李明', '小李', '男', null, null, 'N');

-- ----------------------------
-- Table structure for customer_login
-- ----------------------------
DROP TABLE IF EXISTS `customer_login`;
CREATE TABLE `customer_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`customer_id`),
  KEY `fk_customer_login_customer1_idx` (`customer_id`),
  CONSTRAINT `fk_customer_login_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_login
-- ----------------------------
INSERT INTO `customer_login` VALUES ('1', '123', '1');
INSERT INTO `customer_login` VALUES ('2', '123456', '2');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eID` varchar(45) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(20) CHARACTER SET big5 NOT NULL,
  `employee_limit_id` int(11) NOT NULL,
  `password` varchar(45) NOT NULL DEFAULT '123456',
  `isdelete` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  UNIQUE KEY `eID_UNIQUE` (`eID`),
  KEY `fk_employee_employee_limit1_idx` (`employee_limit_id`),
  CONSTRAINT `fk_employee_employee_limit1` FOREIGN KEY (`employee_limit_id`) REFERENCES `employee_limit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '123', '管理员', '18813292429', 'guanliyuan@qq.com', '1', '123', 'N');
INSERT INTO `employee` VALUES ('2', '124', '小红', '18813292422', 'xiaohong@qq.com', '2', '123', 'N');
INSERT INTO `employee` VALUES ('3', '125', '小黄', '18813292421', 'xiaohuang@qq.com', '3', '123', 'N');

-- ----------------------------
-- Table structure for employee_limit
-- ----------------------------
DROP TABLE IF EXISTS `employee_limit`;
CREATE TABLE `employee_limit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_limit
-- ----------------------------
INSERT INTO `employee_limit` VALUES ('1', 'A');
INSERT INTO `employee_limit` VALUES ('2', 'B');
INSERT INTO `employee_limit` VALUES ('3', 'C');

-- ----------------------------
-- Table structure for getadress
-- ----------------------------
DROP TABLE IF EXISTS `getadress`;
CREATE TABLE `getadress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adress` varchar(45) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `getname` varchar(45) NOT NULL,
  `getphone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_adress_customer1_idx` (`customer_id`),
  CONSTRAINT `fk_adress_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of getadress
-- ----------------------------
INSERT INTO `getadress` VALUES ('1', '广州', '1', '王强', '18813292420');
INSERT INTO `getadress` VALUES ('2', '深圳', '2', '李明', '18813299999');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `discount` double DEFAULT NULL,
  `create_date` date NOT NULL,
  `expiry_date` int(11) DEFAULT NULL,
  `size` varchar(45) NOT NULL,
  `producer` varchar(20) DEFAULT NULL,
  `goods_type_id` int(11) NOT NULL,
  `desc` varchar(45) NOT NULL,
  `isdelete` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  KEY `fk_goods_goods_type1_idx` (`goods_type_id`),
  CONSTRAINT `fk_goods_goods_type1` FOREIGN KEY (`goods_type_id`) REFERENCES `goods_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '火腿肠', '3', '10', '2017-05-25', '3', '中', '广州', '21', '好吃', 'N');
INSERT INTO `goods` VALUES ('3', '香飘飘', '5', '10', '2017-05-25', '5', '大', '杭州', '21', '好喝', 'N');
INSERT INTO `goods` VALUES ('4', '哇哈哈', '3', '7', '2017-05-11', '5', '大', '深圳', '4', '好喝', 'N');
INSERT INTO `goods` VALUES ('5', '统一冰红茶', '3', '10', '2017-05-25', '12', '中', '惠州', '4', '好喝', 'N');
INSERT INTO `goods` VALUES ('6', '上好佳', '5', '8', '2017-05-04', '36', '小', '日本', '21', '很好吃', 'N');
INSERT INTO `goods` VALUES ('7', '华硕', '3999', '9', '2017-05-02', '24', '中', '东莞', '13', '好用', 'N');

-- ----------------------------
-- Table structure for goods_sum
-- ----------------------------
DROP TABLE IF EXISTS `goods_sum`;
CREATE TABLE `goods_sum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sum` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_goods_sum_goods1_idx` (`goods_id`),
  CONSTRAINT `fk_goods_sum_goods1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_sum
-- ----------------------------
INSERT INTO `goods_sum` VALUES ('1', '3', '1');
INSERT INTO `goods_sum` VALUES ('2', '10', '3');
INSERT INTO `goods_sum` VALUES ('3', '5', '4');
INSERT INTO `goods_sum` VALUES ('4', '6', '5');
INSERT INTO `goods_sum` VALUES ('5', '100', '6');
INSERT INTO `goods_sum` VALUES ('6', '20', '7');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sub_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_goods_type_sub_type1_idx` (`sub_type_id`),
  CONSTRAINT `fk_goods_type_sub_type1` FOREIGN KEY (`sub_type_id`) REFERENCES `sub_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES ('1', '蔬菜', '1');
INSERT INTO `goods_type` VALUES ('2', '水果', '1');
INSERT INTO `goods_type` VALUES ('3', '肉类', '1');
INSERT INTO `goods_type` VALUES ('4', '饮料', '1');
INSERT INTO `goods_type` VALUES ('5', '酒类', '1');
INSERT INTO `goods_type` VALUES ('6', '电视', '2');
INSERT INTO `goods_type` VALUES ('7', '冰箱', '2');
INSERT INTO `goods_type` VALUES ('8', '空调', '2');
INSERT INTO `goods_type` VALUES ('9', '洗衣机', '2');
INSERT INTO `goods_type` VALUES ('10', '手机', '3');
INSERT INTO `goods_type` VALUES ('11', '手机配件', '3');
INSERT INTO `goods_type` VALUES ('12', '运营商', '3');
INSERT INTO `goods_type` VALUES ('13', '电脑', '4');
INSERT INTO `goods_type` VALUES ('14', '电脑配件', '4');
INSERT INTO `goods_type` VALUES ('15', '外设产品', '4');
INSERT INTO `goods_type` VALUES ('16', '短袖', '5');
INSERT INTO `goods_type` VALUES ('17', '长袖', '5');
INSERT INTO `goods_type` VALUES ('18', '短裤', '5');
INSERT INTO `goods_type` VALUES ('19', '长裤', '5');
INSERT INTO `goods_type` VALUES ('20', '鞋子', '5');
INSERT INTO `goods_type` VALUES ('21', '零食', '1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(20) NOT NULL,
  `order_status_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `isdelete` varchar(45) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  KEY `fk_order_order_status1_idx` (`order_status_id`),
  KEY `fk_order_customer1_idx` (`customer_id`),
  CONSTRAINT `fk_order_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_order_status1` FOREIGN KEY (`order_status_id`) REFERENCES `order_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '3', '3', '1', 'N');
INSERT INTO `order` VALUES ('2', '1', '3', '2', 'N');

-- ----------------------------
-- Table structure for order_items
-- ----------------------------
DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sum` varchar(45) DEFAULT NULL,
  `goods_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_items_goods1_idx` (`goods_id`),
  KEY `fk_order_items_order1_idx` (`order_id`),
  CONSTRAINT `fk_order_items_goods1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_items_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_items
-- ----------------------------

-- ----------------------------
-- Table structure for order_status
-- ----------------------------
DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_status
-- ----------------------------
INSERT INTO `order_status` VALUES ('1', '未发货');
INSERT INTO `order_status` VALUES ('2', '发货');
INSERT INTO `order_status` VALUES ('3', '运输中');

-- ----------------------------
-- Table structure for sub_type
-- ----------------------------
DROP TABLE IF EXISTS `sub_type`;
CREATE TABLE `sub_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sub_type
-- ----------------------------
INSERT INTO `sub_type` VALUES ('1', '食品');
INSERT INTO `sub_type` VALUES ('2', '电器');
INSERT INTO `sub_type` VALUES ('3', '手机');
INSERT INTO `sub_type` VALUES ('4', '电脑');
INSERT INTO `sub_type` VALUES ('5', '衣服');
SET FOREIGN_KEY_CHECKS=1;
