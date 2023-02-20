package com.servlets;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {


            PrintWriter out = response.getWriter();
            String username = request.getParameter("username");
            String password = request.getParameter("password");


            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/loginpage", "root", "KINGAftab@786");
            String query = "select * from userdetails";
            Statement state = conn.createStatement();
            ResultSet rset = state.executeQuery(query);
            while (rset.next()) {
                response.setContentType("text/html");
                String name = rset.getString(1);
                String pass = rset.getString(2);
                // String email = rset.getString(3);
                // String gender=rset.getString(4);

                if (name.equals(username) && pass.equals(password)) {
                    chain.doFilter(request, response);

                }
                else {
                   // out.println("<h4 style='color:black;,align-items:center;,display:flex;,justify-content:space-around;,background-color:#f44336;'>"+"You are not registered"+"</h4>");

                }


            }
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
