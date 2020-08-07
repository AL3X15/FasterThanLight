create SCHEMA if not exists javawebproject;

use javawebproject;

drop table if exists Line;
drop table if exists order_entity;
drop table if exists User;
drop table if exists Category_Language;
drop table if exists Ship_Language;
drop table if exists Language;
drop table if exists Ship;
drop table if exists Category;

CREATE TABLE javawebproject.`User`
(
    username                VARCHAR(50) PRIMARY key,
    `password`              VARCHAR(200) DEFAULT null,
    authorities             VARCHAR(500) DEFAULT null,
    non_expired             TINYINT(1)   DEFAULT null,
    non_locked              TINYINT(1)   DEFAULT null,
    credentials_non_expired TINYINT(1)   DEFAULT null,
    `enable`                TINYINT(1)   DEFAULT null,
    `name`                  VARCHAR(100) not null,
    first_name              VARCHAR(100) not null,
    email                   VARCHAR(100) not null unique,
    phone_number            VARCHAR(12)  not null,
    postal_code             varchar(4)   not null,
    city                    VARCHAR(100) not null,
    address                 VARCHAR(200) not null,
    gender                  CHAR,
    birth_date              DATETIME,
    CONSTRAINT CheckBirthDate CHECK (birth_date < SYSDATE()),
    CONSTRAINT CheckGender CHECK (gender = 'M' or gender = 'F' or gender = 'A')
);

CREATE TABLE javawebproject.`Language`
(
    id     INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) UNIQUE not null
);

CREATE TABLE javawebproject.Category
(
    id INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE javawebproject.Ship
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    unit_price  FLOAT        not null,
    `name`      varchar(100) not null,
    URL_image   VARCHAR(150) unique,
    ship_code   VARCHAR(45)  not null,
    length_ship INT          not null,
    width_ship  INT          not null,
    height_ship INT          not null,
    builder     VARCHAR(150) not null,
    category_id INTEGER      not null,
    FOREIGN KEY (category_id) REFERENCES Category (id),
    CONSTRAINT CheckUnitPrice CHECK (unit_price > 0)
);

CREATE TABLE javawebproject.order_entity
(
    id            INTEGER PRIMARY KEY AUTO_INCREMENT,
    delivery_date datetime,
    creation_date DATETIME    not null,
    username      VARCHAR(50) not null,
    is_pay        TINYINT(1)  not null,
    FOREIGN key (username) REFERENCES `User` (username),
    CONSTRAINT CheckDeliveryDate CHECK (delivery_date > SYSDATE())
);

CREATE TABLE javawebproject.Line
(
    id             INTEGER PRIMARY KEY AUTO_INCREMENT,
    quantity       FLOAT   not null,
    price_per_kilo FLOAT   not null,
    order_id       INTEGER not null,
    ship_id        INTEGER not null,
    FOREIGN KEY (order_id) REFERENCES order_entity (id),
    FOREIGN KEY (ship_id) REFERENCES Ship (id),
    CONSTRAINT CheckQuantity CHECK (quantity > 0),
    CONSTRAINT checkPricePerKilo CHECK (price_per_kilo > 0)
);

CREATE TABLE javawebproject.Ship_Language
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    ship_id     INTEGER      not null,
    language_id INTEGER      not null,
    description VARCHAR(500) not null,
    FOREIGN KEY (ship_id) REFERENCES Ship (id),
    FOREIGN KEY (language_id) REFERENCES Language (id)
);

CREATE TABLE javawebproject.Category_Language
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    category_id INTEGER      not null,
    language_id INTEGER      not null,
    description VARCHAR(500) not null,
    FOREIGN KEY (category_id) REFERENCES Category (id),
    FOREIGN KEY (language_id) REFERENCES Language (id)
);

create TRIGGER javawebproject.TR_CREATION_DATE
    before INSERT
    on order_entity
    for each row
    set new.creation_date = now();