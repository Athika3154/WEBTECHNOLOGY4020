<?php
// Database connection configuration
$host = "localhost"; // Your database host, usually "localhost"
$username = "root";  // Your database username
$password = "root";      // Your database password (empty for XAMPP default)
$database = "cosmetics_store"; // The name of your database

// Create connection
$conn = new mysqli($host, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// If successfully connected, you can use $conn for queries.
?>
