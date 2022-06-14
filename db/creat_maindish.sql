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
