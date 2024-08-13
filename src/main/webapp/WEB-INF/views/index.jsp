<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-06-30
  Time: 오후 5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.net.URLDecoder"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="logInOutLink" value="${ sessionScope.id==null ? '/login':'/logout' }" />
<c:set var="logInOutTxt" value="${ sessionScope.id==null ? 'login':'logout' }" />
<c:set var="cateName" value="${param.cate ==''? '전체':param.cate}" />


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="<c:url value='/js/h_f.js'/>"></script>
    <script src="<c:url value='/js/index.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/css/h_f.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/index.css'/>">
</head>
<body>
<div id="wrap">
    <div class="header">
        <div class="logo"><a href="<c:url value="/"></c:url>">My_development_story</a></div>
        <div class="login_box">
            <div class="login_id">${sessionScope.u_id} 님</div> <!--  있다 없다  -->
            <div class="login_text"><a href="<c:url value="/logout"></c:url>">log-out</a></div>
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
            <div class="title">당신의 발전을 스토리로 만들어 주세요.</div>
            <div class="main">
                <div class="cate">
                    <div class="cate_title">목록 만들기</div>  <!--  팝업 뛰울거임  -->
                    <div class="cate_content"><a href="/detail">글 만들기</a></div>
                    <div class="cate_total"><a href="/?cate=">전체 리스트 보기</a></div>
                    <div class="cate_box">

<%--                        <c:forEach var="cate" items="${cateList}">--%>
<%--                        <div class="cate_item">--%>
<%--                            <div class="item_name">${cate.getC_content()}</div>--%>
<%--                            <div class="item_mode">--%>
<%--                                <div class="cate_seqno" style="display: none;">${cate.getC_seqno()}</div>  <!--  고유번호 같이 넣어주고 팝업누르면 넣어주기  -->--%>
<%--                                <div class="modify">수정</div>   <!-- 만들기랑 같은 팝업 뛰울거임  -->--%>
<%--                                <div class="delete">삭제</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        </c:forEach>--%>


                    </div>
                    <div class="cate_popup_pan">
                        <div class="cate_popup"><!-- 만들기 누르면 title 비어있어야하고 , 수정 누르면 그내용 담아 와야함. -->
                            <div class="popup_name">${name}</div> <!-- 나상민(사용자이름), 추가(수정) 클릭할때마다 다르게   -->
                            <div class="popup_seqno" style="display: none;"></div> <!--  고유번호 받아와서 넣어주기  -->
                            <input type="text" placeholder="목록의 이름을 정해주세요" class="popup_title" value="" >
                            <div class="popup_buttonbox">
                                <div class="popup_button">만들기</div>  <!-- 만들기랑 수정하기 -->
                                <div class="popup_modify">수정하기</div>
                                <div class="popup_cancle">취소</div>
                            </div>

                        </div>
                    </div>

                </div>
                <div class="content">
                    <div class="content_title">${cateName} 리스트 보기</div>
                    <div class="content_box">


                        <c:forEach var="item" items="${articleList}">
                        <div class="content_item">
                            <div class="content_seqno" style="display: none;">${item.getA_seqno()}</div>
                            <div class="content_type">${item.getA_cate()}</div>
                            <div class="content_name"><a href="/detail?a_seqno=${item.getA_seqno()}">${item.getA_title()}</a></div>
                            <div class="content_delete">삭제</div>
                        </div>
                        </c:forEach>


                    </div>
                    <div class="content_page">
                        <c:if test="${ph.showPrevBtn}">
                            <a href="<c:url value="/?page=${ph.startPage-1}&cate=${param.cate}"/>"class="startPage">[이전]</a>
                        </c:if>
                        <c:forEach var="i" begin="${ph.startPage}" end="${ph.endPage}">
                            <a href="<c:url value="/?page=${i}&cate=${param.cate} "/>"class="${i==ph.page?"pageActive":""}">${i}</a>
                        </c:forEach>

                        <c:if test="${ph.showNextBtn}">
                            <a href="<c:url value="/?page=${ph.endPage+1}&cate=${param.cate}"/>"class="endPage">[다음]</a>
                        </c:if>


                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
