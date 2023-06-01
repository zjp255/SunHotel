package DAO.entity;

import java.math.BigDecimal;

public class CheckOut {
    private BigDecimal pk;
    private String chkNo;
    private String inNo;
    private int days;
    private double money;
    private String chkTime;
    private String remark;
    private int delmark;
    private String other1;
    private String other2;

    @Override
    public String toString() {
        return "CheckOut{" +
                "pk=" + pk +
                ", chkNo='" + chkNo + '\'' +
                ", inNo='" + inNo + '\'' +
                ", days=" + days +
                ", money=" + money +
                ", chkTime='" + chkTime + '\'' +
                ", remark='" + remark + '\'' +
                ", delmark=" + delmark +
                ", other1='" + other1 + '\'' +
                ", other2='" + other2 + '\'' +
                '}';
    }

    public CheckOut(BigDecimal pk, String chkNo, String inNo, int days, double money, String chkTime, String remark, int delmark, String other1, String other2) {
        this.pk = pk;
        this.chkNo = chkNo;
        this.inNo = inNo;
        this.days = days;
        this.money = money;
        this.chkTime = chkTime;
        this.remark = remark;
        this.delmark = delmark;
        this.other1 = other1;
        this.other2 = other2;
    }

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getChkNo() {
        return chkNo;
    }

    public void setChkNo(String chkNo) {
        this.chkNo = chkNo;
    }

    public String getInNo() {
        return inNo;
    }

    public void setInNo(String inNo) {
        this.inNo = inNo;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getChkTime() {
        return chkTime;
    }

    public void setChkTime(String chkTime) {
        this.chkTime = chkTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
