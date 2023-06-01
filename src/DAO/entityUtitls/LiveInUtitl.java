package DAO.entityUtitls;

import DAO.entity.LiveIn;
import DAO.entityUtil;

import java.sql.ResultSet;

public class LiveInUtitl implements entityUtil<LiveIn> {

    private String tableName = "livein";
    private int colCount = 28;
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
                "in_no",
                "r_no",
                "r_type_id",
                "main_room",
                "main_pk",
                "c_type_id",
                "c_name",
                "c_jp",
                "sex",
                "zj_type",
                "zj_no",
                "address",
                "renShu",
                "in_time",
                "account",
                "days",
                "foreGift",
                "remark",
                "m_id",
                "chk_no",
                "chk_time",
                "userid",
                "stateMark",
                "clueMark",
                "delMark",
                "other1",
                "other2"};
    }

    @Override
    public Object[] getObjects(LiveIn rt) {
        return new Object[]
                {
                        rt.getPk(),
                        rt.getIn_no(),
                        rt.getR_no(),
                        rt.getR_type_id(),
                        rt.getMain_room(),
                        rt.getMain_pk(),
                        rt.getC_type_id(),
                        rt.getC_name(),
                        rt.getC_jp(),
                        rt.getSex(),
                        rt.getZj_type(),
                        rt.getZj_no(),
                        rt.getAddress(),
                        rt.getRenShu(),
                        rt.getIn_time(),
                        rt.getAccount(),
                        rt.getDays(),
                        rt.getForeGift(),
                        rt.getRemark(),
                        rt.getM_id(),
                        rt.getChk_no(),
                        rt.getChk_time(),
                        rt.getUserid(),
                        rt.getStateMark(),
                        rt.getClueMark(),
                        rt.getDelMark(),
                        rt.getOther1(),
                        rt.getOther2()
                };
    }


    @Override
    public LiveIn getRowInfo(ResultSet rs) {
        try {
            LiveIn liveIn = new LiveIn(
                    rs.getBigDecimal("pk"),
                    rs.getString("in_no"),
                    rs.getString("r_no"),
                    rs.getString("r_type_id"),
                    rs.getString("main_room"),
                    rs.getBigDecimal("main_pk"),
                    rs.getString("c_type_id"),
                    rs.getString("c_name"),
                    rs.getString("c_jp"),
                    rs.getString("sex"),
                    rs.getString("zj_type"),
                    rs.getString("zj_no"),
                    rs.getString("address"),
                    rs.getInt("renShu"),
                    rs.getString("in_time"),
                    rs.getDouble("account"),
                    rs.getInt("days"),
                    rs.getDouble("foreGift"),
                    rs.getString("remark"),
                    rs.getString("m_id"),
                    rs.getString("chk_no"),
                    rs.getString("chk_time"),
                    rs.getString("userid"),
                    rs.getString("stateMark"),
                    rs.getInt("clueMark"),
                    rs.getInt("delMark"),
                    rs.getString("other1"),
                    rs.getString("other2")
            );
            return liveIn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
