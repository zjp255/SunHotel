package DAO.entityDao;

import DAO.DaoUtils;
import DAO.SQLUtils;
import DAO.entity.CheckOut;
import DAO.entity.CustomerType;
import DAO.entity.LiveIn;
import DAO.entityDaoInterface;
import DAO.entityUtitls.CheckOutUtitls;

import java.math.BigDecimal;
import java.util.List;

public class CheckOutDao implements entityDaoInterface<CheckOut> {
    DaoUtils<CheckOut> daoDU;
    CheckOutUtitls checkOutUtitls;

    public CheckOutDao() {
        daoDU = new DaoUtils<>();
        checkOutUtitls = new CheckOutUtitls();
    }

    @Override
    public List<CheckOut> getRows() {
        return daoDU.Select(SQLUtils.selectAllSql(checkOutUtitls),checkOutUtitls);
    }

    @Override
    public boolean addRow(CheckOut checkOut) {
        int x = daoDU.update(SQLUtils.insertSql(checkOutUtitls),checkOutUtitls.getObjects(checkOut));
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    @Override
    public boolean deleteRow(BigDecimal id) {
        int x = daoDU.update(SQLUtils.deleteSql(checkOutUtitls,id),null);
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    public  List<CheckOut> getLastRow()
    {
        return daoDU.Select("SELECT * FROM " + checkOutUtitls.getTableName() +" ORDER BY pk DESC LIMIT 1",checkOutUtitls);
    }
}
