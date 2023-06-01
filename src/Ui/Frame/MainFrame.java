package Ui.Frame;

import DAO.entity.Pwd;
import Ui.myImage;
import Ui.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MainFrame extends JFrame implements ComponentListener {
    int width,height;
    TopButtonPanel topButtonPanel;
    public static leftPanel leftPanel;
    RightPanel rightPanel;
    BottomPanel bottomPanel;
    InfoPanel infoPanel;
    Pwd userInfo;
    static MainFrame instance;

    public static MainFrame getInstance() {
        return instance;
    }

    public  Pwd getPwd()
    {
        return userInfo;
    }

    public MainFrame(Pwd pwd)
    {
        instance = this;
        userInfo = pwd;
        setTitle("酒店管理系统");

        setMinimumSize(new Dimension(1136,700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(myImage.ImageMainFrameIcon());
        setLayout(null);
        topButtonPanel = new TopButtonPanel();
        leftPanel = new leftPanel();
        rightPanel = new RightPanel();
        bottomPanel = new BottomPanel();
        infoPanel = new InfoPanel(userInfo.getUserid());

        initFrame();
        //setResizable(false);
        addComponentListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(1024,600);
    }

    void initFrame()
    {
        width = getWidth();
        height = getHeight();

        int p1Height = height * 2 / 16;
        int p2Width = width * 3 / 12;
        int p2Height = height * 10 / 16;
        int p3Height = (int) (height * 2.5 / 16);
        int p4Height = (int) (height * 1.5 / 16);

        topButtonPanel.setBounds(0,0,width,p1Height);


        leftPanel.setBounds(0,p1Height,p2Width,p2Height);


        rightPanel.setBounds(p2Width,p1Height,width - p2Width,p2Height);

        bottomPanel.setBounds(0,p1Height + p2Height,width,p3Height);
        infoPanel.setBounds(0,p1Height + p2Height + p3Height,width,p4Height);

        add(bottomPanel);
        add(rightPanel);
        add(leftPanel);
        add(topButtonPanel);
        add(infoPanel);

    }

    void updateFrame()
    {
        width = getWidth();
        height = getHeight();

        int p1Height = height * 2 / 16;
        int p2Width = width * 3 / 12;
        int p2Height = height * 10 / 16;
        int p3Height = (int) (height * 2.5 / 16);
        int p4Height = (int) (height * 1.5 / 16);

        topButtonPanel.setBounds(0,0,width,p1Height);

        leftPanel.setBounds(0,p1Height,p2Width,p2Height);

        rightPanel.setBounds(p2Width,p1Height,width - p2Width,p2Height);

        bottomPanel.setBounds(0,p1Height + p2Height,width,p3Height);

        infoPanel.setBounds(0,p1Height + p2Height + p3Height,width,p4Height);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        updateFrame();
        topButtonPanel.updateButs();
        leftPanel.update();

        bottomPanel.update();
        infoPanel.update();
        rightPanel.update();
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
