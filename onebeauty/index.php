<?php
include('db_config.php');  // If needed
include('includes/load_products.php'); // Make sure the function is included correctly
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OneBeauty - Cosmetics Store</title>
    <link rel="stylesheet" href="assets/css/style.css?v=1"> <!-- Correct path to CSS -->
</head>
<body>
    <div class="container">
        <h1>Welcome to OneBeauty</h1>
        <p>Discover the best beauty products for you!</p>

        <div class="products">
            <?php
            loadProducts();  // Ensure this function is correctly loading the products from XML
            ?>
        </div>
    </div>
</body>
</html>
