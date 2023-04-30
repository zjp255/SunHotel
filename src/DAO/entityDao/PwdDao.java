package DAO.entityDao;

import DAO.DaoUtils;
import DAO.SQLUtils;
import DAO.entity.Pwd;
import DAO.entityDaoInterface;
import DAO.entityUtitls.PwdUtitl;

import java.math.BigDecimal;
import java.util.List;

public class PwdDao implements entityDaoInterface<Pwd> {
    DaoUtils<Pwd> daoDU;
    PwdUtitl pwdU;

    public PwdDao()
    {
        daoDU = new DaoUtils<>();
        pwdU = new PwdUtitl();
    }



    @Override
    public List<Pwd> getRows() {
       return daoDU.Select(SQLUtils.selectAllSql(pwdU),pwdU);
    }

    @Override
    public boolean addRow(Pwd t) {
        int x = daoDU.update(SQLUtils.insertSql(pwdU),pwdU.getObjects(t));
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    @Override
    public boolean deleteRow(BigDecimal id) {
        int x = daoDU.update(SQLUtils.deleteSql(pwdU,id),null);
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }
}
