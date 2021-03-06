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
        <div class = "container-fluid">
            <%@ page session="true"%>

            <div id = "content" class = "col-md-6 col-12 card content" >

                <div class = "card-header text-center">
                    User '<%=request.getRemoteUser()%>':
                </div>

                <div class = "card-body text-center">
                    You are the weakest link, goodbye.
                    <br />
                    <br />
                    <%@ include file="homeButton.jsp"%>
                </div>

                <div class = "card-footer">
                    <%@ include file="foot.jsp"%>
                </div>
            </div>
        </div>
        <% session.invalidate(); %>
    </body>
</html>
