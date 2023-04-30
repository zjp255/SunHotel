package DAO;

import java.math.BigDecimal;

public class SQLUtils {
    public static String insertSql(entityUtil eu) {
        StringBuilder sql;
        sql = new StringBuilder("insert into " + eu.getTableName() + "(");
        int colCount = eu.getColCount();
        String[] colName = eu.getColName();
        try {
            for (int i = 0; i < colCount; i++) {
                if (i < colCount - 1)
                    sql.append(colName[i]).append(",");
                else
                    sql.append(colName[i]).append(")");
            }
            sql.append(" values(");
            for (int i = 0; i < colCount; i++) {
                if (i < colCount - 1)
                    sql.append("?,");
                else
                    sql.append("?);");
            }
            return sql.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String updateSql(entityUtil eu)
    {
        StringBuilder sql = new StringBuilder("update " + eu.getTableName() + "set ");
        int colCount = eu.getColCount();
        String[] colName = eu.getColName();

        try {
            for (int i = 0; i < colCount; i++) {
                if (i < colCount - 1)
                    sql.append(colName[i]).append(" = ?,");
                else
                    sql.append(colName[i]).append(" = ? ");
            }
            sql.append("where id = ?");
            return sql.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String deleteSql(entityUtil eu, BigDecimal id) {
        StringBuilder sql = new StringBuilder("delete from " + eu.getTableName() + " where pk = " + id);
        return sql.toString();
    }

    public static String selectSql(entityUtil eu, BigDecimal id) {
        StringBuilder sql = new StringBuilder("select * from " + eu.getTableName() + " where pk = " + id);
        return sql.toString();
    }

    public static String selectAllSql(entityUtil eu) {
        StringBuilder sql = new StringBuilder("select * from " + eu.getTableName() + ";");
        return sql.toString();
    }

}
