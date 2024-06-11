/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package AdminController;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import model.Administrator;

/**
 *
 * @author admin
 */
@MultipartConfig
public class AdminProfile extends HttpServlet {
   
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
            out.println("<title>Servlet AdminProfile</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminProfile at " + request.getContextPath () + "</h1>");
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
      HttpSession session = request.getSession();
        if (session.getAttribute("username") != null && session.getAttribute("role").equals("admin")) {
            String username = session.getAttribute("username").toString();
            Administrator a = new Administrator();
            Administrator staff = a.getAdminstratorByUsername(username);
            request.setAttribute("staff", staff);
            request.getRequestDispatcher("admin/AdminProfile.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("pleaseLogin.jsp").forward(request, response);

        }
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
        HttpSession session=request.getSession();
        String id=request.getParameter("id");
        String uname = request.getParameter("username");
        String pass = request.getParameter("pass");
        String fname = request.getParameter("fullname");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String occ = request.getParameter("occ");
        String company = request.getParameter("com");
        String address = request.getParameter("add");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String filenamedb=request.getParameter("imagedb");
        Part part=request.getPart("image");
        
        //System.out.println(mimeType);
        
        if(part.getSize() != 0){
        String mimeType = part.getContentType();
        if(mimeType.startsWith("image")){
        String realPath=request.getServletContext().getRealPath("/profileimgadministrator");
        String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if(!Files.exists(Paths.get(realPath))){
            Files.createDirectory(Paths.get(realPath));
            }
        part.write(realPath+"/"+filename);
        filenamedb="profileimgadministrator/"+filename; 
        }
        
        }
       
        Administrator a=new Administrator();
        a.UpdateProfile(id,uname,pass,fname,dob,gender,phone,email,occ,company,address,city,state,filenamedb);
        response.sendRedirect("adminprofile");
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
