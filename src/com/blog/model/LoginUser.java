package com.blog.model;

/**
 * Created by LiHang on 2017/8/7.
 */
public class LoginUser {

    private String name;
    private String password;


    public LoginUser(String name, String password) {
        this.password = password;
        this.name = name;
    }

    public LoginUser() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginUser loginUser = (LoginUser) o;

        if (!name.equals(loginUser.name)) return false;
        return password.equals(loginUser.password);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
