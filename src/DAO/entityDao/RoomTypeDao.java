package DAO.entityDao;

import DAO.DaoUtils;
import DAO.SQLUtils;
import DAO.entity.Pwd;
import DAO.entity.RoomInfo;
import DAO.entity.RoomType;
import DAO.entityDaoInterface;
import DAO.entityUtitls.PwdUtitl;
import DAO.entityUtitls.RoomInfoUtitl;
import DAO.entityUtitls.RoomTypeUtitl;

import java.math.BigDecimal;
import java.util.List;

public class RoomTypeDao implements entityDaoInterface<RoomType> {
    DaoUtils<RoomType> daoDU;
    RoomTypeUtitl roomTypeUtitl;

    public RoomTypeDao()
    {
        daoDU = new DaoUtils<>();
        roomTypeUtitl = new RoomTypeUtitl();
    }
    @Override
    public List<RoomType> getRows() {
        return daoDU.Select(SQLUtils.selectAllSql(roomTypeUtitl),roomTypeUtitl);
    }


    @Override
    public boolean addRow(RoomType roomType) {
        int x = daoDU.update(SQLUtils.insertSql(roomTypeUtitl),roomTypeUtitl.getObjects(roomType));
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    @Override
    public boolean deleteRow(BigDecimal id) {
        int x = daoDU.update(SQLUtils.deleteSql(roomTypeUtitl,id),null);
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

}
