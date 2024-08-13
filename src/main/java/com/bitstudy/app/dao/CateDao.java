package com.bitstudy.app.dao;

import com.bitstudy.app.domain.CateDto;

import java.util.List;

public interface CateDao {
    int insertCate(CateDto cateDto);

    int deleteCateWriter(String c_writer);

    int deleteCateOne(Integer c_seqno);

    int updateCate(CateDto cateDto);

    List<CateDto> selectCate(String c_writer);

    String selectCateOne(int c_seqno);
}
