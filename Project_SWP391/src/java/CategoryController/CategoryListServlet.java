/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package CategoryController;

import dao.CategoryDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
/**
 *
 * @author admin
 */
@WebServlet(name="CategoryListServlet", urlPatterns={"/categorylist"})
public class CategoryListServlet extends HttpServlet {
   
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
//        HttpSession session = request.getSession();
//        Admin u = (Admin) session.getAttribute("account");
//        if (u == null) {
//            response.sendRedirect("error.jsp");
//        } else {
            String num_raw = request.getParameter("pageNumber");
            int num;
            try {
                if (num_raw == null) {
                    num = 5;
                } else {
                    num = Integer.parseInt(num_raw);
                }
                request.setCharacterEncoding("UTF-8");
                CategoryDAO dao = new CategoryDAO();
                int totalCategory = dao.getTotalCategory();
                int numberPage = (int) Math.ceil((double) totalCategory / 5);
                int index;
                String currentPage = request.getParameter("index");
                if (currentPage == null) {
                    index = 1;
                } else {
                    index = Integer.parseInt(currentPage);
                }
                List<Category> list = dao.pagingCategory("","category_id", index, num);
                request.setAttribute("total", totalCategory);
                request.setAttribute("num", 5);
                request.setAttribute("numberPage", numberPage);
                request.setAttribute("listC", list);
                request.getRequestDispatcher("CategoryList.jsp").forward(request, response);
            } catch (ServletException | IOException | NumberFormatException e) {
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
//        }
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
        processRequest(request, response);
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

}
