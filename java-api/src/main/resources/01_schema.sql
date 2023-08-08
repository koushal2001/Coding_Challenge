-- Create the users table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    password VARCHAR(255)
);

-- Create the books table
CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(255) NOT NULL
);

-- Create the book_user table
CREATE TABLE book_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    book_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

-- Create the securities table
CREATE TABLE securities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    isin VARCHAR(255),
    cusip VARCHAR(255),
    issuer VARCHAR(255) NOT NULL,
    maturity_date DATE,
    coupon DECIMAL(10, 2),
    type VARCHAR(255),
    face_value DECIMAL(10, 2),
    status VARCHAR(255)
);

-- Create the trades table
CREATE TABLE trades (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT,
    counterparty_id BIGINT,
    security_id BIGINT,
    quantity DECIMAL(10, 2),
    status VARCHAR(255),
    price DECIMAL(10, 2),
    buy_sell VARCHAR(255),
    trade_date DATE,
    settlement_date DATE,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (counterparty_id) REFERENCES users(id),
    FOREIGN KEY (security_id) REFERENCES securities(id)
);

-- Create the counterparties table
CREATE TABLE counterparties (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
