import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String user = (String) session.getAttribute("user");
        if(user != null) {

            String name = (String) session.getAttribute("user");
            String email = (String) session.getAttribute("email");
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }
}
