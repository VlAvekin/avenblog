package com.vladavekin.web.domain;

import javax.persistence.*;

@Entity
public class Сomments {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String text;

    private String creationData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Сomments() {
    }

    public Сomments(String text, String creationData, User author) {
        this.text = text;
        this.creationData = creationData;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreationData() {
        return creationData;
    }

    public void setCreationData(String creationData) {
        this.creationData = creationData;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
