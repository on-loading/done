(function($){
    $.getUrlParam = function(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return unescape(r[2]); return null;
    }})(jQuery);




function loginCheck(p){
    if(p=="null"||p=="") {
        $('#login-register').show();
    }
    else {
        $('#user-item').show();
    }
}