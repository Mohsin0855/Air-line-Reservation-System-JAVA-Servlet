import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import files.*;
@WebServlet(urlPatterns = {"/InsertPage"})
public class InsertPage extends HttpServlet {
    
// user signup insert page
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<body bgcolor='#ADD8E6'>");
            Profile p = new Profile();
            AirDao dao = new AirDao();

            p.uname = request.getParameter("t1");
            p.upassw = request.getParameter("t2");
            p.ufn = request.getParameter("t3");
            p.uln = request.getParameter("t4");
            p.uaddr = request.getParameter("t5");
            p.utel = request.getParameter("t6");
            p.uemail = request.getParameter("t7");
            out.println("insert");
            int res = dao.Insert(p);
            if (res > 0) {
                out.println("Inserted Successfully");
                response.sendRedirect("loginpage.html");
                
            }
             
            
        }
        
        }
    }

    

