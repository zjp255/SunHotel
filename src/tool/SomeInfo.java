package tool;

import DAO.entity.*;
import DAO.entityDao.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SomeInfo {
    static String[] idType = {"身份证","临时居民身份证","护照"};
    static String[] sexType = {"男","女"};

    static String[] guestType = {"普通宾客","团体组织","内部人事","协议单位","网络会员"};

    static  String[] roomType = {"标准单人间","标准双人间","豪华单人间","豪华双人间","商务套房","总统套房"};

    public static String[] getRoomType()
    {
        return  roomType;
    }

    public static String[] getIdType()
    {
        return idType;
    }

    public static  String[] getSexType(){
        return  sexType;
    }

    public static  String[] guestType(){
        return  guestType;
    }

    public static String getRoomTypeString(RoomInfo roomInfo)
    {
        RoomTypeDao roomTypeDao = new RoomTypeDao();
        List<RoomType> list = roomTypeDao.getRows();
        for(int i = 0; i < list.size();i++)
        {
            if(list.get(i).getId().equals(roomInfo.getRoomTypeId()))
            {
                return list.get(i).getR_type();
            }
        }
        return "";
    }

    public static String getRoomTypeString(String info)
    {
        RoomTypeDao roomTypeDao = new RoomTypeDao();
        List<RoomType> list = roomTypeDao.getRows();
        for(int i = 0; i < list.size();i++)
        {
            if(list.get(i).getId().equals(info))
            {
                return list.get(i).getR_type();
            }
        }
        return "";
    }

    public static String getRoomTypeID(String info)
    {
        RoomInfoDao roomInfoDao = new RoomInfoDao();
        List<RoomInfo> list = roomInfoDao.getRows();
        for(int i = 0; i < list.size();i++)
        {
            if(list.get(i).getId().equals(info))
            {
                return list.get(i).getRoomTypeId();
            }
        }
        return "";
    }
    public static double getRoomPriceString(String roomId)
    {
        RoomTypeDao roomTypeDao = new RoomTypeDao();
        List<RoomType> list = roomTypeDao.getRows();
        for(int i = 0; i < list.size();i++)
        {
            if(list.get(i).getId().equals(roomId))
            {
                return list.get(i).getPrice();
            }
        }
        return 0;
    }
    public static String getGuestNameString(RoomInfo roomInfo)
    {
        LiveInDao liveInDao = new LiveInDao();
        List<LiveIn> list = liveInDao.getRowsWithCol("r_no",roomInfo.getId());
        return list.get(0).getC_name();
    }

    public static String getCustomerType(String customerTypeId)
    {
        CustomerTypeDao customerTypeDao = new CustomerTypeDao();
        List<CustomerType> list = customerTypeDao.getRowsWithCol("id",customerTypeId);
        return list.get(0).getcType();
    }

    public static String getCustomerTypeID(String customerType)
    {
        CustomerTypeDao customerTypeDao = new CustomerTypeDao();
        List<CustomerType> list = customerTypeDao.getRowsWithCol("c_type",customerType);
        return list.get(0).getId();
    }
    public static int getCustomerDiscount(String customerTypeId,String roomId)
    {
        CustomerTypeDao customerTypeDao = new CustomerTypeDao();
        List<CustomerType> list = customerTypeDao.getRowsWithCol("id",customerTypeId);
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getDisAttr().equals(roomId))
            {
                return list.get(i).getDiscount();
            }
        }
        return 10;
    }

    public static double getCustomerDiscountPrice(String customerTypeId, String roomId)
    {
        CustomerTypeDao customerTypeDao = new CustomerTypeDao();
        List<CustomerType> list = customerTypeDao.getRowsWithCol("id",customerTypeId);
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getDisAttr().equals(roomId))
            {
                return list.get(i).getDisPrice();
            }
        }
        return 10;
    }

    public static String GenerateInNo()
    {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        // 格式化日期时间为字符串
        String formattedDateTime = currentDateTime.format(formatter);
        return "RZ" + formattedDateTime;
    }

    public static String getTimeInfo()
    {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm:ss");

        // 格式化日期时间为字符串
        String formattedDateTime = currentDateTime.format(formatter);

        // 打印格式化后的日期时间
        return formattedDateTime;

    }

    public static void setRoomZYUseType(String roomId)
    {
        RoomInfoDao roomInfoDao = new RoomInfoDao();
        roomInfoDao.updateRowRoomStatusZY(roomId);
    }

    public static BigDecimal getLiveInPk()
    {
        LiveInDao liveInDao = new LiveInDao();
        BigDecimal pk = liveInDao.getLastRow().get(0).getPk();
        System.out.println(pk);
        return pk.add(new BigDecimal("1"));
    }

    public static BigDecimal getCheckoutPk()
    {
        CheckOutDao checkOutDao = new CheckOutDao();
        BigDecimal pk = checkOutDao.getLastRow().get(0).getPk();
        System.out.println(pk);
        return pk.add(new BigDecimal("1"));
    }

    public static String GenerateInNoYD()
    {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        // 格式化日期时间为字符串
        String formattedDateTime = currentDateTime.format(formatter);
        return "YD" + formattedDateTime;
    }
}
