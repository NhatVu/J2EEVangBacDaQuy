CREATE DATABASE  IF NOT EXISTS `vangbacdaquy` default character set utf8 /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `vangbacdaquy`;
-- MySQL dump 10.13  Distrib 5.5.55, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: vangbacdaquy
-- ------------------------------------------------------
-- Server version	5.5.55-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CTP_BANHANG`
--

DROP TABLE IF EXISTS `CTP_BANHANG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CTP_BANHANG` (
  `MACTP_BH` int(11) NOT NULL,
  `MAP_BH` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `THANHTIEN` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MACTP_BH`),
  KEY `FK_CTP_BANHANG` (`MASP`),
  KEY `FK_CTP_BANHANG2` (`MAP_BH`),
  CONSTRAINT `FK_CTP_BANHANG` FOREIGN KEY (`MASP`) REFERENCES `SANPHAM` (`MASP`),
  CONSTRAINT `FK_CTP_BANHANG2` FOREIGN KEY (`MAP_BH`) REFERENCES `P_BANHANG` (`MAP_BH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CTP_BANHANG`
--

LOCK TABLES `CTP_BANHANG` WRITE;
/*!40000 ALTER TABLE `CTP_BANHANG` DISABLE KEYS */;
INSERT INTO `CTP_BANHANG` VALUES (1,1,1,2,30000.000),(2,1,3,1,5000.000),(3,2,2,2,6000.000),(4,2,1,2,30000.000),(5,3,1,1,15000.000),(6,4,1,1,15000.000),(7,4,2,1,3000.000),(8,5,1,2,30000.000),(9,5,2,1,3000.000);
/*!40000 ALTER TABLE `CTP_BANHANG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CTP_DICHVU`
--

DROP TABLE IF EXISTS `CTP_DICHVU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CTP_DICHVU` (
  `MACTP_DV` int(11) NOT NULL,
  `MAP_DV` int(11) NOT NULL,
  `MADV` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `THANHTIEN` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MACTP_DV`),
  KEY `FK_CTP_DICHVU` (`MADV`),
  KEY `FK_CTP_DICHVU2` (`MAP_DV`),
  CONSTRAINT `FK_CTP_DICHVU` FOREIGN KEY (`MADV`) REFERENCES `DICHVU` (`MADV`),
  CONSTRAINT `FK_CTP_DICHVU2` FOREIGN KEY (`MAP_DV`) REFERENCES `P_DICHVU` (`MAP_DV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CTP_DICHVU`
--

LOCK TABLES `CTP_DICHVU` WRITE;
/*!40000 ALTER TABLE `CTP_DICHVU` DISABLE KEYS */;
/*!40000 ALTER TABLE `CTP_DICHVU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CTP_GIACONG`
--

DROP TABLE IF EXISTS `CTP_GIACONG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CTP_GIACONG` (
  `MACTP_GC` int(11) NOT NULL,
  `MAP_GC` int(11) NOT NULL,
  `MALOAIGC` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `THANHTIEN` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MACTP_GC`),
  KEY `FK_CTP_GIACONG` (`MALOAIGC`),
  KEY `FK_CTP_GIACONG2` (`MAP_GC`),
  CONSTRAINT `FK_CTP_GIACONG` FOREIGN KEY (`MALOAIGC`) REFERENCES `HANGGIACONG` (`MALOAIGC`),
  CONSTRAINT `FK_CTP_GIACONG2` FOREIGN KEY (`MAP_GC`) REFERENCES `P_GIACONG` (`MAP_GC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CTP_GIACONG`
--

LOCK TABLES `CTP_GIACONG` WRITE;
/*!40000 ALTER TABLE `CTP_GIACONG` DISABLE KEYS */;
/*!40000 ALTER TABLE `CTP_GIACONG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CTP_MUAHANG`
--

DROP TABLE IF EXISTS `CTP_MUAHANG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CTP_MUAHANG` (
  `MACTP_MH` int(11) NOT NULL,
  `MAP_MH` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `THANHTIEN` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MACTP_MH`),
  KEY `FK_CTP_MUAHANG` (`MAP_MH`),
  KEY `FK_CTP_MUAHANG2` (`MASP`),
  CONSTRAINT `FK_CTP_MUAHANG` FOREIGN KEY (`MAP_MH`) REFERENCES `P_MUAHANG` (`MAP_MH`),
  CONSTRAINT `FK_CTP_MUAHANG2` FOREIGN KEY (`MASP`) REFERENCES `SANPHAM` (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CTP_MUAHANG`
--

LOCK TABLES `CTP_MUAHANG` WRITE;
/*!40000 ALTER TABLE `CTP_MUAHANG` DISABLE KEYS */;
INSERT INTO `CTP_MUAHANG` VALUES (1,1,2,2,40000.000),(2,2,3,5,50000.000),(3,3,1,11,165000.000);
/*!40000 ALTER TABLE `CTP_MUAHANG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CT_TONKHO`
--

DROP TABLE IF EXISTS `CT_TONKHO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CT_TONKHO` (
  `MACTP_TK` int(11) NOT NULL,
  `MAP_TK` int(11) NOT NULL,
  `MAHANG` int(11) NOT NULL,
  `TONDAUKY` int(11) DEFAULT NULL,
  `TONCUOIKY` int(11) DEFAULT NULL,
  `SOLUONGBAN` int(11) DEFAULT NULL,
  `SOLUONGMUA` int(11) DEFAULT NULL,
  PRIMARY KEY (`MACTP_TK`),
  KEY `FK_BAOGOM` (`MAP_TK`),
  CONSTRAINT `FK_BAOGOM` FOREIGN KEY (`MAP_TK`) REFERENCES `TONKHO` (`MAP_TK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CT_TONKHO`
--

LOCK TABLES `CT_TONKHO` WRITE;
/*!40000 ALTER TABLE `CT_TONKHO` DISABLE KEYS */;
/*!40000 ALTER TABLE `CT_TONKHO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DICHVU`
--

DROP TABLE IF EXISTS `DICHVU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DICHVU` (
  `MADV` int(11) NOT NULL,
  `TENDV` nvarchar(30) DEFAULT NULL,
  `DONGIA` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MADV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DICHVU`
--

LOCK TABLES `DICHVU` WRITE;
/*!40000 ALTER TABLE `DICHVU` DISABLE KEYS */;
INSERT INTO `DICHVU` VALUES (1,'Can trang suc',100000.000),(2,'Doi tien',200000.000),(3,'Ma trang suc',30000.000);
/*!40000 ALTER TABLE `DICHVU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HANGGIACONG`
--

DROP TABLE IF EXISTS `HANGGIACONG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HANGGIACONG` (
  `MALOAIGC` int(11) NOT NULL,
  `TENLOAIGC` nvarchar(50) DEFAULT NULL,
  `DONGIA` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MALOAIGC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HANGGIACONG`
--

LOCK TABLES `HANGGIACONG` WRITE;
/*!40000 ALTER TABLE `HANGGIACONG` DISABLE KEYS */;
INSERT INTO `HANGGIACONG` VALUES (1,'Gia cong nhan',100000.000),(2,'Gia cong bong tai',200000.000),(3,'Gia cong vong',30000.000);
/*!40000 ALTER TABLE `HANGGIACONG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KHACHHANG`
--

DROP TABLE IF EXISTS `KHACHHANG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `KHACHHANG` (
  `MAKH` int(11) NOT NULL,
  `MANGUOI` int(11) NOT NULL,
  `LAKHACHQUEN` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MAKH`),
  KEY `FK_LANGUOI1` (`MANGUOI`),
  CONSTRAINT `FK_LANGUOI1` FOREIGN KEY (`MANGUOI`) REFERENCES `NGUOI` (`MANGUOI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KHACHHANG`
--

LOCK TABLES `KHACHHANG` WRITE;
/*!40000 ALTER TABLE `KHACHHANG` DISABLE KEYS */;
INSERT INTO `KHACHHANG` VALUES (1,3,0),(2,1,1),(3,2,1),(4,5,0),(5,6,0),(6,7,0),(7,8,0),(8,9,0),(9,10,0),(10,11,0);
/*!40000 ALTER TABLE `KHACHHANG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NGUOI`
--

DROP TABLE IF EXISTS `NGUOI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NGUOI` (
  `MANGUOI` int(11) NOT NULL,
  `SHORTID` int(11) DEFAULT NULL,
  `HOTEN` nvarchar(20) DEFAULT NULL,
  `DIACHI` nvarchar(100) DEFAULT NULL,
  PRIMARY KEY (`MANGUOI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NGUOI`
--

LOCK TABLES `NGUOI` WRITE;
/*!40000 ALTER TABLE `NGUOI` DISABLE KEYS */;
INSERT INTO `NGUOI` VALUES (1,123456789,'Nguyen Hoang Phat','135 Nguyen XXX YYYY'),(2,12345678,'Nguyen Hoang Minh','252 Duong AAA Pho BBB'),(3,12345677,'Nguyen Hoang Tuan','252 Duong CCC Pho DDD'),(4,123456780,'Vu Minh Nhat','125 Vu XXX YYYY'),(5,150240244,'Nguyen Tuan Cuong','123 Vo Van Tan Phuong 6 Quan 3'),(6,151491477,'Nguyen Tuan Cuong','123 Vo Van Tan Phuong 6 Quan 3'),(7,151712226,'Nguyen Tuan Cuong','123 Vo Van Tan Phuong 6 Quan 3'),(8,159705545,'Cuong Nguyen Tuan','123 Vo Van Tan, Phuong 6, Quan 3'),(9,160330218,'a','a'),(10,164093174,'b','b'),(11,164338303,'b','b');
/*!40000 ALTER TABLE `NGUOI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P_BANHANG`
--

DROP TABLE IF EXISTS `P_BANHANG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P_BANHANG` (
  `MAP_BH` int(11) NOT NULL,
  `MAP_THU` int(11) NOT NULL,
  PRIMARY KEY (`MAP_BH`),
  KEY `FK_BANHANG` (`MAP_THU`),
  CONSTRAINT `FK_BANHANG` FOREIGN KEY (`MAP_THU`) REFERENCES `P_THU` (`MAP_THU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P_BANHANG`
--

LOCK TABLES `P_BANHANG` WRITE;
/*!40000 ALTER TABLE `P_BANHANG` DISABLE KEYS */;
INSERT INTO `P_BANHANG` VALUES (1,2),(2,3),(3,5),(4,6),(5,7);
/*!40000 ALTER TABLE `P_BANHANG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P_CHI`
--

DROP TABLE IF EXISTS `P_CHI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P_CHI` (
  `MAP_CHI` int(11) NOT NULL,
  `NGAYCHI` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NOIDUNG` nvarchar(300) DEFAULT NULL,
  `SOTIENCHI` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MAP_CHI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P_CHI`
--

LOCK TABLES `P_CHI` WRITE;
/*!40000 ALTER TABLE `P_CHI` DISABLE KEYS */;
/*!40000 ALTER TABLE `P_CHI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P_DICHVU`
--

DROP TABLE IF EXISTS `P_DICHVU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P_DICHVU` (
  `MAP_DV` int(11) NOT NULL,
  `MAP_THU` int(11) NOT NULL,
  PRIMARY KEY (`MAP_DV`),
  KEY `FK_CUNGCAPDICHVU` (`MAP_THU`),
  CONSTRAINT `FK_CUNGCAPDICHVU` FOREIGN KEY (`MAP_THU`) REFERENCES `P_THU` (`MAP_THU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P_DICHVU`
--

LOCK TABLES `P_DICHVU` WRITE;
/*!40000 ALTER TABLE `P_DICHVU` DISABLE KEYS */;
/*!40000 ALTER TABLE `P_DICHVU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P_GIACONG`
--

DROP TABLE IF EXISTS `P_GIACONG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P_GIACONG` (
  `MAP_GC` int(11) NOT NULL,
  `MATHOGC` int(11) NOT NULL,
  `NGAYNHANHANG` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NGAYTHANHTOAN` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `TONGCONG` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MAP_GC`),
  KEY `FK_GIACONG` (`MATHOGC`),
  CONSTRAINT `FK_GIACONG` FOREIGN KEY (`MATHOGC`) REFERENCES `THOGIACONG` (`MATHOGC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P_GIACONG`
--

LOCK TABLES `P_GIACONG` WRITE;
/*!40000 ALTER TABLE `P_GIACONG` DISABLE KEYS */;
/*!40000 ALTER TABLE `P_GIACONG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P_MUAHANG`
--

DROP TABLE IF EXISTS `P_MUAHANG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P_MUAHANG` (
  `MAP_MH` int(11) NOT NULL,
  `MAKH` int(11) NOT NULL,
  `NGAYMUA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NGAYTHANHTOAN` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `TONGCONG` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MAP_MH`),
  KEY `FK_MUAHANG` (`MAKH`),
  CONSTRAINT `FK_MUAHANG` FOREIGN KEY (`MAKH`) REFERENCES `KHACHHANG` (`MAKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P_MUAHANG`
--

LOCK TABLES `P_MUAHANG` WRITE;
/*!40000 ALTER TABLE `P_MUAHANG` DISABLE KEYS */;
INSERT INTO `P_MUAHANG` VALUES (1,1,'2016-05-20 00:00:00','2016-05-20 00:00:00',30000.000),(2,2,'2016-05-21 00:00:00','2016-05-22 00:00:00',40000.000),(3,10,'2017-05-30 17:00:00','2017-05-30 17:00:00',165000.000);
/*!40000 ALTER TABLE `P_MUAHANG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P_NO`
--

DROP TABLE IF EXISTS `P_NO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P_NO` (
  `MAP_NO` int(11) NOT NULL,
  `MAP_THU` int(11) DEFAULT NULL,
  `NGAYNO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SOTIENNO` decimal(10,3) DEFAULT NULL,
  `NGAYTRA` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `SOTIENTRA` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MAP_NO`),
  KEY `FK_NO` (`MAP_THU`),
  CONSTRAINT `FK_NO` FOREIGN KEY (`MAP_THU`) REFERENCES `P_THU` (`MAP_THU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P_NO`
--

LOCK TABLES `P_NO` WRITE;
/*!40000 ALTER TABLE `P_NO` DISABLE KEYS */;
INSERT INTO `P_NO` VALUES (1,3,'2016-05-20 00:00:00',10000.000,'2016-05-22 00:00:00',1000.000),(2,3,'2016-05-22 00:00:00',9000.000,'2016-05-23 00:00:00',1000.000);
/*!40000 ALTER TABLE `P_NO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P_THU`
--

DROP TABLE IF EXISTS `P_THU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P_THU` (
  `MAP_THU` int(11) NOT NULL,
  `MAKH` int(11) NOT NULL,
  `NGAYLAPPHIEU` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NGAYKETTHUC` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `TONGCONG` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`MAP_THU`),
  KEY `FK_THUTIEN` (`MAKH`),
  CONSTRAINT `FK_THUTIEN` FOREIGN KEY (`MAKH`) REFERENCES `KHACHHANG` (`MAKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P_THU`
--

LOCK TABLES `P_THU` WRITE;
/*!40000 ALTER TABLE `P_THU` DISABLE KEYS */;
INSERT INTO `P_THU` VALUES (1,1,'2016-05-20 00:00:00','2016-05-21 00:00:00',20000.000),(2,3,'2016-05-20 00:00:00','2016-05-21 00:00:00',30000.000),(3,2,'2016-05-20 00:00:00','2016-05-21 00:00:00',10000.000),(4,6,'2017-05-29 17:00:00','2017-05-30 17:00:00',24000.000),(5,6,'2017-05-29 17:00:00','2017-05-30 17:00:00',24000.000),(6,7,'2017-05-29 17:00:00','2017-05-30 17:00:00',18000.000),(7,8,'2017-05-29 17:00:00','2017-05-30 17:00:00',33000.000);
/*!40000 ALTER TABLE `P_THU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SANPHAM`
--

DROP TABLE IF EXISTS `SANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SANPHAM` (
  `MASP` int(11) NOT NULL,
  `TENLOAISP` nvarchar(30) DEFAULT NULL,
  `DONGIAMUA` decimal(10,3) DEFAULT NULL,
  `DONGIABAN` decimal(10,3) DEFAULT NULL,
  `SOLUONGTON` int(11) DEFAULT NULL,
  PRIMARY KEY (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SANPHAM`
--

LOCK TABLES `SANPHAM` WRITE;
/*!40000 ALTER TABLE `SANPHAM` DISABLE KEYS */;
INSERT INTO `SANPHAM` VALUES (1,'Vàng',10000.000,15000.000,36),(2,'Bac',2000.000,3000.000,0),(3,'Da Quy',4000.000,5000.000,10);
/*!40000 ALTER TABLE `SANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `THOGIACONG`
--

DROP TABLE IF EXISTS `THOGIACONG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `THOGIACONG` (
  `MATHOGC` int(11) NOT NULL,
  `MANGUOI` int(11) NOT NULL,
  PRIMARY KEY (`MATHOGC`),
  KEY `FK_LANGUOI2` (`MANGUOI`),
  CONSTRAINT `FK_LANGUOI2` FOREIGN KEY (`MANGUOI`) REFERENCES `NGUOI` (`MANGUOI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `THOGIACONG`
--

LOCK TABLES `THOGIACONG` WRITE;
/*!40000 ALTER TABLE `THOGIACONG` DISABLE KEYS */;
INSERT INTO `THOGIACONG` VALUES (1,2),(2,3);
/*!40000 ALTER TABLE `THOGIACONG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TONKHO`
--

DROP TABLE IF EXISTS `TONKHO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TONKHO` (
  `MAP_TK` int(11) NOT NULL,
  `NGAYBAOCAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`MAP_TK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TONKHO`
--

LOCK TABLES `TONKHO` WRITE;
/*!40000 ALTER TABLE `TONKHO` DISABLE KEYS */;
/*!40000 ALTER TABLE `TONKHO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` nvarchar(100) DEFAULT NULL,
  `Password` nvarchar(500) DEFAULT NULL,
  `Email` nvarchar(100) DEFAULT NULL,
  `Fullname` nvarchar(100) DEFAULT NULL,
  `Phone` nvarchar(20) DEFAULT NULL,
  `UserTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_User_UserType` (`UserTypeId`),
  CONSTRAINT `FK_User_UserType` FOREIGN KEY (`UserTypeId`) REFERENCES `UserType` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'admin','admin','nhatvm@gmail.com','Vũ Minh Nhật','0989241516',1);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserType`
--

DROP TABLE IF EXISTS `UserType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserType` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserType` nvarchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserType`
--

LOCK TABLES `UserType` WRITE;
/*!40000 ALTER TABLE `UserType` DISABLE KEYS */;
INSERT INTO `UserType` VALUES (1,'Admin'),(2,'Editor');
/*!40000 ALTER TABLE `UserType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'vangbacdaquy'
--
/*!50003 DROP PROCEDURE IF EXISTS `CTP_BANHANG_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_BANHANG_Del`(MACTP_BH INT )
begin
delete from CTP_BANHANG 
where MACTP_BH = MACTP_BH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_BANHANG_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_BANHANG_getLastID`(out maxId INT)
begin
select MACTP_BH into maxId
from CTP_BANHANG
order by MACTP_BH desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_BANHANG_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_BANHANG_Ins`(MACTP_BH INT, MAP_BH INT, MASP INT, SOLUONG int, THANHTIEN decimal )
begin
insert into CTP_BANHANG ( MACTP_BH, MAP_BH, MASP, SOLUONG, THANHTIEN ) values ( MACTP_BH, MAP_BH, MASP, SOLUONG, THANHTIEN );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_BANHANG_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_BANHANG_Upd`(MACTP_BH INT, MAP_BH INT, MASP INT, SOLUONG int, THANHTIEN decimal )
begin
update CTP_BANHANG as a 
set 
a.MAP_BH = if(a.MAP_BH <> MAP_BH, MAP_BH, a.MAP_BH),
a.MASP = if(a.MASP <> MASP, MASP, a.MASP),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_BH = MACTP_BH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_DICHVU_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_DICHVU_Del`(MACTP_DV INT )
begin
delete from ctp_dichvu 
where MACTP_DV = MACTP_DV;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_DICHVU_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_DICHVU_getLastID`(out maxId INT)
begin
select MACTP_DV into maxid
from ctp_dichvu
order by MACTP_DV desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_DICHVU_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_DICHVU_Ins`(MACTP_DV INT, MAP_DV INT, MADV INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_dichvu ( MACTP_DV, MAP_DV, MADV, SOLUONG, THANHTIEN ) values ( MACTP_DV, MAP_DV, MADV, SOLUONG, THANHTIEN );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_DICHVU_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_DICHVU_Upd`(MACTP_DV INT, MAP_DV INT, MADV INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_dichvu as a 
set 
a.MAP_DV = if(a.MAP_DV <> MAP_DV, MAP_DV, a.MAP_DV),
a.MADV = if(a.MADV <> MADV, MADV, a.MADV),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_DV = MACTP_DV;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_GIACONG_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_GIACONG_Del`(MACTP_GC INT )
begin
delete from ctp_giacong 
where MACTP_GC = MACTP_GC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_GIACONG_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_GIACONG_getLastID`(out maxId INT)
begin
select MACTP_GC into maxid
from ctp_giacong
order by MACTP_GC desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_GIACONG_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_GIACONG_Ins`(MACTP_GC INT, MAP_GC INT, MALOAIGC INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_giacong ( MACTP_GC, MAP_GC, MALOAIGC, SOLUONG, THANHTIEN ) values ( MACTP_GC, MAP_GC, MALOAIGC, SOLUONG, THANHTIEN );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_GIACONG_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_GIACONG_Upd`(MACTP_GC INT, MAP_GC INT, MALOAIGC INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_giacong as a 
set 
a.MAP_GC = if(a.MAP_GC <> MAP_GC, MAP_GC, a.MAP_GC),
a.MALOAIGC = if(a.MALOAIGC <> MALOAIGC, MALOAIGC, a.MALOAIGC),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_GC = MACTP_GC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_MUAHANG_Del` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_MUAHANG_Del`(MACTP_MH INT )
begin
delete from CTP_MUAHANG 
where MACTP_MH = MACTP_MH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_MUAHANG_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_MUAHANG_getLastID`( out maxId INT )
begin
select MACTP_MH into maxId 
from CTP_MUAHANG
order by MACTP_MH desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_MUAHANG_Ins` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_MUAHANG_Ins`(MACTP_MH INT, MASP INT, MAP_MH INT, SOLUONG int, THANHTIEN decimal )
begin
insert into CTP_MUAHANG ( MACTP_MH, MASP, MAP_MH, SOLUONG, THANHTIEN ) values ( MACTP_MH, MASP, MAP_MH, SOLUONG, THANHTIEN );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CTP_MUAHANG_Upd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_MUAHANG_Upd`(MACTP_MH INT, MASP INT, MAP_MH INT, SOLUONG int, THANHTIEN decimal )
begin
update CTP_MUAHANG as a 
set 
a.MASP = if(a.MASP <> MASP, MASP, a.MASP),
a.MAP_MH = if(a.MAP_MH <> MAP_MH, MAP_MH, a.MAP_MH),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_MH = MACTP_MH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CT_TONKHO_Del` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CT_TONKHO_Del`(MACTP_TK INT )
begin
delete from CT_TONKHO 
where MACTP_TK = MACTP_TK;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CT_TonKho_getLastID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CT_TonKho_getLastID`(out maxID int)
begin
select MACTP_TK into maxID
from CT_TONKHO
order by MACTP_TK desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CT_TONKHO_Ins` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CT_TONKHO_Ins`(MACTP_TK INT, MAP_TK INT, MAHANG INT, TONDAUKY int, TONCUOIKY int, SOLUONGBAN int, SOLUONGMUA int )
begin
insert into CT_TONKHO ( MACTP_TK, MAP_TK, MAHANG, TONDAUKY, TONCUOIKY, SOLUONGBAN, SOLUONGMUA ) values ( MACTP_TK, MAP_TK, MAHANG, TONDAUKY, TONCUOIKY, SOLUONGBAN, SOLUONGMUA );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CT_TONKHO_Upd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CT_TONKHO_Upd`(MACTP_TK INT, MAP_TK INT, MAHANG INT, TONDAUKY int, TONCUOIKY int, SOLUONGBAN int, SOLUONGMUA int )
begin
update CT_TONKHO as a 
set 
a.MAP_TK = if(a.MAP_TK <> MAP_TK, MAP_TK, a.MAP_TK),
a.MAHANG = if(a.MAHANG <> MAHANG, MAHANG, a.MAHANG),
a.TONDAUKY = if(a.TONDAUKY <> TONDAUKY, TONDAUKY, a.TONDAUKY),
a.TONCUOIKY = if(a.TONCUOIKY <> TONCUOIKY, TONCUOIKY, a.TONCUOIKY),
a.SOLUONGBAN = if(a.SOLUONGBAN <> SOLUONGBAN, SOLUONGBAN, a.SOLUONGBAN),
a.SOLUONGMUA = if(a.SOLUONGMUA <> SOLUONGMUA, SOLUONGMUA, a.SOLUONGMUA)
where a.MACTP_TK = MACTP_TK;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `DICHVU_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DICHVU_Del`(MADV INT )
begin
delete from DICHVU 
where DICHVU.MADV = MADV;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `DICHVU_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DICHVU_getLastID`(out maxId INT)
begin
select MADV into maxId
from DICHVU
order by MADV desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `DICHVU_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DICHVU_Ins`(MADV INT, TENDV nvarchar(30), DONGIA decimal )
begin
insert into DICHVU ( MADV, TENDV, DONGIA ) values ( MADV, TENDV, DONGIA );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `DICHVU_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DICHVU_Upd`(MADV INT, TENDV nvarchar(30), DONGIA decimal )
begin
update DICHVU as a 
set 
a.TENDV = if(a.TENDV <> TENDV, TENDV, a.TENDV),
a.DONGIA = if(a.DONGIA <> DONGIA, DONGIA, a.DONGIA)
where a.MADV = MADV;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `HANGGIACONG_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `HANGGIACONG_Del`(MALOAIGC INT )
begin
delete from hanggiacong 
where hanggiacong.MALOAIGC = MALOAIGC;
end ;;
DELIMITER ;

/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `HANGGIACONG_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `HANGGIACONG_Ins`(MALOAIGC INT, TENLOAIGC nvarchar(20), DONGIA decimal )
begin
insert into hanggiacong ( MALOAIGC, TENLOAIGC, DONGIA ) values ( MALOAIGC, TENLOAIGC, DONGIA );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `HANGGIACONG_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `HANGGIACONG_Upd`(MALOAIGC INT, TENLOAIGC nvarchar(20), DONGIA decimal )
begin
update hanggiacong as a 
set 
a.TENLOAIGC = if(a.TENLOAIGC <> TENLOAIGC, TENLOAIGC, a.TENLOAIGC),
a.DONGIA = if(a.DONGIA <> DONGIA, DONGIA, a.DONGIA)
where a.MALOAIGC = MALOAIGC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `KHACHHANG_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `KHACHHANG_Del`(MAKH INT )
begin
delete from khachhang 
where MAKH = MAKH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `KHACHHANG_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `KHACHHANG_getLastID`(out maxId INT)
begin
select MAKH into maxid
from KHACHHANG
order by MAKH desc
limit 1;
end ;;
DELIMITER ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `HANGGIACONG_getLastID`(out maxId INT)
begin
select MALOAIGC into maxid
from HANGGIACONG
order by MALOAIGC desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `KHACHHANG_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `KHACHHANG_Ins`(MAKH INT, MANGUOI INT, LAKHACHQUEN tinyint )
begin
insert into KHACHHANG ( MAKH, MANGUOI, LAKHACHQUEN ) values ( MAKH, MANGUOI, LAKHACHQUEN );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `KHACHHANG_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `KHACHHANG_Upd`(MAKH INT, MANGUOI INT, LAKHACHQUEN tinyint )
begin
update khachhang as a 
set 
a.MANGUOI = if(a.MANGUOI <> MANGUOI, MANGUOI, a.MANGUOI),
a.LAKHACHQUEN = if(a.LAKHACHQUEN <> LAKHACHQUEN, LAKHACHQUEN, a.LAKHACHQUEN)
where a.MAKH = MAKH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `NGUOI_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `NGUOI_Del`(MANGUOI INT )
begin
delete from nguoi 
where MANGUOI = MANGUOI;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `NGUOI_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `NGUOI_getLastID`(out maxId INT)
begin
select MANGUOI into maxid
from NGUOI
order by MANGUOI desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `NGUOI_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `NGUOI_Ins`(MANGUOI INT, SHORTID int, HOTEN nvarchar(50), DIACHI nvarchar(200) )
begin
insert into NGUOI ( MANGUOI, SHORTID, HOTEN, DIACHI ) values ( MANGUOI, SHORTID, HOTEN, DIACHI );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `NGUOI_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `NGUOI_Upd`(MANGUOI INT, SHORTID int, HOTEN nvarchar(50), DIACHI nvarchar(200) )
begin
update NGUOI as a 
set 
a.SHORTID = if(a.SHORTID <> SHORTID, SHORTID, a.SHORTID),
a.HOTEN = if(a.HOTEN <> HOTEN, HOTEN, a.HOTEN),
a.DIACHI = if(a.DIACHI <> DIACHI, DIACHI, a.DIACHI)
where a.MANGUOI = MANGUOI;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_BANHANG_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BANHANG_Del`(MAP_BH INT )
begin
delete from P_BANHANG 
where MAP_BH = MAP_BH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_BANHANG_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BANHANG_getLastID`(out maxId INT)
begin
select MAP_BH into maxId
from P_BANHANG
order by MAP_BH desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_BanHang_getMaKHHoTenByMaP_BH` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BanHang_getMaKHHoTenByMaP_BH`(in maP_BH INT)
begin
select k.MAKH, n.HOTEN
from ((P_BANHANG as b inner join P_THU as t
    on t.MAP_THU = b.MAP_THU) inner join KHACHHANG as k
    on t.MAKH = k.MAKH ) inner join NGUOI as n
	on k.MANGUOI = n.MANGUOI
where b.MAP_BH = map_BH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_BanHang_getMaP_ThuByMaP_BH` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BanHang_getMaP_ThuByMaP_BH`(in maP_BH INT,out maP_Thu INT)
begin
select b.MAP_THU into maP_Thu
from P_BANHANG as b
where b.MAP_BH = maP_BH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_BanHang_getMaSPTongBan` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BanHang_getMaSPTongBan`(in lastedNgayBC timestamp, in newNgayBC timestamp)
begin

-- lấy maSP và tổng lượng bán
select MASP, sum(SOLUONG)
from CTP_BANHANG as c
where c.MAP_BH in (select distinct MAP_BH
					from P_BANHANG as b inner join P_THU as t
					on b.MAP_THU = t.MAP_THU
					where t.NGAYLAPPHIEU > lastedNgayBC and t.NGAYLAPPHIEU <= newNgayBC)
 group by MASP
order by MASP asc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_BANHANG_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BANHANG_Ins`(MAP_BH INT, MAP_THU INT )
begin
insert into P_BANHANG ( MAP_BH, MAP_THU ) values ( MAP_BH, MAP_THU );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_BANHANG_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BANHANG_Upd`(MAP_BH INT, MAP_THU INT )
begin
update P_BANHANG as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU)
where a.MAP_BH = MAP_BH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_CHI_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_CHI_Del`(MAP_CHI INT )
begin
delete from p_chi 
where MAP_CHI = MAP_CHI;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_Chi_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_Chi_getLastID`(out maxid INT)
begin
select MAP_CHI
into maxid
from p_chi
order by MAP_CHI desc
limit 1; 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_CHI_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_CHI_Ins`(MAP_CHI INT, NGAYCHI timestamp, NOIDUNG nvarchar(300), SOTIENCHI decimal )
begin
insert into p_chi ( MAP_CHI, NGAYCHI,NOIDUNG, SOTIENCHI ) values ( MAP_CHI, NGAYCHI,NOIDUNG, SOTIENCHI );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_CHI_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_CHI_Upd`(MAP_CHI INT, NGAYCHI timestamp, NOIDUNG nvarchar(300),SOTIENCHI decimal )
begin
update p_chi as a 
set 
a.NGAYCHI = if(a.NGAYCHI <> NGAYCHI, NGAYCHI, a.NGAYCHI),
a.SOTIENCHI = if(a.SOTIENCHI <> SOTIENCHI, SOTIENCHI, a.SOTIENCHI),
a.NOIDUNG = if(a.NOIDUNG <> NOIDUNG, NOIDUNG, a.NOIDUNG)
where a.MAP_CHI = MAP_CHI;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_DICHVU_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_DICHVU_Del`(MAP_DV INT )
begin
delete from P_DICHVU 
where MAP_DV = MAP_DV;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_DICHVU_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_DICHVU_getLastID`(out maxId INT)
begin
select MAP_DV into maxid
from p_dichvu
order by MAP_DV desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_DICHVU_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_DICHVU_Ins`(MAP_DV INT, MAP_THU INT )
begin
insert into p_dichvu ( MAP_DV, MAP_THU ) values ( MAP_DV, MAP_THU );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_DICHVU_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_DICHVU_Upd`(MAP_DV INT, MAP_THU INT )
begin
update p_dichvu as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU)
where a.MAP_DV = MAP_DV;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_GIACONG_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GIACONG_Del`(MAP_GC INT )
begin
delete from p_giacong 
where MAP_GC = MAP_GC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_GIACONG_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GIACONG_getLastID`(out maxId INT)
begin
select MAP_GC into maxid
from p_giacong
order by MAP_GC desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_GIACONG_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GIACONG_Ins`(MAP_GC INT, MATHOGC INT, NGAYNHANHANG timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
insert into p_giacong ( MAP_GC, MATHOGC, NGAYNHANHANG, NGAYTHANHTOAN, TONGCONG ) values ( MAP_GC, MATHOGC, NGAYNHANHANG, NGAYTHANHTOAN, TONGCONG );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_GIACONG_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GIACONG_Upd`(MAP_GC INT, MATHOGC INT, NGAYNHANHANG timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
update p_giacong as a 
set 
a.MATHOGC = if(a.MATHOGC <> MATHOGC, MATHOGC, a.MATHOGC),
a.NGAYNHANHANG = if(a.NGAYNHANHANG <> NGAYNHANHANG, NGAYNHANHANG, a.NGAYNHANHANG),
a.NGAYTHANHTOAN = if(a.NGAYTHANHTOAN <> NGAYTHANHTOAN, NGAYTHANHTOAN, a.NGAYTHANHTOAN),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_GC = MAP_GC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_MUAHANG_Del` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MUAHANG_Del`(MAP_MH INT )
begin
delete from P_MUAHANG 
where MAP_MH = MAP_MH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `P_MUAHANG_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MUAHANG_getLastID`(out maxId INT)
begin
select MAP_MH into maxId
from P_MUAHANG
order by MAP_MH desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_MuaHang_getMaSPTongMua` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MuaHang_getMaSPTongMua`(in lastedNgayBC timestamp, in newNgayBC timestamp)
begin

-- lấy maSP và tổng lượng bán
select MASP, sum(SOLUONG)
from CTP_MUAHANG as c
where c.MAP_MH in (select distinct MAP_MH
					from P_MUAHANG as m
					where m.NGAYMUA > lastedNgayBC and m.NGAYMUA <= newNgayBC)
 group by  MASP
order by MASP asc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_MUAHANG_Ins` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MUAHANG_Ins`(MAP_MH INT, MAKH INT, NGAYMUA timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
insert into P_MUAHANG ( MAP_MH, MAKH, NGAYMUA, NGAYTHANHTOAN, TONGCONG ) values ( MAP_MH, MAKH, NGAYMUA, NGAYTHANHTOAN, TONGCONG );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `P_MUAHANG_Upd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MUAHANG_Upd`(MAP_MH INT, MAKH INT, NGAYMUA timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
update P_MUAHANG as a 
set 
a.MAKH = if(a.MAKH <> MAKH, MAKH, a.MAKH),
a.NGAYMUA = if(a.NGAYMUA <> NGAYMUA, NGAYMUA, a.NGAYMUA),
a.NGAYTHANHTOAN = if(a.NGAYTHANHTOAN <> NGAYTHANHTOAN, NGAYTHANHTOAN, a.NGAYTHANHTOAN),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_MH = MAP_MH;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `P_NO_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_NO_Del`(MAP_NO INT )
begin
delete from p_no 
where MAP_NO = MAP_NO;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_No_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_No_getLastID`(out maxid INT)
begin
select MAP_NO into maxid
from p_no
order by MAP_NO desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_NO_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_NO_Ins`(MAP_NO INT, MAP_THU INT, NGAYNO timestamp, SOTIENNO decimal, NGAYTRA timestamp, SOTIENTRA decimal )
begin
insert into p_no ( MAP_NO, MAP_THU, NGAYNO, SOTIENNO, NGAYTRA, SOTIENTRA ) values ( MAP_NO, MAP_THU, NGAYNO, SOTIENNO, NGAYTRA, SOTIENTRA );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_NO_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_NO_Upd`(MAP_NO INT, MAP_THU INT, NGAYNO timestamp, SOTIENNO decimal, NGAYTRA timestamp, SOTIENTRA decimal )
begin
update p_no as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU),
a.NGAYNO = if(a.NGAYNO <> NGAYNO, NGAYNO, a.NGAYNO),
a.SOTIENNO = if(a.SOTIENNO <> SOTIENNO, SOTIENNO, a.SOTIENNO),
a.NGAYTRA = if(a.NGAYTRA <> NGAYTRA, NGAYTRA, a.NGAYTRA),
a.SOTIENTRA = if(a.SOTIENTRA <> SOTIENTRA, SOTIENTRA, a.SOTIENTRA)
where a.MAP_NO = MAP_NO;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_THU_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_THU_Del`(MAP_THU INT )
begin
delete from p_thu 
where MAP_THU = MAP_THU;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_Thu_getLastConLaiNgayTraByMaP_Thu` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_Thu_getLastConLaiNgayTraByMaP_Thu`(in maKH INT, in maP_Thu INT,
out conLai decimal(20,3), out ngayTra timestamp)
begin
declare checkKhachquen bool;
set conlai = 0;
 set ngayTra = '1970-01-02 00:00:00';
-- nếu phiếu nợ đã tồn tại

select (SOTIENNO - SOTIENTRA), n.NGAYTRA
into conlai, ngayTra
from p_no as n
where n.map_thu = maP_Thu
order by MAP_NO desc
limit 1;
-- nếu phiếu nợ chưa tồn tại
if(conlai = 0 and ngayTra = '1970-01-02 00:00:00')
then
select laKhachQuen into checkKhachquen
from khachhang as k
where k.makh = maKH;
-- nếu là khách quen
if (checkKhachquen = 1)
then
select tongcong, Ngaylapphieu into conlai, ngayTra
from p_thu as t
where t.map_thu = maP_Thu;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_THU_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_THU_getLastID`(out maxId INT)
begin
select MAP_THU into maxid
from P_THU
order by MAP_THU desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_THU_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_THU_Ins`(MAP_THU INT, MAKH INT, NGAYLAPPHIEU timestamp, NGAYKETTHUC timestamp, TONGCONG decimal )
begin
insert into P_THU ( MAP_THU, MAKH, NGAYLAPPHIEU, NGAYKETTHUC, TONGCONG ) values ( MAP_THU, MAKH, NGAYLAPPHIEU, NGAYKETTHUC, TONGCONG );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `P_THU_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_THU_Upd`(MAP_THU INT, MAKH INT, NGAYLAPPHIEU timestamp, NGAYKETTHUC timestamp, TONGCONG decimal )
begin
update p_thu as a 
set 
a.MAKH = if(a.MAKH <> MAKH, MAKH, a.MAKH),
a.NGAYLAPPHIEU = if(a.NGAYLAPPHIEU <> NGAYLAPPHIEU, NGAYLAPPHIEU, a.NGAYLAPPHIEU),
a.NGAYKETTHUC = if(a.NGAYKETTHUC <> NGAYKETTHUC, NGAYKETTHUC, a.NGAYKETTHUC),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_THU = MAP_THU;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `SANPHAM_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SANPHAM_Del`(MASP INT )
begin
delete from SANPHAM 
where SANPHAM.MASP = MASP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `SANPHAM_getLastID` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SANPHAM_getLastID`(out maxId INT)
begin
select MASP into maxId
from SANPHAM
order by MASP desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `SanPham_getSanPham` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SanPham_getSanPham`()
begin
select MASP
from SANPHAM
order by MASP asc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `SANPHAM_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SANPHAM_Ins`(MASP INT, TENLOAISP nvarchar(30), DONGIAMUA decimal, DONGIABAN decimal, SOLUONGTON int )
begin
insert into SANPHAM ( MASP, TENLOAISP, DONGIAMUA, DONGIABAN, SOLUONGTON ) values ( MASP, TENLOAISP, DONGIAMUA, DONGIABAN, SOLUONGTON );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `SANPHAM_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SANPHAM_Upd`(MASP INT, TENLOAISP nvarchar(30), DONGIAMUA decimal, DONGIABAN decimal, SOLUONGTON int )
begin
update SANPHAM as a 
set 
a.TENLOAISP = if(a.TENLOAISP <> TENLOAISP, TENLOAISP, a.TENLOAISP),
a.DONGIAMUA = if(a.DONGIAMUA <> DONGIAMUA, DONGIAMUA, a.DONGIAMUA),
a.DONGIABAN = if(a.DONGIABAN <> DONGIABAN, DONGIABAN, a.DONGIABAN),
a.SOLUONGTON = if(a.SOLUONGTON <> SOLUONGTON, SOLUONGTON, a.SOLUONGTON)
where a.MASP = MASP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `THOGIACONG_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `THOGIACONG_Del`(MATHOGC INT )
begin
delete from thogiacong 
where MATHOGC = MATHOGC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `THOGIACONG_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `THOGIACONG_Ins`(MATHOGC INT, MANGUOI INT )
begin
insert into thogiacong ( MATHOGC, MANGUOI ) values ( MATHOGC, MANGUOI );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `THOGIACONG_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `THOGIACONG_Upd`(MATHOGC INT, MANGUOI INT )
begin
update thogiacong as a 
set 
a.MANGUOI = if(a.MANGUOI <> MANGUOI, MANGUOI, a.MANGUOI)
where a.MATHOGC = MATHOGC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `TONKHO_Del` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TONKHO_Del`(MAP_TK INT )
begin
delete from tonkho 
where MAP_TK = MAP_TK;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `TonKho_getLastRow` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TonKho_getLastRow`()
begin
select *
from TONKHO
order by MAP_TK desc
limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `TonKho_getMaSPTonCuoiKyByMaTK` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TonKho_getMaSPTonCuoiKyByMaTK`(in MaTK INT)
begin
select t.MAHANG, t.TONCUOIKY
from CT_TONKHO as t
where t.MAP_TK = MaTK
order by t.MAHANG;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `TONKHO_Ins` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TONKHO_Ins`(MAP_TK INT, NGAYBAOCAO timestamp )
begin
insert into tonkho ( MAP_TK, NGAYBAOCAO ) values ( MAP_TK, NGAYBAOCAO );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `TONKHO_Upd` */;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TONKHO_Upd`(MAP_TK INT, NGAYBAOCAO timestamp )
begin
update tonkho as a 
set 
a.NGAYBAOCAO = if(a.NGAYBAOCAO <> NGAYBAOCAO, NGAYBAOCAO, a.NGAYBAOCAO)
where a.MAP_TK = MAP_TK;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `vangbacdaquy` CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-31 11:24:21
