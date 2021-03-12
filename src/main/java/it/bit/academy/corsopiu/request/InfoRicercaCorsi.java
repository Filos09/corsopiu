package it.bit.academy.corsopiu.request;

import java.util.Collection;

public class InfoRicercaCorsi {

    String titleLike;
    Boolean hasPrice;
    Boolean cert;
    int minDur;
    int maxDur;
    String category;

    public InfoRicercaCorsi(){

    }
    public InfoRicercaCorsi(
            String titleLike,
            Boolean hasPrice,
            Boolean cert,
            int minDur,
            int maxDur,
            String category) {

        this.titleLike = titleLike;
        this.hasPrice = hasPrice;
        this.cert = cert;
        this.minDur = minDur;
        this.maxDur = maxDur;
        this.category = category;
    }


    public String getTitleLike() {
        return titleLike;
    }

    public void setTitleLike(String titleLike) {
        this.titleLike = titleLike;
    }

    public Boolean getHasPrice() {
        return hasPrice;
    }

    public void setHasPrice(Boolean hasPrice) {
        this.hasPrice = hasPrice;
    }

    public Boolean getCert() {
        return cert;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean isCert() {
        return cert;
    }

    public void setCert(Boolean cert) {
        this.cert = cert;
    }

    public int getMinDur() {
        return minDur;
    }

    public void setMinDur(int minDur) {
        this.minDur = minDur;
    }

    public int getMaxDur() {
        return maxDur;
    }

    public void setMaxDur(int maxDur) {
        this.maxDur = maxDur;
    }
}
