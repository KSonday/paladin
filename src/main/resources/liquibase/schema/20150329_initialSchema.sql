--liquibase formatted sql
--changeset paladin:20150329_userTable.sql

Create table users (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
email VARCHAR(100) NOT NULL, 
first_name VARCHAR(100),
last_name VARCHAR(100),
password VARCHAR(100),
user_type VARCHAR(100) NOT NULL,
state VARCHAR(100) NOT NULL,
user_profile_id INT,
title VARCHAR(100),
organization_id INT);

Create table user_profiles (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
employer VARCHAR(100),
practice_area VARCHAR(100),
years_experience VARCHAR(10),
primary_jurisdiction VARCHAR(100),
hour_commitment VARCHAR(10),
insurance TINYINT(1),
supervision TINYINT(1),
previous_experience TINYINT(1),
experience LONGTEXT
);

Create table languages (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
language VARCHAR(100),
user_profile_id INT,
organization_id INT
);

Create table advocacy_areas (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
area VARCHAR(100),
user_profile_id INT,
organization_id INT
);

Create table opportunity_types (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
opportunity VARCHAR(100),
user_profile_id INT,
organization_id INT
);

Create table organizations (
organization_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(100),
phone_number VARCHAR(100)
);


Create table nonprofits (
organization_id INT PRIMARY KEY NOT NULL,
primary_jurisdiction VARCHAR(100),
insurance TINYINT(1),
supervision TINYINT(1),
overview LONGTEXT
);

Create table enterprises (
organization_id INT PRIMARY KEY NOT NULL,
num_lawyers INT,
has_program TINYINT(1),
program_exp LONGTEXT,
org_type VARCHAR(20)
);