/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package LoginController;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.util.Base64;
import model.Administrator;
import model.Customer;

/**
 *
 * @author admin
 */
public class ResetPassword extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetPassword</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPassword at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id=request.getParameter("id");
        String pass=request.getParameter("password");
        String repass=request.getParameter("confPassword");
        if(pass.equals(repass)){
           if(request.getParameter("type").equals("admin")){
               Administrator a=new Administrator();
               a.updatePass(toSHA1(pass),Integer.parseInt(id));
           }else{
               Customer c=new Customer();
            c.updatePass(toSHA1(pass),Integer.parseInt(id));
        request.getRequestDispatcher("login.jsp").forward(request, response);

           } 
           
        }else{
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("type", request.getParameter("type"));
        request.setAttribute("id",id );
        request.setAttribute("msg", "ConfirmPassword Error");
        request.getRequestDispatcher("newPassword.jsp").forward(request, response);
        }
        
    }
 public String toSHA1(String str){
        String salt="asdfghjkl;";
        String result=null;
        str+=salt;
        try{
            byte[] dataBytes=str.getBytes("UTF-8");
            MessageDigest md=MessageDigest.getInstance("SHA-1");
            result=Base64.getEncoder().encodeToString(md.digest(dataBytes));
        }catch(Exception e){
            
        }
        return result;
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
