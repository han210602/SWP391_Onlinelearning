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
import model.Customer;
import model.Administrator;

/**
 *
 * @author admin
 */
public class LoginController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs

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
              request.getRequestDispatcher("login.jsp").forward(request, response);


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
       String username=request.getParameter("username");
       String password=request.getParameter("password");
        Administrator u =new Administrator(username, password);
        Customer c=new Customer(username, password);
        if(u.checkAdministrator()!=null){
        
            if(u.checkAdministrator().getRoles_id().equals("1")){
                request.getRequestDispatcher("admin/dashboard.jsp").forward(request, response);
            }else if(u.checkAdministrator().getRoles_id().equals("3")){
                request.getRequestDispatcher("teacher/home.jsp").forward(request, response);

            }else if(u.checkAdministrator().getRoles_id().equals("2")){
                request.getRequestDispatcher("staff/home.jsp").forward(request, response);

            }else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
 
            }
        }else if(c.checkCustomer()!=null){
        request.getRequestDispatcher("homePage.jsp").forward(request, response);
        }else{
        request.getRequestDispatcher("login.jsp").forward(request, response);

        }

        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
 
}
