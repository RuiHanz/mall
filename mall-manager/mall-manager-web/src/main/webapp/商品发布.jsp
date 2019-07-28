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
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.mall.service.utils.JdbcUtils" %>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="com.mall.service.markAndclass.Mark" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanListHandler" %>
<%@ page import="org.apache.commons.dbutils.ResultSetHandler" %>
<%@ page import="javax.sql.DataSource" %>

<html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>海哥电脑城</title>
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
                    <i class="fa fa-fw fa-sign-out"></i>Logout</a>
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
            <li class="breadcrumb-item active">商品管理</li>
        </ol>

        <!-- Example DataTables Card-->
        <div class="card mb-3">
            <div class="card-header">
                <i class="fa fa-table"></i> 商品上架 </div>

                <div class="row">
                    <div class="col-sm-12 col-md-6">
                        <div id="dataTable_filter" class="dataTables_filter">
                            <form action="/addProduct.do" style="margin-left:50px;margin-top: 10px " method="post" >

                                    <tr><td class="label">编辑商品名称：</td><br/><td><br/><input name="shp_mch" type="text"  class="form-control"  /></td></tr><br/>
                                    <tr><td class="label">设置商品分类：<br/></td><br/>
                                        <td>
                                            <span >一级分类：</span>
                                            <select name="type1" size="1" class="custom-select" >
                                                <option value="0" selected >电脑整机</option>
                                                <option value="0" >电脑整机</option>
                                                <option value="0" >电脑整机</option>
                                            </select>&nbsp;&nbsp;
                                            <span>二级分类：</span>
                                            <select name="type2" size="1" class="custom-select">
                                                <option value="0" selected>笔记本电脑</option>
                                                <option value="1" >台式机</option>
                                                <option value="2" >服务器/工作站</option>
                                                <option value="3" >一体机</option>
                                            </select><br/>

                                        </td></tr>

                                    </td>
                                    </tr>


                                <%
                                    List<Mark> list=new ArrayList<>();
                                    List<String> list1=new ArrayList<String>();
                                    ResultSet rs=null;
                                    Mark mark=new Mark();
                                    Connection connection=null;
                                    Statement stmt=null;
                                    String sql="select ppmch from mark";
                                    connection=JdbcUtils.getConnection();
                                    stmt=connection.createStatement();
                                    try{
                                        rs=stmt.executeQuery(sql) ;
                                        while(rs.next()){
                                            list1.add(rs.getString("ppmch"));
                                        }
                                    }catch(SQLException ex){
                                        System.out.println(ex.getMessage());
                                    }

                                %>


                                <br/><tr><td class="label">品牌名称：</td><td><select name="ppmch" class="custom-select"><%for (int i=0;i<list1.size();i++){
                                        %><option value=<%=list1.get(i)%>><%=list1.get(i)%></option>
                                        <%}%>
                                    </select></td></tr>&nbsp;&nbsp;
<%--                                    <tr><td class="label">商品种类：</td><td><input name="shp_zhl" type="text"  class="form-control" ></td></tr>--%>
                                <span>处理器型号：</span>
                                <select name="cpu"  class="custom-select">
                                    <option value="i3" selected>i3</option>
                                    <option value="i5" >i5</option>
                                    <option value="i7" >i7</option>
                                    <option value="奔腾处理器" >奔腾处理器</option>
                                    <option value="迈腾处理器" >迈腾处理器</option>
                                </select><br/><br/>




<%--                                <tr>处理器型号：<td><input name="cpu" type="text" class="form-control"  style="width: 150px" placeholder="处理器型号"></td></tr>--%>
                                <span>内存型号：</span>
                                <select name="ram" class="custom-select">
                                    <option value="4G" selected>4G</option>
                                    <option value="8G" >8G</option>
                                    <option value="16G" >16G</option>
                                </select>&nbsp;&nbsp;
