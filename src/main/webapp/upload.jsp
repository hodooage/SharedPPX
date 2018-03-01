<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/6
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="uploadImage" method="post" enctype="multipart/form-data">
        用户ＩＤ：<input type="text" name="userId" ><br>
        选择图片：<input type="file" name="image" accept="image/*"/><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
