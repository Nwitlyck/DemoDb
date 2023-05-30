
package com.mycompany.demodb;

import java.sql.*;

/*
 * @author Nwitlyck
 */
public abstract class Service {
    
    protected Connection conn = null;

    public Service() {
    }

    protected Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testproject2?serverTimezone=UTC", "root", "Root");

        return conn;
    }

    protected void close(Connection toClose) throws Exception {
        if (toClose != null && !toClose.isClosed()) {
            toClose.close();
            toClose = null;
        }
    }

    protected void close(PreparedStatement toClose) throws Exception {
        if (toClose != null && !toClose.isClosed()) {
            toClose.close();
            toClose = null;
        }
    }

    protected void close(ResultSet toClose) throws Exception {
        if (toClose != null && !toClose.isClosed()) {
            toClose.close();
            toClose = null;
        }
    }
    
    
    
}
