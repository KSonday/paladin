--liquibase formatted sql
--changeset paladin:20160619_furtherMVPupdates.sql


ALTER TABLE organizations ADD COLUMN form_type VARCHAR(20);