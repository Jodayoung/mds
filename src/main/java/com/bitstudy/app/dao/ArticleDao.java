package com.bitstudy.app.dao;

import com.bitstudy.app.domain.ArticleDto;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
    int insertArticle(ArticleDto articleDto);

    int deleteArticleAll();

    int deleteArticleWriter(String a_writer);

    int deleteArticleOne(Map map);

    int updateArticle(ArticleDto articleDto);

    List<ArticleDto> selectArticle(Map map);

    List<ArticleDto> selectArticleCate(Map map);

    ArticleDto selectArticleOne(Integer a_seqno);

    Integer selectTotalCount (String a_writer);

    Integer selectCateCount (Map map);

    int deleteArticleCate (Map map);

}
