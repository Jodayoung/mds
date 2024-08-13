package com.bitstudy.app.domain;

public class UserDto {
private Integer u_seqno=null;
private String u_id;
private String u_pw;
private String u_name;
private String u_number;


    public UserDto() {
    }

    public UserDto(String u_id, String u_pw, String u_name, String u_number) {
        this.u_id = u_id;
        this.u_pw = u_pw;
        this.u_name = u_name;
        this.u_number = u_number;
    }

    public Integer getU_seqno() {
        return u_seqno;
    }

    public void setU_seqno() {
        this.u_seqno = u_seqno;
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

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_number() {
        return u_number;
    }

    public void setU_number(String u_number) {
        this.u_number = u_number;
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "u_seqno=" + u_seqno +
                ", u_id='" + u_id + '\'' +
                ", u_pw='" + u_pw + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_number='" + u_number + '\'' +
                '}';
    }
}


