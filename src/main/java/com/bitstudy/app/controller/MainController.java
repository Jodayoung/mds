package com.bitstudy.app.controller;

import com.bitstudy.app.domain.ArticleDto;
import com.bitstudy.app.domain.CateDto;
import com.bitstudy.app.domain.PageHandler;
import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.service.ArticleService;
import com.bitstudy.app.service.CateService;
import com.bitstudy.app.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/* 할 일
* 페이지 구현
* 로그인한 사람에 카테리스트 불러오기
* 로그인 한 사람꺼 게시글 전체 리스트 불러오기
* 페이지네이션
* 목록만들기 기능
* 글 만들기 누르면 상세페이지 이동
* 전체리스트누르면 전체리스트
* 카테 네임 누르면 그 카테에 관련된 리스트 뽑아오기
* 수정 누르면 수정 되게 다시 저장
* 삭제누르면 삭제됨
* 로그인 되어있으면 유저네임 뽑아주고 로그인 되어있으면 로그아웃 로그인 안되어있으면  로그인 떠야됨
* 회원탈퇴 기능(만든 게시글 /카테/회원정보 다 삭제)
* 게시글 옆에 삭제 누르면 삭제하시겠읍니까?예쓰~
*
*
*
* */


/*
* 목록 만들기 순서
* 사용자가 입력한 정보(목록 제목일 될거임)적고 만들기 누르면 ajax에서 정보 받아서 post 맵핑에서 정보 받아서 데이터 베이스에 넣어주고
* 석세스 영역에서 리스트 다시 찍어주기
*
*
* */


/* 한 일
* 리퀘스트안에 겟세션을 세션타입으로 세션이라는 변수명에 저장하고 그 저장한 세션에 셋어트리부트로 임시로 설정해주고
* 겟어트리부트로 가져온 유저아이디값을 스트링 타입 유저 변수명에 저장
* 카테 서비스안에 셀렉트카테 유저를 불러서 유저값 보내주고 그 결과를 카테디티오 리스트타입으로 카테리스트 변수명에 담아서 sout 으로 잘 찍히는지 확인 후
* 모델 선언하고 카테리스트 저장한 값을 모델에 담아준다
*
* 페이지핸들러(dto) 만들고, 게시글 총 구하는 맵퍼 만들어서 다오/다오임플/서비스 만들고 컨트롤러에서 유저 정보 보내줘서 그 유저에 게시글 총 불러오고
* 그 갯수와 현재 페이지를 페이지핸들러에 넣어줘서 저장후 모델에 담아준다
* 로그인한 유저가 작성한 전체 게시글 불러와서 디티오에 담고 모델에 담기
* 
* 모델에 담아둔 전체게시글 리스트를 뷰파일에서 포이치로 돌려서 전체 게시글 구현
* 모델에 담아둔 페이지 핸들러로 밑에 페이지 네비 구현
* 페이지 네비는 누르면 다시 겟맵핑(/)으로 오는데 올때 page들고옴(ex)/?page=1) 이런식으로 들고옴
* 그리고 이전 버튼은 스타트 페이지 -1 page로 들고오고 다음 버튼은 앤드페이지 +1 page로 들고옴
*
* 카테고리 리스트 불러오는걸 모델에 담아서 했었는데 그내용을 ajax로 변경했음(이유: 추가하거나 수정 삭제 했을떄의 최신 리스트를 바로 바로 찍어 주기 위해서)
* get 방식으로(읽어오기 라서) 맵핑 만들어서 리스트 보내줄거임 리턴타입은 보내줄 리스트타입에 리스폰즈 붙은거 ex)ResponseEntity<List<CateDto>>
* 사용자가 만든 카테리스트 불러와서 저장하고 석세스로 보내주고 석세스영역에서 변수 하나만들어서 그밑에 포이치문(자바 스크립트 방식)으로 돌려준다음에
* 그 변수를 item의 부모 박스의 html으로 넣어 준다음에 밑에서 불러 줬음.
*
* 만들기 버튼 누르면 post 방식으로 받는 맵핑이 텍스트 받아서 그 내용으로 작성자 세션에서 뽑아서 cateDto만들고
* 그dto로 insert해주기(맵퍼 짤때 insert의 파라메타 타입이 dto로 달라고해서 dto에 담아서 주는거임)
* 데이터 베이스에 인설트 해주고 등록성공했다는 내용적어서 석세스영역에 보내고 석세스 영역에서 alret 뛰워주기
* 띄워 준 다음에 (get방식 cate읽어주는 ajax있는 변수로 저장된 거 불러주기) 그러면 내가 방금 넣은 카테 리스트까지 나옴.
*
* 
* */
@Controller
public class MainController {
    @Autowired
    ArticleService articleService;

    @Autowired
    CateService cateService;

    @Autowired
    UserService userService;

