package DAO.entity;

import java.math.BigDecimal;

public class CustomerType {
    private BigDecimal pk;
    private String id;
    private String cType;
    private String disAttr;
    private int discount;
    private double price;
    private double disPrice;
    private String remark;
    private int delMark;
    private String other1;
    private String other2;

    public CustomerType(BigDecimal pk, String id, String cType, String disAttr, int discount, double price, double disPrice, String remark, int delMark, String other1, String other2) {
        this.pk = pk;
        this.id = id;
        this.cType = cType;
        this.disAttr = disAttr;
        this.discount = discount;
        this.price = price;
        this.disPrice = disPrice;
        this.remark = remark;
        this.delMark = delMark;
        this.other1 = other1;
        this.other2 = other2;
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "pk=" + pk +
                ", id='" + id + '\'' +
                ", cType='" + cType + '\'' +
                ", disAttr='" + disAttr + '\'' +
                ", discount=" + discount +
                ", price=" + price +
                ", disPrice=" + disPrice +
                ", remark='" + remark + '\'' +
                ", delMark=" + delMark +
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

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getDisAttr() {
        return disAttr;
    }

    public void setDisAttr(String disAttr) {
        this.disAttr = disAttr;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(double disPrice) {
        this.disPrice = disPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
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
