/**
 * Created by chenhansen on 2018/7/5.
 */

var province="";
var city="";
var district="";
var index=1;
var cityPid=0;
var districtPid=0;


$(document).ready(function(){

    getAddressInfo(0);
    getAddressUsed();




    $('#address').click(function(){
        $('.address-info').show();

    });

    $('.province').click(function(){
        $('.address-head .left span').css('margin-left','25px');
        index=1;
        getAddressInfo(0);
    });

    $('.city').click(function(){
        if(index==1)
            return;
        index=2;
        $('.address-head .left span').css('margin-left','80px');
        getAddressInfo(cityPid);
    });
    $('.district').click(function(){
        if(index!=3)
            return;
        $('.address-head .left span').css('margin-left','140px');
        getAddressInfo(districtPid);
    });



    $('#address-submit').click(function(){
        var name=$('#name').val();
        var phone=$('#phone').val();
        var address=$('#address').val();
        var address_detail = $('#address-detail').val();
        if(name=="") {
            alert("请输入收货人姓名！");
            return;
        }
        if(phone=="") {
            return;
            alert('请输入联系电话');
        }
        if(address==""||address_detail=="") {
            alert('请输入详细地址');
            return;
        }
        $.ajax({
            url:"saveAddress",
            type:"post",
            data:{
                area:address,
                addressDetail:address_detail,
                phone:phone,
                receiver:name
            },
            success:function(msg){
                alert("success");
                appendAddress(name,phone,address,address_detail);
                $('#myModal').modal('hide');
            }


        })
    });


    $('.address-head .right a').click(function () {
        $('.address-info').hide();
    });



    $('.order-submit-btn').click(function(){
        var price=$('#payableTotal').html();
        var phone="";
        var num=$('#pnum').html();
        var receiver="";
        var address="";
        var selected=0;
        $('.order-address-list>ul>li').each(function(){
            if($(this).hasClass("selected")){
                selected=1;
                phone=$(this).find('.order_phone').html();
                receiver=$(this).find('.order_name').html();
                address=$(this).find('.order_address').html()+
                    $(this).find('.order_detail_address').html();
            }
        });

        if(selected==0){
            alert("请选择收货地址信息");
            return;
        }

        $('#submit_form .receiver').val(receiver);
        $('#submit_form .num').val(num);
        $('#submit_form .phone').val(phone);
        $('#submit_form .address').val(address);
        $('#submit_form .price').val(price);
        console.log($('#submit_form .receiver').val());
        console.log($('#submit_form .num').val());
        console.log($('#submit_form .phone').val());
        console.log($('#submit_form .address').val());
        console.log($('#submit_form .price').val());
        $('#submit_form').submit();
    })



    function getAddressUsed() {
        $.ajax({
            url:"showAddress",
            type:"get",
            dataType:"json",
            success:function(msg){
                for(var key in msg){
                    appendAddress(msg[key].receiver,msg[key].phone,msg[key].area,msg[key].addressDetail);
                }
            }
        })

    }

})

function getAddressInfo(addressID){
    $.ajax({
        url:"addressInfo",
        type:"get",
        dataType:"json",
        data:{
            aid:addressID
        },
        success:function(msg){
            putAddress(msg);
        }

    })
}

function putAddress(msg){
    var htm="";
    for(i in msg){
        htm+='<li class="address-items" >'+
            '<a  id="'+i+'" onclick="getAddress(this)" >'+msg[i]+'</a>'+
            '</li >';
    }

    $('.address-list').html(htm);
}

function getAddress(e) {



    if(index==3){

        district=$(e).html();
        $('#address').val(province+"-"+city+"-"+district);
        $('.address-info').hide();
    }

    else if(index==1){
        cityPid=parseInt($(e).attr('id'));
        province=$(e).html();
        $('.address-head .left span').css('margin-left','80px');
        getAddressInfo(cityPid);
        index++;
    }
    else if(index==2){
        districtPid=$(e).attr('id');
        city=$(e).html();
        $('.address-head .left span').css('margin-left','140px');
        getAddressInfo(districtPid);
        index++;
    }
}

function itemSelect(e){
    $('.order-address-list>ul>li').each(function(){

        if($(this).hasClass("selected")){
            $(this).removeClass("selected");
            $(this).css("border","1px solid #eaeaea");
        }
    })
    $(e).addClass("selected");
    $(e).css("border","1px solid #f00");

}




function appendAddress(name,phone,address,address_detail){
    var h='<li onclick="itemSelect(this)">'+
        '<div class="namePhone item">'+
        '<span class="order_name">'+name+'</span>'+' '+'<span class="order_phone">' +phone+ '</span>'+
        '</div>'+

        '<div class=" item">'+
        '<span class="order_address">'+address+'  '+'</span>'+'<span class="order_detail_address">'+address_detail+ '</span>'+
        '</div>'+

        '</li>';
    $('.order-address-list ul #address-empty').before(h);
}




