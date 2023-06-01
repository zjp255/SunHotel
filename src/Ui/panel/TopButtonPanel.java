package Ui.panel;

import Ui.Frame.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class TopButtonPanel extends JPanel implements ActionListener, ComponentListener {

    static TopButtonPanel instance;

    public static TopButtonPanel getInstance() {
        return instance;
    }

    JButton individualBillBut;//散户开单
    JButton groupBillBut;//团体开单
    JButton guestCheckoutBut;//客户结账
    JButton roomReservationBut;//客房预定
    JButton businessInquiryBut;//营业查询
    JButton customerManagementBut;//客户管理


    JFrame individualBillFrame,groupBillFrame,guestCheckoutFrame,roomReservationFrame,businessInquiryFrame,customerManagementFrame;

    public TopButtonPanel()
    {
        setLayout(null);
        individualBillBut = new JButton();
        groupBillBut = new JButton();
        guestCheckoutBut = new JButton();
        roomReservationBut = new JButton();
        businessInquiryBut = new JButton();
        customerManagementBut = new JButton();

        add(groupBillBut);
        add(individualBillBut);
        add(guestCheckoutBut);
        add(roomReservationBut);
        add(businessInquiryBut);
        add(customerManagementBut);

        addComponentListener(this);

    }

    public void updateButs()
    {
        updateBut(individualBillBut,1);
        updateBut(groupBillBut,2);
        updateBut(guestCheckoutBut,3);
        //updateBut(roomReservationBut,4);
        updateBut(businessInquiryBut,4);
        //updateBut(customerManagementBut,6);

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
        //initButton(roomReservationBut,"Source/预定.png",4,"客房预定");
        initButton(businessInquiryBut,"Source/营业执照.png",5,"营业查询");
        //initButton(customerManagementBut,"Source/客户管理.png",6,"客户管理");

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
            if(individualBillFrame == null)
            {
                individualBillFrame = new IndividualBillFrame(this);
            }
        }
        else if(e.getSource() == groupBillBut)
        {
            if(groupBillFrame == null)
            {
                groupBillFrame = new groupBillFrame(this);
            }
        }
        else if(e.getSource() == guestCheckoutBut)
        {
            if(guestCheckoutFrame == null)
            {
                guestCheckoutFrame = new guestCheckoutFrame(this);
            }
        }
        else if(e.getSource() == roomReservationBut)
        {
            if(roomReservationFrame == null)
            {
                roomReservationFrame = new roomReservationFrame(this);
            }
        }
        else if(e.getSource() == businessInquiryBut)
        {
            if(businessInquiryFrame== null)
            {
                businessInquiryFrame = new businessInquiryFrame(this);
            }
        }
        else if(e.getSource() == customerManagementBut)
        {
            if(customerManagementFrame == null)
            {
               customerManagementFrame = new customerManagementFrame(this);
            }
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

    public JFrame getIndividualBillFrame() {
        return individualBillFrame;
    }

    public void setIndividualBillFrame(JFrame individualBillFrame) {
        this.individualBillFrame = individualBillFrame;
    }

    public JFrame getGroupBillFrame() {
        return groupBillFrame;
    }

    public void setGroupBillFrame(JFrame groupBillFrame) {
        this.groupBillFrame = groupBillFrame;
    }

    public JFrame getGuestCheckoutFrame() {
        return guestCheckoutFrame;
    }

    public void setGuestCheckoutFrame(JFrame guestCheckoutFrame) {
        this.guestCheckoutFrame = guestCheckoutFrame;
    }

    public JFrame getRoomReservationFrame() {
        return roomReservationFrame;
    }

    public void setRoomReservationFrame(JFrame roomReservationFrame) {
        this.roomReservationFrame = roomReservationFrame;
    }

    public JFrame getBusinessInquiryFrame() {
        return businessInquiryFrame;
    }

    public void setBusinessInquiryFrame(JFrame businessInquiryFrame) {
        this.businessInquiryFrame = businessInquiryFrame;
    }

    public JFrame getCustomerManagementFrame() {
        return customerManagementFrame;
    }

    public void setCustomerManagementFrame(JFrame customerManagementFrame) {
        this.customerManagementFrame = customerManagementFrame;
    }
}


