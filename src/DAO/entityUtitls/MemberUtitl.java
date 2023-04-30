package DAO.entityUtitls;

import DAO.entity.Member;
import DAO.entityUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberUtitl implements entityUtil<Member> {
    private String tableName = "member";
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
        return new String[]{"pk","m_id","m_name","sex","zj_no","m_tel","address","remark","delmark","other1","other2"};
    }

    @Override
    public Object[] getObjects(Member rt) {
        return new Object[]{
                rt.getPk(),
                rt.getM_id(),
                rt.getM_name(),
                rt.getSex(),
                rt.getZj_no(),
                rt.getM_tel(),
                rt.getAddress(),
                rt.getRemark(),
                rt.getDelmark(),
                rt.getOther1(),
                rt.getOther2()
        };
    }

    @Override
    public Member getRowInfo(ResultSet rs) {
        try {
            Member mem = new Member(
                    rs.getBigDecimal(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getString(10),
                    rs.getString(11)
            );
            return mem;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
