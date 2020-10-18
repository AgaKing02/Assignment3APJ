<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 15.10.2020
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>controllers.Main</title>
</head>
<body>
<jsp:include page="blocks/header.jsp"/>

<div class="container text-center">
    <form class="row" action="<%=request.getContextPath()%>/confirm" method="post">
        <c:forEach items="${products}" var="product">
            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 col-xl-2 text-center shadow rounded pt-5 my-5">

                <img src="${product.getImage_url()}" alt="${product.getName()}" style="height: 200px;max-width: 200px;">
                <h2>${product.getName()}</h2>
                <p>${product.getCategory()}</p>
                <p><b>Size:</b></p>
                <h4>${product.getSize()}</h4>
                <h4><b>Price:</b></h4><br>
                <b><h3>${product.getPrice()} tg</h3></b>
                <div>
                    <input type="checkbox" id="${product.getName()}" name="products" value="${product.getName()}">
                    <label for="${product.getName()}">Add to Cart</label>
                </div>


<%--                <p><a class="btn btn-secondary" th:href="'/'+${food.getCategory()}+'/'+${food.getName()}" role="button">View--%>
<%--                    details »</a></p>--%>

<%--                <div class="row text-center">--%>
<%--                    <a class="btn btn-success mb-4 mx-4" th:href="'/food/edit/'+${food.getID()}"--%>
<%--                        role="button">Edit--%>
<%--                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-tools" fill="currentColor"--%>
<%--                             xmlns="http://www.w3.org/2000/svg">--%>
<%--                            <path fill-rule="evenodd"--%>
<%--                                  d="M0 1l1-1 3.081 2.2a1 1 0 0 1 .419.815v.07a1 1 0 0 0 .293.708L10.5 9.5l.914-.305a1 1 0 0 1 1.023.242l3.356 3.356a1 1 0 0 1 0 1.414l-1.586 1.586a1 1 0 0 1-1.414 0l-3.356-3.356a1 1 0 0 1-.242-1.023L9.5 10.5 3.793 4.793a1 1 0 0 0-.707-.293h-.071a1 1 0 0 1-.814-.419L0 1zm11.354 9.646a.5.5 0 0 0-.708.708l3 3a.5.5 0 0 0 .708-.708l-3-3z"/>--%>
<%--                            <path fill-rule="evenodd"--%>
<%--                                  d="M15.898 2.223a3.003 3.003 0 0 1-3.679 3.674L5.878 12.15a3 3 0 1 1-2.027-2.027l6.252-6.341A3 3 0 0 1 13.778.1l-2.142 2.142L12 4l1.757.364 2.141-2.141zm-13.37 9.019L3.001 11l.471.242.529.026.287.445.445.287.026.529L5 13l-.242.471-.026.529-.445.287-.287.445-.529.026L3 15l-.471-.242L2 14.732l-.287-.445L1.268 14l-.026-.529L1 13l.242-.471.026-.529.445-.287.287-.445.529-.026z"/>--%>
<%--                        </svg>--%>
<%--                    </a>--%>
<%--                    <form th:action="'/food/remove/'+${food.getID()}"--%>
<%--                          method="post">--%>
<%--                        <input type="submit" value="Remove" class="btn btn-danger">--%>
<%--                    </form>--%>
                </div>

        </c:forEach>
        <br>
        <div class="text-center"><input type="submit" class="btn btn-outline-primary" value="Add to Cart"></div>

    </form>
</div>
<a class="btn btn-success" style="margin-left: 15px;" href='<%=request.getContextPath()+"/main?sort_by=price"%>'>Sort by Price</a>
<jsp:include page="blocks/footer.jsp"/>

</body>
</html>
