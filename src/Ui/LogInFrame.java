package Ui;

import DAO.entity.Pwd;
import DAO.entityDao.PwdDao;
import DAO.entityUtitls.PwdUtitl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LogInFrame extends JFrame implements ActionListener {
    private  JLabel accountLabel,pwLabel,background,title;
    private JTextField accountField;
    private JPasswordField pwField;
    private JButton loginButton;

    public LogInFrame()
    {
        setTitle("登录");
        setSize(800,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(myImage.getLoginTitleIcon());

        JPanel panel = new JPanel(null);
        background = new JLabel(myImage.getLoginBackgroundImage());
        background.setBounds(320,65,420,280);
        panel.add(background);

        Font font = new Font("微软雅黑",Font.PLAIN,20);

        accountLabel = new JLabel("账号");
        accountLabel.setFont(font);
        accountLabel.setBounds(30,180,40,30);
        panel.add(accountLabel);
        accountField = new JTextField();
        accountField.setBounds(90,180,180,30);
        panel.add(accountField);

        pwLabel = new JLabel("密码");
        pwLabel.setFont(font);
        pwLabel.setBounds(30,225,40,30);
        panel.add(pwLabel);
        pwField = new JPasswordField();
        pwField.setBounds(90,225,180,30);
        panel.add(pwField);

        title = new JLabel("酒店管理系统");
        title.setFont(font);
        title.setBounds(30,130,200,30);
        panel.add(title);

        loginButton = new JButton("登录");
        loginButton.setFont(font);
        loginButton.setBounds(120,280,100,30);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this);
        panel.add(loginButton);




        add(panel);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getSource() == loginButton)
            {
                String account = accountField.getText();
                String password = new String( pwField.getPassword());
                List<Pwd> list = new PwdDao().getRows();
                int i = 0;
                for ( ;i < list.size(); i++) {
                    if(account.equals(list.get(i).getUserid()) && password.equals(list.get(i).getPwd())) {
                        new MyDialog(this, "登陆成功");
                        break;
                    }
                }
                if(i >= list.size())
                {
                    new MyDialog(this,"账号或密码错误");
                }

            }
    }
}
