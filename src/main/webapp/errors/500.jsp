<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/23/18
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR - 500</title>
</head>
<body>
<div class = "container">
    <div id = "content" class = "card content">
        <div class = "card-header text-center">
            500:
        </div>

        <div class = "card-body text-center">
            There was an internal server error.
            <%@ include file="../homeButton.jsp"%>
        </div>

        <div class = "card-footer text-center">
            <%@ include file="../foot.jsp"%>
        </div>
    </div>
</div>
</body>
</html>

