<form method="post" action="submit_review.php">
    <label for="username">Your Name:</label>
    <input type="text" name="username" required>

    <label for="rating">Rating:</label>
    <input type="number" name="rating" min="1" max="5" required>

    <label for="review_text">Your Review:</label>
    <textarea name="review_text" rows="5" required></textarea>

    <button type="submit">Submit Review</button>
</form>
