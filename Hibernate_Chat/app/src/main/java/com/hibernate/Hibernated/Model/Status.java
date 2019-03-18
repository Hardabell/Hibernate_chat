package com.hibernate.Hibernated.Model;

import java.util.Date;

public class Status {
    private String id;
    private String username;
    private Date timestamp;
    private String imageURL;
    private String status;

    public Status(String id, String username, Date timestamp, String imageURL, String status) {
        this.id = id;
        this.username = username;
        this.timestamp = timestamp;
        this.imageURL = imageURL;
        this.status = status;
    }

    public Status() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
