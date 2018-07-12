/**
 * Created by chenhansen on 2018/6/30.
 */

    function getPhoneList() {
    $.ajax({
        url: "phoneList",
        type: "get",
        dataType: "JSON",
        success: function (msg) {
            var htm="";
            var name="";
            var names="";

            var huawei_lists=$('#huawei');
            var huaweiNames=$('#huaweiList');
            for (j in msg['华为']) {
                var phone_detail = msg['华为'][j];
                htm += getPhoneInfo(phone_detail);
            }
            var obj=msg['华为'];
            for(var i=0;i<=obj.length/6;i++){
                for(var j=i*6;j<(i+1)*6&&j<obj.length;j++){
                    name+=setLiInfo(obj[j]);
                }
                names+=setPhoneNameInfo(name);
                name="";
            }

            huawei_lists.html(htm);
           // console.log(names)
            huaweiNames.html(names);

            var xiaomi_lists=$('#xiaomi');
            var xiaomiNames=$('#xiaomiList');
            names="";
            htm="";
            for (j in msg['小米']) {
                var phone_detail = msg['小米'][j];
                htm += getPhoneInfo(phone_detail);
            }
            xiaomi_lists.html(htm);
            obj=msg['小米'];
            name="";names="";
            for(var i=0;i<=obj.length/6;i++){
                for(var j=i*6;j<(i+1)*6&&j<obj.length;j++){
                    name+=setLiInfo(obj[j]);
                }
                names+=setPhoneNameInfo(name);
                name="";
            }
          //  console.log(names);
            xiaomiNames.html(names)
        }

    })
    }
    function setLiInfo(phone) {
        return '<li><a class="link" href="phone_detail?pid='+phone.phoneId+'"><span class="text">'+phone.name+'</span></a></li>'
    }
    function setPhoneNameInfo(name){
        var htm='<ul class="children-list children-list-col children-list-col-1">'
         htm+=name;
        htm+='</ul>';
        return htm;
    }
    function getPhoneInfo(phone){

        return '<li class="grid-items">'+
        '<div class="figure figure-img">'+
            '<a class="exposure" href="phone_detail?pid='+phone.phoneId+'">'+
            '<img src="/yphone'+phone.url+'" width="160" height="160" alt="">'+
            '</a>'+
            '</div>'+
            '<h3 class="title">'+phone.name+'</h3>'+
            '<p class="desc">'+phone.description+'</p>'+
        '<p class="price">'+phone.price+ '元</p>'+
        '</li>';
    }

