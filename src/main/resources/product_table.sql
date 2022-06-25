USE movie_rental;

CREATE TABLE categories (
    id       INT AUTO_INCREMENT,
    title    VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE directors (
    id 			INT AUTO_INCREMENT,
    first_name   	VARCHAR(64) NOT NULL,
    last_name   	VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE pegi_categories (
    id 			INT AUTO_INCREMENT,
    title	VARCHAR(64) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE carriers (
    id 			INT AUTO_INCREMENT,
    description VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE branches (
    id 			INT AUTO_INCREMENT,
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