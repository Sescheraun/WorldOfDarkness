<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/23/18
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goodbye</title>
</head>
<body>
<%@ page session="true"%>

User '<%=request.getRemoteUser()%>', you are the weakest link, goodbye.

<% session.invalidate(); %>

<br/><br/>
</body>
</html>
