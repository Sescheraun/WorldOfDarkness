<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/23/18
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../head.jsp"%>
<html>
<body>
    <div class="container">
        <div id = "content" class = "card content">
            <div class = "card-header text-center">
                I am the sys-admin, do NOT mess with me.
            </div>

            <div class = "card-body text-center">
                <a class = "btn" href="Manage-Content.jsp">Content Management</a>
                <br />
                <%--<a class = "btn" href="Manage-Users.jsp">User Management</a>--%>
                <%--<br /><br />--%>
                <a class = "btn" href="/WorldOfFutureDarkness">Link to the home page</a>
                <br />
            </div>

            <div class = "card-footer text-center">
                <%@ include file="../foot.jsp"%>
            </div>
        </div>
    </div>
</body>
</html>
