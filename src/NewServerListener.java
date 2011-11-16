/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 * @author ntioudis
 */
public class NewServletListener implements ServletContextListener {

    
    public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext sc = sce.getServletContext();
        
        sc.setAttribute("redirect", new redirect(sc.getInitParameter("redirect")));

    }

    
    public void contextDestroyed(ServletContextEvent sce) {}
    
}
