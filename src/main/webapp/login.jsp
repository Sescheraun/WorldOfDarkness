<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/22/18
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="head.jsp"%>
<body>
    <div class = "container">
        <div id = "content">
            <script>backgroundShift();</script>
            <FORM ACTION="j_security_check" METHOD="POST">
                <TABLE>
                    <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
                    <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
                    <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
                </TABLE>
            </FORM>
        </div>
        <%@ include file="foot.jsp"%>
        <a href="createNewUser.jsp">Create an Account</a>
    </div>
</body>
</html>
