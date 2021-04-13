/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Doktoh
 */
public class Comment {

    int id;
    String comment;
    boolean usercheck, admincheck;
    String name;
    int postid;
    String date;

    private Connection cnn;
    private Statement stm;
    private ResultSet rs;
    PreparedStatement ps = null;

    public Comment() {
        connect();
    }

    public Comment(int id, String comment, boolean usercheck, boolean admincheck,String name, int postid, String date) {
        this.id = id;
        this.comment = comment;
        this.usercheck = usercheck;
        this.admincheck = admincheck;
        this.name = name;
        this.postid = postid;
        this.date = date;
        connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isUsercheck() {
        return usercheck;
    }

    public void setUsercheck(boolean usercheck) {
        this.usercheck = usercheck;
    }

    public boolean isAdmincheck() {
        return admincheck;
    }

    public void setAdmincheck(boolean admincheck) {
        this.admincheck = admincheck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
    

    public void connect() {
        try {
            cnn = (new DBContext()).getConnection();
            System.out.println("Connect successfully!");

        } catch (Exception e) {
            System.out.println("Loi ket noi: " + e.getMessage());
        }
    }
    
    public ArrayList<Comment> getListComment(int postid) {
        //Tao danh sach user
        ArrayList<Comment> list = new ArrayList();
        try {
            String strSelect = "Select * from comment where post_id = '" + postid +"'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String comment = rs.getString(2);
                boolean userc = rs.getBoolean(3);
                boolean adminc = rs.getBoolean(4);
                String name = rs.getString(5);
                int post_id = rs.getInt(6);
                String date = rs.getString(7);
                if(userc && adminc){
                    list.add(new Comment(id, comment, userc, adminc, name, post_id, date));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public ArrayList<Comment> getListCommentUser(int postid) {
        //Tao danh sach user
        ArrayList<Comment> list = new ArrayList();
        try {
            String strSelect = "Select * from comment where post_id = '" + postid +"'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String comment = rs.getString(2);
                boolean userc = rs.getBoolean(3);
                boolean adminc = rs.getBoolean(4);
                String name = rs.getString(5);
                int post_id = rs.getInt(6);
                String date = rs.getString(7);
                if(!userc){
                    list.add(new Comment(id, comment, userc, adminc, name, post_id,date));
                }
   
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public ArrayList<Comment> getListCommentAdmin(int postid) {
        //Tao danh sach user
        ArrayList<Comment> list = new ArrayList();
        try {
            String strSelect = "Select * from comment where post_id = '" + postid +"'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String comment = rs.getString(2);
                boolean userc = rs.getBoolean(3);
                boolean adminc = rs.getBoolean(4);
                String name = rs.getString(5);
                int post_id = rs.getInt(6);
                String date = rs.getString(7);
                if(userc&!adminc){
                    list.add(new Comment(id, comment, userc, adminc, name, post_id, date));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public ArrayList<Comment> getListCmt() {
        //Tao danh sach user
        ArrayList<Comment> list = new ArrayList();
        try {
            String strSelect = "Select * from comment";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String comment = rs.getString(2);
                boolean userc = rs.getBoolean(3);
                boolean adminc = rs.getBoolean(4);
                String name = rs.getString(5);
                int post_id = rs.getInt(6);
                String date = rs.getString(7);
                list.add(new Comment(id, comment, userc, adminc, name, post_id,date));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public void addComment(Comment c) {
        String sqlInsert = "Insert Into comment values('"+c.getId()+"',N'"+c.getComment()+"','"+c.isUsercheck()+"','"+c.isAdmincheck()+"',N'"+c.getName()+"','"+c.getPostid()+"','"+c.getDate()+"')";
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlInsert);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateCmtUser(int idcmt) {
        //Add SQL

        try {
            String sqlUpdate = "UPDATE dbo.comment\n"
                    + "SET usercheck = '" + true + "'\n"
                    + "WHERE id = '" + idcmt + "';";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlUpdate);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }
    
    public void updateCmtAdmin(int idcmt) {
        //Add SQL

        try {
            String sqlUpdate = "UPDATE dbo.comment\n"
                    + "SET admincheck = '" + true + "'\n"
                    + "WHERE id = '" + idcmt + "';";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlUpdate);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }

}
