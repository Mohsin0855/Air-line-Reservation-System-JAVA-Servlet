

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import files.*;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/last"})
public class last extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             HttpSession session = request.getSession();
            if(session.getAttribute("uname")!=null)
            {
           out.println("<body bgcolor='#ADD8E6'>");
            Card c = new Card();
            
            AirDao dao = new AirDao();

            c.cnum = request.getParameter("cnum");
            c.ccv = request.getParameter("ccv");
            c.exm = request.getParameter("exm");
            c.exy = request.getParameter("exy");
            c.uname = request.getParameter("uname");
            int res = dao.InsertC(c);
            if (res > 0) {
                out.println("You bought ticket Successfully");
                response.sendRedirect("thankyou");
                
            }
            }
            else{
                response.sendRedirect("loginpage.html");
            }
            
            
        }//end of try
    }

    

}
