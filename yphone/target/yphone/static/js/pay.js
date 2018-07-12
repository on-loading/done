/**
 * Created by chenhansen on 2018/7/6.
 */
$(document).ready(function () {

    $('#alipay').click(function(){
        window.location.href="fastpay?orderID="+$('#order_id').html()+"&orderPrice="+$('#order_price').html();
    })

    // var qrcode = new QRCode(document.getElementById("qrcode"), {
    //     width : 100,
    //     height : 100
    // });
    //
    // function makeCode () {
    //     qrcode.makeCode("www.baidu.com");
    // }
    //
    // makeCode();



})