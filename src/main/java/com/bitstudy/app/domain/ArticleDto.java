package com.bitstudy.app.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ArticleDto {
    private Integer a_seqno=null;
    private String a_writer;
    private String a_content;
    private String a_title;
    private String a_cate;
    private Date a_time;

    public ArticleDto() {
    }

    public ArticleDto(String a_writer, String a_content, String a_title, String a_cate) {
        this.a_writer = a_writer;
        this.a_content = a_content;
        this.a_title = a_title;
        this.a_cate = a_cate;
    }


    public Integer getA_seqno() {
        return a_seqno;
    }

    public void setA_seqno(Integer a_seqno) {
        this.a_seqno = a_seqno;
    }

    public String getA_writer() {
        return a_writer;
    }

    public void setA_writer(String a_writer) {
        this.a_writer = a_writer;
    }

    public String getA_content() {
        return a_content;
    }

    public void setA_content(String a_content) {
        this.a_content = a_content;
    }

    public String getA_title() {
        return a_title;
    }

    public void setA_title(String a_title) {
        this.a_title = a_title;
    }

    public String getA_cate() {
        return a_cate;
    }

    public void setA_cate(String a_cate) {
        this.a_cate = a_cate;
    }

    public Date getA_time() {
        return a_time;
    }

    public void setA_time(Date a_time) {
        this.a_time = a_time;
    }


    @Override
    public String toString() {
        return "ArticleDto{" +
                "a_seqno=" + a_seqno +
                ", a_writer='" + a_writer + '\'' +
                ", a_content='" + a_content + '\'' +
                ", a_title='" + a_title + '\'' +
                ", a_cate='" + a_cate + '\'' +
                ", a_time=" + a_time +
                '}';
    }
}
