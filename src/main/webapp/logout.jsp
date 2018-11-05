<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/23/18
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@ include file="head.jsp"%>
    <body>
            <script>backgroundShift();</script>
            <%@ page session="true"%>

            <div id = "content">
                User '<%=request.getRemoteUser()%>', you are the weakest link, goodbye.
            </div>

            <% session.invalidate(); %>

            <a href="/WorldOfFutureDarkness/index.jsp">return</a>

            <br/><br/>
            <%@ include file="foot.jsp"%>
    </body>
</html>
