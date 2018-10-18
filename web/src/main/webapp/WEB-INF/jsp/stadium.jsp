<%--
  Created by IntelliJ IDEA.
  User: Zhenya
  Date: 14.10.2018
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stadium</title>
</head>
<body>
<p>Название: ${requestScope.stadium.name}</p>
<p>Число мест: ${requestScope.stadium.numberOfSeats}</p>
<p>Город: ${requestScope.stadium.city}</p>
</body>
</html>
