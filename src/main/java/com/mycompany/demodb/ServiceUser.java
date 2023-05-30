package com.mycompany.demodb;

import java.sql.*;
import java.util.*;

/*
 * @author Nwitlyck
 */
public class ServiceUser extends Service implements ICrud<UserTO> {

    @Override
    public void insert(UserTO userTO) {

        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement("INSERT INTO user VALUES (?, ?)");
            ps.setInt(1, userTO.getId());
            ps.setString(2, userTO.getName());
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

    @Override
    public void update(UserTO userTO) {
        
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement("UPDATE user SET name = ? WHERE (id = ?)");
            ps.setString(1, userTO.getName());
            ps.setInt(2, userTO.getId());
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

    @Override
    public void delete(UserTO userTO) {
        
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement("DELETE FROM user WHERE (id = ?)");
            ps.setInt(1, userTO.getId());
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

    @Override
    public List<UserTO> select() {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserTO> userTOList = new ArrayList<UserTO>();
        try {
            ps = getConnection().prepareStatement("SELECT id, name FROM user");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                UserTO user = new UserTO(id, name);
                userTOList.add(user);
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
        return userTOList;
    }

    @Override
    public UserTO getByPk(int pk) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserTO userTO = null;
        try {
            ps = getConnection().prepareStatement("SELECT id, name FROM user WHERE id = ?");
            ps.setInt(1, pk);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                UserTO user = new UserTO(id, name);
                userTO = user;
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
        return userTO;
    }

}
