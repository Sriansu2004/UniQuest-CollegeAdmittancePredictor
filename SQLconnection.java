package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLconnection {
    public static Connection getconnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college_predictor", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
