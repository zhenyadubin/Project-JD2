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
    Клуб
    <select name="club" id="club">
        <option></option>
        <c:forEach var="club" items="${requestScope.clubs}">
            <option value="${club.id}">${club.name}</option>
        </c:forEach>
    </select><br>

    <label>Родился с:
        <input type="date" name="dateBefore">
    </label>

    <label>по:
        <input type="date" name="dateAfter">
    </label><br>

    Позиция:
    <input type="radio" name="position" value="GOALKEEPER"> Вратарь
    <input type="radio" name="position" value="DEFENDER"> Защитник
    <input type="radio" name="position" value="MIDFIELDER"> Полузащитник
    <input type="radio" name="position" value="FORWARD"> Нападающий <br>

    <p>Сколько игроков показывать в списке?</p>
    <p><input type="number" name="limit" value="2" min="2" max="10" step="1"></p>

    <input type="submit" value="Поиск">
</form>
</body>
</html>
