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
    <div class="container-fluid">
        <div id = "content" class = "card content">
            <div class = "card-header text-center">
                Greetings, welcome to the World of Darkness.
            </div>
            <div class = "card-body text-center">

                <FORM ACTION="addUser"
                      METHOD="POST">
                    <%--onsubmit="return validateForm()">--%>
                    <div class = "row" id="firstNameRow">

                        <div class = "col-12 col-sm-5 text-sm-right text-left">
                            <label for = "firstName">First Name:</label>
                        </div>

                        <div class = "col-12 col-sm-7 text-left">
                            <INPUT TYPE="TEXT"
                                   id="firstName"
                                   NAME="firstName">
                        </div>

                    </div>

                    <div class = "row" id = "lastNameRow">

                        <div class = "col-12 col-sm-5 text-sm-right text-left">
                            <label for = "lastName">Last Name:</label>
                        </div>

                        <div class = "col-12 col-sm-7 text-left">
                            <INPUT TYPE="TEXT"
                                   id="lastName"
                                   NAME="lastName">
                        </div>
                    </div>

                    <div class = "row" id = "userNameRow">

                        <div class = "col-12 col-sm-5 text-sm-right text-left">
                            <label for = "userName">User Name:</label>
                        </div>

                        <div class = "col-12 col-sm-7 text-left">
                            <INPUT TYPE="TEXT"
                                     id="userName"
                                   NAME="userName">
                        </div>
                    </div>

                    <div class = "row" id = "emailRow">

                        <div class = "col-12 col-sm-5 text-sm-right text-left">
                            <label for = "email">Email Address:</label>
                        </div>

                        <div class = "col-12 col-sm-7 text-left">
                            <INPUT TYPE="TEXT"
                                   id="email"
                                   NAME="EMAIL">
                        </div>
                    </div>

                    <div class = "row" id = "passwordRow">

                        <div class = "col-12 col-sm-5 text-sm-right text-left">
                            <label for="password">Password: </label>
                        </div>

                        <div class = "col-12 col-sm-7 text-left">
                            <INPUT TYPE="PASSWORD"
                                   id="password"
                                   NAME="password">
                        </div>
                    </div>

                    <div class = "row" id = "confirmPasswordRow">

                        <div class = "col-12 col-sm-5 text-sm-right text-left">
                            <label for = "password2">Verify Password:</label>
                        </div>

                        <div class = "col-12 col-sm-7 text-left">
                            <INPUT TYPE="PASSWORD"
                                   id="password2"
                                   NAME="password2">
                        </div>
                    </div>

                    <div class = "col-sm-12 text-center">
                        <INPUT TYPE="SUBMIT"
                               VALUE="Sign up" />
                    </div>

                </FORM>
                <%@ include file="homeButton.jsp"%>
            git add </div>

            <div class = "card-footer text-center">
                <%@ include file="foot.jsp"%>
            </div>
        </div>
    </div>
    </body>
</html>
