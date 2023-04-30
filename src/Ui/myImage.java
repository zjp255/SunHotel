package Ui;

import javax.swing.*;
import java.awt.*;

public class myImage {
    public static Image getLoginTitleIcon()
    {
        return Toolkit.getDefaultToolkit().getImage("Source/登录.png");
    }
    public  static ImageIcon getLoginBackgroundImage()
    {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage("Source/hotelImage.jpg"));
    }

    public static Image ImageDialogIcon()
    {
        return Toolkit.getDefaultToolkit().getImage("Source/提示.png");
    }

    public static Image ImageMainFrameIcon()
    {
        return Toolkit.getDefaultToolkit().getImage("Source/酒店.png");
    }
}
