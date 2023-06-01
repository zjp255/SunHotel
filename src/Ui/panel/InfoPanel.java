package Ui.panel;

import DAO.entity.Pwd;

import javax.swing.*;

public class InfoPanel extends JPanel {
    JLabel systemInfo,userInfo;
    public InfoPanel(String userId)
    {
        setLayout(null);
        systemInfo = new JLabel("阳光酒店管理系统");
        userInfo = new JLabel("当前操作员:" + userId);
        add(systemInfo);
        add(userInfo);
    }

    public void update()
    {
        systemInfo.setBounds(10,-20,180,getHeight());
        userInfo.setBounds(getWidth()- 180,-20,180,getHeight());
    }
}
