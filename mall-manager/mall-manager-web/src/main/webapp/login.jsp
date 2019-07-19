<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-7-18
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SB Admin - Start Bootstrap Template</title>
    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">登录</div>
        <div class="card-body">
            <form action="/login.do">
                <div class="form-group">
                    <label for="exampleInputEmail1">手机号</label>
                    <input class="form-control" required="手机号没输" id="exampleInputEmail1" name="phoneNumber" type="text" aria-describedby="emailHelp" placeholder="请输入手机号">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input class="form-control" required="你tm密码不输怎么登录" id="exampleInputPassword1" name="password" type="password" placeholder="请输入密码">
                </div>
<%--                <div class="form-group">--%>
<%--                    <div class="form-check">--%>
<%--                        <label class="form-check-label">--%>
<%--                            <input class="form-check-input" type="checkbox"> Remember Password</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <input class="btn btn-primary btn-block" type="submit" value="登录" >

            </form>
            <div class="text-center">
<%--                <a class="d-block small mt-3" href="register.jsp">Register an Account</a>--%>
                <a class="d-block small" href="forgot-password.jsp">忘记密码?这他妈都能忘?</a>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
