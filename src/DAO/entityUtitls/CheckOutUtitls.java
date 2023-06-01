package DAO.entityUtitls;

import DAO.entity.CheckOut;
import DAO.entity.CustomerType;
import DAO.entity.Pwd;
import DAO.entityUtil;

import java.sql.ResultSet;

public class CheckOutUtitls implements entityUtil<CheckOut> {

    private  String tableName = "checkout";
    private int colCount = 10;
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
        return new String[]{ "pk",
                "chk_no",
                "in_no",
                "days",
                "money",
                "chk_time",
                "remark",
                "delmark",
                "other1",
                "other2"};
    }

    @Override
    public Object[] getObjects(CheckOut rt) {
        return new Object[]{rt.getPk(),
                rt.getChkNo(),
                rt.getInNo(),
                rt.getDays(),
                rt.getMoney(),
                rt.getChkTime(),
                rt.getRemark(),
                rt.getDelmark(),
                rt.getOther1(),
                rt.getOther2()
        };
    }

    @Override
    public CheckOut getRowInfo(ResultSet rs) {
        try {
            CheckOut checkOut = new CheckOut(
                    rs.getBigDecimal(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getDouble(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getInt(8),
                    rs.getString(9),
                    rs.getString(10)
            );
            return checkOut;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
