/*
SQLyog Trial v12.2.1 (64 bit)
MySQL - 5.6.34 : Database - yzc_manager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yzc_manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yzc_manager`;

/*Table structure for table `yzc_born_record` */

DROP TABLE IF EXISTS `yzc_born_record`;

CREATE TABLE `yzc_born_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bor_time` date DEFAULT NULL COMMENT '出生日期',
  `bor_count` int(11) DEFAULT NULL COMMENT '产量',
  `bor_live_count` int(11) DEFAULT NULL COMMENT '存活量',
  `bor_pre_id` int(11) DEFAULT NULL COMMENT '怀孕编号(yzc_pregnant_record的主键pre_id)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='出生记录表';

/*Data for the table `yzc_born_record` */

insert  into `yzc_born_record`(`id`,`bor_time`,`bor_count`,`bor_live_count`,`bor_pre_id`) values 
(1,'2017-05-03',20,19,2),
(2,'2017-05-10',18,18,9),
(3,'2017-04-30',20,16,10);

/*Table structure for table `yzc_breed_record` */

DROP TABLE IF EXISTS `yzc_breed_record`;

CREATE TABLE `yzc_breed_record` (
  `bre_id` int(11) NOT NULL AUTO_INCREMENT,
  `bre_time` date DEFAULT NULL COMMENT '配种时间',
  `bre_mo_ear` int(11) DEFAULT NULL COMMENT '配种母耳号（yzc_pig表主键pig_id）',
  `bre_fa_ear` int(11) DEFAULT NULL COMMENT '配种父耳号（yzc_pig表主键pig_id）',
  PRIMARY KEY (`bre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='配种记录表';

/*Data for the table `yzc_breed_record` */

insert  into `yzc_breed_record`(`bre_id`,`bre_time`,`bre_mo_ear`,`bre_fa_ear`) values 
(1,'2017-05-01',7,2),
(2,'2017-04-20',8,3),
(3,'2017-04-01',9,5),
(4,'2017-04-01',10,3);

/*Table structure for table `yzc_class` */

DROP TABLE IF EXISTS `yzc_class`;

CREATE TABLE `yzc_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cla_gra_id` int(11) DEFAULT NULL COMMENT '猪舍号(yzc_grade表主键gra_id)',
  `cla_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '栏名称',
  `cla_eara` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '面积',
  `cla_breeder` int(11) DEFAULT NULL COMMENT '饲养员id(yzc_employee表主键emp_id)',
  `cla_is_intact` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '是否完好',
  `cla_desc` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='猪栏';

/*Data for the table `yzc_class` */

insert  into `yzc_class`(`id`,`cla_gra_id`,`cla_name`,`cla_eara`,`cla_breeder`,`cla_is_intact`,`cla_desc`) values 
(1,1,'天字号1','30',3,'完好','提供成长猪成长的5星级猪栏，一般小猪放在生长这里'),
(2,2,'育肥天栏','30',4,'完好','育肥的好地方，饲养即将出售的育肥猪'),
(3,4,'妊娠猪栏','20',5,'完好','给妊娠猪提供的住所，即将分娩的猪的住所'),
(4,6,'育种猪栏','50',6,'完好','提供给后备猪（育种猪）的住所，就是种猪的住所'),
(5,8,'分娩猪栏','20',7,'完好','提供给正在分娩期间的母猪的住所');

/*Table structure for table `yzc_clean_record` */

DROP TABLE IF EXISTS `yzc_clean_record`;

CREATE TABLE `yzc_clean_record` (
  `cle_id` int(11) NOT NULL AUTO_INCREMENT,
  `cle_time` date DEFAULT NULL COMMENT '时间',
  `cle_cla_id` int(11) DEFAULT NULL COMMENT '猪栏（yzc_class表主键id）',
  `cle_emp_id` int(11) DEFAULT NULL COMMENT '打扫人员（yzc_employee表主键emp_id）',
  `cle_desc` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`cle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='打扫记录表';

/*Data for the table `yzc_clean_record` */

/*Table structure for table `yzc_deal_pig` */

DROP TABLE IF EXISTS `yzc_deal_pig`;

CREATE TABLE `yzc_deal_pig` (
  `deal_id` int(11) NOT NULL AUTO_INCREMENT,
  `deal_time` date DEFAULT NULL COMMENT '日期',
  `deal_price` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '单价',
  `deal_weight` double DEFAULT NULL COMMENT '重量',
  `deal_ear` int(11) DEFAULT NULL COMMENT '耳号（yzc_pig表主键pig_id）',
  `order_uuid` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '订单号（yzc_orders表主键uuid）',
  `deal_buy_sell` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '（购入，卖出）',
  PRIMARY KEY (`deal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='猪买卖记录表';

/*Data for the table `yzc_deal_pig` */

insert  into `yzc_deal_pig`(`deal_id`,`deal_time`,`deal_price`,`deal_weight`,`deal_ear`,`order_uuid`,`deal_buy_sell`) values 
(1,'2017-05-02','20',150,6,'f0ac5fab2b7240af9907ef75874b17ac','购入'),
(2,'2017-05-02','20',156,7,'92ebbc37d3f94b48bf79e5342943b3c0','购入'),
(3,'2017-05-02','20',100,3,'92ebbc37d3f94b48bf79e5342943b3c0','购入'),
(4,'2017-05-10','20',200,15,'f0a6584b907f4595bdac0bd325229bce','卖出');

/*Table structure for table `yzc_death_record` */

DROP TABLE IF EXISTS `yzc_death_record`;

CREATE TABLE `yzc_death_record` (
  `dea_id` int(11) NOT NULL AUTO_INCREMENT,
  `dea_ear` int(11) DEFAULT NULL COMMENT '耳号（yzc_pig表主键pig_id）',
  `dea_time` date DEFAULT NULL COMMENT '日期',
  `dea_reason` text COLLATE utf8_bin COMMENT '死亡原因',
  `dea_rec_peo` int(11) DEFAULT NULL COMMENT '处理人员（yzc_employee表主键emp_id）',
  PRIMARY KEY (`dea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='死亡记录表';

/*Data for the table `yzc_death_record` */

insert  into `yzc_death_record`(`dea_id`,`dea_ear`,`dea_time`,`dea_reason`,`dea_rec_peo`) values 
(1,1,'2017-05-01','意外，摔死了',3),
(2,13,'2017-05-02','出生猝死',4),
(3,14,'2017-05-12','饿死了',6);

/*Table structure for table `yzc_department` */

DROP TABLE IF EXISTS `yzc_department`;

CREATE TABLE `yzc_department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名称',
  `dept_desc` text COLLATE utf8_bin COMMENT '描述',
  `dept_pare_id` int(11) DEFAULT NULL COMMENT '父id',
  `dept_state` int(11) DEFAULT '1' COMMENT '状态(0,1)',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='部门表';

/*Data for the table `yzc_department` */

insert  into `yzc_department`(`dept_id`,`dept_name`,`dept_desc`,`dept_pare_id`,`dept_state`) values 
(1,'养殖部','管养猪',-1,1),
(2,'管理部','管养猪以外',-1,1),
(3,'高层','查看报表',-1,1),
(4,'人事部','管理员工、部门',-1,1),
(5,'系统管理','管理设置本系统的相关参数',-1,1),
(6,'超级管理','具有所有权限',-1,1);

/*Table structure for table `yzc_employee` */

DROP TABLE IF EXISTS `yzc_employee`;

CREATE TABLE `yzc_employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_account` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '账号',
  `emp_pwd` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `emp_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `emp_sex` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `emp_birth` date DEFAULT NULL COMMENT '生日',
  `emp_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `emp_email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `emp_in_date` date DEFAULT NULL COMMENT '入职日期',
  `emp_desc` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `emp_dept_id` int(11) DEFAULT NULL COMMENT '部门（yzc_department表主键dept_id）',
  `emp_manager` int(1) DEFAULT '0',
  `emp_state` int(11) DEFAULT '1' COMMENT '状态（0，1）',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工人员表';

/*Data for the table `yzc_employee` */

insert  into `yzc_employee`(`emp_id`,`emp_account`,`emp_pwd`,`emp_name`,`emp_sex`,`emp_birth`,`emp_phone`,`emp_email`,`emp_in_date`,`emp_desc`,`emp_dept_id`,`emp_manager`,`emp_state`) values 
(1,'admin','21232f297a57a5a743894a0e4a801fc3','超级管理','保密','1999-01-01','18780272765','784727590@qq.com','1999-01-01','管理员，系统初始化就存在的账号',6,1,1),
(2,'wangfj','e10adc3949ba59abbe56e057f20f883e','王富杰','男','1995-01-01','18780272765','784727590@qq.com','2017-05-01','ss',2,0,1),
(3,'yangzhi_1','e10adc3949ba59abbe56e057f20f883e','饲养员1','女','1990-05-09','13112345678','sdasf@qq.com','2017-05-01','什么都没有描述啊大神大神发法',1,0,1),
(4,'yangzhi_2','e10adc3949ba59abbe56e057f20f883e','饲养员2','女','1993-01-04','18712345678','safseidj@qds.com','2017-05-01','ds',1,0,1),
(5,'yangzhi_3','e10adc3949ba59abbe56e057f20f883e','饲养员3','男','2017-05-01','18712345678','safsef@qq.com','2017-05-01','sad',1,0,1),
(6,'yangzhi_4','e10adc3949ba59abbe56e057f20f883e','饲养员4','男','2017-05-02','18712345678','sjhkjh@qq.com','2017-05-01','sad',1,0,1),
(7,'yangzhi_5','e10adc3949ba59abbe56e057f20f883e','饲养员5','男','2017-05-03','18712345678','sdf@qq.com','2017-05-01','sad',1,0,1),
(8,'gaochen_1','e10adc3949ba59abbe56e057f20f883e','高层','男','2017-05-02','13165132498','safsdf@qq.com','2017-05-02','犯得上额',3,0,1),
(9,'renshi_1','e10adc3949ba59abbe56e057f20f883e','人事','男','2017-05-01','13145616512','856413986@qq.com','2017-05-01','人力资源',4,0,1);

/*Table structure for table `yzc_feed_record` */

DROP TABLE IF EXISTS `yzc_feed_record`;

CREATE TABLE `yzc_feed_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fee_time` date DEFAULT NULL COMMENT '时间',
  `fee_class` int(50) DEFAULT NULL COMMENT '栏号（yzc_class表主键id）',
  `fee_count` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '饲料量',
  `fee_fes_id` int(11) DEFAULT NULL COMMENT '饲料编号（yzc_feeds表主键fes_id）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='喂养记录';

/*Data for the table `yzc_feed_record` */

insert  into `yzc_feed_record`(`id`,`fee_time`,`fee_class`,`fee_count`,`fee_fes_id`) values 
(1,'2017-05-02',1,'50',1);

/*Table structure for table `yzc_feeds` */

DROP TABLE IF EXISTS `yzc_feeds`;

CREATE TABLE `yzc_feeds` (
  `fes_id` int(11) NOT NULL AUTO_INCREMENT,
  `fes_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `fes_price` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '价格',
  `fes_par_id` int(11) DEFAULT NULL COMMENT '供应商(yzc_partner表par_id)',
  PRIMARY KEY (`fes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='饲料表';

/*Data for the table `yzc_feeds` */

insert  into `yzc_feeds`(`fes_id`,`fes_name`,`fes_price`,`fes_par_id`) values 
(1,'通威','100',NULL),
(2,'新希望','200',NULL),
(3,'巨星','100',NULL),
(4,'巨星2','100',NULL);

/*Table structure for table `yzc_grade` */

DROP TABLE IF EXISTS `yzc_grade`;

CREATE TABLE `yzc_grade` (
  `gra_id` int(11) NOT NULL AUTO_INCREMENT,
  `gra_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '猪舍名称',
  `gra_class_num` int(11) DEFAULT NULL COMMENT '猪栏数量',
  `gra_desc` text COLLATE utf8_bin COMMENT '描述',
  `gra_admin` int(11) DEFAULT NULL COMMENT '舍长（猪舍管理员）（yzc_employee表主键emp_id）',
  `gra_build_time` date DEFAULT NULL COMMENT '建立日期',
  PRIMARY KEY (`gra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='猪舍';

/*Data for the table `yzc_grade` */

insert  into `yzc_grade`(`gra_id`,`gra_name`,`gra_class_num`,`gra_desc`,`gra_admin`,`gra_build_time`) values 
(1,'生长舍',100,'生长猪',2,'2016-09-27'),
(2,'育肥舍',100,'育肥猪',NULL,'2016-09-27'),
(3,'保育舍',100,'保育猪',NULL,'2016-10-26'),
(4,'妊娠舍',100,'妊娠母猪',NULL,'2016-08-16'),
(5,'空怀舍',100,'配种母猪',NULL,'2016-10-01'),
(6,'后备舍',100,'后备母猪',NULL,'2016-07-06'),
(7,'公猪舍',100,'种公猪',NULL,'2016-09-07'),
(8,'产仔舍',100,'分娩母猪',NULL,'2016-02-26'),
(9,'产1',100,'产1',NULL,'2016-10-16');

/*Table structure for table `yzc_ill_record` */

DROP TABLE IF EXISTS `yzc_ill_record`;

CREATE TABLE `yzc_ill_record` (
  `ill_id` int(11) NOT NULL AUTO_INCREMENT,
  `ill_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '疾病名称',
  `ill_ear` int(11) DEFAULT NULL COMMENT '生病猪耳号（yzc_pig表主键pig_id）',
  `ill_time` date DEFAULT NULL COMMENT '生病时间',
  `ill_med_list` text COLLATE utf8_bin COMMENT '药方',
  `ill_doctor` int(11) DEFAULT NULL COMMENT '开药人员（yzc_employee表主键emp_id）',
  `ill_desc` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`ill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='病历表';

/*Data for the table `yzc_ill_record` */

insert  into `yzc_ill_record`(`ill_id`,`ill_name`,`ill_ear`,`ill_time`,`ill_med_list`,`ill_doctor`,`ill_desc`) values 
(1,'腹泻',3,'2017-05-01','藿香正气液，两桶',5,'试试');

/*Table structure for table `yzc_medicine_record` */

DROP TABLE IF EXISTS `yzc_medicine_record`;

CREATE TABLE `yzc_medicine_record` (
  `med_rec_id` int(11) NOT NULL AUTO_INCREMENT,
  `med_rec_time` date DEFAULT NULL COMMENT '用药时间',
  `med_rec_count` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '药品量',
  `med_rec_mec_id` int(11) DEFAULT NULL COMMENT '药品编号',
  `med_rec_fee_id` int(11) DEFAULT NULL COMMENT '喂养记录编号(yzc_feed_record主键id)',
  `med_rec_ill_id` int(11) DEFAULT NULL COMMENT '病例表号（yzc_ill_record表主键ill_id）',
  `med_rec_money` decimal(10,0) DEFAULT NULL COMMENT '花费',
  PRIMARY KEY (`med_rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用药记录表';

/*Data for the table `yzc_medicine_record` */

/*Table structure for table `yzc_orders` */

DROP TABLE IF EXISTS `yzc_orders`;

CREATE TABLE `yzc_orders` (
  `uuid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'uuid',
  `order_date` date DEFAULT NULL COMMENT '订单日期',
  `order_sub` decimal(10,0) DEFAULT NULL COMMENT '总计',
  `order_sup` int(11) DEFAULT NULL COMMENT '合作商（yzc_partner表主键par_id）',
  `order_emp` int(11) DEFAULT NULL COMMENT '采购人员（yzc_employee表主键emp_id）',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单记录表';

/*Data for the table `yzc_orders` */

insert  into `yzc_orders`(`uuid`,`order_date`,`order_sub`,`order_sup`,`order_emp`) values 
('242fded69e8249bea98ed850b4894a39','2017-05-01','4000',4,2),
('7cdcd8d6a3084d69873510b30473bc1b','2017-05-01','5000',6,2),
('8f48c305dbf54d1586a1d64e964338ee','2017-05-02','8000',4,2),
('92ebbc37d3f94b48bf79e5342943b3c0','2017-05-02','5120',4,2),
('f0a6584b907f4595bdac0bd325229bce','2017-05-10','4000',2,5),
('f0ac5fab2b7240af9907ef75874b17ac','2017-05-01','3000',4,2);

/*Table structure for table `yzc_partner` */

DROP TABLE IF EXISTS `yzc_partner`;

CREATE TABLE `yzc_partner` (
  `par_id` int(11) NOT NULL AUTO_INCREMENT,
  `par_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '合作商名称',
  `par_address` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `par_phone` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `par_email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `par_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '种类',
  `par_state` int(11) DEFAULT '1' COMMENT '状态（0，1）',
  PRIMARY KEY (`par_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='合作商';

/*Data for the table `yzc_partner` */

insert  into `yzc_partner`(`par_id`,`par_name`,`par_address`,`par_phone`,`par_email`,`par_type`,`par_state`) values 
(1,'富杰大酒店','成都市高新区','13112345678','jiudain@faxmail.com','酒店',1),
(2,'高新美食城','成都武侯区','13145678942','54d9689@qq.com','美食',1),
(3,'人民农家乐','成都双流县某村落','028-77625374','renming@fsa.com','农家乐',1),
(4,'阿米巴巴','成都高新孵化园','15228786951','1522879518@qq.com','快捷餐厅',1),
(5,'龙门客栈','成都建设路','18782459567','longmen@faxmail.com','火锅店',1),
(6,'百货大厦','成都武侯','18780245249','baihuo@faxmail.com','百货',1);

/*Table structure for table `yzc_pig` */

DROP TABLE IF EXISTS `yzc_pig`;

CREATE TABLE `yzc_pig` (
  `pig_id` int(11) NOT NULL AUTO_INCREMENT,
  `pig_ear_num` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '耳号',
  `pig_sex` varchar(10) COLLATE utf8_bin DEFAULT '' COMMENT '性别',
  `pig_class` int(11) DEFAULT NULL COMMENT '栏号',
  `pig_fa_ear` int(11) DEFAULT NULL COMMENT '父耳号（yzc_pig表主键pig_id）',
  `pig_mo_ear` int(11) DEFAULT NULL COMMENT '母耳号（yzc_pig表主键pig_id）',
  `pig_source` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '来源（自繁，购入）',
  `pig_birth` date DEFAULT NULL COMMENT '出生日期',
  `pig_weight` double DEFAULT NULL COMMENT '重量',
  `pig_dn_weight` double DEFAULT NULL COMMENT '断奶重量',
  `pig_enter_time` date DEFAULT NULL COMMENT '进场日期',
  `pig_level` int(11) DEFAULT NULL COMMENT '品级评定',
  `pig_letf_nipples` int(11) DEFAULT NULL COMMENT '左奶头数',
  `pig_right_nipples` int(11) DEFAULT NULL COMMENT '右奶头数',
  `pig_is_spay` int(11) DEFAULT '0' COMMENT '是否阉割',
  `pig_health` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '健康状态',
  `pig_out_time` date DEFAULT NULL COMMENT '淘汰日期',
  `pig_type_id` int(11) DEFAULT NULL COMMENT '品种（yzc_variety表主键var_id）',
  `pig_step_id` int(11) DEFAULT NULL COMMENT '阶段（yzc_step表主键id）',
  `pig_desc` text COLLATE utf8_bin NOT NULL COMMENT '描述（备注）',
  `pig_is_dead` int(1) DEFAULT '1' COMMENT '是否死亡（0，1）',
  PRIMARY KEY (`pig_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='猪表';

/*Data for the table `yzc_pig` */

insert  into `yzc_pig`(`pig_id`,`pig_ear_num`,`pig_sex`,`pig_class`,`pig_fa_ear`,`pig_mo_ear`,`pig_source`,`pig_birth`,`pig_weight`,`pig_dn_weight`,`pig_enter_time`,`pig_level`,`pig_letf_nipples`,`pig_right_nipples`,`pig_is_spay`,`pig_health`,`pig_out_time`,`pig_type_id`,`pig_step_id`,`pig_desc`,`pig_is_dead`) values 
(1,'boar001','公猪',1,NULL,NULL,'购入','2016-05-01',50,20,'2017-05-01',3,NULL,NULL,0,'健康',NULL,1,10,'',0),
(2,'boar002','公猪',1,NULL,NULL,'购入','2015-12-29',50,20,'2017-05-01',3,NULL,NULL,0,'健康',NULL,1,10,'',1),
(3,'boar003','公猪',1,NULL,NULL,'购入','2017-05-02',150,20,'2017-04-30',3,NULL,NULL,1,'健康',NULL,2,12,'rfg',1),
(4,'boar004','公猪',2,NULL,NULL,'购入','2017-05-01',150,20,'2017-05-01',3,NULL,NULL,1,'健康',NULL,2,12,'刚发',1),
(5,'boar005','公猪',2,NULL,NULL,'购入','2017-05-02',150,20,'2017-05-01',3,NULL,NULL,0,'亚健康',NULL,1,1,'sd',1),
(6,'boar006','公猪',4,NULL,NULL,'购入','2017-05-01',130,20,'2017-05-01',1,NULL,NULL,1,'健康',NULL,1,8,'',1),
(7,'sow001','母猪',4,NULL,NULL,'购入','2017-05-01',150,20,'2017-05-01',1,10,10,0,'健康',NULL,1,9,'',1),
(8,'sow002','母猪',4,NULL,NULL,'购入','2017-05-01',200,20,'2017-05-01',3,20,20,0,'健康',NULL,2,9,'j',1),
(9,'sow003','母猪',4,NULL,NULL,'购入','2017-05-02',200,20,'2017-05-01',3,20,20,0,'健康',NULL,2,9,'',1),
(10,'sow004','母猪',4,NULL,NULL,'购入','2017-05-02',100,10,'2017-05-01',2,10,11,0,'健康',NULL,6,9,'',1),
(11,'baoyu001','公猪',4,NULL,NULL,'购入','2017-01-31',100,20,'2017-04-06',3,NULL,NULL,0,'健康',NULL,2,1,'',1),
(12,'baoyun002','公猪',4,NULL,NULL,'购入','2017-05-01',120,21,'2017-04-05',2,NULL,NULL,0,'健康',NULL,5,1,'',1),
(13,'sizhu001','公猪',2,3,7,'自繁','2017-05-02',10,0,'2017-05-02',2,NULL,NULL,0,'亚健康',NULL,3,6,'',0),
(14,'sizhu002','公猪',1,NULL,NULL,'购入','2017-05-01',130,20,'2017-05-02',2,NULL,NULL,0,'健康',NULL,6,12,'11',0),
(15,'seal_mai001','公猪',2,NULL,NULL,'自繁','2017-05-09',200,20,'2017-05-03',3,NULL,NULL,1,'健康',NULL,2,12,'df',1);

/*Table structure for table `yzc_pregnant_record` */

DROP TABLE IF EXISTS `yzc_pregnant_record`;

CREATE TABLE `yzc_pregnant_record` (
  `pre_id` int(11) NOT NULL AUTO_INCREMENT,
  `pre_found_pre` date DEFAULT NULL COMMENT '怀孕日期',
  `pre_bre_id` int(11) DEFAULT NULL COMMENT '配种表(yzc_breed_record表主键bre_id)',
  PRIMARY KEY (`pre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='怀孕记录表';

/*Data for the table `yzc_pregnant_record` */

insert  into `yzc_pregnant_record`(`pre_id`,`pre_found_pre`,`pre_bre_id`) values 
(2,'2017-05-03',1),
(3,'2017-05-11',1),
(9,'2017-04-21',3),
(10,'2017-04-10',4);

/*Table structure for table `yzc_purchase_record` */

DROP TABLE IF EXISTS `yzc_purchase_record`;

CREATE TABLE `yzc_purchase_record` (
  `pur_id` int(11) NOT NULL AUTO_INCREMENT,
  `pur_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '采购物品',
  `pur_price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `pur_count` decimal(10,2) DEFAULT NULL COMMENT '采购数',
  `pur_unit` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '单位',
  `pur_total` decimal(10,2) DEFAULT NULL COMMENT '总计',
  `order_uuid` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '订单号（yzc_orders表主键uuid）',
  PRIMARY KEY (`pur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='采购详情记录表';

/*Data for the table `yzc_purchase_record` */

insert  into `yzc_purchase_record`(`pur_id`,`pur_name`,`pur_price`,`pur_count`,`pur_unit`,`pur_total`,`order_uuid`) values 
(1,'猪槽','50.00','100.00',NULL,'5000.00','7cdcd8d6a3084d69873510b30473bc1b');

/*Table structure for table `yzc_repair_record` */

DROP TABLE IF EXISTS `yzc_repair_record`;

CREATE TABLE `yzc_repair_record` (
  `rep_id` int(11) NOT NULL AUTO_INCREMENT,
  `rep_cla_id` int(11) DEFAULT NULL COMMENT '栏号（yzc_class表主键id）',
  `rep_desc` text COLLATE utf8_bin COMMENT '描述',
  `rep_found_tine` date DEFAULT NULL COMMENT '发现破损时间',
  `rep_time` date DEFAULT NULL COMMENT '维修时间',
  `rep_result` text COLLATE utf8_bin COMMENT '维修结果',
  `rep_emp_id` int(11) DEFAULT NULL COMMENT '维修人员（yzc_employee表主键emp_id）',
  `rep_spend` decimal(50,0) DEFAULT NULL COMMENT '花费金额',
  PRIMARY KEY (`rep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='维修记录表';

/*Data for the table `yzc_repair_record` */

/*Table structure for table `yzc_step` */

DROP TABLE IF EXISTS `yzc_step`;

CREATE TABLE `yzc_step` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `step_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '阶段名称',
  `step_period` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '日期',
  `step_desc` text COLLATE utf8_bin COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='生长阶段';

/*Data for the table `yzc_step` */

insert  into `yzc_step`(`id`,`step_name`,`step_period`,`step_desc`) values 
(1,'后备期','90-配种','准备养为种猪生长期间,90-配种'),
(2,'妊娠前期','28','怀孕的前期，此期母猪对日粮能量、蛋白营养的要求不高，只要求一日2餐，吃饱为止。'),
(3,'妊娠中期','55','怀孕中期'),
(4,'妊娠后期','20','怀孕后期，到产前7天这个期间'),
(5,'产前7天','7','产仔前7天'),
(6,'哺乳期','28','仔猪出生至断乳阶段'),
(7,'空怀期','断奶-配种','小猪断奶后母猪就是空怀期的开始，直到下次配种这前这段时间就是母猪的空怀期'),
(8,'种公猪','配种期','用来配种的公猪'),
(9,'保育猪','20','仔猪断奶至保育结束这一阶段'),
(10,'小猪期','30','仔猪保育结束进入生长舍饲养，的小猪阶段'),
(11,'中猪期','40','仔猪保育结束进入生长舍饲养，的中猪阶段'),
(12,'大猪期','40','仔猪保育结束进入生长舍饲养，的大猪阶段');

/*Table structure for table `yzc_variety` */

DROP TABLE IF EXISTS `yzc_variety`;

CREATE TABLE `yzc_variety` (
  `var_id` int(11) NOT NULL AUTO_INCREMENT,
  `var_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '品种名称',
  `var_desc` text COLLATE utf8_bin COMMENT '品种描述',
  PRIMARY KEY (`var_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='品种表';

/*Data for the table `yzc_variety` */

insert  into `yzc_variety`(`var_id`,`var_name`,`var_desc`) values 
(1,'杜洛克','杜洛克原产于原产于美国东部的新泽西州和纽约州等地，主要亲本用纽约州的杜洛克和新泽西州的泽西红杂交育成，原称杜洛克泽西，后筒称杜洛克，分为美系和加系杜洛克；产于我国台湾的杜洛克经过培育自成风格，因而称台湾杜洛克或台系杜洛克'),
(2,'大白猪','又叫做“大约克猪”。原产于英国，特称为“英国大白猪”。输入苏联后，经过长期风土驯化和培育，成为“苏联大白猪”。后者的体躯比前者结实、粗壮，四肢强健有力，适于放牧。十八世纪于英国育成。 　　约克夏猪是猪的一个着名品种。原产于英国约克郡（Yorkshire，英格兰东北部的一个旧郡，一九七四年分割为North Yorkshire，South Yorkshire及West Yorkshire），由当地猪与中国猪等杂交育成。全身白色，耳向前挺立。有大、中、小三种，分别称为“大白猪”、“中白猪”和“小白猪”。大白猪属腌肉型，为全世界分布最广的猪种。体长大，成年公猪体重三百至五百公斤，母猪两百至三百五十公斤。繁殖力强，每胎产仔十到十二头。小白猪早熟易肥，属脂肪型。中白猪体型介于两者之间，属肉用型。中国饲养大白猪较多。'),
(3,'长白猪','是“兰德瑞斯（Landrace）猪”在中国的通称。着名腌肉型猪品种。原产于丹麦。由当地猪与大白猪杂交育成。全身白色。体驱特长，呈流线型。头狭长、耳大前垂，背腰平直，后躯发达，大腿丰满，四肢较高。生长快，饲料利用率高。皮薄、瘦肉多。每胎产仔十一至十二头。成年公猪体重四百到五百公斤，母猪三百公斤左右。要求有较好的饲养管理条件。遍布于世界各国。'),
(4,'汉普夏母猪','是着名肉用型猪品种。十九世纪初期由英国汉普夏（Hampshire，一译汉普郡）输往美国后，在肯塔基州（Kentucky）经杂交选育而成。毛色黑，肩颈接合部和前肢白色。鼻面稍长而直，正竖立。体躯较长，肌肉发达。成年公猪体重三百一十五至四百一十公斤，母猪两百五十至三百四十公斤。早熟性，繁殖力中等，平均每胎产仔八头。母性强。屠体品质高，瘦肉比例大。'),
(5,'波中猪','为猪的着名品种。原产于美国。由中国猪、俄国猪、英国猪等杂交而成。原属脂肪型，已培育为肉用型。全身黑色，有六白的特征。鼻面直，耳半下垂。体型大，成年公猪体重三百九十至四百五十公斤，母猪三百至四百公斤。早熟易肥，屠体品质优良；但繁殖力较弱，每胎性仔八头左右'),
(6,'马身猪','马身猪原产于中国。山西， 体型较大，耳大、下垂超过鼻端，嘴筒长直，背腰平直狭窄，臀部倾斜，四肢坚实有力，皮、毛黑色，皮厚，毛粗而密，冬季密生棕红色绒毛，乳头7～10对。可分为“大马身猪”（大）、“二马身猪”（中）和“钵盂猪”（小）三型。 虽生长速度较慢，但胴体瘦肉率较高'),
(7,'皮特兰猪','皮特兰猪原产于比利时的布拉帮特省，是由法国的贝叶杂交猪与英国的巴克夏猪进行回交，然后再与英国的大白猪杂交育成的。主要特点是瘦肉率高，后驱和双肩肌肉丰满。');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



/*视图创建*/
-- pro_sowinfo
CREATE
    VIEW `pro_sowinfo` 
    AS
(SELECT DISTINCT p.pig_id,p.pig_ear_num,g.gra_name,c.cla_name,
  COUNT(b.bre_id) AS btime,COUNT(t.pre_id) AS ptime,
  CONCAT(CAST((COALESCE(ROUND((COUNT(t.pre_id) / COUNT(b.bre_id)),2),0) * 100) AS CHAR CHARSET utf8),'%') AS crate,
  SUM(n.bor_count) AS scount,
  CONCAT(CAST((COALESCE(ROUND((SUM(n.bor_live_count) / SUM(n.bor_count)),2),0) * 100) AS CHAR CHARSET utf8),'%') AS lrate
FROM yzc_breed_record b 
JOIN yzc_pig p ON p.pig_id = b.bre_mo_ear
JOIN yzc_class c ON p.pig_class = c.id
JOIN yzc_grade g ON c.cla_gra_id = g.gra_id
JOIN yzc_pregnant_record t ON b.bre_id = t.pre_bre_id
JOIN yzc_born_record n ON n.bor_pre_id = t.pre_id
WHERE p.pig_sex = '母猪'
GROUP BY p.pig_id);

-- pig_count
CREATE
    VIEW `pig_count` 
    AS
(SELECT o.uuid,p.par_name,o.order_date,o.order_sub,e.emp_name,
  COUNT(d.deal_id) AS pig_num,SUM(d.deal_weight) AS sum_weight
FROM yzc_orders o
LEFT JOIN yzc_deal_pig d ON o.uuid = d.order_uuid
LEFT JOIN yzc_partner p ON p.par_id = o.order_sup
LEFT JOIN yzc_employee e ON e.emp_id = o.order_emp
WHERE d.deal_buy_sell = '卖出'
GROUP BY o.uuid); 