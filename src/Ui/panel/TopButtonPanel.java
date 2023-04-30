package Ui.panel;

import Ui.LogInFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class TopButtonPanel extends JPanel implements ActionListener, ComponentListener {

    JButton individualBillBut;//散户开单
    JButton groupBillBut;//团体开单
    JButton guestCheckoutBut;//客户结账
    JButton roomReservationBut;//客房预定
    JButton businessInquiryBut;//客户管理
    JButton netSettingBut;//网络设置
    JButton sysSettingBut;//系统设置

    JFrame jFrame;

    public TopButtonPanel()
    {
        setLayout(null);
        individualBillBut = new JButton();
        groupBillBut = new JButton();
        guestCheckoutBut = new JButton();
        roomReservationBut = new JButton();
        businessInquiryBut = new JButton();
        netSettingBut = new JButton();
        sysSettingBut = new JButton();
        add(groupBillBut);
        add(individualBillBut);
        add(guestCheckoutBut);
        add(roomReservationBut);
        add(businessInquiryBut);
        add(netSettingBut);
        add(sysSettingBut);
        addComponentListener(this);

    }

    public void updateButs()
    {
        updateBut(individualBillBut,1);
        updateBut(groupBillBut,2);
        updateBut(guestCheckoutBut,3);
        updateBut(roomReservationBut,4);
        updateBut(businessInquiryBut,5);
        updateBut(netSettingBut,6);
        updateBut(sysSettingBut,7);
    }

    void updateBut(JButton button,int no)
    {
        int tempHeight = (getHeight() - 62 ) / 2;

        button.setBounds(10 + (no - 1) * 80,tempHeight,50,62);
    }

    public void initButs()
    {
        initButton(individualBillBut,"Source/个人.png",1,"散客开单");
        initButton(groupBillBut,"Source/多人.png",2,"团体开单");
        initButton(guestCheckoutBut,"Source/结账.png",3,"客户结账");
        initButton(roomReservationBut,"Source/预定.png",4,"客房预定");
        initButton(businessInquiryBut,"Source/客户管理.png",5,"客户管理");
        initButton(netSettingBut,"Source/网络设置.png",6,"网络设置");
        initButton(sysSettingBut,"Source/系统设置.png",7,"系统设置");
    }
    void initButton(JButton button,String path,int no,String butName)
    {

        int tempHeight = (getHeight() - 62 ) / 2;

        button.setBounds(10 + (no - 1) *60,tempHeight,50,62);
        button.setBackground(new Color(238, 238, 238));
        button.setLayout(null);

        JLabel imageLabel = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        imageLabel.setBounds(0,0,50,50);


        JLabel textLabel = new JLabel(butName);
        textLabel.setBounds(0,49,50,12);


        button.add(imageLabel);
        button.add(textLabel);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == individualBillBut)
        {
            if(jFrame == null)
            {
                jFrame = new LogInFrame();
            }
        }
        else if(e.getSource() == groupBillBut)
        {

        }
        else if(e.getSource() == guestCheckoutBut)
        {

        }
        else if(e.getSource() == roomReservationBut)
        {

        }
        else if(e.getSource() == businessInquiryBut)
        {

        }
        else if(e.getSource() == netSettingBut)
        {

        }
        else if(e.getSource() == sysSettingBut)
        {

        }

    }

    @Override
    public void componentResized(ComponentEvent e) {
        initButs();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}


