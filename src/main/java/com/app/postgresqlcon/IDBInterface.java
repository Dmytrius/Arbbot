package main.java.com.app.postgresqlcon;

import main.java.com.app.domain.BTC_USD;

import java.util.List;

public interface IDBInterface {

    List<BTC_USD> initEXMO_BTC_USDList();
    List<BTC_USD> initBITTREX_BTC_USDList();

    List<BTC_USD> getBtc_usd_EXMOList();
    List<BTC_USD> getBtc_usd_BITTREXList();

    BTC_USD getEXMO_BTC_USDPrevious();
    BTC_USD getBITTREX_BTC_USDPrevious();
    List<BTC_USD> update_BTC_USD_EXMOList(BTC_USD bu);
    List<BTC_USD> update_BTC_USD_BITTREXList(BTC_USD bu);

    void clear_btc_usd_EXMOList();
    void clear_btc_usd_BITTREXList();

}
