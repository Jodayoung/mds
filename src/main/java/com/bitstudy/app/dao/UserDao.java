package com.bitstudy.app.dao;

import com.bitstudy.app.domain.UserDto;

public interface UserDao {
    int insertUser(UserDto userDto);

    int deleteUser(String u_id);

    UserDto selectUser(String u_id);
}
