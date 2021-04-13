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
public class User {

    int id;
    String username, password, fullname;

    private Connection cnn;
    private Statement stm;
    private ResultSet rs;
    PreparedStatement ps = null;

    public User() {
        connect();
    }

    public User(int id, String username, String password, String fullname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        connect();
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void connect() {
        try {
            cnn = (new DBContext()).getConnection();
            System.out.println("Connect successfully!");

        } catch (Exception e) {
            System.out.println("Loi ket noi: " + e.getMessage());
        }
    }

    public boolean checkUser() {
        //Check xem trong database co ton tai tai khoan nay khong
        try {
            String strSelect = "Select * from users where username = '" + username + "' and password = '" + password + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean checkadmin() {
        //Check xem trong database co ton tai tai khoan nay khong
        if(username.equals("admin")&&password.equals("admin")){
            return true;
        }
        return false;
    }

    public ArrayList<User> getListUser() {
        //Tao danh sach user
        ArrayList<User> list = new ArrayList();
        try {
            String strSelect = "Select * from users";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String fullname = rs.getString(4);

                list.add(new User(id, username, password, fullname));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public ArrayList<User> getListUserbyID(int userid) {
        //Tao danh sach user
        ArrayList<User> list = new ArrayList();
        try {
            String strSelect = "Select * from users where id = '" + userid + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String fullname = rs.getString(4);

                list.add(new User(id, username, password, fullname));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public int getIdacc(String acc) {
        int accid = 0;
        try {
            String strSelect = "Select * from users where username = '" + acc + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String fullname = rs.getString(4);

                if(username.equals(acc)){
                    accid = id;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return accid;
    }

    public ArrayList<User> searchListUser(ArrayList<User> list, String search) {
        ArrayList<User> searchlist = new ArrayList();

        try {
            String strSelect = "Select * from users where username = '" + username + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String fullname = rs.getString(4);

                list.add(new User(id, username, password, fullname));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return searchlist;
    }

    public int addAccount(User u) {
        ArrayList<User> list = getListUser();
        try {

            String sqlInsert = "INSERT INTO users "
                    + "VALUES('" + u.getId() + "'," + "'" + u.getUsername() + "','"
                    + u.getPassword() + "',N'" + u.getFullname() + "')";
            cnn = new Model.DBContext().getConnection();
            ps = cnn.prepareStatement(sqlInsert);

            int iResult = ps.executeUpdate();

            if (iResult > 0) {
                list.add(u);

            }
            return iResult;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;

    }

    public boolean checkExistUser() {

        try {
            String strSelect = "Select * from users where username = '" + username + "' ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                return true;
            }

        } catch (Exception e) {

        }

        return false;
    }
    
    public boolean checkExistId() {

        try {
            String strSelect = "Select * from users where id = '" + id + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                return true;
            }

        } catch (Exception e) {

        }

        return false;
    }
    
    public void delUser(int userid) {
        try {
            String sqlUpdate = "DELETE FROM users WHERE id = '" + userid + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlUpdate);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Error del: " + e.getMessage());
        }
    }
    
    public void updateUser(User u) {
        //Add SQL
        try {
            String sqlUpdate = "UPDATE dbo.users\n"
                    + "SET username = '" + u.getUsername() + "',\n"
                    + "password = '" + u.getPassword() + "',\n"
                    + "fullname = N'" + u.getFullname() + "'\n"
                    + "WHERE id = '" + u.getId() + "';";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeUpdate(sqlUpdate);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }
}
