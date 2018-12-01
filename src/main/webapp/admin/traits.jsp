<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 11/26/18
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../head.jsp"%>
<html>
<body>
<script>backgroundShift();</script>
<div class="container">
    <div id = "content" class = "card content">
        <div class = "card-header text-center">
            Creating new Traits
        </div>
        <div class = "card-body text-center">
            <form>
                <label for = "traitName">Trait Name<input name = "traitName" id = "traitName" class = "input" type = "text" /></label>
                <label for = "speciality"><input type = "checkbox" name = "speciality" id = "speciality"/>Speciality Allowed</label>
                <label for = "allowed"> Allowed for
                    <select id = "allowed">
                        <c:forEach var = "critter"  items = "${critters}">
                            <option>${critter.critterName}</option>
                        </c:forEach>
                    </select>
                </label>
                <label for = "goodAt">Good At<input name = "goodAt" id = "goodAt" class = "input" type = "text" /></label>


            </form>
        </div>
        <%@ include file="../foot.jsp"%>
</body>
</html>