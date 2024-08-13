package com.bitstudy.app.service;

import com.bitstudy.app.dao.UserDao;
import com.bitstudy.app.domain.LoginDto;
import com.bitstudy.app.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    public int insertUser(UserDto userDto){
        return userDao.insertUser(userDto);
    }

    public int deleteUser(String u_id){
        return userDao.deleteUser(u_id);
    }


    public UserDto selectUser(String u_id){
        return userDao.selectUser(u_id);
    }



    /* 할 일
    * 유저가 입력한 아이디로 셀렉트 한 다음에 그 정보 받아와서 저장하고 그 정보에 있는
    * 패스워드랑 유저가 입력한 패스워드랑 같냐!?
    * 같으면 오케이
    * 다르면 다시 로그인페이지 보내주기(에러메세지)
    *
    * */
    public int loginChk (LoginDto loginDto) {
        UserDto userDto = userDao.selectUser(loginDto.getU_id());
        if(userDto == null){//로그인 시켜주면 안됨 에러메세지 띄우기
            return 0;
        }
        else {
            if (userDto.getU_pw().equals(loginDto.getU_pw())){
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}
