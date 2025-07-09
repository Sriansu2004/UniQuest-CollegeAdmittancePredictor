package Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Admin_login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if ("admin".equalsIgnoreCase(name) && "admin".equalsIgnoreCase(pass)) {
            response.sendRedirect("admin_home.jsp?success");
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
