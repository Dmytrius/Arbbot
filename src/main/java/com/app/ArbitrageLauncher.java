package main.java.com.app;

import main.java.com.app.apiconnectors.BITTREX_APISearcher;
import main.java.com.app.domain.Arbitrage;
import main.java.com.app.domain.BTC_USD;
import main.java.com.app.postgresqlcon.PostgreDataManager;

public class ArbitrageLauncher {

    public static void main(String[] args) {
        Arbitrage arbitrage = new Arbitrage();
        PostgreDataManager postgredm = new PostgreDataManager();

        arbitrage.setDBManager(postgredm);
        arbitrage.doBTC_USDTicker(postgredm);

    }

}

