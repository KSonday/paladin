--liquibase formatted sql
--changeset paladin:20160508_addOpportunities.sql

Create table opportunities (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
title VARCHAR(255),
description LONGTEXT,
organization_id INT,
asignee_id INT
);

alter table languages add column opportunity_id INT;

alter table advocacy_areas add column opportunity_id INT;

alter table opportunity_types add column opportunity_id INT;