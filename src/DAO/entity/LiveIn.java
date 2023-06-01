package DAO.entity;

import java.math.BigDecimal;

public class LiveIn {
    private BigDecimal pk;//主键
    private String in_no;//入住单号
    private String r_no;//房间号
    private String r_type_id;//房间类型编号
    private String main_room;//主房间号
    private BigDecimal main_pk;//主房间pk
    private String c_type_id;//客户类型编号
    private String c_name;//客户名称
    private String c_jp;//客户名称简拼
    private String sex;//性别
    private String zj_type;//证件类型
    private String zj_no;//证件编号
    private String address;//地址信息
    private int renShu;//人数
    private String in_time;//入住时间
    private double account;//消费数量
    private int days;//预住天数
    private double foreGift;//押金
    private String remark;//备注
    private String m_id;//会员编号
    private String chk_no;//结算单号
    private String chk_time;//结算时间
    private String userid;//操作员id
    private String stateMark;//状态标志
    private int clueMark;//提醒标志
    private int delMark;//删除标记
    private String other1;
    private String other2;

    public LiveIn(String in_no, String r_no, String r_type_id, String main_room, BigDecimal main_pk, String c_type_id, String c_name, String c_jp, String sex, String zj_type, String zj_no, String address, int renShu, String in_time, double account, int days, double foreGift, String remark, String m_id, String chk_no, String chk_time, String userid, String stateMark, int clueMark, int delMark, String other1, String other2) {
        this.in_no = in_no;
        this.r_no = r_no;
        this.r_type_id = r_type_id;
        this.main_room = main_room;
        this.main_pk = main_pk;
        this.c_type_id = c_type_id;
        this.c_name = c_name;
        this.c_jp = c_jp;
        this.sex = sex;
        this.zj_type = zj_type;
        this.zj_no = zj_no;
        this.address = address;
        this.renShu = renShu;
        this.in_time = in_time;
        this.account = account;
        this.days = days;
        this.foreGift = foreGift;
        this.remark = remark;
        this.m_id = m_id;
        this.chk_no = chk_no;
        this.chk_time = chk_time;
        this.userid = userid;
        this.stateMark = stateMark;
        this.clueMark = clueMark;
        this.delMark = delMark;
        this.other1 = other1;
        this.other2 = other2;
    }

    public LiveIn(BigDecimal pk, String in_no, String r_no, String r_type_id, String main_room, BigDecimal main_pk, String c_type_id, String c_name, String c_jp, String sex, String zj_type, String zj_no, String address, int renShu, String in_time, double account, int days, double foreGift, String remark, String m_id, String chk_no, String chk_time, String userid, String stateMark, int clueMark, int delMark) {
        this.pk = pk;
        this.in_no = in_no;
        this.r_no = r_no;
        this.r_type_id = r_type_id;
        this.main_room = main_room;
        this.main_pk = main_pk;
        this.c_type_id = c_type_id;
        this.c_name = c_name;
        this.c_jp = c_jp;
        this.sex = sex;
        this.zj_type = zj_type;
        this.zj_no = zj_no;
        this.address = address;
        this.renShu = renShu;
        this.in_time = in_time;
        this.account = account;
        this.days = days;
        this.foreGift = foreGift;
        this.remark = remark;
        this.m_id = m_id;
        this.chk_no = chk_no;
        this.chk_time = chk_time;
        this.userid = userid;
        this.stateMark = stateMark;
        this.clueMark = clueMark;
        this.delMark = delMark;
    }

