--liquibase formatted sql
--changeset paladin:20160525_activeOpportunities.sql

Create table active_opportunities (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
token VARCHAR(70) NOT NULL,
active TINYINT(1) NOT NULL DEFAULT 1,
user_id INT NOT NULL,
opportunity_id INT NOT NULL
);