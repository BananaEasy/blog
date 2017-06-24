package com.hang.blog.mvc.entity;

import java.io.Serializable;
import java.util.Date;

public class User  implements Serializable{
    private String id;

    private Date createtime;

    private String email;

    private String username;

    private String userheadimage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserheadimage() {
        return userheadimage;
    }

    public void setUserheadimage(String userheadimage) {
        this.userheadimage = userheadimage == null ? null : userheadimage.trim();
    }
}