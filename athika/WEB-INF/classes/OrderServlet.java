import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String product = request.getParameter("product");
        String quantity = request.getParameter("quantity");

        // Set the content type to HTML
        response.setContentType("text/html");

        // Get the PrintWriter object to write response
        PrintWriter out = response.getWriter();

        // Generate the response page
        out.println("<html><body>");
        out.println("<h2>Order Summary</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Product:</strong> " + product + "</p>");
        out.println("<p><strong>Quantity:</strong> " + quantity + "</p>");
        out.println("<p>Thank you for your order!</p>");
        out.println("</body></html>");
    }
}
