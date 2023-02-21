package com.servlets;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


import static java.sql.DriverManager.getConnection;

public class LoginServlet extends HttpServlet {


    //getting userinfo using jdbc


   /* public static void dispaly() throws SQLException {
        Connection conn = getConnection("jdbc:mysql://localhost:3306/jdbclibrary","root", "KINGAftab@786");
        String query = "select * from userdetails";
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery(query);
        while (rset.next()) {
            String username = rset.getString(1);
            String password = rset.getString(2);
            String email = rset.getString(3);
            String gender=rset.getString(4);


        }
        conn.close();

    }*/


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String newstr = "";


            PrintWriter out = resp.getWriter();
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String gender = req.getParameter("gender");
            newstr = req.getParameter("button");

            if (newstr.equals("Display")) {
                Connection conn = null;
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/loginpage", "root", "KINGAftab@786");
                String query = "select * from userdetails";
                Statement state = conn.createStatement();
                ResultSet rset = state.executeQuery(query);
                while (rset.next()) {
                    resp.setContentType("text/html");
                    username = rset.getString(1);
                    password = rset.getString(2);
                    email = rset.getString(3);
                    gender = rset.getString(4);
                    out.println("<h4 style='color:black;"+"align-items:center;"+"display:flex;"+
                            "justify-content:space-around;"+"background-color:#e1f5fe;'>" +
                            ""+"username:"+"&nbsp;"+"&nbsp;"+username+"&nbsp;"+"&nbsp;"+"email:"+"&nbsp;"+"&nbsp;"+email+
                            "&nbsp;"+"&nbsp;"+"gender:"+"&nbsp;"+"&nbsp;"+gender+"</h4>");

                    //out.println("<h3  style='color:black;,align-items:center;,display:flex;,justify-content:flex-start;,background-color:#e1f5fe;>" + username + "  " + email + " " + gender + "</h3>");

                }
                conn.close();


            } else if (newstr.equals("Register")) {

                RequestDispatcher newpage = req.getRequestDispatcher("newindex.html");
                newpage.forward(req, resp);


            } else if (newstr.equals("Login")) {


                Connection conn = null;
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/loginpage", "root", "KINGAftab@786");
                String query = "select * from userdetails";
                Statement state = conn.createStatement();
                ResultSet rset = state.executeQuery(query);
                boolean flag=false;
                while(rset.next()) {
                    resp.setContentType("text/html");
                    String name = rset.getString(1);
                    String pass = rset.getString(2);
                    // String email = rset.getString(3);
                    // String gender=rset.getString(4);

                    if (name.equals(username) && pass.equals(password)) {
                        flag=true;
                        out.println("<!DOCTYPE html>");
                        out.println("<h3> Welcome to Login page</h3>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<meta charset=\"utf-8\">");  // escape the quote marks
                        out.println("<title>Registration</title>");
                        out.println("<style>");     // start style
                        // enclose style attributes withing the <style> </style> elements
                        out.println("h3 {");        // note leading brace
                        out.println("color:black;");
                        out.println("align-items:center;");
                        out.println(" display: flex;");
                        out.println("justify-content: space-around;");
                        out.println("background-color:#87eba28f;");
                        out.println("\n");
                        out.println("}");
                        out.println("</style>");  // terminate style
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<img  src='loginimage.png' width='100%' height='100%' ");
                        out.println("</body>");
                        out.println("</html>");
                        break;
                    }


                }
                if(!flag){
                    out.println("<h4 style='color:black;"+"align-items:center;"+"display:flex;"+"justify-content:space-around;"+"background-color:#f44336;'>"+"You are not registered"+"</h4>");

                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}




