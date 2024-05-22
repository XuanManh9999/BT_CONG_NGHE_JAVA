package BT4;

import com.example.bt_servlet.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*
* Bài 4: Sử dụng JSP xây dựng một form có các giá trị a, b được nhập vào từ textbox. Sau
đó xây dựng một Servlet giải phương trình bậc nhất, trong đó a, b là các hệ số của
phương trình.
*
* */

@WebServlet (name = "BT4", urlPatterns = "/BT4")
public class BT4 extends HelloServlet {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Enter a and b</h1>");
        response.getWriter().println("<form method='post'>");
        response.getWriter().println("<input type='text' name='a'>");
        response.getWriter().println("<input type='text' name='b'>");
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
        // check if it is a triangle
        if (a == null || b == null){
            resp.getWriter().println("Please enter a and b");
        }else {
            double a1 = Double.parseDouble(a);
            double b1 = Double.parseDouble(b);
            if (a1 == 0){
                if (b1 == 0){
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println("<h1>There are infinitely many solutions</h1>");
                    resp.getWriter().println("</body></html>");
                }else {
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println("<h1>There are no solutions</h1>");
                    resp.getWriter().println("</body></html>");
                }
            }else {
                double x = -b1 / a1;
                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h1>There is one solution</h1>");
                resp.getWriter().println("<h1>x = " + x + "</h1>");
                resp.getWriter().println("</body></html>");
            }
        }
    }
}

