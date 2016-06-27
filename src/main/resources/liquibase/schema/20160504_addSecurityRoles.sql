--liquibase formatted sql
--changeset paladin:20160504_addSecurityRoles.sql

Create table roles (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(100) NOT NULL
);

Create table privileges (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(100) NOT NULL
);

Create table users_roles (
user_id INT,
role_id INT
);

Create table roles_privileges (
role_id INT,
privilege_id INT
);