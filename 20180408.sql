/*
Navicat MySQL Data Transfer

Source Server         : z
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : sharedppx

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-08 13:46:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `phonenum` varchar(50) COLLATE utf8_bin NOT NULL,
  `pwd` varchar(100) COLLATE utf8_bin NOT NULL,
  `nickname` varchar(50) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `birthday` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `enabled` int(2) NOT NULL DEFAULT '0',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `balance` float unsigned zerofill NOT NULL,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '17680519905', 'admin', 'sakura', '13454@love.com', '女', '1996年8月1日', '0', 'http://192.168.1.206:8080/SharedPPX/images/eaNQvSiOrt.jpg', '2016-11-22 19:11:17', '2016-10-21 11:35:43', '000000099999', '0');
INSERT INTO `user` VALUES ('2', 'qqq', '123', 'hopolaris', '123@qq.com', '女', '2017年10月13日', '0', 'http://192.168.1.206:8080/SharedPPX/images/wxILsrdCgo.jpg', null, null, '000007817990', '0');
INSERT INTO `user` VALUES ('3', '111', '111', 'admin', 'admin@139.com', '男', '2017年9月23日', '0', 'http://192.168.1.206:8080/SharedPPX/images/vlmqECyyMw.jpg', null, null, '000000000000', null);

-- ----------------------------
-- Table structure for userecord
-- ----------------------------
DROP TABLE IF EXISTS `userecord`;
CREATE TABLE `userecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startSite` varchar(255) DEFAULT NULL,
  `stopSite` varchar(255) DEFAULT NULL,
  `startTime` varchar(255) DEFAULT NULL,
  `stopTime` varchar(255) DEFAULT NULL,
  `duration` varchar(11) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `totalMoney` double(11,0) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  `x_id` int(11) DEFAULT NULL,
  `state` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `u_id` (`u_id`),
  KEY `x_id` (`x_id`),
  CONSTRAINT `u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`),
  CONSTRAINT `x_id` FOREIGN KEY (`x_id`) REFERENCES `xia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userecord
-- ----------------------------
INSERT INTO `userecord` VALUES ('1', '31.25784,120.749346', '31.259507,120.74953', '2017-10-06 15:22:10', '2017-10-06 15:22:47', '00:00:36', null, '0', '1', '5121001', '1');
INSERT INTO `userecord` VALUES ('2', '31.25784,120.749346', '31.259517,120.749505', '2017-10-06 17:44:33', '2017-10-06 17:50:22', '00:05:48', null, '270', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('3', '31.259517,120.749505', '31.259515,120.749507', '2017-10-06 17:51:54', '2017-10-06 17:52:10', '00:00:15', null, '0', '3', '5121001', '1');
INSERT INTO `userecord` VALUES ('4', '31.259515,120.749507', '31.259561,120.749052', '2017-10-09 09:29:19', '2017-10-09 16:15:58', '6:46:33', null, '21924', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('5', '31.259561,120.749052', '31.259583,120.749129', '2017-10-09 16:24:35', '2017-10-09 16:24:55', '00:00:06', null, '0', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('6', '31.259561,120.749052', '31.259369,120.749652', '2017-10-09 16:24:45', '2017-10-10 09:47:42', '17:22:53', null, '56268', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('7', '31.257829,120.749382', '31.259532,120.749098', '2017-10-09 16:26:42', '2017-10-09 16:27:35', '00:00:13', null, '0', '2', '5121002', '1');
INSERT INTO `userecord` VALUES ('8', '31.259369,120.749652', '31.259495,120.749531', '2017-10-11 13:45:00', '2017-10-11 13:46:03', '00:01:01', null, '54', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('9', '31.259495,120.749531', '31.259496,120.749549', '2017-10-11 15:10:44', '2017-10-11 15:11:50', '00:01:04', null, '54', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('14', '31.257865,120.749559', '31.259483,120.749544', '2017-10-11 17:00:47', '2017-10-11 17:06:46', '00:05:56', null, '270', '2', '5121003', '1');
INSERT INTO `userecord` VALUES ('15', '31.259483,120.749544', '31.259488,120.749541', '2017-10-11 17:09:00', '2017-10-11 17:09:13', '00:00:12', null, '0', '2', '5121003', '1');
INSERT INTO `userecord` VALUES ('16', '31.259318,120.748229', '31.259494,120.749533', '2017-10-12 10:13:38', '2017-10-13 22:17:01', '36:03:19', null, '2160837', '2', '5121005', '1');
INSERT INTO `userecord` VALUES ('17', '31.259496,120.749549', '31.259492,120.749535', '2017-10-13 22:19:21', '2017-10-13 22:20:26', '00:01:04', null, '54', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('18', '31.259492,120.749535', '31.259495,120.749534', '2017-10-13 22:23:23', '2017-10-13 22:58:50', '00:34:13', null, '1836', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('19', '31.259495,120.749534', '31.259497,120.749539', '2017-10-13 23:02:18', '2017-10-13 23:04:35', '00:02:15', null, '108', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('20', '31.260365,120.750211', '31.259535,120.749508', '2017-10-13 23:51:44', '2017-10-13 23:51:50', '00:00:05', null, '0', '2', '5121005', '1');
INSERT INTO `userecord` VALUES ('21', '31.259425,120.748218', '27.52998,109.942777', '2018-01-18 14:20:43', '2018-01-18 15:48:53', '1:27:43', null, '4698', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('57', '27.52998,109.942777', '37.422075,-122.084082', '2018-04-04 17:56:40', '2018-04-04 17:56:42', '00:01', '54.00', '0', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('58', '27.52998,109.942777', '37.422075,-122.084082', '2018-04-04 17:57:21', '2018-04-04 17:58:26', '01:04', '54.00', '54', '2', '5121001', '1');
INSERT INTO `userecord` VALUES ('59', '27.52998,109.942777', '27.529958,109.9428', '2018-04-08 09:37:29', '2018-04-08 11:10:37', '1:33:07', '54.00', '5022', '2', '5121001', '1');

-- ----------------------------
-- Table structure for xia
-- ----------------------------
DROP TABLE IF EXISTS `xia`;
CREATE TABLE `xia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` double(11,6) DEFAULT NULL,
  `longitude` double(11,6) DEFAULT NULL,
  `price` float(11,2) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7451050 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xia
-- ----------------------------
INSERT INTO `xia` VALUES ('5121001', '27.529980', '109.942777', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('5121002', '31.258036', '120.749737', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('5121003', '31.257031', '120.749812', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('5121004', '31.259443', '120.747596', '108.00', '1', '0');
INSERT INTO `xia` VALUES ('5121005', '31.259535', '120.749508', '999.00', '2', '0');
INSERT INTO `xia` VALUES ('7451000', '27.530957', '109.938896', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451001', '27.531371', '109.948117', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451002', '27.534119', '109.942689', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451003', '27.529243', '109.948155', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451004', '27.528295', '109.945909', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451005', '27.533763', '109.943802', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451006', '27.531441', '109.943570', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451007', '27.531879', '109.948396', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451008', '27.530625', '109.939513', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451009', '27.527032', '109.941655', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451010', '27.534262', '109.941618', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451011', '27.530077', '109.942104', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451012', '27.527928', '109.948850', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451013', '27.525765', '109.948229', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451014', '27.526597', '109.938365', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451015', '27.534081', '109.937871', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451016', '27.525833', '109.939799', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451017', '27.531501', '109.947738', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451018', '27.530774', '109.940929', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451019', '27.530990', '109.944985', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451020', '27.528373', '109.939177', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451021', '27.527683', '109.948646', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451022', '27.532870', '109.940044', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451023', '27.529010', '109.944770', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451024', '27.526154', '109.943637', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451025', '27.525960', '109.942713', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451026', '27.528071', '109.938463', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451027', '27.527358', '109.949120', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451028', '27.530707', '109.945625', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451029', '27.529862', '109.938402', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451030', '27.530040', '109.941321', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451031', '27.530688', '109.944441', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451032', '27.527216', '109.943800', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451033', '27.526869', '109.948192', '54.00', '0', '1');
INSERT INTO `xia` VALUES ('7451034', '27.534522', '109.948468', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451035', '27.531374', '109.944268', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451036', '27.525763', '109.945092', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451037', '27.532209', '109.949086', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451038', '27.528506', '109.945943', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451039', '27.529079', '109.943074', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451040', '27.533833', '109.945610', '54.00', '0', '1');
INSERT INTO `xia` VALUES ('7451041', '27.530196', '109.941155', '54.00', '0', '1');
INSERT INTO `xia` VALUES ('7451042', '27.530663', '109.942281', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451043', '27.533426', '109.943176', '54.00', '0', '1');
INSERT INTO `xia` VALUES ('7451044', '27.526824', '109.948906', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451045', '27.529742', '109.946569', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451046', '27.534145', '109.938455', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451047', '27.533792', '109.944263', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451048', '27.531484', '109.946076', '54.00', '0', '0');
INSERT INTO `xia` VALUES ('7451049', '27.530404', '109.942732', '54.00', '0', '0');
