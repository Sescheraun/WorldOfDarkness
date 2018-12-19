<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../head.jsp"%>
<html>
<body>
    <div class="container">
        <div id = "content" class = "card content">
            <div class = "card-header text-center">
                Content Management
            </div>
            <div class = "card-body text-center">
                <a class = "btn" href="/WorldOfFutureDarkness/prepTraitForm">Add or Remove Traits</a>
                <br />
                <a class = "btn" href="/WorldOfFutureDarkness/prepSubCritterForm">Manage Sub Types</a>
                <br /><br />
                <a class = "btn" href="/WorldOfFutureDarkness">Link to the home page</a>
                <br />
            </div>
            
            <div class = "card-footer text-center">
                <%@ include file="../foot.jsp"%>
            </div>
        </div>
    </div>
</body>
</html>