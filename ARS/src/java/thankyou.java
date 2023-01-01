

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/thankyou"})
public class thankyou extends HttpServlet {

   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            if(session.getAttribute("uname")!=null)
            {
            
           out.println(" <style>");
 out.println("a:link, a:visited {");
  out.println(" background-color: #219ebc;");
  out.println(" color: white;");
  out.println(" padding: 14px 20px;");
  out.println(" text-align: center;");
  out.println(" text-decoration: none;");
   out.println("display: inline-block;");
 out.println("}");

 out.println("a:hover, a:active {");
 out.println("  background-color:#ffb703 ;");
 out.println("}");
out.println("</style>");
            
            out.println("<body bgcolor='#ADD8E6'>");
            out.println("<h1>Purchase Successful</h1>");
            out.println("<h3>We Hope You Enjoy Your Trip</h3>");
            out.println("<a href='TicketDetails'>Go Back</a>");
            out.println("<a href='Logout'>Logout</a>");
            }
            else{
                response.sendRedirect("loginpage.html");
            }
        
        }//end of try
    }

    

}
