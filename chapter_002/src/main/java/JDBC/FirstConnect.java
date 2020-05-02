package JDBC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Properties;

public class FirstConnect {
    private static final Logger log= LoggerFactory.getLogger(FirstConnect.class);

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Query";
        String userName="postgres";
        String password="password";
        Connection conn=null;
        conn = DriverManager.getConnection(url, userName, password);
        PreparedStatement st = conn.prepareStatement("SELECT * FROM product");
        ResultSet rs = st.executeQuery("SELECT * FROM product");
        while (rs.next())
        {
            System.out.println(rs.getString(2));
        }
        rs.close();
        st.close();
        conn.close();
    }
}
