<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/16 0016
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.mall.service.order.Order" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改订单</title>
</head>
<body>
    <%
        Order order = (Order) request.getAttribute("order");
    %>
  <%--  <%
         if(order == null){
    %>
     <form action="/order.do?_method=save" method="post">
         订单编号:<input type="text" name="dd_id" value=""><br/><br/>
         用户id:<input type="text" name="yh_id" value=""><br/><br/>
        &lt;%&ndash; 卖家id:<input type="text" name="mai_id" value=""><br/><br/>&ndash;%&gt;
         商品名称:<input type="text" name="shp_mch" value=""><br/><br/>
         总价:<input type="text" name="zje" value=""><br/><br/>
         收货人:<input type="text" name="shhr" value=""><br/><br/>
         收获地址:<input type="text" name="dzh_mch" value=""><br/><br/>
         订单进度:<select name="jdh">
                      <option>0</option>
                      <option>1</option>
                      <option>2</option>
                      <option>3</option>
                   </select>
          <br/><br/>
         创建时间:<input type="date" name="chjshj" value=""><br/><br/>
         预计送达时间:<input type="date"  name="yjsdshj" value=""><br/><br/>
         <input type="submit" value="保存">
         <input type="reset" value="重置">
     </form>
      <%
          }
      %>--%>

   <%-- <%
        if(order != null){
    %>--%>
    <form action="/order.do?_method=modifySave" method="post">
        订单编号:<input type="text" name="dd_id" readonly="readonly" value="<%=order.getDd_id()%>"><br/><br/>
        <p style="display: none">用户id:<input   type="text" name="yh_id" value="<%=order.getYh_id()%>">
            卖家id:<input   type="text" name="mai_id" value="<%=order.getMai_id()%>"></p>
        商品名称:<input type="text" name="shp_mch" value="<%=order.getShp_mch()%>"><br/><br/>
        总价:<input type="text" name="zje" value="<%=order.getZje()%>"><br/><br/>
        收货人:<input type="text" name="shhr" value="<%=order.getShhr()%>"><br/><br/>
        收获地址:<input type="text" name="dzh_mch" value="<%=order.getDzh_mch()%>"><br/><br/>
        订单进度:<select name="jdh" value="<%=order.getJdh()%>" >
        <option>0</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
    </select>
        <br/><br/>
        创建时间:<input type="date" name="chjshj" value="<%=order.getChjshj()%>"><br/><br/>
        <p style="display: none">预计送达时间:<input type="date"  name="yjsdshj" value="<%=order.getYjsdshj()%>"></p>
        <input type="submit" value="保存">
        <input type="reset" value="重置">
    </form>
   <%-- <%
        }
    %>--%>
</body>
</html>
