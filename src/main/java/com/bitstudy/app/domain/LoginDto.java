package com.bitstudy.app.domain;

public class LoginDto {
    private String u_id;
    private String u_pw;
    private boolean auto;

    public LoginDto() {
    }

    public LoginDto(String u_id, String u_pw, boolean auto) {
        this.u_id = u_id;
        this.u_pw = u_pw;
        this.auto = auto;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pw() {
        return u_pw;
    }

    public void setU_pw(String u_pw) {
        this.u_pw = u_pw;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "u_id='" + u_id + '\'' +
                ", u_pw='" + u_pw + '\'' +
                ", auto=" + auto +
                '}';
    }
}
