package com.bitstudy.app.dao;


import com.bitstudy.app.domain.CateDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CateDaoimpl implements CateDao {
    @Autowired
    SqlSession session;

    String namespace="com.bitstudy.app.dao.cateMapper.";

    @Override
    public int insertCate(CateDto cateDto){
        return session.insert(namespace+"insertCate",cateDto);
    }

    @Override
    public int deleteCateWriter(String c_writer){
        return session.delete(namespace+"deleteCateWriter",c_writer);
    }
    @Override
    public int deleteCateOne(Integer c_seqno){
        return session.delete(namespace+"deleteCateOne",c_seqno);
    }

    @Override
    public int updateCate(CateDto cateDto){
        return session.update(namespace+"updateCate",cateDto);
    }

    @Override
    public List<CateDto> selectCate(String c_writer){
        return session.selectList(namespace+"selectCate",c_writer);
    }

    @Override
    public String selectCateOne(int c_seqno){
        return session.selectOne(namespace+"selectCateOne",c_seqno);
    }
}
