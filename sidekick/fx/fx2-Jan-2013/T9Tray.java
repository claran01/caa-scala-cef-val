package appfx01;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.application.Platform;

import javax.swing.Timer;

public class T9Tray 
{
//    final 
    Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("tray-icon.png"));
    TrayIcon trayIcon;

    public T9Tray()
    {

        if (!SystemTray.isSupported()) 
        {
            System.err.println("System tray is not supported.");
            return;
        }

        SystemTray tray = SystemTray.getSystemTray();
        

        PopupMenu popup = new PopupMenu();
            trayIcon = new TrayIcon(image, "To begin at the beginning...", popup);
        
            MenuItem test01Item = new MenuItem("Test 1");
            test01Item.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                System.out.println("Test 1 - T9Tray -  Hello, World!");
                trayIcon.displayMessage("Pop up caption title", "Hello, World!", TrayIcon.MessageType.INFO);
              }
            });
            popup.add(test01Item);
            
            MenuItem exitItem = new MenuItem("Exit");
            exitItem.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
              
//x                    SwingUtilities.invokeLater(new Runnable() {
                    Platform.runLater(new Runnable() {
                        public void run() {
//x                     	Platform.exit();

                        System.out.println("T9Tray: Exit, System.exit(0)");
                    	System.exit(0);
                        }
                    });
              }
            });
            popup.add(exitItem);

        
            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                trayIcon.displayMessage("How do stop?",
                    "Right-click on the tray icon and select Exit.", TrayIcon.MessageType.INFO);
              }
            });

            try {
              tray.add(trayIcon);
            } catch (AWTException e) {
              System.err.println("TrayIcon could not be added.");
              return;
            }

    //x         Timer timer = new Timer(10000, new ActionListener() {
    //x           public void actionPerformed(ActionEvent e) {
    //x             trayIcon.displayMessage("Pop up caption title", "Hello, World!", TrayIcon.MessageType.INFO);
    //x           }
    //x         });
    //x         timer.start();
      }
  
//    public static void main(String[] args) 
//    {
//        new T9Tray();
//    }
}
