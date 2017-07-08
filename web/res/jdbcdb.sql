# Host: localhost  (Version: 5.5.40)
# Date: 2017-04-15 17:35:46
# Generator: MySQL-Front 5.3  (Build 4.128)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "hibernate_sequences"
#

DROP TABLE IF EXISTS `hibernate_sequences`;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "hibernate_sequences"
#


#
# Structure for table "leader"
#

DROP TABLE IF EXISTS `leader`;
CREATE TABLE `leader` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "leader"
#

INSERT INTO `leader` VALUES (1,'hwh1',221),(2,'hwh2',222),(3,'hwh3',223),(4,'hwh4',224),(5,'hwh1',221),(6,'hwh2',222),(7,'hwh3',223),(8,'hwh4',224);

#
# Structure for table "movie"
#

DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `MovieName` varchar(255) DEFAULT NULL,
  `MovieLink` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "movie"
#


#
# Structure for table "orders"
#

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` varchar(100) DEFAULT NULL,
  `persionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "orders"
#

INSERT INTO `orders` VALUES (1,'等等',1);

#
# Structure for table "person"
#

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "person"
#

INSERT INTO `person` VALUES (1,'beini');

#
# Structure for table "t_user"
#

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_age` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_user"
#

