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
                <div class = "row">
                    <label for = "subCritterName" class = "col-sm-3">Sub Type Name</label>
                    <input name = "subCritterName" id = "subCritterName" class = "input" type = "text" />
                </div>

                <div class = "row">
                <label for = "category" class = "col-sm-3"> Sub Type Label</label>
                    <input name="category" id = "category" class = "input" type = "text" />

                </div>
                    <div class = "row">
                <label for = "firstAdvantage" class = "col-sm-3"> Advantage One</label>
                    <textarea  name="firstAdvantage" id = "firstAdvantage" class = "input" type = "textArea"></textarea>
                    </div>
                        <div class = "row">
                <label for = "secondAdvantage" class = "col-sm-3"> Advantage Two</label>
                    <textarea  name="secondAdvantage" id = "secondAdvantage" class = "input" type = "textArea"></textarea>
                        </div>
                            <div class = "row">
                <label for = "flaw" class = "col-sm-3"> Flaw</label>
                    <textarea name="flaw" id = "flaw" class = "input" type = "textArea"></textarea>
                            </div>

                <button class = "btn" id = "subCritterSubmit">Add Sub Type</button>
            </form>
        </div>
        <%@ include file="../foot.jsp"%>
    </div>
</body>
</html>
