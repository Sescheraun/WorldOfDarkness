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

        <div id = "content" class = "card content">

            <div class = "card-header text-center">
                Enter Credentials:
            </div>

            <div class = "card-body text-center">
                <FORM  class = "text-center" ACTION="/WorldOfFutureDarkness/j_security_check" METHOD="POST">

                    <div class = "row" id = "userNameRow">

                        <div class = "col-12 col-sm-5 text-right">
                            <label for = "j_username">User Name</label>
                        </div>

                        <div class = "col-12 col-sm-7 text-left">
                            <INPUT TYPE="TEXT" id = "j_username" NAME="j_username"></TD>
                        </div>
                    </div>
                    <div class = "row" id = "passwordRow">

                        <div class = "col-12 col-sm-5 text-right">
                            <label for = "j_password">Password</label>
                        </div>

                        <div class = "colo-12 col-sm-7 text-left">
                            <INPUT TYPE="password" id = "j_password" NAME="j_password"></TD>
                        </div>
                    </div>

                    <div class = "col-sm-12 text-center">
                        <TH colspan="2" class = "text-center"><INPUT TYPE="SUBMIT" VALUE="Log In"></TH>
                    </div>
                </FORM>
                <br /> <a class = "col-sm-6 col-12 btn" href="/WorldOfFutureDarkness/createNewUser.jsp">Create an Account</a>
                <br /> <a class = "col-sm-6 col-12 btn" href="/WorldOfFutureDarkness/index.jsp">Return Home</a>
            </div>

            <div class = "card-footer">
                <%@ include file="foot.jsp"%>
            </div>
        </div>
    </div>
</body>
</html>
