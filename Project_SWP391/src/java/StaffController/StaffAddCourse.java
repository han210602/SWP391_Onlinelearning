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
 */
@MultipartConfig
public class StaffAddCourse extends HttpServlet {
   
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
            out.println("<title>Servlet StaffAddCourse</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffAddCourse at " + request.getContextPath () + "</h1>");
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
                HttpSession session=request.getSession();
        System.out.println(session.getAttribute("staffid"));
                        System.out.println(session.getAttribute("role"));

                    CategoryDAO cateDAO=new CategoryDAO();
                    TeacherDAO teacherDAO=new TeacherDAO();
                    request.setAttribute("listc", cateDAO.getListCategory());
                    request.setAttribute("listt", teacherDAO.getListTeachers());
                    request.getRequestDispatcher("staff/addCourse.jsp").forward(request, response);

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

        String title=request.getParameter("title");
        String cateid=request.getParameter("cateid");
        String start=request.getParameter("start");
        String teacherid=request.getParameter("teacherid");
        String duration=request.getParameter("duration");
        String price=request.getParameter("price");
        String discount=request.getParameter("discount");
        String description=request.getParameter("description");
        String staffid=session.getAttribute("staffid").toString();
        Part part=request.getPart("image");
        String realPath=request.getServletContext().getRealPath("/courseimguploads");
        String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if(!Files.exists(Paths.get(realPath))){
            Files.createDirectory(Paths.get(realPath));
        }
        part.write(realPath+"/"+filename);
        CourseStaffDao course=new CourseStaffDao();
        course.AddCourse(title,cateid,start,teacherid,price,discount,description,"courseimguploads/"+filename,staffid,duration);
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
