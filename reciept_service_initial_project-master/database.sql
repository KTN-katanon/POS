--
-- File generated with SQLiteStudio v3.3.3 on Wed Sep 21 13:49:13 2022
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: category
DROP TABLE IF EXISTS category;

CREATE TABLE category (
    category_id   INTEGER   PRIMARY KEY ASC AUTOINCREMENT,
    category_name TEXT (50) NOT NULL
);

INSERT INTO category (
                         category_id,
                         category_name
                     )
                     VALUES (
                         1,
                         'MyCoffee'
                     );

INSERT INTO category (
                         category_id,
                         category_name
                     )
                     VALUES (
                         2,
                         'dessert'
                     );

INSERT INTO category (
                         category_id,
                         category_name
                     )
                     VALUES (
                         3,
                         'candy'
                     );


-- Table: product
DROP TABLE IF EXISTS product;

CREATE TABLE product (
    product_id          INTEGER   PRIMARY KEY ASC AUTOINCREMENT,
    product_name        TEXT (50) UNIQUE,
    product_price       DOUBLE    NOT NULL,
    product_size        TEXT (5)  DEFAULT SML
                                  NOT NULL,
    product_sweet_level TEXT (5)  DEFAULT (123) 
                                  NOT NULL,
    product_type        TEXT (5)  DEFAULT HCF
                                  NOT NULL,
    category_id         INTEGER   DEFAULT (1) 
                                  NOT NULL
                                  REFERENCES category (category_id) ON DELETE SET NULL
                                                                    ON UPDATE CASCADE
);

INSERT INTO product (
                        product_id,
                        product_name,
                        product_price,
                        product_size,
                        product_sweet_level,
                        product_type,
                        category_id
                    )
                    VALUES (
                        1,
                        'Espresso',
                        30.0,
                        'SML',
                        '0123',
                        'HCF',
                        1
                    );

INSERT INTO product (
                        product_id,
                        product_name,
                        product_price,
                        product_size,
                        product_sweet_level,
                        product_type,
                        category_id
                    )
                    VALUES (
                        2,
                        'Americano',
                        40.0,
                        'SML',
                        '012',
                        'HC',
                        1
                    );

INSERT INTO product (
                        product_id,
                        product_name,
                        product_price,
                        product_size,
                        product_sweet_level,
                        product_type,
                        category_id
                    )
                    VALUES (
                        3,
                        'เค้กชิฟฟ่อนช็อกโกแลต',
                        50.0,
                        '-',
                        '-',
                        '-',
                        2
                    );

INSERT INTO product (
                        product_id,
                        product_name,
                        product_price,
                        product_size,
                        product_sweet_level,
                        product_type,
                        category_id
                    )
                    VALUES (
                        4,
                        'บัตเตอร์เค้ก',
                        60.0,
                        '-',
                        '-',
                        '-',
                        2
                    );


-- Table: user
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    user_id       INTEGER   PRIMARY KEY ASC AUTOINCREMENT,
    user_login    TEXT (50) UNIQUE,
    user_gender   TEXT (3)  NOT NULL,
    user_password TEXT (50) NOT NULL,
    user_role     INTEGER   NOT NULL,
    user_name     TEXT (50) 
);

INSERT INTO user (
                     user_id,
                     user_login,
                     user_gender,
                     user_password,
                     user_role,
                     user_name
                 )
                 VALUES (
                     6,
                     'werapan',
                     'M',
                     'password',
                     1,
                     'Worawit'
                 );

INSERT INTO user (
                     user_id,
                     user_login,
                     user_gender,
                     user_password,
                     user_role,
                     user_name
                 )
                 VALUES (
                     10,
                     'admin',
                     'M',
                     'password',
                     0,
                     'Administrator'
                 );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
