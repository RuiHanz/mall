<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-labelauty.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<script src="js/footer.js" type="text/javascript"></script>
<script src="js/jquery-labelauty.js" type="text/javascript"></script>
<title>发布商品</title>
</head>

<body>
<head>
 <div id="header_top">
  <div id="top">
    <div class="Inside_pages">
      <div class="Collection"><a href="#" class="green">请登录</a> <a href="#" class="green">免费注册</a></div>
	<div class="hd_top_manu clearfix">
	  <ul class="clearfix">
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="index.jsp">首页</a></li>
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"> <a href="#">我的小充</a> </li>
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">消息中心</a></li>
       <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">商品分类</a></li>
        <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">我的购物车<b>(23)</b></a></li>	
	  </ul>
	</div>
    </div>
  </div>
  <div id="header"  class="header page_style">
  <div class="logo"><a href="index.jsp"><img src="images/logo.png" /></a></div>
  <!--结束图层-->
  <div class="Search">
        <div class="search_list">
            <ul>
                <li class="current"><a href="#">产品</a></li>
                <li><a href="#">信息</a></li>
            </ul>
        </div>
        <div class="clear search_cur">
            <form action="#">
           <input name="searchName" id="searchName" class="search_box" onkeydown="keyDownSearch()" type="text">
           <input name="select" type="submit" value="搜 索"  class="Search_btn"/>
            <select name="type1" size="1">
                <option value="0" selected>全部</option>
                <option value="1" >商品名称</option>
                <option value="2" >商品id</option>
                <option value="3"> 关键词</option>>
            </select>
            </form>
        </div>
        <div class="clear hotword">热门搜索词：香醋&nbsp;&nbsp;&nbsp;茶叶&nbsp;&nbsp;&nbsp;草莓&nbsp;&nbsp;&nbsp;葡萄&nbsp;&nbsp;&nbsp;菜油</div>
</div>
 <!--购物车样式-->
 <div class="hd_Shopping_list" id="Shopping_list">
   <div class="s_cart"><a href="#">我的购物车</a> <i class="ci-right">&gt;</i><i class="ci-count" id="shopping-amount">0</i></div>
   <div class="dorpdown-layer">
    <div class="spacer"></div>
	 <!--<div class="prompt"></div><div class="nogoods"><b></b>购物车中还没有商品，赶紧选购吧！</div>-->
	 <ul class="p_s_list">	   
		<li>
		    <div class="img"><img src="images/tianma.png"></div>
		    <div class="content"><p class="name"><a href="#">产品名称</a></p><p>颜色分类:紫花8255尺码:XL</p></div>
			<div class="Operations">
			<p class="Price">￥55.00</p>
			<p><a href="#">删除</a></p></div>
		  </li>
		</ul>		
	 <div class="Shopping_style">
	 <div class="p-total">共<b>1</b>件商品　共计<strong>￥ 515.00</strong></div>
	  <a href="Shop_cart.html" title="去购物车结算" id="btn-payforgoods" class="Shopping">去购物车结算</a>
	 </div>	 
   </div>
 </div>
</div>
<!--菜单栏-->
	<div class="Navigation" id="Navigation">
		 <ul class="Navigation_name">
			<li><a href="Home.html">首页</a></li>

			<li><a href="http://localhost:8080/商品专区-查询、修改及删除商品.jsp">搜索</a></li>

			<li><a href="Brands.html">联系我们</a></li>
		 </ul>			 
		</div>
	<script>$("#Navigation").slide({titCell:".Navigation_name li",trigger:"click"});</script>
    </div>
</head>
<!--发布商品样式-->
<div class="Inside_pages clearfix">
 <div class="left_style">
<!--列表-->
  <div class="menu_style">
   <ul class="menu_list">
    <li ><em></em><a href="店铺专区.html">店铺专区</a></li>
   </ul>
  </div>
</div>
<div class="right_style">
  <!--内容详细-->
   <div class="title_style"><em></em>发布商品</div>
    <div class="content_style" action>
     <div class="Release_product_style">
     <form action="/addProduct.do" method="post">
     <table cellpadding="0" cellspacing="0" width="100%">
      <tr>
       <td class="label">店铺/公司名称：</td><td>江苏业祥股份有限公司</td></tr> 
       <tr><td class="label">编辑商品标题：</td><td><input name="shp_mch" type="text"  class="addtext"  style=" width:500px;"/></td></tr>
       <tr><td class="label">设置商品分类：</td>
           <td>
               <span>一级分类：</span>
                   <select name="type1" size="1">
                       <option value="0" selected>电脑整机</option>
                       <option value="1" >电脑配件</option>
                       <option value="2" >电脑外设</option>
                    </select>
               <span>二级分类：</span>
                   <select name="type2" size="1">
                       <option value="0" selected>笔记本电脑</option>
                       <option value="1" >台式机</option>
                       <option value="2" >服务器/工作站</option>
                       <option value="3" >一体机</option>
                   </select>
            </td></tr>

       <div class="add_Spec">
       <a href="#" class="add_Spec_btn"><em class="icon_1"></em>添加分类标签</a><a href="#" class="jx_btn">继续添加</a><a href="#" class="delete_btn">删除</a>
       <!--添加标签隐藏层-->
       <div class="spec_label_style">
