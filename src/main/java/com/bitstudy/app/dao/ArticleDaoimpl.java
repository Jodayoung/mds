package com.bitstudy.app.dao;

import com.bitstudy.app.domain.ArticleDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ArticleDaoimpl implements ArticleDao {
    @Autowired
    SqlSession session;

    String namespace="com.bitstudy.app.dao.articleMapper.";


    @Override
    public int insertArticle(ArticleDto articleDto){
        return session.insert (namespace+"insertArticle",articleDto);
    }

    @Override
    public int deleteArticleAll(){
        return session.delete(namespace+"deleteArticleAll");
    }

    @Override
    public int deleteArticleWriter(String a_writer){
        return session.delete(namespace+"deleteArticleWriter",a_writer);
    }

    @Override
    public int deleteArticleOne(Map map){
        return session.delete(namespace+"deleteArticleOne",map);
    }

    @Override
    public int updateArticle(ArticleDto articleDto){
        return session.update(namespace+"updateArticle",articleDto);
    }

    @Override
    public List<ArticleDto> selectArticle(Map map){
        return session.selectList(namespace+"selectArticle",map);
    }

    @Override
    public List<ArticleDto> selectArticleCate(Map map){
        return session.selectList(namespace+"selectArticleCate",map);
    }

    @Override
    public ArticleDto selectArticleOne(Integer a_seqno){
        return session.selectOne(namespace+"selectArticleOne",a_seqno);
    }

    @Override
    public Integer selectTotalCount (String a_writer){
        return session.selectOne(namespace+"selectTotalCount",a_writer);
    }



    @Override
    public Integer selectCateCount (Map map){
        return session.selectOne(namespace+"selectCateCount",map);
    }

    @Override
    public int deleteArticleCate(Map map) {
        return session.delete(namespace + "deleteArticleCate", map);
    }
}
