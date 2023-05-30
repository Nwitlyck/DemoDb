package edu.ulatina.demodb;

import java.sql.*;
import java.util.*;

/*
    Nwitlyck
 */
public class DemoDb {

    private static Connection conn = null;

    public static void main(String[] args) {
        
        //UserTO userTO = new UserTO(3,"Felipe Tercero");
        //insert(userTO);
        //userTO = new UserTO(4,"sadas");
        //insert(userTO);
        
        //UserTO userTO = new UserTO(4,"Felipe Primero");
        //delete(userTO);
        //update(new UserTO(1,"Felipe Primero"));
        


        List<UserTO> users = getUsers();
        for (UserTO user : users) {
            System.out.println("Id: " + user.getId() + " Name: " + user.getName());
        }
        
        //System.out.println(getUserByPK(2).getName());
    }

    public static void insert(UserTO user) {
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement("INSERT INTO user VALUES (?, ?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                close(ps);
                close(conn);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    
    public static void update(UserTO user) {
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement("UPDATE user SET name = ? WHERE (id = ?)");
            ps.setString(1, user.getName());
            ps.setInt(2, user.getId());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                close(ps);
                close(conn);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    
    public static void delete(UserTO user) {
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement("DELETE FROM user WHERE (id = ?)");
            ps.setInt(1, user.getId());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                close(ps);
                close(conn);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static List<UserTO> getUsers() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserTO> toReturn = new ArrayList<UserTO>();
        try {
            ps = getConnection().prepareStatement("SELECT id, name FROM user");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                UserTO user = new UserTO(id, name);
                toReturn.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                close(rs);
                close(ps);
                close(conn);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return toReturn;
    }
    
    public static UserTO getUserByPK(int pK) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserTO toReturn = null;
        try {
            ps = getConnection().prepareStatement("SELECT id, name FROM user WHERE id = ?");
            ps.setInt(1, pK);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                UserTO user = new UserTO(id, name);
                toReturn = user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                close(rs);
                close(ps);
                close(conn);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return toReturn;
    }

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testproject2?serverTimezone=UTC", "root", "Root");

        return conn;
    }

    public static void close(Connection toClose) throws Exception {
        if (toClose != null && !toClose.isClosed()) {
            toClose.close();
            toClose = null;
        }
    }

    public static void close(PreparedStatement toClose) throws Exception {
        if (toClose != null && !toClose.isClosed()) {
            toClose.close();
            toClose = null;
        }
    }

    public static void close(ResultSet toClose) throws Exception {
        if (toClose != null && !toClose.isClosed()) {
            toClose.close();
            toClose = null;
        }
    }
}