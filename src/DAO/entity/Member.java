package DAO.entity;

import java.math.BigDecimal;

public class Member {
    private BigDecimal pk;//主键
    private String m_id;//会员编号
    private String m_name;//会员姓名
    private String sex;//性别
    private String zj_no;//证件编号
    private String m_tel;//联系电话
    private String address;//详细地址
    private String remark = null;//备注
    private int delmark = 0;//删除标记
    private String other1 = null;
    private String other2 = null;

    public Member(BigDecimal pk, String m_id, String m_name, String sex, String zj_no, String m_tel, String address, String remark, int delmark, String other1, String other2) {
        this.pk = pk;
        this.m_id = m_id;
        this.m_name = m_name;
        this.sex = sex;
        this.zj_no = zj_no;
        this.m_tel = m_tel;
        this.address = address;
        this.remark = remark;
        this.delmark = delmark;
        this.other1 = other1;
        this.other2 = other2;
    }

    public Member(BigDecimal pk, String m_id, String m_name, String sex, String zj_no, String m_tel, String address, String remark, int delmark, String other1) {
        this.pk = pk;
        this.m_id = m_id;
        this.m_name = m_name;
        this.sex = sex;
        this.zj_no = zj_no;
        this.m_tel = m_tel;
        this.address = address;
        this.remark = remark;
        this.delmark = delmark;
        this.other1 = other1;
    }

    public Member(BigDecimal pk, String m_id, String m_name, String sex, String zj_no, String m_tel, String address, String remark, int delmark) {
        this.pk = pk;
        this.m_id = m_id;
        this.m_name = m_name;
        this.sex = sex;
        this.zj_no = zj_no;
        this.m_tel = m_tel;
        this.address = address;
        this.remark = remark;
        this.delmark = delmark;
    }

    public Member(BigDecimal pk, String m_id, String m_name, String sex, String zj_no, String m_tel, String address, String remark) {
        this.pk = pk;
        this.m_id = m_id;
        this.m_name = m_name;
        this.sex = sex;
        this.zj_no = zj_no;
        this.m_tel = m_tel;
        this.address = address;
        this.remark = remark;
    }

    public Member(BigDecimal pk, String m_id, String m_name, String sex, String zj_no, String m_tel, String address) {
        this.pk = pk;
        this.m_id = m_id;
        this.m_name = m_name;
        this.sex = sex;
        this.zj_no = zj_no;
        this.m_tel = m_tel;
        this.address = address;
    }

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZj_no() {
        return zj_no;
    }

    public void setZj_no(String zj_no) {
        this.zj_no = zj_no;
    }

    public String getM_tel() {
        return m_tel;
    }

    public void setM_tel(String m_tel) {
        this.m_tel = m_tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Member{" +
                "pk=" + pk +
                ", m_id='" + m_id + '\'' +
                ", m_name='" + m_name + '\'' +
                ", sex='" + sex + '\'' +
                ", zj_no='" + zj_no + '\'' +
                ", m_tel='" + m_tel + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", delmark=" + delmark +
                ", other1='" + other1 + '\'' +
                ", other2='" + other2 + '\'' +
                '}';
    }

}
