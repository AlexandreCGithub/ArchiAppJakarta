-- +++++++++++++++++++++++++++++++++++++++++++++++++++++ --
-- 
--    TUTORIEL JAVA VEE
--    SCRIPT DE CREATION DES DONNEES EMARKET
-- 
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++ --

-- --------------------------------------------------------
-- les lignes suivantes pour supprimer  
-- les tables existantes dans la base.

DROP TABLE APP.PURCHASE_ORDER ;
DROP TABLE APP.PRODUCT ;
DROP TABLE APP.PRODUCT_CODE ;
DROP TABLE APP.MANUFACTURER ;
DROP TABLE APP.CUSTOMER ;
DROP TABLE APP.MICRO_MARKET ;
DROP TABLE APP.DISCOUNT_CODE ;

-- --------------------------------------------------------

--
-- Structure de la table product
--

CREATE TABLE product (
  id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  selling_price DOUBLE DEFAULT 0,
  PRIMARY KEY (id)
);

--
-- Contenu de la table product
--

INSERT INTO product (id, name, selling_price) VALUES
(1, 'PC configuration de base', 400),
(2, 'PC configuration jeux vidéos', 800),
(3, 'MacBook configuration de base', 600),
(4, 'MacBook configuration performance', 1000);

-- --------------------------------------------------------

--
-- Structure de la table component
--
CREATE TABLE component (
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(255) NOT NULL,
  supplier VARCHAR(255),
  PRIMARY KEY (id)
);

--
-- Contenu de la table component
--

INSERT INTO component (name, supplier) VALUES
('Carte mère', 'Fournisseur1'),
('Processeur', 'Fournisseur1'),
('RAM', 'Fournisseur1'),
('Disque Dur', 'Fournisseur1');

-- --------------------------------------------------------

--
-- Structure de la table product_has_component
--

CREATE TABLE product_has_component (
  product_id INT NOT NULL ,
  component_id INT NOT NULL ,
  quantity INT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (product_id, component_id) ,
  CONSTRAINT fk_product_id
    FOREIGN KEY (product_id )
    REFERENCES product (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_component_id
    FOREIGN KEY (component_id )
    REFERENCES component (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

--
-- Contenu de la table product_has_component
--

INSERT INTO product_has_component (product_id, component_id, quantity) VALUES
(1, 1, 1),
(1, 2, 1),
(2, 1, 1),
(2, 2, 2),
(2, 3, 2),
(3, 3, 1),
(4, 3, 1),
(4, 4, 2);

-- --------------------------------------------------------

--
-- Structure de la table emarket_user
--

CREATE TABLE emarket_user (
  login VARCHAR(50) NOT NULL ,
  password VARCHAR(50) NOT NULL ,
  lastname VARCHAR(100) NOT NULL ,
  firstname VARCHAR(100) NOT NULL ,
  PRIMARY KEY (login)
);

--
-- Contenu de la table emarket_user
--

INSERT INTO emarket_user (login, password, lastname, firstname) VALUES
('admin', '123', 'Dile', 'O'),
('robert', '123', 'Bert', 'Ro'),
('céline', '123', 'Line', 'Cé');

-- --------------------------------------------------------

--
-- Structure de la table user_has_group
--

CREATE TABLE user_has_group (
  login VARCHAR(50) NOT NULL ,
  group_id VARCHAR(50) NOT NULL ,
  PRIMARY KEY (login, group_id) ,
  CONSTRAINT fk_login FOREIGN KEY (login )
    REFERENCES emarket_user (login )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
--
-- Contenu de la table user_has_group
--

INSERT INTO user_has_group (login, group_id) VALUES
('admin', 'admins'),
('céline', 'webusers'),
('robert', 'webusers');

-- --------------------------------------------------------

--
-- Structure de la table shoppingcartitem
--

CREATE TABLE shoppingcartitem (
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  user_login VARCHAR(50) NOT NULL ,
  product_id INT NOT NULL ,
  quantity INT NOT NULL DEFAULT 1,
  PRIMARY KEY (id) ,
  CONSTRAINT fk_shoppingcart_product_id
    FOREIGN KEY (product_id )
    REFERENCES product (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_shoppingcart_user_login
    FOREIGN KEY (user_login )
    REFERENCES emarket_user (login )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

--
-- Contenu de la table shoppingcartitem
--

INSERT INTO shoppingcartitem (user_login, product_id, quantity) VALUES
('robert', 1, 3),
('robert', 4, 1);

