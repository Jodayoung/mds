package com.bitstudy.app.controller;

import com.bitstudy.app.domain.ArticleDto;
import com.bitstudy.app.domain.CateDto;
import com.bitstudy.app.service.ArticleService;
import com.bitstudy.app.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Controller
public  class detailController {

@Autowired
    ArticleService articleService;

@Autowired
    CateService cateService;


/* 디테일 뷰파일 보여줄 겟맵핑 생성하기
 * 리퀘스트 생성하고 임시로 네임/밸류 값 정해놓기 세션 아이디 값 스트링 타입으로 유저 변수 저장
* 그 변수 값 보내서 리스트로 받아온 값 저장하고 모델에 담기
* 고유번호가 있을때 정보가져와서 모델에 담아서 보내줄게임.
* 즉 이말이 게시글 눌러서 넘어올때 이렇게 해준다는거임
* 리턴타입 뷰파일
*
* 포스트맵핑
* 수정하게 만들어야하니까 세션에서 아이디값 받아오깅 dto에 유저 보내서 작성자 세팅해주기
* articleDto 안에 a_seqno가 비어있으면 등록하기임 아니면 업데이트
*
*
*
* 딜리트 겟맵핑
* 게시글 눌러서 정보 보는곳 아래에 삭제 누르면 a태그 타고올때 고유번호도 같이보내줘서 그번호 삭제하고 메인페이지 보내주기
*
* */


    @GetMapping("/detail")
    public String detail(HttpServletRequest request, Integer a_seqno, Model model){
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("u_id");

        if (user ==null){
            return "redirect:/login";
        }

//        a_seqno 보유 여부 필드
        List<CateDto> cateList = cateService.selectCate(user);
        model.addAttribute("cateList",cateList);

        //고유번호가 있을때 정보가져와서 모델에 담아서 보내줄게임.
        //즉 이말이 게시글 눌러서 넘어올때 이렇게 해준다는거임
        if (a_seqno != null){
            ArticleDto article = articleService.selectArticleOne(a_seqno);
            SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

            model.addAttribute("article",article);
            model.addAttribute("time",date.format(article.getA_time()));
        }

        // 만약에 글 만들기로 들어간다면 위에꺼 안만들어진다는거임



        return "detail";
    }


    @PostMapping("/PostDetail")
    public String postDetail (ArticleDto articleDto,HttpSession session){
        String user = (String) session.getAttribute("u_id");
        articleDto.setA_writer(user);
        articleDto.getA_content();

        if (articleDto.getA_seqno() == null){
            articleService.insertArticle(articleDto);


            return "redirect:/";
        }

        else {
            articleService.updateArticle(articleDto);

            return "redirect:detail?a_seqno="+articleDto.getA_seqno();
        }

    }

/* 게시글 눌러서 정보 보는곳 아래에 삭제 누르면 a태그 타고올때 고유번호도 같이보내줘서 그번호 삭제하고 메인페이지 보내주기*/
    @GetMapping("/delete")
    public String delete (Integer a_seqno,HttpSession session){
        String user = (String) session.getAttribute("u_id");
        articleService.deleteArticleOne(a_seqno,user);


        return "redirect:/";
    }



}
