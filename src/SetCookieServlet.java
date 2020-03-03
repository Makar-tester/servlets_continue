import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/setCookie", name="SetCookieServlet")

public class SetCookieServlet extends HttpServlet {

    private static final int DAY = 24*60*60;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String username=req.getParameter("Username");
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(DAY);
        resp.addCookie(cookie);
    }
}
