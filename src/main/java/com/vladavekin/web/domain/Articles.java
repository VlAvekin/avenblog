package com.vladavekin.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Articles {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String theme;
    private String briefDescriptions;
    private String tetx;

    public Articles() {
    }

    public Articles(String theme, String briefDescriptions, String tetx) {
        this.theme = theme;
        this.briefDescriptions = briefDescriptions;
        this.tetx = tetx;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getBriefDescriptions() {
        return briefDescriptions;
    }

    public void setBriefDescriptions(String briefDescriptions) {
        this.briefDescriptions = briefDescriptions;
    }

    public String getTetx() {
        return tetx;
    }

    public void setTetx(String tetx) {
        this.tetx = tetx;
    }
}