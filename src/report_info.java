/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ntioudis
 */
import javax.servlet.http.*;
import java.io.*;

public class report_info extends HttpServlet {
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.sendRedirect(((redirect)getServletContext().getAttribute("redirect")).getRedirectLink());
        }
        catch (IOException ex) {}
            
           

    }

    
}



