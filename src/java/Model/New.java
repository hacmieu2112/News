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
public class New {

    int id, catoid, userid;
    String name, description, detail, image, date;
    int viewtime;

    private Connection cnn;
    private Statement stm;
    private ResultSet rs;
    PreparedStatement ps = null;

    public New() {
        connect();
    }

    public New(int user_id) {
        this.userid = user_id;
        connect();
    }

    public New(int id, int catoid, int userid, String name, String description, String detail, String image, String date, int viewtime) {
        this.id = id;
        this.catoid = catoid;
        this.userid = userid;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.image = image;
        this.date = date;
        this.viewtime = viewtime;
        connect();
    }

    public int getViewtime() {
        return viewtime;
    }

    public void setViewtime(int viewtime) {
        this.viewtime = viewtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatoid() {
        return catoid;
    }

    public void setCatoid(int catoid) {
        this.catoid = catoid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public ArrayList<New> getListNewId() {
        //Tao danh sach user
        ArrayList<New> list = new ArrayList();
        try {
            String strSelect = "Select * from new where user_id = '" + userid + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                list.add(new New(id, catoid, userid, name, description, detail, image, date, viewtime));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList getListNewCmtUser() {
        //Tao danh sach user
        ArrayList list = new ArrayList();
        try {
            String strSelect = "SELECT dbo.new.name\n"
                    + "FROM dbo.new,dbo.comment\n"
                    + "WHERE dbo.comment.[post_id] = new.id AND USER_ID = '" + userid + "' AND usercheck = '0'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String name = rs.getString(1);
                list.add(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList getListNewCmtAdmin() {
        //Tao danh sach user
        ArrayList list = new ArrayList();
        try {
            String strSelect = "SELECT dbo.new.name\n"
                    + "FROM dbo.new,dbo.comment\n"
                    + "WHERE dbo.comment.[post_id] = new.id AND admincheck = '0' AND usercheck = '1'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String name = rs.getString(1);

                list.add(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<New> getListNew() {
        //Tao danh sach user
        ArrayList<New> list = new ArrayList();
        try {
            String strSelect = "Select * from new";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                list.add(new New(id, catoid, userid, name, description, detail, image, date, viewtime));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<New> getListTopView() {
        //Tao danh sach user
        ArrayList<New> list = new ArrayList();
        try {
            String strSelect = "SELECT *\n"
                    + "FROM dbo.new\n"
                    + "ORDER BY viewtime DESC";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                list.add(new New(id, catoid, userid, name, description, detail, image, date, viewtime));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<New> getListTopViewByCate(int cateid) {
        //Tao danh sach user
        ArrayList<New> list = new ArrayList();
        try {
            String strSelect = "SELECT *\n"
                    + "FROM dbo.new\n"
                    + "WHERE category_id = '"+cateid+"'\n"
                    + "ORDER BY viewtime DESC";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                list.add(new New(id, catoid, userid, name, description, detail, image, date, viewtime));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<New> getListTopNew() {
        //Tao danh sach user
        ArrayList<New> list = new ArrayList();
        try {
            String strSelect = "SELECT *\n"
                    + "FROM dbo.new\n"
                    + "ORDER BY [date] DESC";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                list.add(new New(id, catoid, userid, name, description, detail, image, date, viewtime));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public ArrayList<New> getListTopNewByCate(int cateid) {
        //Tao danh sach user
        ArrayList<New> list = new ArrayList();
        try {
            String strSelect = "SELECT *\n"
                    + "FROM dbo.new\n"
                    + "WHERE category_id = '"+cateid+"'\n"
                    + "ORDER BY [date] DESC";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                list.add(new New(id, catoid, userid, name, description, detail, image, date, viewtime));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<New> getListNewPost(int postid) {
        //Tao danh sach user
        ArrayList<New> list = new ArrayList();
        try {
            String strSelect = "Select * from new where id = '" + postid + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                list.add(new New(id, catoid, userid, name, description, detail, image, date, viewtime));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<New> getListNewCateId(int cateid) {
        //Tao danh sach user
        ArrayList<New> list = new ArrayList();
        try {
            String strSelect = "Select * from new where category_id = '" + cateid + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                list.add(new New(id, catoid, userid, name, description, detail, image, date, viewtime));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void updateNew(New New) {
        //Add SQL

        try {
            String sqlUpdate = "UPDATE dbo.new\n"
                    + "SET name = N'" + New.getName() + "',\n"
                    + "description = N'" + New.getDescription() + "',\n"
                    + "detail = N'" + New.getDetail() + "',\n"
                    + "[image] = '" + New.getImage() + "',\n"
                    + "date = '" + New.getDate() + "'\n"
                    + "WHERE id = '" + New.getId() + "';";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlUpdate);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Error add: " + e.getMessage());
        }
    }

    public void updateNewView(int postid, int viewt) {
        //Add SQL

        try {
            String sqlUpdate = "UPDATE dbo.new\n"
                    + "SET viewtime = '" + viewt + "'\n"
                    + "WHERE id = '" + postid + "';";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlUpdate);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }

    public int getListNewPostID(String names) {
        //Tao danh sach user
        int postid = 0;
        try {
            String strSelect = "Select * from new where name = N'" + names + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                postid = id;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return postid;
    }

    public int getListNewView(String names) {
        //Tao danh sach user
        int viewt = 0;
        try {
            String strSelect = "Select * from new where name = N'" + names + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                int catoid = rs.getInt(2);
                String name = rs.getString(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String image = rs.getString(6);
                String date = rs.getString(7);
                int userid = rs.getInt(8);
                int viewtime = rs.getInt(9);

                viewt = viewtime;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return viewt;
    }

    public void addNew(New n) {
        String sqlInsert = "Insert Into new values('" + n.getId() + "','" + n.getCatoid() + "',N'" + n.getName() + "',N'" + n.getDescription() + "',N'" + n.getDetail() + "','" + n.getImage() + "','" + n.getDate() + "','" + n.getUserid() + "','" + n.getViewtime() + "')";
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlInsert);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delNew(String namenew) {
        try {
            String sqlUpdate = "DELETE FROM new WHERE id = '" + namenew + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlUpdate);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Error del: " + e.getMessage());
        }
    }
}
