package Action;
import DBconnection.SQLconnection;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CollegePrediction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cutoff = Integer.parseInt(request.getParameter("cutoff"));
        HttpSession session = request.getSession();
        StringBuilder results = new StringBuilder();

        try (Connection conn = SQLconnection.getconnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM college WHERE cutoff <= ?");
            ps.setInt(1, cutoff);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.append(rs.getString("name")).append(" - ").append(rs.getString("location")).append("<br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("results", results.toString());
        response.sendRedirect("prediction_result.jsp");
    }
}
