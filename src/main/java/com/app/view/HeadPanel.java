package main.java.com.app.view;

import main.java.com.app.domain.Arbitrage;

import javax.swing.*;
import java.awt.*;

public class HeadPanel {

    private Arbitrage arbitrage;
    private JPanel hP;

    private JTextField exmo_btc_usd_buyField;
    private JTextField exmo_btc_usd_sellField;
    private JTextField bittrex_btc_usd_buyField;
    private JTextField bittrex_btc_usd_sellField;

    public HeadPanel(Arbitrage arbitrage) {
        this.arbitrage = arbitrage;
        this.hP = createHeadPieceUI();
    }

    private JPanel createHeadPieceUI() {

        hP = new JPanel();
        hP.setLayout(new GridBagLayout());
        hP.setBackground(Color.LIGHT_GRAY);

        JLabel btc_usd = new JLabel("BTC_USD");
        btc_usd.setBackground(Color.GRAY);
        btc_usd.setFont(new Font("Colibry", Font.BOLD, 30));
        btc_usd.setForeground(Color.blue);

        JLabel exmo = new JLabel("EXMO");
        exmo.setBackground(Color.GRAY);
        exmo.setFont(new Font("Colibry", Font.BOLD, 30));
        exmo.setForeground(new Color(0, 200, 50));

        JLabel bittrex = new JLabel("BITTREX");
        bittrex.setBackground(Color.GRAY);
        bittrex.setFont(new Font("Colibry", Font.BOLD, 30));
        bittrex.setForeground(new Color(0, 200, 50));

        JLabel btc_usd_buy = new JLabel("buy course, $");
        btc_usd_buy.setBackground(Color.GRAY);
        btc_usd_buy.setFont(new Font("Colibry", Font.BOLD, 25));
        btc_usd_buy.setForeground(Color.blue);

        JLabel btc_usd_sell = new JLabel("sell course, $");
        btc_usd_sell.setBackground(Color.GRAY);
        btc_usd_sell.setFont(new Font("Colibry", Font.BOLD, 25));
        btc_usd_sell.setForeground(Color.blue);

        exmo_btc_usd_buyField = new JTextField();
        exmo_btc_usd_buyField.setColumns(9);
        exmo_btc_usd_buyField.setFont(new Font("Garamond", Font.BOLD, 25));
        exmo_btc_usd_buyField.setForeground(Color.BLACK);
        exmo_btc_usd_buyField.setHorizontalAlignment(JTextField.RIGHT);

        exmo_btc_usd_sellField = new JTextField();
        exmo_btc_usd_sellField.setColumns(9);
        exmo_btc_usd_sellField.setFont(new Font("Garamond", Font.BOLD, 25));
        exmo_btc_usd_sellField.setForeground(Color.BLACK);
        exmo_btc_usd_sellField.setHorizontalAlignment(JTextField.RIGHT);

        bittrex_btc_usd_buyField = new JTextField();
        bittrex_btc_usd_buyField.setColumns(9);
        bittrex_btc_usd_buyField.setFont(new Font("Garamond", Font.BOLD, 25));
        bittrex_btc_usd_buyField.setForeground(Color.BLACK);
        bittrex_btc_usd_buyField.setHorizontalAlignment(JTextField.RIGHT);

        bittrex_btc_usd_sellField = new JTextField();
        bittrex_btc_usd_sellField.setColumns(9);
        bittrex_btc_usd_sellField.setFont(new Font("Garamond", Font.BOLD, 25));
        bittrex_btc_usd_sellField.setForeground(Color.BLACK);
        bittrex_btc_usd_sellField.setHorizontalAlignment(JTextField.RIGHT);

        hP.add(btc_usd, new GridBagConstraints(1, 1, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        hP.add(exmo, new GridBagConstraints(3, 1, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        hP.add(bittrex, new GridBagConstraints(7, 1, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        hP.add(btc_usd_buy, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        hP.add(btc_usd_sell, new GridBagConstraints(2, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        hP.add(exmo_btc_usd_buyField, new GridBagConstraints(3, 2, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        hP.add(bittrex_btc_usd_buyField, new GridBagConstraints(6, 2, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        hP.add(exmo_btc_usd_sellField, new GridBagConstraints(3, 3, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        hP.add(bittrex_btc_usd_sellField, new GridBagConstraints(6, 3, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        return hP;
    }

    public JPanel getHP() {
        return hP;
    }

    public JTextField getExmo_btc_usd_buyField() {
        return exmo_btc_usd_buyField;
    }

    public JTextField getBittrex_btc_usd_buyField() {
        return bittrex_btc_usd_buyField;
    }

    public JTextField getExmo_btc_usd_sellField() {
        return exmo_btc_usd_sellField;
    }

    public JTextField getBittrex_btc_usd_sellField() {
        return bittrex_btc_usd_sellField;
    }


}
