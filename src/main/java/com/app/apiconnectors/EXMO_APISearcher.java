package main.java.com.app.apiconnectors;

import main.java.com.app.domain.AbstractPair;
import main.java.com.app.domain.BTC_USD;

import java.math.BigDecimal;

public class EXMO_APISearcher extends AbstractRialtoAPISearcher {

    private String[] methods = new String[]{"trades", "ticker", "order_book", "pair_settings", "currency"}; // 0, 1, 2, 3, 4

    public EXMO_APISearcher(String methodName) {
        //super("https://api.exmo.com/v1/" + urlName + "?pair=BTC_USD");
        super("https://api.exmo.com/v1/" + methodName);
    }

    @Override
    public AbstractPair getBTC_USDPair() {
        pair = new BTC_USD("EXMO");
        String res = priceResponse;
        int index_1 = res.indexOf(",") + 1;
        String buyPrice = res.substring(25, index_1 - 2);
        res = res.substring(index_1, res.length() - 1);
        int index_2 = res.indexOf(",") + 1;
        String sellPrice = res.substring(14, index_2 - 2);
        pair.setBuyCource(new BigDecimal(buyPrice));
        pair.setSellCource(new BigDecimal(sellPrice));
        return pair;
    }


}
