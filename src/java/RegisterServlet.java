import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");
        String city = request.getParameter("city");

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection con = DBConnection.getConnection();
            
             Statement st = con.createStatement();
            st.executeUpdate("ALTER TABLE students AUTO_INCREMENT = 100");

            // Prepare statement with ID return
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(name,email,phone,gender,course,city) VALUES(?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS
            );

            // Set values
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, gender);
            ps.setString(5, course);
            ps.setString(6, city);

            // Execute query (ONLY ONCE)
            ps.executeUpdate();

            // Get generated ID
            ResultSet rs = ps.getGeneratedKeys();
            int id = 100;

            if (rs.next()) {
                id = rs.getInt(1);
            }

            // Redirect with success + ID
            response.sendRedirect("index.html?success=1&id=" + id);

            // Close connection
            con.close();

         } catch (Exception e) {
    e.printStackTrace();
    response.setContentType("text/html");
    response.getWriter().println("<h2>Registration Error</h2>");
    response.getWriter().println("<p>" + e.getMessage() + "</p>");
}

        System.out.println("Servlet hit successfully");
    }
}