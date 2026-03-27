INSERT INTO product (sku, name, price, description, quantity) VALUES
-- Existing variety
('SKU001', 'Laptop', 55000.50, 'Gaming Laptop', 10),
('SKU002', 'Mouse', 500.00, 'Wireless Mouse', 50),
('SKU003', 'Keyboard', 1500.75, 'Mechanical Keyboard', 30),
('SKU004', 'Monitor', 12000.00, '24 inch LED Monitor', 15),
('SKU005', 'Headphones', 2500.99, 'Noise Cancelling', 20),

-- SAME NAME (Laptop) → different prices (for sorting)
('SKU011', 'Laptop', 45000.00, 'Budget Laptop', 8),
('SKU012', 'Laptop', 65000.00, 'High-end Laptop', 5),
('SKU013', 'Laptop', 50000.00, 'Mid-range Laptop', 7),

-- SAME NAME (Mouse)
('SKU014', 'Mouse', 300.00, 'Basic Mouse', 40),
('SKU015', 'Mouse', 800.00, 'Gaming Mouse', 25),

-- SAME NAME (Keyboard)
('SKU016', 'Keyboard', 1000.00, 'Basic Keyboard', 35),
('SKU017', 'Keyboard', 2500.00, 'RGB Keyboard', 20),

-- Additional variety
('SKU018', 'Tablet', 20000.00, 'Android Tablet', 12),
('SKU019', 'Tablet', 30000.00, 'Premium Tablet', 6),
('SKU020', 'Speaker', 1500.00, 'Mini Speaker', 18);