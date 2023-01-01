

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
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/TicketDetails"})
public class TicketDetails extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            if(session.getAttribute("uname")!=null)
            {
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewServlet</title>");            
            out.println("</head>");
            out.println("<body bgcolor='#ADD8E6'>");
  
            out.println("<h1>Ticket Page</h1>");
            out.println("<table id='customers'><tr><th>Airline Name</th><th>From Location</th><th>To Location</th><th>Departure Time</th><th>Arival Time</th><th>Duration</th><th>Total Seats</th><th>Flight Departure</th><th>Price</th><th>Available Seats</th><th>Buy</th></tr>");
            out.println("<style> a:link, a:visited { background-color: #219ebc;color: white;padding: 14px 20px;text-align: center;text-decoration: none;display: inline-block;} a:hover, a:active { background-color:#ffb703 ;} #customers {   font-family: Arial, Helvetica, sans-serif; border-collapse: collapse; width: 100%;}#customers td, #customers th { border: 1px solid #ddd;padding: 8px;}#customers tr:nth-child(even){background-color: #f2f2f2;}#customers tr:hover {background-color: #ddd;}#customers th {padding-top: 12px;padding-bottom: 12px;text-align: left;background-color: #219ebc;color: white}</style>");
            AirDao dao = new AirDao();
            ResultSet rs = dao.SelectAll();
            
            while(rs.next())
            {
                    
                    out.println("<tr><td>"+rs.getString(3)+"</td>");
                    out.println("<td>"+rs.getString(4)+"</td>");
                    out.println("<td>"+rs.getString(5)+"</td>");
                    out.println("<td>"+rs.getString(6)+"</td>");
                    out.println("<td>"+rs.getString(7)+"</td>");
                    out.println("<td>"+rs.getString(8)+"</td>");
                    out.println("<td>"+rs.getString(9)+"</td>");
                    out.println("<td>"+rs.getString(10)+"</td>");
                    out.println("<td>"+rs.getString(11)+"</td>");
                    out.println("<td>"+rs.getString(12)+"</td>");
                    out.println("<td><a href='CardDetails.html'>Buy</a></td>");
                   
                    
                    
                }
                out.println("</table>");
                 out.println("<br>");
                
                 out.println("<a href='Logout'>Logout</a>");
            
            out.println("</body>");
            out.println("</html>");
            
            }
            else{
                response.sendRedirect("loginpage.html");
            }
            
        } //end of try
        
        catch (SQLException ex) {
            Logger.getLogger(TicketDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
