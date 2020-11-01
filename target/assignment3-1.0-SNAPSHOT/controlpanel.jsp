<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01.11.2020
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ControlPanel</title>
</head>
<body>
<jsp:include page="blocks/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-2 btn btn-light">
            <a href='<%=request.getContextPath()+"/add/book"%>'>Add Book</a></div>
        <div class="col-2 btn btn-light"><a href='<%=request.getContextPath()+"/books"%>'>Edit Book</a></div>
        <div class="col-2 btn btn-light"><a href='<%=request.getContextPath()+"/signup"%>'>Add Reader</a></div>
        <div class="col-2 btn btn-light"><a href='<%=request.getContextPath()+"/reader"%>'>Edit Reader</a></div>
        <div class="col-2 btn btn-light"><a href='<%=request.getContextPath()+"/assign/book"%>'>Assign Book</a></div>

    </div>
</div>
<jsp:include page="blocks/footer.jsp"/>
</body>
<script>

</script>
</html>
