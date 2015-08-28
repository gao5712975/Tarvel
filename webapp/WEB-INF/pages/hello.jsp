<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2015/7/10 0010
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <style>
        body{
            margin: 0 auto;
            padding: 0 ;
        }
        .login{
            width: 400px;
            height: 300px;
            background-color: #ccc;
            margin: 0 auto;
        }
        .user{
            padding: 100px 75px;
        }
    </style>
    <title></title>
</head>
<body>
<div class="login">
    <form action="login.do" method="post">
        <div class="user">
            <label style="display: inline-block;">用户名： <input name="username" type="text"/></label>
            <label style="display: inline-block;">密码： <input name="password" type="password"/></label>
            <label style="display: inline-block"><input type="submit" value="提交"/></label>
        </div>
    </form>
</div>
</body>
</html>
