package DAO;

import DAO.entity.RoomType;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;

//使用接口，使SQLUtils
public interface entityUtil<T>{
    public String getTableName();
    public int getColCount();
    public String[] getColName();
    public Object[] getObjects(T rt);
    //public Object getObjectWithCol();

    public T getRowInfo(ResultSet rs);
}
