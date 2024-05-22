package BT6;

import com.example.bt_servlet.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Bài 6: Sử dụng JSP xây dựng một form nhập vào số km từ textbox. Sau đó xây dựng một
Servlet tính tiền cước taxi, biết rằng: 1km đầu tiên là 14.000đ, mỗi km tiếp theo là
13.000đ. Nếu lớn hơn 30km thì mỗi km thêm sẽ là 11.000đ.
*
* */

@WebServlet (name = "BT6", urlPatterns = "/BT6")
public class BT6 extends HelloServlet {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Enter the number of km</h1>");
        response.getWriter().println("<form method='post'>");
        response.getWriter().println("<input type='text' name='km'>");
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
        String km = req.getParameter("km");
        // check if it is a triangle
        if (km == null){
            resp.getWriter().println("Please enter the number of km");
        }else {
            int km1 = Integer.parseInt(km);
            int money = 0;
            if (km1 <= 0){
                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h1>Invalid input</h1>");
                resp.getWriter().println("</body></html>");
            }else if (km1 <= 30){
                money = 14000 + (km1 - 1) * 13000;
            }else {
                money = 14000 + 29 * 13000 + (km1 - 30) * 11000;
            }
            resp.getWriter().println("<html><body>");
            resp.getWriter().println("<h1>Money: " + money + "</h1>");
            resp.getWriter().println("</body></html>");
        }
    }
}
