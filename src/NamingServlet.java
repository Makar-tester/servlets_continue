import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/browser", name="NamingServlet")

public class NamingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //String name = req.getParameter("name");
        String browser = req.getHeader("User-Agent");
        //String surname = req.getParameter("surname");
        //resp.getWriter().write(name + " " +surname);
        resp.getWriter().write("Hello"+browser);
    }

    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        resp.getWriter().write(name + " " +surname);
    }*/


}
