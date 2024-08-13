package com.bitstudy.app.controller;

import com.bitstudy.app.domain.LoginDto;
import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.service.ArticleService;
import com.bitstudy.app.service.CateService;
import com.bitstudy.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;




/*
* 할 일
* 일단 겟맵핑으로 로그인 창 연결해서 뷰파일 보여주기?
* 포스트맵핑으로 정보 받아오기
* 디비에 로그인 정보 보내서 맞으면 메인페이지 띄우고, 정보 다르면 오류메세지 띄우기
*
* */


/* 한 일
* GetMapping ("/login") 로그인페이지 보여주기 위해 만들어준다
* 사용자가 입력한 아이디/비밀번호를 가져오기 위해서 포스트 맵핑을 만들어준다(jsp안에 있는 폼태그랑 액션 매서드 인풋 네임 맞추기)
* 사용자가 입력한 정보를 받기위해 매개변수에 로그인 Dto 선언한다
* 유저가 입력한 정보를 체크하기위해 유저서비스에 아이디/비밀번호가 맞는지 확인하게 해서 정보가 맞으면 1/다르면 0으로 저장한다
* 그 저장한 값이 0이면 에러메세지 만들어서 로그인페이지로 보낼 때 같이 보내주기
* 쿠키 생성해서 자동로그인 체크 안 했을 때 쿠키 저장시간 0으로 만들어주고 리스폰즈에 담아주기
* 세션 생성해서 아이디 값 세션에 저장하기
* 메인페이지 보여주기
* */

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @Autowired
    CateService cateService;

    @GetMapping("/login")//url주소 치는 곳
    public String login(HttpServletRequest request){

        String c_id = "";  //세션 만들기위해 쿠키에있는 벨류값 저장해줄려고 만든 변수
        Cookie[] cookies =request.getCookies(); // 쿠키 전부들고와서 배열로 저장
        if (cookies != null){
            for(Cookie c : cookies) {  //배열 돌리면서 우리가 넣은 쿠키 이름이랑 같은 애(instagram_id) value 값저장.
                if (c.getName().equals("u_id")){
                    c_id = c.getValue();
                }
            }
        }

//        if (!c_id.equals("")){  //! 붙여서 같지않다면
//            HttpSession session = request.getSession();
//            session.setAttribute("u_id",c_id);
//            return "redirect:/"; //그걸로 세션만들어서 바로 메인으로
//        }


        return "login"; //리다이렉트가 붙으면 주소창을 쳐주는 거고,아니면 폼을 보여주는 것
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,HttpServletResponse response) {


        session.invalidate();

        Cookie myCookie = new Cookie("u_id", null);  // 쿠키 값을 null로 설정
        myCookie.setMaxAge(0);  // 남은 만료시간을 0으로 설정
        response.addCookie(myCookie);

        return "redirect:/login";
    }


    @PostMapping("login/chk")
    public String chk(LoginDto loginDto, HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("로그인 디티오 " + loginDto);
        Integer ttt = userService.loginChk(loginDto);

        if(ttt==0){
            String msg = URLEncoder.encode("잘못된 정보를 입력하셨습니다.","UTF-8");
            return "redirect:/login?msg="+msg;
        }


        //쿠키 세션 만들어 줘야죠
        String u_id = loginDto.getU_id();
        Cookie cookie = new Cookie("u_id",u_id);
        if(!loginDto.isAuto()){
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
        HttpSession session = request.getSession();
        session.setAttribute("u_id",u_id);

        return "redirect:/";

    }

    @GetMapping("/dropUser")
    public String dropUser(HttpSession session){
        /*
        * 할 일

        * 1. 유저가 작성한 게시글 삭제 해줄거임
        * 2. 유저가 작성한 카테 삭제 해줄거임
        * 3. 유저 삭제 해줄거임
        * */
        String user = (String) session.getAttribute("u_id");
        articleService.deleteArticleWriter(user);
        cateService.deleteCateWriter(user);
        userService.deleteUser(user);



        return "redirect:/login";
    }







}
