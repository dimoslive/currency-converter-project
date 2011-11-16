/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ntioudis
 */


public class CurrencyConverter extends HttpServlet {

    int flag=0;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>WWW Technologies</title>");
            out.println("</head>");
            out.println("<body style=background-color:white;>");

            String param = request.getParameter("action");


            if (param.equals("Submit")) {


                String from = request.getParameter("From");

                String to = request.getParameter("To");

                String amount = request.getParameter("amount");
                
                String result;

                
                if (amount.isEmpty()) {
                    out.println("This aint work without an input!");
                }
                else {
                    for (int i = 0; i < amount.length(); i++) {
                        //If we find a non-digit character we return false.
                        if (!Character.isDigit(amount.charAt(i))) {
                            flag=1;
                        }
                    }
                }
                if(flag==0){
                    result = convertG(from, to, amount);
                    out.println(result);
                }
                else {
                    out.println("Wrong input, try giving only digits!");
                }




            }
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }



    }

    public String convertG(String from, String to, String amount) {
        try {
            URL url = new URL("http://www.google.com/ig/calculator?hl=en&q=" + amount + from + "=?" + to);
            URLConnection yc = url.openConnection();

            Scanner in = new Scanner(
                    new InputStreamReader(
                    yc.getInputStream()));
            in.findInLine("rhs: \"");
            return in.next();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

