# My Develope Story
![header](https://capsule-render.vercel.app/api?type=wave&color=auto&height=300&section=header&text=Hello&fontSize=90&animation=fadeIn&fontAlignY=38&desc=Dayoung's%20GitHub%20Profile&descAlignY=51&descAlign=62)


#  project : MDS
---
## 💻 프로젝트 소개
네이버 블로그를 운영하면서 나만의 이야기를 담을 수 있는 페이지가 있으면 좋겠다 생각해서 만들게 되었습니다.

---
## 📆 개발기간
+ 2024.07.08 ~ 07.10(3일) 

## 📝 개발언어
<div style="display:flex; flex-direction:column; align-items:flex-start;">
    <!-- Backend -->
    <p><strong>Backend</strong></p>
    <div>
        <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white"> 
        <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
    </div>
    <!-- Database -->
    <p><strong>Database</strong></p>
    <div>
        <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
    </div>
    <!-- Server -->
    <p><strong>Server</strong></p>
    <div>
        <img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black">
    </div>
    <!-- Frontend -->
    <p><strong>Frontend</strong></p>
    <div>
        <img src="https://img.shields.io/badge/html5-E34F26?style=flat-square&logo=html5&logoColor=white"> 
        <img src="https://img.shields.io/badge/css-1572B6?style=flat-square&logo=css3&logoColor=white"> 
        <img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat-square&logo=javascript&logoColor=black"> 
    </div>
</div>

## ⚙ 개발환경
+ Java 11 version
+ JDK 11.0.22 version
+ Tomcat 9.088 version
+ Framework : Spring
+ Database : MySql(8.0.36)
+ ORM : Mybatis
---
## 📌 주요기능
1. 로그인 페이지
자동로그인 기능
기본적인 유효성 검사
로그인

2. 회원가입 페이지
유효성 검사 기능
회원가입

3. 메인페이지
로그인 한 유저만 글을 작성할 수 있음
만약 로그인 안했으면 로그인 페이지로 이동

    왼쪽칸에 큰목록 칸을 정리할 수 있게큼 하나만들고 그거 누르면 옆에 칸이 바뀌게 구현함

    페이지 네이션 기능 게시물 10개씩/네비 갯수는 5개 

4. 만들기페이지
기존 게시글 읽기 ,수정, 삭제
게시글 만들기

  

## 📎이미지

로그인 페이지

![KakaoTalk_20240813_150214096](https://github.com/user-attachments/assets/8dd9cfe4-c426-4c81-b1b4-b47a60433823)


회원가입 페이지 & 기능

![KakaoTalk_20240813_150213594](https://github.com/user-attachments/assets/8651df48-ea3f-497e-a8df-4a9bc2f22520)


![KakaoTalk_20240813_150214639](https://github.com/user-attachments/assets/c4640afc-18dd-4ffd-a95e-83041afec673)



메인 페이지 & 기능

![KakaoTalk_20240813_150231575](https://github.com/user-attachments/assets/e8880d54-5af8-43d4-b5c1-4fa9cbdbe9a0)

1.목록 만들기
  4번에 들어가는 목록 생성할 수 있는 팝업이 켜진다

<img width="745" alt="목록만들기" src="https://github.com/user-attachments/assets/24d51b9f-2270-4fce-bb4a-69a0b40e6117">

  
2.글 만들기
  만들기 페이지

 
 목록을 설정해야 글 작성이 가능하며, 목록 설정하지 않으면 alert로 "목록을 체크해주세요"라는 메세지가 뜬다

![image](https://github.com/user-attachments/assets/a1ba49cb-3e0f-4d09-8d1f-8955aabebf35)

3.전체 리스트 보기
  모든 목록에 있는 글을 전체 다 불러와서 페이지네이션으로 10개씩/네비 갯수는 5개 보여준다

4.목록 리스트
  목록이 박스 범위를 넘어가면 스크롤이 생긴다


5. 수정

 <img width="758" alt="수정" src="https://github.com/user-attachments/assets/af5f56a3-0312-4410-9ef1-8a4b93b85331">



6. 누른 목록 삭제

![image](https://github.com/user-attachments/assets/990d12d8-f6d0-4fb8-8f40-00125266ea31)


7. 목록 누르면 해당하는 목록 글 가져오기



8. 누른 글 삭제


   
9. 페이지네이션
  네비의 갯수는 5개,보여주는 글의 갯수는 최대 10개로 설정했으며 현재 페이지 설정은 url에서 받아오는 페이지를 보여주는 형식
  만약 페이지 값이 없다면 1페이지를 보여주게 설정했음



10.유저 아이디를 가져와서 아이디 박스에 보여줌



11. 로그아웃
    버튼을 누르면 로그인한 유저의 관련된 세션이랑 쿠키를 삭제해줌

  12.회원 탈퇴
    버튼을 누르면 "모든 게시글이 삭제 됩니다 정말 탈퇴 하시겠습니까?" 띄워주고 확인 버튼 누르면 작성했던 모든 글/목록 삭제됨

