package Ui.Frame;

import Ui.panel.TopButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class customerManagementFrame extends JFrame {
    JButton addBut,modifyBut,deleteBut,selectBut,refreshBut;
    JTextField selectInfo;
    JTable amountList;
    Font font;
    TopButtonPanel owner;
    public customerManagementFrame(TopButtonPanel owner)
    {
        this.owner = owner;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                owner.setCustomerManagementFrame(null);
            }});

        setTitle("客户管理");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Source/客户管理.png"));
        setSize(595,650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        font = new Font("微软雅黑",Font.PLAIN,20);

        JLabel topLabel = new JLabel("客户信息");
        topLabel.setFont(font);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setBounds(0,5,590,30);
        topLabel.setOpaque(true);
        topLabel.setBackground(new Color(255, 255, 255));
        add(topLabel);

        //-----------------------------------------------------------------

        initBut(addBut,"增加",0,40);
        initBut(modifyBut,"修改",100,40);
        initBut(deleteBut,"删除",200,40);
        initBut(refreshBut,"刷新",300,40);
        selectInfo = new JTextField();
        selectInfo.setBounds(400,40,80,30);
        add(selectInfo);
        initBut(selectBut,"查询",500,40);

        //------------------------------------------------------------------

        amountList = new JTable(new Object[][]{},new String[]{"客户类型","客户姓名","性别","身份证号","联系电话","详细地址"});
        //amountList.setBounds(0,180,580,380);
        amountList.setRowSelectionAllowed(true);
        amountList.setRowHeight(25);
        amountList.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane = new JScrollPane(amountList);
        jScrollPane.setBounds(0,100,580,500);
        //jScrollPane.add(amountList);
        add(jScrollPane);

        //--------------------------------------------------------------------




        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

    }



    void initBut(JButton jButton,String info,int x, int y)
    {
        jButton = new JButton(info);
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setBounds(x,y,80,30);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        add(jButton);
    }
}
