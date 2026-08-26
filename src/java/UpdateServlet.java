import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get data
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");
        String city = request.getParameter("city");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college", "root", "250605");

            // ✅ UPDATE QUERY (NOT INSERT)
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=?, email=?, phone=?, gender=?, course=?, city=? WHERE id=?"
            );

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, gender);
            ps.setString(5, course);
            ps.setString(6, city);
            ps.setInt(7, Integer.parseInt(id));

            int rows = ps.executeUpdate();

            // Check success
            if (rows > 0) {
                response.sendRedirect("index.html?success=updated");
            } else {
                response.sendRedirect("index.html?success=error");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
