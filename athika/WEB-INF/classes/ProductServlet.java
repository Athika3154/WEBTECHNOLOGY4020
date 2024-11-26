import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("product_name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/cosmetics_db";
        String username = "root"; // Replace with your MySQL username
        String password = "root"; // Replace with your MySQL password

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT quantity FROM products WHERE product_name = '" + productName + "'";
            ResultSet rs = stmt.executeQuery(query);

            out.println("<html><body>");
            if (rs.next()) {
                int quantity = rs.getInt("quantity");
                out.println("<h1>Product: " + productName + "</h1>");
                out.println("<p>Available Quantity: " + quantity + "</p>");
            } else {
                out.println("<h1>No product found for: " + productName + "</h1>");
            }
            out.println("</body></html>");
            conn.close();
        } catch (Exception e) {
            out.println("<h2>Error accessing the database</h2>");
            e.printStackTrace(out);
        }
    }
}
