/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Category;
import Model.Comment;
import Model.New;
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
public class DetailController extends HttpServlet {

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
        int postid = Integer.parseInt(request.getParameter("postid"));
        New n = new New();
        ArrayList<New> listn = n.getListNewPost(postid);
        Category c = new Category();
        ArrayList<Category> listc = c.getListCategory();
        request.setAttribute("listc3", listc);
        Comment cmt = new Comment();
        ArrayList<Comment> listcmt = cmt.getListComment(postid);
        request.setAttribute("listcmt", listcmt);
        int view = listn.get(0).getViewtime() + 1;
        n.updateNewView(postid,view);
        listn = n.getListNewPost(postid);
        request.setAttribute("listn3", listn);
        long millis = System.currentTimeMillis();
        java.sql.Date dateup = new java.sql.Date(millis);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateFormat = formatter.format(dateup);
        
        if(request.getParameter("CMTpost")!= null){
            ArrayList<Comment> listcmt2 = cmt.getListCmt();
            int cmtid;
            if(listcmt2.size()-1<0){
                cmtid = 0;
            }else{
                cmtid = listcmt2.get(listcmt2.size()-1).getId() + 1;
            }
            String name = request.getParameter("usercmt");
            String comment = request.getParameter("comment");
            Comment cmtadd = new Comment(cmtid,  comment, false, false,name, postid,dateFormat);
            cmt.addComment(cmtadd);
        }
        request.getRequestDispatcher("View/viewdetail.jsp").forward(request, response);
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
