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
