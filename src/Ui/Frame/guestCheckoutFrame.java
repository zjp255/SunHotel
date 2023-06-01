package Ui.Frame;

import DAO.entity.CheckOut;
import DAO.entity.LiveIn;
import DAO.entityDao.CheckOutDao;
import DAO.entityDao.LiveInDao;
import DAO.entityDao.RoomInfoDao;
import Ui.MyDialog;
import Ui.panel.BottomPanel;
import Ui.panel.RightPanel;
import Ui.panel.TopButtonPanel;
import tool.SomeInfo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class guestCheckoutFrame extends JFrame implements ListSelectionListener , ActionListener {
    JLabel billCode;
    JLabel checkoutRoom;
    JLabel guestName;
    JLabel consumptionAmount;//消费金额
    JLabel receivableAmount;//应收金额
    JLabel receivedDeposit;//已收押金
    JLabel discountAmount;//优惠金额
    JTextField actualAmount;//实际金额
    JTextField guestPay;//宾客支付
    JLabel giveChange;//找零
    JTextField otherInfo;//备注
    JTable amountList;//消费清单
    JButton confirm,cancel;
    Font font;
    DefaultTableModel tableModel;
    TopButtonPanel owner;
    CheckOut checkOut;
    String selectRoomID;
    public guestCheckoutFrame(TopButtonPanel owner)
    {
        this.owner = owner;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                owner.setGuestCheckoutFrame(null);
            }});

        setTitle("客户结账");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Source/结账.png"));
        setSize(595,650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        font = new Font("微软雅黑",Font.PLAIN,20);
        JLabel topLabel = new JLabel("客户结账");
        topLabel.setFont(font);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setBounds(0,5,590,30);
        topLabel.setOpaque(true);
        topLabel.setBackground(new Color(255, 255, 255));
        add(topLabel);

        //-----------------------------------------------------------------------------


       billCode = createJLabelOfCenter(billCode,"结账单号:",10,40,190,25);
       checkoutRoom = createJLabelOfCenter(checkoutRoom,"结账房间:",200,40,190,25);
       guestName = createJLabelOfCenter(guestName,"宾客姓名:",390,40,190,25);

        //-----------------------------------------------------------------------------
        createJLabel("消费金额:",18,70,53,30);

        consumptionAmount = new JLabel("10");
        consumptionAmount.setBounds(73,70,40,30);
        add(consumptionAmount);


        createJLabel("应收金额:",140,70,53,30);

        receivableAmount = new JLabel("¥100.0");
        receivableAmount.setBounds(195,70,53,30);
        add(receivableAmount);

        createJLabel("已收押金:",270,70,53,30);

        receivedDeposit = new JLabel("1");
        receivedDeposit.setBounds(325,70,60,30);
        add(receivedDeposit);

        createJLabel("优惠金额:",420,70,53,30);

        discountAmount = new JLabel("¥0.00");
        discountAmount.setBounds(480,70,80,30);
        add(discountAmount);


        //-----------------------------------------------------------------------------

        createJLabel("实收金额:",18,110,53,30);

        actualAmount = new JTextField();
        actualAmount.setBounds(73,110,80,25);
        add(actualAmount);

        createJLabel("宾客支付:",182,110,53,30);

        guestPay = new JTextField();
        guestPay.setBounds(239,110,160,25);
        add(guestPay);



        //-----------------------------------------------------------------------------

        createJLabel("备注信息:",18,150,53,30);

        otherInfo = new JTextField();
        otherInfo.setBounds(73,150,490,25);
        add(otherInfo);

        //-----------------------------------------------------------------------------

        amountList = new JTable();
        amountList.getSelectionModel().addListSelectionListener(this);
        //tableModel = new DefaultTableModel(new Object[][]{},new String[]{"房间号","单价","折扣","折扣价","消费天数","消费金额","入住时间"});
        //amountList.setModel(tableModel);
        //amountList.setBounds(0,180,580,380);
        amountList.setRowSelectionAllowed(true);
        amountList.setRowHeight(25);
        amountList.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane = new JScrollPane(amountList);
        jScrollPane.setBounds(0,180,580,380);
        //jScrollPane.add(amountList);
        add(jScrollPane);

        //-----------------------------------------------------------------------------

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
        updateTable();
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


    void updateTable()
    {
        LiveInDao liveInDao = new LiveInDao();
        List<LiveIn> list = liveInDao.getRows();
        tableModel = new DefaultTableModel(new Object[][]{},new String[]{"房间号","单价","折扣","折扣价","消费天数","消费金额","入住时间"});
        Object[] objects;
        for(int i = 0; i < list.size();i++)
        {
            objects =new Object[]{
                    list.get(i).getR_no(),
                    SomeInfo.getRoomPriceString(list.get(i).getR_type_id()),
                    SomeInfo.getCustomerDiscount(list.get(i).getC_type_id(),list.get(i).getR_type_id()),
                    SomeInfo.getCustomerDiscountPrice(list.get(i).getC_type_id(),list.get(i).getR_type_id()),
                    list.get(i).getDays(),
                    SomeInfo.getCustomerDiscountPrice(list.get(i).getC_type_id(),list.get(i).getR_type_id()) *list.get(i).getDays(),
                    list.get(i).getIn_time()};
            tableModel.addRow(objects);
        }
        amountList.setModel(tableModel);
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = amountList.getSelectedRow();
            if (selectedRow != -1) {
                LiveInDao liveInDao = new LiveInDao();
                List<LiveIn> list = liveInDao.getRows();
                billCode.setText("结账单号:" + list.get(selectedRow).getIn_no());
                checkoutRoom.setText("结账房间:" + list.get(selectedRow).getR_no());
                guestName.setText("宾客姓名:" + list.get(selectedRow).getC_name());
                consumptionAmount.setText("" + SomeInfo.getRoomPriceString(list.get(selectedRow).getR_type_id()) * list.get(selectedRow).getDays());
                receivableAmount.setText("" +(double)amountList.getValueAt(selectedRow,5));
                receivedDeposit.setText("" + list.get(selectedRow).getForeGift());
                discountAmount.setText("￥" + (double)amountList.getValueAt(selectedRow,5) * ((10 -(int)amountList.getValueAt(selectedRow,2))/(int)amountList.getValueAt(selectedRow,2)));

                selectRoomID = list.get(selectedRow).getR_no();

                checkOut = new CheckOut(
                        SomeInfo.getCheckoutPk(),
                        SomeInfo.GenerateInNoYD(),
                        list.get(selectedRow).getIn_no(),
                        list.get(selectedRow).getDays(),
                        (double)amountList.getValueAt(selectedRow,5),
                        SomeInfo.getTimeInfo(),
                        otherInfo.getText(),
                        0,
                        null,
                        null
                        );
            }
        }
    }


    void confirmFc()
    {
        CheckOutDao checkOutDao = new CheckOutDao();
        checkOutDao.addRow(checkOut);

        LiveInDao liveInDao = new LiveInDao();
        List<LiveIn> list = liveInDao.getRowsWithCol("in_no",checkOut.getInNo());

        for(int i = 0; i < list.size();i++)
        {
            if(list.get(i).getR_no().equals(selectRoomID))
            {
                liveInDao.deleteRow(list.get(i).getPk());
                break;
            }
        }

        RoomInfoDao roomInfoDao = new RoomInfoDao();
        roomInfoDao.updateRowRoomStatusKG(selectRoomID);


        RightPanel.getInstance().updateJPanels();
        BottomPanel.getInstance().updateTable(RightPanel.getInstance().getNowRoomType());
    }
    void cancelFc()
    {
        owner.setGuestCheckoutFrame(null);
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            confirmFc();
            new MyDialog(MainFrame.getInstance(), "结账成功");
            cancelFc();
        } else if (e.getSource() == cancel) {
            cancelFc();
        }
    }
}
