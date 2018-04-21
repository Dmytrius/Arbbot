package main.java.com.app.domain;

import java.math.BigDecimal;

public abstract class AbstractPair {

    protected String name;
    protected String rialto;
    protected BigDecimal course;
    protected BigDecimal buyCource;
    protected BigDecimal sellCource;

    public AbstractPair(String name, String rialto){
        this.name = name;
        this.rialto = rialto;
    }

    public String getName(){
        return name;
    }

    public String getRialto(){
        return rialto;
    }

    public BigDecimal getCourse() {
        return course;
    }

    public BigDecimal getBuyCource() {
        return buyCource;
    }

    public BigDecimal getSellCource() {
        return sellCource;
    }

    public abstract void setCourse(BigDecimal course);

    public abstract void setBuyCource(BigDecimal buyCource);

    public abstract void setSellCource(BigDecimal sellCource);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPair)) return false;

        AbstractPair that = (AbstractPair) o;

        if (!getName().equals(that.getName())) return false;
        if (!getRialto().equals(that.getRialto())) return false;
        if (getCourse() != null ? !getCourse().equals(that.getCourse()) : that.getCourse() != null) return false;
        if (!getBuyCource().equals(that.getBuyCource())) return false;
        return getSellCource().equals(that.getSellCource());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getRialto().hashCode();
        result = 31 * result + (getCourse() != null ? getCourse().hashCode() : 0);
        result = 31 * result + getBuyCource().hashCode();
        result = 31 * result + getSellCource().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AbstractPair{" +
                "name='" + name + '\'' +
                ", rialto='" + rialto + '\'' +
                ", course=" + course +
                ", buyCource=" + buyCource +
                ", sellCource=" + sellCource +
                '}';
    }
}

