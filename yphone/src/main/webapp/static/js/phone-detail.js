/**
 * Created by chenhansen on 2018/7/3.
 */

$(document).ready(function(){

    $('#pro-quantity-plus').click(function(){
        var val=$('#product-stock-text').val();
        val++;
        $('#product-stock-text').val(val);
    });
    $('#pro-quantity-minus').click(function(){
        var val=$('#product-stock-text').val();
        if(val<=1)
            return;
        val--;
        $('#product-stock-text').val(val);
    });

    $('#product-stock-text').bind('input porpertychange',function() {
        var val=$('#product-stock-text').val();
        var max=$('#phone_info_num').text();
        if(val>parseInt(max))
            $('#product-stock-text').val(max);
       // $('#content').html($(this).val().length + ' characters');
    });

    $('.product-button01').click(function() {
        //alert("hansen");
        var phoneID=$('#pid').val();
        var num=$('#product-stock-text').val();
        parent.document.location.href="purchase?phoneID="+phoneID+"&num="+num;
});
})
