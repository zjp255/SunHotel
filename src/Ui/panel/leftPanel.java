package Ui.panel;

import DAO.entity.RoomInfo;
import tool.SomeInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class leftPanel extends JPanel {
    public static leftPanel getInstance() {
        return instance;
    }

    private static leftPanel instance;
    JLabel timeLabel;
    JLabel roomStatus;
    JLabel allRoomStatus;
    String[] roomStatusText = {"房间状态","房间类型:","房间编号:","宾客姓名:","房间电话:","开始时间:"};
    String[] allRoomStatusText = {"房间总状态","房间总数:","当前占用:","当前可供:","当前预定:","当前停用:"};
    public int[] stateInfo = {0,0,0,0,0};
    public leftPanel()
    {
        instance = this;
        setBackground(new Color(215, 205, 205));
        setLayout(null);
        timeLabel = new JLabel();
        roomStatus = new JLabel();
        allRoomStatus = new JLabel();

        Font font = new Font("微软雅黑",Font.PLAIN,20);

        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setFont(font);

        roomStatus.setText("<HTML><font color = \"red\">" + roomStatusText[0] +"</font><br>" + roomStatusText[1] +"<br>" + roomStatusText[2] +"<br>" + roomStatusText[3] +"<br>" + roomStatusText[4] + "<br>"  + "<br>"+"______________________________");
        roomStatus.setVerticalAlignment(JLabel.TOP);
        roomStatus.setFont(font);


        allRoomStatus.setVerticalAlignment(JLabel.TOP);
        allRoomStatus.setFont(font);





        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });

        timer.start();
        updateTime();

        add(timeLabel);
        add(roomStatus);
        add(allRoomStatus);
    }

    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = sdf.format(new Date());
        timeLabel.setText(timeStr);
    }

    public void update()
    {
        timeLabel.setBounds(0,0,getWidth(),30);
        roomStatus.setBounds(0,30,getWidth(),(getHeight() - 30)/2);
        allRoomStatus.setBounds(0,(getHeight() - 30)/2 + 30,getWidth(),(getHeight() - 30)/2);
    }

    public void updateRoomStatus(RoomInfo roomInfo,boolean isAvailable) {
        roomStatus.setText("<HTML><font color = \"red\">" + roomStatusText[0] +"</font><br>" +
                roomStatusText[1] + SomeInfo.getRoomTypeString(roomInfo) +"<br>" + roomStatusText[2] + roomInfo.getId() +"<br>" +
                roomStatusText[3] + (isAvailable?"":SomeInfo.getGuestNameString(roomInfo)) + "<br>" + roomStatusText[4] + roomInfo.getPhoneNum() + "<br>" +
                 "<br>"+"______________________________");
    }

    public  void updateAllRoomStatus()
    {
        allRoomStatus.setText("<HTML><font color = \"red\">" + allRoomStatusText[0] +"</font><br>" +
                allRoomStatusText[1] + "\t" + stateInfo[0] +"<br>" +
                allRoomStatusText[2] + "\t" + stateInfo[1] +"<br>" +
                allRoomStatusText[3] + "\t" + stateInfo[2] +"<br>" +
                allRoomStatusText[4] + "\t" + stateInfo[3] +"<br>" +
                allRoomStatusText[5] + "\t" + stateInfo[4]);

    }
}
