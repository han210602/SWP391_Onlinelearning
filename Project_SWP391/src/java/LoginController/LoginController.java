/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package LoginController;

import dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.Base64;
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
        Administrator u =new Administrator(username, toSHA1(password));
        Customer c=new Customer(username, toSHA1(password));
        TeacherDAO t=new TeacherDAO();
        
        HttpSession session=request.getSession();

        if(u.checkAdministrator()!=null){
            session.setAttribute("username", username);
            if(u.checkAdministrator().getRoles_id().equals("1")){
                session.setAttribute("role", "admin");
                request.getRequestDispatcher("admin/dashboard.jsp").forward(request, response);
            }else 
                if(u.checkAdministrator().getRoles_id().equals("2")){
            session.setAttribute("role", "staff");
            session.setAttribute("staffid", u.checkAdministrator().getId());
               // request.getRequestDispatcher("staff/coursesManager.jsp").forward(request, response);
            //request.setAttribute("staff", u.getId());
            response.sendRedirect("shomepage?pageIndex=1");

            }else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
 
            }
        }else if(c.checkCustomer()!=null){
            session.setAttribute("username", username);
        session.setAttribute("role", "customer");
        request.getRequestDispatcher("homePage.jsp").forward(request, response);
        }else if(t.checkTeacher(username, password)!=null){
        session.setAttribute("role", "teacher");
        session.setAttribute("username", username);
        request.getRequestDispatcher("homePage.jsp").forward(request, response); 
        }
        else{
        request.getRequestDispatcher("login.jsp").forward(request, response);

        }
//if(u.checkAdministrator().getRoles_id().equals("3")){
//                session.setAttribute("role", "teacher");
//                request.getRequestDispatcher("teacher/home.jsp").forward(request, response);
//
//            }else 
        
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

}
