package com.mycalculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcultorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer=resp.getWriter();
        int x,y;
        String str="";
        x=Integer.parseInt(req.getParameter("first"));
        y=Integer.parseInt(req.getParameter("second"));
        str=req.getParameter("operation");
        if(str.equals("add")){
            writer.println("<h1>The result is :"+(x+y)+"</h1>");
        }
        else if(str.equals("subtract")){
            writer.println("<h1>The result is :"+(x-y)+"</h1>");
        }
        else if(str.equals("Multiply")){
           writer.println ("<h1>The result is :"+(x*y)+"</h1>");
        }
        else if(str.equals("Divide")){
            writer.println("<h1>The result is :"+(x/y)+"</h1>");
        }
        else if(str.equals(null)){
            writer.println("<h1 style='background-color:red;'>You did not select any operation<h1>");
        }
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");  // escape the quote marks
            out.println("<title>Glassfish HTML Testing</title>");
            out.println("<style>");     // start style
            // enclose style attributes withing the <style> </style> elements
            out.println("h1 {");        // note leading brace
            out.println("color:black;");
            out.println("align-items:center;");
            out.println(" display: flex;");
            out.println("justify-content: space-around;");
            out.println("background-color:#87eba28f;");
            out.println("\n");
            out.println("}");          // note trailing brace for h1 style
            // add styles for other elements here using similar structure
            // note that separate lines are used for clarity -
            // all of the above could be one println
            out.println("</style>");  // terminate style
            out.println("</head>");
            out.println("<body>");
            out.println("<img style='margin:5rem 20rem;' src='surprise.jpg' width='50%' height='70%' ");
            out.println("</body>");
            out.println("</html>");
        }  // end of try-with-resources block
    }
}
