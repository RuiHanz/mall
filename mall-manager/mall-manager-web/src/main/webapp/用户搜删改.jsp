<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-7-18
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="false" %>
<html>
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
    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.jsp">海哥电脑城后端管理</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">

            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
            <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
                <i class="fa fa-fw fa-wrench"></i>
                <span class="nav-link-text">商品管理</span>
            </a>
            <ul class="sidenav-second-level collapse" id="collapseComponents">
                <li>
                    <a href="商品发布.jsp">商品上架</a>
                </li>
                <li>
                    <a href="tables.jsp">商品查询、下架及修改</a>
                </li>
                <li>
                    <a href="添加品牌.jsp">添加品牌</a>
                </li>
                <li>
                    <a href="品牌查删改.jsp">品牌查询、下架及修改</a>
                </li>
            </ul>
        </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-sitemap"></i>
                    <span class="nav-link-text">用户管理</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseMulti">
                    <li>
                        <a href="用户搜删改.jsp">用户查询、删除、封禁与解封</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                <a class="nav-link" href="ordertables.jsp">
                    <i class="fa fa-fw fa-table"></i>
                    <span class="nav-link-text">订单管理</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
                <a class="nav-link" href="评论管理.jsp">
                    <i class="fa fa-fw fa-area-chart"></i>
                    <span class="nav-link-text">评论管理</span>
                </a>
            </li>
<%--            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">--%>
<%--                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">--%>
<%--                    <i class="fa fa-fw fa-sitemap"></i>--%>
<%--                    <span class="nav-link-text">Menu Levels</span>--%>
<%--                </a>--%>
<%--                <ul class="sidenav-second-level collapse" id="collapseMulti">--%>
<%--                    <li>--%>
<%--                        <a href="#">Second Level Item</a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a href="#">Second Level Item</a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a href="#">Second Level Item</a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti2">Third Level</a>--%>
<%--                        <ul class="sidenav-third-level collapse" id="collapseMulti2">--%>
<%--                            <li>--%>
<%--                                <a href="#">Third Level Item</a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="#">Third Level Item</a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="#">Third Level Item</a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </li>--%>
<%--            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">--%>
<%--                <a class="nav-link" href="#">--%>
<%--                    <i class="fa fa-fw fa-link"></i>--%>
<%--                    <span class="nav-link-text">Link</span>--%>
<%--                </a>--%>
<%--            </li>--%>
        </ul>
        <ul class="navbar-nav sidenav-toggler">
            <li class="nav-item">
                <a class="nav-link text-center" id="sidenavToggler">
                    <i class="fa fa-fw fa-angle-left"></i>
                </a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-fw fa-envelope"></i>
                    <span class="d-lg-none">信息
              <span class="badge badge-pill badge-primary">12 New</span>
            </span>
                    <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
                </a>
                <div class="dropdown-menu" aria-labelledby="messagesDropdown">
                    <h6 class="dropdown-header">信息:</h6>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        <strong>David Miller</strong>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        <strong>Jane Smith</strong>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        <strong>John Doe</strong>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item small" href="#">View all messages</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-fw fa-bell"></i>
                    <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
                    <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
                </a>
                <div class="dropdown-menu" aria-labelledby="alertsDropdown">
                    <h6 class="dropdown-header">New Alerts:</h6>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item small" href="#">View all alerts</a>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                    <i class="fa fa-fw fa-sign-out"></i>退出</a>
            </li>
        </ul>
    </div>
</nav>

