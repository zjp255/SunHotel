package Ui.panel;

import DAO.entity.LiveIn;
import DAO.entityDao.LiveInDao;
import tool.SomeInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class BottomPanel extends JPanel {

    static BottomPanel instance;

    public static BottomPanel getInstance() {
        return instance;
    }
    JTable amountList;
    JScrollPane jScrollPane;
    Object[] columnNames = {"入住单号","主房间号","标准单价","宾客类型","折扣","消费金额","消费时间","记账人"};

    public BottomPanel()
    {
        instance = this;
        setLayout(null);
        amountList = new JTable(new Object[][]{},columnNames);
        amountList.setRowSelectionAllowed(true);
        amountList.setRowHeight(25);
        amountList.getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        amountList.setDefaultRenderer(Object.class,r);

        jScrollPane = new JScrollPane(amountList);
        add(jScrollPane);
        updateTable("LX0001");
    }

    public void update()
    {
        jScrollPane.setBounds(0,0,getWidth(),getHeight());

    }
    public void updateTable(String value)
    {
        LiveInDao liveInDao = new LiveInDao();
        List<LiveIn> list = liveInDao.getRowsWithCol("r_type_id",value);
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{},columnNames);
        Object[] objects;
        for(int i = 0; i < list.size();i++)
        {
          objects =new Object[]{list.get(i).getIn_no(),
                    list.get(i).getMain_room(),
                    SomeInfo.getRoomPriceString(list.get(i).getR_type_id()),
                    SomeInfo.getCustomerType(list.get(i).getC_type_id()),
                    SomeInfo.getCustomerDiscount(list.get(i).getC_type_id(),list.get(i).getR_type_id()),
                    SomeInfo.getRoomPriceString(list.get(i).getR_type_id()) * list.get(i).getDays(),
                    list.get(i).getDays(),
                    list.get(i).getUserid()};
            tableModel.addRow(objects);
        }
        amountList.setModel(tableModel);

    }


}
