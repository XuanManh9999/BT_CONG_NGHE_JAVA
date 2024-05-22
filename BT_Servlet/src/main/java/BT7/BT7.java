package BT7;



import com.example.bt_servlet.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet (name = "BT7", urlPatterns = "/BT7")

/*
* BT7 Sử dụng JSP xây dựng một form nhập vào các chỉ số cũ, chỉ số mới của công tơ.
Sau đó xây dựng một Servlet tính tiền điện (in kết quả gồm tiền trả định mức, triền trả
vượt định mức, tổng tiền). Tiền được tính gồm các khoảng sau:
- Tiền thuê bao điện kế: 1000đ/tháng
- Định mức sử dụng điện cho mỗi hộ là: 50 KW với giá 230đ/KW
- Nếu phần vượt định mức &lt;= 50KW thì tính giá 480đ/KW
- Nếu 50KW &lt; phần vượt định mức &lt;= 100KW thì tính giá 700đ/KW
- Nếu phần vượt định mức &gt;= 100KW thì tính giá 900đ/KW
*
* */

public class BT7 extends HelloServlet {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Enter the old index and the new index of the meter</h1>");
        response.getWriter().println("<form method='post'>");
        response.getWriter().println("<input type='text' name='oldIndex'>");
        response.getWriter().println("<input type='text' name='newIndex'>");
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
        String oldIndex = req.getParameter("oldIndex");
        String newIndex = req.getParameter("newIndex");
        // check if it is a triangle
        if (oldIndex == null || newIndex == null){
            resp.getWriter().println("Please enter the old index and the new index of the meter");
        }else {
            int oldIndex1 = Integer.parseInt(oldIndex);
            int newIndex1 = Integer.parseInt(newIndex);
            int money = 0;
            int used = newIndex1 - oldIndex1;
            if (used <= 50){
                money = 50 * 230;
            }else if (used <= 100){
                money = 50 * 230 + (used - 50) * 480;
            }else if (used <= 150){
                money = 50 * 230 + 50 * 480 + (used - 100) * 700;
            }else {
                money = 50 * 230 + 50 * 480 + 50 * 700 + (used - 150) * 900;
            }
            resp.getWriter().println("<html><body>");
            resp.getWriter().println("<h1>Money to pay: " + money + "</h1>");
            resp.getWriter().println("</body></html>");
        }
    }
}
