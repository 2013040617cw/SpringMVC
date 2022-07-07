<%--
  Created by IntelliJ IDEA.
  User: cuiwei
  Date: 2022/6/28
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--编写一个满足文件上传三要素的表单--%>
<form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data" >

    名称：<input type="text" name="username"><br>
    文件：<input type="file" name="filePic"><br>
        <input type="submit" value="单文件上传">
</form>
</body>
</html>
