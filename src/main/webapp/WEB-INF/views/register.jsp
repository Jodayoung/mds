<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-06-29
  Time: 오후 6:42
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
    <script src="<c:url value='/js/register.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/css/register.css'/>">
</head>
<body>
<div id="wrap" class="contents_area">
    <div class="main">
        <div class="logo"><a href="#">My_development_story</a></div>
        <div id="error">${param.msg}</div>
        <form action="/register/save" method="post" class="form" onsubmit="return register_check()">
            <input type="text" placeholder="아이디" class="id" id="id" name="u_id">
            <input type="password" placeholder="비밀번호" class="pw" id="pw" name="u_pw">
            <input type="password" placeholder="비밀번호확인" class="pw_chk" id="pw_chk" >
            <input type="text" placeholder="성명" class="name" name="u_name" id="name">
            <input type="text" placeholder="전화번호(숫자만 입력)" class="pone" name="u_number" id="pone">
            <button class="register">회원가입</button>
        </form>
        <div class="login">계정이 있으신가요? <span><a href="/login">로그인</a></span></div>

    </div>

</div>
</body>
</html>