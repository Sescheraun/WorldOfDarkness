<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 11/2/18
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%@ include file="../head.jsp"%>
<body>
<div id = "content">
    <script>backgroundShift();</script>
    <table>
    <c:forEach var = "critter"  items = "${critters}">
        <tr>
            <td>
                ${critter.critterName}
            </td>
            <td>
                ${critter.implemented}
            </td>
        </tr>
    </c:forEach>
    </table>
    <br />
    <a href="/WorldOfFutureDarkness">Link to the home page</a>

    <%@ include file="../foot.jsp"%>
</div>
</body>

</html>
