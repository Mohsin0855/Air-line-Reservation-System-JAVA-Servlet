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
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             try
        {
           
            PrintWriter out = response.getWriter();
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body bgcolor='#ADD8E6'>");
            
            Details d = new Details();
            d.fid = request.getParameter("id");
            
            AirDao dao = new AirDao();
            ResultSet rs = dao.SelectById(d);
            rs.next();
            out.println("<style>");
out.println("input[type=text], select {");
 out.println(" width: 100%;");
  out.println("padding: 12px 20px;");
 out.println(" margin: 8px 0;");
 out.println(" display: inline-block;");
  out.println("border: 1px solid #ccc;");
  out.println("border-radius: 4px;");
  out.println("box-sizing: border-box;");
out.println("}");

out.println("input[type=submit] {");
 out.println(" width: 100%;");
 out.println(" background-color: #4CAF50;");
 out.println(" color: white;");
  out.println("padding: 14px 20px;");
  out.println("margin: 8px 0;");
  out.println("border: none;");
  out.println("border-radius: 4px;");
  out.println("cursor: pointer;");
out.println("}");

out.println("input[type=submit]:hover {");
out.println("  background-color: #45a049;");
out.println("}");

out.println("div {");
 out.println(" border-radius: 5px;");
 out.println(" background-color: #f2f2f2;");
 out.println(" padding: 20px;");
out.println("}");

 out.println("a:link, a:visited {");
  out.println(" background-color: #f44336;");
  out.println(" color: white;");
  out.println(" padding: 14px 25px;");
  out.println(" text-align: center;");
  out.println(" text-decoration: none;");
   out.println("display: inline-block;");
 out.println("}");

 out.println("a:hover, a:active {");
 out.println("  background-color: red;");
 out.println("}");



out.println("</style>");

out.println("<body bgcolor='#ADD8E6'>");

out.println("<h3>Update Flight Details</h3>");

out.println("<div>");
 out.println(" <form action='updateServlet' method='post'>");
  out.println("  <label>Flight Id</label>");
   out.println(" <input type='text' value="+rs.getString(1)+" name='t3' placeholder='Flight ID..'>");

   out.println(" <label>Airline Id</label>");
   out.println(" <input type='text' value="+rs.getString(2)+" name='t4' placeholder='Airline ID..'>");
 
   out.println(" <label>Airline Name</label>");
  out.println("  <input type='text' value="+rs.getString(3)+" name='t5' placeholder='Airline Name..'>");
 
  out.println("  <label>From Location</label>");
  out.println("  <select value="+rs.getString(4)+" name='t6'>");
   out.println("   <option value='islamabad'>Islamabad</option>");
   out.println("   <option value='lahore'>Lahore</option>");
    out.println("  <option value='karachi'>Karachi</option>");
   out.println(" </select>");
  
    out.println("    <label>To Location</label>");
    out.println("<select value="+rs.getString(5)+" name='t7'>");
   out.println("   <option value='islamabad'>Islamabad</option>");
    out.println("  <option value='lahore'>Lahore</option>");
    out.println("  <option value='kharachi'>Karachi</option>");
   out.println(" </select>");
   
  out.println("  <label>Departure Time</label>");
  out.println("  <select value="+rs.getString(6)+" name='t8'>");
    out.println("  <option value='12:00pm'>12:00 PM</option>");
    out.println("  <option value='2:00pm'>2:00 PM</option>");
    out.println("  <option value='4:00pm'>4:00 PM</option>");
 out.println("   </select>");
   out.println("   <label>Arrival Time</label>");
   out.println(" <select value="+rs.getString(7)+" name='t9'>");
    out.println("  <option value='12:00pm'>12:00 PM</option>");
    out.println("  <option value='2:00pm'>2:00 PM</option>");
    out.println("  <option value='4:00pm'>4:00 PM</option>");
  out.println("  </select>");
    
   out.println(" <label>Duration</label>");
  out.println("  <input type='text' value="+rs.getString(8)+" name='t10' placeholder='Duration..'>");
  out.println("  <label>Total Seats</label>");
  out.println("  <input type='text' value="+rs.getString(9)+" name='t11' placeholder='Total Seats..'>");
   out.println(" <label>Departure Date</label>");
   out.println(" <select value="+rs.getString(10)+" name='t12'>");
     out.println(" <option value='12-dec-2022'>12/ DEC /2022</option>");
     out.println(" <option value='13-dec-2022'>13/ DEC /2022</option>");
     out.println(" <option value='14-dec-2022'>14/ DEC /2022</option>");
   out.println(" </select>");
   
   out.println(" <label>Price</label>");
   out.println(" <input type='text' value="+rs.getString(11)+" name='t13' placeholder='Price..'>");
   out.println(" <label>Avaialable Seats</label>");
   out.println(" <input type='text' value="+rs.getString(12)+" name='t14' placeholder='Available Seats..'>");
 
   
   out.println(" <input type='submit' value='Submit'>");
 out.println(" </form>");
out.println("</div>");

out.println("</body>");
out.println("</html>");
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    

}
