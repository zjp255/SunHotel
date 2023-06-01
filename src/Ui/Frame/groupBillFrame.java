package Ui.Frame;

import DAO.entity.LiveIn;
import DAO.entity.RoomInfo;
import DAO.entityDao.LiveInDao;
import Ui.MyDialog;
import Ui.panel.BottomPanel;
import Ui.panel.RightPanel;
import Ui.panel.TopButtonPanel;
import tool.SomeInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class groupBillFrame extends JFrame implements ActionListener {
    JComboBox<String> idType;
    JTextField idCode;
    JComboBox<String> guestSexType;
    JComboBox<String> guestType;
    JTextField guestName;
    JTextField guestCount;
    JTextField addressInfo;
    JTextField otherInfo;
    JLabel discount;
    JLabel mainRoom;
    JTextField useRoomDays;//预住天数
    JTextField cashPledge;//押金
    JList<String> emptyRoomList;
    JList<String> billRoomList;
    JButton addRoom,deleteRoom,confirm,cancel;
    JComboBox<String> roomType;
    Font font;
    TopButtonPanel owner;

    List<RoomInfo> openBillRoomInfoS;
    DefaultListModel<String> LList,RList;
    public groupBillFrame(TopButtonPanel owner)
    {
        this.owner = owner;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                owner.setGroupBillFrame(null);
            }});
        LList = new DefaultListModel<>();
        RList = new DefaultListModel<>();
        openBillRoomInfoS = new ArrayList<>();
        setTitle("团体开单");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Source/多人.png"));
        setSize(595,650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        font = new Font("微软雅黑",Font.PLAIN,20);

        JLabel topLabel = new JLabel("开单信息");
        topLabel.setFont(font);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setBounds(0,5,590,30);
        topLabel.setOpaque(true);
        topLabel.setBackground(new Color(255, 255, 255));
        add(topLabel);
        //-----------------------------------------------------------

        createJLabel("证件类型:",18,70,53,30);

        idType = new JComboBox<>(SomeInfo.getIdType());
        idType.setBounds(73,70,80,25);
        add(idType);

        createJLabel("证件编码:",182,70,53,30);

        idCode = new JTextField();
        idCode.setBounds(239,70,160,25);
        add(idCode);

        createJLabel("主客性别:",428,70,53,30);

        guestSexType = new JComboBox<>(SomeInfo.getSexType());
        guestSexType.setBounds(483,70,80,25);
        add(guestSexType);

        //-----------------------------------------------------------

        createJLabel("宾客类型:",18,110,53,30);

        guestType = new JComboBox<>(SomeInfo.guestType());
        guestType.setBounds(73,110,80,25);
        add(guestType);

        createJLabel("主客姓名:",182,110,53,30);

        guestName = new JTextField();
        guestName.setBounds(239,110,160,25);
        add(guestName);

        createJLabel("宾客人数:",428,110,53,30);

        guestCount = new JTextField("1");
        guestCount.setBounds(483,110,80,25);
        add(guestCount);
        //-----------------------------------------------------------------------------

        createJLabel("地址信息:",18,150,53,30);

        addressInfo = new JTextField();
        addressInfo.setBounds(73,150,490,25);
        add(addressInfo);

        createJLabel("备注信息:",18,190,53,30);

        otherInfo = new JTextField();
        otherInfo.setBounds(73,190,490,25);
        add(otherInfo);

        //-----------------------------------------------------------------------------

        createJLabel("折扣比例:",18,230,53,30);

        discount = new JLabel("10");
        discount.setBounds(73,230,40,30);
        add(discount);


        createJLabel("主客房间:",140,230,53,30);

        mainRoom = new JLabel();
        mainRoom.setBounds(195,230,53,30);
        add(mainRoom);

        createJLabel("预住天数:",270,230,53,30);

        useRoomDays = new JTextField("1");
        useRoomDays.setBounds(325,230,60,30);
        add(useRoomDays);

        createJLabel("实收押金:",420,230,53,30);

        cashPledge = new JTextField("¥0.00");
        cashPledge.setBounds(480,230,80,30);
        add(cashPledge);

        //-----------------------------------------------------------------------------
        createJLabel("房间类型",18,280,53,30);
        roomType = new JComboBox<>(SomeInfo.getRoomType());
        roomType.setBounds(75,280,100,25);
        roomType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 处理选项改变的逻辑
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    getAvailableRoomCode();
                    updateJLists();
                }
            }
        });
        add(roomType);


        JLabel jLabel13 = new JLabel("可供房间");
        jLabel13.setFont(font);
        jLabel13.setHorizontalAlignment(JLabel.CENTER);
        jLabel13.setBounds(18,320,200,30);
        jLabel13.setOpaque(true);
        jLabel13.setBackground(new Color(133, 123, 123));
        add(jLabel13);

        emptyRoomList = new JList<>();
        emptyRoomList.setBounds(18,350,200,200);
        add(emptyRoomList);

        JLabel jLabel14 = new JLabel("开单房间");
        jLabel14.setFont(font);
        jLabel14.setHorizontalAlignment(JLabel.CENTER);
        jLabel14.setBounds(360,320,200,30);
        jLabel14.setOpaque(true);
        jLabel14.setBackground(new Color(133, 123, 123));
        add(jLabel14);

        billRoomList = new JList<>();
        billRoomList.setBounds(360,350,200,200);
        add(billRoomList);

        addRoom = new JButton(">");
        addRoom.setMargin(new Insets(0, 0, 0, 0));
        addRoom.setBounds(275,400,30,30);
        addRoom.setBorderPainted(false);
        addRoom.setFocusPainted(false);
        addRoom.addActionListener(this);
        add(addRoom);

        deleteRoom = new JButton("<");
        deleteRoom.setMargin(new Insets(0, 0, 0, 0));
        deleteRoom.setBounds(275,450,30,30);
        deleteRoom.setBorderPainted(false);
        deleteRoom.setFocusPainted(false);
        deleteRoom.addActionListener(this);
        add(deleteRoom);

        confirm = new JButton("确认");
        confirm.setMargin(new Insets(0, 0, 0, 0));
        confirm.setBounds(150,570,100,30);
        confirm.setBorderPainted(false);
        confirm.setFocusPainted(false);
        confirm.addActionListener(this);
        add(confirm);

        cancel = new JButton("取消");
        cancel.setMargin(new Insets(0, 0, 0, 0));
        cancel.setBounds(320,570,100,30);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        getAvailableRoomCode();
        updateJLists();
        
    }

    void createJLabel(String title,int x,int y ,int width,int height)
    {
        JLabel jLabel = new JLabel(title);
        jLabel.setBounds(x,y,width,height);
        add(jLabel);
    }

    
    String getAvailableRoomCode()
    {
        List<RoomInfo> list = new ArrayList<>();
        openBillRoomInfoS.clear();
        if(roomType.getSelectedIndex() == 0) {

            list = RightPanel.getInstance().getRoomInfo1();
        } else if (roomType.getSelectedIndex() == 1) {
            list = RightPanel.getInstance().getRoomInfo2();
        } else if (roomType.getSelectedIndex() == 2) {
            list = RightPanel.getInstance().getRoomInfo3();
        } else if (roomType.getSelectedIndex() == 3) {
            list = RightPanel.getInstance().getRoomInfo4();
        } else if (roomType.getSelectedIndex() == 4) {
            list = RightPanel.getInstance().getRoomInfo5();
        } else if (roomType.getSelectedIndex() == 5) {
            list = RightPanel.getInstance().getRoomInfo6();
        }
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getRoomState().equals("可供"))
            {
                openBillRoomInfoS.add(list.get(i));
            }
        }
        return openBillRoomInfoS == null?"":openBillRoomInfoS.get(0).getId();
    }

    void updateJLists(){
        LList.clear();
        for(int i = 0; i < openBillRoomInfoS.size();i++) {
            if(RList.isEmpty()) {
                LList.addElement(openBillRoomInfoS.get(i).getId());
            }else {
                boolean isAdd = true;
                for (int j = 0; j < RList.size(); j++) {
                    if (RList.getElementAt(j).equals(openBillRoomInfoS.get(i).getId()))
                        isAdd = false;
                }
                if (isAdd)
                {
                    LList.addElement(openBillRoomInfoS.get(i).getId());
                }
            }
        }
        billRoomList.setModel(RList);
        emptyRoomList.setModel(LList);
    }

    void addRoomFc()
    {
        if(!LList.isEmpty()) {
            RList.addElement(LList.get(0));
            LList.remove(0);
            mainRoom.setText(RList.get(0));
        }
    }
    void deleteRoomFc()
    {
        if(RList.size() > 0) {
            RList.remove(RList.size() - 1);
            updateJLists();
        }
    }

    void confirmFc()
    {
        LiveIn liveIn;
        LiveInDao liveInDao = new LiveInDao();
        String in_no = SomeInfo.GenerateInNo();

        for(int i = 0; i < RList.size();i++) {
            liveIn = new LiveIn(
                    SomeInfo.getLiveInPk(),
                    in_no,
                    RList.get(i),
                    SomeInfo.getRoomTypeID(RList.get(i)),
                    RList.get(0),
                    openBillRoomInfoS.get(i).getPk(),
                    SomeInfo.getCustomerTypeID(guestType.getSelectedItem().toString()),
                    guestName.getText(),
                    null,
                    guestSexType.getSelectedItem().toString(),
                    idType.getSelectedItem().toString(),
                    idCode.getText(),
                    addressInfo.getText(),
                    Integer.parseInt(guestCount.getText()),
                    SomeInfo.getTimeInfo(),
                    0,
                    Integer.parseInt(useRoomDays.getText()),
                    Integer.parseInt(cashPledge.getText()),
                    otherInfo.getText(),
                    null,
                    null,
                    null,
                    (MainFrame.getInstance().getPwd().getUserid() == null?"":MainFrame.getInstance().getPwd().getUserid()),
                    null,
                    0,
                    0,
                    null,
                    null);
            liveInDao.addRow(liveIn);
            SomeInfo.setRoomZYUseType(RList.get(i));
        }
        RightPanel.getInstance().updateJPanels();
        BottomPanel.getInstance().updateTable(RightPanel.getInstance().getNowRoomType());
    }

    void cancelFc()
    {
        owner.setIndividualBillFrame(null);
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addRoom) {
            addRoomFc();
        } else if (e.getSource() == deleteRoom) {
            deleteRoomFc();
        } else if (e.getSource() == confirm) {
            confirmFc();
            new MyDialog(MainFrame.getInstance(), "开单成功");
            cancelFc();
        } else if (e.getSource() == cancel) {
            cancelFc();
        }

    }
}
