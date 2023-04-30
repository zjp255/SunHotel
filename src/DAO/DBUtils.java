package DAO;

import java.sql.*;

public class DBUtils{
    private static final String DATABASE = "sunhotel";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?serverTimezone=GMT";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static Connection connect = null;

    public static Connection getConnection(){
        Connection connection = connect;
        try {
            if(connection == null) {
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeALL(Connection connect, PreparedStatement statement, ResultSet rs){

        try {
            if(connect != null) {
               connect.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(rs != null){
                rs.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //开启事务
    public static void begin()
    {
        Connection connect = null;
        try {
            connect = getConnection();
            connect.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //提交事务
    public static void commit() {
        Connection connect = null;
        try {
            connect = getConnection();
            connect.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback() {
        Connection connect = null;
        try {
            connect = getConnection();
            connect.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
