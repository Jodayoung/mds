package com.bitstudy.app.domain;

public class CateDto {
    private Integer c_seqno=null;
    private String c_writer;
    private String c_content;


    public CateDto() {
    }

    public CateDto(String c_writer, String c_content) {
        this.c_writer = c_writer;
        this.c_content = c_content;
    }

    public Integer getC_seqno() {
        return c_seqno;
    }

    public void setC_seqno(Integer c_seqno) {
        this.c_seqno = c_seqno;
    }

    public String getC_writer() {
        return c_writer;
    }

    public void setC_writer(String c_writer) {
        this.c_writer = c_writer;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }


    @Override
    public String toString() {
        return "CateDto{" +
                "c_seqno=" + c_seqno +
                ", c_writer='" + c_writer + '\'' +
                ", c_content='" + c_content + '\'' +
                '}';
    }
}
