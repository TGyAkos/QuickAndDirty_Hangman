package quickanddirty.hangman.dao.connection;

import java.sql.*;

public class Connect {
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/hangman";

    public Connection getConnected() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl, "root", "");
        } catch (SQLException e){
            System.out.println(e);
        }
        return conn;
    }
    public void closeConnected(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
