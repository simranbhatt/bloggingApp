CREATE DATABASE PenseDatabase;

USE PenseDatabase;

CREATE TABLE PenseUsers (
firstname VARCHAR(50) NOT NULL,
lastname VARCHAR(50),
email NVARCHAR(320) NOT NULL,
password VARCHAR(50) NOT NULL,
userID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (userID));


CREATE TABLE PensePosts (
PostID INT NOT NULL AUTO_INCREMENT,
title VARCHAR(200), 
timestamp VARCHAR(200), 
tag VARCHAR(30), 
description VARCHAR(5000),
email NVARCHAR(320) NOT NULL,
PRIMARY KEY (PostID));