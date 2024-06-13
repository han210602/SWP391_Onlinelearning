/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminController;

import dao.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Administrator;

/**
 *
 * @author admin
 */
@WebServlet(name = "manageStaffAccounts", urlPatterns = {"/manageStaffAccounts"})
public class manageStaffAccounts extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet manageStaffAccounts</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet manageStaffAccounts at " + request.getContextPath() + "</h1>");
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
        StaffDAO sd = new StaffDAO();
    
    int page = 1;
    int recordsPerPage =0;
    if(request.getParameter("recordsPerPage") == null){
        recordsPerPage = 6;
    }else {
        recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
    }
    
    // Kiểm tra xem tham số "page" có null hay không
    if (request.getParameter("page") != null) {
        page = Integer.parseInt(request.getParameter("page"));
    }
    
    // tính số lượng bản ghi cho offset
    int offset = (page - 1) * recordsPerPage;

    // Lấy list Administrator cho trang hiện tại bằng OFFSET và FETCH
    List<Administrator> list = sd.getListAdministrator(offset, recordsPerPage);
    
    // Lấy tổng số bản ghi
    int noOfRecords = sd.getTotalRecords();
    
    // Tính tổng số trang cần thiết 
    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
    
    request.setAttribute("recordsPerPage", recordsPerPage);
    request.setAttribute("data", list);
    request.setAttribute("noOfPages", noOfPages);
    request.setAttribute("currentPage", page);
    request.getRequestDispatcher("admin/manageStaffAccounts.jsp").forward(request, response);
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
        processRequest(request, response);
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
