<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp"%>
<html>
    <body>
        <div class="container-fluid">
            <div id = "content" class = "card content">
                <div class = "card-header text-center">
                    Error!
                </div>

                <div class = "card-body text-center">
                    <h1>${warning}</h1>
                    <br />
                    <div class = "col-12 col-sm-4 text-sm-right text-left float-sm-left">Reason:</div>
                    <div class = "col-12 col-sm-8 text-left float-sm-right">${error}</div>

                    <%@ include file="homeButton.jsp"%>
                </div>

                <div class = "card-footer text-center">
                    <%@ include file="foot.jsp"%>
                </div>
            </div>
        </div>
    </body>
</html>
