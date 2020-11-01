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
    <title><%=request.getServletContext().getInitParameter("Order")%>
    </title>
</head>
<body>
<jsp:include page="blocks/header.jsp"/>
<c:if test="${my!=null}">
    <h1 class="text-center border border-warning">My Library</h1>
    <div class="row p-1 text-center">
        <c:forEach var="book" items="${my}">
            <div style="border: 1px solid black"
                 class="col-xs-12 col-sm-6 col-md-4 col-lg-3 col-xl-3 text-center shadow rounded pt-5 my-5 rounded shadow">
                <h1>The Book</h1>
                <img src="${book.getImage()}" alt="${book.getImage()}" style="width: 150px;height: auto;">
                <p>${book.getName()}</p>
                <a class="btn btn-info" href="<%=request.getContextPath()+"/view?="%>${book.getIsbn()}">Read the
                    Book</a>
                <button id="${book.getIsbn()}" onclick="removeBook(this.id)" class="btn btn-outline-danger"
                        type="button" data-toggle="modal" data-target="#exampleModal">Remove
                </button>

            </div>
        </c:forEach>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Success</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body text-center">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${my==null}">
    <h1 class="text-center border border-warning">Your Library is Empty</h1>
</c:if>
<label>
    <input type="text" id="user" value="${cookie.username.value}" class="d-none">
</label>
<jsp:include page="blocks/footer.jsp"/>

</body>
</html>
<script>
    $('#myModal').modal(options)

    function removeBook(idd) {

        let username = $('#user').val();
        $.ajax({
            type: "DELETE",
            url: "localhost:8080/assignment3_war/rest/orders/" + idd + "/" + username,
            success: function () {
                setDetail("Success", "The book with id=" + idd + " is back")
            },
            error: function () {
                setDetail("Error", "The book with id=" + idd + " is not back")

            }

        });
    }



    function setDetail(status, message) {
        $('#exampleModalLabel').text(status);
        $('.modal-body ').text(message);
    }

</script>