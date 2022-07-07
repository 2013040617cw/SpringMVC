<%--
  Created by IntelliJ IDEA.
  User: cuiwei
  Date: 2022/6/13
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--动态获取当前项目路径   a标签是get请求--%>
<a href="${pageContext.request.contextPath}/user/simpleParam?id=1&username=杰克">
    基本类型参数
</a>

<%--获取对象类型的请求参数--%>
<%--该表单提交的请求类型为post类型--%>
    <form action="${pageContext.request.contextPath}/user/pojoParam" method="post">
        编号<input type="text" name="id"><br>
        用户名<input type="text" name="username">
        <input type="submit" value="对象类型参数">
    </form>


<%--获取数组类型的请求参数--%>
<form action="${pageContext.request.contextPath}/user/arrayParam" method="post">
    编号<input type="checkbox" name="ids" value="1"><br>
    <input type="checkbox" name="ids" value="2"><br>
    <input type="checkbox" name="ids" value="3"><br>
    <input type="checkbox" name="ids" value="4"><br>
    <input type="checkbox" name="ids" value="5"><br>
    <input type="submit" value="数组类型参数">
</form>


<%--获取集合类型的请求参数--%>

<form action="${pageContext.request.contextPath}/user/queryParam" method="post">

    搜索关键字：<input type="text" name="keyword">

    user对象：
    <input type="text" name="user.id" placeholder="编号">
    <input type="text" name="user.name" placeholder="性命">

    list集合：
    第一个元素
    <input type="text" name="userList[0].id" placeholder="编号">
    <input type="text" name="userList[0].username" placeholder="姓名">

    第二个元素
    <input type="text" name="userList[1].id" placeholder="编号">
    <input type="text" name="userList[1].username" placeholder="姓名">

    map集合:

    第一个元素
    <input type="text" name="userMap['u1'].id" placeholder="编号">
    <input type="text" name="userMap['u1'].username" placeholder="姓名">

    第二个元素：
    <input type="text" name="userMap['u2'].id" placeholder="编号">
    <input type="text" name="userMap['u2'].username" placeholder="姓名">

    <input type="submit" value="复杂类型参数">

</form>

<%--自定义类型转换器  ： 错误的产生 2021/12/12--%>
<form action="${pageContext.request.contextPath}/user/coverParam" method="post">
   生日：<input type="text" name="birthday">
    <input type="submit" value="自定义类型转换器">
</form>

<%--演示@RequestParam标签--%>
<a href="${pageContext.request.contextPath}/user/findByPage?pageNo=2">分页查询</a>
</body>

</html>
