package BT3;

import com.example.bt_servlet.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
/*
* Bài 3: Sử dụng JSP xây dựng một form nhập vào số ba cạnh bất kỳ của một tam giác.
Sau đó xây dựng một Servlet thông báo thông báo là ba cạnh có lập thành một tam giác
hay không và tính diện tích tam giác (nếu thỏa mãn điều kiện lập thành một tam giác).
* */
@WebServlet (name = "BT3", urlPatterns = "/BT3")
public class BT3 extends HelloServlet {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Enter 3 sides of a triangle</h1>");
        response.getWriter().println("<form method='post'>");
        response.getWriter().println("<input type='text' name='side1'>");
        response.getWriter().println("<input type='text' name='side2'>");
        response.getWriter().println("<input type='text' name='side3'>");
        response.getWriter().println("<input type='submit' value='Submit'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");

    }

    @Override
    public void destroy() {
        super.destroy();
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
                double p = (s1 + s2 + s3) / 2.0;
                double area = Math.sqrt(p * (p - s1) * (p - s2) * (p - s3));
                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h1>It is a triangle</h1>");
                resp.getWriter().println("<h1>Area of the triangle is: " + area + "</h1>");
                resp.getWriter().println("</body></html>");
            }else {
                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h1>It is not a triangle</h1>");
                resp.getWriter().println("</body></html>");
            }
        }
    }
}
