
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp"%>
<html>
    <body>
    <script>backgroundShift();</script>
    <div class="container">
        <div id = "content" class = "card content">
            <div class = "card-header text-center">
                This is the launching off point for the page.
            </div>
            <div class = "card-body text-center">
                <br />    <a class = "btn" href="/WorldOfFutureDarkness/admin/index.jsp">Link to the admin pages</a>
                <br />    <a class = "btn" href="/WorldOfFutureDarkness/gamemaster/index.jsp">Link to the Game Master pages</a>
                <br />    <a class = "btn" href="/WorldOfFutureDarkness/player/index.jsp">Link to the player pages</a>
                <br />    <a class = "btn" href="/WorldOfFutureDarkness/logout.jsp">logout</a>
                <br />    <a class = "btn" href="/WorldOfFutureDarkness/createNewUser.jsp">Create an Account</a>
                <br />    <a class = "btn" href="/WorldOfFutureDarkness/contact.jsp">Contact The Administration</a>
            </div>
            <div class = "card-footer text-center">
                <%@ include file="foot.jsp"%>
            </div>
        </div>
        <script>center()</script>
    </div>
    </body>
</html>
