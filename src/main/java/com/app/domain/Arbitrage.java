package main.java.com.app.domain;

import main.java.com.app.apiconnectors.BITTREX_APISearcher;
import main.java.com.app.apiconnectors.EXMO_APISearcher;
import main.java.com.app.postgresqlcon.IDBInterface;
import main.java.com.app.view.ArbitrUI;

public class Arbitrage {

    private volatile BTC_USD exmo_btc_usd;
    private volatile BTC_USD bittrex_btc_usd;
    private IDBInterface idbI;
    private ArbitrUI aui;

    public Arbitrage(){
        this.aui = new ArbitrUI(this);
    }

    public IDBInterface getIdbI() {
        return idbI;
    }

    public void setDBManager(IDBInterface idbI) {
        this.idbI = idbI;
    }

    public void doBTC_USDTicker(IDBInterface idbI) {
        EXMO_APISearcher exmoSearcher = null;
        BITTREX_APISearcher bittrexSearcher = null;
        boolean notExit = false;
        while(!notExit){

            exmoSearcher = new EXMO_APISearcher("ticker");
            exmo_btc_usd = (BTC_USD) exmoSearcher.getBTC_USDPair();
            bittrexSearcher = new BITTREX_APISearcher("getticker?market=USDT-BTC");
            bittrex_btc_usd = (BTC_USD) bittrexSearcher.getBTC_USDPair();

            aui.viewEXMOCourse(exmo_btc_usd);
            aui.viewBITTREXCourse(bittrex_btc_usd);

            // if previous btc_usd not equal to the current one, the current one would be placed in DB
            if(idbI.getBtc_usd_EXMOList().size() != 0) {
                if(!idbI.getEXMO_BTC_USDPrevious().equals(exmo_btc_usd)) {
                    idbI.update_BTC_USD_EXMOList(exmo_btc_usd);
                }
            } else {
                idbI.update_BTC_USD_EXMOList(exmo_btc_usd);
            }

            if(idbI.getBtc_usd_BITTREXList().size() != 0) {
                if(!idbI.getBITTREX_BTC_USDPrevious().equals(bittrex_btc_usd)) {
                    idbI.update_BTC_USD_BITTREXList(bittrex_btc_usd);
                }
            } else {
                idbI.update_BTC_USD_BITTREXList(bittrex_btc_usd);
            }
            // wait for 10 sec
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
