use javawebproject;

insert into javawebproject.`language` (`name`)
values ('français');
insert into javawebproject.`language`(`name`)
values ('english');

INSERT into javawebproject.Category (name)
VALUES ('Battle Ship');

INSERT into javawebproject.category_language (description, language_id, category_id)
VALUES ('Battle Ship', 2, 1);

INSERT into javawebproject.category_language (description, language_id, category_id)
VALUES ('Vaisseau de Combat', 1, 1);


INSERT into javawebproject.Category (name)
VALUES ('Transport Ship');

INSERT into javawebproject.category_language (description, language_id, category_id)
VALUES ('Transport Ship', 2, 2);

INSERT into javawebproject.category_language (description, language_id, category_id)
VALUES ('Vaisseau de Transport', 1, 2);


INSERT into javawebproject.Category (name)
VALUES ('Exploration Ship');

INSERT into javawebproject.category_language (description, language_id, category_id)
VALUES ('Exploration Ship', 2, 3);

INSERT into javawebproject.category_language (description, language_id, category_id)
VALUES ('Vaisseau d\'Exploration', 1, 3);



INSERT into javawebproject.ship (name, unit_price, URL_image, length_ship, width_ship, height_ship, category_id,
                                 builder)
VALUES ('Millenium Falcon', '10', 'MilleniumFalcon.png', 34, 25, 8, 2, 'Corellian Engineering Corporation');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (1, 2, 'Millenium Falcon');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (1, 1, 'Faucon Millenium');


INSERT into javawebproject.ship (name, unit_price, URL_image, length_ship, width_ship, height_ship, category_id,
                                 builder)
VALUES ('Normandy SR-2', '100', 'NormandySR2.png', 170, 75, 30, 1, 'Cerberus');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (2, 2, 'Normandy SR-2');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (2, 1, 'Normandy SR-2');


INSERT into javawebproject.ship (name, unit_price, URL_image, length_ship, width_ship, height_ship, category_id,
                                 builder)
VALUES ('Tempest', '50', 'Tempest.png', 170, 75, 30, 3, 'Andromeda Initiative');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (3, 2, 'Tempest');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (3, 1, 'Tempète');


INSERT into javawebproject.ship (name, unit_price, URL_image, length_ship, width_ship, height_ship, category_id,
                                 builder)
VALUES ('Unreliable', '5', 'Unreliable.png', 60, 30, 15, 2, 'Andromeda Initiative');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (4, 2, 'Unreliable');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (4, 1, 'Imposteur');


INSERT into javawebproject.ship (name, unit_price, URL_image, length_ship, width_ship, height_ship, category_id,
                                 builder)
VALUES ('USS Enterprise', '500', 'USS_Enterprise.png', 642, 463, 135, 3, 'Starfleet');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (5, 2, 'USS Enterprise');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (5, 1, 'USS Enterprise');


INSERT into javawebproject.ship (name, unit_price, URL_image, length_ship, width_ship, height_ship, category_id,
                                 builder)
VALUES ('Ebon Hawk', '5', 'EbonHawk.png', 21, 22, 5, 2, 'Core Galaxy Systems');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (6, 2, 'Ebon Hawk');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (6, 1, 'Faucon d\'ébène');


INSERT into javawebproject.ship (name, unit_price, URL_image, length_ship, width_ship, height_ship, category_id,
                                 builder)
VALUES ('Battle Barge', '10000', 'Macragge_Honour.png', 10000, 3000, 3560, 1, 'Imperium of Man');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (7, 2, 'Battle Barge');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (7, 1, 'Barge de Bataille');


INSERT into javawebproject.ship (name, unit_price, URL_image, length_ship, width_ship, height_ship, category_id,
                                 builder)
VALUES ('Venator', '1000', 'Venator.png', 1137, 548, 268, 1, 'Kuat Drive Yards');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (8, 2, 'Venator');

insert into javawebproject.ship_language (ship_id, language_id, description)
values (8, 1, 'Venator');