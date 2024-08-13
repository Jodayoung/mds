package com.bitstudy.app.service;

import com.bitstudy.app.dao.ArticleDao;
import com.bitstudy.app.domain.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {
    @Autowired
    ArticleDao articleDao;
    public int insertArticle(ArticleDto articleDto){
        return articleDao.insertArticle(articleDto);
    }

    public int deleteArticleAll(){
        return articleDao.deleteArticleAll();
    }

    public int deleteArticleWriter(String a_writer){
        return articleDao.deleteArticleWriter(a_writer);
    }

    public int deleteArticleOne(Integer a_seqno,String a_writer){
        Map map = new HashMap<>();
        map.put("a_seqno",a_seqno);
        map.put("a_writer",a_writer);
        return articleDao.deleteArticleOne(map);
    }
    public int updateArticle(ArticleDto articleDto){
        return articleDao.updateArticle(articleDto);
    }

    public List<ArticleDto> selectArticle(String a_writer,Integer page){
        page = (page-1)*10;
        Map map = new HashMap();
        map.put("a_writer",a_writer);
        map.put("page",page);
        return articleDao.selectArticle(map);
    }
    public List<ArticleDto> selectArticleCate(String a_cate,String a_writer,Integer page){
        page = (page-1)*10;
        Map map = new HashMap();
        map.put("a_cate",a_cate);
        map.put("a_writer",a_writer);
        map.put("page",page);
        return articleDao.selectArticleCate(map);
    }

    public ArticleDto selectArticleOne(Integer a_seqno){
        return articleDao.selectArticleOne(a_seqno);
    }


    public Integer selectTotalCount (String a_writer){
        return articleDao.selectTotalCount(a_writer);
    }

    public Integer selectCateCount (String a_cate,String a_writer){
        Map map = new HashMap();
        map.put("a_cate",a_cate);
        map.put("a_writer",a_writer);
        return articleDao.selectCateCount(map);
    }

    public int deleteArticleCate(String a_writer,String a_cate){
        Map map = new HashMap();
        map.put("a_cate",a_cate);
        map.put("a_writer",a_writer);
        return articleDao.deleteArticleCate(map);
    }

}
