--liquibase formatted sql
--changeset paladin:20160611_homepageUrlSize.sql

ALTER TABLE organizations CHANGE homepage_url homepage_url VARCHAR(255);