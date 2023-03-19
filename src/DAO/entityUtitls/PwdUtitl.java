package DAO.entityUtitls;

import DAO.entity.Pwd;
import DAO.entity.RoomType;
import DAO.entityUtil;

import java.sql.ResultSet;

public class PwdUtitl implements entityUtil<Pwd> {
    private String tableName = "pwd";
    private int colCount = 7;
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
        return new String[]{"pk","userid","pwd","puis","delmark","other1","other2"};
    }

    @Override
    public Object[] getObjects(Pwd rt) {
        return new Object[]{rt.getPk(),rt.getUserid(),rt.getPwd(),rt.getPuis(),rt.getDelmark(),rt.getOther1(),rt.getOther2()};
    }

    @Override
    public Pwd getRowInfo(ResultSet rs) {
        try {
            Pwd pwd = new Pwd(
                    rs.getBigDecimal(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7)
            );
            return pwd;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
