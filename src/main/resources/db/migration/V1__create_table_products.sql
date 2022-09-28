CREATE TABLE products (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    price DECIMAL(19,2) NOT NULL,
    description VARCHAR(100) NOT NULL,
    amount VARCHAR(255),
    PRIMARY KEY (id)
);