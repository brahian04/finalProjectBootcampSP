create database BD_bank;
SELECT * FROM bd_bank.customers;
SELECT * FROM bd_bank.products;
SELECT * FROM products WHERE id_product=2;
use bd_bank;
ALTER TABLE customers ALTER COLUMN modification_user SET DEFAULT 'admin';
ALTER TABLE customers ALTER COLUMN creation_user SET DEFAULT 'admin';
INSERT INTO customers (creation_date, creation_user, date_of_birth, document_number, document_type, email, last_name, modification_date, modification_user, name) values ('12/31/2022','admin','05/03/1986','187656','cc','jaimelopez@gmail.com','lopez', '12/31/2022','admin','jaime');
INSERT INTO customers (creation_date, date_of_birth, document_number, document_type, email, last_name, modification_date, name) values ('12/31/2022','05/03/1986','187656','cc','jaimelopez@gmail.com','lopez', '12/31/2022','jaime');