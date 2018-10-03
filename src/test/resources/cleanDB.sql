drop database WorldOfDarknessTest;
create database WorldOfDarknessTest;
use WorldOfDarknessTest;
-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-10-02 15:14:30.089
-- tables
-- Table: Roles
CREATE TABLE Roles (roleID int NOT NULL, user_id int NOT NULL, CONSTRAINT Roles_pk PRIMARY KEY (roleID));
-- Table: Traits
CREATE TABLE Traits (traitID int NOT NULL AUTO_INCREMENT, openTo_critterID int NULL DEFAULT 0,    goodAt_subCritterID int NULL,    traitName varchar(100) NOT NULL,    specialtyAllowed bool NOT NULL DEFAULT TRUE,    minimumScore int NOT NULL DEFAULT 0 COMMENT 'For traits that have no score, like a garou gift, this will be 0',    maximumScore int NOT NULL DEFAULT 5 COMMENT 'For traits that have no score, like a garou gift, this will be 0.',    traitType varchar(50) NOT NULL COMMENT 'This is the kind of trait it is.  E: Art, realm, discipline, Talent, background ect...',    newCost int NOT NULL COMMENT 'This is the cost to buy the first dot in a trait.  For a background it will always be 0.  For things that only have 1 level, it will be the cost t0 buy it',    cheapCost int NOT NULL COMMENT 'this is the cost to raise something if you are ''''good at it''''  clan disciplines for example.',    normalCost int NOT NULL COMMENT 'this is the cost to buy something on average.  For situations like orphans and spheres, it will be the cost to buy all spheres.',    expensiveCost int NOT NULL COMMENT 'this is the cost to buy something that you are not the best at.  Non primary spheres, non clan disciplines for examples.',    freebieCost int NOT NULL COMMENT 'This is the cost to buy something with freebie points.',    isDeleted bool NOT NULL DEFAULT 0,    CONSTRAINT Traits_pk PRIMARY KEY (traitID));
-- Table: character
CREATE TABLE `character` (    characterID int NOT NULL AUTO_INCREMENT,    firstName varchar(20) NOT NULL,    middleName varchar(20) NULL,    lastName varchar(20) NULL,    critterID int NOT NULL,    unspentExperience int NOT NULL,    approved bool NOT NULL,    isDeleted bool NOT NULL DEFAULT 0,    user_id int NOT NULL,    CONSTRAINT character_pk PRIMARY KEY (characterID));
-- Table: characterTraits
CREATE TABLE characterTraits (    character_characterID int NOT NULL,    traitID int NOT NULL,    currentRank int NOT NULL DEFAULT 0,    description varchar(20) NOT NULL,    firstSpecialty varchar(50) NULL,    scondSpecialty varchar(50) NULL,    currentLevel int NOT NULL DEFAULT 0 COMMENT 'this will be enforced by the software to not exceed the max level for the given trait.',    CONSTRAINT characterTraits_pk PRIMARY KEY (character_characterID,traitID));
-- Table: critter
CREATE TABLE critter (    critterID int NOT NULL AUTO_INCREMENT,    critterName varchar(100) NOT NULL,    implemented bool NOT NULL,    isDeleted bool NOT NULL DEFAULT 0,    CONSTRAINT critter_pk PRIMARY KEY (critterID)) COMMENT 'Human, vampire, Changeling ect...';
-- Table: subCritter
CREATE TABLE subCritter (    subCritterID int NOT NULL AUTO_INCREMENT,    subCritterLabel varchar(20) NOT NULL COMMENT 'this will be Kith if the subCritter is pooka for example',    critterID int NOT NULL,    critterSubName varchar(100) NOT NULL COMMENT 'Pooka, Gangrel, Get of Fenris ect..',    first_advantage varchar(500) NOT NULL,    secondAdvantage varchar(500) NOT NULL,    flaw varchar(500) NOT NULL,    isDeleted bool NOT NULL DEFAULT 0,    CONSTRAINT subCritter_pk PRIMARY KEY (subCritterID)) COMMENT 'Vampire : clan Werewolf: tribe, auspice, breed Changeling: Kith, seeming, house mage: tradition/conventionWraith ???';
-- Table: user
CREATE TABLE user (  id int NOT NULL AUTO_INCREMENT,    firstName varchar(20) NOT NULL,    lastName varchar(20) NOT NULL,    userName varchar(25) NOT NULL COMMENT 'This must also be unique in the database.',    authenticator varchar(100) NOT NULL,    EmailAddress varchar(100) NOT NULL,    phoneNumber char(13) NOT NULL,    isDeleted bool NOT NULL DEFAULT 0,    CONSTRAINT user_pk PRIMARY KEY (id));
-- foreign keys
-- Reference: Roles_user (table: Roles)
ALTER TABLE Roles ADD CONSTRAINT Roles_user FOREIGN KEY Roles_user (user_id) REFERENCES user (id);
-- Reference: Traits_critter (table: Traits)
ALTER TABLE Traits ADD CONSTRAINT Traits_critter FOREIGN KEY Traits_critter (openTo_critterID)    REFERENCES critter (critterID);
-- Reference: Traits_subCritter (table: Traits)
ALTER TABLE Traits ADD CONSTRAINT Traits_subCritter FOREIGN KEY Traits_subCritter (goodAt_subCritterID)    REFERENCES subCritter (subCritterID);
-- Reference: characterTraits_Traits (table: characterTraits)
ALTER TABLE characterTraits ADD CONSTRAINT characterTraits_Traits FOREIGN KEY characterTraits_Traits (traitID)    REFERENCES Traits (traitID);
-- Reference: characterTraits_character (table: characterTraits)
ALTER TABLE characterTraits ADD CONSTRAINT characterTraits_character FOREIGN KEY characterTraits_character (character_characterID)    REFERENCES `character` (characterID);
-- Reference: character_critter (table: character)
ALTER TABLE `character` ADD CONSTRAINT character_critter FOREIGN KEY character_critter (critterID)    REFERENCES critter (critterID);
-- Reference: character_user (table: character)
ALTER TABLE `character` ADD CONSTRAINT character_user FOREIGN KEY character_user (user_id)    REFERENCES user (id);
-- Reference: subCritter_critter (table: subCritter)
ALTER TABLE subCritter ADD CONSTRAINT subCritter_critter FOREIGN KEY subCritter_critter (critterID)    REFERENCES critter (critterID);
INSERT INTO user (firstName, lastName, userName, authenticator, EmailAddress, phoneNumber) VALUES ('Ducky', 'Powers', 'negaduck', 'PASSW0RD', 'yousuck@Irule.com','512-555-1212');
INSERT INTO user (firstName, lastName, userName, authenticator, EmailAddress, phoneNumber) VALUES ('Jodie', 'Whittaker', 'theDoctor', 'TheSonic', 'theDoctor@gallifray.gov','161-803-3988');
INSERT INTO user (firstName, lastName, userName, authenticator, EmailAddress, phoneNumber) VALUES ('Richard', 'Boone', 'Paladin', 'nidalaP', 'Paladin@CarlotonHotel.com','888-GET-HELP');
INSERT INTO user (firstName, lastName, userName, authenticator, EmailAddress, phoneNumber, isDeleted) VALUES ('Kent', 'Allard', 'TheShadow', 'TheShadowKnows', 'lamontCranston@cranstonInternational.com','512-555-1212', 1);
INSERT INTO user (firstName, lastName, userName, authenticator, EmailAddress, phoneNumber) VALUES ('Drake', 'Mallard', 'totallyNotDarkwingDuck', 'PASSW0RD', 'IAMAWESOME@Irule.com','512-555-1212');