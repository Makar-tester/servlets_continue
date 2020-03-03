import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Locale.filter;

public class CookieCounterServlet extends HttpServlet {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie userCookie = Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals("username"))
                .findAny().orElse(null);
         if(getServletContext().getAttribute(userCookie.getValue())==null){
             getServletContext().setAttribute(userCookie.getValue(), "logged in");
             resp.getWriter().write("Counter value is "+counter.incrementAndGet());
         } else {
             resp.getWriter().write("Counter value is "+counter.get());
         }
    }
}
