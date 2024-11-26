import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cosmetics")
public class CosmeticRecommendationServlet extends HttpServlet {

    // Handle the GET request
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the skin type from the form submission
        String skinType = request.getParameter("skinType");

        // Set the response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Start HTML response
        out.println("<html><body>");
        out.println("<h1>Cosmetic Recommendations</h1>");

        // Provide recommendations based on the selected skin type
        if (skinType != null && !skinType.isEmpty()) {
            out.println("<h2>Recommended cosmetics for " + skinType + " skin:</h2>");
            switch (skinType.toLowerCase()) {
                case "dry":
                    out.println("<p>We recommend moisturizing creams and hydrating serums. Try products with hyaluronic acid and vitamin E.</p>");
                    break;
                case "oily":
                    out.println("<p>For oily skin, look for oil-free moisturizers and mattifying products. Products with salicylic acid are great!</p>");
                    break;
                case "sensitive":
                    out.println("<p>For sensitive skin, choose products with soothing ingredients like aloe vera or chamomile. Avoid harsh chemicals.</p>");
                    break;
                case "normal":
                    out.println("<p>Normal skin can benefit from most types of products. A gentle cleanser and light moisturizer are perfect.</p>");
                    break;
                default:
                    out.println("<p>Please select a valid skin type.</p>");
                    break;
            }
        } else {
            out.println("<h2>Please select a skin type to get recommendations.</h2>");
        }

        // End HTML response
        out.println("</body></html>");
    }
}
