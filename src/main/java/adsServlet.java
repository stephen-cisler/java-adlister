import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addServlet", urlPatterns = "/ads")
public class adsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Ad> ads = DaoFactory.getAdsDao().all();

//        Ad first = ads.all().get(0);

        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/Ads/index.jsp").forward(request, response);
    }
}
