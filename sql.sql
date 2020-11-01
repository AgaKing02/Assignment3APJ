
CREATE TABLE books (
	isbn int PRIMARY KEY,
	name VARCHAR ( 20 ),
	author VARCHAR ( 30 ),
	image TEXT ,
	stock int
);
ALTER TABLE books
    ALTER COLUMN isbn 
        SET DEFAULT NEXTVAL('table_id_seq');

CREATE TABLE orders (
	id int PRIMARY KEY,
	username VARCHAR ( 20 ),
	product_id int
);
ALTER TABLE orders
    ALTER COLUMN id
        SET DEFAULT NEXTVAL('orders_id_seq');

CREATE TABLE users (
	username VARCHAR ,
	surname VARCHAR,
    password VARCHAR,
    name VARCHAR,
    id bigint,
    role varchar,
    birthday varchar
);
ALTER TABLE users
    ALTER COLUMN id
        SET DEFAULT NEXTVAL('users_id_seq');