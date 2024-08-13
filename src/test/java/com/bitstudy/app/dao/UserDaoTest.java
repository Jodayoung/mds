package com.bitstudy.app.dao;

import com.bitstudy.app.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void insertUser() {
        UserDto userDto = new UserDto("dayoung","ddd","다영","5555");
        System.out.println("여기"+userDto);
        userDao.insertUser(userDto);
    }

    @Test
    public void deleteUser() {
        userDao.deleteUser("dayoung");
    }

    @Test
    public void selectUser() {
        UserDto userDto = userDao.selectUser("dkdk3153");
        System.out.println("여기예요"+userDto);
    }
}