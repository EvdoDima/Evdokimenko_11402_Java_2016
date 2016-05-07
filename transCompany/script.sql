CREATE TABLE applications
(
    id INTEGER PRIMARY KEY NOT NULL,
    summ INTEGER,
    description VARCHAR,
    customer_id INTEGER NOT NULL,
    name VARCHAR(255)
);
CREATE TABLE cars
(
    id INTEGER PRIMARY KEY NOT NULL,
    model VARCHAR(20) NOT NULL,
    year INTEGER,
    run INTEGER NOT NULL,
    state VARCHAR(60),
    mark VARCHAR(255)
);
CREATE TABLE customers
(
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL,
    tel_number VARCHAR(11) NOT NULL,
    deals VARCHAR,
    user_id INTEGER NOT NULL,
    lastname VARCHAR(20) NOT NULL
);
CREATE TABLE docs
(
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    link VARCHAR(60) NOT NULL
);
CREATE TABLE drivers
(
    id INTEGER PRIMARY KEY NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    tel_number VARCHAR(11),
    driving_exp INTEGER,
    salary_rate DOUBLE PRECISION,
    user_id INTEGER NOT NULL
);
CREATE TABLE orders
(
    id INTEGER PRIMARY KEY NOT NULL,
    description VARCHAR NOT NULL,
    cost INTEGER,
    deadline DATE,
    customer_id INTEGER NOT NULL,
    driver_id INTEGER NOT NULL,
    car_id INTEGER NOT NULL,
    status VARCHAR
);
CREATE TABLE user_role
(
    id INTEGER PRIMARY KEY NOT NULL,
    user_id INTEGER NOT NULL,
    role INTEGER NOT NULL
);
CREATE TABLE users
(
    id INTEGER PRIMARY KEY NOT NULL,
    login VARCHAR(20) NOT NULL,
    password VARCHAR(128) NOT NULL
);
ALTER TABLE applications ADD FOREIGN KEY (summ) REFERENCES ;
ALTER TABLE customers ADD FOREIGN KEY (lastname) REFERENCES users (id);
CREATE UNIQUE INDEX customers_user_id_uindex ON customers (deals);
ALTER TABLE drivers ADD FOREIGN KEY (user_id) REFERENCES ;
CREATE UNIQUE INDEX drivers_user_id_uindex ON drivers (user_id);
ALTER TABLE orders ADD FOREIGN KEY (customer_id) REFERENCES ;
ALTER TABLE orders ADD FOREIGN KEY (driver_id) REFERENCES drivers (id);
ALTER TABLE orders ADD FOREIGN KEY (car_id) REFERENCES ;
ALTER TABLE user_role ADD FOREIGN KEY (user_id) REFERENCES ;
CREATE UNIQUE INDEX users_login_uindex ON users (login);
