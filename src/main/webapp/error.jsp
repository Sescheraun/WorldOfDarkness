<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp"%>
<html>
    <body>
        <div class="container">
            <div id = "content" class = "card content">
                <div class = "card-header text-center">
                    Error!
                </div>

                <div class = "card-body text-center">
                    <h1>${warning}</h1>
                    <div class = "col-sm-4 text-right float-left">Reason:</div>
                    <div class = "col-sm-8 text-left float-right">${error}</div>

                    <a class = "btn" href="/WorldOfFutureDarkness/index.jsp">Return</a>
                </div>

                <div class = "card-footer text-center">
                    <%@ include file="foot.jsp"%>
                </div>
            </div>
        </div>
    </body>
</html>
