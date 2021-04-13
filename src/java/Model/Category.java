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
public class Category {
    int id;
    String name;
    
    private Connection cnn;
    private Statement stm;
    private ResultSet rs;
    PreparedStatement ps = null;

    public Category() {
        connect();
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void connect() {
        try {
            cnn = (new DBContext()).getConnection();
            System.out.println("Connect successfully!");

        } catch (Exception e) {
            System.out.println("Loi ket noi: " + e.getMessage());
        }
    }
    
    public ArrayList<Category> getListCategory() {
        //Tao danh sach user
        ArrayList<Category> list = new ArrayList();
        try {
            String strSelect = "Select * from categories";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Category(id, name));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public int getListCategoryID(String names) {
        //Tao danh sach user
        int cateid = 0;
        try {
            String strSelect = "Select * from categories where name = N'" + names + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                cateid = id;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cateid;
    }
    
    public String getNameCategory(int idcate) {
        //Tao danh sach user
        String catename ="";
        try {
            String strSelect = "Select * from categories where id = N'" + idcate + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                catename = name;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return catename;
    }
   
    
    
    public void addCate(Category c) {
        String sqlInsert = "Insert Into categories values('" + c.getId() + "',N'" + c.getName() + "')";
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlInsert);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delCate(String cateid) {
        try {
            String sqlUpdate = "DELETE FROM categories WHERE id = '" + cateid + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlUpdate);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Error del: " + e.getMessage());
        }
    }
    
}
