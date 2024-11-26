<?php
// db_connection.php
$servername = "localhost";
$username = "root";
$password = "root";  // Replace with your MySQL root password if needed
$dbname = "cosmetics_store";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
