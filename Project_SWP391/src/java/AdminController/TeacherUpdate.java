/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminController;

import dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Teachers;

/**
 *
 * @author admin
 */
public class TeacherUpdate extends HttpServlet {

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
            out.println("<title>Servlet TeacherUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeacherUpdate at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");

        TeacherDAO tNew = new TeacherDAO();

        Teachers t = tNew.getTeacherById(id);
        request.setAttribute("teacher", t);
        request.getRequestDispatcher("admin/UpdateTeacher.jsp").forward(request, response);

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
        String id, username, pass, name, gender, email, phone, address, subject, imgUrl, join_date, city, state, active;
        id = request.getParameter("id");
        username = request.getParameter("username");
        pass = request.getParameter("pass");
        name = request.getParameter("name");
        gender = request.getParameter("gender");
        email = request.getParameter("email");
        phone = request.getParameter("phone");
        address = request.getParameter("address");
        subject = request.getParameter("subject");
        imgUrl = request.getParameter("imgUrl");
        join_date = request.getParameter("join_date");
        city = request.getParameter("city");
        state = request.getParameter("state");
        active = request.getParameter("active");

        TeacherDAO tNew = new TeacherDAO();

        Teachers t = new Teachers(id, username, pass, name, gender, email, phone, address, subject, imgUrl, join_date, city, state, active);
        tNew.Update(t);
       
       response.sendRedirect("teachermanager?index=1");

        //request.getRequestDispatcher("teachermanager?index=1").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
