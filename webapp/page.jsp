<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2015/7/10 0010
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。
    pageContext.setAttribute("path", path);
    pageContext.setAttribute("basePath", basePath);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link rel="stylesheet" type="text/css" href="${pageScope.basePath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageScope.basePath}/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageScope.basePath}/css/menus/default.css">
<script type="text/javascript" src="${pageScope.basePath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageScope.basePath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageScope.basePath}/js/common/common.js"></script>
