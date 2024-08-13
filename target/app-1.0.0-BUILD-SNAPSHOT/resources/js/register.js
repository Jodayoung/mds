function register_check() {
    let id = document.getElementById("id");
    let pw = document.getElementById("pw");
    let pw_chk = document.getElementById("pw_chk");
    let name = document.getElementById("name");
    let pone = document.getElementById("pone");

    let error = document.getElementById("error");
    let pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
    let poneCheck =/^[0-9]+$/;


    if (id.value == "") {
        error.textContent = "아이디를 입력하세요.";
        id.focus();
        return false;
    } 
    else if (id.value.length < 8 || id.value.length > 16) {
        error.textContent = "아이디는 8자리 이상 16자리 이하여야 합니다.";
        id.focus();
        return false;
    } 
    else if (!/^[a-zA-Z0-9]+$/.test(id.value)) {
        error.textContent = "영문자와 숫자만 사용 가능합니다.";
        id.focus();
        return false;
    }
    else if (pw.value == "") {
        error.textContent = "비밀번호를 입력하세요.";
        pw.focus();
        return false;
    } 
    else if (!pwdCheck.test(pw.value)) {
        error.textContent = "비밀번호는 영문자+숫자+특수문자 조합으로 8~20자리 사용해야 합니다.";
        pw.focus();
        return false;
    }
    else if (pw_chk.value !== pw.value) {
        error.textContent = "비밀번호가 일치하지 않습니다.";
        pw_chk.focus();
        return false;
    }
    else if (name.value == "") {
        error.textContent = "이름을 입력하세요.";
        name.focus();
        return false;
    }
    else if (pone.value == "") {
        error.textContent = "핸드폰 번호를 입력해주세요.";
        pone.focus();
        return false;
    } 
    else if (pone.value.length !== 11 ) {
        error.textContent = "핸드폰 번호 11자리 입력해주세요.";
        pone.focus();
        return false;
    } 
    else if (!/^[0-9]+$/.test(pone.value)) {
        error.textContent = "핸드폰번호는 번호만 입력해주세요";
        pone.focus();
        return false;
    }
    else{
        return true;
    }
    
}
$(document).ready(function(){




    
})