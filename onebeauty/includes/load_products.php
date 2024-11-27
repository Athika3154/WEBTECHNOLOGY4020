<?php
function loadProducts() {
    // Load the XML file
    $xml = simplexml_load_file("products/products.xml");

    if ($xml === false) {
        die("Error: Cannot load XML file.");
    }

    // Loop through the XML file and display products
    foreach ($xml->product as $product) {
        echo "<div class='product'>";
        // Ensure the 'image' tag exists, otherwise use a placeholder
        $imagePath = isset($product->image) ? "assets/images/{$product->image}" : "assets/images/placeholder.jpg";
        echo "<img src='{$imagePath}' alt='{$product->name}'>";
        echo "<h2>{$product->name}</h2>";
        echo "<p>{$product->description}</p>";
        echo "<p><strong>Price: ₹{$product->price}</strong></p>";
        echo "<p><strong>Stock: {$product->stock}</strong></p>";
        echo "</div>";
    }
}
?>
