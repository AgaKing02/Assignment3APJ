<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01.11.2020
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<jsp:include page="blocks/header.jsp"/>
<div class="card">
    <div class="card-header">
        <i class="fa fa-user"></i>Adding the book<br>

    </div>
    <div class="card-block" style="padding: 24px;">
        <form name="f" action="<%=request.getContextPath()%>/add/book" method="post">
            <fieldset>


                <!-- Login Controls -->
                <div class="form-group">
                    <label for="txtUsername">Name</label>
                    <input type="text" class="form-control" id="txtUsername" name="bookname"
                           placeholder="Name">
                </div>
                <div class="form-group">
                    <label for="txtName">Author</label>
                    <input type="text" class="form-control" id="txtName" name="bookauthor"
                           placeholder="Author">
                </div>
                <div class="form-group">
                    <label for="txtSurname">Image</label>
                    <input type="text" class="form-control" id="txtSurname" name="bookimage"
                           placeholder="Image">
                </div>

                <div class="form-group">
                    <label for="txtPassword">Stock </label>
                    <input type="number" class="form-control" id="txtPassword" name="bookstock"
                           placeholder="Stock">
                </div>


                <!-- Login Button -->
                <div class="form-actions" style="margin-top: 12px;">
                    <button type="submit" class="btn btn-success">Add Book</button>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>
