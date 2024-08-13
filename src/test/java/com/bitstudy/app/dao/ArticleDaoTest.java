package com.bitstudy.app.dao;

import com.bitstudy.app.domain.ArticleDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ArticleDaoTest {
    @Autowired
    ArticleDao articleDao;

    @Test
    public void insertArticle() {
        for (int i=0; i<30; i++){
            ArticleDto articleDto = new ArticleDto("다영","내용","한결"+i,"한결");
            articleDao.insertArticle(articleDto);
        }
    }

    @Test
    public void deleteArticleAll() {
        articleDao.deleteArticleAll();
    }

    @Test
    public void deleteArticleWriter() {
        articleDao.deleteArticleWriter("다영");
    }


    @Test
    public void updateArticle() {
        ArticleDto articleDto = new ArticleDto("dayoung","내용2","제목","독서");
        articleDto.setA_seqno(3);
        articleDao.updateArticle(articleDto);
    }

//    @Test
//    public void selectArticle() {
//        List<ArticleDto> articleDto = articleDao.selectArticle("dayoung");
//        System.out.println("여기예요"+articleDto);
//    }

    @Test
    public void selectArticleCate() {
        Map map = new HashMap();
        map.put("a_cate","독서");
        map.put("a_writer","dayoung");
        List<ArticleDto> articleDto = articleDao.selectArticleCate(map);
        System.out.println("여기예요"+articleDto);
    }

    @Test
    public void selectArticleOne() {
        ArticleDto articleDto = articleDao.selectArticleOne(3);
        System.out.println("여기예요"+articleDto);

    }
}