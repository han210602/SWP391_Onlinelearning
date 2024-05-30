/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package AdminController;

import dao.CategoryDAO;
import dao.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Course;

/**
 *
 * @author admin
 */
public class CoursesManager extends HttpServlet {
   
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
            out.println("<title>Servlet CoursesManager</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CoursesManager at " + request.getContextPath () + "</h1>");
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
            CourseDAO course=new CourseDAO();
            CategoryDAO category=new CategoryDAO();
            ArrayList<Course>data=new ArrayList<>();
            int pageSize=3;
            int count=0;
            if(request.getParameter("cate")!=null){
                                request.setAttribute("cate", request.getParameter("cate"));

                if(request.getParameter("cate").equals("0")){
                count=course.getTotalCourse();
                data=course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")), pageSize);  
                }else{
                int pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
                int cateid=Integer.parseInt(request.getParameter("cate"));
                count=course.getTotalCourseByCate(cateid);
                System.out.println(count);
                data=course.getListCourseByCate(cateid,pageIndex,pageSize);
                 System.out.println(data.size());
                }
            }else if(request.getParameter("approve")!=null){
                request.setAttribute("approve", request.getParameter("approve"));
                if(request.getParameter("approve").equals("2")){
                count=course.getTotalCourse();
                System.out.println("s"+count);
                data=course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")), pageSize); 
                }else{
                int pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
                int approve=Integer.parseInt(request.getParameter("approve"));
                count=course.getTotalCourseByActive(approve);
                data=course.getListCourseByActive(approve,pageIndex,pageSize);
                }
            
            }else if(request.getParameter("btnSearch")!=null){
                if(request.getParameter("search").equals("")){
                    count=course.getTotalCourse();
                data=course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")), pageSize);
                }else{
                int pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
                String search=request.getParameter("search");
                count=course.getTotalCourseBySearch(search);
                                    request.setAttribute("search", search);

                data=course.getListCourseBySearch(search,pageIndex,pageSize); 
                }
            }
            else{
                count=course.getTotalCourse();
                data=course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")), pageSize);
            }
            
            int endPage=count/pageSize;
            if(count%pageSize!=0){
                endPage++;
            }
            System.out.println(endPage);
           // course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")),pageSize)
            request.setAttribute("endPage", endPage);
            request.setAttribute("listCate", category.getListCategory());
            request.setAttribute("data", data);
            request.getRequestDispatcher("admin/coursesManager.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private int getTotalCourseByCate(int cateid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