<!--        <div class="jx_cz_spec"><a href="#">继续添加</a> <span>最多只能添加5张图片</span></div>-->
        <div class="tianjia_label">
         <em class="sprite-icon"></em>
<!--        <input name="" type="text"  class="addtext"  style=" width:300px;"/><input name="" type="submit" value="添加"  class="add_submit"/></div>-->
       </div>
       </div>

     </div>
       </td>
       </tr>
       <tr><td class="label">品牌名称：</td><td><input name="ppname" type="text"  class="addtext" style=" width:200px;"/></td></tr>
         <tr><td class="label">商品种类：</td><td><input name="shp_zhl" type="text"  class="addtext" style=" width:200px;"/></td></tr>
       <tr><td class="label">处理器型号：</td><td><input name="cpu" type="text"  class="addtext" style=" width:200px; float:left" /></td></tr>
         <tr><td class="label">内存型号：</td><td><input name="ram" type="text"  class="addtext" style=" width:200px;"/></td></tr>
         <tr><td class="label">硬盘型号：</td><td><input name="caliche" type="text"  class="addtext" style=" width:200px;"/></td></tr>
         <tr><td class="label">显卡型号：</td><td><input name="gpu" type="text"  class="addtext" style=" width:200px;"/></td></tr>
         <tr><td class="label">显示器型号：</td><td><input name="tv" type="text"  class="addtext" style=" width:200px;"/></td></tr>
         <tr><td class="label">价格：</td><td><input name="jg" type="text"  class="addtext" style=" width:200px;"/></td></tr>
         <tr><td class="label">颜色：</td><td><input name="color" type="text"  class="addtext" style=" width:200px;"/></td></tr>
         <tr><td class="label">仓库id：</td><td><input name="ck_id" type="text"  class="addtext" style=" width:200px;"/></td>
             <td class="label">库存数量：</td><td><input name="shp_kc" type="text"  class="addtext" style=" width:200px;"/></td>
         </tr>
         <tr><td class="label">商品概要介绍：</td><td><textarea name="shp_msh" cols="" rows="" placeholder="商品的概要介绍。该介绍将出现在商品名称下方。" class="textarea"></textarea></td></tr>
       <tr><td class="label">商品宣传图片：</td><td>
<!--       <table class="Publicize_img_style">-->
<!--        -->
<!--         <td>-->
<!--         <div class="file-uploader-wrap"> -->
<!--　　　　　　<input type="file" class="file-uploader" name="uploadDataField" id="FileUploader"/> -->
<!--　　　　　　<div class="file-uploader-wrap-fake"> -->
<!--　　　　　　<input type="text" id="PathDisplayer" class="input-text" disabled /> -->
<!--　　　　　　　　<a href="javascript:void(0)" class="link-btn" >选择文件</a> -->
<!--　　　　　　</div> -->
<!--　　　　</div> -->
<!--</td><td><input name="" type="checkbox" value="" /></td></tr>-->
<!--        </table>-->
       </td></tr>
<!--       <tr><td class="label">商品详细介绍：</td><td>富文本编辑器</td></tr>-->
     </table>
         <input type="submit" value="提交商品资料 " >
         <!--/mall-manager/mall-manager-web/-->
<%--         <a href="http://localhost:8080/mall/ActionServlet?method=addProduct" >提交商品资料</a>--%>
<!--     <a href="" class="Next_btn">提交商品资料</a>-->
     </form>
     </div>
    </div>
  </div>
</div>
<script type="text/javascript">
$(function(){
	$(':input').labelauty();
});
</script>
<!--网站地图-->
<div class="fri-link-bg clearfix">
    <div class="fri-link">
        <div class="logo left margin-r20"><img src="images/fo-logo.jpg" width="152" height="81" /></div>
        <div class="left"><img src="images/qd.jpg" width="90"  height="90" />
            <p>扫描下载APP</p>
        </div>
       <div class="">
    <dl>
	 <dt>新手上路</dt>
	 <dd><a href="#">售后流程</a></dd>
     <dd><a href="#">购物流程</a></dd>
     <dd><a href="#">订购方式</a> </dd>
     <dd><a href="#">隐私声明 </a></dd>
     <dd><a href="#">推荐分享说明 </a></dd>
	</dl>
	<dl>
	 <dt>配送与支付</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
	<dl>
	 <dt>售后保障</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
	<dl>
	 <dt>支付方式</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>	
    <dl>
	 <dt>帮助中心</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
     <dl>
	 <dt>帮助中心</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>
     <dl>
	 <dt>帮助中心</dt>
	 <dd><a href="#">保险需求测试</a></dd>
     <dd><a href="#">专题及活动</a></dd>
     <dd><a href="#">挑选保险产品</a> </dd>
     <dd><a href="#">常见问题 </a></dd>
	</dl>	   
   </div>
    </div>
</div>
<!--网站地图END-->
<!--网站页脚-->
<div class="copyright">
    <div class="copyright-bg">
        <div class="hotline">为生活充电在线 <span>招商热线：****-********</span> 客服热线：400-******</div>
        <div class="hotline co-ph">
            <p>版权所有Copyright ©***************</p>
            <p>*ICP备***************号 不良信息举报</p>
            <p>总机电话：****-*********/194/195/196 客服电话：4000****** 传 真：********
                
                E-mail:****@****.gov.cn</p>
        </div>
    </div>
</div>
</body>
</html>
