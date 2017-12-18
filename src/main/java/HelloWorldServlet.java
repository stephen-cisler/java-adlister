import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    private int pageCount = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        pageCount++;
        String name = req.getParameter("name");
        res.getWriter().println("<h1>Hello, World!</h1>");
        res.getWriter().println("<h3>Hello, " + name + ", welcome!</h3>");
        res.getWriter().println("<h4>Times visited: " + pageCount + "<h4>");
        if (req.getParameter("resetCount").equalsIgnoreCase("true")) {
            pageCount = 0;
        }
    }
}


//    Make the page say "Hello, <name>!" if name is passed as part of the query string, otherwise default to "Hello, World!"
//
//        Learn about the .getParameter method on the request object.
//
//        Create a page view counter
//
//        Create a page that displays a number that goes up by 1 everytime the /count page is viewed.
//
//        Bonus
//
//        Allow the user to pass a parameter in the query string to reset the counter.