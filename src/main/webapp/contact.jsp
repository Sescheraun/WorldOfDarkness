
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp"%>

<html>
<head>
    <title>Contact</title>
</head>
<body>
<body>

<div class="container-fluid">
    <div id = "content" class = "card content">

        <div class = "card-header text-center">
            Send an email to the site operator.
        </div>

        <div class = "card-body text-center">

            <form action = "sendMail" method = "POST">

                <div class = "row">
                    <span class = "col-sm-3 text-right">
                        <label for = "senderName">
                            Your Name:
                        </label>
                    </span>

                    <input type = "text" id = "senderName" class = "form-control input col-sm-8" name = "senderName" />
                </div>

                <div class = "row">
                    <span class = "col-sm-3 text-right">
                        <label for = "email">
                            Your Email:
                        </label>
                    </span>

                    <input type = "text" id = "email" class = "form-control input col-sm-8" name = "email" />
                </div>

                <div class = "row">
                    <span class = "col-sm-3 text-right">
                        <label for = "subject">
                            Topic:
                        </label>
                    </span>

                    <input type = "text" id = "subject" class = "form-control input col-sm-8" name = "subject" />
                </div>

                <div class = "row">
                    <span class = "col-sm-3 text-right">
                        <label for = "messageBody">
                            Message:
                        </label>
                    </span>

                    <textarea rows="10" class = "form-control col-sm-8" id = "messageBody" name = "messageBody"></textarea>
                </div>

                <div class = "row">
                    <span class = "col-sm-3 text-center"></span><button type = "submit" class = "btn">Send Email</button>

                </div>
            </form>
            <%@ include file="homeButton.jsp"%>
        </div>

        <div class = "card-footer text-center">
            <%@ include file="foot.jsp"%>
        </div>
    </div>
    <script>center()</script>
</div>
</body>
</body>
</html>
