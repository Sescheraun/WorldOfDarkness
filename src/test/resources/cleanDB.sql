drop database WorldOfDarknessTest;
create database WorldOfDarknessTest;
use WorldOfDarknessTest;
-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-10-21 19:45:01.777
-- tables
-- Table: character
CREATE TABLE `character` (characterID int NOT NULL AUTO_INCREMENT, firstName varchar(20) NOT NULL, middleName varchar(20) NULL, lastName varchar(20) NULL, unspentExperience int NOT NULL, approved bool NOT NULL, isDeleted bool NOT NULL DEFAULT 0, user_id int NOT NULL, CONSTRAINT character_pk PRIMARY KEY (characterID));
-- Table: characterSubCritter
CREATE TABLE characterSubCritter (character_characterID int NOT NULL, subCritter_subCritterID int NOT NULL, CONSTRAINT characterSubCritter_pk PRIMARY KEY (character_characterID,subCritter_subCritterID));
-- Table: characterTraits
CREATE TABLE characterTraits (character_characterID int NOT NULL, traitID int NOT NULL, currentRank int NOT NULL DEFAULT 0, description varchar(20) NOT NULL, firstSpecialty varchar(50) NULL, scondSpecialty varchar(50) NULL, currentLevel int NOT NULL DEFAULT 0 COMMENT 'this will be enforced by the software to not exceed the max level for the given trait.', CONSTRAINT characterTraits_pk PRIMARY KEY (character_characterID,traitID));
-- Table: critter
CREATE TABLE critter (critterID int NOT NULL AUTO_INCREMENT, critterName varchar(100) NOT NULL, implemented bool NOT NULL, isDeleted bool NOT NULL DEFAULT 0, CONSTRAINT critter_pk PRIMARY KEY (critterID)) COMMENT 'Human, vampire, Changeling ect...';
-- Table: role
CREATE TABLE role (id int NOT NULL AUTO_INCREMENT, userID int NOT NULL, roleName varchar(100) NOT NULL DEFAULT 'player', userName varchar(100) NOT NULL , isDeleted bool NOT NULL DEFAULT 0, CONSTRAIN  T role_pk PRIMARY KEY (id));
-- Table: subCritter
CREATE TABLE subCritter (subCritterID int NOT NULL AUTO_INCREMENT, subCritterLabel varchar(20) NOT NULL COMMENT 'this will be Kith if the subCritter is pooka for example', critterID int NOT NULL, critterSubName varchar(20) NOT NULL COMMENT 'Pooka, Gangrel, Get of Fenris ect..', firstAdvantage blob NOT NULL, secondAdvantage blob NOT NULL, flaw varchar(500) NOT NULL, isDeleted bool NOT NULL DEFAULT 0, CONSTRAINT subCritter_pk PRIMARY KEY (subCritterID) ) COMMENT 'Vampire : clan Werewolf: tribe, auspice, breed Changeling: Kith, seeming, house mage: tradition/convention Wraith ???';
-- Table: trait
CREATE TABLE trait (traitID int NOT NULL AUTO_INCREMENT, openToCritterID int NULL DEFAULT 0, goodAtSubCritterID int NULL, traitName varchar(100) NOT NULL, specialtyAllowed bool NOT NULL DEFAULT TRUE, minimumScore int NOT NULL DEFAULT 0 COMMENT 'For traits that have no score, like a garou gift, this will be 0', maximumScore int NOT NULL DEFAULT 5 COMMENT 'For traits that have no score, like a garou gift, this will be 0.', traitType varchar(50) NOT NULL COMMENT 'This is the kind of trait it is.  E: Art, realm, discipline, Talent, background ect...', newCost int NOT NULL COMMENT 'This is the cost to buy the first dot in a trait.  For a background it will always be 0.  For things that only have 1 level, it will be the cost t0 buy it', cheapCost int NOT NULL COMMENT 'this is the cost to raise something if you are ''''good at it''''  clan disciplines for example.', normalCost int NOT NULL COMMENT 'this is the cost to buy something on average.  For situations like orphans and spheres, it will be the cost to buy all spheres.', expensiveCost int NOT NULL COMMENT 'this is the cost to buy something that you are not the best at.  Non primary spheres, non clan disciplines for examples.', freebieCost int NOT NULL COMMENT 'This is the cost to buy something with freebie points.', descriptionFile varchar(64) NULL, isDeleted bool NOT NULL DEFAULT 0, CONSTRAINT trait_pk PRIMARY KEY (traitID));
-- Table: user
CREATE TABLE user (id int NOT NULL AUTO_INCREMENT, firstName varchar(20) NOT NULL, lastName varchar(20) NOT NULL, userName varchar(100) NOT NULL COMMENT 'This must also be unique in the database.', authenticator varchar(100) NOT NULL, EmailAddress varchar(100) NOT NULL, phoneNumber char(13) NULL, isDeleted bool NOT NULL DEFAULT 0, CONSTRAINT user_pk PRIMARY KEY (id));
-- foreign keys
-- Reference: Roles_user (table: role)
ALTER TABLE role ADD CONSTRAINT Roles_user FOREIGN KEY Roles_user (userID)    REFERENCES user (id);
-- Reference: Traits_critter (table: trait)
ALTER TABLE trait ADD CONSTRAINT Traits_critter FOREIGN KEY Traits_critter (openToCritterID)    REFERENCES critter (critterID);
-- Reference: Traits_subCritter (table: trait)
ALTER TABLE trait ADD CONSTRAINT Traits_subCritter FOREIGN KEY Traits_subCritter (goodAtSubCritterID)    REFERENCES subCritter (subCritterID);
-- Reference: characterSubCritter_character (table: characterSubCritter)
ALTER TABLE characterSubCritter ADD CONSTRAINT characterSubCritter_character FOREIGN KEY characterSubCritter_character (character_characterID)    REFERENCES `character` (characterID);
-- Reference: characterSubCritter_subCritter (table: characterSubCritter)
ALTER TABLE characterSubCritter ADD CONSTRAINT characterSubCritter_subCritter FOREIGN KEY characterSubCritter_subCritter (subCritter_subCritterID) REFERENCES subCritter (subCritterID);
-- Reference: characterTraits_Traits (table: characterTraits)
ALTER TABLE characterTraits ADD CONSTRAINT characterTraits_Traits FOREIGN KEY characterTraits_Traits (traitID) REFERENCES trait (traitID);
-- Reference: characterTraits_character (table: characterTraits)
ALTER TABLE characterTraits ADD CONSTRAINT characterTraits_character FOREIGN KEY characterTraits_character (character_characterID) REFERENCES `character` (characterID);
-- Reference: character_user (table: character)
ALTER TABLE `character` ADD CONSTRAINT character_user FOREIGN KEY character_user (user_id) REFERENCES user (id);
-- Reference: subCritter_critter (table: subCritter)
ALTER TABLE subCritter ADD CONSTRAINT subCritter_critter FOREIGN KEY subCritter_critter (critterID) REFERENCES critter (critterID);
-- End of file.
INSERT INTO user (firstName, lastName, userName, authenticator, emailAddress, phoneNumber) VALUES ('Ducky', 'Powers', 'negaduck', 'PASSW0RD', 'yousuck@Irule.com','512-555-1212');
INSERT INTO user (firstName, lastName, userName, authenticator, emailAddress, phoneNumber) VALUES ('Jodie', 'Whittaker', 'theDoctor', 'TheSonic', 'theDoctor@gallifray.gov','161-803-3988');
INSERT INTO user (firstName, lastName, userName, authenticator, emailAddress, phoneNumber) VALUES ('Richard', 'Boone', 'Paladin', 'nidalaP', 'Paladin@CarlotonHotel.com','888-GET-HELP');
INSERT INTO user (firstName, lastName, userName, authenticator, emailAddress, phoneNumber, isDeleted) VALUES ('Kent', 'Allard', 'TheShadow', 'TheShadowKnows', 'lamontCranston@cranstonInternational.com','512-555-1212', 1);
INSERT INTO user (firstName, lastName, userName, authenticator, emailAddress, phoneNumber) VALUES ('Drake', 'Mallard', 'totallyNotDarkwingDuck', 'PASSW0RD', 'IAMAWESOME@Irule.com','512-555-1212');
INSERT INTO critter (critterName, implemented) VALUES ('Human',FALSE);
INSERT INTO critter (critterName, implemented) VALUES ('Vampire',FALSE);
INSERT INTO critter (critterName, implemented) VALUES ('Wereworlf',FALSE);
INSERT INTO critter (critterName, implemented) VALUES ('Mage',FALSE);
INSERT INTO critter (critterName, implemented) VALUES ('Changeling',FALSE);
INSERT INTO critter (critterName, implemented) VALUES ('Wraith',FALSE);
INSERT INTO critter (critterName, implemented) VALUES ('Mummy',FALSE);
INSERT INTO critter (critterName, implemented) VALUES ('Bygone',FALSE);
INSERT INTO critter (critterName, implemented) VALUES ('Exalted',FALSE);
INSERT INTO critter (critterName, implemented) VALUES ('Dragon',FALSE);
INSERT INTO role (userID, roleName, userName) VALUES (1, 'Nerf Herder', 'Negaduck');
INSERT INTO role (userID, roleName, userName) VALUES (1, 'The Villain', 'Negaduck');
INSERT INTO role (userID, roleName, userName) VALUES (2, 'The token Female', 'theDoctor');
INSERT INTO role (userID, roleName, userName, isDeleted) VALUES (5, 'The Terror that Flaps', 'totallyNotDarkwingDuck', 1);
