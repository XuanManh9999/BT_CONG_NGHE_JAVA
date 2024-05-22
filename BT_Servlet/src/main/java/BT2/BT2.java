package BT2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
   BT2. Sử dụng JSP xây dựng một form nhập vào ba cạnh bất kỳ của một tam giác. Sau
    đó xây dựng một Servlet thông báo về các tính chất của tam giác được thành lập từ ba
    cạnh kể trên, ví dụ như: là tam giác đều, tam giác cân, không phải là tam giác.
*/
@WebServlet (name = "BT2", urlPatterns = "/BT2")
public class BT2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h1>Enter 3 sides of a triangle</h1>");
        resp.getWriter().println("<form method='post'>");
        resp.getWriter().println("<input type='text' name='side1'>");
        resp.getWriter().println("<input type='text' name='side2'>");
        resp.getWriter().println("<input type='text' name='side3'>");
        resp.getWriter().println("<input type='submit' value='Submit'>");
        resp.getWriter().println("</form>");
        resp.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String side1 = req.getParameter("side1");
        String side2 = req.getParameter("side2");
        String side3 = req.getParameter("side3");
        // check if it is a triangle
        if (side1 == null || side2 == null || side3 == null){
            resp.getWriter().println("Please enter 3 sides of a triangle");
        }else {
            int s1 = Integer.parseInt(side1);
            int s2 = Integer.parseInt(side2);
            int s3 = Integer.parseInt(side3);
            if (s1 + s2 > s3 && s1 + s3 > s2 && s2 + s3 > s1){
                if (s1 == s2 && s2 == s3){
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println("<h1>It is an equilateral triangle</h1>");
                    resp.getWriter().println("</body></html>");
                }else if (s1 == s2 || s2 == s3 || s1 == s3){
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println("<h1>It is an isosceles triangle</h1>");
                    resp.getWriter().println("</body></html>");
                }else {
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println("<h1>It is a scalene triangle</h1>");
                    resp.getWriter().println("</body></html>");
                }
            }else {
                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h1>It is not a triangle</h1>");
                resp.getWriter().println("</body></html>");
            }
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
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
