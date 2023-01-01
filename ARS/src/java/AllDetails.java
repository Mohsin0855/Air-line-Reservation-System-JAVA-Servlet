/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import files.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/AllDetails"})
public class AllDetails extends HttpServlet {

 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tickets Sold Record</title>");            
            out.println("</head>");
            out.println("<body bgcolor='#ADD8E6'>");
            
            out.println("<h1> Users Book Tickets</h1>");
            
            out.println("<table id='customers'><tr><th>User Name</th><th>User Email</th><th>Card Number</th><th>CCV</th></tr>");
            out.println("<style> a:link, a:visited { background-color: #219ebc;color: white;padding: 14px 20px;text-align: center;text-decoration: none;display: inline-block;} a:hover, a:active { background-color:#ffb703 ;} #customers {   font-family: Arial, Helvetica, sans-serif; border-collapse: collapse; width: 100%;}#customers td, #customers th { border: 1px solid #ddd;padding: 8px;}#customers tr:nth-child(even){background-color: #f2f2f2;}#customers tr:hover {background-color: #ddd;}#customers th {padding-top: 12px;padding-bottom: 12px;text-align: left;background-color: #219ebc;color: white}</style>");
            AirDao dao = new AirDao();
            ResultSet rs = dao.SelectAllUD();
            
            while(rs.next())
            {
                    out.println("<tr><td>"+rs.getString(1)+"</td>");
                   
                    out.println("<td>"+rs.getString(3)+"</td>");
                    out.println("<td>"+rs.getString(4)+"</td>");
                    out.println("<td>"+rs.getString(5)+"</td></tr>");
                   
                    
                    
                }
                out.println("</table>");
                 out.println("<br>");
               out.println("<a href='adminhome.html'>Go Back</a>");
                
                out.println("<a href='index.html'>Logout</a>"); 
                
            out.println("</body>");
            out.println("</html>");   
        } catch (SQLException ex) {
            Logger.getLogger(AllDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
