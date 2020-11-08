<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01.11.2020
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Reader</title>
</head>
<body>
<jsp:include page="blocks/header.jsp"/>

<div class="row">
    <c:forEach var="user" items="${users}">
        <div class="col-3 border border-danger text-center shadow ${user.getId()}">
            <h1>${user.getName()}</h1>
            <h2>${user.getSurname()}</h2>
            <h2>${user.getUsername()}</h2>
            <button class="btn btn-danger" id="${user.getId()}" onclick="removeReader(this.id)">Remove</button>
            <button class="btn btn-info" id="${user.getId()}" onclick="editReader(this.id)">Edit</button>


        </div>
    </c:forEach>
</div>
<jsp:include page="blocks/footer.jsp"/>

</body>
<script>
    function removeReader(idd) {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/assignment3_war/remove",
            data: {
                reqValue: idd
            },
            cache: false,
            timeout: 600000,
            success: function (data) {
                alert("Success The user with id=" + idd + " is removed")
                removeUserView(idd);
            },
            error: function (response, error, errorThrown) {
                alert("Error  The user with id=" + idd + " is not removed")

            }
        });
    }
    function removeUserView(idd){
        $("div."+idd).addClass("d-none")
    }
</script>
</html>
