package com.bitstudy.app.controller;

import com.bitstudy.app.dao.UserDao;
import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class RegisterController {
@Autowired
UserService userService;

/*할일
* 1. 뷰파일에서 겟맵핑 주소 연결해오기
* 2. 유효성 검사
* 3. 저장
* 4. 리턴값 넣기
*
*   아이디 값 받아서 아이디값 널이면 진행시켜
*   아이디값 널 아니면 이미 있는 정보로 경고창 띄워
*
*   인설트 아이디로 저장시켜
*
*   로그인페이지로 이동시켜
*
*
* */
/*
* 한 일 정리
* 회원가입 페이지를 보여주기 위해서 겟맵핑으로 주소 연결 후 리턴값으로 뷰파일 보여주기
* 포스트 맵핑만들어서 정보 받아와서(정보 받아올 때 폼태그써서 받아왔는데 거기 안에 있는 매서드랑
* 액션 맞춰주고 유저Dto랑 인풋 네임 맞춰주기 //jsp건들면 업데이트로 돌리기) Dto에 담기
* 아이디 중복 검사를 위해서 데이터베이스에 같은 아이디가 있냐 체크할 거임(아이디가 유니크이기때문)
* 하기위해서 만들어 놓은 셀렉트 유저를 사용해서 저장하고 그 값이 널이라면 중복된 아이디가 없다는 거니깐
* 회원가입 시켜주고, 로그인 페이지 보내주기 근데 널이 아니라면 아이디 중복이니깐,
* 오류 메세지 만들어서 jsp 파일에있는 <div id="error">${param.msg}</div> 넣어주기
*
*
*
*
* */

@GetMapping("/register")
    public String register(){
    return "register";
}

@PostMapping ("/register/save")
    public String save(UserDto userDto) throws Exception {
    UserDto user = userService.selectUser(userDto.getU_id());
    if(user != null){
        String msg = URLEncoder.encode("이미 존재하는 아이디입니다.","UTF-8");
        return "redirect:/register?msg="+msg;
    }
    else {
        userService.insertUser(userDto);
        return "redirect:/login";
    }
}













}
