package main.java.com.app.apiconnectors;

import main.java.com.app.domain.AbstractPair;
import main.java.com.app.domain.BTC_USD;

import java.math.BigDecimal;

public class BITTREX_APISearcher extends AbstractRialtoAPISearcher {

    public BITTREX_APISearcher(String methodName) {
        super("https://bittrex.com/api/v1.1/public/" + methodName);
    }

    @Override
    public AbstractPair getBTC_USDPair() {
        pair = new BTC_USD("BITTREX");
        String res = priceResponse;
        char ch[] = res.toCharArray();
        int index_0 = getFirstIndex(ch);
        res = res.substring(index_0, res.length() - 1);
        int index_1 = res.indexOf(",");
        String buyPrice = res.substring(0, index_1);
        int index_2 = res.indexOf(":") + 1;
        res = res.substring(index_2, res.length() - 1);
        int index_3 = res.indexOf(",");
        String sellPrice = res.substring(0, index_3);
        pair.setBuyCource(new BigDecimal(buyPrice));
        pair.setSellCource(new BigDecimal(sellPrice));
        return pair;
    }

    private int getFirstIndex(char[] ch) {
        int i = 0;
        for (; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) break;
        }
        return i;
    }

}
