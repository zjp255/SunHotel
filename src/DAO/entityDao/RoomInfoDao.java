package DAO.entityDao;

import DAO.DaoUtils;
import DAO.SQLUtils;
import DAO.entity.Pwd;
import DAO.entity.RoomInfo;
import DAO.entityDaoInterface;
import DAO.entityUtitls.RoomInfoUtitl;

import java.math.BigDecimal;
import java.util.List;

public class RoomInfoDao implements entityDaoInterface<RoomInfo> {

    DaoUtils<RoomInfo> daoDU;
    RoomInfoUtitl roomInfoUtitl;

    public RoomInfoDao()
    {
        daoDU = new DaoUtils<>();
        roomInfoUtitl = new RoomInfoUtitl();
    }
     @Override
    public List<RoomInfo> getRows() {
        return daoDU.Select(SQLUtils.selectAllSql(roomInfoUtitl),roomInfoUtitl);
    }

    @Override
    public boolean addRow(RoomInfo roomInfo) {
        int x = daoDU.update(SQLUtils.insertSql(roomInfoUtitl),roomInfoUtitl.getObjects(roomInfo));
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    @Override
    public boolean deleteRow(BigDecimal id) {
        int x = daoDU.update(SQLUtils.deleteSql(roomInfoUtitl,id),null);
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    public boolean updateRowRoomStatusZY(String roomId)
    {
        String sql = "UPDATE " + roomInfoUtitl.getTableName() + " SET state = '占用' WHERE id = '"+ roomId + "'";
        int x =  daoDU.update(sql,null);
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }

    public boolean updateRowRoomStatusKG(String roomId)
    {
        String sql = "UPDATE " + roomInfoUtitl.getTableName() + " SET state = '可供' WHERE id = '"+ roomId + "'";
        int x =  daoDU.update(sql,null);
        if(x != 0)
            return true;
        else {
            return  false;
        }
    }
}
