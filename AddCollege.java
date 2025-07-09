package Action;
import DBconnection.SQLconnection;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AddCollege extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String course = request.getParameter("course");
        int cutoff = Integer.parseInt(request.getParameter("cutoff"));

        try (Connection conn = SQLconnection.getconnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO college (name, location, course, cutoff) VALUES (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, location);
            ps.setString(3, course);
            ps.setInt(4, cutoff);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("admin_home.jsp");
    }
}
