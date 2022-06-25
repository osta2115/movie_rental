USE movie_rental;
-- USE movie_rental_dev;

CREATE TABLE categories (
    id       INT AUTO_INCREMENT,
    title    VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE directors (
    id           INT AUTO_INCREMENT,
    first_name     VARCHAR(64) NOT NULL,
    last_name      VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE pegi_categories (
    id           INT AUTO_INCREMENT,
    title  VARCHAR(64) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE carriers (
    id           INT AUTO_INCREMENT,
    description VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE branches (
    id           INT AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    postaL_code VARCHAR(6) NOT NULL UNIQUE,
    adres VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE products (
   id INT AUTO_INCREMENT,
    title VARCHAR (64) NOT NULL,
    category_id INT NOT NULL,
    director_id INT NOT NULL,
    pegi_category_id INT NOT NULL,
    carrier_id INT NOT NULL,
    release_date DATE NOT NULL,
    branch_id INT NOT NULL,


    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (director_id) REFERENCES directors(id),
    FOREIGN KEY (pegi_category_id) REFERENCES pegi_categories(id),
    FOREIGN KEY (carrier_id) REFERENCES carriers(id),
    FOREIGN KEY (branch_id) REFERENCES branches(id),
    PRIMARY KEY (id)
);

CREATE TABLE clients (
    id INT AUTO_INCREMENT,
    first_name VARCHAR (32) NOT NULL,
    last_name VARCHAR (32) NOT NULL,
    phone_number VARCHAR (9) NOT NULL,
    email VARCHAR (64) NOT NULL,
    postal_code VARCHAR (6) NOT NULL,
    login VARCHAR (64) UNIQUE NOT NULL,
    admin INT,
    password VARCHAR (64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE rents (
    id INT AUTO_INCREMENT,
    product_id INT NOT NULL,
    client_id INT NOT NULL,
    return_date DATE NOT NULL,
    rent_date DATE NOT NULL,
    
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (client_id) REFERENCES clients(id),
    PRIMARY KEY (id)
);
    
    
    