package DAO.entityUtitls;

import DAO.entity.Pwd;
import DAO.entity.RoomInfo;
import DAO.entity.RoomType;
import DAO.entityUtil;

import java.sql.ResultSet;

public class RoomInfoUtitl implements entityUtil<RoomInfo> {
    @Override
    public String getTableName() {
        return "roominfo";
    }

    @Override
    public int getColCount() {
        return 12;
    }

    @Override
    public String[] getColName() {
        return new String[]{"pk","id","r_type_id","state","location","r_tel","remark","statetime","indimark","delmark","other1","other2"};
    }

    @Override
    public Object[] getObjects(RoomInfo rt) {
        return new Object[0];
    }

    @Override
    public RoomInfo getRowInfo(ResultSet rs) {
        try {
            RoomInfo roomInfo = new RoomInfo(
                    rs.getBigDecimal(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6),
            rs.getString(7),
            rs.getInt(8),
            rs.getInt(9),
            rs.getInt(10),
            rs.getString(11),
            rs.getString(12)
            );
            return roomInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