<div class="content-wrapper">
    <div class="container-fluid">
        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
            </li>
            <li class="breadcrumb-item active">用户管理</li>
        </ol>

        <!-- Example DataTables Card-->
        <div class="card mb-3">
            <div class="card-header">
                <i class="fa fa-table"></i> 用户管理 </div>
            <form action="/selectUser.do" method="post" style="margin: 30px 30px ">
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                        <div id="dataTable_filter" class="dataTables_filter form-inline">

                            <label>

                                <select name="selectType" size="1" class="form-control">
                                    <option value="0" selected>全部</option>
                                    <option value="1" >用户名称</option>
                                    <option value="2" >用户手机号</option>
                                </select>&nbsp;&nbsp;
                                <input type="search" name="searchName" class="form-control form-control-sm" placeholder="" aria-controls="dataTable">&nbsp;&nbsp;
                                <input name="select" type="submit" class="btn btn-primary" value="搜 索"  class="Search_btn"/>
                            </label>
                        </div>
                    </div>
                </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th align="center" style="text-align: center">用户名称</th>
                            <th align="center" style="text-align: center">用户姓名</th>
                            <th align="center" style="text-align: center">用户性别</th>
                            <th align="center" style="text-align: center">用户手机号</th>
                            <th align="center" style="text-align: center">用户邮箱</th>
                            <th align="center" style="text-align: center">用户住址</th>
                            <th align="center" style="text-align: center">用户状态</th>
                            <th align="center" style="text-align: center" colspan="3">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${pageBean.list}" varStatus="vs">
<%--                        <c:forEach items="${userList}" var="user">--%>
                        <tr>

                            <td align="center">${user.yh_mch}</td>
                            <td align="center">${user.yh_xm}</td>
                            <c:if test="${user.yh_xb == '1'}">
                                <td align="center">男</td>
                            </c:if>
                            <c:if test="${user.yh_xb == '0'}">
                                <td align="center">女</td>
                            </c:if>
                            <c:if test="${user.yh_xb == ''}">
                                <td align="center">男</td>
                            </c:if>

                            <td align="center">${user.yh_shjh}</td>
                            <td align="center">${user.yh_yx}</td>
                            <td align="center">${user.yh_jg}</td>
                            <c:if test="${user.yh_zht == '0'}">
                                <td align="center">正常</td>
                            </c:if>
                            <c:if test="${user.yh_zht == '1'}">
                                <td align="center">封禁</td>
                            </c:if>
                            <td align="center"><a href="javascript:if(confirm('确定删除吗?'))location='/updateUser.do?yh_id=${user.yh_id}&currentPage=${requestScope.pageBean.currentPage}&handle=delete';">删除</a></td>
                            <td align="center"><a href="javascript:if(confirm('确定封禁吗?'))location='/updateUser.do?yh_id=${user.yh_id}&currentPage=${requestScope.pageBean.currentPage}&handle=close';">封禁</a></td>

                            <td align="center"><a href="javascript:if(confirm('确定解封吗?'))location='/updateUser.do?yh_id=${user.yh_id}&currentPage=${requestScope.pageBean.currentPage}&handle=open';">解封</a></td>

                        </tr>
                        </c:forEach>

                        </tbody>
                        <tr>
                             <td colspan="10" align="right" >

                             <a href="${pageContext.request.contextPath }/selectUser.do?selectType=0&currentPage=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                             <a href="${pageContext.request.contextPath }/selectUser.do?selectType=0&currentPage=${requestScope.pageBean.currentPage - 1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                             <a href="${pageContext.request.contextPath }/selectUser.do?selectType=0&currentPage=${requestScope.pageBean.currentPage + 1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                             <a href="${pageContext.request.contextPath }/selectUser.do?selectType=0&currentPage=${requestScope.pageBean.totalPage}">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <font face="微软雅黑">第</font>${requestScope.pageBean.currentPage}<font face="微软雅黑">页/共</font>${requestScope.pageBean.totalPage}<font face="微软雅黑">页</font>
                                
                        </td>
                        </tr>
                    </table>
                </div>
            </div>
            </form>
<%--            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>--%>
        </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © 海哥电脑城 2019 / 后端管理 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">海哥电脑城</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">海哥之家</a></small>
            </div>
        </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
</div>
</body>

</html>
