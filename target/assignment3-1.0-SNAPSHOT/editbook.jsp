<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Edit Book</title>
</head>
<body>
<jsp:include page="blocks/header.jsp"/>
<div class="container text-center">
    <div id="row" class="row">
        <c:forEach items="${books}" var="book">
            <div id="${book.getIsbn()}" class="col-xs-12 col-sm-6 col-md-4 col-lg-3 col-xl-3 text-center shadow rounded pt-5 my-5 ${product.getCategory()} ">
                <img src="${book.getImage()}" alt="${book.getName()}"
                     style="height: 200px;max-width: 200px;">
                <h1>${book.getIsbn()}</h1>
                <h2>${book.getName()}</h2>
                <p>${book.getAuthor()}</p>
                <p><b>In Stock</b></p>
                <h4>${book.getStock()}</h4>
                <c:if test="${cookie.role.value=='ADMIN'}">
                    <button type="button" data-toggle="modal" data-target="#exampleModal" id="${book.getIsbn()}"
                            class="btn btn-danger" onclick="deleteProduct(this.id)">
                        Remove
                    </button>
                    <a class="btn btn-warning"
                       href='<%=request.getContextPath()+"/edit?id="%>${book.getIsbn()}'>Edit</a>
                </c:if>

            </div>
        </c:forEach>
    </div>

    <br>

</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Unknown</h5>
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
<jsp:include page="blocks/footer.jsp"/>
</body>
<script>
    $('#myModal').modal(options)

    function deleteProduct(idd) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/assignment3_war/orderremove",
            data: {
                reqValue: idd
            },
            cache: false,
            timeout: 600000,
            success: function (data) {

                setDetail("Success", "The book with id=" + idd + " is removed")
                removeView(idd);
            },
            error: function (response, error, errorThrown) {
                setDetail("Success", "The book with id=" + idd + " is not removed")

            }
        });
    }

    function setDetail(status, message) {
        $('#exampleModalLabel').text(status);
        $('.modal-body ').text(message);
    }
    function removeView(idd){
        $('div#'+idd).addClass("d-none");
    }

</script>
</html>
