<%--
  Created by IntelliJ IDEA.
  User: chenhansen
  Date: 2018/5/21
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/login.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/global.css">

</head>
<body>

<div class="header">
    <div class="container">
        <a class="logo" href="home">
            <img class="imgstyle" src="<%=request.getContextPath()%>/static/images/logo.png" alt="E购网">
        </a>
    </div>
</div>
<div style="margin-top: 10px; background: #fff url('<%=request.getContextPath()%>/static/images/background.jpg') no-repeat center center;background-size: 100% 100%;">
    <div class="public-layout container">
        <div class="form-box login">
            <div class="login-form">
                <div class="tabs-nav">
                    <h2>欢迎登录E购网平台</h2>
                </div>
                <div class="tabs-container">
                    <form class="tabs_form" action="" method="post" id="login_form">
                        <!-- 错误信息 -->
                        <div class="form-group">
                            <div class="error_msg" id="login_error">
                                <!-- 错误信息 范例html
                                <div class="alert alert-warning alert-dismissible fade in" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <strong>密码错误</strong> 请重新输入密码
                                </div>
                                 -->
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
                                </div>
                                <input class="form-control phone" name="phone" id="login_phone" required
                                       placeholder="用户名/手机号" autocomplete="off" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                </div>
                                <input class="form-control password" name="password" id="login_pwd" placeholder="请输入密码"
                                       autocomplete="off" type="password">
                                <!-- <div class="input-group-addon pwd-toggle" title="显示密码"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></div> -->
                                <input class="backurl" type="hidden" name="backurl" value=${backurl}>
                            </div>
                        </div>
                        <div class="checkbox">

                            <a href="javascript:;" class="pull-right" id="resetpwd">忘记密码？</a>
                        </div>

                        <button class="btn btn-large btn-primary btn-lg btn-block submit" id="login_submit"
                                type="button">登录
                        </button>
                        <br>
                        <p class="text-center">没有账号？<a href="javascript:;" id="register">免费注册</a></p>
                    </form>
                </div>
            </div>
        </div>
        <div class="form-box register">
            <div class="tabs-nav">
                <h2>欢迎注册<a href="javascript:;" class="pull-right fz16" id="reglogin">返回登录</a></h2>
            </div>
            <div class="tabs_container">
                <form class="tabs_form" action=" " method="post" id="register_form">
                    <!-- 错误信息 -->
                    <div class="form-group">
                        <div class="error_msg" id="register_error"></div>

                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            </div>
                            <input class="form-control username" name="username" id="register_username" required
                                   placeholder="用户名" maxlength="11" autocomplete="off" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
                            </div>
                            <input class="form-control phone" name="phone" id="register_phone" required
                                   placeholder="手机号" maxlength="11" autocomplete="off" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <input class="form-control code" name="smscode" id="register_sms" placeholder="输入验证码"
                                   type="text">
                            <span class="input-group-btn">
                                  <button class="btn btn-primary getsms" type="button">发送短信验证码</button>
                              </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                            </div>
                            <input class="form-control password" name="password" id="register_pwd" placeholder="请输入密码"
                                   autocomplete="off" type="password">
                            <!-- <div class="input-group-addon pwd-toggle" title="显示密码"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></div> -->
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                            </div>
                            <input class="form-control password1" name="password1" id="register_pwd1"
                                   placeholder="请确认密码" autocomplete="off" type="password">
                            <!-- <div class="input-group-addon pwd-toggle" title="显示密码"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></div> -->
                        </div>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input checked="" id="register_checkbox" type="checkbox"><i></i> 同意<a href="#">E购网用户协议</a>
                        </label>
                    </div>

                    <button class="btn btn-large btn-primary btn-lg btn-block submit" id="register_submit"
                            type="button">注册
                    </button>
                </form>

            </div>
        </div>
    </div>
</div>
<div class="footer-login container clearfix">
    <ul class="links">
        <a href="">
            <li>关于我们</li>
        </a>
        <a href="">
            <li>E购学堂</li>
        </a>
        <a href="">
            <li>联系我们</li>
        </a>
        <a href="">
            <li>企业简介</li>
        </a>
        <a href="">
            <li>新手上路</li>
        </a>
    </ul>
    <!-- 版权 -->
    <p class="copyright">
        © 2018-2020 E购网 版权所有，并保留所有权利<br>
    </p>
</div>

<script src="<%=request.getContextPath()%>/static/js/jquery.1.12.4.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/global.js"></script>
<script src="<%=request.getContextPath()%>/static/js/login.js"></script>
<script>
    $(document).ready(function () {
        var p = '<%=request.getAttribute("p")%>';
        console.log("hansen" + p);
        switch (p) {
            case 'register':
                $('.register').show();
                break;
            default:
                $('.login').show();
        }
        $('#register').click(function () {
            $('.login').fadeOut(150, function () {
                $('.register').fadeIn(150)
            })
        });
        $('#reglogin').click(function () {
            $('.register').fadeOut(150, function () {
                $('.login').fadeIn(150)
            })
        });
    })

</script>

</body>
</html>
