<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01.11.2020
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="blocks/header.jsp"/>
<c:if test="${book!=null}">
    <c:set value="${book}" var="books" />
</c:if>
<div class="card">
    <div class="card-header">
        <i class="fa fa-user"></i>Adding the book<br>

    </div>
    <div class="card-block" style="padding: 24px;">
        <form name="f" action="<%=request.getContextPath()%>/edit" method="post">
            <fieldset>


                <!-- Login Controls -->
                <div class="form-group">
                    <label for="txtUsername">Name</label>
                    <input type="text" class="form-control" id="txtUsername" name="bookname" value="${books.getName()}"
                           placeholder="Name">
                </div>
                <div class="form-group">
                    <label for="txtName">Author</label>
                    <input type="text" class="form-control" id="txtName" name="bookauthor" value="${books.getAuthor()}"
                           placeholder="Author">
                </div>
                <div class="form-group">
                    <label for="txtSurname">Image</label>
                    <input type="text" class="form-control" id="txtSurname" name="bookimage" value="${books.getImage()}"
                           placeholder="Image">
                </div>

                <div class="form-group">
                    <label for="txtPassword">Stock </label>
                    <input type="number" class="form-control" id="txtPassword" name="bookstock" value="${books.getStock()}"
                           placeholder="Stock">
                </div>
                <div class="form-group">
                    <label for="idd">Id </label>
                    <input type="number" class="form-control d-none" id="idd" name="bookisbn" value="${books.getIsbn()}"
                           placeholder="Stock">
                </div>


                <!-- Login Button -->
                <div class="form-actions" style="margin-top: 12px;">
                    <button type="submit" class="btn btn-success">Edit Book</button>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>
