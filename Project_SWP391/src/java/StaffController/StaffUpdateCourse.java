/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package StaffController;

import dao.CategoryDAO;
import dao.CourseDAO;
import dao.CourseStaffDao;
import dao.TeacherDAO;
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

/**
 *
 * @author admin
 */@MultipartConfig


public class StaffUpdateCourse extends HttpServlet {
   
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
            out.println("<title>Servlet StaffUpdateCourse</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffUpdateCourse at " + request.getContextPath () + "</h1>");
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
          CategoryDAO cateDAO=new CategoryDAO();
                    TeacherDAO teacherDAO=new TeacherDAO();
                    request.setAttribute("listc", cateDAO.getListCategory());
                    request.setAttribute("listt", teacherDAO.getListTeachers());
        String id=request.getParameter("id");
        request.setAttribute("idc", id);

        CourseStaffDao course=new CourseStaffDao();
        request.setAttribute("course", course.getCourseById(Integer.parseInt(id)));
        request.getRequestDispatcher("staff/updateCourse.jsp").forward(request, response);
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
        System.out.println(session.getAttribute("staffid"));
        System.out.println(session.getAttribute("role"));
        String id=request.getParameter("idc");
        String title=request.getParameter("title");
        String cateid=request.getParameter("cateid");
        String start=request.getParameter("start");
        String teacherid=request.getParameter("teacherid");
        String duration=request.getParameter("duration");
        String price=request.getParameter("price");
        String discount=request.getParameter("discount");
        String description=request.getParameter("description");
        String imagedb=request.getParameter("imagedb");
        String msg="";
       // String staffid=session.getAttribute("staffid").toString();
        Part part=request.getPart("image");
        String mimeType = part.getContentType();
        //System.out.println(mimeType);
        System.out.println(part);
        System.out.println(part.getSize());
        if(part.getSize() != 0&&mimeType.startsWith("image")){
        String realPath=request.getServletContext().getRealPath("/courseimguploads");
        String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if(!Files.exists(Paths.get(realPath))){
            Files.createDirectory(Paths.get(realPath));
        }
        part.write(realPath+"/"+filename);
        imagedb="courseimguploads/"+filename;
        }else{
            msg="Ban hay nhap vao 1 anh";
            request.setAttribute("msg", msg);
            request.setAttribute("idc", id);
            response.sendRedirect("staffupdatecourse?idc="+id+"");

        }
       // String mimeType = part.getContentType();
        
        CourseStaffDao course=new CourseStaffDao();
        course.UpdateCourse(id,title,cateid,start,teacherid,price,discount,description,imagedb,duration);
        response.sendRedirect("shomepage?pageIndex=1");
        

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
