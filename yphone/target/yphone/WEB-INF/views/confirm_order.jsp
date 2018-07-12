<%--
  Created by IntelliJ IDEA.
  User: chenhansen
  Date: 2018/7/4
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/global.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/confirm_order.css">

</head>
<body>
<div class="site-topbar">
    <div class="container">
        <div class="topbar-nav">
            <div class="nav-left">
                嗨，欢迎来到
                <span class="cr">E购网</span>
            </div>
            <a href="">网点代售</a>
            <a href="">帮助中心</a>
        </div>
        <div class="topbar-cart">
            <a href="order">我的订单</a>
            <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
            <a href="cart">购物车(<span id="header-cart-total">0</span>)</a>
        </div>
        <div class="topbar-info">
            <div class="dropdown" id="user-item" style="display: block">
                <a  class="dropdown-toggle user-item" data-toggle="dropdown"><%=request.getSession().getAttribute("userName")%></a>
                <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                    <li role="presentation">
                        <a role="menuitem" tabindex="-1" href="user_info">个人中心</a>
                    </li>
                    <li role="presentation">
                        <a role="menuitem" tabindex="-1" href="quitLogin">退出登录</a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>

<div class="header order-herader container">
    <div class="left">
        <div class="logo">
            <a href="home">
                <img class="imgstyle" src="<%=request.getContextPath()%>/static/images/logo.png" alt="E购网" >
            </a>
            <span class="text">确认订单</span>
        </div>

    </div>
    <div class="right">
        <div class="prograss-submit" >
            <img src="<%=request.getContextPath()%>/static/images/prograss_confirm.png">
        </div>
    </div>

</div>

<div class="layout order">
    <div class="hr20"></div>
    <div class="order-address">

        <div class="h">收货地址</div>
        <div class="order-address-list">
            <ul class="clearfix">

                <li id="address-empty" class="address-used">
                    <div class="address-empty">
                        <a class="address-add-btn" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span>新增收获地址</a>
                        <!-- 模态框（Modal） -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">×
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">
                                            </span>添加地址
                                        </h4>
                                    </div>
                                    <div class="modal-body">
                                        <form role="form">
                                            <div class="form-group">
                                                <label for="name">收货人：</label>
                                                <input type="text" class="form-control" id="name" required="true" placeholder="收货人姓名">
                                            </div>
                                            <div class="form-group">
                                                <label for="name">手机号码：</label>
                                                <input type="text" class="form-control" id="phone"    placeholder="请输入11位手机号码">
                                            </div>
                                            <div class="form-group">
                                                <label for="name">收货地址：</label>
                                                <input type="text" class="form-control" id="address" placeholder="选择省-市-区">
                                                <div class="address-info">

                                                    <div class="address-head">
                                                        <div class="right clearfix">
                                                            <a class="cancel">
                                                                <span class="glyphicon glyphicon-remove"></span>
                                                            </a>
                                                        </div>
                                                        <div class="left clearfix">
                                                            <span >------</span>
                                                            <a class="province">省份</a>
                                                            <a class="city">城市</a>
                                                            <a class="district">县区</a>
                                                        </div>


                                                    </div>
                                                    <div class="address-body clearfix">
                                                        <ul class="address-list">


                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="name">详细地址：</label>
                                                <input type="text" class="form-control" id="address-detail" placeholder="如乡、镇、学校等">
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">取消
                                        </button>
                                        <button type="button" class="btn btn-primary" id="address-submit">
                                            保存并使用
                                        </button>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal-dialog -->
                        </div><!-- /.modal -->
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="hr20"></div>
    <div class="order-detail-area">
        <div class="order-detail" id="order-pro-list">
            <table class="table detail table-bordered" >
                <caption class="title">订单详情</caption>
                <thead>
                <tr>
                    <th>商品名称</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>总计</th>
                </tr>
                </thead>

                <tbody>

                <tr>
                    <td>${phoneInfo.name} ${phoneInfo.ram}GB+${phoneInfo.capacity}GB,${phoneInfo.color}</td>
                    <td >${phoneInfo.price}</td>
                    <td id="pnum">${num}</td>
                    <td>${phoneInfo.price*num}</td>
                </tr>
                </tbody>
            </table>

        </div>
        <div class="order-submit">
            <div class="order-submit-info">
                应付总额<b>
                ￥<span id="payableTotal">${phoneInfo.price*num}</span>
            </b>
            </div>
            <div class="order-submit-confirm clearfix">
                <form id="submit_form" action="saveOrder" method="post">
                    <input type="hidden" class="receiver" name="receiver">
                    <input type="hidden" class="price" name="price">
                    <input type="hidden" class="num" name="num">
                    <input type="hidden" class="address" name="address">
                    <input type="hidden" class="phone" name="phone">
                    <input type="hidden" class="phoneId" name="phoneId" value="${phoneInfo.phoneId}">
                </form>
                <a  class="order-submit-btn">
                    提交订单
                </a>
            </div>
        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/static/js/jquery-3.1.1.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/confirm_order.js"></script>
</body>
</html>
