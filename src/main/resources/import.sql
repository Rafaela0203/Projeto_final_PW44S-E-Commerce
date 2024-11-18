insert into tb_category (name) values ('Floral');
insert into tb_category (name) values ('Frutado');
insert into tb_category (name) values ('Amadeirado');
insert into tb_category (name) values ('Cítrico');
insert into tb_category (name) values ('Atalcado');

INSERT INTO tb_product (price, quantity, category_id, name, description, image, brand, details, ingredients) VALUES (299.90, 20, 1, 'Eau de Parfum Floral', 'Notas de rosa e jasmim', 'https://exemplo.com/imagens/perfume_floral.jpg', 'MarcaA', 'Perfume feminino com fragrância floral e leve', 'Álcool, Água, Fragrância, Extrato de rosa');
INSERT INTO tb_product (price, quantity, category_id, name, description, image, brand, details, ingredients) VALUES (450.00, 15, 2, 'Eau de Parfum Oriental', 'Notas de âmbar e baunilha', 'https://exemplo.com/imagens/perfume_oriental.jpg', 'MarcaB', 'Perfume com toque oriental intenso e marcante', 'Álcool, Água, Fragrância, Óleo de âmbar');
INSERT INTO tb_product (price, quantity, category_id, name, description, image, brand, details, ingredients) VALUES (399.99, 10, 1, 'Eau de Parfum Cítrico', 'Notas de limão e laranja', 'https://exemplo.com/imagens/perfume_citrico.jpg', 'MarcaC', 'Perfume feminino cítrico e refrescante', 'Álcool, Água, Fragrância, Óleo essencial de laranja');
INSERT INTO tb_product (price, quantity, category_id, name, description, image, brand, details, ingredients) VALUES (279.90, 30, 3, 'Eau de Toilette Frutado', 'Notas de pêssego e frutas vermelhas', 'https://exemplo.com/imagens/perfume_frutado.jpg', 'MarcaD', 'Perfume com toque frutado e alegre', 'Álcool, Água, Fragrância, Extrato de frutas vermelhas');
INSERT INTO tb_product (price, quantity, category_id, name, description, image, brand, details, ingredients) VALUES (349.50, 25, 4, 'Eau de Toilette Floral', 'Notas de sândalo e lírio', 'https://exemplo.com/imagens/perfume_amadeirado.jpg', 'MarcaE', 'Perfume feminino com uma mistura floral e amadeirada', 'Álcool, Água, Fragrância, Óleo de sândalo');
INSERT INTO tb_product (price, quantity, category_id, name, description, image, brand, details, ingredients) VALUES (499.00, 5, 5, 'Eau de Parfum Gourmet', 'Notas de baunilha e caramelo', 'https://exemplo.com/imagens/perfume_gourmet.jpg', 'MarcaF', 'Perfume doce e envolvente, com notas gourmets', 'Álcool, Água, Fragrância, Extrato de baunilha');

-- --
-- INSERT INTO tb_user(display_name, username, password) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
-- INSERT INTO tb_user(display_name, username, password) VALUES ('Teste', 'test','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');