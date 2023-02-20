package com.servlets;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


import static java.sql.DriverManager.getConnection;

public class RegisterServlet extends HttpServlet {


    //getting userinfo using jdbc

    public static void insertinfo(String name, String password, String email, String gender) throws SQLException, ClassNotFoundException {
        Connection conn=null;
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/loginpage","root","KINGAftab@786");


        String q = "INSERT INTO userdetails(name,password,email,gender)VALUES(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(q);
        stmt.setString(1, name);
        stmt.setString(2, password);
        stmt.setString(3, email);
        stmt.setString(4, gender);
        stmt.executeUpdate();
        conn.close();


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {


            PrintWriter out = resp.getWriter();


            resp.setContentType("text/html");

                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String email = req.getParameter("email");
                String gender = req.getParameter("gender");

                    insertinfo(username, password, email, gender);
                    out.println("<h4 style='color:black;"+"align-items:center;"+"display:flex;"+"justify-content:space-around;"+"background-color:#1e88e5;'>"+"Your details are saved"+"</h4>");


            } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    }







