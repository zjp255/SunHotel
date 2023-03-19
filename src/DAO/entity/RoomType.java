package DAO.entity;

import java.math.BigDecimal;

public class RoomType {

    private BigDecimal pk;//主键
    private String id;//房间类型编号
    private String r_type;//房间类型
    private String bed;//床位数
    private double price;//单价
    private double foregift;//押金
    private String cl_room;//是否钟点房
    private double cl_price;//钟点房价格
    private String remark = null;//备注
    private int sysmark = 0;
    private int delmark = 0;//删除标记
    private String other1 = null;
    private String other2 = null;

    public RoomType(BigDecimal pk, String id, String r_type, String bed, double price, double foregift, String cl_room, double cl_price) {
        this.pk = pk;
        this.id = id;
        this.r_type = r_type;
        this.bed = bed;
        this.price = price;
        this.foregift = foregift;
        this.cl_room = cl_room;
        this.cl_price = cl_price;

    }

    public RoomType(BigDecimal pk, String id, String r_type, String bed, double price, double foregift, String cl_room, double cl_price, String remark, int sysmark) {
        this.pk = pk;
        this.id = id;
        this.r_type = r_type;
        this.bed = bed;
        this.price = price;
        this.foregift = foregift;
        this.cl_room = cl_room;
        this.cl_price = cl_price;
        this.remark = remark;
        this.sysmark = sysmark;

    }

    public RoomType(BigDecimal pk, String id, String r_type, String bed, double price, double foregift, String cl_room, double cl_price, String remark, int sysmark, int delmark) {
        this.pk = pk;
        this.id = id;
        this.r_type = r_type;
        this.bed = bed;
        this.price = price;
        this.foregift = foregift;
        this.cl_room = cl_room;
        this.cl_price = cl_price;
        this.remark = remark;
        this.sysmark = sysmark;
        this.delmark = delmark;

    }

    public RoomType(BigDecimal pk, String id, String r_type, String bed, double price, double foregift, String cl_room, double cl_price, String remark, int sysmark, int delmark, String other1) {
        this.pk = pk;
        this.id = id;
        this.r_type = r_type;
        this.bed = bed;
        this.price = price;
        this.foregift = foregift;
        this.cl_room = cl_room;
        this.cl_price = cl_price;
        this.remark = remark;
        this.sysmark = sysmark;
        this.delmark = delmark;
        this.other1 = other1;
    }

    public RoomType(BigDecimal pk, String id, String r_type, String bed, double price, double foregift, String cl_room, double cl_price, String remark) {
        this.pk = pk;
        this.id = id;
        this.r_type = r_type;
        this.bed = bed;
        this.price = price;
        this.foregift = foregift;
        this.cl_room = cl_room;
        this.cl_price = cl_price;
        this.remark = remark;

    }

    public RoomType(BigDecimal pk, String id, String r_type, String bed, double price, double foregift, String cl_room, double cl_price, String remark, int sysmark, int delmark, String other1, String other2) {
        this.pk = pk;
        this.id = id;
        this.r_type = r_type;
        this.bed = bed;
        this.price = price;
        this.foregift = foregift;
        this.cl_room = cl_room;
        this.cl_price = cl_price;
        this.remark = remark;
        this.sysmark = sysmark;
        this.delmark = delmark;
        this.other1 = other1;
        this.other2 = other2;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "pk=" + pk +
                ", id='" + id + '\'' +
                ", r_type='" + r_type + '\'' +
                ", bed='" + bed + '\'' +
                ", price=" + price +
                ", foregift=" + foregift +
                ", cl_room='" + cl_room + '\'' +
                ", cl_price=" + cl_price +
                ", remark='" + remark + '\'' +
                ", sysmark=" + sysmark +
                ", delmark=" + delmark +
                ", other1='" + other1 + '\'' +
                ", other2='" + other2 + '\'' +
                '}';
    }

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getForegift() {
        return foregift;
    }

    public void setForegift(double foregift) {
        this.foregift = foregift;
    }

    public String getCl_room() {
        return cl_room;
    }

    public void setCl_room(String cl_room) {
        this.cl_room = cl_room;
    }

    public double getCl_price() {
        return cl_price;
    }

    public void setCl_price(double cl_price) {
        this.cl_price = cl_price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getSysmark() {
        return sysmark;
    }

    public void setSysmark(int sysmark) {
        this.sysmark = sysmark;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

}
