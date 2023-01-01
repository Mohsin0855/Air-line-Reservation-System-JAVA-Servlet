

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import files.*;
@WebServlet(urlPatterns = {"/updateServlet"})
public class updateServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<body bgcolor='#ADD8E6'>");
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
            int res = dao.Update(d);
            if (res > 0) {
                out.println("Updated Successfully");
                response.sendRedirect("ViewServlet");
                //l5.setText("Inserted Successfully");
            }
        }
    }

    

}
