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
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/FlightInsert"})
public class FlightInsert extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        try (PrintWriter out = response.getWriter()) {
           
            HttpSession session = request.getSession();
            if(session.getAttribute("t1")!=null){
                
            out.println("<body bgcolor='#ADD8E6'>");
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
            Details d = new Details();
            AirDao dao = new AirDao();

            d.fid = request.getParameter("t3");
            d.aid = request.getParameter("t4");
            d.aname = request.getParameter("t5");
            d.floc = request.getParameter("t6");
            d.toloc = request.getParameter("t7");
            d.dept = request.getParameter("t8");
            d.atime = request.getParameter("t9");
            d.duration = request.getParameter("t10");
            d.tseats = request.getParameter("t11");
            d.fdepdate = request.getParameter("t12");
            d.fprice = request.getParameter("t13");
            d.avseats = request.getParameter("t14");
            int res = dao.FInsert(d);
            if (res > 0) {
                out.println("Inserted Successfully");
                 response.sendRedirect("adminhome.html");
                //l5.setText("Inserted Successfully");
            }
            
            out.println("<a href='EditServlet?id="+d.fid+"'>Edit</a>");
            out.println("<a href='DeleteServlet'>Delete</a>");
            out.println("<a href='ViewServlet'>View</a>");
             out.println("<a href='index.html'>Logout</a>");
            
        }
            else{
                 response.sendRedirect("index.html");
            }
    }

    

}
}