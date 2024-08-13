<%--
  Created by IntelliJ IDEA.
  User: 나상민
  Date: 2024-07-12
  Time: 오후 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.net.URLDecoder"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

    <script src="<c:url value='/js/h_f.js'/>"></script>
    <script src="<c:url value='/js/show.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/css/h_f.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/show.css'/>">

</head>
<body>
<div id="wrap">
    <div class="header">
        <div class="logo"><a href="<c:url value="/"></c:url>">My_development_story</a></div>
        <div class="login_box">
            <div class="login_id">${sessionScope.u_id} 님</div> <!--  있다 없다  -->
            <div class="login_text"><a href="<c:url value="/logout"></c:url>">log-out</a></div> <!-- 로그인,로그아웃  -->
            <div class="unregister">회원 탈퇴</div> <!-- 회원 가입, 회원 탈퇴 -->
        </div>
        <div class="header_ham">
            <div class="ham_line"></div>
            <div class="ham_line"></div>
            <div class="ham_line"></div>
        </div>
        <div class="ham_pan">
            <div class="ham_top">
                <div class="ham_logo"><a href="<c:url value="/"></c:url>">My_development_story</a></div>
                <div class="close">닫기</div>
            </div>
            <div class="ham_bot">
                <div class="ham_login_text"><a href="<c:url value="/logout"></c:url>">log-out</a></div> <!-- 로그인,로그아웃  -->
                <div class="ham_unregister">회원 탈퇴</div> <!-- 회원 가입, 회원 탈퇴 -->
            </div>
        </div>
    </div>
    <div class="container">
        <div class="container_area">
            <form action="/PostDetail" method="post">
                <div class="title_box">
                    <div class="content_seqno" style="display: none"></div>  <!--  고유 번호 넣기  -->
<%--                    <div class="title_cate" style="display: inline-block">독서</div>--%>

                    <select name="a_cate" class="select_cate" style="display: inline-block" ${empty article? "": "disabled"}>
                        <option value="" disabled hidden selected>목록</option>
                            <c:forEach var="item" items="${cateList}">
                            <option value="${item.c_content}" ${item.c_content == article.a_cate?"selected":""} >${item.c_content}</option>
                            </c:forEach>
                    </select>
                    <c:if test="${not empty article}">
                    <div class="title_time">${time}</div>
                    </c:if>
                    <input type="text" name="a_seqno" value="${article.a_seqno}" hidden="hidden">
                    <input type="text" class="title_name" name="a_title"${empty article ? "": "readonly"} value="${article.a_title}">
                </div>
                <div class="content_box">
                    <textarea name="a_content" id="content" ${ empty article ? "" : "readonly"}>${article.a_content}</textarea>
                </div>
                <div class="button_box">
                    <button class="button_register" style="display:  ${empty article ? "block" : "none"}">등록하기</button>

                    <div class="button_modify" style="display: ${empty article ? "none" : "block"}"> 수정하기</div>

                    <div class="button_delete" style="display: ${empty article ? "none" : "block"}">삭제하기</div>
                </div>
            </form>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
<script>
    $(document).ready(function(){

            $(".button_modify").on('click',function(){
                $(".button_modify").css({
                    display : "none"
                })
                $(".button_register").css({
                    display : "block"
                })

                $(".title_name").removeAttr("readonly")
                $("#content").removeAttr("readonly")

        })

        $(".button_delete").on('click',function(){
            if(!confirm("게시글이 삭제 됩니다 정말 삭제 하시겠습니까?")) return;
            location.href="<c:url value="/delete?a_seqno=${param.a_seqno}"></c:url>"
        })



        //등록하기를 눌렀는데 목록 체크된 게 없으면 이동막고 알람 띄우기
        $(".button_register").on('click',function(){
        if($(".select_cate").val() == null){
            alert("목록을 체크해주세요")
            event.preventDefault()
        }



        })


    })
</script>

</html>
