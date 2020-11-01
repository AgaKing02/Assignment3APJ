<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17.10.2020
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<jsp:include page="blocks/header.jsp"/>
<div class="container">
    <div style="width:75%;margin-left: auto;margin-right: auto;margin-top:24px;padding: 24px;">
        <div class="card">
            <div class="card-header">
                <i class="fa fa-user"></i>Register the Reader<br>
            </div>
            <div class="card-block" style="padding: 24px;">
                <form name="f" action="<%=request.getContextPath()%>/signup" method="post">
                    <fieldset>


                        <!-- Login Controls -->
                        <div class="form-group">
                            <label for="txtUsername">Username</label>
                            <input type="text" class="form-control" id="txtUsername" name="txtUsername"
                                   placeholder="Username">
                        </div>
                        <div class="form-group">
                            <label for="txtName">Name</label>
                            <input type="text" class="form-control" id="txtName" name="txtName"
                                   placeholder="Name">
                        </div>
                        <div class="form-group">
                            <label for="txtSurname">Surname</label>
                            <input type="text" class="form-control" id="txtSurname" name="txtSurname"
                                   placeholder="Surname">
                        </div>

                        <div class="form-group">
                            <label for="txtPassword">Password</label>
                            <input type="password" class="form-control" id="txtPassword" name="txtPassword"
                                   placeholder="Password">
                        </div>


                        <!-- Login Button -->
                        <div class="form-actions" style="margin-top: 12px;">
                            <button type="submit" class="btn btn-success">Add Reader</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>
