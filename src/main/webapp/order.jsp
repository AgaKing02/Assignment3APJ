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
<h1 class="text-center border border-warning">Session Info</h1>
<c:forEach var="type" items="${hash}">
    Key is ${type.key}
    Value is ${type.value}
    <br>
</c:forEach>

<c:if test="${my!=null}">
    <h1 class="text-center border border-warning">Order Info</h1>
    <div class="row p-1">
        <c:forEach var="order" items="${my}">
            <div style="border: 1px solid black" class="col-3 text-center">
                <p>${order.getId()} order</p>
                <p>${order.getProduct_id()} with product_id</p>
                <div class="spinner-border text-warning" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>
<c:if test="${my==null}">
    <h1 class="text-center border border-warning">No orders yet</h1>
</c:if>
<jsp:include page="blocks/footer.jsp"/>


</body>
</html>
