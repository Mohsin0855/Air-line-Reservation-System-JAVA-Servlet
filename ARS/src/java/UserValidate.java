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
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/UserValidate"})
public class UserValidate extends HttpServlet {

 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<body bgcolor='#ADD8E6'>");
             Profile p = new Profile();
            AirDao dao = new AirDao();
            p.uname = request.getParameter("uname");
            p.upassw = request.getParameter("upassw");
            
            ResultSet rs = dao.SelectByUser(p);
            while(rs.next())
            {
                
                System.out.println(rs.getString(1));
                HttpSession session = request.getSession();
                session.setAttribute("uname", p.uname);
                response.sendRedirect("TicketDetails");
                
            }
            response.sendRedirect("loginpage.html");
        }
        catch(Exception ex)
        {
            
        }
    }

    

}
