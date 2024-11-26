<?php
// Include the database connection from the correct path
include('db_config.php');  // Now this points directly to the db_config.php file in the root folder

// Fetch reviews from the database for a specific product
$product_id = 1; // You can replace this with dynamic product ID
$sql = "SELECT * FROM reviews WHERE product_id = $product_id ORDER BY date DESC";
$result = $conn->query($sql);

// Check if the form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $rating = $_POST['rating'];
    $review_text = $_POST['review_text'];

    // Insert review into the database
    $insert_sql = "INSERT INTO reviews (product_id, username, rating, review_text)
                   VALUES ('$product_id', '$username', '$rating', '$review_text')";
    if ($conn->query($insert_sql) === TRUE) {
        echo "Review added successfully!";
    } else {
        echo "Error: " . $conn->error;
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="product-container">
        <h1>Product Name</h1>
        <div class="product-details">
            <p>Description of the product...</p>
            <p>Price: $XX.XX</p>
        </div>

        <div class="reviews">
            <h2>Customer Reviews</h2>
            <?php
            if ($result->num_rows > 0) {
                // Display reviews
                while ($row = $result->fetch_assoc()) {
                    echo "<div class='review'>
                            <p class='review-text'>" . htmlspecialchars($row['review_text']) . "</p>
                            <p class='review-meta'>Reviewed by " . htmlspecialchars($row['username']) . " on " . $row['date'] . "</p>
                          </div>";
                }
            } else {
                echo "<p>No reviews yet.</p>";
            }
            ?>
        </div>

        <!-- Review Submission Form -->
        <h2>Write a Review</h2>
        <form method="post">
            <label for="username">Your Name:</label>
            <input type="text" name="username" required>

            <label for="rating">Rating:</label>
            <input type="number" name="rating" min="1" max="5" required>

            <label for="review_text">Your Review:</label>
            <textarea name="review_text" rows="5" required></textarea>

            <button type="submit">Submit Review</button>
        </form>
    </div>
</body>
</html>
