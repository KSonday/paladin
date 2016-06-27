--liquibase formatted sql
--changeset paladin:20160525_updateModels.sql

ALTER TABLE user_profiles CHANGE years_experience experience_level VARCHAR(100);

ALTER TABLE user_profiles CHANGE hour_commitment time_commitment VARCHAR(100);

ALTER TABLE user_profiles CHANGE previous_experience probono_exp TINYINT(1);

ALTER TABLE user_profiles ADD COLUMN commitment_duration VARCHAR(50);

ALTER TABLE user_profiles ADD COLUMN supervision_type VARCHAR(50);


ALTER TABLE nonprofits ADD COLUMN supervision_type VARCHAR(50);

ALTER TABLE organizations ADD COLUMN contact_name VARCHAR(100);

ALTER TABLE organizations ADD COLUMN contact_email VARCHAR(15);

ALTER TABLE organizations ADD COLUMN homepage_url VARCHAR(50);

ALTER TABLE opportunities ADD COLUMN commitment_duration VARCHAR(50);

ALTER TABLE opportunities ADD COLUMN time_commitment VARCHAR(50);

ALTER TABLE opportunities ADD COLUMN training VARCHAR(50);

ALTER TABLE opportunities ADD COLUMN cle_credit TINYINT(1);

ALTER TABLE opportunities ADD COLUMN training_duration VARCHAR(50);

