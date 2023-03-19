package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUtils<T> {
    public int update(String sql,Object[] args)
    {
        Connection connect = null;
        connect = DBUtils.getConnection();

        try {
            PreparedStatement state = connect.prepareStatement(sql);
            int result = 0;
            if(args != null) {
                for (int i = 0; i < args.length; i++) {
                    state.setObject(i + 1, args[i]);
                }
            }
            result = state.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> Select(String sql,entityUtil eu)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<>();

        connection = DBUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                 T t = (T) eu.getRowInfo(resultSet);
                list.add(t);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
