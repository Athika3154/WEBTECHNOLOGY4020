-- Create the database
CREATE DATABASE IF NOT EXISTS cosmetics_store;

-- Use the newly created database
USE cosmetics_store;

-- Create the reviews table
CREATE TABLE IF NOT EXISTS reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Primary key for the review
    product_id INT,                     -- The product associated with the review
    username VARCHAR(255) NOT NULL,      -- Username of the reviewer
    rating INT NOT NULL,                -- Rating given to the product (1-5)
    review_text TEXT NOT NULL,          -- The actual review text
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Timestamp of the review
);

-- You can insert some initial sample data into the reviews table
INSERT INTO reviews (product_id, username, rating, review_text) 
VALUES
    (1, 'JohnDoe', 5, 'This product is amazing! Highly recommend it.'),
    (1, 'JaneSmith', 4, 'Good quality, but a bit expensive.'),
    (2, 'AliceBrown', 3, 'It works, but not as great as I expected.');
