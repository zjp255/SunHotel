package DAO.entityUtitls;

import DAO.entity.RoomType;
import DAO.entityUtil;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomTypeUtitl implements entityUtil <RoomType>{

    private String tableName = "roomtype";
    private int colCount = 13;

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public int getColCount() {
        return colCount;
    }

    @Override
    public String[] getColName() {

        return new String[]{"pk","id","r_type","bed","price","foregift","cl_room","cl_price","remark","sysmark","delmark","other1","other2"};
    }

    @Override
    public Object[] getObjects(RoomType rt) {
        return new Object[]{rt.getPk(),rt.getId(),rt.getR_type(),rt.getBed(),rt.getPrice(),rt.getForegift(),rt.getCl_room(),rt.getCl_price(),rt.getRemark(),rt.getSysmark(),rt.getDelmark(),rt.getOther1(),rt.getOther2()};
    }

    @Override
    public RoomType getRowInfo(ResultSet rs) {
        try {
            RoomType rt = new RoomType(rs.getBigDecimal(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDouble(5),
                    rs.getDouble(6),
                    rs.getString(7),
                    rs.getDouble(8),
                    rs.getString(9),
                    rs.getInt(10),
                    rs.getInt(11),
                    rs.getString(12),
                    rs.getString(13)
            );
            return rt;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
