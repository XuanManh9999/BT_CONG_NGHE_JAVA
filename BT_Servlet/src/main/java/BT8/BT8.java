package BT8;

import com.example.bt_servlet.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Bài 8: Sử dụng JSP xây dựng một form nhập vào: Họ tên, ngày sinh, trường, số báo
danh, điểm thi. Trong đó, điểm thi là cấu trúc gồm 3 môn: Toán, Lý, Hóa. Sau đó xây
dựng một Servlet thông báo thí sinh đỗ hay trượt (những thí sinh đỗ có tổng điểm >=15).
* */

@WebServlet (name = "BT8", urlPatterns = "/BT8")
public class BT8 extends HelloServlet {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Enter your information</h1>");
        response.getWriter().println("<form method='post'>");
        response.getWriter().println("<input type='text' name='name' placeholder='Name'>");
        response.getWriter().println("<input type='text' name='dob' placeholder='Date of birth'>");
        response.getWriter().println("<input type='text' name='school' placeholder='School'>");
        response.getWriter().println("<input type='text' name='id' placeholder='ID'>");
        response.getWriter().println("<input type='text' name='math' placeholder='Math'>");
        response.getWriter().println("<input type='text' name='physics' placeholder='Physics'>");
        response.getWriter().println("<input type='text' name='chemistry' placeholder='Chemistry'>");
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
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String school = req.getParameter("school");
        String id = req.getParameter("id");
        String math = req.getParameter("math");
        String physics = req.getParameter("physics");
        String chemistry = req.getParameter("chemistry");
        // check if it is a triangle
        if (name == null || dob == null || school == null || id == null || math == null || physics == null || chemistry == null){
            resp.getWriter().println("Please enter your information");
        }else {
            double math1 = Double.parseDouble(math);
            double physics1 = Double.parseDouble(physics);
            double chemistry1 = Double.parseDouble(chemistry);
            double total = math1 + physics1 + chemistry1;
            if (total >= 15){
                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h1>Congratulations! You passed the exam</h1>");
                resp.getWriter().println("</body></html>");
            }else {
                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h1>Sorry! You failed the exam</h1>");
                resp.getWriter().println("</body></html>");
            }
        }
    }
}
