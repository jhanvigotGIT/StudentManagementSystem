import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "250605"
            );

            String query = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            StringBuilder json = new StringBuilder();
            json.append("[");

            boolean first = true;

            while (rs.next()) {

                if (!first) {
                    json.append(",");
                }

                json.append("{");
                json.append("\"id\":").append(rs.getInt("id")).append(",");
                json.append("\"name\":\"").append(rs.getString("name")).append("\",");
                json.append("\"email\":\"").append(rs.getString("email")).append("\",");
                json.append("\"phone\":\"").append(rs.getString("phone")).append("\",");
                json.append("\"gender\":\"").append(rs.getString("gender")).append("\",");
                json.append("\"course\":\"").append(rs.getString("course")).append("\",");
                json.append("\"city\":\"").append(rs.getString("city")).append("\"");
                json.append("}");

                first = false;
            }

            json.append("]");

            out.print(json.toString());

            con.close();

        } catch (Exception e) {
            out.print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
