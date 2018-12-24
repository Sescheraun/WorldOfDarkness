<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%@ include file="../head.jsp"%>
<body>
<div id = "content">
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
    <%@ include file="../homeButton.jsp"%>

    <%@ include file="../foot.jsp"%>
</div>
</body>

</html>