<%--                                <tr><td class="label">内存型号：</td><td><input name="ram" type="text"  class="form-control" style="width: 150px"></td></tr>--%>
                                <span>硬盘型号：</span>
                                <select name="caliche" class="custom-select">
                                    <option value="西数500G" selected>西数500G</option>
                                    <option value="西数1T" >西数1T</option>
                                    <option value="西数2T" >西数2T</option>
                                </select><br/>
<%--                                <tr><td class="label">硬盘型号：</td><td><input name="caliche" type="text"  class="form-control" style="width: 150px"></td></tr>--%>
                                <br/><span>显卡型号：</span>
                                <select name="gpu" class="custom-select">
                                    <option value="GTX950" selected>GTX950</option>
                                    <option value="GTX960" >GTX960</option>
                                    <option value="GTX1050Ti" >GTX1050Ti</option>
                                    <option value="GTX970" >GTX970</option>
                                    <option value="GTX1060" >GTX1060</option>
                                    <option value="GTX980Ti" >GTX980Ti</option>
                                    <option value="GTXTitanZ" >GTXTitanZ</option>
                                    <option value="GTXTitanX" >GTXTitanX</option>
                                    <option value="GTX1070" >GTX1070</option>
                                    <option value="GTX1070Ti" >GTX1070Ti</option>
                                    <option value="GTX1080" >GTX1080</option>
                                    <option value="GTX1070Ti" >GTX1070Ti</option>
                                    <option value="RTX2080" >RTX2080</option>
                                    <option value="RTX2080Ti" >RTX2080Ti</option>
                                    <option value="TitanRTX" >TitanRTX</option>
                                </select>&nbsp;&nbsp;
<%--                                <tr><td class="label">显卡型号：</td><td><input name="gpu" type="text"  class="form-control" style="width: 150px"></td></tr>--%>
                                <span>显示器型号：</span>
                                <select name="tv" class="custom-select">
                                    <option value="三星60HZ" selected>三星60HZ</option>
                                    <option value="京东方60HZ" >京东方60HZ</option>
                                    <option value="三星90HZ" >三星90HZ</option>
                                    <option value="京东方90HZ" >京东方90HZ</option>
                                    <option value="三星144HZ" >三星144HZ</option>
                                    <option value="京东方144HZ" >京东方144HZ</option>
                                </select><br/>
<%--                                <tr><td class="label">显示器型号：</td><td><input name="tv" type="text"  class="form-control" style="width: 150px"></td></tr>--%>
                                <br/><td class="label">价格：</td><input type="text" name="jg" onkeyup="this.value=this.value.replace(/\D/g,'')"><br/>
                            <%--                                <tr><td class="label">价格：</td><td><input name="jg" type="text"  class="form-control" style="width: 150px"></td></tr>--%>

                                <br/><span>颜色：</span>
                                <select name="color" class="custom-select">
                                    <option value="红色" selected>红色</option>
                                    <option value="黑色" >黑色</option>
                                    <option value="银色" >银色</option>
                                    <option value="白色" >白色</option>
                                    <option value="金色" >金色</option>
                                    <option value="黄色" >黄色</option>
                                </select>&nbsp;&nbsp;
<%--                                <tr><td class="label">颜色：</td><td><input name="color" type="text"  class="form-control" style="width: 150px"></td></tr>--%>

                                <td class="label">库存数量：</td><input type="text"  name="shp_kc" onkeyup="this.value=this.value.replace(/\D/g,'')"><br/>

<%--                                <tr><td class="label">库存数量：</td><td><input name="shp_kc" type="text"  class="form-control" style="width: 150px"></td></tr>--%>
<%--                                    <tr><td class="label">商品概要介绍：</td><td><textarea name="shp_msh" cols="" rows="" placeholder="商品的概要介绍。该介绍将出现在商品名称下方。" class="textarea"></textarea></td></tr>--%>
                                </table><br/>
                                <input type="submit" class="btn btn-primary" value="发布商品" >


                            </form>
                            <div class="card-footer small text-muted"></div>
                        </div>
                    </div>
                </div>
        </div>


    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © 海哥电脑城 2019 / 后端管理 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家"></a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank"></a></small>
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
