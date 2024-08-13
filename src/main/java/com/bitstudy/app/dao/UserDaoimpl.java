package com.bitstudy.app.dao;

import com.bitstudy.app.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoimpl implements UserDao {
    @Autowired
    SqlSession session;

    String namespace="com.bitstudy.app.dao.userMapper.";

    @Override
    public int insertUser(UserDto userDto) {
        return session.insert(namespace + "insertUser",userDto);
    }

    @Override
    public int deleteUser(String u_id) {
        return session.delete(namespace + "deleteUser",u_id);
    }

    @Override
    public UserDto selectUser(String u_id) {
        return session.selectOne(namespace + "selectUser",u_id);
    }
}
