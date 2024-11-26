import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");  // Get the 'name' parameter from the request
        response.setContentType("text/html");  // Set the response content type to HTML
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Hello Servlet</title></head>");
        response.getWriter().println("<body style='background: linear-gradient(45deg, #ff6f61, #ffbc00, #00b3b3, #6a5acd); color: white;'>");
        response.getWriter().println("<h1 style='text-shadow: 0 0 30px rgba(255, 255, 255, 0.9), 0 0 60px rgba(255, 255, 255, 0.8);'>");
        response.getWriter().println("Hello, " + (name != null ? name : "World") + "!");
        response.getWriter().println("</h1>");
        response.getWriter().println("<a href='index.html' style='color: white; font-size: 1.5em; text-decoration: none;'>Go back</a>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
