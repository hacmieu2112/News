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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Doktoh
 */
public class EditNewController extends HttpServlet {

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
        HttpSession s = request.getSession();
        String acc = (String) s.getAttribute("sAccount");
        System.out.println(acc);
        User u = new User();
        int idacc = u.getIdacc(acc);

        New n = new New(idacc);
        ArrayList<New> listn = n.getListNewId();
        request.setAttribute("listn", listn);
        Category c = new Category();
        ArrayList<Category> listc = c.getListCategory();
        request.setAttribute("listc", listc);
        long millis = System.currentTimeMillis();
        java.sql.Date dateup = new java.sql.Date(millis);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateFormat = formatter.format(dateup);
        
        if (request.getParameter("edit") != null) {
            String name = request.getParameter("name");
            
            String description = request.getParameter("description");
            String detail = request.getParameter("detail");
            String image = "View/images/" + request.getParameter("image");
            int category = c.getListCategoryID(request.getParameter("category"));
            New n1 = new New();
            int idpost = n1.getListNewPostID(name);
            int viewt = n1. getListNewView(name);

            New n2 = new New();
            New newN2 = new New(idpost, category, idacc, name, description, detail, image, dateFormat, viewt);
            n2.updateNew(newN2);
        }
        request.getRequestDispatcher("View/editnews.jsp").forward(request, response);
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
