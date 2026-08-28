import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.io.PrintWriter;

@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String idParam = request.getParameter("id");

        // ✅ Check if ID is empty
        if (idParam == null || idParam.trim().isEmpty()) {
            out.print("{\"error\":\"ID is required\"}");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);

            Class.forName("com.mysql.cj.jdbc.Driver");

           Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM students WHERE id=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // ✅ If record found
            if (rs.next()) {
                out.print("{");
                out.print("\"id\":\"" + rs.getInt("id") + "\",");
                out.print("\"name\":\"" + rs.getString("name") + "\",");
                out.print("\"email\":\"" + rs.getString("email") + "\",");
                out.print("\"phone\":\"" + rs.getString("phone") + "\",");
                out.print("\"gender\":\"" + rs.getString("gender") + "\",");
                out.print("\"course\":\"" + rs.getString("course") + "\",");
                out.print("\"city\":\"" + rs.getString("city") + "\"");
                out.print("}");
            } else {
                // ✅ If ID not found
                out.print("{\"error\":\"No record found\"}");
            }

            // ✅ Close resources
            rs.close();
            ps.close();
            con.close();

        } catch (NumberFormatException e) {
            out.print("{\"error\":\"Invalid ID format\"}");
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"error\":\"Server error\"}");
        }
    }
}
