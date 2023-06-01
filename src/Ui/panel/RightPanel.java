package Ui.panel;

import DAO.entity.RoomInfo;
import DAO.entityDao.RoomInfoDao;
import Ui.RoomBut;
import tool.SomeInfo;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RightPanel extends JPanel implements ActionListener {
    JScrollPane standardSingleRoomSPanel;//标准单人间
    JScrollPane standardDoubleRoomSPanel;//标准双人间
    JScrollPane deluxeSingleRoomSPanel;//豪华单人间
    JScrollPane deluxeDoubleRoomSPanel;//豪华双人间
    JScrollPane businessSuiteRoomSPanel;//商务套房
    JScrollPane presidentialSuiteSPanel;//总统套房

    JPanel standardSingleRoomPanel;//标准单人间
    JPanel standardDoubleRoomPanel;//标准双人间
    JPanel deluxeSingleRoomPanel;//豪华单人间
    JPanel deluxeDoubleRoomPanel;//豪华双人间
    JPanel businessSuiteRoomPanel;//商务套房
    JPanel presidentialSuitePanel;//总统套房


    CardLayout cardLayout;
    JPanel parentPanel;
    JButton jBut1,jBut2,jBut3,jBut4,jBut5,jBut6;
    List<RoomInfo> roomInfo1,roomInfo2,roomInfo3,roomInfo4,roomInfo5,roomInfo6;
    static RightPanel instance;
    String nowRoomType = "LX0001";

    public String getNowRoomType() {
        return nowRoomType;
    }


    public List<RoomInfo> getRoomInfo1() {
        return roomInfo1;
    }

    public List<RoomInfo> getRoomInfo2() {
        return roomInfo2;
    }

    public List<RoomInfo> getRoomInfo3() {
        return roomInfo3;
    }

    public List<RoomInfo> getRoomInfo4() {
        return roomInfo4;
    }

    public List<RoomInfo> getRoomInfo5() {
        return roomInfo5;
    }

    public List<RoomInfo> getRoomInfo6() {
        return roomInfo6;
    }

    public static RightPanel getInstance() {
        return instance;
    }

   public List<RoomInfo> getRoomInfoList()
    {
        if(nowRoomType.equals("LX0001"))
        {
            return roomInfo1;
        } else if (nowRoomType.equals("LX0002")) {
            return roomInfo2;
        }else if (nowRoomType.equals("LX0003")) {
            return roomInfo3;
        }else if (nowRoomType.equals("LX0004")) {
            return roomInfo4;
        }else if (nowRoomType.equals("LX0005")) {
            return roomInfo5;
        }else if (nowRoomType.equals("LX0006")) {
            return roomInfo6;
        }
        return null;
    }

    public RightPanel()
    {
        roomInfo1 = new ArrayList<>();
        roomInfo2 = new ArrayList<>();
        roomInfo3 = new ArrayList<>();
        roomInfo4 = new ArrayList<>();
        roomInfo5 = new ArrayList<>();
        roomInfo6 = new ArrayList<>();
        instance = this;
        setLayout(null);
        cardLayout = new CardLayout();
        parentPanel = new JPanel();
        parentPanel.setLayout(cardLayout);
        add(parentPanel);

        standardSingleRoomPanel = new JPanel();
        standardDoubleRoomPanel = new JPanel();
        deluxeSingleRoomPanel = new JPanel();
        deluxeDoubleRoomPanel = new JPanel();
        businessSuiteRoomPanel = new JPanel();
        presidentialSuitePanel = new JPanel();

        standardSingleRoomSPanel = initJPanel(standardSingleRoomSPanel,"标准单人间",standardSingleRoomPanel);
        standardDoubleRoomSPanel = initJPanel(standardDoubleRoomSPanel,"标准双人间",standardDoubleRoomPanel);
        deluxeSingleRoomSPanel = initJPanel(deluxeSingleRoomSPanel,"豪华单人间",deluxeSingleRoomPanel);
        deluxeDoubleRoomSPanel = initJPanel(deluxeDoubleRoomSPanel,"豪华双人间",deluxeDoubleRoomPanel);
        businessSuiteRoomSPanel = initJPanel(businessSuiteRoomSPanel,"商务套房",businessSuiteRoomPanel);
        presidentialSuiteSPanel = initJPanel(presidentialSuiteSPanel,"总统套房",presidentialSuitePanel);
        jBut1 = initChangePageBut(jBut1,0,"标准单人间");
        jBut2 = initChangePageBut(jBut2,81,"标准双人间");
        jBut3 = initChangePageBut(jBut3,162,"豪华单人间");
        jBut4 = initChangePageBut(jBut4,243,"豪华双人间");
        jBut5 = initChangePageBut(jBut5,324,"商务套房");
        jBut6 = initChangePageBut(jBut6,405,"总统套房");

        initJPanelS();

    }

    public JButton initChangePageBut(JButton jButton,int y,String text)
    {
        jButton = new JButton(text);
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setBounds(y,0,80,20);
        jButton.setBackground(new Color(133, 123, 123));
        jButton.addActionListener(e -> cardLayout.show(parentPanel, text));
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        jButton.addActionListener(this);
        add(jButton);
        return jButton;
    }
    public void update()
    {
        int width,height;
        width = getWidth() - 15;
        height = getHeight()-20;
        Dimension dimension = new Dimension(width,height);
        standardSingleRoomSPanel.setPreferredSize(dimension);
        standardDoubleRoomSPanel.setPreferredSize(dimension);
        deluxeSingleRoomSPanel.setPreferredSize(dimension);
        deluxeDoubleRoomSPanel.setPreferredSize(dimension);
        businessSuiteRoomSPanel.setPreferredSize(dimension);
        presidentialSuiteSPanel.setPreferredSize(dimension);

        //dimension.setSize(width - 20, height);
        standardSingleRoomPanel.setPreferredSize(dimension);
        standardDoubleRoomPanel.setPreferredSize(dimension);
        deluxeSingleRoomPanel.setPreferredSize(dimension);
        deluxeDoubleRoomPanel.setPreferredSize(dimension);
        businessSuiteRoomPanel.setPreferredSize(dimension);
        presidentialSuitePanel.setPreferredSize(dimension);
        parentPanel.setBounds(0,20,width,height);
        standardSingleRoomPanel.setBounds(0,20,width,height);
        standardDoubleRoomPanel.setBounds(0,20,width,height);
        deluxeSingleRoomPanel.setBounds(0,20,width,height);
        deluxeDoubleRoomPanel.setBounds(0,20,width,height);
        businessSuiteRoomPanel.setBounds(0,20,width,height);
        presidentialSuitePanel.setBounds(0,20,width,height);
        //initJPanelS();
    }
    private JScrollPane initJPanel(JScrollPane jSPanel,String panelName,JPanel jPanel)
    {
        jSPanel = new JScrollPane();
        jSPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //jPanel.setBackground(new Color(232, 220, 220));

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(12);
        flowLayout.setVgap(15);
        jPanel.setLayout(flowLayout);
        jSPanel.setViewportView(jPanel);
        parentPanel.add(jSPanel,panelName);
        return jSPanel;
    }

    public void updateJPanels()
    {
       standardSingleRoomPanel.removeAll();
       standardDoubleRoomPanel.removeAll();
       deluxeSingleRoomPanel.removeAll();
       deluxeDoubleRoomPanel.removeAll();
       businessSuiteRoomPanel.removeAll();
       presidentialSuitePanel.removeAll();
        roomInfo1.clear();
        roomInfo2.clear();
        roomInfo3.clear();
        roomInfo4.clear();
        roomInfo5.clear();
        roomInfo6.clear();
       initJPanelS();

    }
    private void initJPanelS()
    {
        List<RoomInfo> list = new RoomInfoDao().getRows();
        leftPanel.getInstance().stateInfo[0] = list.size();
        for(int i = 0; i < list.size(); i++)
        {
            String roomTypeName = SomeInfo.getRoomTypeString(list.get(i));
            if(roomTypeName.equals("标准单人间"))
            {
               standardSingleRoomPanel = initRoomBut( standardSingleRoomPanel,list.get(i));
               roomInfo1.add(list.get(i));
            }
            else if(roomTypeName.equals("标准双人间"))
            {
               standardDoubleRoomPanel = initRoomBut( standardDoubleRoomPanel,list.get(i));
                roomInfo2.add(list.get(i));
            }
            else if(roomTypeName.equals("豪华单人间"))
            {
               deluxeSingleRoomPanel = initRoomBut( deluxeSingleRoomPanel,list.get(i));
                roomInfo3.add(list.get(i));
            }
            else if(roomTypeName.equals("豪华双人间"))
            {
               deluxeDoubleRoomPanel = initRoomBut( deluxeDoubleRoomPanel,list.get(i));
                roomInfo4.add(list.get(i));
            }
            else if(roomTypeName.equals("商务套房"))
            {
               businessSuiteRoomPanel = initRoomBut( businessSuiteRoomPanel,list.get(i));
                roomInfo5.add(list.get(i));
            }
            else if(roomTypeName.equals("总统套房"))
            {
               presidentialSuitePanel = initRoomBut( presidentialSuitePanel,list.get(i));
                roomInfo6.add(list.get(i));
            }

            String state = list.get(i).getRoomState();
            if (state.equals("占用"))
            {
                leftPanel.getInstance().stateInfo[1]++;
            } else if (state.equals("可供")) {
                leftPanel.getInstance().stateInfo[2]++;
            }else if (state.equals("预订")) {
                leftPanel.getInstance().stateInfo[3]++;
            }else if (state.equals("停用")) {
                leftPanel.getInstance().stateInfo[4]++;
            }
        }
        leftPanel.getInstance().updateAllRoomStatus();
    }

    private JPanel initRoomBut(JPanel jPanel,RoomInfo roomInfo)
    {
        RoomBut roomBut = new RoomBut(roomInfo);

        jPanel.add(roomBut);

        return jPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jBut1)
        {
            BottomPanel.getInstance().updateTable("LX0001");
            nowRoomType = "LX0001";
        } else if (e.getSource() == jBut2) {
            BottomPanel.getInstance().updateTable("LX0002");
            nowRoomType = "LX0002";
        }
        else if (e.getSource() == jBut3) {
            BottomPanel.getInstance().updateTable("LX0003");
            nowRoomType = "LX0003";
        }
        else if (e.getSource() == jBut4) {
            BottomPanel.getInstance().updateTable("LX0004");
            nowRoomType = "LX0004";
        }
        else if (e.getSource() == jBut5) {
            BottomPanel.getInstance().updateTable("LX0005");
            nowRoomType = "LX0005";
        }
        else if (e.getSource() == jBut6) {
            BottomPanel.getInstance().updateTable("LX0006");
            nowRoomType = "LX0006";
        }
    }
}
