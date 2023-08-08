-- Insert sample users
INSERT INTO users (name, email, role, password) VALUES
    ('John Doe', 'john@example.com', 'USER', 'password123'),
    ('Jane Smith', 'jane@example.com', 'ADMIN', 'admin123');

-- Insert sample books
INSERT INTO books (book_name) VALUES
    ('Book 1'),
    ('Book 2'),
    ('Book 3');

-- Insert sample book_user mappings
INSERT INTO book_user (user_id, book_id) VALUES
    (1, 1),
    (1, 2),
    (2, 3);

-- Insert sample securities
INSERT INTO securities (isin, cusip, issuer, maturity_date, coupon, type, face_value, status) VALUES
    ('ISIN123', 'CUSIP123', 'Issuer A', '2023-12-31', 3.5, 'Corporate Bond', 1000.0, 'ACTIVE'),
    ('ISIN456', 'CUSIP456', 'Issuer B', '2024-06-30', 4.0, 'Government Bond', 1500.0, 'ACTIVE');

-- Insert sample trades
INSERT INTO trades (book_id, counterparty_id, security_id, quantity, status, price, buy_sell, trade_date, settlement_date) VALUES
    (1, 2, 1, 100, 'OPEN', 105.0, 'BUY', '2023-08-01', '2023-08-05'),
    (2, 1, 2, 200, 'CLOSED', 98.0, 'SELL', '2023-08-02', '2023-08-06');
    
-- Insert sample counterparties
INSERT INTO counterparties (name) VALUES
    ('Counterparty 1'),
    ('Counterparty 2');
