<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/23/18
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp"%>
<html>
    <body>
    <script>backgroundShift();</script>
    <div class="container">
        <div id = "content" class = "card content">
            <div class = "card-header">
                This is the launching off point for the page.
            </div>
            <div class = "card-body">
                <br />    <a href="/WorldOfFutureDarkness/admin/index.jsp">Link to the admin pages</a>
                <br />    <a href="/WorldOfFutureDarkness/gamemaster/index.jsp">Link to the Game Master pages</a>
                <br />    <a href="/WorldOfFutureDarkness/player/index.jsp">Link to the player pages</a>
                <br />    <a href="/WorldOfFutureDarkness/logout.jsp">logout</a>
                <br />    <a href="/WorldOfFutureDarkness/createNewUser.jsp">Create an Account</a>
            </div>
            <div class = "card-footer">
                <%@ include file="foot.jsp"%>
            </div>
        </div>
        <script>center()</script>
    </div>
    </body>
</html>
