package DAO.entity;

import java.math.BigDecimal;

public class Pwd {
    private BigDecimal pk;//主键
    private String userid;//用户登陆id
    private String pwd;//登录密码
    private String puis;//用户权限
    private int delmark = 0;//删除标记
    private String other1 = null;//保留1
    private String other2 = null;//保留2

    public Pwd(BigDecimal pk, String userid, String pwd, String puis, int delmark, String other1, String other2) {
        this.pk = pk;
        this.userid = userid;
        this.pwd = pwd;
        this.puis = puis;
        this.delmark = delmark;
        this.other1 = other1;
        this.other2 = other2;
    }

    public Pwd(BigDecimal pk, String userid, String pwd, String puis, int delmark, String other1) {
        this.pk = pk;
        this.userid = userid;
        this.pwd = pwd;
        this.puis = puis;
        this.delmark = delmark;
        this.other1 = other1;
    }

    public Pwd(BigDecimal pk, String userid, String pwd, String puis, int delmark) {
        this.pk = pk;
        this.userid = userid;
        this.pwd = pwd;
        this.puis = puis;
        this.delmark = delmark;
    }

    public Pwd(BigDecimal pk, String userid, String pwd, String puis) {
        this.pk = pk;
        this.userid = userid;
        this.pwd = pwd;
        this.puis = puis;
    }

    @Override
    public String toString() {
        return "Pwd{" +
                "pk=" + pk +
                ", userid='" + userid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", puis='" + puis + '\'' +
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPuis() {
        return puis;
    }

    public void setPuis(String puis) {
        this.puis = puis;
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
