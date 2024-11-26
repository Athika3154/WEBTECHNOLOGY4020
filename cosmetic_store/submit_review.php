<?php
include('includes/db_config.php');

// Check if form data is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $product_id = 1; // You can dynamically set this based on the product
    $username = $_POST['username'];
    $rating = $_POST['rating'];
    $review_text = $_POST['review_text'];

    // Insert review into the database
    $sql = "INSERT INTO reviews (product_id, username, rating, review_text)
            VALUES ('$product_id', '$username', '$rating', '$review_text')";

    if ($conn->query($sql) === TRUE) {
        header("Location: product_page.php"); // Redirect to product page after submission
        exit();
    } else {
        echo "Error: " . $conn->error;
    }
}
?>
