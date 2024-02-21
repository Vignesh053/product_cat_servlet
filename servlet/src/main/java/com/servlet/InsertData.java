package com.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Retrieve form data
        String username = request.getParameter("username");
        String book = request.getParameter("book");
        String feed = request.getParameter("feed");


        String url = "jdbc:mysql://localhost:3306/my_db";
        String user = "root";
        String password = "password";

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            // Prepare and execute SQL statement
            String query = "INSERT INTO feedback (username, book, feed) VALUES (?, ?, ?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, book);
            pst.setString(3, feed);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                // Success response
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("feedback saved.");
            } else {
                // Failure response
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("Failed to insert the record.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (pst != null) {

                try { pst.close();

                } catch (SQLException e) {

                    e.printStackTrace();

                } }
            if (conn != null) {

                try { conn.close();

                } catch (SQLException e) {

                    e.printStackTrace();

                } }
        }
    }
}
