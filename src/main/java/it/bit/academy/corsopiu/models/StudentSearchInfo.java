package it.bit.academy.corsopiu.models;

public class StudentSearchInfo {

    private String nameLike;
    private String surnameLike;
    private String emailLike;
    private int limit;



    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNameLike() {
        return nameLike;
    }

    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }

    public String getSurnameLike() {
        return surnameLike;
    }

    public void setSurnameLike(String surnameLike) {
        this.surnameLike = surnameLike;
    }

    public String getEmailLike() {
        return emailLike;
    }

    public void setEmailLike(String emailLike) {
        this.emailLike = emailLike;
    }
}
