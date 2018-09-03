/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : utf-8

 Date: 11/06/2016 11:20:27 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `eqs_samples_user`;
CREATE TABLE `eqs_samples_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birthDay` datetime DEFAULT NULL COMMENT '生日',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `gender` int(11) DEFAULT NULL COMMENT '性别，1为男，2为女',
  `money` double DEFAULT NULL COMMENT '财产',
  `groupId` int(11) DEFAULT NULL COMMENT '所属组织id',
  `isDeleted` tinyint(1) DEFAULT NULL COMMENT '是否已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `eqs_samples_user` VALUES ('1', 'eqs', '11', '2017-10-30 15:51:05', null, null, null, null, '1', '1'), ('2', 'eqs', '20', '2016-10-30 16:01:15', null, null, null, null, null, '1'), ('3', 'june', '1', '2017-11-06 11:11:01', null, null, null, null, '1', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
