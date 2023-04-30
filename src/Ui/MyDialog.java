package Ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDialog extends JDialog implements ActionListener {
    MyButton myButton;
    public MyDialog(JFrame own,String content)
    {
        super(own);
        setLayout(null);
        setTitle("提示");
        setIconImage(myImage.ImageDialogIcon());


        JLabel jLabel = new JLabel(content);
        Font font = new Font("微软雅黑",Font.PLAIN,18);
        jLabel.setFont(font);
        jLabel.setBounds(0,30,300,50);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(jLabel);

        myButton = new MyButton("确认",this,font,100,100);
        add(myButton);

        setResizable(false);
        setSize(300,180);
        setLocationRelativeTo(own);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == myButton)
            {
                dispose();

            }
    }
}
