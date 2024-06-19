/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminController;

import Ulti.Helper;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Customer;

/**
 *
 * @author admin
 */
@WebServlet(name = "UserManagerController", urlPatterns = {"/customersmanager"})
public class UserManagerController extends HttpServlet {

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
            String txtSearch = request.getParameter("txtSearch");
            int pagenum = 1;
            String page = request.getParameter("page");
            if (page != null) {
                pagenum = Integer.parseInt(page);
            }
            UserDAO userDAO = new UserDAO();
            List<Customer> users = userDAO.getUsers(txtSearch);
            List paging = Helper.pagination(users, pagenum, 5);
            int total = users.size() % 5 == 0 ? (users.size() / 5) : (users.size() / 5 + 1);
            request.setAttribute("users", paging);
            request.setAttribute("total", total);
            request.setAttribute("page", pagenum);
            request.setAttribute("message", request.getAttribute("success"));
            request.setAttribute("error", request.getAttribute("error"));
            request.setAttribute("txtSearch", txtSearch);

            request.getRequestDispatcher("admin/customerManager.jsp").include(request, response);
//            request.getRequestDispatcher("admin/customerManager.jsp").forward(request, response);
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
        processRequest(request, response);
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
