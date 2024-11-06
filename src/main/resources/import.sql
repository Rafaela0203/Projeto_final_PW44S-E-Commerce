insert into tb_category (name) values ('Informática');
insert into tb_category (name) values ('UD');
insert into tb_category (name) values ('Cozinha');
insert into tb_category (name) values ('Móveis');
insert into tb_category (name) values ('Eletrônico');

INSERT INTO tb_product (name, brand, description, price, details, quantity, ingredients, category_id) VALUES('Chanel No. 5', 'Chanel', 'Perfume floral icônico com notas de jasmim e rosa.', 950.00, 'Eau de Parfum, 100ml', 20, 'Álcool, Água, Fragrância, Geraniol, Limoneno', 1);
INSERT INTO tb_product (name, brand, description, price, details, quantity, ingredients, category_id) VALUES('La Vie Est Belle', 'Lancôme', 'Fragrância gourmand com notas de íris, jasmim e flor de laranjeira.', 750.00, 'Eau de Parfum, 75ml', 15, 'Álcool, Água, Fragrância, Benzil Benzoato, Linalol', 1);
INSERT INTO tb_product (name, brand, description, price, details, quantity, ingredients, category_id) VALUES('Good Girl', 'Carolina Herrera', 'Perfume oriental floral com notas de tuberosa e jasmim árabe.', 680.00, 'Eau de Parfum, 80ml', 25, 'Álcool, Água, Fragrância, Cinnamyl Alcohol, Geraniol', 1);
INSERT INTO tb_product (name, brand, description, price, details, quantity, ingredients, category_id) VALUES('Jadore', 'Dior', 'Fragrância floral frutada com notas de ylang-ylang e rosa damascena.', 870.00, 'Eau de Parfum, 100ml', 18, 'Álcool, Água, Fragrância, Benzyl Salicylate, Hydroxycitronellal', 1);
INSERT INTO tb_product (name, brand, description, price, details, quantity, ingredients, category_id) VALUES('Black Opium', 'Yves Saint Laurent', 'Perfume oriental gourmand com notas de café e baunilha.', 820.00, 'Eau de Parfum, 90ml', 22, 'Álcool, Água, Fragrância, Coumarin, Limonene', 1);


INSERT INTO tb_user(display_name, username, password) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO tb_user(display_name, username, password) VALUES ('Teste', 'test','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');