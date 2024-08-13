package com.bitstudy.app.dao;

import com.bitstudy.app.domain.CateDto;
import org.checkerframework.checker.units.qual.C;
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
public class CateDaoTest {
    @Autowired
    CateDao cateDao;
    @Test
    public void insertCate() {
        CateDto cateDto = new CateDto("다영","여행");
        cateDao.insertCate(cateDto);
    }

    @Test
    public void deleteCateWriter() {
        cateDao.deleteCateWriter("dayoung");
    }

    @Test
    public void deleteCateOne() {
        cateDao.deleteCateOne(11);
    }

    @Test
    public void updateCate() {
        CateDto cateDto = new CateDto("dayoung","독서");
        cateDto.setC_seqno(6);
        System.out.println("여기예요"+cateDto);
        cateDao.updateCate(cateDto);
    }

    @Test
    public void selectCate() {
        List<CateDto> cateDto = cateDao.selectCate("dayoung");
        System.out.println("여기예요"+cateDto);
    }
}