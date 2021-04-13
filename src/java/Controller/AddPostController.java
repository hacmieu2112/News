/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Category;
import Model.New;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Doktoh
 */
public class AddPostController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        Category c = new Category();
        ArrayList<Category> listc = c.getListCategory();
        request.setAttribute("listc", listc);
        New n = new New();
        ArrayList<New> listn = n.getListNew();
        User u = new User();
        long millis = System.currentTimeMillis();
        java.sql.Date dateup = new java.sql.Date(millis);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateFormat = formatter.format(dateup);

        if (request.getParameter("add") != null) {
            int id = listn.get(listn.size()-1).getId() + 1;
            String name = request.getParameter("post");
            String category = request.getParameter("category");
            int cateid = c.getListCategoryID(category);
            String description = request.getParameter("description");
            String detail = request.getParameter("detail");
            String image = "View/images/"+request.getParameter("image");
            String username = request.getParameter("username");
            int userid = u.getIdacc(username);
            int viewt = 0;
            
            New newS = new New(id, cateid, userid, name, description, detail, image, dateFormat,viewt);
            n.addNew(newS);
        }

        request.getRequestDispatcher("View/AddPostView.jsp").forward(request, response);
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
