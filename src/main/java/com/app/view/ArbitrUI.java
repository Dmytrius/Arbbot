package main.java.com.app.view;

import main.java.com.app.domain.Arbitrage;
import main.java.com.app.domain.BTC_USD;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArbitrUI {

    private Arbitrage arbitrage;
    private JFrame frame;
    private JPanel panel;
    private HeadPanel hp;
    private String head = "* CRYPTOCURRENCY - \" CRYPTO\\FIAT ARBITRAGE\" - CRYPTOCURRENCY *";

    public ArbitrUI(Arbitrage arbitrage) {
        this.arbitrage = arbitrage;
        this.hp = new HeadPanel(arbitrage);
        this.frame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame(head);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1360, 725));
        frame.setLocation(0, 0);
        frame.setJMenuBar(createMenuBar());
        panel = hp.getHP();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar(){
        Font bigFont = new Font("Colibry", Font.BOLD, 24);
        Font font = new Font("Colibry", Font.BOLD, 21);
        Font fant = new Font("Colibry", Font.BOLD, 18);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("MENU");
        fileMenu.setBorder(new BevelBorder(0, Color.BLACK, Color.GRAY));
        fileMenu.setFont(bigFont);
        menuBar.add(fileMenu);

        JMenuItem exitItem = new JMenuItem("EXIT");
        exitItem.setBorder(new BevelBorder(0, Color.RED, Color.red));
        exitItem.setFont(font);
        fileMenu.add(exitItem);

        /*
            some set of menu items should be here
        */

        exitItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                arbitrage.getIdbI().clear_btc_usd_EXMOList();
                arbitrage.getIdbI().clear_btc_usd_BITTREXList();
                System.exit(0);
            }
        });

        return menuBar;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public HeadPanel getHP() {
        return hp;
    }

    public JTextField getEXMO_BTC_USD_buyField(){
        return getHP().getExmo_btc_usd_buyField();
    }

    public JTextField getBITTREX_BTC_USD_buyField(){
        return getHP().getBittrex_btc_usd_buyField();
    }

    public JTextField getEXMO_BTC_USD_sellField(){
        return getHP().getExmo_btc_usd_sellField();
    }

    public JTextField getBITTREX_BTC_USD_sellField(){
        return getHP().getBittrex_btc_usd_sellField();
    }

    public void viewEXMOCourse(BTC_USD btc_usd) {
        String newBuyText = getBuyCourse(btc_usd);
        getEXMO_BTC_USD_buyField().setText(newBuyText);
        String newSellText = getSellCourse(btc_usd);
        getEXMO_BTC_USD_sellField().setText(newSellText);
    }

    public void viewBITTREXCourse(BTC_USD btc_usd) {
        String newBuyText = getBuyCourse(btc_usd);
        getBITTREX_BTC_USD_buyField().setText(newBuyText);
        String newSellText = getSellCourse(btc_usd);
        getBITTREX_BTC_USD_sellField().setText(newSellText);
    }

    public String getBuyCourse(BTC_USD btc_usd) {
        return btc_usd.getBuyCource().toString();
    }

    public String getSellCourse(BTC_USD btc_usd) {
        return btc_usd.getSellCource().toString();
    }

}