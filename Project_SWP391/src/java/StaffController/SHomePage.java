/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package StaffController;

import dao.CategoryDAO;
import dao.CourseDAO;
import dao.CourseStaffDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Administrator;
import model.Course;

/**
 *
 * @author admin
 */
public class SHomePage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SHomePage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SHomePage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null && session.getAttribute("role").equals("staff")) {
            String username = session.getAttribute("username").toString();
            Administrator a = new Administrator();
            Administrator staff = a.getAdminstratorByUsername(username);
            int id=Integer.parseInt(staff.getId());
            CourseStaffDao course = new CourseStaffDao();
            CategoryDAO category = new CategoryDAO();
            ArrayList<Course> data = new ArrayList<>();
            int pageSize =5;
            int count = 0;
            if (request.getParameter("cate") != null) {
                request.setAttribute("cate", request.getParameter("cate"));

                if (request.getParameter("cate").equals("0")) {
                    count = course.getTotalCourse(id);
                    data = course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")), pageSize,id);
                } else {
                    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
                    int cateid = Integer.parseInt(request.getParameter("cate"));
                    count = course.getTotalCourseByCate(cateid,id);
                    System.out.println(count);
                    data = course.getListCourseByCate(cateid, pageIndex, pageSize,id);
                    System.out.println(data.size());
                }
            } else if (request.getParameter("approve") != null) {
                request.setAttribute("approve", request.getParameter("approve"));
                if (request.getParameter("approve").equals("2")) {
                    count = course.getTotalCourse(id);
                   
                    data = course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")), pageSize,id);
                } else {
                    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
                    int approve = Integer.parseInt(request.getParameter("approve"));
                    count = course.getTotalCourseByActive(approve,id);
                    data = course.getListCourseByActive(approve, pageIndex, pageSize,id);
                }

            } else if (request.getParameter("btnSearch") != null) {
                if (request.getParameter("search").equals("")) {
                    count = course.getTotalCourse(id);
                    data = course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")), pageSize,id);
                } else {
                    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
                    String search = request.getParameter("search");
                    count = course.getTotalCourseBySearch(search,id);
                    request.setAttribute("search", search);
                    data = course.getListCourseBySearch(search, pageIndex, pageSize,id);
                }
            } else {
                count = course.getTotalCourse(id);
                data = course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")), pageSize,id);
            }

            int endPage = count / pageSize;
            if (count % pageSize != 0) {
                endPage++;
            }
            System.out.println(endPage);
            // course.getListCourses(Integer.parseInt(request.getParameter("pageIndex")),pageSize)
            request.setAttribute("endPage", endPage);
            request.setAttribute("listCate", category.getListCategory());
            request.setAttribute("data", data);
            request.getRequestDispatcher("staff/coursesManager.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("pleaseLogin.jsp").forward(request, response);

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
