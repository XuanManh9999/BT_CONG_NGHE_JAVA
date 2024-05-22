package BT1;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet (name = "BT1", urlPatterns = "/BT1")
public class BT1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h1>Enter a number</h1>");
        resp.getWriter().println("<form method='post'>");
        resp.getWriter().println("<input type='text' name='number'>");
        resp.getWriter().println("<input type='submit' value='Submit'>");
        resp.getWriter().println("</form>");
        resp.getWriter().println("</body></html>");

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String number = req.getParameter("number");
        // tinh tong cac chu so
        int sum = 0;
        if (number == null){
            resp.getWriter().println("Please enter a number");
        }else {
            for (int i = 0; i < number.length(); i++){
                sum += Integer.parseInt(String.valueOf(number.charAt(i)));
            }
        }
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h1>Tổng của các chữ số là</h1>");
        resp.getWriter().println("<h1>" + sum + "</h1>");
        resp.getWriter().println("</body></html>");

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
