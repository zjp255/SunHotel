package Ui;

import DAO.entity.RoomInfo;
import Ui.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomBut extends JButton implements ActionListener {
    RoomInfo roomInfo;
    String redPath = "Source/房间 红.png";
    String path = "Source/房间.png";
    public boolean isAvailable = false;

    public RoomBut(RoomInfo roomInfo)
    {

        this.roomInfo = roomInfo;
        //setSize(new Dimension(50,60));
        setPreferredSize(new Dimension(50,60));
        setBackground(new Color(232, 220, 220));
        setLayout(null);

        JLabel imageLabel;
        if(roomInfo.getRoomState().equals("可供")) {
            isAvailable = true;
            imageLabel = new JLabel(getRoomImage());
            imageLabel.setBounds(0,0,50,50);
        } else{
            if (roomInfo.getRoomState().equals("占用") || roomInfo.getRoomState().equals("预订")) {
                isAvailable = false;
            }
            else {
                isAvailable = true;
            }
            imageLabel = new JLabel(getRedRoomImage());
            imageLabel.setBounds(0,0,50,50);
        }


        JLabel textLabel = new JLabel(roomInfo.getId());
        textLabel.setBounds(0,49,50,12);


        add(imageLabel);
        add(textLabel);
        setBorderPainted(false);
        setFocusPainted(false);
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

       leftPanel.getInstance().updateRoomStatus(roomInfo,isAvailable);
    }

    public ImageIcon getRoomImage()
    {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(50,50,Image.SCALE_SMOOTH));
    }
    public ImageIcon getRedRoomImage()
    {
       return new ImageIcon(Toolkit.getDefaultToolkit().getImage(redPath).getScaledInstance(50,50,Image.SCALE_SMOOTH));
    }
}
