create schema javawebprojectcheeseking;
  
  CREATE TABLE javawebprojectcheeseking.`User` (
    username VARCHAR(50) PRIMARY key,
    `password` VARCHAR(200) DEFAULT null,
    authorities VARCHAR(500) DEFAULT null,
    non_expired TINYINT(1) DEFAULT null,
    non_locked TINYINT(1) DEFAULT null,
    credentials_non_expired TINYINT(1) DEFAULT null,
    `enable` TINYINT(1) DEFAULT null,
    `name` VARCHAR(100) not null,
    first_name VARCHAR(100) not null,
    email VARCHAR(100) not null unique,
    phone_number VARCHAR(12) not null,
    postal_code varchar(4) not null,
    city VARCHAR(100) not null,
    address VARCHAR(200) not null,
    gender CHAR,
    birth_date DATETIME,
    CONSTRAINT CheckBirthDate CHECK(birth_date < SYSTEM_TIME),
    CONSTRAINT CheckGender CHECK(gender = 'M' or gender = 'F' or gender = 'A')
);

CREATE TABLE javawebprojectcheeseking.`Language` (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name`VARCHAR(50) UNIQUE not null
);

CREATE TABLE javawebprojectcheeseking.Cheese (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    price_per_kilo FLOAT not null,
    `name` varchar(100) not null,
    URL_image VARCHAR(150) unique,
    CONSTRAINT CheckPricePerKilo CHECK(price_per_kilo > 0)
);

CREATE TABLE javawebprojectcheeseking.order_entity (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    delivery_date datetime,
    creation_date DATETIME not null,
    username VARCHAR(50) not null,
    is_pay TINYINT(1) not null,
    FOREIGN key(username) REFERENCES `User`(username),
    CONSTRAINT CheckDeliveryDate CHECK(delivery_date > SYSTEM_TIME)
);

CREATE TABLE javawebprojectcheeseking.Line (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    quantity FLOAT not null,
    price_per_kilo FLOAT not null,
    order_id INTEGER not null,
    cheese_id INTEGER not null,
    FOREIGN KEY(order_id) REFERENCES order_entity(id),
    FOREIGN KEY(cheese_id) REFERENCES Cheese(id),
    CONSTRAINT CheckQuantity CHECK(quantity > 0),
    CONSTRAINT checkPricePerKilo CHECK(price_per_kilo > 0)
);

CREATE TABLE javawebprojectcheeseking.Cheese_Language (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    cheese_id INTEGER not null,
    language_id INTEGER not null,
    description VARCHAR(500) not null,
    FOREIGN KEY(cheese_id) REFERENCES Cheese(id),
    FOREIGN KEY(language_id) REFERENCES Language(id)
);

create TRIGGER javawebprojectcheeseking.TR_CREATION_DATE
    before INSERT on order_entity
    for each row
	set new.creation_date = now();