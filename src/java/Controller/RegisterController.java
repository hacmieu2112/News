/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Doktoh
 */
public class RegisterController extends HttpServlet {

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
        String res = "";
        String exist = "";
        User u2 = new User();
        ArrayList<User> list = u2.getListUser();
        request.setAttribute("list", list);
        if (request.getParameter("registerbtn") == null) {
            request.getRequestDispatcher("View/Register.jsp").forward(request, response);
        } else {
            if (request.getParameter("username").trim().equals("") || request.getParameter("pass").trim().equals("")
                    || request.getParameter("re-pass").trim().equals("") || request.getParameter("name").trim().equals("")) {
                res = "Please input full info to regis!";
            } else {
                int id = list.get(list.size()-1).getId() + 1;
                String acc = request.getParameter("username");
                String pass = request.getParameter("pass");
                String name = request.getParameter("name");

                User u = new User(acc, pass);
                User u1 = new User();
                if (u.checkExistUser()) {
                    exist = "Usename is existed, please enter others usename";
                } else {
                    res = "Register success!";
                    u1.addAccount(new User(id, acc, pass, name));
                    list = u2.getListUser();
                    request.setAttribute("list", list);
                }
            }
            request.setAttribute("res", res);
            request.setAttribute("exist", exist);
            request.getRequestDispatcher("View/Register.jsp").forward(request, response);
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
