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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Doktoh
 */
public class LoginController extends HttpServlet {

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
        if (request.getParameter("register") != null) {
            request.getRequestDispatcher("register").forward(request, response);
        } else {
            //Nhan thong tin phia view
            String account = request.getParameter("name");
            String pass = request.getParameter("pass");

            //Xu ly thong tin - Goi sang model xu ly
            User u = new User(account, pass);
            boolean status = u.checkUser();

            //Goi model de tao danh sach user
            ArrayList<User> list = u.getListUser();

            //Tra ket qua ve cho view hien thi
            if (status) {
                //Tao session
                HttpSession s = request.getSession();
                s.setAttribute("sAccount", account);
                s.setMaxInactiveInterval(5*60);
                
                //Login thanh cong
                //Toi muon di chuyen den 1 file co ten la ListUser.jsp
                request.setAttribute("account", account);
                request.setAttribute("list", list);
                request.getRequestDispatcher("editnew").forward(request, response);
            } else {
                //Login that bai
                //Toi back tro lai trang login ban dau
                request.getRequestDispatcher("View/Login.jsp").forward(request, response);
            }
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
