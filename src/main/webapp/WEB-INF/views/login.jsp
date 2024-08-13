<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-06-30
  Time: 오후 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.net.URLDecoder"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="logInOutLink" value="${ sessionScope.id==null ? '/login':'/logout' }" />
<c:set var="logInOutTxt" value="${ sessionScope.id==null ? 'login':'logout' }" />


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/login.css'/>">
    <script src="<c:url value='/js/login.js'/>"></script>


</head>
<body>
<div id="wrap" class="contents_area">
    <div class="main">
        <div class="logo"><a href="#">My_development_story</a></div>
        <div class="error">${param.msg}</div>
        <form action="login/chk" method="post" class="loginbox">
            <input type="text" placeholder="아이디" name="u_id" class="id">
            <input type="password" placeholder="비밀번호" name="u_pw" class="pw">
            <div class="check">
                <input type="checkbox" name="auto" id="auto">
                <label for="auto">로그인 상태 유지</label>
            </div>
            <button class="login">로그인</button>
        </form>
        <div class="register">계정이 없으신가요? <span><a href="/register">가입하기</a></span></div>

    </div>

</div>
</body>
</html>