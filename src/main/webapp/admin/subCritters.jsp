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
<script src="/WorldOfFutureDarkness/scripts/subCritterCrud.js" type="application/javascript"></script>

<body>

    <div class="container">
        <div id = "content" class = "card content">
            <div class = "card-header text-center">
                Creating new Traits
            </div>
            <div class = "card-body text-center">

                <label for = "allowed"> Base Creature
                    <select id = "allowed">
                        <c:forEach var = "critter"  items = "${critters}">
                            <option id = "${critter.critterId}">${critter.critterName}</option>
                        </c:forEach>
                    </select>
                </label>
                <br />
                <ul class = "nav nav-pills nav-justified">
                    <li class = "nav-item" id = "create">
                        <a class="nav-link active" data-toggle="pill" href="#createTab">Create</a>
                    </li>
                    <li class = "nav-item" id = "update">
                        <a class="nav-link" data-toggle="pill" href="#updateTab">Update</a>
                    </li>
                    <li class = "nav-item" id = "read">
                        <a class="nav-link" data-toggle="pill" href="#readTab">Read</a>
                    </li>
                    <li class = "nav-item" id = "delete">
                        <a class="nav-link" data-toggle="pill" href="#deleteTab">Delete</a>
                    </li>
                </ul>

                <!-- *********************************************************************************************** -->
                <!-- **                                    Create Tab                                             ** -->
                <!-- *********************************************************************************************** -->


                <div class = "tab-content">
                    <div class = "tab-pane container active" id = "createTab">
                        <h4>Add new Sub Type</h4>
                        <div class = "row">
                            <label for = "subCritterNameNew" class = "col-sm-3 text-right">Sub Type Name</label>
                            <input name = "subCritterNameNew" maxlength="20" id = "subCritterNameNew" class = "col-sm-8 input" type = "text" />
                        </div>

                        <div class = "row">
                            <label for = "categoryNew" class = "col-sm-3 text-right"> Sub Type Label</label>
                            <input name="categoryNew" maxlength="20" id = "categoryNew" class = "col-sm-8 input" type = "text" />
                        </div>

                        <div class = "row">
                            <label for = "firstAdvantageNew" class = "col-sm-3 text-right"> Advantage One</label>
                            <textarea  name="firstAdvantageNew" id = "firstAdvantageNew" class = "col-sm-8 input" type = "textArea"></textarea>
                        </div>

                        <div class = "row">
                            <label for = "secondAdvantageNew" class = "col-sm-3 text-right"> Advantage Two</label>
                            <textarea  name="secondAdvantageNew" id = "secondAdvantageNew" class = "col-sm-8 input" type = "textArea"></textarea>
                        </div>

                        <div class = "row">
                            <label for = "flawNew" class = "col-sm-3 text-right"> Flaw</label>
                            <textarea name="flawNew" id = "flawNew" class = "col-sm-8 input" type = "textArea"></textarea>
                        </div>

                        <button class = "btn" id = "subCritterSubmit">Add Sub Type</button>
                    </div>

                    <!-- *********************************************************************************************** -->
                    <!-- **                                    Update Tab                                             ** -->
                    <!-- *********************************************************************************************** -->

                    <div class = "tab-pane container" id = "updateTab">
                        <h4>
                            Update Sub Type ID#
                            <span id = "updateSubtypeID"
                               class = "idDisplay">

                            </span>
                        </h4>

                        <div class = "row">
                            <label for = "subCritterNameUpdate" class = "col-sm-3 text-right">Sub Type Name</label>
                            <input name = "subCritterNameUpdate" maxlength="20" id = "subCritterNameUpdate" class = "subCritterNameDisplay col-sm-8 input" type = "text" />
                        </div>

                        <div class = "row">
                            <label for = "categoryUpdate" class = "col-sm-3 text-right"> Sub Type Label</label>
                            <input name="categoryUpdate" maxlength="20" id = "categoryUpdate" class = "categoryDisplay col-sm-8 input" type = "text" />
                        </div>

                        <div class = "row">
                            <label for = "firstAdvantageUpdate" class = "col-sm-3 text-right"> Advantage One</label>
                            <textarea  name="firstAdvantageUpdate" id = "firstAdvantageUpdate" class = "firstAdvantageDisplay col-sm-8 input" type = "textArea"></textarea>
                        </div>

                        <div class = "row">
                            <label for = "secondAdvantageUpdate" class = "col-sm-3 text-right"> Advantage Two</label>
                            <textarea  name="secondAdvantageUpdate" id = "secondAdvantageUpdate" class = "secondAdvantageDisplay col-sm-8 input" type = "textArea"></textarea>
                        </div>

                        <div class = "row">
                            <label for = "flawUpdate" class = "col-sm-3 text-right"> Flaw</label>
                            <textarea name="flawUpdate" id = "flawUpdate" class = "flawDisplay col-sm-8 input" type = "textArea"></textarea>
                        </div>

                        <div class = "row text-center">

                            <div class = "col-sm-4 float-left">

                                <button id = "updatePostLeft"
                                        class = "btn PostLeft">
                                    <<
                                </button>
                            </div>

                            <div class = "col-sm-4 text-center">

                                <button id = "subCritterUpdate"
                                        class = "btn">
                                    Update Post
                                </button>
                            </div>

                            <div class="col-sm-4 float-right">

                                <button id="updatePostRight"
                                        class="btn PostRight">
                                    >>
                                </button>
                            </div>
                        </div>
                    </div>

                    <!-- *********************************************************************************************** -->
                    <!-- **                                      Read Tab                                             ** -->
                    <!-- *********************************************************************************************** -->

                    <div class = "tab-pane container" id = "readTab">
                        <h4>
                            Read current sub types for this creature ID#
                            <span id = "readSubtypeID"
                               class = "idDisplay">

                            </span>
                        </h4>

                        <div class = "row">
                            <span class = "col-sm-3 text-right">Sub Type Name</span>
                            <div id = "subCritterNameRead" class = "subCritterNameDisplay col-sm-8"></div>
                        </div>

                        <div class = "row">
                            <span class = "col-sm-3 text-right"> Sub Type Label</span>
                            <div id = "categoryRead" class = "categoryDisplay col-sm-8"></div>
                        </div>

                        <div class = "row">
                            <span class = "col-sm-3 text-right"> Advantage One</span>
                            <div  id = "firstAdvantageRead" class = "firstAdvantageDisplay col-sm-8"></div>
                        </div>

                        <div class = "row">
                            <span class = "col-sm-3 text-right"> Advantage Two</span>
                            <div  id = "secondAdvantageRead" class = "secondAdvantageDisplay col-sm-8"></div>
                        </div>

                        <div class = "row">
                            <span class = "col-sm-3 text-right"> Flaw</span>
                            <div id = "flawRead" class = "flawDisplay col-sm-8"></div>
                        </div>

                        <div class = "row text-center">

                            <div class = "col-sm-6 float-left">

                                <button id = "readPostLeft"
                                        class = "btn PostLeft">
                                    <<
                                </button>
                            </div>

                            <div class = "col-sm-6 float-right">

                                <button id = "readPostRight"
                                        class = "btn PostRight">
                                    >>
                                </button>
                            </div>
                        </div>
                    </div>

                    <!-- *********************************************************************************************** -->
                    <!-- **                                    Delete Tab                                             ** -->
                    <!-- *********************************************************************************************** -->

                    <div class = "tab-pane container" id = "deleteTab">
                        <h4>
                            Remove this Sub Type ID#
                            <span id = "deleteSubtypeID"
                                  class = "idDisplay">

                            </span>
                        </h4>

                        <div class = "row">
                            <span class = "col-sm-3 text-right">Sub Type Name</span>
                            <div id = "subCritterNameDelete" class = "subCritterNameDisplay col-sm-8"></div>
                        </div>

                        <div class = "row">
                            <span class = "col-sm-3 text-right"> Sub Type Label</span>
                            <div id = "categoryDelete" class = "categoryDisplay col-sm-8"></div>
                        </div>

                        <div class = "row">
                            <span class = "col-sm-3 text-right"> Advantage One</span>
                            <div id = "firstAdvantageDelete" class = "firstAdvantageDisplay col-sm-8"></div>
                        </div>

                        <div class = "row">
                            <span class = "col-sm-3 text-right"> Advantage Two</span>
                            <div id = "secondAdvantageDelete" class = "secondAdvantageDisplay col-sm-8"></div>
                        </div>

                        <div class = "row">
                            <span class = "col-sm-3 text-right"> Flaw</span>
                            <div id = "flawNewDelete" class = "flawDisplay col-sm-8"></div>
                        </div>

                        <div class = "row text-center">
                            <div class = "col-sm-4 float-left">

                                <button id = "deletePostLeft" class = "btn PostLeft">
                                    <<
                                </button>
                            </div>

                            <div class = "col-sm-4 text-center">

                                <button id = "subCritterDelete" class = "btn">
                                    Delete
                                </button>
                            </div>

                            <div class = "col-sm-4 float-right">

                                <button id = "deletePostRight"
                                        class = "btn PostRight">
                                    >>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <%@ include file="../homeButton.jsp"%>
            </div>
            <div class = "card-footer text-center">
                <%@ include file="../foot.jsp"%>
            </div>
        </div>
    </div>
</body>
</html>
