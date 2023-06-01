package DAO.entityDao;

import DAO.DaoUtils;
import DAO.SQLUtils;
import DAO.entity.LiveIn;
import DAO.entity.Pwd;
import DAO.entityDaoInterface;
import DAO.entityUtitls.LiveInUtitl;

import java.math.BigDecimal;
import java.util.List;

public class LiveInDao implements entityDaoInterface<LiveIn> {

    DaoUtils<LiveIn> daoDU;
    LiveInUtitl liveInUtitl;

    public LiveInDao() {
        daoDU = new DaoUtils<>();
        liveInUtitl = new LiveInUtitl();
    }

    @Override
    public List<LiveIn> getRows() {
        return daoDU.Select(SQLUtils.selectAllSql(liveInUtitl),liveInUtitl);
    }

    @Override
    public boolean addRow(LiveIn liveIn) {
        int x = daoDU.update(SQLUtils.insertSql(liveInUtitl),liveInUtitl.getObjects(liveIn));
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    @Override
    public boolean deleteRow(BigDecimal id) {
        int x = daoDU.update(SQLUtils.deleteSql(liveInUtitl,id),null);
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    public List<LiveIn> getRowsWithCol(String colName,Object value) {
        return daoDU.Select(SQLUtils.selectSqlUseCol(liveInUtitl,colName,value),liveInUtitl);
    }

    public  List<LiveIn> getLastRow()
    {
        return daoDU.Select("SELECT * FROM " + liveInUtitl.getTableName() +" ORDER BY pk DESC LIMIT 1",liveInUtitl);
    }
}
