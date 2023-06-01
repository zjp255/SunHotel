package Ui.Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import DAO.entity.LiveIn;
import DAO.entity.RoomInfo;
import DAO.entityDao.LiveInDao;
import Ui.MyDialog;
import Ui.panel.BottomPanel;
import Ui.panel.InfoPanel;
import Ui.panel.RightPanel;
import Ui.panel.TopButtonPanel;
import tool.SomeInfo;

public class IndividualBillFrame extends JFrame implements ActionListener {
  JLabel roomCode;
  JLabel roomType;
  JLabel roomPrice;

  JComboBox<String> idType;
  JTextField idCode;
  JComboBox<String> guestSexType;
  JComboBox<String> guestType;
  JTextField guestName;
  JTextField guestCount;
  JTextField addressInfo;
  JTextField otherInfo;
  JLabel discount;
  JLabel actualPrice;
  JTextField useRoomDays;//预住天数
  JTextField cashPledge;//押金
  JList<String> emptyRoomList;
  JList<String> billRoomList;
  JButton addRoom,deleteRoom,confirm,cancel;
  TopButtonPanel owner;
  Font font;

  List<RoomInfo> openBillRoomInfoS;
  DefaultListModel<String> LList,RList;

  public IndividualBillFrame(TopButtonPanel owner)
  {
    LList = new DefaultListModel<>();
    RList = new DefaultListModel<>();
    this.owner = owner;
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        owner.setIndividualBillFrame(null);
      }});
    openBillRoomInfoS = new ArrayList<>();
    setTitle("散客开单");
    setIconImage(Toolkit.getDefaultToolkit().getImage("Source/个人.png"));
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

    roomCode = createJLabelOfCenter(roomCode,"主客房间:",10,40,190,25);
    roomType = createJLabelOfCenter(roomType,"房间类型:",200,40,190,25);
    roomPrice = createJLabelOfCenter(roomPrice,"预设单价:",390,40,190,25);

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


    //-----------------------------------------------------------------------------

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


    createJLabel("实际单价:",140,230,53,30);

    actualPrice = new JLabel("¥100.0");
    actualPrice.setBounds(195,230,53,30);
    add(actualPrice);

    createJLabel("预住天数:",270,230,53,30);

    useRoomDays = new JTextField("1");
    useRoomDays.setBounds(325,230,60,30);
    add(useRoomDays);

    createJLabel("实收押金:",420,230,53,30);

    cashPledge = new JTextField("0.00");
    cashPledge.setBounds(480,230,80,30);
    add(cashPledge);

    //-----------------------------------------------------------------------------

    createJLabel("追加房间",18,280,53,30);

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

    updateRoomInfo();
    updateJLists();
  }

  void createJLabel(String title,int x,int y ,int width,int height)
  {
    JLabel jLabel = new JLabel(title);
    jLabel.setBounds(x,y,width,height);
    add(jLabel);
  }

  JLabel createJLabelOfCenter(JLabel jLabel,String title,int x,int y ,int width,int height)
  {
    jLabel = new JLabel(title);
    jLabel.setHorizontalAlignment(JLabel.CENTER);
    jLabel.setBounds(x,y,width,height);
    add(jLabel);
    return jLabel;
  }

 void updateRoomInfo()
  {
    this.roomCode.setText("主客房间:" + getAvailableRoomCode() );
    this.roomType.setText("房间类型:" + SomeInfo.getRoomTypeString(openBillRoomInfoS.get(0)));
    this.roomPrice.setText("预设单价:" + "¥" + SomeInfo.getRoomPriceString(openBillRoomInfoS.get(0).getRoomTypeId()));
  }

  String getAvailableRoomCode()
  {
    List<RoomInfo> list = RightPanel.getInstance().getRoomInfoList();
    for (int i = 0; i < list.size(); i++)
    {
      if(list.get(i).getRoomState().equals("可供"))
      {
        openBillRoomInfoS.add(list.get(i));
      }
    }

    return openBillRoomInfoS == null?"":openBillRoomInfoS.get(0).getId();
  }

  void updateJLists()
  {
   RList.addElement(openBillRoomInfoS.get(0).getId());
    for(int i = 1; i < openBillRoomInfoS.size();i++)
    {
      LList.addElement(openBillRoomInfoS.get(i).getId());
    }
    billRoomList.setModel(RList);
    emptyRoomList.setModel(LList);
  }

  void addRoomFc()
  {
    if(!LList.isEmpty()) {
      RList.addElement(LList.get(0));
      LList.remove(0);
    }
  }
  void deleteRoomFc()
  {
    if(RList.size() > 1) {
      LList.add(0,RList.get(RList.size() - 1));
      RList.remove(RList.size() - 1);
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
            openBillRoomInfoS.get(0).getRoomTypeId(),
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
