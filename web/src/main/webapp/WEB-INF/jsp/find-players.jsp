<%--
  Created by IntelliJ IDEA.
  User: Zhenya
  Date: 11.11.2018
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>players</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/find-players" method="post">
    <select name="club" id="club">
        <option></option>
        <c:forEach var="club" items="${requestScope.clubs}">
            <option value="${club.id}">${club.name}</option>
        </c:forEach>
    </select><br>

    <label>Дата before:
        <input type="date" name="dateBefore">
    </label><br>

    <label>Дата after:
        <input type="date" name="dateAfter">
    </label><br>

    <input type="radio" name="position" value="GOALKEEPER"> Вратарь
    <input type="radio" name="position" value="DEFENDER"> Защитник
    <input type="radio" name="position" value="MIDFIELDER"> Полузащитник
    <input type="radio" name="position" value="FORWARD"> Нападающий <br>
    <input type="submit" value="Поиск">
</form>
</body>
</html>