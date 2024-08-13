package com.bitstudy.app.service;

import com.bitstudy.app.dao.CateDao;
import com.bitstudy.app.domain.CateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateService {
    @Autowired
    CateDao cateDao;

    public int insertCate(CateDto cateDto){
        return cateDao.insertCate(cateDto);
    }
    public int deleteCateWriter(String c_writer){return cateDao.deleteCateWriter(c_writer);}
    public int deleteCateOne(Integer c_seqno){
        return cateDao.deleteCateOne(c_seqno);
    }

    public int updateCate(CateDto cateDto){
        return cateDao.updateCate(cateDto);
    }

    public List<CateDto> selectCate(String c_writer){
        return cateDao.selectCate(c_writer);
    }

    public String selectCateOne(int c_seqno){
        return cateDao.selectCateOne(c_seqno);
    }



}
