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
                <label for = "allowed"> Base Creature
                    <select id = "allowed">
                        <c:forEach var = "critter"  items = "${critters}">
                            <option>${critter.critterName}</option>
                        </c:forEach>
                    </select>
                </label>
                <br />
                <label for = "subCritterName">Sub Type Name<input name = "subCritterName" id = "subCritterName" class = "input" type = "text" /></label>

                <label for = "category"> Sub Type Label
                    <input name="category" id = "category" class = "input" type = "text" />
                </label>

                <label for = "firstAdvantage"> Advantage One
                    <textarea  name="firstAdvantage" id = "firstAdvantage" class = "input" type = "textArea"></textarea>
                </label>

                <label for = "secondAdvantage"> Advantage Two
                    <textarea  name="secondAdvantage" id = "secondAdvantage" class = "input" type = "textArea"></textarea>
                </label>

                <label for = "flaw"> Flaw
                    <textarea name="flaw" id = "flaw" class = "input" type = "textArea"></textarea>
                </label>

            </form>
        </div>
        <%@ include file="../foot.jsp"%>
    </div>
</body>
</html>
