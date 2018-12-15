package com.vladavekin.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Files {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String fileId;
    private String filename;

    public Files() {
    }

    public Files(String filename) {
        this.filename = filename;
    }

    public Files(String fileId, String filename) {
        this.fileId = fileId;
        this.filename = filename;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