<script>
    $(document).ready(function(){

        let showCate = function() {
            $.ajax({
                url: '/getCate',
                type: 'GET',

                success: function(result) {
                    let tmp = "";
                    result.forEach(function (rowResult) {

                        tmp += `<div class="cate_item">
                            <div class="item_name"><a href="/?cate=${'${rowResult.c_content}'}">${'${rowResult.c_content}'}</a></div>
                            <div class="item_mode">
                                <div class="cate_seqno" style="display: none;">${'${rowResult.c_seqno}'}</div>  <!--  고유번호 같이 넣어주고 팝업누르면 넣어주기  -->
                                <div class="modify">수정</div>   <!-- 만들기랑 같은 팝업 뛰울거임  -->
                                <div class="delete">삭제</div>
                            </div>
                        </div>`

                    })
                    $('.cate_box').html(tmp);
                },
                error: function () {
                    alert("실패")
                }
            });
        }
        showCate();

        $(".cate_title").on('click',function(){
            $('.cate_popup_pan').css({
                display: "block"
            })
            $('.popup_modify').css({
                display: "none"
            })
            $('.popup_button').css({
                display: "inline-block"
            })
            $('.popup_title').val("")
        })


        $(document).on('click','.modify',function(){
            $('.popup_button').css({
                display: "none"
            })
            $('.popup_modify').css({
                display: "inline-block"
            })

            $('.cate_popup_pan').css({
                display: "block"
            })
            $('.popup_title').val($(this).parent().prev().text())
            $('.popup_seqno').text($(this).prev().text())
        })


        $(".popup_button").on('click',function(){

            let title = $(this).parent().prev().val()
            console.log(title)

            $.ajax({
                url: "/madeCate?title="+title, // 요청할 URI
                type: "post", // 전송 타입
                data: JSON.stringify(title),
                // 서버로 전송할 데이터(직렬화)
                // data: {id:"asdf", name:"홍길동"},
                // dataType: 'text',
                // headers: {"content-type": "application/json"}, // 요청 헤더
                success: function(body){
                    alert(body)
                    showCate();

                },
                error: function(){
                    alert("등록에 실패했습니다.")
                }
            });
        })

        $(document).on('click','.delete',function() {
            if(!confirm("정말로 삭제 하시겠습니까? 관련된 게시글이 모두 지워집니다.")){return;}
            let c_seqno = $(this).prev().prev().text()
            console.log(c_seqno);

            $.ajax({
                url: "/deleteCate/"+c_seqno, // 요청할 URI
                type: "delete", // 전송 타입
                success: function(body){
                    alert(body);
                    location.reload();
                },
                error: function(){
                    alert("삭제에 실패했습니다.")
                }
            });
        });


        $(document).on('click','.popup_modify',function() {
            let c_seqno = $(this).parent().prev().prev().text()
            let c_content = $(this).parent().prev().val()
            console.log(c_seqno,c_content)
            $.ajax({
                url: "/patchCate/", // 요청할 URI
                type: "patch", // 전송 타입
                headers: {"content-type":"application/json"},
                data:JSON.stringify({c_seqno:c_seqno, c_content:c_content}),


                success: function(body){
                    alert(body)
                    showCate();

                },
                error: function(){
                    alert("등록에 실패했습니다.")
                }
            });
        });


        $(document).on('click','.content_delete',function() {
            if(!confirm("정말로 삭제 하시겠습니까?")) return;
            let a_seqno = $(this).prev().prev().prev().text()
            console.log(a_seqno);

            $.ajax({
                url: "/articleDelet/"+a_seqno, // 요청할 URI
                type: "delete", // 전송 타입
                success: function(body){
                    alert(body)
                },
                error: function(){
                    alert("등록에 실패했습니다.")
                }
            });

        });

        $(document).on('click','.unregister,.ham_unregister',function(){
            if(!confirm("모든 게시글이 삭제 됩니다 정말 탈퇴 하시겠습니까?")) return;
            location.href="<c:url value="/dropUser"></c:url>"

        })


    });
</script>

</html>