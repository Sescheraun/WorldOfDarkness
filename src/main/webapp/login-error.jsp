<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/22/18
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="head.jsp"%>
<body>
    <div class = "container-fluid">

        <div id = "content" class = "card content">
            <div class = "card-header text-center">
                Login phailled.
            </div>
            <div class = "card-body text-center">
                <br />    <a class = "col-sm-6 col-12 btn" href="/WorldOfFutureDarkness/login.jsp">Try again?</a>
                <br />    <a class = "col-sm-6 col-12 btn" href="/WorldOfFutureDarkness/index.jsp">Return Home</a>
            </div>
            <div class = "card-footer text-center">
                <%@ include file="foot.jsp"%>
            </div>
        </div>
    </div>
</body>
</html>
