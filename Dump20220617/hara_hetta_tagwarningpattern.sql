-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: hara_hetta
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tagwarningpattern`
--

DROP TABLE IF EXISTS `tagwarningpattern`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tagwarningpattern` (
  `TagWarningPatternID` int NOT NULL AUTO_INCREMENT,
  `WarningMessage` varchar(45) DEFAULT NULL,
  `WarningSetting` int NOT NULL,
  `User_UserID` int NOT NULL,
  `Tag_TagID` int NOT NULL,
  `EatYesOrNo` tinyint DEFAULT NULL,
  `WarningCount` int NOT NULL,
  PRIMARY KEY (`TagWarningPatternID`),
  KEY `fk_TagWarningPattern_User_idx` (`User_UserID`),
  KEY `fk_TagWarningPattern_Tag1_idx` (`Tag_TagID`),
  CONSTRAINT `fk_TagWarningPattern_Tag1` FOREIGN KEY (`Tag_TagID`) REFERENCES `tag` (`TagID`),
  CONSTRAINT `fk_TagWarningPattern_User` FOREIGN KEY (`User_UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagwarningpattern`
--

LOCK TABLES `tagwarningpattern` WRITE;
/*!40000 ALTER TABLE `tagwarningpattern` DISABLE KEYS */;
INSERT INTO `tagwarningpattern` VALUES (2,NULL,1,1,14,NULL,2),(3,NULL,1,1,15,NULL,5),(4,NULL,2,1,16,NULL,5);
/*!40000 ALTER TABLE `tagwarningpattern` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-17 11:21:20
