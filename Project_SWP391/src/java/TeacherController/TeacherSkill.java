/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package TeacherController;

import dao.TeacherSkillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author admin
 */
   @MultipartConfig
public class TeacherSkill extends HttpServlet {

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
            out.println("<title>Servlet TeacherSkill</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeacherSkill at " + request.getContextPath () + "</h1>");
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
       String id=request.getParameter("id");
       String ids=request.getParameter("ids");
       System.out.println(id+""+ids);
       TeacherSkillDAO ts=new TeacherSkillDAO();
       ts.delete(id,ids);
       response.sendRedirect("teacherprofile");


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
        String ids=request.getParameter("ids");
        TeacherSkillDAO ts=new TeacherSkillDAO();
        Part part=request.getPart("cerimg");
        String mimeType = part.getContentType();
        String filenamedb="";
        if(part.getSize() != 0&&mimeType.startsWith("image")){
        String realPath=request.getServletContext().getRealPath("/certificateSkill");
        String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if(!Files.exists(Paths.get(realPath))){
            Files.createDirectory(Paths.get(realPath));
        }
        part.write(realPath+"/"+filename);
        filenamedb="certificateSkill/"+filename;
        }
       
       if(ts.checkSkill(id,ids)==null&&!filenamedb.isEmpty()){
          ts.addNewSkill(id,ids,filenamedb); 
       }
       response.sendRedirect("teacherprofile");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Object checkSkill(String id, String ids) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void addNewSkill(String id, String ids) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