    public LiveIn(BigDecimal pk, String in_no, String r_no, String r_type_id, String main_room, BigDecimal main_pk, String c_type_id, String c_name, String c_jp, String sex, String zj_type, String zj_no, String address, int renShu, String in_time, double account, int days, double foreGift, String remark, String m_id, String chk_no, String chk_time, String userid, String stateMark, int clueMark, int delMark, String other1, String other2) {
        this.pk = pk;
        this.in_no = in_no;
        this.r_no = r_no;
        this.r_type_id = r_type_id;
        this.main_room = main_room;
        this.main_pk = main_pk;
        this.c_type_id = c_type_id;
        this.c_name = c_name;
        this.c_jp = c_jp;
        this.sex = sex;
        this.zj_type = zj_type;
        this.zj_no = zj_no;
        this.address = address;
        this.renShu = renShu;
        this.in_time = in_time;
        this.account = account;
        this.days = days;
        this.foreGift = foreGift;
        this.remark = remark;
        this.m_id = m_id;
        this.chk_no = chk_no;
        this.chk_time = chk_time;
        this.userid = userid;
        this.stateMark = stateMark;
        this.clueMark = clueMark;
        this.delMark = delMark;
        this.other1 = other1;
        this.other2 = other2;
    }

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getIn_no() {
        return in_no;
    }

    public void setIn_no(String in_no) {
        this.in_no = in_no;
    }

    public String getR_no() {
        return r_no;
    }

    public void setR_no(String r_no) {
        this.r_no = r_no;
    }

    public String getR_type_id() {
        return r_type_id;
    }

    public void setR_type_id(String r_type_id) {
        this.r_type_id = r_type_id;
    }

    public String getMain_room() {
        return main_room;
    }

    public void setMain_room(String main_room) {
        this.main_room = main_room;
    }

    public BigDecimal getMain_pk() {
        return main_pk;
    }

    public void setMain_pk(BigDecimal main_pk) {
        this.main_pk = main_pk;
    }

    public String getC_type_id() {
        return c_type_id;
    }

    public void setC_type_id(String c_type_id) {
        this.c_type_id = c_type_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_jp() {
        return c_jp;
    }

    public void setC_jp(String c_jp) {
        this.c_jp = c_jp;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZj_type() {
        return zj_type;
    }

    public void setZj_type(String zj_type) {
        this.zj_type = zj_type;
    }

    public String getZj_no() {
        return zj_no;
    }

    public void setZj_no(String zj_no) {
        this.zj_no = zj_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRenShu() {
        return renShu;
    }

    public void setRenShu(int renShu) {
        this.renShu = renShu;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getForeGift() {
        return foreGift;
    }

    public void setForeGift(double foreGift) {
        this.foreGift = foreGift;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getChk_no() {
        return chk_no;
    }

    public void setChk_no(String chk_no) {
        this.chk_no = chk_no;
    }

    public String getChk_time() {
        return chk_time;
    }

    public void setChk_time(String chk_time) {
        this.chk_time = chk_time;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStateMark() {
        return stateMark;
    }

    public void setStateMark(String stateMark) {
        this.stateMark = stateMark;
    }

    public int getClueMark() {
        return clueMark;
    }

    public void setClueMark(int clueMark) {
        this.clueMark = clueMark;
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

    @Override
    public String toString() {
        return "LiveIn{" +
                "pk=" + pk +
                ", in_no='" + in_no + '\'' +
                ", r_no='" + r_no + '\'' +
                ", r_type_id='" + r_type_id + '\'' +
                ", main_room='" + main_room + '\'' +
                ", main_pk='" + main_pk + '\'' +
                ", c_type_id='" + c_type_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_jp='" + c_jp + '\'' +
                ", sex='" + sex + '\'' +
                ", zj_type='" + zj_type + '\'' +
                ", zj_no='" + zj_no + '\'' +
                ", address='" + address + '\'' +
                ", renShu=" + renShu +
                ", in_time='" + in_time + '\'' +
                ", account=" + account +
                ", days=" + days +
                ", foreGift=" + foreGift +
                ", remark='" + remark + '\'' +
                ", m_id='" + m_id + '\'' +
                ", chk_no='" + chk_no + '\'' +
                ", chk_time='" + chk_time + '\'' +
                ", userid='" + userid + '\'' +
                ", stateMark='" + stateMark + '\'' +
                ", clueMark=" + clueMark +
                ", delMark=" + delMark +
                ", other1='" + other1 + '\'' +
                ", other2='" + other2 + '\'' +
                '}';
    }
}
