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
    <script>backgroundShift();</script>
    <div class = "container">
        <div id = "content">

            <FORM ACTION="/WorldOfFutureDarkness/j_security_check" METHOD="POST">
                <TABLE>
                    <TR>
                        <TD>User name:  </TD>
                        <TD><INPUT TYPE="TEXT" NAME="j_username"></TD>
                    </TR>
                    <TR>
                        <TD>Password:  </TD>
                        <TD><INPUT TYPE="PASSWORD" NAME="j_password"></TD>
                    </TR>
                    <TR>
                        <TH colspan="2" class = "text-center"><INPUT TYPE="SUBMIT" VALUE="Log In"></TH>
                    </TR>
                </TABLE>
            </FORM>
        </div>
        <%@ include file="foot.jsp"%>
        <a href="/WorldOfFutureDarkness/createNewUser.jsp">Create an Account</a>
    </div>
</body>
</html>
