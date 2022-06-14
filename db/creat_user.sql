CREATE TABLE `user` (
  `UserID` int NOT NULL,
  `UserMail` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `UserID_UNIQUE` (`UserMail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
