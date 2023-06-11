package edu.ulatina.demodb;

import java.sql.*;
import java.util.*;

/*
 * @author Nwitlyck
 */
public class ServiceUser extends Service implements ICrud<UserTO> {

    @Override
    public void insert(UserTO userTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?)");
        ps.setInt(1, userTO.getId());
        ps.setString(2, userTO.getName());
        ps.setString(3, userTO.getLastName());
        ps.setInt(3, userTO.getState());
        ps.executeUpdate();

        close(ps);
        close(conn);

    }

    @Override
    public void update(UserTO userTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE user SET name = ?, lastname = ?, state = ? WHERE (id = ?)");
        ps.setString(1, userTO.getName());
        ps.setString(2, userTO.getLastName());
        ps.setInt(3, userTO.getState());
        ps.setInt(4, userTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);

    }

    @Override
    public void delete(UserTO userTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM user WHERE (id = ?)");
        ps.setInt(1, userTO.getId());
        ps.executeUpdate();

        close(ps);
        close(conn);

    }

    @Override
    public List<UserTO> select() throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserTO> userTOList = new ArrayList<UserTO>();

        ps = getConnection().prepareStatement("SELECT id, name, lastname, state  FROM user");
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String lastName = rs.getString("lastname");
            int state = rs.getInt("state");

            if (state == 1) {
                UserTO user = new UserTO(id, name, lastName, state);
                userTOList.add(user);
            }
        }

        close(rs);
        close(ps);
        close(conn);

        return userTOList;
    }

    @Override
    public UserTO getByPk(int pk) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        UserTO userTO = null;

        ps = getConnection().prepareStatement("SELECT id, name, lastname, state FROM user WHERE id = ?");
        ps.setInt(1, pk);
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String lastName = rs.getString("lastname");
            int state = rs.getInt("state");

            UserTO user = new UserTO(id, name, lastName, state);
            userTO = user;
        }

        close(rs);
        close(ps);
        close(conn);

        return userTO;
    }

}
