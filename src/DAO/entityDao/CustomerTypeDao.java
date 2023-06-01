package DAO.entityDao;

import DAO.DaoUtils;
import DAO.SQLUtils;
import DAO.entity.CustomerType;
import DAO.entity.LiveIn;
import DAO.entityDaoInterface;
import DAO.entityUtitls.CustomerTypeUtitls;

import java.math.BigDecimal;
import java.util.List;

public class CustomerTypeDao implements entityDaoInterface<CustomerType> {
   DaoUtils<CustomerType> daoDU;
   CustomerTypeUtitls customerTypeUtitls;

   public CustomerTypeDao()
   {
       daoDU = new DaoUtils<>();
       customerTypeUtitls = new CustomerTypeUtitls();
   }

    @Override
    public List<CustomerType> getRows() {
        return daoDU.Select(SQLUtils.selectAllSql(customerTypeUtitls),customerTypeUtitls);
    }

    @Override
    public boolean addRow(CustomerType customerType) {
        int x = daoDU.update(SQLUtils.insertSql(customerTypeUtitls),customerTypeUtitls.getObjects(customerType));
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    @Override
    public boolean deleteRow(BigDecimal id) {
        int x = daoDU.update(SQLUtils.deleteSql(customerTypeUtitls,id),null);
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    public List<CustomerType> getRowsWithCol(String colName,Object value) {
        return daoDU.Select(SQLUtils.selectSqlUseCol(customerTypeUtitls,colName,value),customerTypeUtitls);
    }
}
