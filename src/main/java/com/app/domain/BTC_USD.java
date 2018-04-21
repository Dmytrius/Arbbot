package main.java.com.app.domain;

import java.math.BigDecimal;

public class BTC_USD extends AbstractPair {

    public BTC_USD(String rialto) {
        super("BTC_USD", rialto);
    }

    @Override
    public void setCourse(BigDecimal course) {
        this.course = course;
    }

    @Override
    public void setBuyCource(BigDecimal buyCource) {
        this.buyCource = buyCource;
    }

    @Override
    public void setSellCource(BigDecimal sellCource) {
        this.sellCource = sellCource;
    }

    @Override
    public String toString() {
        return getName() + ":" + getRialto() + ", buy = " + getBuyCource() + ", sell = " + getSellCource() + "; ";
    }
}

