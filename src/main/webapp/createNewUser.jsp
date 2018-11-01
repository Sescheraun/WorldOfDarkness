<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/23/18
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@ include file="head.jsp"%>

    <body>
            <script>backgroundShift();</script>

            <div id = "content">
                Greetings, welcome to the World of Darkness.
                <FORM ACTION="addUser" METHOD="POST">
                    <TABLE>
                        <TR><TD>First Name: </TD><TD><INPUT TYPE="TEXT" NAME="firstName"></TD></TR>
                        <TR><TD>Last Name: </TD><TD><INPUT TYPE="TEXT" NAME="lastName"></TD></TR>
                        <TR><TD>User Name:</TD><TD><INPUT TYPE="TEXT" NAME="userName"></TD></TR>
                        <TR><TD>Email Address:</TD><TD><INPUT TYPE="TEXT" NAME="EMAIL"></TD></TR>
                        <%--<TR><TD>Cell Phone (optional):</TD><TD><INPUT TYPE="TEXT" NAME="cell"></TD></TR>--%>


                        <TR><TD>Password: </TD><TD><INPUT TYPE="PASSWORD" id="password" NAME="password"></TD></TR>

                        <TR><TD>Verify Password: </TD><TD><INPUT TYPE="PASSWORD" id="password2" NAME="password2"></TD></TR>

                        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Sign up">
                    </TABLE>
                </FORM>
                <%@ include file="foot.jsp"%>
            </div>

    </body>



</html>
