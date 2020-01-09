### CREATE USERS
CREATE DATABASE sfg_dev;
CREATE DATABASE sfg_prod;

### CREATE USERS
CREATE USER 'sfg_dev_user'@'localhost' IDENTIFIED BY 'guru';
CREATE USER 'sfg_prod_user'@'localhost' IDENTIFIED BY 'guru';
CREATE USER 'sfg_dev_user'@'%' IDENTIFIED BY 'guru';
CREATE USER 'sfg_prod_user'@'%' IDENTIFIED BY 'guru';

### DATABASE GRANTS
## DEV
GRANT SELECT ON sfg_dev.* TO 'sfg_dev_user'@'localhost';
GRANT INSERT ON sfg_dev.* TO 'sfg_dev_user'@'localhost';
GRANT UPDATE ON sfg_dev.* TO 'sfg_dev_user'@'localhost';
GRANT DELETE ON sfg_dev.* TO 'sfg_dev_user'@'localhost';
GRANT SELECT ON sfg_dev.* TO 'sfg_dev_user'@'%';
GRANT INSERT ON sfg_dev.* TO 'sfg_dev_user'@'%';
GRANT UPDATE ON sfg_dev.* TO 'sfg_dev_user'@'%';
GRANT DELETE ON sfg_dev.* TO 'sfg_dev_user'@'%';
## PROD
GRANT SELECT ON sfg_prod.* TO 'sfg_prod_user'@'localhost';
GRANT INSERT ON sfg_prod.* TO 'sfg_prod_user'@'localhost';
GRANT UPDATE ON sfg_prod.* TO 'sfg_prod_user'@'localhost';
GRANT DELETE ON sfg_prod.* TO 'sfg_prod_user'@'localhost';
GRANT SELECT ON sfg_prod.* TO 'sfg_prod_user'@'%';
GRANT INSERT ON sfg_prod.* TO 'sfg_prod_user'@'%';
GRANT UPDATE ON sfg_prod.* TO 'sfg_prod_user'@'%';
GRANT DELETE ON sfg_prod.* TO 'sfg_prod_user'@'%';