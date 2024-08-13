$(document).ready(function(){

    $(".popup_cancle,.popup_button,.popup_modify").on('click',function(){
        $('.cate_popup_pan').css({
            display: "none"
        })
    })


    $('.header_ham').click(function(){
        $('.ham_pan').css({
            left : 0
        })
        $('body').css({
            overflow: 'hidden'
        })
    })


})