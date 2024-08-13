$(document).ready(function(){


    $('.header_ham').click(function(){
        $('.ham_pan').css({
            left : 0
        })
        $('body').css({
            overflow: 'hidden'
        })
    })

    $('.close').click(function(){
        $('.ham_pan').css({
            left : "-100%"
        })
        $('body').css({
            overflow: 'auto'
        })
    })

})