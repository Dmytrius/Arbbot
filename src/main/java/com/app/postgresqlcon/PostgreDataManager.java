package main.java.com.app.postgresqlcon;

import main.java.com.app.domain.BTC_USD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgreDataManager implements IDBInterface {

    private PostgreSQLConnect psqlcon;
    private List<BTC_USD> btc_usd_EXMOList = new ArrayList<>();
    private List<BTC_USD> btc_usd_BITTREXList = new ArrayList<>();

    public PostgreDataManager(){
        psqlcon = new PostgreSQLConnect();
        this.btc_usd_EXMOList = initEXMO_BTC_USDList();
        this.btc_usd_BITTREXList = initBITTREX_BTC_USDList();
    }

    @Override
    public List<BTC_USD> getBtc_usd_EXMOList() {
        return btc_usd_EXMOList;
    }

    @Override
    public List<BTC_USD> getBtc_usd_BITTREXList() {
        return btc_usd_BITTREXList;
    }

    @Override
    public List<BTC_USD> initEXMO_BTC_USDList(){
        String btc_usd_query = "select * from btc_usd_exmo";
        try {
            Statement statement = psqlcon.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(btc_usd_query);
            while(resultSet.next()){
                BTC_USD sql = new BTC_USD("EXMO");
                sql.setBuyCource(resultSet.getBigDecimal("buy_bu"));
                sql.setSellCource(resultSet.getBigDecimal("sell_bu"));
                btc_usd_EXMOList.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return btc_usd_EXMOList;
    }

    @Override
    public List<BTC_USD> initBITTREX_BTC_USDList(){
        String btc_usd_query = "select * from btc_usd_bittrex";
        try {
            Statement statement = psqlcon.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(btc_usd_query);
            while(resultSet.next()){
                BTC_USD sql = new BTC_USD("EXMO");
                sql.setBuyCource(resultSet.getBigDecimal("buy_bu"));
                sql.setSellCource(resultSet.getBigDecimal("sell_bu"));
                btc_usd_BITTREXList.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return btc_usd_BITTREXList;
    }

    @Override
    public BTC_USD getEXMO_BTC_USDPrevious() {
        return btc_usd_EXMOList.get(btc_usd_EXMOList.size() - 1);
    }

    @Override
    public BTC_USD getBITTREX_BTC_USDPrevious() {
        return btc_usd_BITTREXList.get(btc_usd_BITTREXList.size() - 1);
    }

    @Override
    public List<BTC_USD> update_BTC_USD_EXMOList(BTC_USD bu) {
        btc_usd_EXMOList.add(bu);
        String update = "INSERT INTO btc_usd_exmo(buy_bu, sell_bu) VALUES(?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = psqlcon.getConnection().prepareStatement(update);
            preparedStatement.setBigDecimal(1, bu.getBuyCource());
            preparedStatement.setBigDecimal(2, bu.getSellCource());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return btc_usd_EXMOList;
    }

    @Override
    public List<BTC_USD> update_BTC_USD_BITTREXList(BTC_USD bu) {
        btc_usd_BITTREXList.add(bu);
        String update = "INSERT INTO btc_usd_bittrex(buy_bu, sell_bu) VALUES(?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = psqlcon.getConnection().prepareStatement(update);
            preparedStatement.setBigDecimal(1, bu.getBuyCource());
            preparedStatement.setBigDecimal(2, bu.getSellCource());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return btc_usd_BITTREXList;
    }

    @Override
    public void clear_btc_usd_EXMOList() {
        btc_usd_EXMOList.clear();
        String deleteQuery = "delete from btc_usd_exmo";
        try {
            Statement statement = psqlcon.getConnection().createStatement();
            statement.executeUpdate(deleteQuery);
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    @Override
    public void clear_btc_usd_BITTREXList() {
        btc_usd_BITTREXList.clear();
        String deleteQuery = "delete from btc_usd_bittrex";
        try {
            Statement statement = psqlcon.getConnection().createStatement();
            statement.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}