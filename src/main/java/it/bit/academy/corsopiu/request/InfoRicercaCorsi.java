package it.bit.academy.corsopiu.request;

import java.util.Collection;

public class InfoRicercaCorsi {

    Collection<String> keywords;
    boolean hasPrice;
    Collection<String> categories;
    boolean cert;
    int minDur;
    int maxDur;

    public InfoRicercaCorsi(){

    }
    public InfoRicercaCorsi(
            Collection<String> keywords,
            boolean hasPrice,
            Collection<String> categories,
            boolean cert,
            int minDur,
            int maxDur) {

        this.keywords = keywords;
        this.hasPrice = hasPrice;
        this.categories = categories;
        this.cert = cert;
        this.minDur = minDur;
        this.maxDur = maxDur;
    }

    public Collection<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Collection<String> keywords) {
        this.keywords = keywords;
    }

    public boolean getHasPrice() {
        return hasPrice;
    }

    public void setHasPrice(boolean hasPrice) {
        this.hasPrice = hasPrice;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    public void setCategories(Collection<String> categories) {
        this.categories = categories;
    }

    public boolean isCert() {
        return cert;
    }

    public void setCert(boolean cert) {
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
