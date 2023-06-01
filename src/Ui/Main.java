package Ui;

import DAO.DaoUtils;
import DAO.SQLUtils;
import DAO.entity.Pwd;
import DAO.entity.RoomType;
import DAO.entityUtitls.PwdUtitl;
import DAO.entityUtitls.RoomTypeUtitl;
import Ui.Frame.*;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        new LogInFrame();

    }

    void test1()
    {
        DaoUtils<RoomType> rtdu = new DaoUtils<>();
        RoomTypeUtitl rtu = new RoomTypeUtitl();
        RoomType rt = new RoomType(new BigDecimal(123),"LX008","特价双人房","2",150,200,"N",0);
        //添加行（成功）
        rtdu.update(SQLUtils.insertSql(rtu),rtu.getObjects(rt));
        //删除行（成功）
        rtdu.update(SQLUtils.deleteSql(rtu,new BigDecimal(123)),null);
        //查询
        List<RoomType> list = rtdu.Select(SQLUtils.selectSql(rtu,new BigDecimal("1145855029280")),rtu);
        System.out.println(list.get(0).toString());

        DaoUtils<Pwd> pdu = new DaoUtils<>();
        PwdUtitl pu = new PwdUtitl();
        Pwd pd = new Pwd(new BigDecimal("2333"),"我","23333","233");
        //添加
        pdu.update(SQLUtils.insertSql(pu),pu.getObjects(pd));
        //删除
        pdu.update(SQLUtils.deleteSql(pu,new BigDecimal("2333")),null);
        //查询
        List<Pwd> list1 = pdu.Select(SQLUtils.selectSql(pu,new BigDecimal("1522730590000")),pu);
        System.out.println(list1.get(0).toString());
    }

//    static void test2()
//    {
//        AllDao dao = new AllDao(new PwdUtitl());
//        System.out.println(dao.getRows());
//
//    }
}