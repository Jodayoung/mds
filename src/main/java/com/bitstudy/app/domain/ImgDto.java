package com.bitstudy.app.domain;

public class ImgDto {
    private Integer i_seqno=null;
    private Integer fk_a_seqno;
    private String i_link;

    public ImgDto() {
    }

    public ImgDto(Integer fk_a_seqno, String i_link) {
        this.fk_a_seqno = fk_a_seqno;
        this.i_link = i_link;
    }


    public Integer getI_seqno() {
        return i_seqno;
    }

    public void setI_seqno(Integer i_seqno) {
        this.i_seqno = i_seqno;
    }

    public Integer getFk_a_seqno() {
        return fk_a_seqno;
    }

    public void setFk_a_seqno(Integer fk_a_seqno) {
        this.fk_a_seqno = fk_a_seqno;
    }

    public String getI_link() {
        return i_link;
    }

    public void setI_link(String i_link) {
        this.i_link = i_link;
    }

    @Override
    public String toString() {
        return "ImgDto{" +
                "i_seqno=" + i_seqno +
                ", fk_a_seqno=" + fk_a_seqno +
                ", i_link='" + i_link + '\'' +
                '}';
    }
}
