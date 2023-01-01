

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

@WebServlet(urlPatterns = {"/validate"})
public class validate extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
           
            out.println("<body bgcolor='#ADD8E6'>");
            Profile p = new Profile();
            AirDao dao = new AirDao();
            p.admin = request.getParameter("t1");
            p.pass = request.getParameter("t2");
            
            ResultSet rs = dao.SelectByUserNamePassword(p);
            while(rs.next())
            {
                
                System.out.println(rs.getString(1));
                HttpSession session = request.getSession();
                session.setAttribute("t1", p.admin);
                response.sendRedirect("adminhome.html");
                
            }
            response.sendRedirect("admin.html");
        }
        catch(Exception ex)
        {
            
        }
    }

   
}
