package Action;

import DBconnection.SQLconnection;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Student_register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("username");
        String mail = request.getParameter("email");
        String pass = request.getParameter("password");
        int cutoff = Integer.parseInt(request.getParameter("cutoff"));

        try (Connection conn = SQLconnection.getconnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO student (name, email, password, cutoff) VALUES (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, mail);
            ps.setString(3, pass);
            ps.setInt(4, cutoff);
            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("login.jsp?register=success");
            } else {
                response.sendRedirect("register.jsp?register=fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
