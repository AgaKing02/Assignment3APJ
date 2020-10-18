<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 18.10.2020
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<jsp:include page="blocks/header.jsp"/>
<c:forEach var="type" items="${hash}">
    Key is ${type.key}
    Value is ${type.value}
    <br>
</c:forEach>
<c:forEach var="order" items="${my}">
    Order
  <p>${order.getId()}</p>
    <br>
</c:forEach>
<jsp:include page="blocks/footer.jsp"/>


</body>
</html>
