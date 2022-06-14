create database mydb;

CREATE TABLE `maindish` (
  `DishID` int NOT NULL,
  `DishDate` date DEFAULT NULL,
  `DishName` varchar(45) DEFAULT NULL,
  `DishBikou` varchar(45) DEFAULT NULL,
  `User_UserID` int NOT NULL,
  `Tag_TagID` int NOT NULL,
  PRIMARY KEY (`DishID`,`User_UserID`,`Tag_TagID`),
  KEY `fk_MainDish_User1_idx` (`User_UserID`),
  KEY `fk_MainDish_Tag1_idx` (`Tag_TagID`),
  CONSTRAINT `fk_MainDish_Tag1` FOREIGN KEY (`Tag_TagID`) REFERENCES `tag` (`TagID`),
  CONSTRAINT `fk_MainDish_User1` FOREIGN KEY (`User_UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `tag` (
  `TagID` int NOT NULL,
  `TagName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TagID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `tagwarningpattern` (
  `TagWarningPatternID` int NOT NULL,
  `WarningMessage` varchar(45) NOT NULL,
  `WarningSetting` int NOT NULL,
  `User_UserID` int NOT NULL,
  `Tag_TagID` int NOT NULL,
  `EatYesOrNo` tinyint NOT NULL,
  PRIMARY KEY (`TagWarningPatternID`,`User_UserID`,`Tag_TagID`),
  KEY `fk_TagWarningPattern_User_idx` (`User_UserID`),
  KEY `fk_TagWarningPattern_Tag1_idx` (`Tag_TagID`),
  CONSTRAINT `fk_TagWarningPattern_Tag1` FOREIGN KEY (`Tag_TagID`) REFERENCES `tag` (`TagID`),
  CONSTRAINT `fk_TagWarningPattern_User` FOREIGN KEY (`User_UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user` (
  `UserID` int NOT NULL,
  `UserMail` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `UserID_UNIQUE` (`UserMail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

