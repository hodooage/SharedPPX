<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/6
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
    <title>测试页面</title>
</head>
<body>
    <form action="client/userLogin" method="post">
        账号：<input type="text" name="username"/><br>
        密码：<input type="text" name="password"/><br>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
