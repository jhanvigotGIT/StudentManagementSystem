
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "250605");
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE id=?");
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
            response.sendRedirect("index.html?success=deleted");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
