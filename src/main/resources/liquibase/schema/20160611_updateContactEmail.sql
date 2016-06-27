--liquibase formatted sql
--changeset paladin:20160611_updateContactEmail.sql

ALTER TABLE organizations CHANGE contact_email contact_email VARCHAR(255);

ALTER TABLE organizations ADD COLUMN display_name VARCHAR(255);

