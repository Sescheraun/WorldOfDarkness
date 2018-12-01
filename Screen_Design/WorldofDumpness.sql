-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: WorldOfDarkness
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `character`
--

DROP TABLE IF EXISTS `character`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `character` (
  `characterID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `middleName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `unspentExperience` int(11) NOT NULL,
  `approved` tinyint(1) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`characterID`),
  KEY `character_user` (`user_id`),
  CONSTRAINT `character_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character`
--

LOCK TABLES `character` WRITE;
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
/*!40000 ALTER TABLE `character` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `characterTraits`
--

DROP TABLE IF EXISTS `characterTraits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `characterTraits` (
  `character` int(11) NOT NULL,
  `trait` int(11) NOT NULL,
  `currentRank` int(11) NOT NULL DEFAULT '0',
  `description` varchar(20) NOT NULL,
  `firstSpecialty` varchar(50) DEFAULT NULL,
  `scondSpecialty` varchar(50) DEFAULT NULL,
  `currentLevel` int(11) NOT NULL DEFAULT '0' COMMENT 'this will be enforced by the software to not exceed the max level for the given trait.',
  PRIMARY KEY (`character`,`trait`),
  KEY `characterTraits_Traits` (`trait`),
  CONSTRAINT `characterTraits_Traits` FOREIGN KEY (`trait`) REFERENCES `trait` (`id`),
  CONSTRAINT `characterTraits_character` FOREIGN KEY (`character`) REFERENCES `character` (`characterID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characterTraits`
--

LOCK TABLES `characterTraits` WRITE;
/*!40000 ALTER TABLE `characterTraits` DISABLE KEYS */;
/*!40000 ALTER TABLE `characterTraits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `critter`
--

DROP TABLE IF EXISTS `critter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `critter` (
  `critterID` int(11) NOT NULL AUTO_INCREMENT,
  `critterName` varchar(100) NOT NULL,
  `implemented` tinyint(1) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`critterID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='Human, vampire, Changeling ect...';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `critter`
--

LOCK TABLES `critter` WRITE;
/*!40000 ALTER TABLE `critter` DISABLE KEYS */;
INSERT INTO `critter` (`critterID`, `critterName`, `implemented`, `isDeleted`) VALUES (1,'Human',0,0),(2,'Vampire',0,0),(3,'Wereworlf',0,0),(4,'Mage',0,0),(5,'Changeling',0,0),(6,'Wraith',0,0),(7,'Mummy',0,0),(8,'Bygone',0,0),(9,'Exalted',0,0),(10,'Dragon',0,0);
/*!40000 ALTER TABLE `critter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `roleName` varchar(100) NOT NULL DEFAULT 'player',
  `userName` varchar(100) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `Roles_user` (`userID`),
  CONSTRAINT `Roles_user` FOREIGN KEY (`userID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `userID`, `roleName`, `userName`, `isDeleted`) VALUES (1,1,'player','Sescheraun',0),(2,2,'player','cde',0),(3,3,'player','appleOrange',0),(4,4,'player','zzzzz',0),(5,5,'player','qwerty',0),(6,1,'admin','Sescheraun',0),(7,1,'gameMaster','Sescheraun',0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subCritter`
--

DROP TABLE IF EXISTS `subCritter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subCritter` (
  `subCritterID` int(11) NOT NULL AUTO_INCREMENT,
  `subCritterLabel` varchar(20) NOT NULL COMMENT 'this will be Kith if the subCritter is pooka for example',
  `critterID` int(11) NOT NULL,
  `critterSubName` varchar(20) NOT NULL COMMENT 'Pooka, Gangrel, Get of Fenris ect..',
  `firstAdvantage` blob NOT NULL,
  `secondAdvantage` blob NOT NULL,
  `flaw` blob NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`subCritterID`),
  KEY `subCritter_critter` (`critterID`),
  CONSTRAINT `subCritter_critter` FOREIGN KEY (`critterID`) REFERENCES `critter` (`critterID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Vampire : clan Werewolf: tribe, auspice, breed Changeling: Kith, seeming, house mage: tradition/convention Wraith ???';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subCritter`
--

LOCK TABLES `subCritter` WRITE;
/*!40000 ALTER TABLE `subCritter` DISABLE KEYS */;
/*!40000 ALTER TABLE `subCritter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trait`
--

DROP TABLE IF EXISTS `trait`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trait` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openToCritterID` int(11) DEFAULT '0',
  `goodAtSubCritterID` int(11) DEFAULT NULL,
  `traitName` varchar(100) NOT NULL,
  `specialtyAllowed` tinyint(1) NOT NULL DEFAULT '1',
  `minimumScore` int(11) NOT NULL DEFAULT '0' COMMENT 'For traits that have no score, like a garou gift, this will be 0',
  `maximumScore` int(11) NOT NULL DEFAULT '5' COMMENT 'For traits that have no score, like a garou gift, this will be 0.',
  `traitType` varchar(50) NOT NULL COMMENT 'This is the kind of trait it is.  E: Art, realm, discipline, Talent, background ect...',
  `newCost` int(11) NOT NULL COMMENT 'This is the cost to buy the first dot in a trait.  For a background it will always be 0.  For things that only have 1 level, it will be the cost t0 buy it',
  `cheapCost` int(11) NOT NULL COMMENT 'this is the cost to raise something if you are ''''good at it''''  clan disciplines for example.',
  `normalCost` int(11) NOT NULL COMMENT 'this is the cost to buy something on average.  For situations like orphans and spheres, it will be the cost to buy all spheres.',
  `expensiveCost` int(11) NOT NULL COMMENT 'this is the cost to buy something that you are not the best at.  Non primary spheres, non clan disciplines for examples.',
  `freebieCost` int(11) NOT NULL COMMENT 'This is the cost to buy something with freebie points.',
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `Traits_critter` (`openToCritterID`),
  KEY `Traits_subCritter` (`goodAtSubCritterID`),
  CONSTRAINT `Traits_critter` FOREIGN KEY (`openToCritterID`) REFERENCES `critter` (`critterID`),
  CONSTRAINT `Traits_subCritter` FOREIGN KEY (`goodAtSubCritterID`) REFERENCES `subCritter` (`subCritterID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trait`
--

LOCK TABLES `trait` WRITE;
/*!40000 ALTER TABLE `trait` DISABLE KEYS */;
/*!40000 ALTER TABLE `trait` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `userName` varchar(100) NOT NULL COMMENT 'This must also be unique in the database.',
  `authenticator` varchar(256) NOT NULL,
  `EmailAddress` varchar(100) NOT NULL,
  `phoneNumber` char(13) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `firstName`, `lastName`, `userName`, `authenticator`, `EmailAddress`, `phoneNumber`, `isDeleted`) VALUES (1,'Robert','Collier','Sescheraun','5d115e1e64782dd5158004d0911a3696823e27fc5d3f2d69e539838e0d3a6a0e$1$33c252f96bc252819dbb2e2a3181aec0553d0e9c2dbfe3b7fd1d28972359b40a1ee0baa75c6bbb7eca71068385fa1caf0f6b07245119c4c94423bb2beade8ed7','dekker_soc@yahoo.com',NULL,0),(2,'a','b','cde','da99eaa68ab86ddee530498ed52b67ed993438401cf4bd1f3fa215334323b869$1$07fe493cf20c52d0297a4bda14a981265452e9d6b021c93c6e8d0f245980ebd2ec773ce719561c325413da4415b48e8e04f7bc5a2b9cc642d29deaaef600e38a','def@ghi.jkl',NULL,0),(3,'apple','orange','appleOrange','3f50e2e28298955c913fc88446a057e92f0eba4c7533a5e21a26e74cfe2726e7$1$78579506cfc1ea5bb5bc0ab698b1ff0f86f655bbf60e2eb704ef57e48af99f9c12ab6243bb3e2103b7897af7e9daaa389aa6016bae37212335c6db0239ccc6c3','zzzzzzzzzzzzzzzzz',NULL,0),(4,'zzzzz','zzzzz','zzzzz','4c6ce5ac30c14d74feb6b98a98ee03011dd4feef34d22a07ff6d76a347449f39$1$78238916dfe2df64d857894b926b85ea0f6ac48d20b5d7db9103abf74ac660e6d611db809f41f4f3ad55c58307a26f6cf6923f7d646660ed157d308ed6878d18','zzzzz',NULL,0),(5,'qwerty','qwerty','qwerty','c53a375f1120831dc861641ff929edcaeaed7ec0bf4f9589ab85b7cd351545c8$1$5f9f549e664caee0324223e7b72cd554074b1ce66444399b977ffd72abcda9cfb925bd0e9360659b29430b424d02e18ec1729610483e7dca2dbbe9de98868b20','qwerty',NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-30 18:58:16
