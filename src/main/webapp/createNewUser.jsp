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
    <div class="container">
        <div id = "content" class = "card content">
            <div class = "card-header text-center">
                Greetings, welcome to the World of Darkness.
            </div>
            <div class = "card-body text-center">

            <FORM ACTION="addUser"
                  METHOD="POST">
                <%--onsubmit="return validateForm()">--%>

                <TABLE class = "col-md-12">
                    <TR>
                        <TD class = "text-right">
                            First Name:
                        </TD>
                        <TD>
                            <INPUT TYPE="TEXT"
                                     id="firstName"
                                   NAME="firstName">
                        </TD>
                    </TR>

                    <TR>
                        <TD class = "text-right">
                            Last Name:
                        </TD>

                        <TD>
                            <INPUT TYPE="TEXT"
                                     id="lastName"
                                   NAME="lastName">
                        </TD>
                    </TR>

                    <TR>
                        <TD class = "text-right">
                            User Name:
                        </TD>

                        <TD>
                            <INPUT TYPE="TEXT"
                                     id="userName"
                                   NAME="userName">
                        </TD>
                    </TR>

                    <TR>
                        <TD class = "text-right">
                            Email Address:
                        </TD>

                        <TD>
                            <INPUT TYPE="TEXT"
                                     id="email"
                                   NAME="EMAIL">
                        </TD>
                    </TR>
                    <%--<TR><TD>Cell Phone (optional):</TD><TD><INPUT TYPE="TEXT" NAME="cell"></TD></TR>--%>

                    <TR>
                        <TD class = "text-right">
                            Password:
                        </TD>

                        <TD>
                            <INPUT TYPE="PASSWORD"
                                     id="password"
                                   NAME="password">
                        </TD>
                    </TR>

                    <TR>
                        <TD class = "text-right">
                            Verify Password:
                        </TD>

                        <TD>
                            <INPUT TYPE="PASSWORD"
                                     id="password2"
                                   NAME="password2">
                        </TD>
                    </TR>

                    <TR>
                        <th></th>
                        <TH class = "text-center">
                            <INPUT TYPE="SUBMIT"
                                  VALUE="Sign up" />
                        </TH>
                    </TR>
                </TABLE>
            </FORM>

            <div id = "errorDisplay" class = "col-med-6 float-right">

            </div>

            </div>

            <div class = "card-footer text-center">
                <%@ include file="foot.jsp"%>
            </div>
        </div>
    </div>
    </body>
</html>
