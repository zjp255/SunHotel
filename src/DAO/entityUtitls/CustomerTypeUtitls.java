package DAO.entityUtitls;

import DAO.entity.CustomerType;
import DAO.entity.LiveIn;
import DAO.entity.Pwd;
import DAO.entityUtil;

import java.sql.ResultSet;

public class CustomerTypeUtitls implements entityUtil<CustomerType> {

    private String tableName = "customertype";
    private int colCount = 11;


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
        return new String[]{"pk",
                "id",
                "c_type",
                "dis_attr",
                "discount",
                "price",
                "dis_price",
                "remark",
                "delmark",
                "other1",
                "other2"};
    }

    @Override
    public Object[] getObjects(CustomerType rt) {
        return new Object[]{
                rt.getPk(),
                rt.getId(),
                rt.getcType(),
                rt.getDisAttr(),
                rt.getDiscount(),
                rt.getPrice(),
                rt.getDisPrice(),
                rt.getRemark(),
                rt.getDelMark(),
                rt.getOther1(),
                rt.getOther2()
        };
    }

    @Override
    public CustomerType getRowInfo(ResultSet rs) {
        try {
            CustomerType customerType = new CustomerType(
                    rs.getBigDecimal(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getDouble(6),
                    rs.getDouble(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getString(10),
                    rs.getString(11)
            );
            return customerType;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
