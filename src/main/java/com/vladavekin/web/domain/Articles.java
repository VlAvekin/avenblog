package com.vladavekin.web.domain;

import javax.persistence.*;

@Entity
public class Articles {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String theme;
    private String briefDescriptions;
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;



    public Articles() {
    }


    public Articles(String theme, String briefDescriptions, String text, User author) {
        this.theme = theme;
        this.briefDescriptions = briefDescriptions;
        this.text = text;
        this.author = author;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "none";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}