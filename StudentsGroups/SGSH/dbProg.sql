-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dbprog
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacts` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt6tbf1av26ds8aimnru7lrf3r` (`group_id`),
  CONSTRAINT `FKt6tbf1av26ds8aimnru7lrf3r` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (2,'user0@test.com','Name0','12345670','Surname0',NULL),(3,'user1@test.com','Name1','12345671','Surname1',NULL),(4,'user2@test.com','Name2','12345672','Surname2',NULL),(5,'user3@test.com','Name3','12345673','Surname3',NULL),(6,'user4@test.com','Name4','12345674','Surname4',NULL),(7,'user5@test.com','Name5','12345675','Surname5',NULL),(8,'user6@test.com','Name6','12345676','Surname6',NULL),(9,'user7@test.com','Name7','12345677','Surname7',NULL),(10,'user8@test.com','Name8','12345678','Surname8',NULL),(11,'user9@test.com','Name9','12345679','Surname9',NULL),(12,'user10@test.com','Name10','123456710','Surname10',NULL),(13,'user11@test.com','Name11','123456711','Surname11',NULL),(14,'user12@test.com','Name12','123456712','Surname12',NULL),(15,'user13@test.com','Name13','123456713','Surname13',NULL),(16,'user14@test.com','Name14','123456714','Surname14',NULL),(17,'user15@test.com','Name15','123456715','Surname15',NULL),(18,'user16@test.com','Name16','123456716','Surname16',NULL),(19,'user17@test.com','Name17','123456717','Surname17',NULL),(20,'user18@test.com','Name18','123456718','Surname18',NULL),(21,'user19@test.com','Name19','123456719','Surname19',NULL),(22,'user20@test.com','Name20','123456720','Surname20',NULL),(23,'user21@test.com','Name21','123456721','Surname21',NULL),(24,'user22@test.com','Name22','123456722','Surname22',NULL),(25,'user23@test.com','Name23','123456723','Surname23',NULL),(26,'user24@test.com','Name24','123456724','Surname24',NULL),(27,'user0@other.com','Other0','76543210','OtherSurname0',1),(28,'user1@other.com','Other1','76543211','OtherSurname1',1),(29,'user2@other.com','Other2','76543212','OtherSurname2',1),(30,'user3@other.com','Other3','76543213','OtherSurname3',1),(31,'user4@other.com','Other4','76543214','OtherSurname4',1),(32,'user5@other.com','Other5','76543215','OtherSurname5',1),(33,'user6@other.com','Other6','76543216','OtherSurname6',1),(34,'user7@other.com','Other7','76543217','OtherSurname7',1),(35,'user8@other.com','Other8','76543218','OtherSurname8',1),(36,'user9@other.com','Other9','76543219','OtherSurname9',1),(37,'user10@other.com','Other10','765432110','OtherSurname10',1),(38,'user11@other.com','Other11','765432111','OtherSurname11',1);
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'Test');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (39),(39);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbprog'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-10 13:39:28
