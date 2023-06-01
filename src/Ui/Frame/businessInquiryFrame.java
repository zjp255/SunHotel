package Ui.Frame;

import DAO.entity.LiveIn;
import DAO.entityDao.LiveInDao;
import Ui.panel.TopButtonPanel;
import tool.SomeInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class businessInquiryFrame extends JFrame implements ActionListener {

    JRadioButton useTimeBut,useRoomCodeBut;
    JButton selectBut,refreshBut;
    JTextField startTime,endTime,roomCode;
    JTable amountList;
    ButtonGroup buttonGroup;
    TopButtonPanel owner;
    Font font;
    DefaultTableModel tableModel;
    public  businessInquiryFrame(TopButtonPanel owner)
    {
        this.owner = owner;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                owner.setBusinessInquiryFrame(null);
            }});

        setTitle("营业查询");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Source/营业执照.png"));
        setSize(595,650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        font = new Font("微软雅黑",Font.PLAIN,20);

        //-----------------------------------------------------------------------------

        JLabel topLabel = new JLabel("在店宾客查询");
        topLabel.setFont(font);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setBounds(0,5,590,30);
        topLabel.setOpaque(true);
        topLabel.setBackground(new Color(255, 255, 255));
        add(topLabel);

        //-----------------------------------------------------------------------------

        useTimeBut = new JRadioButton("入住时间");
        useRoomCodeBut = new JRadioButton("房间号");
        useTimeBut.setBounds(10,40,100,30);
        useRoomCodeBut.setBounds(10,80,80,30);
        add(useRoomCodeBut);
        add(useTimeBut);

        createJLabel("起始时间",120,40,50,30);
        createJLabel("终止时间",350,40,50,30);

        startTime = new JTextField();
        startTime.setBounds(180,40,150,30);
        add(startTime);

        endTime = new JTextField();
        endTime.setBounds(410,40,150,30);
        add(endTime);

        roomCode = new JTextField();
        roomCode.setBounds(100,80,150,30);
        add(roomCode);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(useRoomCodeBut);
        buttonGroup.add(useTimeBut);

        selectBut = new JButton("查询");
        selectBut.setBounds(300,80,100,30);
        selectBut.setMargin(new Insets(0, 0, 0, 0));
        selectBut.setBorderPainted(false);
        selectBut.setFocusPainted(false);
        selectBut.addActionListener(this);
        add(selectBut);

        refreshBut = new JButton("刷新");
        refreshBut.setBounds(420,80,100,30);
        refreshBut.setMargin(new Insets(0, 0, 0, 0));
        refreshBut.setBorderPainted(false);
        refreshBut.setFocusPainted(false);
        refreshBut.addActionListener(this);
        add(refreshBut);


        //-----------------------------------------------------------------------------

        amountList = new JTable(new Object[][]{},new String[]{"房间号","房间类型","单价","折扣","折后单价","优惠金额","入住时间"});
        //amountList.setBounds(0,180,580,380);
        amountList.setRowSelectionAllowed(true);
        amountList.setRowHeight(25);
        amountList.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane = new JScrollPane(amountList);
        jScrollPane.setBounds(0,150,580,420);
        //jScrollPane.add(amountList);
        add(jScrollPane);

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

    void updateTable()
    {
        LiveInDao liveInDao = new LiveInDao();
        List<LiveIn> list = liveInDao.getRows();
        tableModel = new DefaultTableModel(new Object[][]{},new String[]{"房间号","房间类型","单价","折扣","折后单价","入住时间"});
        Object[] objects;
        for(int i = 0; i < list.size();i++)
        {
            objects =new Object[]{
                    list.get(i).getR_no(),
                    SomeInfo.getRoomTypeString(list.get(i).getR_type_id()),
                    SomeInfo.getRoomPriceString(list.get(i).getR_type_id()),
                    SomeInfo.getCustomerDiscount(list.get(i).getC_type_id(),list.get(i).getR_type_id()),
                    SomeInfo.getCustomerDiscountPrice(list.get(i).getC_type_id(),list.get(i).getR_type_id()),
                    list.get(i).getIn_time()};
            tableModel.addRow(objects);
        }
        amountList.setModel(tableModel);
    }

    void updateTableUseTime()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse(startTime.getText());
            Date date2 = format.parse(endTime.getText());

            LiveInDao liveInDao = new LiveInDao();
            List<LiveIn> list = liveInDao.getRows();
            tableModel = new DefaultTableModel(new Object[][]{},new String[]{"房间号","房间类型","单价","折扣","折后单价","入住时间"});
            Object[] objects;
            for(int i = 0; i < list.size();i++)
            {
                Date date = format.parse(list.get(i).getIn_time());
                int result1 = date1.compareTo(date);
                int result2 = date2.compareTo(date);

                if(result1 <= 0 && result2 >= 0) {
                    objects = new Object[]{
                            list.get(i).getR_no(),
                            SomeInfo.getRoomTypeString(list.get(i).getR_type_id()),
                            SomeInfo.getRoomPriceString(list.get(i).getR_type_id()),
                            SomeInfo.getCustomerDiscount(list.get(i).getC_type_id(), list.get(i).getR_type_id()),
                            SomeInfo.getCustomerDiscountPrice(list.get(i).getC_type_id(), list.get(i).getR_type_id()),
                            list.get(i).getIn_time()};
                    tableModel.addRow(objects);
                }
            }
            amountList.setModel(tableModel);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }



    }

    void updateTableUseRoomID()
    {
        LiveInDao liveInDao = new LiveInDao();
        List<LiveIn> list = liveInDao.getRows();
        tableModel = new DefaultTableModel(new Object[][]{},new String[]{"房间号","房间类型","单价","折扣","折后单价","入住时间"});
        Object[] objects;
        for(int i = 0; i < list.size();i++)
        {
            if(list.get(i).getR_no().equals(roomCode.getText())) {
                objects = new Object[]{
                        list.get(i).getR_no(),
                        SomeInfo.getRoomTypeString(list.get(i).getR_type_id()),
                        SomeInfo.getRoomPriceString(list.get(i).getR_type_id()),
                        SomeInfo.getCustomerDiscount(list.get(i).getC_type_id(), list.get(i).getR_type_id()),
                        SomeInfo.getCustomerDiscountPrice(list.get(i).getC_type_id(), list.get(i).getR_type_id()),
                        list.get(i).getIn_time()};

                tableModel.addRow(objects);
            }
        }
        amountList.setModel(tableModel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == selectBut)
        {
            if(useTimeBut.isSelected())
            {
                updateTableUseTime();
            } else if (useRoomCodeBut.isSelected()) {
                updateTableUseRoomID();
            }
        } else if (e.getSource() == refreshBut) {
            updateTable();
        }
    }
}
