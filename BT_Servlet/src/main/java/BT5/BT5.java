package BT5;

import com.example.bt_servlet.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Bài 5: Sử dụng JSP xây dựng một form có các giá trị a, b, c được nhập vào từ textbox.
Sau đó xây dựng một Servlet giải phương trình bậc 2, trong đó a, b, c là các hệ số của
phương trình.
*
*
* */


@WebServlet (name = "BT5", urlPatterns = "/BT5")
public class BT5 extends HelloServlet {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Enter a, b and c</h1>");
        response.getWriter().println("<form method='post'>");
        response.getWriter().println("<input type='text' name='a'>");
        response.getWriter().println("<input type='text' name='b'>");
        response.getWriter().println("<input type='text' name='c'>");
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
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String c = req.getParameter("c");
        // check if it is a triangle
        if (a == null || b == null || c == null){
            resp.getWriter().println("Please enter a, b and c");
        }else {
            double a1 = Double.parseDouble(a);
            double b1 = Double.parseDouble(b);
            double c1 = Double.parseDouble(c);
            if (a1 == 0) {
                if (b1 == 0) {
                    if (c1 == 0) {
                        resp.getWriter().println("<html><body>");
                        resp.getWriter().println("<h1>There are infinitely many solutions</h1>");
                        resp.getWriter().println("</body></html>");
                    } else {
                        resp.getWriter().println("<html><body>");
                        resp.getWriter().println("<h1>There is no solution</h1>");
                        resp.getWriter().println("</body></html>");
                    }
                } else {
                    double x = -c1 / b1;
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println("<h1>There is one solution</h1>");
                    resp.getWriter().println("<h1>x = " + x + "</h1>");
                    resp.getWriter().println("</body></html>");
                }
            } else {
                double delta = b1 * b1 - 4 * a1 * c1;
                if (delta < 0) {
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println("<h1>There is no solution</h1>");
                    resp.getWriter().println("</body></html>");
                } else if (delta == 0) {
                    double x = -b1 / (2 * a1);
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println("<h1>There is one solution</h1>");
                    resp.getWriter().println("<h1>x = " + x + "</h1>");
                    resp.getWriter().println("</body></html>");
                } else {
                    double x1 = (-b1 + Math.sqrt(delta)) / (2 * a1);
                    double x2 = (-b1 - Math.sqrt(delta)) / (2 * a1);
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println("<h1>There are two solutions</h1>");
                    resp.getWriter().println("<h1>x1 = " + x1 + "</h1>");
                    resp.getWriter().println("<h1>x2 = " + x2 + "</h1>");
                    resp.getWriter().println("</body></html>");
                }
            }
        }
    }
}