    @GetMapping ("/")
    public String main(HttpServletRequest request,Integer page,String cate, Model model){
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("u_id");

        if (user ==null){
            return "redirect:/login";
        }
        UserDto userDto = userService.selectUser(user);


        if(page == null) {
            page = 1;
        }

        if (cate == "" || cate == null){
            Integer totalCount = articleService.selectTotalCount(user);
            PageHandler pageHandler = new PageHandler(page,totalCount);
            List<ArticleDto> articleList = articleService.selectArticle(user,page);

            model.addAttribute("ph",pageHandler);
            model.addAttribute("articleList",articleList);
        }

        else {
            Integer totalCount = articleService.selectCateCount(cate,user);
            PageHandler pageHandler = new PageHandler(page,totalCount);
            List<ArticleDto> articleList = articleService.selectArticleCate(cate,user,page);

            model.addAttribute("ph",pageHandler);
            model.addAttribute("articleList",articleList);
        }
        model.addAttribute("name",userDto.getU_name());

        return "index";
    }

    /*
    * 카테고리 최신 파일 불러오기 위해 ajax랑 주고 받는 맵핑임
    * 우리는 cateDto에 담아서 리스트로 리턴 해줄거임
    *  리스트 내용은 로그인한 유저가 작성한 cate 리스트를 담아줄거임
    *
    * 최신파일 dto에 담아서 보내줄거면 리스폰즈바디 이노테이션 붙여주기.
    * */
    @GetMapping("/getCate")
    @ResponseBody
    public ResponseEntity<List<CateDto>> getCate(HttpSession session){
        try {
            String user = (String) session.getAttribute("u_id");
            List<CateDto> cateList = cateService.selectCate(user);


            return new ResponseEntity<List<CateDto>>(cateList, HttpStatus.OK);// 200

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CateDto>> (HttpStatus.BAD_REQUEST);// 400
        }

    }


    /*
    * cate 만들기 했을때 그 이름 받아와서 로그인한 유저 세션에서 들고와서 저장해주고
    * cate 이름이랑 작성자 보내서 cate insert 해주고
    * 성공했다고 보내주기 (성공했다고 보내는게 String이라 리턴 타입도 스트링.)
    *
    * */
    @PostMapping("/madeCate")
    public ResponseEntity<String> madeCate( String title,HttpSession session){
        try {
            String user = (String) session.getAttribute("u_id");
            CateDto cateDto = new CateDto(user,title);
            cateService.insertCate(cateDto);


            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("content-type","text/html; charset=UTF-8");
            return new ResponseEntity<String>("카테고리 등록 성공", responseHeader, HttpStatus.OK);// 200

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);// 400
        }

    }



    /*삭제 버튼을 누르면 정말 삭제하시겠습니까?를 띄우고 눌러지면 고유번호를 들고 가서
    * 딜리트 맵핑 만들어서 받은 후 삭제해주고 삭제된 리스트 불러와서 띄워주기
    * */

    @DeleteMapping("/deleteCate/{c_seqno}")
    public ResponseEntity<String> deleteCate (@PathVariable Integer c_seqno,HttpSession session){
        try {

            System.out.println("들어는옴");
            String user = (String)session.getAttribute("u_id");

            String aaa = cateService.selectCateOne(c_seqno);
            cateService.deleteCateOne(c_seqno);
            articleService.deleteArticleCate(user,aaa);

            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("content-type","text/html; charset=UTF-8");
            return new ResponseEntity<String>("삭제 완료 되었습니다.", responseHeader, HttpStatus.OK);// 200

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);// 400
        }

    }

    
    
    /* 수정 버튼 누르면 팝업창 뜨고 변경할 내용 적고 수정하기 버튼 누르면(온클릭 안에서 ajax만들기)
       수정한 내용 변수에 담아주고 수정하는 고유번호도 저장해주기 패스맵핑에 보내주고 dto에 담아서 db보내주기(아마 작성자도 넣어 줘야할듯)
       수정 완료하면 showList() 뷰파일에서 불러주기.
    * */
    @PatchMapping ("/patchCate/")
    public ResponseEntity<String> patchCate(@RequestBody CateDto cateDto){
        try {
            cateService.updateCate(cateDto);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("content-type","text/html; charset=UTF-8");
            return new ResponseEntity<String>("수정 성공", responseHeader, HttpStatus.OK);// 200

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);// 400
        }

    }

/*게시글 하나 삭제하기
*  ajax 고유넘버 받아서 딜리트맵핑 하나삭제하기
* */


    @DeleteMapping("/articleDelet/{a_seqno}")
    public ResponseEntity<String> articleDelet(@PathVariable Integer a_seqno, HttpSession session){
        try {
            String user = (String) session.getAttribute("u_id");
            System.out.println("시퀀스넘버여기" + a_seqno);
            articleService.deleteArticleOne(a_seqno,user);


            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("content-type","text/html; charset=UTF-8");
            return new ResponseEntity<String>("삭제 되었습니다", responseHeader, HttpStatus.OK);// 200
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);// 400
        }
    }

}
