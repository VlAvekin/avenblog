package com.vladavekin.web.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Entity
public class Articles {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the Theme")
    @Length(max = 255, message = "Theme top long (more then 255 chat)")
    private String theme;

    @NotBlank(message = "Please fill the Brief Descriptions")
    @Length(max = 255, message = "Brief Descriptions top long (more then 255 chat)")
    private String briefDescriptions;

    @NotBlank(message = "Please fill the Articles")
    private String text;
    private String photo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String creationData;
    private ArrayList<Long> commentList;

    public Articles() {
    }


    public Articles(@NotBlank(message = "Please fill the Theme")
                    @Length(max = 255, message = "Theme top long (more then 255 chat)")
                            String theme,
                    @NotBlank(message = "Please fill the Brief Descriptions")
                    @Length(max = 255, message = "Brief Descriptions top long (more then 255 chat)")
                            String briefDescriptions,
                    @NotBlank(message = "Please fill the Articles")
                            String text,
                    String photo,
                    User author,
                    String creationData) {
        this.theme = theme;
        this.briefDescriptions = briefDescriptions;
        this.text = text;
        this.photo = photo;
        this.author = author;
        this.creationData = creationData;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getCreationData() {
        return creationData;
    }

    public void setCreationData(String creationData) {
        this.creationData = creationData;
    }

    public ArrayList<Long> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Long> commentList) {
        this.commentList = commentList;
    }
}