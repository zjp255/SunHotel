package DAO.entity;

import java.math.BigDecimal;

public class RoomInfo {
    private BigDecimal pk;//主键
    private String id;//id
    private String roomTypeId;//房间类型id
    private String roomState;//房间状态
    private String location;//楼层
    private String phoneNum;//房间电话
    private String remark;//备注
    private int stateTime;//状态计时
    private int indimark = 0;
    private int delmark = 0;//删除标记
    private String other1 = null;
    private String other2 = null;

    public RoomInfo(BigDecimal pk, String id, String roomTypeId, String roomState, String location, String phoneNum, String remark, int stateTime, int indimark, int delmark, String other1, String other2) {
        this.pk = pk;
        this.id = id;
        this.roomTypeId = roomTypeId;
        this.roomState = roomState;
        this.location = location;
        this.phoneNum = phoneNum;
        this.remark = remark;
        this.stateTime = stateTime;
        this.indimark = indimark;
        this.delmark = delmark;
        this.other1 = other1;
        this.other2 = other2;
    }

    public RoomInfo(BigDecimal pk, String id, String roomTypeId, String roomState, String location, String phoneNum, String remark, String other1) {
        this.pk = pk;
        this.id = id;
        this.roomTypeId = roomTypeId;
        this.roomState = roomState;
        this.location = location;
        this.phoneNum = phoneNum;
        this.remark = remark;
        this.other1 = other1;
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

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomState() {
        return roomState;
    }

    public void setRoomState(String roomState) {
        this.roomState = roomState;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStateTime() {
        return stateTime;
    }

    public void setStateTime(int stateTime) {
        this.stateTime = stateTime;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    @Override
    public String toString() {
        return "RoomInfo{" +
                "pk=" + pk +
                ", id='" + id + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", roomState='" + roomState + '\'' +
                ", location=" + location +
                ", phoneNum='" + phoneNum + '\'' +
                ", remark='" + remark + '\'' +
                ", stateTime=" + stateTime +
                ", indimark=" + indimark +
                ", delmark=" + delmark +
                ", other1='" + other1 + '\'' +
                ", other2='" + other2 + '\'' +
                '}';
    }
}
