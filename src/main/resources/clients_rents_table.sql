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